package com.pzj.product.vo.voParam.resultParam;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.pzj.channel.vo.resultParam.PCStrategyResult;
import com.pzj.product.vo.product.*;

public class SkuProductResultVO implements Serializable {

    /**
     * 
     */
    private static final long      serialVersionUID = -5109117449075068232L;

    /** 产品信息*/
    private SkuProduct             skuProduct;

    /** 产品组信息*/
    private SpuProduct             spuProduct;

    /** 产品景区*/
    private List<SkuProductScenic> scenic;

    /** 产品景点*/
    private List<SkuSiteData>      siteDateList;

    /** 产品场次区域关系*/
    private List<SkuRondaRelation> rondaRelationList;

    /** 产品关闭时间事件*/
    private List<SkuCloseTimeSlot> closeTimeSlotList;

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

    public List<SkuProductScenic> getScenic() {
        return scenic;
    }

    public void setScenic(List<SkuProductScenic> scenic) {
        this.scenic = scenic;
    }

    public List<SkuSiteData> getSiteDateList() {
        return siteDateList;
    }

    public void setSiteDateList(List<SkuSiteData> siteDateList) {
        this.siteDateList = siteDateList;
    }

    public List<SkuRondaRelation> getRondaRelationList() {
        return rondaRelationList;
    }

    public void setRondaRelationList(List<SkuRondaRelation> rondaRelationList) {
        this.rondaRelationList = rondaRelationList;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public List<SkuCloseTimeSlot> getCloseTimeSlotList() {
        return closeTimeSlotList;
    }

    public void setCloseTimeSlotList(List<SkuCloseTimeSlot> closeTimeSlotList) {
        this.closeTimeSlotList = closeTimeSlotList;
    }

}
