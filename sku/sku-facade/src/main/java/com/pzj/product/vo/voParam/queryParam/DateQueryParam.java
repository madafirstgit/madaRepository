package com.pzj.product.vo.voParam.queryParam;

import java.io.Serializable;
import java.util.Date;

public class DateQueryParam implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5584589584747642952L;

    /**查询时间段：开始时间*/
    private Date              startDate;

    /**查询时间段：结束时间*/
    private Date              endDate;

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

}
