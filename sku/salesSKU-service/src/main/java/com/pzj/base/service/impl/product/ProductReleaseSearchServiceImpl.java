package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.product.IProductReleaseSearchMapper;
import com.pzj.base.service.exception.SkuParamNullException;
import com.pzj.base.service.model.queryResult.Product;
import com.pzj.base.service.model.util.ModelOperateUtil;
import com.pzj.base.service.model.util.SkuStockConvert;
import com.pzj.base.service.product.IProductCloseTimeslotService;
import com.pzj.base.service.product.IProductInfoSearchService;
import com.pzj.base.service.product.IProductReleaseSearchService;
import com.pzj.common.QueryPageBean;
import com.pzj.common.QueryPageList;
import com.pzj.common.QueryPageModel;
import com.pzj.core.stock.model.result.SkuStockRelationResult;
import com.pzj.core.stock.model.result.SkuStockResult;
import com.pzj.product.vo.product.SkuProduct;
import com.pzj.product.vo.voParam.queryParam.SkuProductQuery;
import com.pzj.util.productConvertUtil.CommonConvert;
import com.pzj.util.productConvertUtil.ProductConvert;

@Service
@Lazy
public class ProductReleaseSearchServiceImpl implements IProductReleaseSearchService {

    private Logger logger = LoggerFactory.getLogger(ProductReleaseSearchServiceImpl.class);

    @Autowired
    IProductReleaseSearchMapper mapper;

    @Autowired
    IProductCloseTimeslotService productCloseTimeslotService;

    @Autowired
    IProductInfoSearchService  productInfoSearchService;


    ModelOperateUtil modelOperateUtil = ModelOperateUtil.getInstance();

    SkuStockConvert skuStockConvert = SkuStockConvert.getInstance();


    public ProductRelease findById(Long id) {

        return mapper.selectByPrimaryKey(id);
    }

    public List<ProductRelease> queryByParam(ProductRelease bParam) {
        return mapper.selectPageByParam(bParam, null);
    }

    private QueryPageList<ProductRelease> queryPageByParam(ProductRelease bParam,
                                                           QueryPageModel pParam) {

        List<ProductRelease> listBean = null;
        Integer count = mapper.countByParam(bParam);
        if (count > 0) {
            listBean = mapper.selectPageByParam(bParam, pParam);
        }
        QueryPageBean pageObj = new QueryPageBean(Long.valueOf(count.toString()), pParam);
        QueryPageList<ProductRelease> pagelist = new QueryPageList<ProductRelease>(listBean,
                pageObj);

        return pagelist;
    }

    @Override
    public List<SkuProduct> queryByParam(SkuProductQuery bParam) throws Exception {

        ProductRelease release = ProductConvert.convertTProduct(bParam);
        List<ProductRelease> queryList = queryByParam(release);

        return ProductConvert.convertTSkuProductList(queryList);
    }

    @Override
    public QueryPageList<SkuProduct> queryPageByParam(SkuProductQuery bParam,
                                                      QueryPageModel pParam) throws Exception {
        ProductRelease release = ProductConvert.convertTProduct(bParam);
        QueryPageList<ProductRelease> queryPageList = queryPageByParam(release, pParam);
        QueryPageList<SkuProduct> result = null;
        if (queryPageList != null && !queryPageList.isEmpty()) {
            result = new QueryPageList<SkuProduct>();
            List<ProductRelease> queryList = queryPageList.getResultList();
            result.setResultList(ProductConvert.convertTSkuProductList(queryList));
            result.setPageBean(queryPageList.getPageBean());
        }
        return result;
    }

    @Override
    public List<SkuProduct> queryByParam(SkuProductQuery queryParam,
                                         List<Long> skuIds) throws Exception {
        List<Long> idQuery  =skuIds;
        if (queryParam == null) {
            queryParam = new SkuProductQuery();
        }
        if (!CollectionUtils.isEmpty(queryParam.getIds())) {
            idQuery = CommonConvert.intersectionList(skuIds, queryParam.getIds());
        }
        if (!CollectionUtils.isEmpty(skuIds)) {
            queryParam.setIds(idQuery);
        }
        return queryByParam(queryParam);
    }
  

    public List<Product> findValidSkuByIds(List<Long> ids) {
        if(CollectionUtils.isEmpty(ids)){
            throw  new SkuParamNullException("根据产品id集合查询有效的产品[findValidSkuByIds],入参为空");
        }

        ProductRelease query = new ProductRelease();
        query.setIds(ids);
        query.setFlag(GlobalParam.FLAG.start().toString());
        List<ProductRelease> prList = queryByParam(query);
        if(CollectionUtils.isEmpty(prList)){
            return new ArrayList<Product>();
        }
        List<Long> productInfoIds = modelOperateUtil.getInfoIdList(prList);
        List<ProductInfo> infoList = productInfoSearchService.findListByIds(productInfoIds);
        List<ProductCloseTimeslot> slotList = productCloseTimeslotService.findValidListByProductIds(productInfoIds);

        return ProductConvert.combinationTProduct(prList, infoList, slotList);
    }

    @Override
    public List<SkuStockResult> findValidSkuByRelations(
            List<SkuStockRelationResult> relations) {
        if(CollectionUtils.isEmpty(relations)){
            throw  new SkuParamNullException("根据产品库存关系集合获取有效的产品集合[findValidSkuByRelations],入参为空");
        }
        List<Long> productIds = modelOperateUtil.getProductIdForSSR(relations);
        List<Product> productList = findValidSkuByIds(productIds);
        return skuStockConvert.convertTSkuStockResult(productList);
    }
}
