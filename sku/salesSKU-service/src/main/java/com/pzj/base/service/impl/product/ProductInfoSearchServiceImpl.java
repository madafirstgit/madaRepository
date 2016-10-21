package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelation;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.product.IProductInfoSearchMapper;
import com.pzj.base.service.exception.SkuSearchException;
import com.pzj.base.service.product.IProductInfoSearchService;
import com.pzj.base.service.product.IProductRelationService;
import com.pzj.base.service.product.IProductScenicService;
import com.pzj.common.QueryPageBean;
import com.pzj.common.QueryPageList;
import com.pzj.common.QueryPageModel;
import com.pzj.product.vo.product.SpuProduct;
import com.pzj.product.vo.voParam.queryParam.AppSearchQuery;
import com.pzj.product.vo.voParam.queryParam.DateQueryParam;
import com.pzj.product.vo.voParam.queryParam.SpuProductQuery;
import com.pzj.util.productConvertUtil.CommonConvert;
import com.pzj.util.productConvertUtil.ProductConvert;

@Service
@Lazy
public class ProductInfoSearchServiceImpl implements IProductInfoSearchService {

    @Autowired
    IProductInfoSearchMapper mapper;

    @Autowired
    IProductScenicService        productScenicService;

    @Autowired
    IProductRelationService      productRelationService;

    @Override
    public QueryPageList<SpuProduct> queryPageByAppParam(QueryPageModel pParam,
                                                         SpuProductQuery queryParamj,
                                                         AppSearchQuery appSearchQuery,
                                                         List<Long> spuIds) throws Exception {


        ProductInfo bParam = ProductConvert.convertTProductInfo(queryParamj);
        if (bParam == null) {
            bParam = new ProductInfo();
        }

        //根据关键字过滤产品组id
        spuIds = querySkuIdsByScenicAppSearch(appSearchQuery,spuIds);
        if(CollectionUtils.isEmpty(spuIds)){
            throw new SkuSearchException("根据关键字:"+appSearchQuery+"过滤产品："+spuIds+",没有有效的产品数据");
        }



        //过滤id集合查询参数，取交集[前台输入产品组id集合参数和分销商可看的产品组id集合参数]
        List<Long> spuIds1 = bParam.getIds();
        if (!CollectionUtils.isEmpty(spuIds1))
            spuIds = CommonConvert.intersectionList(spuIds, spuIds1);


        //按照id和产品组查询参数查询
        bParam.setIds(spuIds);
        Integer count = mapper.countProductInfoByAppSearchKey(bParam);
        if (count < 1) {
            return null;
        }
        List<ProductInfo> listBean = mapper.selectProductInfoByAppSearchKey(bParam, pParam);

        QueryPageList<SpuProduct> returnPage = new QueryPageList<SpuProduct>();
        List<SpuProduct> returnList = ProductConvert.convertTSpuList(listBean);
        QueryPageBean pageBean = new QueryPageBean(Long.valueOf(count.toString()), pParam);
        returnPage.setResultList(returnList);
        returnPage.setPageBean(pageBean);

        return returnPage;
    }

    @Override
    public QueryPageList<SpuProduct> queryPageByCommonsParam(QueryPageModel pParam,
                                                             SpuProductQuery queryParam,
                                                             List<Long> spuIds) throws Exception {
        ProductInfo productInfoParam = ProductConvert.convertTProductInfo(queryParam);
        if (productInfoParam == null)
            productInfoParam = new ProductInfo();

        productInfoParam.setIds(spuIds);

        Integer count = mapper.countProductInfoByAppSearchKey(productInfoParam);
        if (count < 1) {
            return null;
        }
        List<ProductInfo> listBean = mapper.queryByParamMap(productInfoParam, pParam);

        QueryPageList<SpuProduct> returnPage = new QueryPageList<SpuProduct>();
        List<SpuProduct> returnList = ProductConvert.convertTSpuList(listBean);
        QueryPageBean pageBean = new QueryPageBean(Long.valueOf(count.toString()), pParam);
        returnPage.setResultList(returnList);
        returnPage.setPageBean(pageBean);

        return returnPage;
    }

    /**
     * 根据app查询参数，过滤产品组id
     * @param vo
     * @return
     * @throws Exception
     */
    private List<Long> querySkuIdsByScenicAppSearch(AppSearchQuery vo, List<Long> spuIds) throws Exception {

        if (vo == null) {
            return spuIds;
        }
        if(vo.isNotHaveValue()){
            return spuIds;
        }


        List<Long> resultIds = new ArrayList<Long>();

        //1.按照关键字产品出景区信息
        List<ProductScenic> scenics = productScenicService.queryScenicsByAppSearchKey(vo);

        List<Long> scenicIds = CommonConvert.getIdList(scenics);

        List<Long> needScenicInfoId = null;
        List<Long> notNeedScenicInfoId = null;

        //1.查询景区id绑定的产品
        if(vo.getId() != null){
            needScenicInfoId = spuIds;
        }else{
            //2.查询关键字绑定的产品
            List<ProductRelation> relation =  productRelationService.queryRelationByProductInfoIds(spuIds);
            List<Long> infoIds = ProductConvert.getObjIdList(relation);

            //3.拆分景区关联产品的关键字查询
            needScenicInfoId = CommonConvert.intersectionList(spuIds, infoIds);
            notNeedScenicInfoId = CommonConvert.notInList(spuIds, infoIds);
        }

        //4.关键字：景区查询
        if(CollectionUtils.isNotEmpty(needScenicInfoId) && CollectionUtils.isNotEmpty(scenicIds)){
            List<ProductInfo> needScenic =  mapper.selectByScenicAppSearchKey(needScenicInfoId, scenicIds);
            if(CollectionUtils.isNotEmpty(needScenic)){
                resultIds.addAll(CommonConvert.getIdList(needScenic));
            }
        }

        //5.关键字：产品查询
        if(CollectionUtils.isNotEmpty(notNeedScenicInfoId)){
            List<ProductInfo> notNeedScenic = findByAppSearchKey(notNeedScenicInfoId,vo);
            if(CollectionUtils.isNotEmpty(notNeedScenic)){
                resultIds.addAll(CommonConvert.getIdList(notNeedScenic));
            }
        }


        return resultIds;
    }

    private List<ProductInfo> findByAppSearchKey(List<Long> infoIds, AppSearchQuery searchKey){
        if(CollectionUtils.isEmpty(infoIds)){
            return null;
        }
        if (searchKey == null) {
            return null;
        }
        if(searchKey.isNotHaveValue()){
            return null;
        }

        ProductInfo info = new ProductInfo();
        info.setIds(infoIds);
        info.setProvince(searchKey.getProvince());
        info.setCity(searchKey.getCity());
        info.setCounty(searchKey.getCounty());
        info.setSearchKey(searchKey.getSearchKey());

        return mapper.selectProductInfoByAppSearchKey(info, null);



    }



    @Override
    public List<Integer> queryHashCodeForUpdate(Integer hashCode) {

        return mapper.selectHashCodeForUpdate(hashCode);
    }

    @Override
    public List<Long> queryIdBySkuIdForUpdate(Long skuId) {
        // TODO Auto-generated method stub
        return mapper.selectIdBySkuIdForUpdate(skuId);
    }

    @Override
    public QueryPageList<ProductInfo> findSpuproductForSupplier(ProductInfo productInfo, ProductRelease productRelease, QueryPageModel pageModel){
        List<ProductInfo> productInfoList = null;
        int count = mapper.countSpuproductForSupplier(productInfo, productRelease);
        if (count > 0){
            productInfoList = mapper.selectSpuproductForSupplier(productInfo, productRelease, pageModel);
        }

        QueryPageList<ProductInfo> result = new QueryPageList<ProductInfo>(productInfoList, pageModel, count);
        return result;
    }

    @Override
    public List<ProductInfo> findAddressByProductId(List<Long> productIds) {
        // TODO Auto-generated method stub
        return mapper.selectAddressByProductId(productIds);
    }

    @Override
    public List<ProductInfo> findListByParam(ProductInfo productInfo) {

        return mapper.queryByParamMap(productInfo, null);
    }


    public List<ProductInfo> findListByIds(List<Long> ids) {
        ProductInfo info = new ProductInfo();
        info.setIds(ids);
        return mapper.queryByParamMap(info, null);
    }

	@Override
	public List<ProductInfo> findByAppParam(SpuProductQuery queryParam,
			AppSearchQuery appSearchQuery) {
		ProductInfo info = ProductConvert.convertTProductInfo(queryParam);
		if(queryParam == null){
			info = new ProductInfo();
		}
		info.setProvince(appSearchQuery.getProvince());
		info.setCity(appSearchQuery.getCity());
		info.setCounty(appSearchQuery.getCounty());
		info.setSearchKey(appSearchQuery.getSearchKey());
		
		
		return findListByParam(info);
	}
}
