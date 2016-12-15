package com.hht.models;

public class BTableInfo {

    private String id;

    private String tableCode;

    private String tableName;

    private String tableTypeCode;

    private Integer sectionId;

    private Integer capacity;

    private String bookPemissionType;

    private String position;

    private Float xPoint;

    private Float yPoint;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode == null ? null : tableCode.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getTableTypeCode() {
        return tableTypeCode;
    }

    public void setTableTypeCode(String tableTypeCode) {
        this.tableTypeCode = tableTypeCode == null ? null : tableTypeCode.trim();
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getBookPemissionType() {
        return bookPemissionType;
    }

    public void setBookPemissionType(String bookPemissionType) {
        this.bookPemissionType = bookPemissionType == null ? null : bookPemissionType.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Float getxPoint() {
        return xPoint;
    }

    public void setxPoint(Float xPoint) {
        this.xPoint = xPoint;
    }

    public Float getyPoint() {
        return yPoint;
    }

    public void setyPoint(Float yPoint) {
        this.yPoint = yPoint;
    }
}