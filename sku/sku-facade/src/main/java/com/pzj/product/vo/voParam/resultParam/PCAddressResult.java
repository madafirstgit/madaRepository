package com.pzj.product.vo.voParam.resultParam;

import java.io.Serializable;

public class PCAddressResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -9106596899492999000L;

    /**
     * 省
     */
    private String            province;

    /**
     * 市
     */
    private String            city;
    
    public PCAddressResult(){}
    
    public PCAddressResult(String province, String city){
    	this.province = province;
    	this.city = city;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((province == null) ? 0 : province.hashCode());
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
		PCAddressResult other = (PCAddressResult) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		return true;
	}

}
