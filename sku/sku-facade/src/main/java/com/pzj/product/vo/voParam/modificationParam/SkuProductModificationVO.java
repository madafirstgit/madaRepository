package com.pzj.product.vo.voParam.modificationParam;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.pzj.product.vo.product.SkuProduct;
import com.pzj.product.vo.product.SkuRondaRelation;

public class SkuProductModificationVO implements Serializable {

    /**
     * 
     */
    private static final long      serialVersionUID = 8531852860797095919L;

    /** 产品信息*/
    private SkuProduct             skuProduct;

    /** 产品与场次区域关系*/
    private List<SkuRondaRelation> rondaRelations;

    public SkuProduct getSkuProduct() {
        return skuProduct;
    }

    public void setSkuProduct(SkuProduct skuProduct) {
        this.skuProduct = skuProduct;
    }

    public List<SkuRondaRelation> getRondaRelations() {
        return rondaRelations;
    }

    public void setRondaRelations(List<SkuRondaRelation> rondaRelations) {
        this.rondaRelations = rondaRelations;
    }

    public boolean isExistSku() {
        return skuProduct != null;
    }
    

    public boolean isExistSkuRondaRelation() {
        return rondaRelations != null;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
