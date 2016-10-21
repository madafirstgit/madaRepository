/*
 * ProductStockRelation.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.entity.product;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;
/**
 * vo.区域
 * @author 票之家
 */

public class ProductStockRelation extends BaseEntity implements Serializable{
    /** 产品id */
    private Long productId;
    /** 产品组id */
    private Long productInfoId;
    /** 库存id */
    private Long stockRuleId;
    /** 是否有效（1：是，0：否） */
    private Integer flag;
    
    
    
 
    /** 设置 产品id */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /** 得到 产品id */
    public Long getProductId() {
        return productId;
    }
    /** 设置 产品组id */
    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }

    /** 得到 产品组id */
    public Long getProductInfoId() {
        return productInfoId;
    }
    
    
    
    public Long getStockRuleId() {
		return stockRuleId;
	}

	public void setStockRuleId(Long stockRuleId) {
		this.stockRuleId = stockRuleId;
	}

	/** 设置 是否有效（1：是，0：否） */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /** 得到 是否有效（1：是，0：否） */
    public Integer getFlag() {
        return flag;
    }

  
}
