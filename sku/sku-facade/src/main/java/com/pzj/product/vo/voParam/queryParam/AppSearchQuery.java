package com.pzj.product.vo.voParam.queryParam;

import java.io.Serializable;

public class AppSearchQuery implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 952059279284770620L;

	/** 关键字 */
	private String searchKey;

	/** 景区id */
	private Long id;
	/** 省 */
	private String province;

	/** 市 */
	private String city;

	/** 县 */
	private String county;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isNotHaveValue() {
		return isNotHaveSearchKey() && isNotHaveProvince()
				&& isNotHaveCity() && isNotHaveCounty() && (id == null);
	}
	
	public boolean isNotHaveSearchKey(){
		return searchKey == null || searchKey.isEmpty();
	}
	
	public boolean isNotHaveProvince(){
		return province == null || province.isEmpty();
	}
	public boolean isNotHaveCity(){
		return city == null || city.isEmpty();
	}
	
	public boolean isNotHaveCounty(){
		return county == null || county.isEmpty();
	}
	

}
