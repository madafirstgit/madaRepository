package com.pzj.base.entity.json;

/**
 * @author liyh <levart@163.com>
 * @version 20160509
 */
public class DisplayStyle implements java.io.Serializable{

    private String fixedStartTime;
    private Integer defaultLength;
    private Integer fixedLength;
    private String bookingDisplay;
    private Short showEndTimes;
    private Short showUnavailableSlots;
    private String timeType;


    public String getFixedStartTime() {
        return fixedStartTime;
    }

    public void setFixedStartTime(String fixedStartTime) {
        this.fixedStartTime = fixedStartTime;
    }

    public Integer getDefaultLength() {
        return defaultLength;
    }

    public void setDefaultLength(Integer defaultLength) {
        this.defaultLength = defaultLength;
    }

    public Integer getFixedLength() {
        return fixedLength;
    }

    public void setFixedLength(Integer fixedLength) {
        this.fixedLength = fixedLength;
    }

    public String getBookingDisplay() {
        return bookingDisplay;
    }

    public void setBookingDisplay(String bookingDisplay) {
        this.bookingDisplay = bookingDisplay;
    }

    public Short getShowEndTimes() {
        return showEndTimes;
    }

    public void setShowEndTimes(Short showEndTimes) {
        this.showEndTimes = showEndTimes;
    }

    public Short getShowUnavailableSlots() {
        return showUnavailableSlots;
    }

    public void setShowUnavailableSlots(Short showUnavailableSlots) {
        this.showUnavailableSlots = showUnavailableSlots;
    }

    public String getTimeType() {
        return timeType;
    }

    public void setTimeType(String timeType) {
        this.timeType = timeType;
    }
}
