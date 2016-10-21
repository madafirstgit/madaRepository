package com.pzj.product.vo.voParam.resultParam;

import com.pzj.channel.vo.resultParam.PCStrategyResult;
import com.pzj.product.vo.product.SkuCloseTimeSlot;
import com.pzj.product.vo.product.SkuProduct;
import com.pzj.product.vo.product.SpuProduct;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016-8-24.
 */
public class SkuProductForScenic implements Serializable {
    /**
     * SKU产品信息
     */
    private SkuProduct skuProduct;

    /**
     * SPU产品组信息
     */
    private SpuProduct spuProduct;

    /** 渠道，政策相关信息*/
    private List<PCStrategyResult> strategyList;

    public SkuProduct getSkuProduct() {
        return skuProduct;
    }

    public void setSkuProduct(SkuProduct skuProduct) {
        this.skuProduct = skuProduct;
    }

    public SpuProduct getSpuProduct() {
        return spuProduct;
    }

    public void setSpuProduct(SpuProduct spuProduct) {
        this.spuProduct = spuProduct;
    }

    public List<PCStrategyResult> getStrategyList() {
        return strategyList;
    }

    public void setStrategyList(List<PCStrategyResult> strategyList) {
        this.strategyList = strategyList;
    }

}
