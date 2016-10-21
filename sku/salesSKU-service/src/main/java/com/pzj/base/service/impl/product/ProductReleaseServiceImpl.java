package com.pzj.base.service.impl.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pzj.common.QueryPageList;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.product.GlobalPorduct.TicketRuleType;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRebateRule;
import com.pzj.base.entity.product.ProductRelation;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductRondaRelation;
import com.pzj.base.entity.product.ProductRuleRel;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.entity.product.TicketRule;
import com.pzj.base.entity.product.pms.ProductBed;
import com.pzj.base.entity.product.pms.ProductPenalty;
import com.pzj.base.entity.product.pms.ProductPriceRule;
import com.pzj.base.entity.product.pms.ProductReleaseUtil;
import com.pzj.base.entity.query.ProductUser;
import com.pzj.base.product.IProductReleaseMapper;
import com.pzj.base.service.exception.SkuParamNullException;
import com.pzj.base.service.product.IProductBedService;
import com.pzj.base.service.product.IProductCombineRelationService;
import com.pzj.base.service.product.IProductInfoService;
import com.pzj.base.service.product.IProductPenaltyService;
import com.pzj.base.service.product.IProductPriceRuleService;
import com.pzj.base.service.product.IProductRelationService;
import com.pzj.base.service.product.IProductReleaseService;
import com.pzj.base.service.product.IProductRondaRelationService;
import com.pzj.base.service.product.IProductRuleRelService;
import com.pzj.base.service.product.IProductStockRelationService;
import com.pzj.base.service.product.ITicketRuleService;
import com.pzj.common.QueryPageModel;
import com.pzj.util.productConvertUtil.ProductCheckUtil;

/**
 * 产品发布关系服务接口
 * 
 * @author apple
 * 
 */
@Service
@Lazy
public class ProductReleaseServiceImpl extends
                                       BaseServiceImpl<ProductRelease, IProductReleaseMapper>
                                       implements IProductReleaseService {

    @Autowired
    IProductInfoService            productInfoService;

    @Autowired
    IProductRelationService        productRelationService;

    @Autowired
    IProductCombineRelationService productCombineRelationService;

    @Autowired
    IProductBedService             productBedService;

    @Autowired
    IProductPriceRuleService       productPriceRuleService;

    @Autowired
    IProductPenaltyService         productPenaltyService;

    @Autowired
    ITicketRuleService             ticketRuleService;

    @Autowired
    IProductRuleRelService         productRuleRelService;
    
    @Autowired
    IProductRondaRelationService   productRondaRelationService;
    
    @Autowired
    IProductStockRelationService   productStockRelationService;
    

    ProductReleaseUtil             productReleaseUtil = ProductReleaseUtil.getInstance();
    /**
     * 日志对象
     */
    protected Logger               logger             = LoggerFactory
        .getLogger(ProductReleaseServiceImpl.class);

    @Override
    public void updateReleaseAndInfo(ProductRelease release, ProductInfo productInfo) {
        if (null == release || release.getId() == null)
            return;

        super.updateByPrimaryKey(release);

        if (productInfo != null) {
            ProductRelease release1 = this.mapper.selectByPrimaryKey(release.getId());
            if (release != null && release1.getProductId() != null) {
                productInfo.setId(release1.getProductId());
                this.productInfoService.updateByPrimaryKey(productInfo);
            }
        }
        // 改为一对多关联，2016-02-14，by lizheng
        // if (productInfo != null) {
        // productCombineRelationService.deleteByProductId(release.getId());
        //
        // }
    }

    @Override
    @SuppressWarnings("finally")
    public Long adjustPrice(Long productId, Double newPrice, Double retailPrice, Double mfPrice) {
        ProductRelease release = super.getById(productId);
        ProductRelease pr = new ProductRelease();
        Long reval = 0L;
        try {
            BeanUtils.copyProperties(pr, release);
            pr.setProductPrice(newPrice);
            pr.setMfPrice(mfPrice);
            pr.setRetailPrice(retailPrice);
            pr.setFlag("1");
            reval = super.insert(pr);

            ProductRelease par = new ProductRelease();
            par.setProductId(release.getProductId());
            par.setProductType(release.getProductType());
            List<ProductRelease> releaseList = super.findListByParams(par);
            if (releaseList != null && !releaseList.isEmpty()) {
                for (ProductRelease re : releaseList) {
                    if (!reval.equals(re.getId()))
                        re.setFlag(GlobalParam.FLAG.off().toString());
                }
            }
            super.updateBatchByPrimaryKey(releaseList);

            ProductRelation relEntity = new ProductRelation(); // 景区
            ProductRelation relSpotEntity = new ProductRelation();// 景点关系
            ProductRelation supplierEntity = new ProductRelation(); // 供应商

            relEntity.setObjId(productId);
            relEntity.setObjType(GlobalParam.PRORELEASETABEL);
            relEntity.setRelType(GlobalParam.SCENIC);

            relSpotEntity.setObjId(productId);
            relSpotEntity.setObjType(GlobalParam.PRORELEASETABEL);
            relSpotEntity.setRelType(GlobalParam.SCENICSPOT);

            supplierEntity.setObjId(productId);
            supplierEntity.setObjType(GlobalParam.PRORELEASETABEL);
            supplierEntity.setRelType(GlobalParam.SUPPLIER);

            // 查询产品景区关系集合
            List<ProductRelation> relScenicList = this.productRelationService
                .findListByParams(relEntity);
            List<ProductRelation> relScenicSpotList = this.productRelationService
                .findListByParams(relSpotEntity);
            List<ProductRelation> relSupplierList = this.productRelationService
                .findListByParams(supplierEntity);

            if (relScenicList != null && relScenicSpotList != null) {
                // 景区关系
                for (ProductRelation rel : relScenicList) {
                    rel.setId(null);
                    rel.setObjId(reval);
                }
                this.productRelationService.insertBatch(relScenicList);
                // 景点关系
                for (ProductRelation relspot : relScenicSpotList) {
                    relspot.setId(null);
                    relspot.setObjId(reval);
                }
                this.productRelationService.insertBatch(relScenicSpotList);
                // 景点关系
                for (ProductRelation relsupplier : relSupplierList) {
                    relsupplier.setId(null);
                    relsupplier.setObjId(reval);
                }
                this.productRelationService.insertBatch(relSupplierList);
            }

        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }
        return reval; // 返回产品id集合
    }

    @Override
    public List<ProductRelease> queryByUserRelation(Map<String, Object> params) {
        return this.mapper.queryByUserRelation(params);
    }

    @Override
    public List<ProductRelease> queryFrontProductOfRebate(ProductRebateRule rebateRule) {
        return this.mapper.selectFrontProductOfRebate(rebateRule);
    }

    @Override
    public PageList<ProductRelease> queryPageByUserRelation(PageModel pager,
                                                            ProductRelease release) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", release);

        List<ProductRelease> listBean = this.mapper.queryByUserRelation(params);
        Integer count = this.mapper.countByUserRelation(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<ProductRelease> pagelist = new PageList<ProductRelease>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public PageList<ProductRelease> queryRelateList(PageModel pager, ProductRelease param) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", param);

        List<ProductRelease> listBean = this.mapper.queryRelateProductList(params);
        Integer count = this.mapper.countRelateProductList(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<ProductRelease> pagelist = new PageList<ProductRelease>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public PageList<ProductRelease> queryProductWithChannelMF(List<Long> channelIds,
                                                              PageModel pager, ProductRelease param,
                                                              SysChannelStrategy strategy) {
        Map<String, Object> params = new HashMap<>();
        params.put("channelIds", channelIds);
        params.put("strategy", strategy);
        params.put("pParam", pager);
        params.put("bParam", param);

        List<ProductRelease> listBean = this.mapper.selectProductIdWithChannelMF(params);
        Integer count = this.mapper.countProductIdWithChannelMF(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<ProductRelease> pagelist = new PageList<ProductRelease>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public List<ProductRelease> findProductByIntegralId(Long integralId) {
        return this.mapper.findProductByIntegralId(integralId);
    }

    @Override
    public PageList<ProductRelease> findReleaseAndInfoByParams(ProductRelease param,
                                                               PageModel page) {
        List<ProductRelease> listBean = null;
        Map<String, Object> paramMap = new HashMap<>(1);
        paramMap.put("bParam", param);

        int count = this.mapper.countByParamMap(paramMap);
        if (count > 0) {
            listBean = this.mapper.selectReleaseAndInfoByParams(param, page);
        }
        PageList<ProductRelease> pagelist = new PageList<>(listBean, page, count);
        return pagelist;
    }

    @Override
    public List<ProductRelease> findReleaseAndInfoByParams(ProductRelease param) {
        List<ProductRelease> listBean = this.mapper.selectReleaseAndInfoByParams(param, null);
        return listBean;
    }

    @Override
    public PageList<ProductRelease> queryComposeAndGeneralProduct(ProductRelease param,
                                                                  PageModel page) {
        List<ProductRelease> listBean = null;

        int count = this.mapper.countComposeAndGeneralProduct(param);
        if (count > 0) {
            listBean = this.mapper.selectComposeAndGeneralProduct(param, page);
        }
        PageList<ProductRelease> pagelist = new PageList<>(listBean, page, count);
        return pagelist;
    }

    @Override
    public PageList<ProductRelease> queryProductByScenic(ProductRelease param, ProductScenic scenic,
                                                         PageModel page) {
        List<ProductRelease> listBean = null;

        int count = this.mapper.countProductByScenic(param, scenic);
        if (count > 0) {
            listBean = this.mapper.selectProductByScenic(param, scenic, page);
        }
        PageList<ProductRelease> pagelist = new PageList<>(listBean, page, count);
        return pagelist;
    }

    @Override
    public Long insertOrUpdateBatchAndAuthForPMS(List<ProductRelease> prList) {
        Long num = 0l;
        try {
            if (prList == null) {
                this.logger
                    .error("方法[ProductReleaseService.insertBatchProductForPMS],参数prList不可以为空");
                return num;
            }
            // 新建或更新产品信息
            num += this.insertOrUpdateBatch(prList);

            // 新建或更新房型房间
            num += this.saveBatchProductAndBed(prList, false);

            // 新建或更新房型价格
            num += this.saveBatchProductAndPrice(prList, false);

            // 新建或更新房型违约金
            num += this.saveBatchProductPenalty(prList, false);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;
    }

    @Override
    public List<ProductRelease> insertOrUpdateBatchAndAuthHaveID(List<ProductRelease> prList) {
        Long num = 0l;
        try {
            if (prList == null) {
                this.logger
                    .error("方法[ProductReleaseService.insertBatchProductForPMS],参数prList不可以为空");
                return null;
            }
            // 新建或更新产品信息
            num += this.insertOrUpdateBatch(prList);

            // 新建或更新房型房间
            num += this.saveBatchProductAndBed(prList, false);

            // 新建或更新房型价格
            num += this.saveBatchProductAndPrice(prList, false);

            // 新建或更新房型违约金
            num += this.saveBatchProductPenalty(prList, false);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return prList;
    }

    public Long saveBatchProductAndBed(List<ProductRelease> prList, boolean isNeedSaveProduct) {
        Long num = 0l;
        try {
            if (prList == null) {
                this.logger.error("方法[ProductReleaseService.saveBatchProductAndBed],参数prList不可以为空");
                return num;
            }

            // 新建或更新产品信息
            if (isNeedSaveProduct) {
                num += this.insertOrUpdateBatch(prList);
            }
            // key:房型 value ：房间集合
            Map<Long, List<ProductBed>> entityMap = this.productReleaseUtil
                .getProductBedMap(prList);

            num += this.productBedService.updateParentRelationBatch(entityMap, false);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;

    }

    public Long saveBatchProductAndPrice(List<ProductRelease> prList, boolean isNeedSaveProduct) {
        Long num = 0l;
        try {
            if (prList == null) {
                this.logger
                    .error("方法[ProductReleaseService.saveBatchProductAndPrice],参数prList不可以为空");
                return num;
            }

            // 新建或更新产品信息
            if (isNeedSaveProduct) {
                num += this.insertOrUpdateBatch(prList);
            }
            // key:房型 value ：房间集合
            Map<Long, List<ProductPriceRule>> entityMap = this.productReleaseUtil
                .getProductPriceRuleMap(prList);

            num += this.productPriceRuleService.updateParentRelationBatch(entityMap, false);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;

    }

    public Long saveBatchProductPenalty(List<ProductRelease> prList, boolean isNeedSaveProduct) {
        Long num = 0l;
        try {
            if (prList == null) {
                this.logger
                    .error("方法[ProductReleaseService.saveBatchProductPenalty],参数prList不可以为空");
                return num;
            }

            // 新建或更新产品信息
            if (isNeedSaveProduct) {
                num += this.insertOrUpdateBatch(prList);
            }
            // key:房型 value ：房间集合
            Map<Long, List<ProductPenalty>> entityMap = this.productReleaseUtil
                .getProductPenaltyMap(prList);

            num += this.productPenaltyService.updateParentRelationBatch(entityMap, false);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            this.logger.error(e.getMessage(), e);
            throw e;
        }
        return num;

    }

    @Override
    public PageList<ProductRelease> queryByAllParamForPMS(PageModel pager, ProductRelease vo) {

        List<ProductRelease> listBean = this.mapper.selectListByAllParam(vo, pager);
        Integer count = this.mapper.countByAllParam(vo);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<ProductRelease> pagelist = new PageList<ProductRelease>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public PageList<ProductRelease> queryDisableExpiredProducts(ProductRelease release, Date date,
                                                                PageModel pager) {
        List<ProductRelease> releaseList = this.mapper.selectDisableExpiredProducts(release, date,
            pager);
        PageList<ProductRelease> result = new PageList<ProductRelease>(releaseList, pager, 0);
        return result;
    }

    @Override
    public Integer enableProducts(List<Long> ids, String newflag, String otherFlag) {
        if (null == ids || ids.isEmpty())
            return null;
        ProductRelease params = new ProductRelease();
        params.setIds(ids);
        List<ProductRelease> listByParams = this.findListByParams(params);

        if (null == listByParams || listByParams.isEmpty())
            return null;

        List<ProductRelease> releaseList = new ArrayList<>();
        for (ProductRelease release : listByParams) {
            ProductRelease pr = new ProductRelease();
            pr.setProductId(release.getProductId());
            pr.setProductType(release.getProductType());
            releaseList.add(pr);
        }
        releaseList = this.mapper.selectDisableAllProducts(releaseList);

        if (null == releaseList || releaseList.isEmpty())
            return null;

        List<ProductRelease> updateList = new ArrayList<>();
        for (ProductRelease release : releaseList) {
            ProductRelease pr = new ProductRelease();
            pr.setId(release.getId());
            String flag = otherFlag;
            for (Long id : ids) {
                if (id.equals(release.getId()))
                    flag = newflag;
            }
            pr.setFlag(flag);
            updateList.add(pr);
        }

        Integer integer = this.mapper.updateBatchByPrimaryKey(updateList);
        return integer;
    }

    @Override
    public PageList<ProductUser> findProductWithCustomerForPmsManager(ProductRelease release,
                                                                      PageModel page) {
        List<ProductUser> listBean = null;

        int count = this.mapper.countPorductWithCustomerForPmsManager(release);
        if (count > 0) {
            listBean = this.mapper.selectPorductWithCustomerForPmsManager(release, page);
        }
        PageList<ProductUser> pagelist = new PageList<>(listBean, page, count);
        return pagelist;
    }

    @Override
    public PageList<ProductUser> findProductWithCustomerForPmsCheck(ProductRelease release,
                                                                    PageModel page) {
        List<ProductUser> listBean = null;

        int count = this.mapper.countPorductWithCustomerForPmsCheck(release);
        if (count > 0) {
            listBean = this.mapper.selectPorductWithCustomerForPmsCheck(release, page);
        }
        PageList<ProductUser> pagelist = new PageList<>(listBean, page, count);
        return pagelist;
    }

    @Override
    public PageList<ProductRelease> queryPage(ProductRelease release, PageModel page) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("page", page);
        params.put("bParam", release);
        Integer count = this.mapper.countPage(release);
        if (count == 0)
            return null;
        List<ProductRelease> listBean = this.mapper.selectPage(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), page);
        PageList<ProductRelease> pagelist = new PageList<ProductRelease>(listBean, pageObj);
        return pagelist;
    }

    /**
     * 判断产品是否可退
     * 
     * @param productIds
     * @param playDate
     * @param refundDate
     * @param mustRufundAllFlag
     *            如果为true，则判断产品列表中有一个不能退，则productIds中的所有都不能退。如果为false，
     *            则只根据退款规则判断每个产品是否可退
     * @return
     */
    @Override
    public Map<Long, Boolean> isCanRefund(List<Long> productIds, Date playDate, Date playEndDate,
                                          Date refundDate, boolean mustRufundAllFlag) {
        Boolean mustRufundResult = true;
        Map<Long, Boolean> allFalseReuslt = new HashMap<Long, Boolean>();
        Map<Long, Boolean> resultMap = new HashMap<Long, Boolean>();
        if (productIds == null || productIds.isEmpty()) {
            logger.error("方法【IproductRelease.isCanRefund】的productIds参数不能为空");
            return null;
        }

        for (Long productId : productIds) {
            allFalseReuslt.put(productId, false);
        }

        if (refundDate == null) {
            logger.error("方法【IproductRelease.orderDate】的refundDate参数不能为空");
            return allFalseReuslt;
        }

        Map<String, Set<TicketRule>> proRuleMap = getTicketRuleMapByPIDList(productIds);
        if (proRuleMap != null && !proRuleMap.isEmpty()) {

            for (Long productId : productIds) {
                String productId_ = String.valueOf(productId);
                boolean result = isCanRefund(proRuleMap.get(productId_), playDate, playEndDate,
                    refundDate);
                if (!result) {
                    mustRufundResult = result;
                }
                resultMap.put(productId, result);
            }

        }
        if (mustRufundAllFlag && !mustRufundResult) {
            return allFalseReuslt;
        }

        return resultMap;
    }

    public boolean isCanRefund(Set<TicketRule> ruleList, Date playDate, Date playEndDate,
                               Date refundDate) {
        if (ruleList == null || ruleList.isEmpty()) {
            return true;
        }

        boolean result = true;
        for (TicketRule rule : ruleList) {
            boolean unitResult = false;
            double day = rule.getDays();
            double hour = rule.getHours();
            double minutes = rule.getMinutes();
            Calendar refundDateBefore = Calendar.getInstance();
            refundDateBefore.setTime(refundDate);
            refundDateBefore.add(Calendar.DATE, -new BigDecimal(day).intValue());
            refundDateBefore.add(Calendar.HOUR, -new BigDecimal(hour).intValue());
            refundDateBefore.add(Calendar.MINUTE, -new BigDecimal(minutes).intValue());

            Calendar refundDateAfter = Calendar.getInstance();
            refundDateAfter.setTime(refundDate);
            refundDateBefore.add(Calendar.DATE, new BigDecimal(day).intValue());
            refundDateBefore.add(Calendar.HOUR, new BigDecimal(hour).intValue());
            refundDateBefore.add(Calendar.MINUTE, new BigDecimal(minutes).intValue());

            Integer timeType = rule.getTimeType();
            if (timeType.intValue() == TicketRuleType.NO_RULE.intValue()) {
                unitResult = true;
            } else if (playDate != null) {
                if (timeType.intValue() == TicketRuleType.DATE_CURRENT.intValue()
                    || timeType.intValue() == TicketRuleType.DATE_BEFORE.intValue()
                    || timeType.intValue() == TicketRuleType.PLAY_BEFORE.intValue()) {
                    if (refundDateAfter.getTime().before(playDate)) {
                        unitResult = true;
                    }
                } else if (timeType.intValue() == TicketRuleType.DATE_AFTER.intValue()) {
                    if (refundDateBefore.getTime().after(playDate)) {
                        unitResult = true;
                    }
                }
            } else if (playEndDate != null) {
                if (timeType.intValue() == TicketRuleType.STOP_BEFOR.intValue()) {
                    if (refundDateAfter.getTime().before(playEndDate)) {
                        unitResult = true;
                    }
                }
            }
            if (!unitResult) {
                result = false;
                break;
            }

        }
        return result;
    }

    /**
     * 根据产品id集合获取产品对应的规则集合
     * 
     * @param productIds
     *            产品主键集合
     * @return key = 产品主键 , value = 产品对应的退款规则集合
     */
    public Map<String, Set<TicketRule>> getTicketRuleMapByPIDList(List<Long> productIds) {
        ProductRuleRel relparam = new ProductRuleRel();
        relparam.setpIds(productIds);
        List<ProductRuleRel> list = productRuleRelService.findListByParams(relparam);
        Map<String, Set<TicketRule>> proRuleMap = null;

        if (list == null || list.isEmpty()) {
            return proRuleMap;
        }

        List<Long> ruleIds = productRuleRelService.getRuleIdList(list);
        TicketRule param = new TicketRule();
        param.setRuleIds(ruleIds);
        param.setStatus(GlobalParam.FLAG.start());
        List<TicketRule> ruleList = ticketRuleService.findListByParams(param);
        proRuleMap = setTicketRuleForProduct(ruleList, list);

        return proRuleMap;

    }

    public Map<String, Set<TicketRule>> setTicketRuleForProduct(List<TicketRule> ruleList,
                                                                List<ProductRuleRel> relList) {
        if (ruleList == null || ruleList.isEmpty()) {
            return null;
        }
        if (relList == null || relList == null) {
            return null;
        }

        Map<String, TicketRule> ruleMap = ticketRuleService.listTMap(ruleList, null);
        Map<String, Set<TicketRule>> returnMap = new HashMap<String, Set<TicketRule>>();
        for (ProductRuleRel rel : relList) {
            Long pid = rel.getP_id();
            String pid_ = String.valueOf(pid);
            Long ruldId = rel.getR_id();
            String ruleId_ = String.valueOf(ruldId);
            TicketRule rule = ruleMap.get(ruleId_);
            if (rule == null) {
                continue;
            }
            Set<TicketRule> set = returnMap.get(pid_);
            if (set == null) {
                set = new HashSet<TicketRule>();
                returnMap.put(pid_, set);
            }
            set.add(rule);
        }

        return returnMap;

    }

    @Override
    public Integer countReleaseAndInfoByInfoParams(ProductRelease releaseParam,
                                                   ProductInfo productInfoParam) {
        return mapper.countReleaseAndInfoByInfoParams(releaseParam, productInfoParam);
    }

    @Override
    public List<ProductRelease> findReleaseAndInfoByInfoParams(ProductRelease releaseParam,
                                                               ProductInfo productInfoParam) {

        return mapper.selectReleaseAndInfoByInfoParams(releaseParam, productInfoParam, null);
    }

    @Override
    public QueryPageList<ProductRelease> findReleaseAndInfoByInfoParams(ProductRelease releaseParam,
                                                                        ProductInfo productInfoParam,
                                                                        QueryPageModel queryPageModel) {

        int count = mapper.countReleaseAndInfoByInfoParams(releaseParam, productInfoParam);

        List<ProductRelease> productReleaseList = null;
        if (count > 0) {
            productReleaseList = mapper.selectReleaseAndInfoByInfoParams(releaseParam, productInfoParam, queryPageModel);
        }

        QueryPageList<ProductRelease> queryPageList = new QueryPageList<>(productReleaseList, queryPageModel, count);
        return queryPageList;
    }

    public Integer updateBatchByInfoId(List<ProductRelease> entityList) {
        logger.info("方法[updateBatchByInfoId]，入参entityList:{}", entityList);
        if (CollectionUtils.isEmpty(entityList)) {
            return 0;
        }
        Iterator<ProductRelease> it = entityList.iterator();
        while (it.hasNext()) {
            ProductRelease bean = it.next();
            if (bean.getProductId() == null) {
                it.remove();
            }
        }
        logger.info("方法[updateBatchByInfoId]，过滤后更新实体:{}", entityList);
        return mapper.updateBatchByInfoId(entityList);
    }
    
    public Long addProduct(List<ProductRelease> prList,
    		Map<ProductRelease, List<ProductRondaRelation>> rondaRelation, List<Long> scenicIds,
			List<Long> siteList) {
    	if(CollectionUtils.isEmpty(prList)){
			throw new SkuParamNullException("批量新建产品信息，传入的产品集合为空");
		}
    	//1.产品数据验证
    	ProductCheckUtil.checkAddData(prList);
    	
    	//2.新建产品
	    Long result = insertBatch(prList);
	    
	    //3.新建产品库存关系
	    productStockRelationService.addSkuAndStockRelation(prList);
	    
	    //4.更新产品关系
	    saveProductAuth(prList,rondaRelation,scenicIds,siteList);
		return result;
	}

    @Override
	public Long addProduct(ProductRelease pr,
			List<ProductRondaRelation> rondaRelation, List<Long> scenicIds,
			List<Long> siteList) {
    	if(pr == null){
			throw new SkuParamNullException("批量新建产品信息，传入的产品集合为空");
		}
    	
    	//1.产品数据验证
    	ProductCheckUtil.checkAddData(pr);
    	
    	//2.新建产品
	    Long result = insert(pr);
	    
	    //3.新建产品库存关系
	    productStockRelationService.addSkuAndStockRelation(pr);

	    //4.更新产品关系
	    saveProductAuth(pr,rondaRelation,scenicIds,siteList);
		return result;
	}
    
    
    public Integer saveProduct(List<ProductRelease> prList,
    		Map<ProductRelease, List<ProductRondaRelation>> rondaRelation, List<Long> scenicIds,
			List<Long> siteList) {
    	if(CollectionUtils.isEmpty(prList)){
			throw new SkuParamNullException("批量更新产品信息，传入的产品集合为空");
		}
    	//1.新建产品
    	Integer result = updateBatchByPrimaryKey(prList);
	    
	    //2.更新产品关系
	    saveProductAuth(prList,rondaRelation,scenicIds,siteList);
		return result;
	}

    @Override
	public Integer saveProduct(ProductRelease pr,
			List<ProductRondaRelation> rondaRelation, List<Long> scenicIds,
			List<Long> siteList) {
    	if(pr == null){
			throw new SkuParamNullException("更新产品信息，传入的产品实体为空");
		}
    	
    	if(pr.getId() == null){
			throw new SkuParamNullException("更新产品信息，传入的产品id为空");
		}
	    Integer result = updateByPrimaryKey(pr);
	    saveProductAuth(pr,rondaRelation,scenicIds,siteList);
		return result;
	}
   
    private Integer saveProductAuth(List<ProductRelease> prList, Map<ProductRelease, List<ProductRondaRelation>> rondaRelation,List<Long> scenicIds,List<Long> siteList){
    	Integer result = 0;

    	//1.更新产品与场次区域的关系
    	if(rondaRelation != null){
    		productRondaRelationService.saveSkuAndRondaRelation(rondaRelation);
    	}
    	//2.更新产品与景区的关系
    	if(scenicIds != null){
    		productRelationService.saveSkuAndScenicRelation(null, prList, scenicIds);
    	}
    	
    	//3.更新产品与景点的关系
    	if (siteList != null) {
            productRelationService.saveSkuAndSiteDateRelation(null, prList, siteList);
        }
    	
    	return result;
    }
    
    
    private Integer saveProductAuth(ProductRelease pr, List<ProductRondaRelation> rondaList,List<Long> scenicIds,List<Long> siteList){
    	 if (pr == null) {
             logger.info("更新产品与景区关系接口[saveProductAuth],没有传入产品参数");
             return 0;
         }
    	 List<ProductRelease> prList = new ArrayList<ProductRelease>();
    	 prList.add(pr);
    	 Map<ProductRelease, List<ProductRondaRelation>> rondaRelation = null;
    	 if(rondaRelation != null){
    		 rondaRelation = new HashMap<ProductRelease, List<ProductRondaRelation>>();
    		 rondaRelation.put(pr, rondaList);
    	 }

    	return saveProductAuth(prList,rondaRelation,scenicIds,siteList);
    }
    
    @Override
    public Integer modifyProductReleaseState(String flag, List<Long> ids) {
        logger.info("产品组更新接口[modifyProductReleaseState],传入参数：flag={},ids={}", flag, ids);
        if (StringUtils.isBlank(flag) || CollectionUtils.isEmpty(ids)) {
            return null;
        }

        List<ProductRelease> updateBean = new ArrayList<ProductRelease>();
        for (Long id : ids) {
            ProductRelease info = new ProductRelease();
            info.setProductId(id);
            info.setFlag(flag);
            updateBean.add(info);
        }
        return updateBatchByInfoId(updateBean);
    }
    
    public Integer modifyPReleaseStateById(String flag, Long id) {
		if(flag == null){
			throw new SkuParamNullException("更新产品状态接口[modifyPReleaseStateById]：没有传入状态参数{flag}");
		}
		if(id == null){
			throw new SkuParamNullException("更新产品状态接口[modifyPReleaseStateById]：没有传入产品参数{id}");
		}
		 logger.info("产品更新状态接口[modifyPReleaseStateById],传入参数：flag={},id={}", flag, id);
		
	    List<Long> ids = new ArrayList<Long>();
	    ids.add(id);
        
		return modifyPReleaseStateById(flag,ids);
	}

	@Override
	public Integer modifyPReleaseStateById(String flag, List<Long> ids) {
		if(flag == null){
			throw new SkuParamNullException("更新产品状态接口[modifyPReleaseStateById]：没有传入状态参数{flag}");
		}
		if(CollectionUtils.isEmpty(ids)){
			throw new SkuParamNullException("更新产品状态接口[modifyPReleaseStateById]：没有传入产品参数{ids}");
		}
		 logger.info("产品更新状态接口[modifyPReleaseStateById],传入参数：flag={},ids={}", flag, ids);
		
	    List<ProductRelease> updateBean = new ArrayList<ProductRelease>();
        for (Long id : ids) {
            ProductRelease pr = new ProductRelease();
            pr.setId(id);
            pr.setFlag(flag);
            updateBean.add(pr);
        }
		return updateBatchByPrimaryKey(updateBean);
	}

	
}
