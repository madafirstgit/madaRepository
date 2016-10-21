package com.pzj.product.vo.product;

import java.io.Serializable;
import java.util.Date;

public class SkuScenic implements Serializable{
	
	private Long id;
	
	 /**
     * 编码（预留）
     */
    private String            code;

    /**
     * 供应商名称
     */
    private String            name;

    /**
     * 省
     */
    private String            province;

    /**
     * 市
     */
    private String            city;

    /**
     * 县
     */
    private String            county;

    /**
     * 景区等级（字典）
     */
    private Integer           grade;

    /**
     * 检票方式（字典）多选
     */
    private String            checkinType;

    /**
     * 地址
     */
    private String            address;

    /**
     * 演出场次，类型为剧场时用到
     */
    private String            showNum;

    /**
     * 剧场分区，类型为剧场时用到
     */
    private String            theaterZone;

    /**
     * 供应商介绍
     */
    private String            info;

    /**
     * 图片资料
     */
    private String            imgUrl;

    /**
     * 视频资料
     */
    private String            viewUrl;

    /**
     * 文字资料
     */
    private String            dataUrl;

    private String            createBy;

    private Date              createDate;

    private String            updateBy;

    private Date              updateDate;

    /**
     * 排序
     */
    private Byte              sort;

    /**
     * 状态（1启用0禁用2删除）
     */
    private Integer           status;

    /**
     * 类型（1景区 2剧场）
     */
    private Integer           type;

    /** 所属平台 */
    private String            source;

    /** 所属供应商id */
    private String            supplierId;


    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getCheckinType() {
        return checkinType;
    }

    public void setCheckinType(String checkinType) {
        this.checkinType = checkinType == null ? null : checkinType.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getShowNum() {
        return showNum;
    }

    public void setShowNum(String showNum) {
        this.showNum = showNum == null ? null : showNum.trim();
    }

    public String getTheaterZone() {
        return theaterZone;
    }

    public void setTheaterZone(String theaterZone) {
        this.theaterZone = theaterZone == null ? null : theaterZone.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getViewUrl() {
        return viewUrl;
    }

    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl == null ? null : viewUrl.trim();
    }

    public String getDataUrl() {
        return dataUrl;
    }

    public void setDataUrl(String dataUrl) {
        this.dataUrl = dataUrl == null ? null : dataUrl.trim();
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

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    /** 所属供应商 */
    public String getSupplierId() {
        return supplierId;
    }

    /** 所属供应商 */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
    
    
}
