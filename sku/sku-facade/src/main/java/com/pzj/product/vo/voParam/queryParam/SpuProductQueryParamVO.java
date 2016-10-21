package com.pzj.product.vo.voParam.queryParam;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

public class SpuProductQueryParamVO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3980027740413710307L;

    /** 产品组查询参数*/
    private SpuProductQuery   spuProductParam;

    /**产品查询参数*/
    private SkuProductQuery   skuProductParam;

    /** 分销商id*/
    private Long              distributorId;

    /** 销售端口*/
    private String            salesType;
    
    /** 团散*/
    private String           ticketVarie;
    

    /** app搜索查询参数*/
    private AppSearchQuery    appSearchQuery;

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

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType;
    }

    public AppSearchQuery getAppSearchQuery() {
        return appSearchQuery;
    }

    public void setAppSearchQuery(AppSearchQuery appSearchQuery) {
        this.appSearchQuery = appSearchQuery;
    }
    
    
    
    

    public String getTicketVarie() {
		return ticketVarie;
	}

	public void setTicketVarie(String ticketVarie) {
		this.ticketVarie = ticketVarie;
	}

	public String toString() {
		String str = "{" +
				"distributorId : " + this.getDistributorId()+
				"salesType :" + this.getSalesType()+
				"appSearchQuery : " + ToStringBuilder.reflectionToString(appSearchQuery)+
				"}";
        return str;
    }
    
    
    
    public Boolean isHaveDistributorId(){
    	if(this.getDistributorId() == null){
    		return false;
    	}
    	return true;
    			 
    }
    
    public Boolean isHaveSpuParam(){
    	if(this.getSpuProductParam() == null){
    		return false;
    	}
    	return true;
    			 
    }
    
    public Boolean isHaveSaleType(){
    	if(this.getSalesType() == null){
    		return false;
    	}
    	return true;
    }

}
