package com.pzj.base.sku.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XzSkuPriceEventExample {

    protected String orderByClause;

    protected boolean distinct;

    protected java.util.List<Criteria> oredCriteria;

    protected int start = -1;

    protected int pageSize = -1;

    public XzSkuPriceEventExample() {
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

        public Criteria andEventNameIsNull() {
            addCriterion("EVENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEventNameIsNotNull() {
            addCriterion("EVENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEventNameEqualTo(String value) {
            addCriterion("EVENT_NAME =", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotEqualTo(String value) {
            addCriterion("EVENT_NAME <>", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThan(String value) {
            addCriterion("EVENT_NAME >", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameGreaterThanOrEqualTo(String value) {
            addCriterion("EVENT_NAME >=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThan(String value) {
            addCriterion("EVENT_NAME <", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLessThanOrEqualTo(String value) {
            addCriterion("EVENT_NAME <=", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameLike(String value) {
            addCriterion("EVENT_NAME like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotLike(String value) {
            addCriterion("EVENT_NAME not like", value, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameIn(java.util.List<java.lang.String> values) {
            addCriterion("EVENT_NAME in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("EVENT_NAME not in", values, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameBetween(String value1, String value2) {
            addCriterion("EVENT_NAME between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventNameNotBetween(String value1, String value2) {
            addCriterion("EVENT_NAME not between", value1, value2, "eventName");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNull() {
            addCriterion("EVENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNotNull() {
            addCriterion("EVENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(String value) {
            addCriterion("EVENT_TYPE =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotEqualTo(String value) {
            addCriterion("EVENT_TYPE <>", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThan(String value) {
            addCriterion("EVENT_TYPE >", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThanOrEqualTo(String value) {
            addCriterion("EVENT_TYPE >=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThan(String value) {
            addCriterion("EVENT_TYPE <", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThanOrEqualTo(String value) {
            addCriterion("EVENT_TYPE <=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLike(String value) {
            addCriterion("EVENT_TYPE like", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotLike(String value) {
            addCriterion("EVENT_TYPE not like", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("EVENT_TYPE in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("EVENT_TYPE not in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeBetween(String value1, String value2) {
            addCriterion("EVENT_TYPE between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotBetween(String value1, String value2) {
            addCriterion("EVENT_TYPE not between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIsNull() {
            addCriterion("PRICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIsNotNull() {
            addCriterion("PRICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTypeEqualTo(String value) {
            addCriterion("PRICE_TYPE =", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotEqualTo(String value) {
            addCriterion("PRICE_TYPE <>", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeGreaterThan(String value) {
            addCriterion("PRICE_TYPE >", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_TYPE >=", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLessThan(String value) {
            addCriterion("PRICE_TYPE <", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLessThanOrEqualTo(String value) {
            addCriterion("PRICE_TYPE <=", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLike(String value) {
            addCriterion("PRICE_TYPE like", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotLike(String value) {
            addCriterion("PRICE_TYPE not like", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("PRICE_TYPE in", values, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("PRICE_TYPE not in", values, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeBetween(String value1, String value2) {
            addCriterion("PRICE_TYPE between", value1, value2, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotBetween(String value1, String value2) {
            addCriterion("PRICE_TYPE not between", value1, value2, "priceType");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterion("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterion("START_DATE <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterion("START_DATE >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterion("START_DATE >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterion("START_DATE <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterion("START_DATE <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(java.util.List<java.util.Date> values) {
            addCriterion("START_DATE in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(java.util.List<java.util.Date> values) {
            addCriterion("START_DATE not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterion("START_DATE between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterion("START_DATE not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNull() {
            addCriterion("END_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEndDateIsNotNull() {
            addCriterion("END_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEndDateEqualTo(Date value) {
            addCriterion("END_DATE =", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotEqualTo(Date value) {
            addCriterion("END_DATE <>", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThan(Date value) {
            addCriterion("END_DATE >", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateGreaterThanOrEqualTo(Date value) {
            addCriterion("END_DATE >=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThan(Date value) {
            addCriterion("END_DATE <", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateLessThanOrEqualTo(Date value) {
            addCriterion("END_DATE <=", value, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateIn(java.util.List<java.util.Date> values) {
            addCriterion("END_DATE in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotIn(java.util.List<java.util.Date> values) {
            addCriterion("END_DATE not in", values, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateBetween(Date value1, Date value2) {
            addCriterion("END_DATE between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andEndDateNotBetween(Date value1, Date value2) {
            addCriterion("END_DATE not between", value1, value2, "endDate");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysIsNull() {
            addCriterion("APPLICABLE_DAYS is null");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysIsNotNull() {
            addCriterion("APPLICABLE_DAYS is not null");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysEqualTo(Integer value) {
            addCriterion("APPLICABLE_DAYS =", value, "applicableDays");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysNotEqualTo(Integer value) {
            addCriterion("APPLICABLE_DAYS <>", value, "applicableDays");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysGreaterThan(Integer value) {
            addCriterion("APPLICABLE_DAYS >", value, "applicableDays");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("APPLICABLE_DAYS >=", value, "applicableDays");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysLessThan(Integer value) {
            addCriterion("APPLICABLE_DAYS <", value, "applicableDays");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysLessThanOrEqualTo(Integer value) {
            addCriterion("APPLICABLE_DAYS <=", value, "applicableDays");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysIn(java.util.List<java.lang.Integer> values) {
            addCriterion("APPLICABLE_DAYS in", values, "applicableDays");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("APPLICABLE_DAYS not in", values, "applicableDays");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysBetween(Integer value1, Integer value2) {
            addCriterion("APPLICABLE_DAYS between", value1, value2, "applicableDays");
            return (Criteria) this;
        }

        public Criteria andApplicableDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("APPLICABLE_DAYS not between", value1, value2, "applicableDays");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeIsNull() {
            addCriterion("APPLICABLE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeIsNotNull() {
            addCriterion("APPLICABLE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeEqualTo(String value) {
            addCriterion("APPLICABLE_TIME =", value, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeNotEqualTo(String value) {
            addCriterion("APPLICABLE_TIME <>", value, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeGreaterThan(String value) {
            addCriterion("APPLICABLE_TIME >", value, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeGreaterThanOrEqualTo(String value) {
            addCriterion("APPLICABLE_TIME >=", value, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeLessThan(String value) {
            addCriterion("APPLICABLE_TIME <", value, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeLessThanOrEqualTo(String value) {
            addCriterion("APPLICABLE_TIME <=", value, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeLike(String value) {
            addCriterion("APPLICABLE_TIME like", value, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeNotLike(String value) {
            addCriterion("APPLICABLE_TIME not like", value, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("APPLICABLE_TIME in", values, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("APPLICABLE_TIME not in", values, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeBetween(String value1, String value2) {
            addCriterion("APPLICABLE_TIME between", value1, value2, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andApplicableTimeNotBetween(String value1, String value2) {
            addCriterion("APPLICABLE_TIME not between", value1, value2, "applicableTime");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeIsNull() {
            addCriterion("DYNAMIC_PRICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeIsNotNull() {
            addCriterion("DYNAMIC_PRICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeEqualTo(String value) {
            addCriterion("DYNAMIC_PRICE_TYPE =", value, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeNotEqualTo(String value) {
            addCriterion("DYNAMIC_PRICE_TYPE <>", value, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeGreaterThan(String value) {
            addCriterion("DYNAMIC_PRICE_TYPE >", value, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DYNAMIC_PRICE_TYPE >=", value, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeLessThan(String value) {
            addCriterion("DYNAMIC_PRICE_TYPE <", value, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeLessThanOrEqualTo(String value) {
            addCriterion("DYNAMIC_PRICE_TYPE <=", value, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeLike(String value) {
            addCriterion("DYNAMIC_PRICE_TYPE like", value, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeNotLike(String value) {
            addCriterion("DYNAMIC_PRICE_TYPE not like", value, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("DYNAMIC_PRICE_TYPE in", values, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("DYNAMIC_PRICE_TYPE not in", values, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeBetween(String value1, String value2) {
            addCriterion("DYNAMIC_PRICE_TYPE between", value1, value2, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceTypeNotBetween(String value1, String value2) {
            addCriterion("DYNAMIC_PRICE_TYPE not between", value1, value2, "dynamicPriceType");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueIsNull() {
            addCriterion("DYNAMIC_PRICE_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueIsNotNull() {
            addCriterion("DYNAMIC_PRICE_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueEqualTo(String value) {
            addCriterion("DYNAMIC_PRICE_VALUE =", value, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueNotEqualTo(String value) {
            addCriterion("DYNAMIC_PRICE_VALUE <>", value, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueGreaterThan(String value) {
            addCriterion("DYNAMIC_PRICE_VALUE >", value, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueGreaterThanOrEqualTo(String value) {
            addCriterion("DYNAMIC_PRICE_VALUE >=", value, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueLessThan(String value) {
            addCriterion("DYNAMIC_PRICE_VALUE <", value, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueLessThanOrEqualTo(String value) {
            addCriterion("DYNAMIC_PRICE_VALUE <=", value, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueLike(String value) {
            addCriterion("DYNAMIC_PRICE_VALUE like", value, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueNotLike(String value) {
            addCriterion("DYNAMIC_PRICE_VALUE not like", value, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueIn(java.util.List<java.lang.String> values) {
            addCriterion("DYNAMIC_PRICE_VALUE in", values, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueNotIn(java.util.List<java.lang.String> values) {
            addCriterion("DYNAMIC_PRICE_VALUE not in", values, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueBetween(String value1, String value2) {
            addCriterion("DYNAMIC_PRICE_VALUE between", value1, value2, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andDynamicPriceValueNotBetween(String value1, String value2) {
            addCriterion("DYNAMIC_PRICE_VALUE not between", value1, value2, "dynamicPriceValue");
            return (Criteria) this;
        }

        public Criteria andRulesetIsNull() {
            addCriterion("RULESET is null");
            return (Criteria) this;
        }

        public Criteria andRulesetIsNotNull() {
            addCriterion("RULESET is not null");
            return (Criteria) this;
        }

        public Criteria andRulesetEqualTo(Integer value) {
            addCriterion("RULESET =", value, "ruleset");
            return (Criteria) this;
        }

        public Criteria andRulesetNotEqualTo(Integer value) {
            addCriterion("RULESET <>", value, "ruleset");
            return (Criteria) this;
        }

        public Criteria andRulesetGreaterThan(Integer value) {
            addCriterion("RULESET >", value, "ruleset");
            return (Criteria) this;
        }

        public Criteria andRulesetGreaterThanOrEqualTo(Integer value) {
            addCriterion("RULESET >=", value, "ruleset");
            return (Criteria) this;
        }

        public Criteria andRulesetLessThan(Integer value) {
            addCriterion("RULESET <", value, "ruleset");
            return (Criteria) this;
        }

        public Criteria andRulesetLessThanOrEqualTo(Integer value) {
            addCriterion("RULESET <=", value, "ruleset");
            return (Criteria) this;
        }

        public Criteria andRulesetIn(java.util.List<java.lang.Integer> values) {
            addCriterion("RULESET in", values, "ruleset");
            return (Criteria) this;
        }

        public Criteria andRulesetNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("RULESET not in", values, "ruleset");
            return (Criteria) this;
        }

        public Criteria andRulesetBetween(Integer value1, Integer value2) {
            addCriterion("RULESET between", value1, value2, "ruleset");
            return (Criteria) this;
        }

        public Criteria andRulesetNotBetween(Integer value1, Integer value2) {
            addCriterion("RULESET not between", value1, value2, "ruleset");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusIsNull() {
            addCriterion("INVENTORY_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusIsNotNull() {
            addCriterion("INVENTORY_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusEqualTo(Boolean value) {
            addCriterion("INVENTORY_STATUS =", value, "inventoryStatus");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusNotEqualTo(Boolean value) {
            addCriterion("INVENTORY_STATUS <>", value, "inventoryStatus");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusGreaterThan(Boolean value) {
            addCriterion("INVENTORY_STATUS >", value, "inventoryStatus");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("INVENTORY_STATUS >=", value, "inventoryStatus");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusLessThan(Boolean value) {
            addCriterion("INVENTORY_STATUS <", value, "inventoryStatus");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("INVENTORY_STATUS <=", value, "inventoryStatus");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("INVENTORY_STATUS in", values, "inventoryStatus");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("INVENTORY_STATUS not in", values, "inventoryStatus");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("INVENTORY_STATUS between", value1, value2, "inventoryStatus");
            return (Criteria) this;
        }

        public Criteria andInventoryStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("INVENTORY_STATUS not between", value1, value2, "inventoryStatus");
            return (Criteria) this;
        }

        public Criteria andRecurrenceIsNull() {
            addCriterion("RECURRENCE is null");
            return (Criteria) this;
        }

        public Criteria andRecurrenceIsNotNull() {
            addCriterion("RECURRENCE is not null");
            return (Criteria) this;
        }

        public Criteria andRecurrenceEqualTo(String value) {
            addCriterion("RECURRENCE =", value, "recurrence");
            return (Criteria) this;
        }

        public Criteria andRecurrenceNotEqualTo(String value) {
            addCriterion("RECURRENCE <>", value, "recurrence");
            return (Criteria) this;
        }

        public Criteria andRecurrenceGreaterThan(String value) {
            addCriterion("RECURRENCE >", value, "recurrence");
            return (Criteria) this;
        }

        public Criteria andRecurrenceGreaterThanOrEqualTo(String value) {
            addCriterion("RECURRENCE >=", value, "recurrence");
            return (Criteria) this;
        }

        public Criteria andRecurrenceLessThan(String value) {
            addCriterion("RECURRENCE <", value, "recurrence");
            return (Criteria) this;
        }

        public Criteria andRecurrenceLessThanOrEqualTo(String value) {
            addCriterion("RECURRENCE <=", value, "recurrence");
            return (Criteria) this;
        }

        public Criteria andRecurrenceLike(String value) {
            addCriterion("RECURRENCE like", value, "recurrence");
            return (Criteria) this;
        }

        public Criteria andRecurrenceNotLike(String value) {
            addCriterion("RECURRENCE not like", value, "recurrence");
            return (Criteria) this;
        }

        public Criteria andRecurrenceIn(java.util.List<java.lang.String> values) {
            addCriterion("RECURRENCE in", values, "recurrence");
            return (Criteria) this;
        }

        public Criteria andRecurrenceNotIn(java.util.List<java.lang.String> values) {
            addCriterion("RECURRENCE not in", values, "recurrence");
            return (Criteria) this;
        }

        public Criteria andRecurrenceBetween(String value1, String value2) {
            addCriterion("RECURRENCE between", value1, value2, "recurrence");
            return (Criteria) this;
        }

        public Criteria andRecurrenceNotBetween(String value1, String value2) {
            addCriterion("RECURRENCE not between", value1, value2, "recurrence");
            return (Criteria) this;
        }

        public Criteria andApplyAllIsNull() {
            addCriterion("APPLY_ALL is null");
            return (Criteria) this;
        }

        public Criteria andApplyAllIsNotNull() {
            addCriterion("APPLY_ALL is not null");
            return (Criteria) this;
        }

        public Criteria andApplyAllEqualTo(Boolean value) {
            addCriterion("APPLY_ALL =", value, "applyAll");
            return (Criteria) this;
        }

        public Criteria andApplyAllNotEqualTo(Boolean value) {
            addCriterion("APPLY_ALL <>", value, "applyAll");
            return (Criteria) this;
        }

        public Criteria andApplyAllGreaterThan(Boolean value) {
            addCriterion("APPLY_ALL >", value, "applyAll");
            return (Criteria) this;
        }

        public Criteria andApplyAllGreaterThanOrEqualTo(Boolean value) {
            addCriterion("APPLY_ALL >=", value, "applyAll");
            return (Criteria) this;
        }

        public Criteria andApplyAllLessThan(Boolean value) {
            addCriterion("APPLY_ALL <", value, "applyAll");
            return (Criteria) this;
        }

        public Criteria andApplyAllLessThanOrEqualTo(Boolean value) {
            addCriterion("APPLY_ALL <=", value, "applyAll");
            return (Criteria) this;
        }

        public Criteria andApplyAllIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("APPLY_ALL in", values, "applyAll");
            return (Criteria) this;
        }

        public Criteria andApplyAllNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("APPLY_ALL not in", values, "applyAll");
            return (Criteria) this;
        }

        public Criteria andApplyAllBetween(Boolean value1, Boolean value2) {
            addCriterion("APPLY_ALL between", value1, value2, "applyAll");
            return (Criteria) this;
        }

        public Criteria andApplyAllNotBetween(Boolean value1, Boolean value2) {
            addCriterion("APPLY_ALL not between", value1, value2, "applyAll");
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