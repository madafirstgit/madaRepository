package com.pzj.product.vo.voParam.queryParam;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-8-24.
 */
public class SkuProductForScenicQuery implements Serializable {
    /**
     * 景区ID
     */
    private Long scenicId;

    /**
     * 分销商ID
     */
    private Long resellerId;

    /**
     * 销售端口
     */
    private String salesType;

    /**
     * 是否团票
     */
    private String ticketVarie;
    
    
    /**
     * 产品的信息查询参数
     */
    private SkuProductQuery queryParam;
    
    

    public Long getScenicId() {
        return scenicId;
    }

    public void setScenicId(Long scenicId) {
        this.scenicId = scenicId;
    }

    public String getSalesType() {
        return salesType;
    }

    public void setSalesType(String salesType) {
        this.salesType = salesType;
    }

    public Long getResellerId() {
        return resellerId;
    }

    public void setResellerId(Long resellerId) {
        this.resellerId = resellerId;
    }

    public String getTicketVarie() {
        return ticketVarie;
    }

    public void setTicketVarie(String ticketVarie) {
        this.ticketVarie = ticketVarie;
    }

	public SkuProductQuery getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(SkuProductQuery queryParam) {
		this.queryParam = queryParam;
	}
    
    
    
}
