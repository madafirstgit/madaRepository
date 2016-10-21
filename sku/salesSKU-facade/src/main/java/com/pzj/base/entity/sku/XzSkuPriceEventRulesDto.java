package com.pzj.base.entity.sku;

import java.io.Serializable;

public class XzSkuPriceEventRulesDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer bossid;

    private String rulesName;

    private Integer maxDuration;

    private Integer minDuration;

    private Integer maxBooking;

    private Integer minBooking;

    private Integer dayOfWeek;

    private Integer cutoff;

    private Integer overbookingAllowance;

    private Integer forwardBookingWindow;

    private Integer pastBookingWindow;

    private String maxMeony;

    private String minMoney;

    private String maxDurationApplyTo;

    private String minDurationApplyTo;

    private String maxBookingApplyTo;

    private String minBookingApplyTo;

    private String dayOfWeekApplyTo;

    private String cutoffApplyTo;

    private String overbookingAllowanceApplyTo;

    private String forwardBookingWindowApplyTo;

    private String pastBookingWindowApplyTo;

    private String maxMeonyApplyTo;

    private String minMoneyApplyTo;

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

    public String getRulesName() {
        return rulesName;
    }

    public void setRulesName(String rulesName) {
        this.rulesName = rulesName == null ? null : rulesName.trim();
    }

    public Integer getMaxDuration() {
        return maxDuration;
    }

    public void setMaxDuration(Integer maxDuration) {
        this.maxDuration = maxDuration;
    }

    public Integer getMinDuration() {
        return minDuration;
    }

    public void setMinDuration(Integer minDuration) {
        this.minDuration = minDuration;
    }

    public Integer getMaxBooking() {
        return maxBooking;
    }

    public void setMaxBooking(Integer maxBooking) {
        this.maxBooking = maxBooking;
    }

    public Integer getMinBooking() {
        return minBooking;
    }

    public void setMinBooking(Integer minBooking) {
        this.minBooking = minBooking;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getCutoff() {
        return cutoff;
    }

    public void setCutoff(Integer cutoff) {
        this.cutoff = cutoff;
    }

    public Integer getOverbookingAllowance() {
        return overbookingAllowance;
    }

    public void setOverbookingAllowance(Integer overbookingAllowance) {
        this.overbookingAllowance = overbookingAllowance;
    }

    public Integer getForwardBookingWindow() {
        return forwardBookingWindow;
    }

    public void setForwardBookingWindow(Integer forwardBookingWindow) {
        this.forwardBookingWindow = forwardBookingWindow;
    }

    public Integer getPastBookingWindow() {
        return pastBookingWindow;
    }

    public void setPastBookingWindow(Integer pastBookingWindow) {
        this.pastBookingWindow = pastBookingWindow;
    }

    public String getMaxMeony() {
        return maxMeony;
    }

    public void setMaxMeony(String maxMeony) {
        this.maxMeony = maxMeony == null ? null : maxMeony.trim();
    }

    public String getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(String minMoney) {
        this.minMoney = minMoney == null ? null : minMoney.trim();
    }

    public String getMaxDurationApplyTo() {
        return maxDurationApplyTo;
    }

    public void setMaxDurationApplyTo(String maxDurationApplyTo) {
        this.maxDurationApplyTo = maxDurationApplyTo == null ? null : maxDurationApplyTo.trim();
    }

    public String getMinDurationApplyTo() {
        return minDurationApplyTo;
    }

    public void setMinDurationApplyTo(String minDurationApplyTo) {
        this.minDurationApplyTo = minDurationApplyTo == null ? null : minDurationApplyTo.trim();
    }

    public String getMaxBookingApplyTo() {
        return maxBookingApplyTo;
    }

    public void setMaxBookingApplyTo(String maxBookingApplyTo) {
        this.maxBookingApplyTo = maxBookingApplyTo == null ? null : maxBookingApplyTo.trim();
    }

    public String getMinBookingApplyTo() {
        return minBookingApplyTo;
    }

    public void setMinBookingApplyTo(String minBookingApplyTo) {
        this.minBookingApplyTo = minBookingApplyTo == null ? null : minBookingApplyTo.trim();
    }

    public String getDayOfWeekApplyTo() {
        return dayOfWeekApplyTo;
    }

    public void setDayOfWeekApplyTo(String dayOfWeekApplyTo) {
        this.dayOfWeekApplyTo = dayOfWeekApplyTo == null ? null : dayOfWeekApplyTo.trim();
    }

    public String getCutoffApplyTo() {
        return cutoffApplyTo;
    }

    public void setCutoffApplyTo(String cutoffApplyTo) {
        this.cutoffApplyTo = cutoffApplyTo == null ? null : cutoffApplyTo.trim();
    }

    public String getOverbookingAllowanceApplyTo() {
        return overbookingAllowanceApplyTo;
    }

    public void setOverbookingAllowanceApplyTo(String overbookingAllowanceApplyTo) {
        this.overbookingAllowanceApplyTo = overbookingAllowanceApplyTo == null ? null : overbookingAllowanceApplyTo.trim();
    }

    public String getForwardBookingWindowApplyTo() {
        return forwardBookingWindowApplyTo;
    }

    public void setForwardBookingWindowApplyTo(String forwardBookingWindowApplyTo) {
        this.forwardBookingWindowApplyTo = forwardBookingWindowApplyTo == null ? null : forwardBookingWindowApplyTo.trim();
    }

    public String getPastBookingWindowApplyTo() {
        return pastBookingWindowApplyTo;
    }

    public void setPastBookingWindowApplyTo(String pastBookingWindowApplyTo) {
        this.pastBookingWindowApplyTo = pastBookingWindowApplyTo == null ? null : pastBookingWindowApplyTo.trim();
    }

    public String getMaxMeonyApplyTo() {
        return maxMeonyApplyTo;
    }

    public void setMaxMeonyApplyTo(String maxMeonyApplyTo) {
        this.maxMeonyApplyTo = maxMeonyApplyTo == null ? null : maxMeonyApplyTo.trim();
    }

    public String getMinMoneyApplyTo() {
        return minMoneyApplyTo;
    }

    public void setMinMoneyApplyTo(String minMoneyApplyTo) {
        this.minMoneyApplyTo = minMoneyApplyTo == null ? null : minMoneyApplyTo.trim();
    }
}