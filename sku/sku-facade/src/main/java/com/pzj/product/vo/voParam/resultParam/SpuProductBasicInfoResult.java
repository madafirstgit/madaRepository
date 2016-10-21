package com.pzj.product.vo.voParam.resultParam;

import com.pzj.product.vo.product.SkuCloseTimeSlot;
import com.pzj.product.vo.product.SpuProduct;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016-8-24.
 */
public class SpuProductBasicInfoResult implements Serializable{

    /** SPU产品组信息*/
    private SpuProduct spuProduct;

    /**
     * SKU产品信息集合
     */
    private List<SkuProductBasicInfoResult> skuProductResultList;

    /** 产品关闭时间事件*/
    private List<SkuCloseTimeSlot> closeTimeSlotList;

    public SpuProduct getSpuProduct() {
        return spuProduct;
    }

    public void setSpuProduct(SpuProduct spuProduct) {
        this.spuProduct = spuProduct;
    }

    public List<SkuProductBasicInfoResult> getSkuProductResultList() {
        return skuProductResultList;
    }

    public void setSkuProductResultList(List<SkuProductBasicInfoResult> skuProductResultList) {
        this.skuProductResultList = skuProductResultList;
    }

    public List<SkuCloseTimeSlot> getCloseTimeSlotList() {
        return closeTimeSlotList;
    }

    public void setCloseTimeSlotList(List<SkuCloseTimeSlot> closeTimeSlotList) {
        this.closeTimeSlotList = closeTimeSlotList;
    }
}
