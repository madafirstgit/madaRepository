package com.pzj.base.sku.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XzSkuPriceBaseExample {

    protected String orderByClause;

    protected boolean distinct;

    protected java.util.List<Criteria> oredCriteria;

    protected int start = -1;

    protected int pageSize = -1;

    public XzSkuPriceBaseExample() {
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

        public Criteria andBookingPriceTypeIsNull() {
            addCriterion("BOOKING_PRICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeIsNotNull() {
            addCriterion("BOOKING_PRICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeEqualTo(String value) {
            addCriterion("BOOKING_PRICE_TYPE =", value, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeNotEqualTo(String value) {
            addCriterion("BOOKING_PRICE_TYPE <>", value, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeGreaterThan(String value) {
            addCriterion("BOOKING_PRICE_TYPE >", value, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("BOOKING_PRICE_TYPE >=", value, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeLessThan(String value) {
            addCriterion("BOOKING_PRICE_TYPE <", value, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeLessThanOrEqualTo(String value) {
            addCriterion("BOOKING_PRICE_TYPE <=", value, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeLike(String value) {
            addCriterion("BOOKING_PRICE_TYPE like", value, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeNotLike(String value) {
            addCriterion("BOOKING_PRICE_TYPE not like", value, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("BOOKING_PRICE_TYPE in", values, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("BOOKING_PRICE_TYPE not in", values, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeBetween(String value1, String value2) {
            addCriterion("BOOKING_PRICE_TYPE between", value1, value2, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andBookingPriceTypeNotBetween(String value1, String value2) {
            addCriterion("BOOKING_PRICE_TYPE not between", value1, value2, "bookingPriceType");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdIsNull() {
            addCriterion("SKU_PARAMS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdIsNotNull() {
            addCriterion("SKU_PARAMS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdEqualTo(Integer value) {
            addCriterion("SKU_PARAMS_ID =", value, "skuParamsId");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdNotEqualTo(Integer value) {
            addCriterion("SKU_PARAMS_ID <>", value, "skuParamsId");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdGreaterThan(Integer value) {
            addCriterion("SKU_PARAMS_ID >", value, "skuParamsId");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SKU_PARAMS_ID >=", value, "skuParamsId");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdLessThan(Integer value) {
            addCriterion("SKU_PARAMS_ID <", value, "skuParamsId");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdLessThanOrEqualTo(Integer value) {
            addCriterion("SKU_PARAMS_ID <=", value, "skuParamsId");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdIn(java.util.List<java.lang.Integer> values) {
            addCriterion("SKU_PARAMS_ID in", values, "skuParamsId");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("SKU_PARAMS_ID not in", values, "skuParamsId");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdBetween(Integer value1, Integer value2) {
            addCriterion("SKU_PARAMS_ID between", value1, value2, "skuParamsId");
            return (Criteria) this;
        }

        public Criteria andSkuParamsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SKU_PARAMS_ID not between", value1, value2, "skuParamsId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(java.util.List<java.math.BigDecimal> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(java.util.List<java.math.BigDecimal> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitIsNull() {
            addCriterion("BOOKING_PRICE_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitIsNotNull() {
            addCriterion("BOOKING_PRICE_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitEqualTo(String value) {
            addCriterion("BOOKING_PRICE_UNIT =", value, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitNotEqualTo(String value) {
            addCriterion("BOOKING_PRICE_UNIT <>", value, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitGreaterThan(String value) {
            addCriterion("BOOKING_PRICE_UNIT >", value, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitGreaterThanOrEqualTo(String value) {
            addCriterion("BOOKING_PRICE_UNIT >=", value, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitLessThan(String value) {
            addCriterion("BOOKING_PRICE_UNIT <", value, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitLessThanOrEqualTo(String value) {
            addCriterion("BOOKING_PRICE_UNIT <=", value, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitLike(String value) {
            addCriterion("BOOKING_PRICE_UNIT like", value, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitNotLike(String value) {
            addCriterion("BOOKING_PRICE_UNIT not like", value, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitIn(java.util.List<java.lang.String> values) {
            addCriterion("BOOKING_PRICE_UNIT in", values, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitNotIn(java.util.List<java.lang.String> values) {
            addCriterion("BOOKING_PRICE_UNIT not in", values, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitBetween(String value1, String value2) {
            addCriterion("BOOKING_PRICE_UNIT between", value1, value2, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andBookingPriceUnitNotBetween(String value1, String value2) {
            addCriterion("BOOKING_PRICE_UNIT not between", value1, value2, "bookingPriceUnit");
            return (Criteria) this;
        }

        public Criteria andIsGroupIsNull() {
            addCriterion("IS_GROUP is null");
            return (Criteria) this;
        }

        public Criteria andIsGroupIsNotNull() {
            addCriterion("IS_GROUP is not null");
            return (Criteria) this;
        }

        public Criteria andIsGroupEqualTo(Short value) {
            addCriterion("IS_GROUP =", value, "isGroup");
            return (Criteria) this;
        }

        public Criteria andIsGroupNotEqualTo(Short value) {
            addCriterion("IS_GROUP <>", value, "isGroup");
            return (Criteria) this;
        }

        public Criteria andIsGroupGreaterThan(Short value) {
            addCriterion("IS_GROUP >", value, "isGroup");
            return (Criteria) this;
        }

        public Criteria andIsGroupGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_GROUP >=", value, "isGroup");
            return (Criteria) this;
        }

        public Criteria andIsGroupLessThan(Short value) {
            addCriterion("IS_GROUP <", value, "isGroup");
            return (Criteria) this;
        }

        public Criteria andIsGroupLessThanOrEqualTo(Short value) {
            addCriterion("IS_GROUP <=", value, "isGroup");
            return (Criteria) this;
        }

        public Criteria andIsGroupIn(java.util.List<java.lang.Short> values) {
            addCriterion("IS_GROUP in", values, "isGroup");
            return (Criteria) this;
        }

        public Criteria andIsGroupNotIn(java.util.List<java.lang.Short> values) {
            addCriterion("IS_GROUP not in", values, "isGroup");
            return (Criteria) this;
        }

        public Criteria andIsGroupBetween(Short value1, Short value2) {
            addCriterion("IS_GROUP between", value1, value2, "isGroup");
            return (Criteria) this;
        }

        public Criteria andIsGroupNotBetween(Short value1, Short value2) {
            addCriterion("IS_GROUP not between", value1, value2, "isGroup");
            return (Criteria) this;
        }

        public Criteria andMinNumberIsNull() {
            addCriterion("MIN_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andMinNumberIsNotNull() {
            addCriterion("MIN_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andMinNumberEqualTo(Integer value) {
            addCriterion("MIN_NUMBER =", value, "minNumber");
            return (Criteria) this;
        }

        public Criteria andMinNumberNotEqualTo(Integer value) {
            addCriterion("MIN_NUMBER <>", value, "minNumber");
            return (Criteria) this;
        }

        public Criteria andMinNumberGreaterThan(Integer value) {
            addCriterion("MIN_NUMBER >", value, "minNumber");
            return (Criteria) this;
        }

        public Criteria andMinNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("MIN_NUMBER >=", value, "minNumber");
            return (Criteria) this;
        }

        public Criteria andMinNumberLessThan(Integer value) {
            addCriterion("MIN_NUMBER <", value, "minNumber");
            return (Criteria) this;
        }

        public Criteria andMinNumberLessThanOrEqualTo(Integer value) {
            addCriterion("MIN_NUMBER <=", value, "minNumber");
            return (Criteria) this;
        }

        public Criteria andMinNumberIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MIN_NUMBER in", values, "minNumber");
            return (Criteria) this;
        }

        public Criteria andMinNumberNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MIN_NUMBER not in", values, "minNumber");
            return (Criteria) this;
        }

        public Criteria andMinNumberBetween(Integer value1, Integer value2) {
            addCriterion("MIN_NUMBER between", value1, value2, "minNumber");
            return (Criteria) this;
        }

        public Criteria andMinNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("MIN_NUMBER not between", value1, value2, "minNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberIsNull() {
            addCriterion("MAX_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andMaxNumberIsNotNull() {
            addCriterion("MAX_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andMaxNumberEqualTo(Integer value) {
            addCriterion("MAX_NUMBER =", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberNotEqualTo(Integer value) {
            addCriterion("MAX_NUMBER <>", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberGreaterThan(Integer value) {
            addCriterion("MAX_NUMBER >", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_NUMBER >=", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberLessThan(Integer value) {
            addCriterion("MAX_NUMBER <", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_NUMBER <=", value, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAX_NUMBER in", values, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAX_NUMBER not in", values, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberBetween(Integer value1, Integer value2) {
            addCriterion("MAX_NUMBER between", value1, value2, "maxNumber");
            return (Criteria) this;
        }

        public Criteria andMaxNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_NUMBER not between", value1, value2, "maxNumber");
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