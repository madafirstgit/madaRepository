/*
 * ProductSiteData.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-30 created
 */
package com.pzj.base.entity.product;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * 点位表包含：检票点，检票点设备，售票点 票之家公司 ----------------------* 2015-09-30created
 */
public class ProductSiteData extends BaseEntity implements Serializable {
	
	/**
	 * id集合，扩展属性
	 */
	private List<Long> ids;

    /**
     * 状态集合，扩展属性
     */
    private List<String>      statusList;

    /**
     * 点位名称
     */
    private String            sdName;

    /**
     * 点位名称集合，只用作查询
     */
    private List<String>      nameList;

    /**
     * 检票使用次数
     */
    private Integer           checkCount;

    /**
     * 设备编号
     */
    private String            equipmentCode;

    /**
     * 设备key
     */
    private String            equipmentKey;

    private String            createBy;

    /**
     * 创建时间
     */
    private Date              createDate;

    private String            updateBy;

    /**
     * 修改时间
     */
    private Date              updateDate;

    /**
     * 排序
     */
    private Integer           sort;

    /**
     * 状态
     */
    private String            sdFlag;

    /**
     * 点位信息
     */
    private String            sdInfo;

    /**
     * 检票设备类型 1手持设备 2台式设备 3闸机
     */
    private String            type;

    /**
     * 数据类型 1检票点 2售票点 3检票设备
     */
    private String            dataType;

    /**
     * 表示所属景区
     */
    private String            belong;

    /**
     * 父对象id,只有检票设备用到，保存的是检票点id
     */
    private Long              parentId;

    /** 景区名称，不做业务处理，只做查询 */
    private String            scenicName;

    /** 景区id */
    private Long              scenicId;

    /** 景区类型 */
    private Integer           scenicType;

    /** 供应商id */
    private Long              supplierId;

    /** 景区id集合，只做为查询条件使用 */
    private List<Long>        scenicIdList;

    /**
     * 景区入口
     */
    private String            jqrkName;

    /**
     * 景区入口id
     */
    private Long              jqrkId;

    /**
     * 缆车票标示
     */
    private Integer           subsidiaryType;

    private static final long serialVersionUID = 1L;

    public String getSdName() {
        return sdName;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName == null ? null : sdName.trim();
    }

    public Integer getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(Integer checkCount) {
        this.checkCount = checkCount;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode == null ? null : equipmentCode.trim();
    }

    public String getEquipmentKey() {
        return equipmentKey;
    }

    public void setEquipmentKey(String equipmentKey) {
        this.equipmentKey = equipmentKey == null ? null : equipmentKey.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getSdFlag() {
        return sdFlag;
    }

    public void setSdFlag(String sdFlag) {
        this.sdFlag = sdFlag == null ? null : sdFlag.trim();
    }

    public String getSdInfo() {
        return sdInfo;
    }

    public void setSdInfo(String sdInfo) {
        this.sdInfo = sdInfo == null ? null : sdInfo.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String datatype) {
        this.dataType = datatype == null ? null : datatype.trim();
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName;
    }

    public Long getScenicId() {
        return scenicId;
    }

    public void setScenicId(Long scenicId) {
        this.scenicId = scenicId;
    }

    /** 供应商id */
    public Long getSupplierId() {
        return supplierId;
    }

    /** 供应商id */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getScenicType() {
        return scenicType;
    }

    public void setScenicType(Integer scenicType) {
        this.scenicType = scenicType;
    }

    public List<Long> getScenicIdList() {
        return scenicIdList;
    }

    public void setScenicIdList(List<Long> scenicIdList) {
        this.scenicIdList = scenicIdList;
    }

    /** 状态集合，扩展属性 */
    public List<String> getStatusList() {
        return statusList;
    }

    /** 状态集合，扩展属性 */
    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public String getJqrkName() {
        return jqrkName;
    }

    public void setJqrkName(String jqrkName) {
        this.jqrkName = jqrkName;
    }

    public Long getJqrkId() {
        return jqrkId;
    }

    public void setJqrkId(Long jqrkId) {
        this.jqrkId = jqrkId;
    }

    public Integer getSubsidiaryType() {
        return subsidiaryType;
    }

    public void setSubsidiaryType(Integer subsidiaryType) {
        this.subsidiaryType = subsidiaryType;
    }

	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
    
    
    
}