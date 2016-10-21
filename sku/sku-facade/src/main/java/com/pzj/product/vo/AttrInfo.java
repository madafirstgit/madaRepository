package com.pzj.product.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 产品属性信息
 * @author liyh <levart@163.com>
 * @version 20160426
 */
public class AttrInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer attrId;

    private Integer defaultValue;

    private Boolean hasPrice;

    private Boolean isDisplayRange;

    private Boolean isRequired;

    private String params;

    private BigDecimal price;

    private Short isGroup;

    private Integer minNumber;

    private Integer maxNumber;

    private Boolean display;
    private String  message;
    
    /** 是否是无限库存
     * 是：SkuProductGlobal.IS_UNLIMITED_INVENTORY
     * 否：SkuProductGlobal.IS_NOT_UNLIMITED_INVENTORY
     * */
    private Boolean                unlimitedInventory;
    
    /** 库存id */
    private Long                 stockRuleId;

    

    public Boolean getUnlimitedInventory() {
		return unlimitedInventory;
	}

	public void setUnlimitedInventory(Boolean unlimitedInventory) {
		this.unlimitedInventory = unlimitedInventory;
	}


	public Long getStockRuleId() {
		return stockRuleId;
	}

	public void setStockRuleId(Long stockRuleId) {
		this.stockRuleId = stockRuleId;
	}

	public Integer getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Integer defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Boolean getHasPrice() {
        return hasPrice;
    }

    public void setHasPrice(Boolean hasPrice) {
        this.hasPrice = hasPrice;
    }

    public Boolean getIsDisplayRange() {
        return isDisplayRange;
    }

    public void setIsDisplayRange(Boolean isDisplayRange) {
        this.isDisplayRange = isDisplayRange;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Short isGroup) {
        this.isGroup = isGroup;
    }

    public Integer getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(Integer minNumber) {
        this.minNumber = minNumber;
    }



    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attrId == null) ? 0 : attrId.hashCode());
		result = prime * result
				+ ((defaultValue == null) ? 0 : defaultValue.hashCode());
		result = prime * result + ((display == null) ? 0 : display.hashCode());
		result = prime * result
				+ ((hasPrice == null) ? 0 : hasPrice.hashCode());
		result = prime * result
				+ ((isDisplayRange == null) ? 0 : isDisplayRange.hashCode());
		result = prime * result + ((isGroup == null) ? 0 : isGroup.hashCode());
		result = prime * result
				+ ((isRequired == null) ? 0 : isRequired.hashCode());
		result = prime * result
				+ ((maxNumber == null) ? 0 : maxNumber.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result
				+ ((minNumber == null) ? 0 : minNumber.hashCode());
		result = prime * result + ((params == null) ? 0 : params.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttrInfo other = (AttrInfo) obj;
		if (attrId == null) {
			if (other.attrId != null)
				return false;
		} else if (!attrId.equals(other.attrId))
			return false;
		if (defaultValue == null) {
			if (other.defaultValue != null)
				return false;
		} else if (!defaultValue.equals(other.defaultValue))
			return false;
		if (display == null) {
			if (other.display != null)
				return false;
		} else if (!display.equals(other.display))
			return false;
		if (hasPrice == null) {
			if (other.hasPrice != null)
				return false;
		} else if (!hasPrice.equals(other.hasPrice))
			return false;
		if (isDisplayRange == null) {
			if (other.isDisplayRange != null)
				return false;
		} else if (!isDisplayRange.equals(other.isDisplayRange))
			return false;
		if (isGroup == null) {
			if (other.isGroup != null)
				return false;
		} else if (!isGroup.equals(other.isGroup))
			return false;
		if (isRequired == null) {
			if (other.isRequired != null)
				return false;
		} else if (!isRequired.equals(other.isRequired))
			return false;
		if (maxNumber == null) {
			if (other.maxNumber != null)
				return false;
		} else if (!maxNumber.equals(other.maxNumber))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (minNumber == null) {
			if (other.minNumber != null)
				return false;
		} else if (!minNumber.equals(other.minNumber))
			return false;
		if (params == null) {
			if (other.params != null)
				return false;
		} else if (!params.equals(other.params))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;

		return true;
	}
    
    
    
}
