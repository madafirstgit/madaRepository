package com.pzj.base.service.impl.product;

import java.util.List;

import com.pzj.base.entity.product.ProductInfo;
import com.pzj.product.vo.voParam.resultParam.SpuProductBasicInfoResult;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.service.product.*;
import com.pzj.util.productConvertUtil.CommonConvert;
import com.pzj.util.productConvertUtil.StrategyConvert;

/**
 * Created by Administrator on 2016-8-1.
 */
@Service
public class ProductSearchServiceUtil {
    private Logger               logger = LoggerFactory.getLogger(StrategySearchServiceImpl.class);

    @Autowired
    IStrategySearchService       strategySearchService;

    @Autowired
    IProductScenicService        productScenicService;

    @Autowired
    IProductRelationService      productRelationService;

    @Autowired
    IProductInfoService productInfoService;

    IProductReleaseSearchService productReleaseSearchService;

    IProductReleaseService       productReleaseService;

    public List<Long> querySkuIdByDistributorId(Long distributorId,
                                                String saleType) throws Exception {
        return querySkuIdByDistributorId(distributorId, saleType, null, null);
    }

    public List<Long> querySkuIdByDistributorId(Long distributorId, String saleType,
                                                List<Long> channelIds,
                                                List<Long> productIds) throws Exception {
        if (distributorId == null) {
            return null;
        }

        //1.根据分销商id查询有效的渠道
        //2.查询渠道id对应的有效政策列表
        List<SysChannelStrategy> strategys = queryStrategyByD_C_P(distributorId, saleType,
            channelIds, productIds);

        //3.获取产品id集合
        List<Long> productIds1 = StrategyConvert.getProductIdsByStategys(strategys);

        return productIds1;

    }

    public List<SysChannelStrategy> queryStrategyByD_C_P(Long distributorId, String saleType,
                                                         List<Long> channelIds,
                                                         List<Long> productIds) throws Exception {

        //1.根据分销商id查询有效的渠道
        List<SysChannel> channels = strategySearchService.queryValidChannelsByUSid(distributorId,
            null, channelIds);

        //2.查询渠道id对应的有效政策列表
        List<SysChannelStrategy> strategys = strategySearchService
            .queryValidStrategysByCids(CommonConvert.getIdList(channels), saleType, productIds);

        return strategys;
    }

    /**
     * 通过产品组id查询产品组和产品
     * @param id
     * @return
     */
    public ProductInfo queryProductInfoAndReleaseByInfoId(Long id) {

        ProductInfo productInfoParam = new ProductInfo();
        productInfoParam.setId(id);
        List<ProductInfo> productInfoList = productInfoService.findProductInfoWithReleaseByParam(productInfoParam);
        if (CollectionUtils.isEmpty(productInfoList)) {
            return null;
        }

        ProductInfo productInfo = productInfoList.get(0);
        return productInfo;
    }
}
