package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalDict.SiteType;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.GlobalParam.FLAG;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductRelation;
import com.pzj.base.entity.product.ProductSiteData;
import com.pzj.base.entity.product.ProductSiteRelation;
import com.pzj.base.product.IProductSiteDataMapper;
import com.pzj.base.service.product.IProductRelationService;
import com.pzj.base.service.product.IProductSiteDataService;

@Service
@Lazy
public class ProductSiteDataServiceImpl extends
                                        BaseServiceImpl<ProductSiteData, IProductSiteDataMapper>
                                        implements IProductSiteDataService {

    @Autowired
    private IProductRelationService productRelationService;

    /**
     * 日志对象
     */
    protected Logger                logger = LoggerFactory
        .getLogger(ProductSiteDataServiceImpl.class);

    @Override
    public Long insert(ProductSiteData site, List<ProductRelation> relList) {
        super.insert(site);
        Long id = site.getId();
        if (relList != null && !relList.isEmpty()) {
            // 新增设备和站点的关系时,设置insert后的设备id
            for (ProductRelation rel : relList) {
                if (rel == null) {
                    continue;
                }
                if (site.getDataType().equals(SiteType.device())) {// 新增设备
                    rel.setRelId(id);
                } else {
                    rel.setObjId(id);
                }
            }
            productRelationService.insertBatch(relList);
        }
        return id;
    }

    @Override
    public int update(ProductSiteData site, List<ProductRelation> relList) {
        int r = super.updateByPrimaryKey(site);
        if (relList != null && !relList.isEmpty()) {
            // 先删除之前的关系，再执行insert

            ProductRelation param = new ProductRelation();
            param.setRelId(site.getId());
            param.setRelType(GlobalParam.PRODUCT_SITE_DATA);

            productRelationService.deleteByParam(param);

            productRelationService.insertBatch(relList);
        }
        return r;
    }

    @Override
    public List<ProductSiteData> findByIdsMap(Map<String, List<Long>> idsMap) {
        return mapper.findByIdsMap(idsMap);
    }

    @Override
    public List<ProductSiteData> findByParentIdsMap(Map<String, List<Long>> idsMap) {
        return mapper.findByParentIdsMap(idsMap);
    }

    @Override
    public List<ProductSiteData> findByScenicIdsMap(Map<String, List<Long>> idsMap) {
        return mapper.findByScenicIdsMap(idsMap);
    }

    @Override
    public Long insert(ProductSiteData site, List<ProductRelation> relList,
                       List<ProductSiteData> siteList) {
        super.insert(site);
        Long id = site.getId();
        if (relList != null && !relList.isEmpty()) {
            for (ProductRelation rel : relList) {
                if (rel == null) {
                    continue;
                }
                if (site.getDataType().equals(SiteType.device())) {// 新增设备
                    rel.setRelId(id);
                } else {
                    rel.setObjId(id);
                }
            }
            productRelationService.insertBatch(relList);
        }
        if (siteList != null && !siteList.isEmpty()) {// 关联的检票设备
            for (ProductSiteData siteEntity : siteList) {
                siteEntity.setParentId(id);
            }
            // mapper.updateBatchByPrimaryKey(siteList);//和现有的检票设备绑定
            mapper.insertBatch(siteList);// 批量新增检票设备
        }
        return id;
    }

    @Override
    public int update(ProductSiteData site, List<ProductRelation> relList,
                      List<ProductSiteData> siteList) {
        int r = super.updateByPrimaryKey(site);

        // 删除和字典的关系
        ProductRelation param = new ProductRelation();
        param.setObjId(site.getId());
        //        param.setRelType(GlobalParam.PRODUCT_SITE_DATA);
        productRelationService.deleteByParam(param);

        if (relList != null && !relList.isEmpty()) {
            productRelationService.insertBatch(relList);
        }

        if (siteList != null && !siteList.isEmpty()) {
            List<Long> delList = new ArrayList<Long>();// 要进行删除的设备id
            List<ProductSiteData> insertList = new ArrayList<ProductSiteData>();// 要进行新增的设备

            for (ProductSiteData device : siteList) {
                if (device.getId() == null || device.getId() == 0) {

                    device.setParentId(site.getId());
                    insertList.add(device);
                } else {
                    if (StringUtils.isNumeric(device.getSdFlag())
                        && Integer.valueOf(device.getSdFlag()) == FLAG.del()) {

                        delList.add(device.getId());
                    }
                }
            }
            if (!delList.isEmpty()) {
                mapper.deleteByIds(delList);
            }
            if (!insertList.isEmpty()) {
                mapper.insertBatch(insertList);
            }
            // 改为新增
            // mapper.resetParentId(site.getId());
            // mapper.updateBatchByPrimaryKey(siteList);
        }
        return r;
    }

    public int resetParentId(Long parentId) {
        return mapper.resetParentId(parentId);
    }

    public PageList<ProductSiteData> findWithScenic(PageModel pager, ProductSiteData entity) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", entity);
        List<ProductSiteData> listBean = mapper.findWithScenic(params);
        Integer count = mapper.countWithScenic(params);
        PageBean pageObj = new PageBean(Long.valueOf(count), pager);
        PageList<ProductSiteData> pagelist = new PageList<ProductSiteData>(listBean, pageObj);
        return pagelist;
    }

    public List<ProductSiteData> queryWithScenic(Map<String, Object> params) {
        return mapper.queryWithScenic(params);
    }

    public List<ProductSiteData> findByIdsMapWithScenic(Map<String, List<Long>> ids) {
        return mapper.findByIdsMapWithScenic(ids);
    }

    public int getEntryCheckCountByMac(String mac) {
        return mapper.getEntryCheckCountByMac(mac);
    }

    @Override
    public List<ProductSiteData> querySiteDataByProductInfo(ProductSiteData siteData,
                                                            ProductSiteRelation relation) {
        List<ProductSiteData> productSiteDatas = mapper.selectSiteDataByProductInfo(siteData,
            relation);
        return productSiteDatas;
    }
    
    
    /**
     * 根据产品id获取产品关联的景点
     * @param productId
     * @return
     */
    public List<ProductSiteData>  findByProductId(Long productId){
        if(productId == null){
            logger.error("根据产品id获取产品关联的景点,入参为空");
        }


        List<Long> siteIds = productRelationService.querySiteIdByProductId(productId);
        if(CollectionUtils.isEmpty(siteIds)){
            logger.error("根据产品id:{}没有关联的景点id",productId);
        }

        ProductSiteData queryData = new ProductSiteData();
        queryData.setIds(siteIds);
       return findListByParams(queryData);
    }
}
