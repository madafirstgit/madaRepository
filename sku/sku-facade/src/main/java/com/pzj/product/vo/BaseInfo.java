package com.pzj.product.vo;

import java.io.Serializable;
import java.util.Date;

public class BaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Long bossid;
    
    private Integer bossid1;
    
    private String categoryId;
    
    private String skuExtCode;
    


    private Boolean isSimple;
    
    private String skuGrouping;

    private String coverImage;
    
    private String skuTitle;

    private String summary;
    
    private String emailNotification;
    
    private String moreInfoUrl;
    
    private String details;
    
    
    private String province;
    
    private String city;
    
    private String county;
    
    private Integer isNeedScenic;
    
    private Integer checkInType;
    
    private String checkinAddress;
    
    private Date startDate;
    
    private Date endDate;
    
    private String startTime;
    
    private String endTime;
    
    private Date saleStartDate;
    
    private Date saleEndDate;
    
    private Integer isNeedPlaytime;
    
    private Integer noPlaytimeOrdertimeType;
    
    private Integer ordertimeValue;
    
    private Integer ordertimeUnit;
    
    /** 一句话特色*/
	private String oneWordFeature;
	
	/** 预订须知*/
	private String orderInfo;
	
	/** 费用说明*/
	private String expenseInfo;
	
	/** 销售技巧*/
	private String salesmanship;
	
	/** 重要条款*/
	private String importantClause;
	
	/** 注意事项 */
	private String attentions;
	
	/** 使用方法*/
	private String userMethod;
	
	
	/** 产品图片列表*/
	private String imageList;
	
	/** 消费凭证类型
	 * 未凭证 SkuProductGlobal.CONSUMER_CARDTYPE_NO
     * 联系人信息  SkuProductGlobal.CONSUMER_CARDTYPE_CONTACTS
     * 魔方码  SkuProductGlobal.CONSUMER_CARDTYPE_MFOUTRCODE
     * */
    private Integer                consumerCardType;
    
 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
    public Long getBossid() {
		return bossid;
	}

	public void setBossid(Long bossid) {
		this.bossid = bossid;
	}

	

    public String getSkuExtCode() {
        return skuExtCode;
    }

    public void setSkuExtCode(String skuExtCode) {
        this.skuExtCode = skuExtCode == null ? null : skuExtCode.trim();
    }

    public Boolean getIsSimple() {
        return isSimple;
    }

    public void setIsSimple(Boolean isSimple) {
        this.isSimple = isSimple;
    }

 

    public String getSkuGrouping() {
        return skuGrouping;
    }

    public void setSkuGrouping(String skuGrouping) {
        this.skuGrouping = skuGrouping == null ? null : skuGrouping.trim();
    }


    public String getSkuTitle() {
        return skuTitle;
    }

    public void setSkuTitle(String skuTitle) {
        this.skuTitle = skuTitle == null ? null : skuTitle.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(String emailNotification) {
        this.emailNotification = emailNotification == null ? null : emailNotification.trim();
    }

    public String getMoreInfoUrl() {
        return moreInfoUrl;
    }

    public void setMoreInfoUrl(String moreInfoUrl) {
        this.moreInfoUrl = moreInfoUrl == null ? null : moreInfoUrl.trim();
    }

 
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
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


	public Integer getIsNeedScenic() {
		return isNeedScenic;
	}

	public void setIsNeedScenic(Integer isNeedScenic) {
		this.isNeedScenic = isNeedScenic;
	}

	public Integer getCheckInType() {
		return checkInType;
	}

	public void setCheckInType(Integer checkInType) {
		this.checkInType = checkInType;
	}

	public String getCheckinAddress() {
		return checkinAddress;
	}

	public void setCheckinAddress(String checkinAddress) {
		this.checkinAddress = checkinAddress;
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Date getSaleStartDate() {
		return saleStartDate;
	}

	public void setSaleStartDate(Date saleStartDate) {
		this.saleStartDate = saleStartDate;
	}

	public Date getSaleEndDate() {
		return saleEndDate;
	}

	public void setSaleEndDate(Date saleEndDate) {
		this.saleEndDate = saleEndDate;
	}

	public Integer getIsNeedPlaytime() {
		return isNeedPlaytime;
	}

	public void setIsNeedPlaytime(Integer isNeedPlaytime) {
		this.isNeedPlaytime = isNeedPlaytime;
	}

	public Integer getNoPlaytimeOrdertimeType() {
		return noPlaytimeOrdertimeType;
	}

	public void setNoPlaytimeOrdertimeType(Integer noPlaytimeOrdertimeType) {
		this.noPlaytimeOrdertimeType = noPlaytimeOrdertimeType;
	}

	public Integer getOrdertimeValue() {
		return ordertimeValue;
	}

	public void setOrdertimeValue(Integer ordertimeValue) {
		this.ordertimeValue = ordertimeValue;
	}

	public Integer getOrdertimeUnit() {
		return ordertimeUnit;
	}

	public void setOrdertimeUnit(Integer ordertimeUnit) {
		this.ordertimeUnit = ordertimeUnit;
	}

	public String getOneWordFeature() {
		return oneWordFeature;
	}

	public void setOneWordFeature(String oneWordFeature) {
		this.oneWordFeature = oneWordFeature;
	}

	public String getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}

	public String getExpenseInfo() {
		return expenseInfo;
	}

	public void setExpenseInfo(String expenseInfo) {
		this.expenseInfo = expenseInfo;
	}

	public String getSalesmanship() {
		return salesmanship;
	}

	public void setSalesmanship(String salesmanship) {
		this.salesmanship = salesmanship;
	}

	public String getImportantClause() {
		return importantClause;
	}

	public void setImportantClause(String importantClause) {
		this.importantClause = importantClause;
	}

	public String getAttentions() {
		return attentions;
	}

	public void setAttentions(String attentions) {
		this.attentions = attentions;
	}

	public String getUserMethod() {
		return userMethod;
	}

	public void setUserMethod(String userMethod) {
		this.userMethod = userMethod;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getImageList() {
		return imageList;
	}

	public void setImageList(String imageList) {
		this.imageList = imageList;
	}

	public Integer getBossid1() {
		return bossid1;
	}

	public void setBossid1(Integer bossid1) {
		this.bossid1 = bossid1;
	}
	
	

	public Integer getConsumerCardType() {
		return consumerCardType;
	}

	public void setConsumerCardType(Integer consumerCardType) {
		this.consumerCardType = consumerCardType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attentions == null) ? 0 : attentions.hashCode());
		result = prime * result + ((bossid == null) ? 0 : bossid.hashCode());
		result = prime * result + ((bossid1 == null) ? 0 : bossid1.hashCode());
		result = prime * result
				+ ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result
				+ ((checkInType == null) ? 0 : checkInType.hashCode());
		result = prime * result
				+ ((checkinAddress == null) ? 0 : checkinAddress.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime
				* result
				+ ((consumerCardType == null) ? 0 : consumerCardType.hashCode());
		result = prime * result + ((county == null) ? 0 : county.hashCode());
		result = prime * result
				+ ((coverImage == null) ? 0 : coverImage.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime
				* result
				+ ((emailNotification == null) ? 0 : emailNotification
						.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result
				+ ((expenseInfo == null) ? 0 : expenseInfo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((imageList == null) ? 0 : imageList.hashCode());
		result = prime * result
				+ ((importantClause == null) ? 0 : importantClause.hashCode());
		result = prime * result
				+ ((isNeedPlaytime == null) ? 0 : isNeedPlaytime.hashCode());
		result = prime * result
				+ ((isNeedScenic == null) ? 0 : isNeedScenic.hashCode());
		result = prime * result
				+ ((isSimple == null) ? 0 : isSimple.hashCode());
		result = prime * result
				+ ((moreInfoUrl == null) ? 0 : moreInfoUrl.hashCode());
		result = prime
				* result
				+ ((noPlaytimeOrdertimeType == null) ? 0
						: noPlaytimeOrdertimeType.hashCode());
		result = prime * result
				+ ((oneWordFeature == null) ? 0 : oneWordFeature.hashCode());
		result = prime * result
				+ ((orderInfo == null) ? 0 : orderInfo.hashCode());
		result = prime * result
				+ ((ordertimeUnit == null) ? 0 : ordertimeUnit.hashCode());
		result = prime * result
				+ ((ordertimeValue == null) ? 0 : ordertimeValue.hashCode());
		result = prime * result
				+ ((province == null) ? 0 : province.hashCode());
		result = prime * result
				+ ((saleEndDate == null) ? 0 : saleEndDate.hashCode());
		result = prime * result
				+ ((saleStartDate == null) ? 0 : saleStartDate.hashCode());
		result = prime * result
				+ ((salesmanship == null) ? 0 : salesmanship.hashCode());
		result = prime * result
				+ ((skuExtCode == null) ? 0 : skuExtCode.hashCode());
		result = prime * result
				+ ((skuGrouping == null) ? 0 : skuGrouping.hashCode());
		result = prime * result
				+ ((skuTitle == null) ? 0 : skuTitle.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result
				+ ((userMethod == null) ? 0 : userMethod.hashCode());
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
		BaseInfo other = (BaseInfo) obj;
		if (attentions == null) {
			if (other.attentions != null)
				return false;
		} else if (!attentions.equals(other.attentions))
			return false;
		if (bossid == null) {
			if (other.bossid != null)
				return false;
		} else if (!bossid.equals(other.bossid))
			return false;
		if (bossid1 == null) {
			if (other.bossid1 != null)
				return false;
		} else if (!bossid1.equals(other.bossid1))
			return false;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (checkInType == null) {
			if (other.checkInType != null)
				return false;
		} else if (!checkInType.equals(other.checkInType))
			return false;
		if (checkinAddress == null) {
			if (other.checkinAddress != null)
				return false;
		} else if (!checkinAddress.equals(other.checkinAddress))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (consumerCardType == null) {
			if (other.consumerCardType != null)
				return false;
		} else if (!consumerCardType.equals(other.consumerCardType))
			return false;
		if (county == null) {
			if (other.county != null)
				return false;
		} else if (!county.equals(other.county))
			return false;
		if (coverImage == null) {
			if (other.coverImage != null)
				return false;
		} else if (!coverImage.equals(other.coverImage))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (emailNotification == null) {
			if (other.emailNotification != null)
				return false;
		} else if (!emailNotification.equals(other.emailNotification))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (expenseInfo == null) {
			if (other.expenseInfo != null)
				return false;
		} else if (!expenseInfo.equals(other.expenseInfo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imageList == null) {
			if (other.imageList != null)
				return false;
		} else if (!imageList.equals(other.imageList))
			return false;
		if (importantClause == null) {
			if (other.importantClause != null)
				return false;
		} else if (!importantClause.equals(other.importantClause))
			return false;
		if (isNeedPlaytime == null) {
			if (other.isNeedPlaytime != null)
				return false;
		} else if (!isNeedPlaytime.equals(other.isNeedPlaytime))
			return false;
		if (isNeedScenic == null) {
			if (other.isNeedScenic != null)
				return false;
		} else if (!isNeedScenic.equals(other.isNeedScenic))
			return false;
		if (isSimple == null) {
			if (other.isSimple != null)
				return false;
		} else if (!isSimple.equals(other.isSimple))
			return false;
		if (moreInfoUrl == null) {
			if (other.moreInfoUrl != null)
				return false;
		} else if (!moreInfoUrl.equals(other.moreInfoUrl))
			return false;
		if (noPlaytimeOrdertimeType == null) {
			if (other.noPlaytimeOrdertimeType != null)
				return false;
		} else if (!noPlaytimeOrdertimeType
				.equals(other.noPlaytimeOrdertimeType))
			return false;
		if (oneWordFeature == null) {
			if (other.oneWordFeature != null)
				return false;
		} else if (!oneWordFeature.equals(other.oneWordFeature))
			return false;
		if (orderInfo == null) {
			if (other.orderInfo != null)
				return false;
		} else if (!orderInfo.equals(other.orderInfo))
			return false;
		if (ordertimeUnit == null) {
			if (other.ordertimeUnit != null)
				return false;
		} else if (!ordertimeUnit.equals(other.ordertimeUnit))
			return false;
		if (ordertimeValue == null) {
			if (other.ordertimeValue != null)
				return false;
		} else if (!ordertimeValue.equals(other.ordertimeValue))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (saleEndDate == null) {
			if (other.saleEndDate != null)
				return false;
		} else if (!saleEndDate.equals(other.saleEndDate))
			return false;
		if (saleStartDate == null) {
			if (other.saleStartDate != null)
				return false;
		} else if (!saleStartDate.equals(other.saleStartDate))
			return false;
		if (salesmanship == null) {
			if (other.salesmanship != null)
				return false;
		} else if (!salesmanship.equals(other.salesmanship))
			return false;
		if (skuExtCode == null) {
			if (other.skuExtCode != null)
				return false;
		} else if (!skuExtCode.equals(other.skuExtCode))
			return false;
		if (skuGrouping == null) {
			if (other.skuGrouping != null)
				return false;
		} else if (!skuGrouping.equals(other.skuGrouping))
			return false;
		if (skuTitle == null) {
			if (other.skuTitle != null)
				return false;
		} else if (!skuTitle.equals(other.skuTitle))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (userMethod == null) {
			if (other.userMethod != null)
				return false;
		} else if (!userMethod.equals(other.userMethod))
			return false;
		return true;
	}

	
    
}