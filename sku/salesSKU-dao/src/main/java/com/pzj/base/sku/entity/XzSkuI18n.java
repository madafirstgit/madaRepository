package com.pzj.base.sku.entity;

public class XzSkuI18n {

    private Integer id;

    private Integer bossid;

    private Integer skuId;

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

    public Integer getSkuId() {
        return skuId;
    }

    public void setSkuId(Integer skuId) {
        this.skuId = skuId;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getMarkerTitle() {
        return markerTitle;
    }

    public void setMarkerTitle(String markerTitle) {
        this.markerTitle = markerTitle == null ? null : markerTitle.trim();
    }

    public String getMarkerDescription() {
        return markerDescription;
    }

    public void setMarkerDescription(String markerDescription) {
        this.markerDescription = markerDescription == null ? null : markerDescription.trim();
    }

    public String getMarkerLinkText() {
        return markerLinkText;
    }

    public void setMarkerLinkText(String markerLinkText) {
        this.markerLinkText = markerLinkText == null ? null : markerLinkText.trim();
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
        this.language = language == null ? null : language.trim();
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getVideoStartTime() {
        return videoStartTime;
    }

    public void setVideoStartTime(String videoStartTime) {
        this.videoStartTime = videoStartTime == null ? null : videoStartTime.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }
}