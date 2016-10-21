/*
 * ProductCloseTimeslot.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.entity.product;


import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;
/**
 * vo.区域
 * @author 票之家
 */

public class ProductCloseTimeslot extends BaseEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3102871222357083450L;
	
	private static Comparator<ProductCloseTimeslot> pctimeslotComparator = null;
	
	
	
	/** 关闭时间点 */
    private Date colseDate;
    /** 关闭开始时间 */
    private Date startDate;
    /** 关闭结束时间 */
    private Date endDate;
    /** 产品组id */
    private Long productInfoId;
    /** 是否有效 */
    private Integer flag;
    /** 提供者id */
    private Long supplierId;
    /** 创建人 */
    private String createBy;
    /** 更新人 */
    private String updateBy;
    /** 创建时间 */
    private Date createDate;
    /** 更新时间 */
    private Date updateDate;
    /**
     * 用于查询，根据多个Id查询
     */
    private List<Long> ids;

    private List<Long> productInfoIds;
 
    /** 设置 关闭时间点 */
    public void setColseDate(Date colseDate) {
        this.colseDate = colseDate;
    }

    /** 得到 关闭时间点 */
    public Date getColseDate() {
        return colseDate;
    }
    /** 设置 关闭开始时间 */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /** 得到 关闭开始时间 */
    public Date getStartDate() {
        return startDate;
    }
    /** 设置 关闭结束时间 */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /** 得到 关闭结束时间 */
    public Date getEndDate() {
        return endDate;
    }
    /** 设置 产品组id */
    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }

    /** 得到 产品组id */
    public Long getProductInfoId() {
        return productInfoId;
    }
    /** 设置 是否有效 */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    /** 得到 是否有效 */
    public Integer getFlag() {
        return flag;
    }
    /** 设置 提供者id */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /** 得到 提供者id */
    public Long getSupplierId() {
        return supplierId;
    }
    /** 设置 创建人 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 得到 创建人 */
    public String getCreateBy() {
        return createBy;
    }
    /** 设置 更新人 */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /** 得到 更新人 */
    public String getUpdateBy() {
        return updateBy;
    }
    /** 设置 创建时间 */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /** 得到 创建时间 */
    public Date getCreateDate() {
        return createDate;
    }
    /** 设置 更新时间 */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /** 得到 更新时间 */
    public Date getUpdateDate() {
        return updateDate;
    }


    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }
    
    public static Comparator<ProductCloseTimeslot> getComparator(){
    	if(pctimeslotComparator == null){
    		pctimeslotComparator = new PCTimeslotComparator();
    	}
    	return pctimeslotComparator;
    }

    public List<Long> getProductInfoIds() {
        return productInfoIds;
    }

    public void setProductInfoIds(List<Long> productInfoIds) {
        this.productInfoIds = productInfoIds;
    }

    private static  class  PCTimeslotComparator   implements   Comparator<ProductCloseTimeslot>   {     	
    	
    	/**
    	 * 判断o1的日期大于o2的日期
    	 */
        public   int   compare(ProductCloseTimeslot   o1,   ProductCloseTimeslot   o2)   {     
          if(o1.getColseDate() == null) return -1;
          if(o2.getColseDate() == null) return -1;
          return   (o1.getColseDate().after(o2.getColseDate()))   ?   1   :   -1;     
        }  
    }
    
    
}
