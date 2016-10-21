package com.pzj.util.productConvertUtil;

import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.channel.Strategy;
import com.pzj.framework.context.Result;
import com.pzj.product.vo.product.SpuProduct;
import com.pzj.product.vo.voParam.resultParam.SkuProductBasicInfoResult;
import com.pzj.product.vo.voParam.resultParam.SpuProductBasicInfoResult;
import com.pzj.util.MapListObjectUtil;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by Administrator on 2016-8-25.
 */
public class ProductSetValueUtil {
    public static SpuProductBasicInfoResult set(Result<SpuProductBasicInfoResult> result, SpuProductBasicInfoResult spuProductBasicInfoResult){
        result.setData(spuProductBasicInfoResult);
        return spuProductBasicInfoResult;
    }

    public static SpuProduct set(SpuProductBasicInfoResult spuProductBasicInfoResult, ProductInfo productInfo){
        SpuProduct spuProduct = ProductConvert.convertTSpuProduct(productInfo);
        spuProductBasicInfoResult.setSpuProduct(spuProduct);

        set(spuProductBasicInfoResult,  productInfo.getProductReleaseList());
        return spuProduct;
    }


    public static List<SkuProductBasicInfoResult> set(SpuProductBasicInfoResult spuProductBasicInfoResult, List<ProductRelease> productReleaseList){
        List<SkuProductBasicInfoResult> skuProductBasicInfoResultList = ProductConvert.convertTSkuProductBasicInfoResult(productReleaseList);
        spuProductBasicInfoResult.setSkuProductResultList(skuProductBasicInfoResultList);
        return skuProductBasicInfoResultList;
    }




    public static void setSysChannelStrategyToSkuProductBasicInfoResult(List<SkuProductBasicInfoResult> skuProductBasicInfoResultList, List<SysChannelStrategy> channelStrategyList){
        if (CollectionUtils.isEmpty(skuProductBasicInfoResultList)
                || CollectionUtils.isEmpty(channelStrategyList))
            return;

        MapListObjectUtil.ComposeConvert composeConvert = new MapListObjectUtil.ComposeConvert<SysChannelStrategy, Long, Strategy>(){
            public Long mapKey(SysChannelStrategy data){
                return data.getProductId();
            }

            public Strategy listValue(SysChannelStrategy data){
                Strategy strategy = StrategyConvert.convertTStrategy(data);
                return strategy;
            }
        };

        MapListObjectUtil.composeListObjcet(skuProductBasicInfoResultList, channelStrategyList, composeConvert);
    }
}
