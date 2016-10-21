package com.pzj.base.service.impl.product;

import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.SysSpcreRelationKey;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.service.product.IStrategySearchService;
import com.pzj.util.productConvertUtil.CommonConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2016-8-25.
 */
@Component
public class StrategySearchServiceUtil {

    @Autowired
    private IStrategySearchService strategySearchService;

    public List<SysChannelStrategy> queryChannelStrategyBySpace(Long channelId, List<Long> productIds){
        SysSpcreRelationKey sysSpcreRelationKey = new SysSpcreRelationKey();
        sysSpcreRelationKey.setChannelId(channelId.toString());
        sysSpcreRelationKey.setQueryProductIds(productIds);

        List<SysChannelStrategy> channelStrategyList = strategySearchService.queryStratgyBySpace(null, sysSpcreRelationKey);
        return channelStrategyList;
    }

    public List<SysChannelStrategy> queryChannelStrategyBySpaceRelease(Long channelId, List<ProductRelease> productReleaseList){
        List<Long> productIds = CommonConvert.getIdList(productReleaseList);
        List<SysChannelStrategy> channelStrategyList = queryChannelStrategyBySpace(channelId, productIds);
        return channelStrategyList;
    }

    public List<SysChannelStrategy> queryChannelStrategyByIds(List<Long> ids){
        SysSpcreRelationKey sysSpcreRelationKey = new SysSpcreRelationKey();
        sysSpcreRelationKey.setQueryStrategyIds(ids);

        List<SysChannelStrategy> channelStrategyList = strategySearchService.queryStratgyBySpace(null, sysSpcreRelationKey);
        return channelStrategyList;
    }
}
