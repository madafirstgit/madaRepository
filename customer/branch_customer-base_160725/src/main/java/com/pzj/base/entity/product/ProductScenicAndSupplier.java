package com.pzj.base.entity.product;

import java.io.Serializable;

/**
 * 由于景区与供应商是多对多关联，所以由此类保存其中一个景区
 * Created by Administrator on 2015-12-18.
 */
public class ProductScenicAndSupplier implements Serializable {
    private Long    productId;
    private Long    supplierId;
    private Long    scenicId;
    private Integer scenicCnt;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getScenicId() {
        return scenicId;
    }

    public void setScenicId(Long scenicId) {
        this.scenicId = scenicId;
    }

    public Integer getScenicCnt() {
        return scenicCnt;
    }

    public void setScenicCnt(Integer scenicCnt) {
        this.scenicCnt = scenicCnt;
    }
}
