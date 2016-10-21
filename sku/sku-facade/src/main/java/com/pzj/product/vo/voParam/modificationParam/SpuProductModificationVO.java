package com.pzj.product.vo.voParam.modificationParam;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.pzj.product.vo.product.SkuCloseTimeSlot;
import com.pzj.product.vo.product.SkuSiteRelation;
import com.pzj.product.vo.product.SpuProduct;

public class SpuProductModificationVO implements Serializable {

    private static final long              serialVersionUID = -2516579269273632639L;

    /** 产品组信息*/
    private SpuProduct                     productInfo;

    /** 产品信息集合*/
    private List<SkuProductModificationVO> skuProducts;

    /** 关闭时间事件集合*/
    private List<SkuCloseTimeSlot>         closeTimeSlotIds;

    /** 景区id集合*/
    private List<Long>                     scenicIds;

    /** 产品组与景点关系集合*/
    private List<SkuSiteRelation>          siteDataRelations;

    public SpuProduct getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(SpuProduct productInfo) {
        this.productInfo = productInfo;
    }

    public List<SkuProductModificationVO> getSkuProducts() {
        return skuProducts;
    }

    public void setSkuProducts(List<SkuProductModificationVO> skuProducts) {
        this.skuProducts = skuProducts;
    }

    public List<SkuCloseTimeSlot> getCloseTimeSlotIds() {
        return closeTimeSlotIds;
    }

    public void setCloseTimeSlotIds(List<SkuCloseTimeSlot> closeTimeSlotIds) {
        this.closeTimeSlotIds = closeTimeSlotIds;
    }

    public List<Long> getScenicIds() {
        return scenicIds;
    }

    public void setScenicIds(List<Long> scenicIds) {
        this.scenicIds = scenicIds;
    }

    public List<SkuSiteRelation> getSiteDataRelations() {
        return siteDataRelations;
    }

    public void setSiteDataRelations(List<SkuSiteRelation> siteDataRelations) {
        this.siteDataRelations = siteDataRelations;
    }

    public boolean isSpuExist() {
        return productInfo != null;
    }

    public boolean isSkuExist() {
        return this.skuProducts != null && !this.skuProducts.isEmpty();
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
