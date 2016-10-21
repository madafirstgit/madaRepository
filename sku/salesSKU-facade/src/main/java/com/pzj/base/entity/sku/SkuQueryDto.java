package com.pzj.base.entity.sku;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class SkuQueryDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bossid;

    private Integer categoryId;

    private String skuExtCode;

    private String supplierCode;

    private Integer inventory;

    private Boolean unlimitedInventory;

    private Boolean isSimple;

    private String allocation;

    private String visibility;

    private Integer maintenanceTime;

    private Integer aliasTo;

    private String pricePer;

    private String defaultCalendarStatus;

    private String skuParentChild;

    private BigDecimal startPrice;

    private BigDecimal pkgStartPrice;

    private String skuGrouping;

    private String listImage;

    private Integer sort;

    private Date createTime;

    private Date deleteTime;

    private Boolean isDeleted;

    private String skuTitle;

    private String summary;

    private String location;

    private String markerTitle;

    private String markerDescription;

    private String markerLinkText;

    private Integer mapZoom;

    private String language;

    private String emailNotification;

    private String moreInfoUrl;

    private String videoUrl;

    private String videoStartTime;

    private String details;

    private Integer skuStatus;

    private String keyword;

    protected int start = -1;

    protected int pageSize = -1;

    protected String orderByClause;

    protected boolean distinct;

    private Integer dateInventoryControl;

    public String getSkuParentChild() {
        return skuParentChild;
    }

    public void setSkuParentChild(String skuParentChild) {
        this.skuParentChild = skuParentChild;
    }

    public Integer getDateInventoryControl() {
        return dateInventoryControl;
    }

    public void setDateInventoryControl(Integer dateInventoryControl) {
        this.dateInventoryControl = dateInventoryControl;
    }

    public Integer getSkuStatus() {
        return skuStatus;
    }
    public void setSkuStatus(Integer skuStatus) {
        this.skuStatus = skuStatus;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBossid() {
        return bossid;
    }

    public void setBossid(Integer bossid) {
        this.bossid = bossid;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getSkuExtCode() {
        return skuExtCode;
    }

    public void setSkuExtCode(String skuExtCode) {
        this.skuExtCode = skuExtCode;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Boolean getUnlimitedInventory() {
        return unlimitedInventory;
    }

    public void setUnlimitedInventory(Boolean unlimitedInventory) {
        this.unlimitedInventory = unlimitedInventory;
    }

    public Boolean getSimple() {
        return isSimple;
    }

    public void setSimple(Boolean simple) {
        isSimple = simple;
    }

    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Integer getMaintenanceTime() {
        return maintenanceTime;
    }

    public void setMaintenanceTime(Integer maintenanceTime) {
        this.maintenanceTime = maintenanceTime;
    }

    public Integer getAliasTo() {
        return aliasTo;
    }

    public void setAliasTo(Integer aliasTo) {
        this.aliasTo = aliasTo;
    }

    public String getPricePer() {
        return pricePer;
    }

    public void setPricePer(String pricePer) {
        this.pricePer = pricePer;
    }

    public String getDefaultCalendarStatus() {
        return defaultCalendarStatus;
    }

    public void setDefaultCalendarStatus(String defaultCalendarStatus) {
        this.defaultCalendarStatus = defaultCalendarStatus;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public String getSkuGrouping() {
        return skuGrouping;
    }

    public BigDecimal getPkgStartPrice() {
        return pkgStartPrice;
    }

    public void setSkuGrouping(String skuGrouping) {
        this.skuGrouping = skuGrouping;
    }

    public void setPkgStartPrice(BigDecimal pkgStartPrice) {
        this.pkgStartPrice = pkgStartPrice;
    }

    public String getListImage() {
        return listImage;
    }

    public void setListImage(String listImage) {
        this.listImage = listImage;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getSkuTitle() {
        return skuTitle;
    }

    public void setSkuTitle(String skuTitle) {
        this.skuTitle = skuTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMarkerTitle() {
        return markerTitle;
    }

    public void setMarkerTitle(String markerTitle) {
        this.markerTitle = markerTitle;
    }

    public String getMarkerDescription() {
        return markerDescription;
    }

    public void setMarkerDescription(String markerDescription) {
        this.markerDescription = markerDescription;
    }

    public String getMarkerLinkText() {
        return markerLinkText;
    }

    public void setMarkerLinkText(String markerLinkText) {
        this.markerLinkText = markerLinkText;
    }

    public Integer getMapZoom() {
        return mapZoom;
    }

    public void setMapZoom(Integer mapZoom) {
        this.mapZoom = mapZoom;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(String emailNotification) {
        this.emailNotification = emailNotification;
    }

    public String getMoreInfoUrl() {
        return moreInfoUrl;
    }

    public void setMoreInfoUrl(String moreInfoUrl) {
        this.moreInfoUrl = moreInfoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoStartTime() {
        return videoStartTime;
    }

    public void setVideoStartTime(String videoStartTime) {
        this.videoStartTime = videoStartTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }
}
