package com.pzj.base.entity.sku;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class XzSkuDto implements Serializable {

    /**
     * 
     */
    private static final long                serialVersionUID = -1753544653209053143L;

    private Integer                          id;

    private Integer                          bossid;

    private Integer                          categoryId;

    private String                           skuExtCode;

    private String                           supplierCode;

    private Integer                          inventory;

    private Boolean                          unlimitedInventory;

    private Boolean                          isSimple;

    private String                           allocation;

    private String                           visibility;

    private Integer                          maintenanceTime;

    private Integer                          aliasTo;

    private String                           pricePer;

    private String                           defaultCalendarStatus;

    private BigDecimal                       startPrice;

    private BigDecimal                       pkgStartPrice;

    private String                           skuGrouping;

    private String                           skuParentChild;

    private String                           listImage;

    private Integer                          sort;

    private Integer                          skuStatus;

    private Date                             createTime;

    private Date                             deleteTime;

    private Boolean                          isDeleted;

    private Integer                          dateInventoryControl;

    private XzSkuI18nDto                     xzSkuI18nDto;

    private List<XzSkuAttrApplyToDto>        xzSkuAttrApplyToDtos;

    private XzSkuAllocationDto               xzSkuAllocationDto;

    private List<XzSkuPriceBaseDto>          xzSkuPriceBaseDtos;

    private List<XzSkuPriceEventApplyToDto>  xzSkuPriceEventApplyToDtos;

    private List<XzSkuImageDto>              xzSkuImageDtos;

    private List<XzSkuPkgDto>                xzSkuPkgDtos;

    private List<XzSkuPriceEventNewPriceDto> xzSkuPriceEventNewPriceDtos;

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
        this.skuExtCode = skuExtCode == null ? null : skuExtCode.trim();
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode == null ? null : supplierCode.trim();
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

    public Boolean getIsSimple() {
        return isSimple;
    }

    public void setIsSimple(Boolean isSimple) {
        this.isSimple = isSimple;
    }

    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation == null ? null : allocation.trim();
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility == null ? null : visibility.trim();
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
        this.pricePer = pricePer == null ? null : pricePer.trim();
    }

    public String getDefaultCalendarStatus() {
        return defaultCalendarStatus;
    }

    public void setDefaultCalendarStatus(String defaultCalendarStatus) {
        this.defaultCalendarStatus = defaultCalendarStatus == null ? null : defaultCalendarStatus
            .trim();
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getPkgStartPrice() {
        return pkgStartPrice;
    }

    public void setPkgStartPrice(BigDecimal pkgStartPrice) {
        this.pkgStartPrice = pkgStartPrice;
    }

    public String getSkuGrouping() {
        return skuGrouping;
    }

    public void setSkuGrouping(String skuGrouping) {
        this.skuGrouping = skuGrouping;
    }

    public String getSkuParentChild() {
        return skuParentChild;
    }

    public void setSkuParentChild(String skuParentChild) {
        this.skuParentChild = skuParentChild;
    }

    public String getListImage() {
        return listImage;
    }

    public void setListImage(String listImage) {
        this.listImage = listImage == null ? null : listImage.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSkuStatus() {
        return skuStatus;
    }

    public void setSkuStatus(Integer skuStatus) {
        this.skuStatus = skuStatus;
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

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getDateInventoryControl() {
        return dateInventoryControl;
    }

    public void setDateInventoryControl(Integer dateInventoryControl) {
        this.dateInventoryControl = dateInventoryControl;
    }

    public List<XzSkuAttrApplyToDto> getXzSkuAttrApplyToDtos() {
        return xzSkuAttrApplyToDtos;
    }

    public void setXzSkuAttrApplyToDtos(List<XzSkuAttrApplyToDto> xzSkuAttrApplyToDtos) {
        this.xzSkuAttrApplyToDtos = xzSkuAttrApplyToDtos;
    }

    public XzSkuAllocationDto getXzSkuAllocationDto() {
        return xzSkuAllocationDto;
    }

    public void setXzSkuAllocationDto(XzSkuAllocationDto xzSkuAllocationDto) {
        this.xzSkuAllocationDto = xzSkuAllocationDto;
    }

    public List<XzSkuPriceBaseDto> getXzSkuPriceBaseDtos() {
        return xzSkuPriceBaseDtos;
    }

    public void setXzSkuPriceBaseDtos(List<XzSkuPriceBaseDto> xzSkuPriceBaseDtos) {
        this.xzSkuPriceBaseDtos = xzSkuPriceBaseDtos;
    }

    public XzSkuI18nDto getXzSkuI18nDto() {
        return xzSkuI18nDto;
    }

    public void setXzSkuI18nDto(XzSkuI18nDto xzSkuI18nDto) {
        this.xzSkuI18nDto = xzSkuI18nDto;
    }

    public List<XzSkuPriceEventApplyToDto> getXzSkuPriceEventApplyToDtos() {
        return xzSkuPriceEventApplyToDtos;
    }

    public void setXzSkuPriceEventApplyToDtos(List<XzSkuPriceEventApplyToDto> xzSkuPriceEventApplyToDtos) {
        this.xzSkuPriceEventApplyToDtos = xzSkuPriceEventApplyToDtos;
    }

    public List<XzSkuImageDto> getXzSkuImageDtos() {
        return xzSkuImageDtos;
    }

    public void setXzSkuImageDtos(List<XzSkuImageDto> xzSkuImageDtos) {
        this.xzSkuImageDtos = xzSkuImageDtos;
    }

    public List<XzSkuPkgDto> getXzSkuPkgDtos() {
        return xzSkuPkgDtos;
    }

    public void setXzSkuPkgDtos(List<XzSkuPkgDto> xzSkuPkgDtos) {
        this.xzSkuPkgDtos = xzSkuPkgDtos;
    }

    public List<XzSkuPriceEventNewPriceDto> getXzSkuPriceEventNewPriceDtos() {
        return xzSkuPriceEventNewPriceDtos;
    }

    public void setXzSkuPriceEventNewPriceDtos(List<XzSkuPriceEventNewPriceDto> xzSkuPriceEventNewPriceDtos) {
        this.xzSkuPriceEventNewPriceDtos = xzSkuPriceEventNewPriceDtos;
    }
}