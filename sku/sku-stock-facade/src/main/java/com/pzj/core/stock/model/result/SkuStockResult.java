package com.pzj.core.stock.model.result;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class SkuStockResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2854368709185203340L;
	
	
	/**产品id*/
	private Long productId;
	
	/**产品组id*/
	private Long productInfoId;
		
	/**产品可用日期:开始时间*/
	private Date startDate;
	
	/**产品可用日期:结束时间*/
	private Date endDate;
	
    /** 产品关闭时间事件集合*/
    private List<Date>         closeTimeSlots;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Date> getCloseTimeSlots() {
		return closeTimeSlots;
	}

	public void setCloseTimeSlots(List<Date> closeTimeSlots) {
		this.closeTimeSlots = closeTimeSlots;
	}

	public Long getProductInfoId() {
		return productInfoId;
	}

	public void setProductInfoId(Long productInfoId) {
		this.productInfoId = productInfoId;
	}

}
