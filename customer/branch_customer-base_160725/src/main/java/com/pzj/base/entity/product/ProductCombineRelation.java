/*
 * ProductCombineRelation.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity.product;

import java.io.Serializable;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * vo.组合产品和所包含的产品关系
 * 
 * @author 票之家
 */

public class ProductCombineRelation extends BaseEntity implements Serializable {

    /**
     * 
     */
    private static final long    serialVersionUID   = 1974781108233481193L;

    /** 组合产品id */
    private Long                 productId;

    private List<Long>           productIds;

    /**
     * 组合产品中包含的主产品对象
     *
     * 使用
     * 1.当关联查询主产品时，返回主产品信息。
     */
    private ProductRelease       product;

    private boolean              needProduct        = false;

    /** 组合产品中包含的产品id */
    private Long                 subProductId;

    /**
     * 组合产品中包含的子产品对象
     *
     * 使用：
     * 1.当关联查询子产品时，返回子产品信息。
     */
    private List<ProductRelease> subProduct;

    private boolean              needSubProduct     = false;

    private boolean              needSubProductInfo = false;

    /** 子票返利规则id */
    private Long                 rebateId;

    private String               supplierId;

    /** 设置 组合产品id */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /** 得到 组合产品id */
    public Long getProductId() {
        return productId;
    }

    /** 设置 组合产品中包含的产品id */
    public void setSubProductId(Long subProductId) {
        this.subProductId = subProductId;
    }

    /** 得到 组合产品中包含的产品id */
    public Long getSubProductId() {
        return subProductId;
    }

    /** 设置 子票返利规则id */
    public void setRebateId(Long rebateId) {
        this.rebateId = rebateId;
    }

    /** 得到 子票返利规则id */
    public Long getRebateId() {
        return rebateId;
    }

    /** supplierId */
    public String getSupplierId() {
        return supplierId;
    }

    /** supplierId */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("productId:").append(this.getProductId()).append(",");
        strBuff.append("subProductId:").append(this.getSubProductId()).append(",");
        strBuff.append("rebateId:").append(this.getRebateId());
        strBuff.append("}");
        return strBuff.toString();
    }

    public List<ProductRelease> getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(List<ProductRelease> subProduct) {
        this.subProduct = subProduct;
    }

    public ProductRelease getProduct() {
        return product;
    }

    public void setProduct(ProductRelease product) {
        this.product = product;
    }

    public boolean isNeedProduct() {
        return needProduct;
    }

    public void setNeedProduct(boolean needProduct) {
        this.needProduct = needProduct;
    }

    public boolean isNeedSubProduct() {
        return needSubProduct;
    }

    public void setNeedSubProduct(boolean needSubProduct) {
        this.needSubProduct = needSubProduct;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public boolean isNeedSubProductInfo() {
        return needSubProductInfo;
    }

    public void setNeedSubProductInfo(boolean needSubProductInfo) {
        this.needSubProductInfo = needSubProductInfo;
    }
}
