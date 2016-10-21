package com.pzj.base.sku.entity;

public class XzSkuAttrApplyTo {

    private Integer id;

    private Integer bossid;

    private Integer skuId;

    private Integer skuAttrId;

    private Integer minNum;

    private Integer maxNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBossid() {
        return bossid;
    }

    public void setBossid(Integer bossid) {
        this.bossid = bossid;
    }

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
    }

    public Integer getSkuAttrId() {
        return skuAttrId;
    }

    public void setSkuAttrId(Integer skuAttrId) {
        this.skuAttrId = skuAttrId;
    }

    public Integer getMinNum() {
        return minNum;
    }

    public void setMinNum(Integer minNum) {
        this.minNum = minNum;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}

	@Override
	public String toString() {
		return "XzSkuAttrApplyTo [id=" + id + ", bossid=" + bossid + ", skuId=" + skuId + ", skuAttrId=" + skuAttrId
				+ ", minNum=" + minNum + ", maxNum=" + maxNum + "]";
	}
}