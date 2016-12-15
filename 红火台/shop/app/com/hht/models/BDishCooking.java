package com.hht.models;

public class BDishCooking {

    private String id;

    private String dishCode;

    private String cookingId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDishCode() {
        return dishCode;
    }

    public void setDishCode(String dishCode) {
        this.dishCode = dishCode == null ? null : dishCode.trim();
    }

    public String getCookingId() {
        return cookingId;
    }

    public void setCookingId(String cookingId) {
        this.cookingId = cookingId == null ? null : cookingId.trim();
    }
}