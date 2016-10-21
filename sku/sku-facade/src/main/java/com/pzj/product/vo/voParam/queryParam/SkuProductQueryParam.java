package com.pzj.product.vo.voParam.queryParam;

import java.io.Serializable;

public class SkuProductQueryParam implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 8344983888597319876L;

    /** 产品组查询参数*/
    private SpuProductQuery   spuProductParam;

    /**产品查询参数*/
    private SkuProductQuery   skuProductParam;

    public SpuProductQuery getSpuProductParam() {
        return spuProductParam;
    }

    public void setSpuProductParam(SpuProductQuery spuProductParam) {
        this.spuProductParam = spuProductParam;
    }

    public SkuProductQuery getSkuProductParam() {
        return skuProductParam;
    }

    public void setSkuProductParam(SkuProductQuery skuProductParam) {
        this.skuProductParam = skuProductParam;
    }

}
