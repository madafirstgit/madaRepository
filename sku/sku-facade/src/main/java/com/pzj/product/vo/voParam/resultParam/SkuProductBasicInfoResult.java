package com.pzj.product.vo.voParam.resultParam;

import com.pzj.channel.Strategy;
import com.pzj.product.vo.ListObject;
import com.pzj.product.vo.MapObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016-8-24.
 */
public class SkuProductBasicInfoResult implements Serializable, MapObject<Long, SkuProductBasicInfoResult>, ListObject<Strategy>  {

    /**
     * SKU产品
     */
    private SkuProductBasicInfo skuProduct;

    /**
     * 政策信息
     */
    private List<Strategy> strategyList;

    public SkuProductBasicInfo getSkuProduct() {
        return skuProduct;
    }

    public void setSkuProduct(SkuProductBasicInfo skuProduct) {
        this.skuProduct = skuProduct;
    }

    public List<Strategy> getStrategyList() {
        return strategyList;
    }

    public void setStrategyList(List<Strategy> strategyList) {
        this.strategyList = strategyList;
    }

    @Override
    public Long key() {
        if (skuProduct != null)
            return skuProduct.getId();
        return null;
    }

    @Override
    public SkuProductBasicInfoResult value() {
        return this;
    }

    @Override
    public List<Strategy> dataList() {
        return getStrategyList();
    }

    @Override
    public void dataList(List<Strategy> dataList) {
        setStrategyList(dataList);
    }
}
