package com.pzj.base.sku.entity;

import java.util.ArrayList;
import java.util.List;

public class XzSkuAllocationExample {

    protected String orderByClause;

    protected boolean distinct;

    protected java.util.List<Criteria> oredCriteria;

    protected int start = -1;

    protected int pageSize = -1;

    public XzSkuAllocationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public java.util.List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setStart(int start) {
        this.start=start;
    }

    public int getStart() {
        return start;
    }

    public void setPageSize(int pageSize) {
        this.pageSize=pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    protected abstract static class GeneratedCriteria {

        protected java.util.List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public java.util.List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(java.util.List<java.lang.Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBossidIsNull() {
            addCriterion("BOSSID is null");
            return (Criteria) this;
        }

        public Criteria andBossidIsNotNull() {
            addCriterion("BOSSID is not null");
            return (Criteria) this;
        }

        public Criteria andBossidEqualTo(Integer value) {
            addCriterion("BOSSID =", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidNotEqualTo(Integer value) {
            addCriterion("BOSSID <>", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidGreaterThan(Integer value) {
            addCriterion("BOSSID >", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidGreaterThanOrEqualTo(Integer value) {
            addCriterion("BOSSID >=", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidLessThan(Integer value) {
            addCriterion("BOSSID <", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidLessThanOrEqualTo(Integer value) {
            addCriterion("BOSSID <=", value, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidIn(java.util.List<java.lang.Integer> values) {
            addCriterion("BOSSID in", values, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("BOSSID not in", values, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidBetween(Integer value1, Integer value2) {
            addCriterion("BOSSID between", value1, value2, "bossid");
            return (Criteria) this;
        }

        public Criteria andBossidNotBetween(Integer value1, Integer value2) {
            addCriterion("BOSSID not between", value1, value2, "bossid");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("SKU_ID is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("SKU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Integer value) {
            addCriterion("SKU_ID =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Integer value) {
            addCriterion("SKU_ID <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Integer value) {
            addCriterion("SKU_ID >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SKU_ID >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Integer value) {
            addCriterion("SKU_ID <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Integer value) {
            addCriterion("SKU_ID <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(java.util.List<java.lang.Integer> values) {
            addCriterion("SKU_ID in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("SKU_ID not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Integer value1, Integer value2) {
            addCriterion("SKU_ID between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SKU_ID not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andAllocationIsNull() {
            addCriterion("ALLOCATION is null");
            return (Criteria) this;
        }

        public Criteria andAllocationIsNotNull() {
            addCriterion("ALLOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andAllocationEqualTo(String value) {
            addCriterion("ALLOCATION =", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationNotEqualTo(String value) {
            addCriterion("ALLOCATION <>", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationGreaterThan(String value) {
            addCriterion("ALLOCATION >", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationGreaterThanOrEqualTo(String value) {
            addCriterion("ALLOCATION >=", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationLessThan(String value) {
            addCriterion("ALLOCATION <", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationLessThanOrEqualTo(String value) {
            addCriterion("ALLOCATION <=", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationLike(String value) {
            addCriterion("ALLOCATION like", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationNotLike(String value) {
            addCriterion("ALLOCATION not like", value, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationIn(java.util.List<java.lang.String> values) {
            addCriterion("ALLOCATION in", values, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationNotIn(java.util.List<java.lang.String> values) {
            addCriterion("ALLOCATION not in", values, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationBetween(String value1, String value2) {
            addCriterion("ALLOCATION between", value1, value2, "allocation");
            return (Criteria) this;
        }

        public Criteria andAllocationNotBetween(String value1, String value2) {
            addCriterion("ALLOCATION not between", value1, value2, "allocation");
            return (Criteria) this;
        }

        public Criteria andFixedLengthIsNull() {
            addCriterion("FIXED_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andFixedLengthIsNotNull() {
            addCriterion("FIXED_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andFixedLengthEqualTo(Integer value) {
            addCriterion("FIXED_LENGTH =", value, "fixedLength");
            return (Criteria) this;
        }

        public Criteria andFixedLengthNotEqualTo(Integer value) {
            addCriterion("FIXED_LENGTH <>", value, "fixedLength");
            return (Criteria) this;
        }

        public Criteria andFixedLengthGreaterThan(Integer value) {
            addCriterion("FIXED_LENGTH >", value, "fixedLength");
            return (Criteria) this;
        }

        public Criteria andFixedLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("FIXED_LENGTH >=", value, "fixedLength");
            return (Criteria) this;
        }

        public Criteria andFixedLengthLessThan(Integer value) {
            addCriterion("FIXED_LENGTH <", value, "fixedLength");
            return (Criteria) this;
        }

        public Criteria andFixedLengthLessThanOrEqualTo(Integer value) {
            addCriterion("FIXED_LENGTH <=", value, "fixedLength");
            return (Criteria) this;
        }

        public Criteria andFixedLengthIn(java.util.List<java.lang.Integer> values) {
            addCriterion("FIXED_LENGTH in", values, "fixedLength");
            return (Criteria) this;
        }

        public Criteria andFixedLengthNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("FIXED_LENGTH not in", values, "fixedLength");
            return (Criteria) this;
        }

        public Criteria andFixedLengthBetween(Integer value1, Integer value2) {
            addCriterion("FIXED_LENGTH between", value1, value2, "fixedLength");
            return (Criteria) this;
        }

        public Criteria andFixedLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("FIXED_LENGTH not between", value1, value2, "fixedLength");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeIsNull() {
            addCriterion("FIXED_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeIsNotNull() {
            addCriterion("FIXED_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeEqualTo(String value) {
            addCriterion("FIXED_START_TIME =", value, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeNotEqualTo(String value) {
            addCriterion("FIXED_START_TIME <>", value, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeGreaterThan(String value) {
            addCriterion("FIXED_START_TIME >", value, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("FIXED_START_TIME >=", value, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeLessThan(String value) {
            addCriterion("FIXED_START_TIME <", value, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeLessThanOrEqualTo(String value) {
            addCriterion("FIXED_START_TIME <=", value, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeLike(String value) {
            addCriterion("FIXED_START_TIME like", value, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeNotLike(String value) {
            addCriterion("FIXED_START_TIME not like", value, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("FIXED_START_TIME in", values, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("FIXED_START_TIME not in", values, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeBetween(String value1, String value2) {
            addCriterion("FIXED_START_TIME between", value1, value2, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andFixedStartTimeNotBetween(String value1, String value2) {
            addCriterion("FIXED_START_TIME not between", value1, value2, "fixedStartTime");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthIsNull() {
            addCriterion("DEFAULT_LENGTH is null");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthIsNotNull() {
            addCriterion("DEFAULT_LENGTH is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthEqualTo(Integer value) {
            addCriterion("DEFAULT_LENGTH =", value, "defaultLength");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthNotEqualTo(Integer value) {
            addCriterion("DEFAULT_LENGTH <>", value, "defaultLength");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthGreaterThan(Integer value) {
            addCriterion("DEFAULT_LENGTH >", value, "defaultLength");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEFAULT_LENGTH >=", value, "defaultLength");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthLessThan(Integer value) {
            addCriterion("DEFAULT_LENGTH <", value, "defaultLength");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthLessThanOrEqualTo(Integer value) {
            addCriterion("DEFAULT_LENGTH <=", value, "defaultLength");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthIn(java.util.List<java.lang.Integer> values) {
            addCriterion("DEFAULT_LENGTH in", values, "defaultLength");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("DEFAULT_LENGTH not in", values, "defaultLength");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthBetween(Integer value1, Integer value2) {
            addCriterion("DEFAULT_LENGTH between", value1, value2, "defaultLength");
            return (Criteria) this;
        }

        public Criteria andDefaultLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("DEFAULT_LENGTH not between", value1, value2, "defaultLength");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("UNIT is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("UNIT =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("UNIT <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("UNIT >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("UNIT <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("UNIT <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("UNIT like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("UNIT not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(java.util.List<java.lang.String> values) {
            addCriterion("UNIT in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(java.util.List<java.lang.String> values) {
            addCriterion("UNIT not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("UNIT between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("UNIT not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayIsNull() {
            addCriterion("BOOKING_DISPLAY is null");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayIsNotNull() {
            addCriterion("BOOKING_DISPLAY is not null");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayEqualTo(String value) {
            addCriterion("BOOKING_DISPLAY =", value, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayNotEqualTo(String value) {
            addCriterion("BOOKING_DISPLAY <>", value, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayGreaterThan(String value) {
            addCriterion("BOOKING_DISPLAY >", value, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayGreaterThanOrEqualTo(String value) {
            addCriterion("BOOKING_DISPLAY >=", value, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayLessThan(String value) {
            addCriterion("BOOKING_DISPLAY <", value, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayLessThanOrEqualTo(String value) {
            addCriterion("BOOKING_DISPLAY <=", value, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayLike(String value) {
            addCriterion("BOOKING_DISPLAY like", value, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayNotLike(String value) {
            addCriterion("BOOKING_DISPLAY not like", value, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayIn(java.util.List<java.lang.String> values) {
            addCriterion("BOOKING_DISPLAY in", values, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayNotIn(java.util.List<java.lang.String> values) {
            addCriterion("BOOKING_DISPLAY not in", values, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayBetween(String value1, String value2) {
            addCriterion("BOOKING_DISPLAY between", value1, value2, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andBookingDisplayNotBetween(String value1, String value2) {
            addCriterion("BOOKING_DISPLAY not between", value1, value2, "bookingDisplay");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesIsNull() {
            addCriterion("SHOW_END_TIMES is null");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesIsNotNull() {
            addCriterion("SHOW_END_TIMES is not null");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesEqualTo(Short value) {
            addCriterion("SHOW_END_TIMES =", value, "showEndTimes");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesNotEqualTo(Short value) {
            addCriterion("SHOW_END_TIMES <>", value, "showEndTimes");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesGreaterThan(Short value) {
            addCriterion("SHOW_END_TIMES >", value, "showEndTimes");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesGreaterThanOrEqualTo(Short value) {
            addCriterion("SHOW_END_TIMES >=", value, "showEndTimes");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesLessThan(Short value) {
            addCriterion("SHOW_END_TIMES <", value, "showEndTimes");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesLessThanOrEqualTo(Short value) {
            addCriterion("SHOW_END_TIMES <=", value, "showEndTimes");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesIn(java.util.List<java.lang.Short> values) {
            addCriterion("SHOW_END_TIMES in", values, "showEndTimes");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesNotIn(java.util.List<java.lang.Short> values) {
            addCriterion("SHOW_END_TIMES not in", values, "showEndTimes");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesBetween(Short value1, Short value2) {
            addCriterion("SHOW_END_TIMES between", value1, value2, "showEndTimes");
            return (Criteria) this;
        }

        public Criteria andShowEndTimesNotBetween(Short value1, Short value2) {
            addCriterion("SHOW_END_TIMES not between", value1, value2, "showEndTimes");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsIsNull() {
            addCriterion("SHOW_UNAVAILABLE_SLOTS is null");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsIsNotNull() {
            addCriterion("SHOW_UNAVAILABLE_SLOTS is not null");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsEqualTo(Short value) {
            addCriterion("SHOW_UNAVAILABLE_SLOTS =", value, "showUnavailableSlots");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsNotEqualTo(Short value) {
            addCriterion("SHOW_UNAVAILABLE_SLOTS <>", value, "showUnavailableSlots");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsGreaterThan(Short value) {
            addCriterion("SHOW_UNAVAILABLE_SLOTS >", value, "showUnavailableSlots");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsGreaterThanOrEqualTo(Short value) {
            addCriterion("SHOW_UNAVAILABLE_SLOTS >=", value, "showUnavailableSlots");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsLessThan(Short value) {
            addCriterion("SHOW_UNAVAILABLE_SLOTS <", value, "showUnavailableSlots");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsLessThanOrEqualTo(Short value) {
            addCriterion("SHOW_UNAVAILABLE_SLOTS <=", value, "showUnavailableSlots");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsIn(java.util.List<java.lang.Short> values) {
            addCriterion("SHOW_UNAVAILABLE_SLOTS in", values, "showUnavailableSlots");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsNotIn(java.util.List<java.lang.Short> values) {
            addCriterion("SHOW_UNAVAILABLE_SLOTS not in", values, "showUnavailableSlots");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsBetween(Short value1, Short value2) {
            addCriterion("SHOW_UNAVAILABLE_SLOTS between", value1, value2, "showUnavailableSlots");
            return (Criteria) this;
        }

        public Criteria andShowUnavailableSlotsNotBetween(Short value1, Short value2) {
            addCriterion("SHOW_UNAVAILABLE_SLOTS not between", value1, value2, "showUnavailableSlots");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {


        protected Criteria() {
            super();
        }
    }

    public static class Criterion {

        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}