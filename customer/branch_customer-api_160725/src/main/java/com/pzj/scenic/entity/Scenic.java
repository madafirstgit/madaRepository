package com.pzj.scenic.entity;

import com.pzj.util.CommonEntity;

/**
 * 景区剧场信息类
 * 
 * @author zhangdianliang
 * 
 */
public class Scenic extends CommonEntity {
    /**
     * 景区名称
     */
    private String name;
    /**
     * 状态（1启用0禁用2删除）
     */
    private Integer status;
    /**
     * 类型（1景区 2剧场）
     */
    private Integer type;

    /**
     * 所属平台
     */
    //private String source;

    /** 所属供应商，只有查询时用到，当做查询条件 */
    private Long supplierId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /*public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }*/

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
