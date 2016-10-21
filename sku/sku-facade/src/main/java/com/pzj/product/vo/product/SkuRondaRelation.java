package com.pzj.product.vo.product;

import java.io.Serializable;

public class SkuRondaRelation implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3641816246739391260L;

    /** 场次id*/
    private Long              rondaId;

    /** 场次名称*/
    private String            rondaName;

    /** 区域id*/
    private Long              regionId;

    /** 区域名称*/
    private String            regionName;

    public Long getRondaId() {
        return rondaId;
    }

    public void setRondaId(Long rondaId) {
        this.rondaId = rondaId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRondaName() {
        return rondaName;
    }

    public void setRondaName(String rondaName) {
        this.rondaName = rondaName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

}
