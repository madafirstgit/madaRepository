package com.pzj.product.service;

import java.util.List;

import com.pzj.common.QueryPageList;
import com.pzj.common.QueryPageModel;
import com.pzj.framework.context.Result;
import com.pzj.product.vo.JsonSkuDto;
import com.pzj.product.vo.product.SkuProduct;
import com.pzj.product.vo.product.SpuProduct;
import com.pzj.product.vo.voParam.modificationParam.SkuPriceModificationVO;
import com.pzj.product.vo.voParam.modificationParam.SpuProductModificationVO;
import com.pzj.product.vo.voParam.queryParam.ProductSaledParam;
import com.pzj.product.vo.voParam.queryParam.SkuProductForScenicQuery;
import com.pzj.product.vo.voParam.queryParam.SkuProductQueryParam;
import com.pzj.product.vo.voParam.queryParam.SpuProductForCommonsQueryParam;
import com.pzj.product.vo.voParam.queryParam.SpuProductQueryParamVO;
import com.pzj.product.vo.voParam.resultParam.PCAddressResult;
import com.pzj.product.vo.voParam.resultParam.SkuCanSaledResult;
import com.pzj.product.vo.voParam.resultParam.SkuImportResult;
import com.pzj.product.vo.voParam.resultParam.SkuProductForScenic;
import com.pzj.product.vo.voParam.resultParam.SkuProductResultVO;
import com.pzj.product.vo.voParam.resultParam.SpuProductResultVO;


public interface ISkuProductService {

    /**
     * 商品上架(SKU)
     * @param list 商品集合
     * @return
     */
	Result<SkuImportResult> importSku(List<JsonSkuDto> list);

    /**
     * 商品下架
     * @param idList 商品id集合
     * @return
     */
    Integer exportSku(List<Long> idList);
    
    /**
     * 商品下架
     * @param skuId 商品id
     * @return
     */
    Integer exportSku(Long skuId);

    
    /**
     * 1。新建产品组，产品信息，2。关联产品组与关闭时间事件关系，产品组与景区关系，产品组与景点关系，产品与场次区域关系
     * @param vo
     * @return
     * @throws Exception
     */
    Long addSpuProductAndAuth(SpuProductModificationVO vo) throws Exception;
    
    /**
     * 更新产品组，产品信息， 
     * 更新产品组与关闭时间事件的关系，产品组与景区关系，产品组与景点关系，产品与场次区域关系
     * @param vo
     * @return
     * @throws Exception
     */
    Integer saveSpuProductAndAuth(SpuProductModificationVO vo) ;
    
    
    /**
     * 根据产品组id更新产品组信息
     * @param vo
     * @return
     * @throws Exception
     */
    Integer saveSpuProduct(SpuProduct vo) throws Exception;

    /**
     * 根据产品id更新产品信息
     * @param vo
     * @return
     * @throws Exception
     */
    Integer saveSkuProduct(SkuProduct vo) throws Exception;

    /**
     * 根据产品组id更新产品信息
     * @param vo
     * @return
     * @throws Exception
     */
    Integer saveSkuProductByParentId(List<SkuProduct> vo) throws Exception;
    
    /**
     * 产品修改价格，原产品禁用，生成一个新产品
     * @param vo
     * @return 新产品id
     */
    Result<Long>  adjustPriceForSku(SkuPriceModificationVO vo);

    /**
     * 判断在某个时间点是否可买某个商品
     * 判断产品是否
     * @param param
     */
    List<SkuCanSaledResult> isCanSaled(List<ProductSaledParam> param) throws Exception;

    /**
     * 根据产品查询信息获取产品列表
     * @param queryParam
     * @return
     */
    List<SkuProduct> findSkuProductByParam(SkuProduct queryParam);

    /**
     * @author ： dongchf
     * @date   ： 2016年6月7日
     * 根据联票ID信息  查询相关子票信息
     */
    List<SkuProduct> findSubProByUnionId(Long unionId);

    /**
     * 查询分销商可买的app端产品列表
     *
     * @return
     * @throws Exception
     */
    List<SpuProductResultVO> findSkuProductForApp(SpuProductQueryParamVO vo) throws Exception;

    /**
     * 分页查询分销商可买的app端产品列表
     *
     * @return
     * @throws Exception
     */
    QueryPageList<SpuProductResultVO> findSkuProductForApp(SpuProductQueryParamVO vo,
                                                           QueryPageModel queryPageModel) throws Exception;

    /**
     * 根据产品id查询产品信息
     * @param id
     * @return
     * @throws Exception
     */
    SkuProductResultVO findSkuProductById(Long id) throws Exception;

    /**
     * 查询代供销可看的产品列表
     * @param vo
     * @return
     * @throws Exception
     */
    List<SkuProductResultVO> findSkuproductForSupplier(SkuProductQueryParam vo);

    /**
     * 分页查询代供销可看的产品列表
     * @param vo
     * @return
     * @throws Exception
     */
    QueryPageList<SkuProductResultVO> findSkuproductForSupplier(SkuProductQueryParam vo,
                                                                QueryPageModel queryPageModel);

    /**
     * 根据产品及产品组信息分页查询产品组列表
     * @param vo
     * @return
     * @throws Exception
     */
    QueryPageList<SpuProductResultVO> findSpuproductForSupplier(SkuProductQueryParam vo,
                                                                QueryPageModel queryPageModel);

    /**
     * 根据分销商查询分销商可看的省市
     * @param vo
     * @return
     */
    List<PCAddressResult> findSpuAddressByDistributorId(SpuProductQueryParamVO vo);

    /**
     * 根据SPU的id，查询spu信息。
     *
     * @param spuId
     * @return
     */
    Result<SpuProductResultVO> findSpuProductById(Long spuId);

    /**
     * 根据景区、分销商查询SKU景区产品
     * @param param
     * @return
     */
    Result<QueryPageList<SkuProductForScenic>> findSkuProductForScenic(SkuProductForScenicQuery param, QueryPageModel queryPageModel);

    /**
     * 根据景区、分销商查询SPU通用产品
     * @param param
     * @return
     */
    Result<QueryPageList<SpuProductResultVO>> findSpuProductForCommons(SpuProductForCommonsQueryParam param, QueryPageModel queryPageModel);
    
    /**
     * 初始化是否选座和是否一证一票
     * @param ids
     * @param isOneVote
     * @param isSelectSeat
     * @return
     */
    Boolean updateSkuInitInfo(List<Long> ids,Boolean isOneVote,Boolean isSelectSeat);

}
