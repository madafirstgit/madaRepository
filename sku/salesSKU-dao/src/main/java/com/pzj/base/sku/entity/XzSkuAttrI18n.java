package com.pzj.base.sku.entity;

public class XzSkuAttrI18n {

    private Integer id;

    private Integer bossid;

    private Integer skuAttrId;

    private String language;

    private String params;

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

    public Integer getSkuAttrId() {
        return skuAttrId;
    }

    public void setSkuAttrId(Integer skuAttrId) {
        this.skuAttrId = skuAttrId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
    
	@Override
	public String toString() {
		return "XzSkuAttrI18n [id=" + id + ", bossid=" + bossid + ", skuAttrId=" + skuAttrId + ", language=" + language
				+ ", params=" + params + "]";
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}
}