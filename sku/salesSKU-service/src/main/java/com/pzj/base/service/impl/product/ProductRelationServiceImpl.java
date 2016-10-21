package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.Date;
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

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductDict;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelation;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductScenicAndSupplier;
import com.pzj.base.entity.query.ProductUser;
import com.pzj.base.product.IProductRelationMapper;
import com.pzj.base.service.exception.SkuParamNullException;
import com.pzj.base.service.product.IProductDictService;
import com.pzj.base.service.product.IProductRelationService;
import com.pzj.util.productConvertUtil.ProductConvert;

/**
 * 产品关系表服务接口
 * 
 * @author apple
 * 
 */
@Service
@Lazy
public class ProductRelationServiceImpl extends
                                        BaseServiceImpl<ProductRelation, IProductRelationMapper>
                                        implements IProductRelationService {

    protected Logger            logger = LoggerFactory.getLogger(ProductRelationServiceImpl.class);

    @Autowired
    private IProductDictService productDictService;

    @Override
    public Long insert(ProductDict dict, String contains) {
        productDictService.insert(dict);
        Long id = dict.getId();
        String productIds[] = contains.split(",");
        List<ProductRelation> prList = new ArrayList<ProductRelation>();
        for (String productId : productIds) {
            ProductRelation pr = new ProductRelation();
            pr.setObjId(id);
            pr.setObjType(GlobalParam.DICTTABLE);
            if (StringUtils.isNumeric(productId)) {
                pr.setRelId(Long.valueOf(productId));
            }
            pr.setRelType(GlobalParam.PRORELEASETABEL);
            pr.setCreateBy(dict.getCreateBy());
            pr.setCreateDate(new Date());
            pr.setUpdateBy(dict.getUpdateBy());
            pr.setUpdateDate(new Date());
            pr.setFlag(GlobalParam.FLAG.start().toString());
            prList.add(pr);
        }
        super.insertBatch(prList);
        return id;
    }

    @Override
    public Long update(ProductDict dict, String contains) {
        productDictService.updateByPrimaryKey(dict);
        Long id = dict.getId();
        String productIds[] = contains.split(",");
        List<ProductRelation> prList = new ArrayList<ProductRelation>();
        ProductRelation param = new ProductRelation();
        param.setObjId(id);
        param.setObjType(GlobalParam.DICTTABLE);
        mapper.deleteByParam(param);

        for (String productId : productIds) {
            ProductRelation pr = new ProductRelation();
            pr.setObjId(id);
            pr.setObjType(GlobalParam.DICTTABLE);
            if (StringUtils.isNumeric(productId)) {
                pr.setRelId(Long.valueOf(productId));
            }
            pr.setRelType(GlobalParam.PRORELEASETABEL);
            pr.setCreateBy(dict.getCreateBy());
            pr.setCreateDate(new Date());
            pr.setUpdateBy(dict.getUpdateBy());
            pr.setUpdateDate(new Date());
            pr.setFlag(GlobalParam.FLAG.start().toString());
            prList.add(pr);
        }
        return super.insertBatch(prList);
    }

    @Override
    public PageList<ProductRelation> queryPageByParams(PageModel pager, ProductRelation relat) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", relat);
        List<ProductRelation> listBean = mapper.queryPageByParams(params);
        Integer count = mapper.queryCountByParams(params);
        PageBean pageObj = new PageBean(count, pager);
        PageList<ProductRelation> pagelist = null;
        pagelist = new PageList<ProductRelation>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public List<ProductRelation> queryListByParams(ProductRelation relat) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("bParam", relat);
        List<ProductRelation> listBean = mapper.queryPageByParams(params);
        return listBean;
    }

    @Override
    public List<ProductRelation> findByIdsMap(Map<String, Object> ids) {
        return mapper.findByIdsMap(ids);
    }

    @Override
    public int deleteByParam(ProductRelation param) {
        return mapper.deleteByParam(param);
    }

    // public List<ProductRelation> queryRels(ProductRelation param) {
    // return mapper.queryRels(param);
    // }

    @Override
    public PageList<Map<String, Object>> findMaxMin(PageModel pager, Map<String, Object> map) {
        // Map<String, Object> params = new HashMap<String, Object>();
        map.put("pParam", pager);
        map.put("scenicType", GlobalParam.SCENIC);
        map.put("proReleaseType", GlobalParam.PRORELEASETABEL);
        map.put("strategyChannelType",
            UserGlobalParam.ChannelMapKeyParam.STRATEGY_CHANNEL_RELATION_TYPE);
        map.put("strategyProductType",
            UserGlobalParam.ChannelMapKeyParam.STRATEGY_PROCUDT_RELATION_TYPE);
        List<Map<String, Object>> listBean = mapper.findMaxMin(map);
        Integer count = mapper.findCouMaxMin(map);
        PageBean pageObj = new PageBean(count, pager);
        PageList<Map<String, Object>> pagelist = null;
        pagelist = new PageList<Map<String, Object>>(listBean, pageObj);
        return pagelist;
    }

    /**
     * 查询景区与产品关系
     */
    @Override
    public List<Map<String, Object>> findScenicByProductId(List<Long> productIdList) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("bParam", productIdList);
        params.put("scenicType", GlobalParam.SCENIC);
        params.put("proReleaseType", GlobalParam.PRORELEASETABEL);
        List<Map<String, Object>> list = mapper.findScenicByProductId(params);
        return list;
    }

    /**
     * 查询景点与产品关系,改版
     */
    @Override
    public List<Map<String, Object>> findScenicBySpotProductId(List<Long> productIdList) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("bParam", productIdList);
        params.put("scenicSpotType", GlobalParam.SCENICSPOT);
        params.put("proReleaseType", GlobalParam.PRORELEASETABEL);
        List<Map<String, Object>> list = mapper.findScenicBySpotProductId(params);
        return list;
    }

    @Override
    public List<Map<String, Object>> findScenicByProduct(List<Long> productIdList, String status) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("bParam", productIdList);
        params.put("scenicType", GlobalParam.SCENIC);
        params.put("proReleaseType", GlobalParam.PRORELEASETABEL);
        params.put("status", status);
        List<Map<String, Object>> list = mapper.findScenicByProduct(params);
        return list;
    }

    // public List<Map<String, Object>> findProductSupplier(
    // List<Long> productIdList) {
    // Map<String, Object> params = new HashMap<String, Object>();
    // params.put("bParam", productIdList);
    // params.put("scenicType", GlobalParam.SCENIC);
    // params.put("proReleaseType", GlobalParam.PRORELEASETABEL);
    // List<Map<String, Object>> list = mapper.findProductSupplier(params);
    // return list;
    // }

    @Override
    public List<ProductScenicAndSupplier> queryPackageWithScenic(List<Long> productIds) {
        return mapper.selectPackageWithScenic(productIds);
    }

    @Override
    public List<ProductUser> queryUserByProduct(ProductUser pu) {
        return mapper.findUserByProduct(pu);
    }

    /**
     * 更新产品与景区关系
     * @param productInfoId
     * @param supplierId
     * @param list
     * @param scenicIds
     */
    public void saveSkuAndScenicRelation(String supplierId, List<ProductRelease> list,
                                         List<Long> scenicIds){
        if (list == null || list.isEmpty()) {
            logger.info("更新产品与景区关系接口[saveSkuAndScenicRelation]：传入参数没有产品信息");
            return;
        }
        if (scenicIds == null) {
            logger.info("更新产品与景区关系接口[saveSkuAndScenicRelation]：传入参数没有景区信息");
            return;
        }
        List<ProductRelation> addRelation = new ArrayList<ProductRelation>();
        List<ProductRelation> deleteRelation = new ArrayList<ProductRelation>();
        for (ProductRelease vo : list) {
            ProductRelation delete = new ProductRelation();
            delete.setObjId(vo.getId());
            delete.setObjType(GlobalParam.PRORELEASETABEL);
            delete.setRelType(GlobalParam.SCENIC);
            delete.setSupplierId(vo.getSupplierId());
            if (supplierId != null) {
                delete.setSupplierId(supplierId);
            }
            deleteRelation.add(delete);

            for (Long scenicId : scenicIds) {
                ProductRelation add = new ProductRelation();
                add.setObjId(vo.getId());
                add.setObjType(GlobalParam.PRORELEASETABEL);
                add.setRelId(scenicId);
                add.setRelType(GlobalParam.SCENIC);
                add.setFlag(GlobalParam.FLAG.start().toString());
                add.setCreateBy(vo.getCreateBy());
                add.setCreateDate(new Date());
                add.setUpdateDate(new Date());
                add.setGroupCode(vo.getProductId() == null ? "" : vo.getProductId().toString());
                add.setSupplierId(vo.getSupplierId());
                if (supplierId != null) {
                    add.setSupplierId(supplierId);
                }
                addRelation.add(add);
            }

        }

        //1.先删除
        mapper.deleteBatchByParam(deleteRelation);

        //2.添加
        insertBatch(addRelation);

    }

    /**
     * 更新产品组与景区关系（为了兼容老接口）
     * @param productInfoId
     * @param supplierId
     * @param list
     * @param scenicIds
     */
    public void saveSpuAndScenicRelation(ProductInfo info, String supplierId,
                                         List<Long> scenicIds) {
        if (info == null) {
            throw new SkuParamNullException("更新产品与景区关系接口[saveSkuAndScenicRelation]：传入参数没有产品信息");
        }
        if (scenicIds == null) {
        	throw new SkuParamNullException("更新产品与景区关系接口[saveSkuAndScenicRelation]：传入参数没有景区信息");

        }
        List<ProductRelation> addRelation = new ArrayList<ProductRelation>();
        List<ProductRelation> deleteRelation = new ArrayList<ProductRelation>();

        ProductRelation delete = new ProductRelation();
        delete.setObjId(info.getId());
        delete.setObjType(GlobalParam.PROINFOTABEL);
        delete.setRelType(GlobalParam.SCENIC);
        delete.setSupplierId(supplierId);
        if (supplierId != null) {
            delete.setSupplierId(supplierId);
        }
        deleteRelation.add(delete);

        for (Long scenicId : scenicIds) {
            ProductRelation add = new ProductRelation();
            add.setObjId(info.getId());
            add.setObjType(GlobalParam.PROINFOTABEL);
            add.setRelId(scenicId);
            add.setRelType(GlobalParam.SCENIC);
            add.setFlag(GlobalParam.FLAG.start().toString());
            add.setCreateBy(info.getCreateBy());
            add.setCreateDate(new Date());
            add.setUpdateDate(new Date());
            add.setSupplierId(info.getSupplierId());
            if (supplierId != null) {
                add.setSupplierId(supplierId);
            }
            addRelation.add(add);
        }
        //1.先删除
        mapper.deleteBatchByParam(deleteRelation);

        //2.添加
        insertBatch(addRelation);

    }

    /**
     * 更新产品与景点关系（为了兼容老接口）
     * @param productInfoId
     * @param supplierId
     * @param list
     * @param scenicIds
     */
    public void saveSkuAndSiteDateRelation(String supplierId, List<ProductRelease> list,
                                           List<Long> siteRelations) {
        if (list == null || list.isEmpty()) {
            logger.error("更新产品与景点关系接口[saveSkuAndSiteDateRelation]：传入参数没有产品信息");
            return;
        }
        if (siteRelations == null) {
            logger.error("更新产品与景点关系接口[saveSkuAndSiteDateRelation]：传入参数没有景点信息");
            return;
        }
        List<ProductRelation> addRelation = new ArrayList<ProductRelation>();
        List<ProductRelation> deleteRelation = new ArrayList<ProductRelation>();
        for (ProductRelease vo : list) {
            ProductRelation delete = new ProductRelation();
            delete.setObjId(vo.getId());
            delete.setObjType(GlobalParam.PRORELEASETABEL);
            delete.setRelType(GlobalParam.SCENICSPOT);
            delete.setSupplierId(vo.getSupplierId());
            if (supplierId != null) {
                delete.setSupplierId(supplierId);
            }
            deleteRelation.add(delete);

            for (Long siteId : siteRelations) {
                ProductRelation add = new ProductRelation();
                add.setObjId(vo.getId());
                add.setObjType(GlobalParam.PRORELEASETABEL);
                add.setRelId(siteId);
                add.setRelType(GlobalParam.SCENICSPOT);
                add.setFlag(GlobalParam.FLAG.start().toString());
                add.setCreateBy(vo.getCreateBy());
                add.setCreateDate(new Date());
                add.setUpdateDate(new Date());
                add.setGroupCode(vo.getProductId() == null ? "" : vo.getProductId().toString());
                add.setSupplierId(vo.getSupplierId());
                if (supplierId != null) {
                    add.setSupplierId(supplierId);
                }
                addRelation.add(add);
            }

        }

        //1.先删除
        mapper.deleteBatchByParam(deleteRelation);

        //2.添加
        insertBatch(addRelation);

    }

    public List<Long> queryProductIdsByScenicIds(List<Long> scenicIds) {
        if (scenicIds == null || scenicIds.isEmpty()) {
            return null;
        }
        ProductRelation key = new ProductRelation();
        key.setRelIds(scenicIds);
        key.setObjType(GlobalParam.PRORELEASETABEL);
        key.setRelType(GlobalParam.SCENIC);
        List<ProductRelation> result = findListByParams(key);
        return ProductConvert.getObjIdList(result);
    }
    
    public List<Long> queryProductInfoIdsByScenicIds(List<Long> scenicIds,List<Long> infoIds) {
        if (scenicIds == null || scenicIds.isEmpty()) {
            return null;
        }
        ProductRelation key = new ProductRelation();
        key.setObjIds(infoIds);
        key.setRelIds(scenicIds);
        key.setObjType(GlobalParam.PROINFOTABEL);
        key.setRelType(GlobalParam.SCENIC);
        List<ProductRelation> result = findListByParams(key);
        return ProductConvert.getObjIdList(result);
    }
    
    
    public List<Long> queryScenicIdByProductId(Long productId) {
        if (productId == null) {
            return null;
        }
        ProductRelation key = new ProductRelation();
        key.setObjId(productId);
        key.setObjType(GlobalParam.PRORELEASETABEL);
        key.setRelType(GlobalParam.SCENIC);
        List<ProductRelation> result = findListByParams(key);
        return ProductConvert.getRelIdList(result);
    }

	@Override
	public List<Long> querySiteIdByProductId(Long productId) {
		 if (productId == null) {
	            return null;
	        }
	        ProductRelation key = new ProductRelation();
	        key.setObjId(productId);
	        key.setObjType(GlobalParam.PRORELEASETABEL);
	        key.setRelType(GlobalParam.SCENICSPOT);
	        List<ProductRelation> result = findListByParams(key);
	        return ProductConvert.getRelIdList(result);
	}

	@Override
	public List<ProductRelation> queryRelationByProductInfoIds(List<Long> infoIds) {
		 if (CollectionUtils.isEmpty(infoIds)) {
	            return null;
	        }
		    ProductRelation key = new ProductRelation();
	        key.setObjIds(infoIds);
	        key.setObjType(GlobalParam.PROINFOTABEL);
	        key.setRelType(GlobalParam.SCENIC);
	        List<ProductRelation> result = findListByParams(key);
	     return result;
	}

}
