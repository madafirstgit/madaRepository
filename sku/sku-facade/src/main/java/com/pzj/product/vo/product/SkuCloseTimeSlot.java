package com.pzj.product.vo.product;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SkuCloseTimeSlot implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -8455832128705886971L;

    /** */
    private Long              id;

    /** 关闭时间点*/
    private Date              colseDate;

    /** 关闭开始时间*/
    private Date              startDate;

    /** 关闭结束时间*/
    private Date              endDate;

    /** 产品组id*/
    private Long              productInfoId;

    /** 是否有效*/
    private Integer           flag;

    /** 提供者id*/
    private Long              supplierId;

    /** 创建人*/
    private String            createBy;

    /** 更新人*/
    private String            updateBy;

    /** 创建时间*/
    private Date              createDate;

    /** 更新时间*/
    private Date              updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getColseDate() {
        return colseDate;
    }

    public void setColseDate(Date colseDate) {
        this.colseDate = colseDate;
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

    public Long getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Long productInfoId) {
        this.productInfoId = productInfoId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((colseDate == null) ? 0 : colseDate.hashCode());
        result = prime * result + ((createBy == null) ? 0 : createBy.hashCode());
        result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((flag == null) ? 0 : flag.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((productInfoId == null) ? 0 : productInfoId.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        result = prime * result + ((supplierId == null) ? 0 : supplierId.hashCode());
        result = prime * result + ((updateBy == null) ? 0 : updateBy.hashCode());
        result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
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
        SkuCloseTimeSlot other = (SkuCloseTimeSlot) obj;
        if (colseDate == null) {
            if (other.colseDate != null)
                return false;
        } else if (!colseDate.equals(other.colseDate))
            return false;
        if (createBy == null) {
            if (other.createBy != null)
                return false;
        } else if (!createBy.equals(other.createBy))
            return false;
        if (createDate == null) {
            if (other.createDate != null)
                return false;
        } else if (!createDate.equals(other.createDate))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (flag == null) {
            if (other.flag != null)
                return false;
        } else if (!flag.equals(other.flag))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (productInfoId == null) {
            if (other.productInfoId != null)
                return false;
        } else if (!productInfoId.equals(other.productInfoId))
            return false;
        if (startDate == null) {
            if (other.startDate != null)
                return false;
        } else if (!startDate.equals(other.startDate))
            return false;
        if (supplierId == null) {
            if (other.supplierId != null)
                return false;
        } else if (!supplierId.equals(other.supplierId))
            return false;
        if (updateBy == null) {
            if (other.updateBy != null)
                return false;
        } else if (!updateBy.equals(other.updateBy))
            return false;
        if (updateDate == null) {
            if (other.updateDate != null)
                return false;
        } else if (!updateDate.equals(other.updateDate))
            return false;
        return true;
    }

}
