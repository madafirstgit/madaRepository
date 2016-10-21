package com.pzj.product.vo;

import java.io.Serializable;
import java.util.List;

import com.pzj.product.vo.product.SkuCloseTimeSlot;

public class JsonSkuDto implements Serializable {
    /**
     * 
     */
    private static final long    serialVersionUID = -3104715239126236299L;

    /** 基础信息*/
    private BaseInfo             baseInfo;
    
    /** 产品关闭时间事件*/
    private List<SkuCloseTimeSlot>  timeSlots;
       
    /** 产品参数*/
    private List<AttrInfo> attrInfos;
    


    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

  

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

 

	public List<SkuCloseTimeSlot> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<SkuCloseTimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}

	public List<AttrInfo> getAttrInfos() {
		return attrInfos;
	}

	public void setAttrInfos(List<AttrInfo> attrInfos) {
		this.attrInfos = attrInfos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attrInfos == null) ? 0 : attrInfos.hashCode());
		result = prime * result
				+ ((baseInfo == null) ? 0 : baseInfo.hashCode());

		result = prime * result
				+ ((timeSlots == null) ? 0 : timeSlots.hashCode());

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
		JsonSkuDto other = (JsonSkuDto) obj;
		if (attrInfos == null) {
			if (other.attrInfos != null)
				return false;
		} else if (!attrInfos.equals(other.attrInfos))
			return false;
		if (baseInfo == null) {
			if (other.baseInfo != null)
				return false;
		} else if (!baseInfo.equals(other.baseInfo))
			return false;

		if (timeSlots == null) {
			if (other.timeSlots != null)
				return false;
		} else if (!timeSlots.equals(other.timeSlots))
			return false;

		return true;
	}

}
