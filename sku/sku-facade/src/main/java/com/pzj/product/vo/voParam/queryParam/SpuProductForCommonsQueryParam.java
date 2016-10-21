package com.pzj.product.vo.voParam.queryParam;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-8-24.
 */
public class SpuProductForCommonsQueryParam implements Serializable{

    /**
     * 分销商ID
     */
    private Long resellerId;

    /**
     * 销售端口
     */
    private String salesType;

    /**
     * SPU产品组查询条件
     */
    private SpuProductQuery spuProductQuery;

    private SkuProductQuery skuProductQuery;

    /**
     * 是否团票
     */
    private String ticketVarie;

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
    
    public SpuProductQuery getSpuProductQuery() {
		return spuProductQuery;
	}

	public void setSpuProductQuery(SpuProductQuery spuProductQuery) {
		this.spuProductQuery = spuProductQuery;
	}

	public String getTicketVarie() {
        return ticketVarie;
    }

    public void setTicketVarie(String ticketVarie) {
        this.ticketVarie = ticketVarie;
    }

    public SkuProductQuery getSkuProductQuery() {
        return skuProductQuery;
    }

    public void setSkuProductQuery(SkuProductQuery skuProductQuery) {
        this.skuProductQuery = skuProductQuery;
    }
}
