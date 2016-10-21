package com.pzj.base.service.product;

import com.pzj.channel.SettlementRule;

import java.util.List;

/**
 * Created by Administrator on 2016-7-31.
 */
public interface ISettlementSearchService {
    /**
     *
     * @param params
     * @return
     */
    List<SettlementRule> findListByParams(SettlementRule params);

    /**
     * 根据多个产品id查询
     * @param productIds
     * @return
     */
    List<SettlementRule> findListByProductIds(List<Long> productIds);
}
