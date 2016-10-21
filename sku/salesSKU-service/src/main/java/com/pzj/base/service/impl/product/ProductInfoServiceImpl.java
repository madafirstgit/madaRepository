package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.exception.ServiceException;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.utils.GenerateRandomNum;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductCombineRelation;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelation;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.entity.product.ProductSiteData;
import com.pzj.base.entity.product.ProductSiteRelation;
import com.pzj.base.product.IProductInfoMapper;
import com.pzj.base.service.exception.SkuParamNullException;
import com.pzj.base.service.product.IProductCloseTimeslotService;
import com.pzj.base.service.product.IProductCombineRelationService;
import com.pzj.base.service.product.IProductInfoService;
import com.pzj.base.service.product.IProductRelationService;
import com.pzj.base.service.product.IProductReleaseService;
import com.pzj.base.service.product.IProductSiteRelationService;
import com.pzj.util.productConvertUtil.ProductCheckUtil;

@Service
@Lazy
public class ProductInfoServiceImpl extends BaseServiceImpl<ProductInfo, IProductInfoMapper>
                                    implements IProductInfoService {

    @Autowired
    IProductReleaseService         productReleaseService;

    @Autowired
    IProductRelationService        productRelationService;

    @Autowired
    IProductCombineRelationService productCombineRelationService;
    
    @Autowired
    IProductCloseTimeslotService  productCloseTimeslotService;
    
    @Autowired
    IProductSiteRelationService    productSiteReletionService;

    /**
     * 日志对象
     */
    protected Logger               logger = LoggerFactory.getLogger(ProductInfoServiceImpl.class);

    @Override
    public PageList<ProductInfo> queryPageByParamMap(PageModel pager, ProductInfo entity) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("info", entity);
        List<ProductInfo> listBean = mapper.queryByParamMap(params);
        Integer count = mapper.countByParamMap(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<ProductInfo> pagelist = null;
        pagelist = new PageList<ProductInfo>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public List<ProductInfo> findListByParams(ProductInfo entity) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("info", entity);
        List<ProductInfo> listBean = mapper.queryByParamMap(params);
        return listBean;
    }

    /**
     * 保存产品，改版
     */
    public void saveProduct(List<ProductInfo> piList, List<ProductRelease> prList,
                            List<ProductScenic> scenicList, List<ProductSiteData> scenicSpotList) {

        super.insertBatch(piList);
        Map<String, Long> tmpMap = new HashMap<String, Long>();
        for (ProductInfo pi : piList) {
            tmpMap.put(pi.getTempNo(), pi.getId());
        }
        for (ProductRelease pr : prList) {
            pr.setProductId(tmpMap.get(pr.getTempNo()));
        }
        productReleaseService.insertBatch(prList);
        List<ProductRelation> prtList = new ArrayList<>();
        List<ProductRelation> prtSpotList = new ArrayList<>();//增加景点集合
        List<ProductRelation> proInfoScenicList = new ArrayList<>();
        // 产品基本信息与景区关系

        Long tempNo = System.currentTimeMillis() + GenerateRandomNum.ranomdNum();
        for (ProductRelease pr : prList) { //改版产品景点关系

            //景区关系
            for (ProductScenic scenic : scenicList) {
                ProductRelation prt = new ProductRelation();
                prt.setObjId(pr.getId());
                prt.setObjType(GlobalParam.PRORELEASETABEL);
                prt.setRelId(scenic.getId());
                prt.setRelType(GlobalParam.SCENIC);
                prt.setFlag(GlobalParam.FLAG.start().toString());
                prt.setCreateBy(scenic.getCreateBy());
                prt.setCreateDate(new Date());
                prt.setUpdateDate(new Date());
                prt.setGroupCode(tempNo.toString());
                prt.setRemarks(pr.getProductId().toString());
                prt.setSupplierId(pr.getSupplierId());
                prtList.add(prt);
            }
            //景点关系
            for (ProductSiteData scenicspot : scenicSpotList) {
                ProductRelation prt = new ProductRelation();
                prt.setObjId(pr.getId());
                prt.setObjType(GlobalParam.PRORELEASETABEL);
                prt.setRelId(scenicspot.getId()); //景点id
                prt.setRelType(GlobalParam.SCENICSPOT);//景点
                prt.setFlag(GlobalParam.FLAG.start().toString());
                prt.setCreateBy(scenicspot.getCreateBy());
                prt.setCreateDate(new Date());
                prt.setUpdateDate(new Date());
                prt.setGroupCode(tempNo.toString());
                prt.setRemarks(pr.getProductId().toString());
                prt.setSupplierId(pr.getSupplierId());
                prtSpotList.add(prt);
            }
        }

        for (ProductInfo info : piList) {
            //景区关系
            if (null != scenicList) {
                for (ProductScenic scenic : scenicList) {
                    ProductRelation prt = new ProductRelation();
                    prt.setObjId(info.getId());
                    prt.setObjType(GlobalParam.PROINFOTABEL);
                    prt.setRelId(scenic.getId());
                    prt.setRelType(GlobalParam.SCENIC);
                    prt.setFlag(GlobalParam.FLAG.start().toString());
                    prt.setCreateBy(scenic.getCreateBy());
                    prt.setCreateDate(new Date());
                    prt.setGroupCode(tempNo.toString());
                    prt.setRemarks(info.getName());
                    prt.setSupplierId(info.getSupplierId());
                    proInfoScenicList.add(prt);
                }
            }
        }

        productRelationService.insertBatch(prtList);
        productRelationService.insertBatch(prtSpotList);
        productRelationService.insertBatch(proInfoScenicList);
    }

    @Override
    public List<Long> saveProductV2(List<ProductInfo> piList, List<ProductRelease> prList,
                                    List<ProductScenic> scenicList,
                                    List<ProductSiteData> scenicSpotList, List<SysUser> userList) {

        logger.info("方法[saveProductV2]的入参:ProductInfo{},ProductRelease{}", piList, prList);
        if (piList == null || piList.isEmpty()) {
            new ServiceException("方法[saveProductV2]新建产品组，请求参数为空无法新建");
        }
        if (prList == null || prList.isEmpty()) {
            new ServiceException("方法[saveProductV2]新建产品，请求参数为空无法新建");
        }

        super.insertBatch(piList);

        Map<String, Long> tmpMap = new HashMap<>();
        for (ProductInfo pi : piList) {
            tmpMap.put(pi.getTempNo(), pi.getId());
        }
        for (ProductRelease pr : prList) {
            pr.setProductId(tmpMap.get(pr.getTempNo()));
        }

        productReleaseService.insertBatch(prList);

        List<ProductRelation> prtList = null;
        List<ProductRelation> prtSpotList = null;//增加景点集合
        List<ProductRelation> prtUserList = null;//产品与供应商关联
        List<ProductRelation> proInfoScenicList = null; // 产品基本信息与景区关系

        if (null != scenicList) {
            prtList = new ArrayList<>();
            proInfoScenicList = new ArrayList<>();
        }
        if (null != scenicSpotList)
            prtSpotList = new ArrayList<>();//增加景点集合
        if (null != userList)
            prtUserList = new ArrayList<>();//产品与供应商关联

        Long tempNo = System.currentTimeMillis() + GenerateRandomNum.ranomdNum();
        List<Long> prIdList = new ArrayList<>();
        for (ProductRelease pr : prList) {
            //景区关系
            if (null != scenicList) {
                for (ProductScenic scenic : scenicList) {
                    ProductRelation prt = new ProductRelation();
                    prt.setObjId(pr.getId());
                    prt.setObjType(GlobalParam.PRORELEASETABEL);
                    prt.setRelId(scenic.getId());
                    prt.setRelType(GlobalParam.SCENIC);
                    prt.setFlag(GlobalParam.FLAG.start().toString());
                    prt.setCreateBy(scenic.getCreateBy());
                    prt.setCreateDate(new Date());
                    prt.setGroupCode(tempNo.toString());
                    prt.setRemarks(pr.getProductId().toString());
                    prt.setSupplierId(pr.getSupplierId());
                    prtList.add(prt);
                }
            }

            //景点关系
            if (null != scenicSpotList) {
                for (ProductSiteData scenicspot : scenicSpotList) {
                    ProductRelation prt = new ProductRelation();
                    prt.setObjId(pr.getId());
                    prt.setObjType(GlobalParam.PRORELEASETABEL);
                    prt.setRelId(scenicspot.getId()); //景点id
                    prt.setRelType(GlobalParam.SCENICSPOT);//景点
                    prt.setFlag(GlobalParam.FLAG.start().toString());
                    prt.setCreateBy(scenicspot.getCreateBy());
                    prt.setCreateDate(new Date());
                    prt.setUpdateDate(new Date());
                    prt.setGroupCode(tempNo.toString());
                    prt.setRemarks(pr.getProductId().toString());
                    prt.setSupplierId(pr.getSupplierId());
                    prtSpotList.add(prt);
                }
            }

            //供应商关系
            if (null != userList) {
                for (SysUser user : userList) {
                    ProductRelation prt = new ProductRelation();
                    prt.setObjId(pr.getId());
                    prt.setObjType(GlobalParam.PRORELEASETABEL);
                    prt.setRelId(user.getId());
                    prt.setRelType(GlobalParam.SUPPLIER);
                    prt.setFlag(GlobalParam.FLAG.start().toString());
                    prt.setCreateBy(user.getCreateBy());
                    prt.setCreateDate(new Date());
                    prt.setGroupCode(tempNo.toString());
                    prt.setRemarks(pr.getProductId().toString());
                    prt.setSupplierId(pr.getSupplierId());
                    prtUserList.add(prt);
                }
            }

            prIdList.add(pr.getId());
        }

        for (ProductInfo info : piList) {
            //景区关系
            if (null != scenicList) {
                for (ProductScenic scenic : scenicList) {
                    ProductRelation prt = new ProductRelation();
                    prt.setObjId(info.getId());
                    prt.setObjType(GlobalParam.PROINFOTABEL);
                    prt.setRelId(scenic.getId());
                    prt.setRelType(GlobalParam.SCENIC);
                    prt.setFlag(GlobalParam.FLAG.start().toString());
                    prt.setCreateBy(scenic.getCreateBy());
                    prt.setCreateDate(new Date());
                    prt.setGroupCode(tempNo.toString());
                    prt.setRemarks(info.getName());
                    prt.setSupplierId(info.getSupplierId());
                    proInfoScenicList.add(prt);
                }
            }
        }

        if (null != prtList) {
            productRelationService.insertBatch(prtList);
        }
        if (null != prtSpotList) {
            productRelationService.insertBatch(prtSpotList);
        }
        if (null != prtUserList) {
            productRelationService.insertBatch(prtUserList);
        }
        if (null != proInfoScenicList) {
            productRelationService.insertBatch(proInfoScenicList);
        }
        return prIdList;
    }

    @Override
    public Long insertCompose(ProductInfo info, List<ProductCombineRelation> relationList,
                              List<ProductRelease> releaseIdList, ProductRelease composeRelease) {
        mapper.insert(info);
        composeRelease.setProductId(info.getId());
        productReleaseService.insert(composeRelease);
        if (releaseIdList != null) {
            productReleaseService.updateBatchByPrimaryKey(releaseIdList);
        }
        Long productId = info.getId();
        if (relationList != null) {
            for (ProductCombineRelation relation : relationList) {
                relation.setProductId(Long.valueOf(productId));
            }
            productCombineRelationService.insertBatch(relationList);
        }
        return productId;
    }

    @Override
    public Long insertCompose(ProductInfo info, ProductRelease compose, List<ProductRelease> subs) {
        if (info == null || compose == null || subs == null || subs.isEmpty())
            return null;

        // 先保存基本信息
        mapper.insert(info);

        // 关联基本信息与Release
        compose.setProductId(info.getId());
        productReleaseService.insert(compose);

        // 关联组合产品Release与子产品Release
        // 改为一对多关联，2016-02-14 by lizheng
        // 添加子票的状态，是否被组合过。2016-02-19 by wuliqing
        Long composeId = compose.getId();
        for (ProductRelease sub : subs) {
            sub.setIsComposed(true);
        }
        productReleaseService.updateBatchByPrimaryKey(subs);
        // end添加子票的状态

        List<ProductCombineRelation> pcrList = new ArrayList<>();
        for (ProductRelease sub : subs) {
            ProductCombineRelation pcr = new ProductCombineRelation();
            pcr.setProductId(composeId);
            pcr.setSubProductId(sub.getId());
            pcrList.add(pcr);
        }
        productCombineRelationService.insertBatch(pcrList);
        return composeId;
    }

    @Override
    public PageList<ProductInfo> findProductInfoByInfoScenic(ProductInfo info, ProductScenic scenic,
                                                             PageModel page) {
        List<ProductInfo> listBean = null;
        int count = mapper.countProductInfoByInfoScenic(info, scenic);
        if (count > 0) {
            listBean = mapper.selectProductInfoByInfoScenic(info, scenic, page);
        }
        PageList<ProductInfo> pagelist = new PageList<>(listBean, page, count);
        return pagelist;
    }

    @Override
    public List<ProductInfo> findProductInfoWithReleaseByParam(ProductInfo info) {
        List<ProductInfo> listBean = mapper.selectProductInfoWithReleaseByParam(info);
        return listBean;
    }

    @Override
    public Integer modifyProductInfoState(String flag, List<Long> ids) {
        logger.info("产品组更新接口[modifyProductInfoState],传入参数：flag={},ids={}", flag, ids);
        if (StringUtils.isBlank(flag) || CollectionUtils.isEmpty(ids)) {
            return null;
        }

        List<ProductInfo> updateBean = new ArrayList<ProductInfo>();
        for (Long id : ids) {
            ProductInfo info = new ProductInfo();
            info.setId(id);
            info.setFlag(flag);
            updateBean.add(info);
        }
        return updateBatchByPrimaryKey(updateBean);
    }

    public Long addProduct(ProductInfo info, List<ProductCloseTimeslot> slotList, List<Long> scenicList,List<ProductSiteRelation> siteList) {
         Long result = 0l;
        if(info == null){
     		throw new SkuParamNullException("新建产品组信息，传入的产品组实体为空");
     	}
     	
     	 ProductCheckUtil.checkAddData(info);
	     //新建产品组
	     result = insert(info);

    	//更新产品组的所有关系（产品组及关闭时间事件，产品组及景区，产品组及景点） 
        saveProductAuth(info,slotList, scenicList, siteList);     
        return result;
    }
    
    public Integer saveProduct(ProductInfo info, List<ProductCloseTimeslot> slotList,List<Long> scenicList,List<ProductSiteRelation> siteList) {
    	Integer result = 0;
    	//更新产品组
    	if(info == null){
    		throw new SkuParamNullException("更新产品组信息，传入的产品组实体为空");
    	}

    	if(info.getId() == null){
			throw new SkuParamNullException("更新产品组信息，传入的产品组id为空");
		}
		result += updateByPrimaryKey(info);	
		//更新产品组的所有关系（产品组及关闭时间事件，产品组及景区，产品组及景点）
        saveProductAuth(info,slotList, scenicList, siteList);   
    	     
        
        return result;
    }
    
    private void saveProductAuth(ProductInfo info,List<ProductCloseTimeslot> slotList,List<Long> scenicIds,List<ProductSiteRelation> siteList){
    

    	//更新产品组与景区的关系
    	if(scenicIds != null){
    		 productRelationService.saveSpuAndScenicRelation(info, null, scenicIds);
    	}
    	//更新产品组与景点的关系
    	if(siteList != null){
    	    productSiteReletionService.saveSkuAndSiteRelation(info, null, siteList);
    	}
    	//更新产品组与关闭时间事件的关系
    	if(!CollectionUtils.isEmpty(slotList)){
            productCloseTimeslotService.saveSkuAndCloseTimeSlotRelation(info,slotList);
    	}
    }

    

}
