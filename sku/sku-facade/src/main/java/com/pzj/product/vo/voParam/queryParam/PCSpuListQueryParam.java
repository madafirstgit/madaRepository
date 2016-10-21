package com.pzj.product.vo.voParam.queryParam;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class PCSpuListQueryParam implements Serializable {

    /** 产品组查询参数*/
    private SpuProductQuery   spuProductParam;

    /**产品查询参数*/
    private SkuProductQuery   skuProductParam;

    /** 分销商id*/
    private Long              distributorId;

    /** 销售端口*/
    private String            salesType;
    
    /** 票型value
     *  SkuProductGlobal.SCATTER_TICKET_VARIE 散票
     *  SkuProductGlobal.GROUP_TICKET_VARIE   团票
     * 
     * */
    private String            ticketVarie;   
   

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


	public String getTicketVarie() {
		return ticketVarie;
	}

	public void setTicketVarie(String ticketVarie) {
		this.ticketVarie = ticketVarie;
	}

	public Boolean isHaveDistributorId(){
    	if(this.getDistributorId() == null){
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
    
    
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
