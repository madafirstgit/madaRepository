package com.pzj.base.sku.entity;

import java.util.ArrayList;
import java.util.List;

public class XzSkuPriceEventRulesExample {

    protected String orderByClause;

    protected boolean distinct;

    protected java.util.List<Criteria> oredCriteria;

    protected int start = -1;

    protected int pageSize = -1;

    public XzSkuPriceEventRulesExample() {
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

        public Criteria andRulesNameIsNull() {
            addCriterion("RULES_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRulesNameIsNotNull() {
            addCriterion("RULES_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRulesNameEqualTo(String value) {
            addCriterion("RULES_NAME =", value, "rulesName");
            return (Criteria) this;
        }

        public Criteria andRulesNameNotEqualTo(String value) {
            addCriterion("RULES_NAME <>", value, "rulesName");
            return (Criteria) this;
        }

        public Criteria andRulesNameGreaterThan(String value) {
            addCriterion("RULES_NAME >", value, "rulesName");
            return (Criteria) this;
        }

        public Criteria andRulesNameGreaterThanOrEqualTo(String value) {
            addCriterion("RULES_NAME >=", value, "rulesName");
            return (Criteria) this;
        }

        public Criteria andRulesNameLessThan(String value) {
            addCriterion("RULES_NAME <", value, "rulesName");
            return (Criteria) this;
        }

        public Criteria andRulesNameLessThanOrEqualTo(String value) {
            addCriterion("RULES_NAME <=", value, "rulesName");
            return (Criteria) this;
        }

        public Criteria andRulesNameLike(String value) {
            addCriterion("RULES_NAME like", value, "rulesName");
            return (Criteria) this;
        }

        public Criteria andRulesNameNotLike(String value) {
            addCriterion("RULES_NAME not like", value, "rulesName");
            return (Criteria) this;
        }

        public Criteria andRulesNameIn(java.util.List<java.lang.String> values) {
            addCriterion("RULES_NAME in", values, "rulesName");
            return (Criteria) this;
        }

        public Criteria andRulesNameNotIn(java.util.List<java.lang.String> values) {
            addCriterion("RULES_NAME not in", values, "rulesName");
            return (Criteria) this;
        }

        public Criteria andRulesNameBetween(String value1, String value2) {
            addCriterion("RULES_NAME between", value1, value2, "rulesName");
            return (Criteria) this;
        }

        public Criteria andRulesNameNotBetween(String value1, String value2) {
            addCriterion("RULES_NAME not between", value1, value2, "rulesName");
            return (Criteria) this;
        }

        public Criteria andMaxDurationIsNull() {
            addCriterion("MAX_DURATION is null");
            return (Criteria) this;
        }

        public Criteria andMaxDurationIsNotNull() {
            addCriterion("MAX_DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDurationEqualTo(Integer value) {
            addCriterion("MAX_DURATION =", value, "maxDuration");
            return (Criteria) this;
        }

        public Criteria andMaxDurationNotEqualTo(Integer value) {
            addCriterion("MAX_DURATION <>", value, "maxDuration");
            return (Criteria) this;
        }

        public Criteria andMaxDurationGreaterThan(Integer value) {
            addCriterion("MAX_DURATION >", value, "maxDuration");
            return (Criteria) this;
        }

        public Criteria andMaxDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_DURATION >=", value, "maxDuration");
            return (Criteria) this;
        }

        public Criteria andMaxDurationLessThan(Integer value) {
            addCriterion("MAX_DURATION <", value, "maxDuration");
            return (Criteria) this;
        }

        public Criteria andMaxDurationLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_DURATION <=", value, "maxDuration");
            return (Criteria) this;
        }

        public Criteria andMaxDurationIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAX_DURATION in", values, "maxDuration");
            return (Criteria) this;
        }

        public Criteria andMaxDurationNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAX_DURATION not in", values, "maxDuration");
            return (Criteria) this;
        }

        public Criteria andMaxDurationBetween(Integer value1, Integer value2) {
            addCriterion("MAX_DURATION between", value1, value2, "maxDuration");
            return (Criteria) this;
        }

        public Criteria andMaxDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_DURATION not between", value1, value2, "maxDuration");
            return (Criteria) this;
        }

        public Criteria andMinDurationIsNull() {
            addCriterion("MIN_DURATION is null");
            return (Criteria) this;
        }

        public Criteria andMinDurationIsNotNull() {
            addCriterion("MIN_DURATION is not null");
            return (Criteria) this;
        }

        public Criteria andMinDurationEqualTo(Integer value) {
            addCriterion("MIN_DURATION =", value, "minDuration");
            return (Criteria) this;
        }

        public Criteria andMinDurationNotEqualTo(Integer value) {
            addCriterion("MIN_DURATION <>", value, "minDuration");
            return (Criteria) this;
        }

        public Criteria andMinDurationGreaterThan(Integer value) {
            addCriterion("MIN_DURATION >", value, "minDuration");
            return (Criteria) this;
        }

        public Criteria andMinDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("MIN_DURATION >=", value, "minDuration");
            return (Criteria) this;
        }

        public Criteria andMinDurationLessThan(Integer value) {
            addCriterion("MIN_DURATION <", value, "minDuration");
            return (Criteria) this;
        }

        public Criteria andMinDurationLessThanOrEqualTo(Integer value) {
            addCriterion("MIN_DURATION <=", value, "minDuration");
            return (Criteria) this;
        }

        public Criteria andMinDurationIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MIN_DURATION in", values, "minDuration");
            return (Criteria) this;
        }

        public Criteria andMinDurationNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MIN_DURATION not in", values, "minDuration");
            return (Criteria) this;
        }

        public Criteria andMinDurationBetween(Integer value1, Integer value2) {
            addCriterion("MIN_DURATION between", value1, value2, "minDuration");
            return (Criteria) this;
        }

        public Criteria andMinDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("MIN_DURATION not between", value1, value2, "minDuration");
            return (Criteria) this;
        }

        public Criteria andMaxBookingIsNull() {
            addCriterion("MAX_BOOKING is null");
            return (Criteria) this;
        }

        public Criteria andMaxBookingIsNotNull() {
            addCriterion("MAX_BOOKING is not null");
            return (Criteria) this;
        }

        public Criteria andMaxBookingEqualTo(Integer value) {
            addCriterion("MAX_BOOKING =", value, "maxBooking");
            return (Criteria) this;
        }

        public Criteria andMaxBookingNotEqualTo(Integer value) {
            addCriterion("MAX_BOOKING <>", value, "maxBooking");
            return (Criteria) this;
        }

        public Criteria andMaxBookingGreaterThan(Integer value) {
            addCriterion("MAX_BOOKING >", value, "maxBooking");
            return (Criteria) this;
        }

        public Criteria andMaxBookingGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_BOOKING >=", value, "maxBooking");
            return (Criteria) this;
        }

        public Criteria andMaxBookingLessThan(Integer value) {
            addCriterion("MAX_BOOKING <", value, "maxBooking");
            return (Criteria) this;
        }

        public Criteria andMaxBookingLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_BOOKING <=", value, "maxBooking");
            return (Criteria) this;
        }

        public Criteria andMaxBookingIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAX_BOOKING in", values, "maxBooking");
            return (Criteria) this;
        }

        public Criteria andMaxBookingNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAX_BOOKING not in", values, "maxBooking");
            return (Criteria) this;
        }

        public Criteria andMaxBookingBetween(Integer value1, Integer value2) {
            addCriterion("MAX_BOOKING between", value1, value2, "maxBooking");
            return (Criteria) this;
        }

        public Criteria andMaxBookingNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_BOOKING not between", value1, value2, "maxBooking");
            return (Criteria) this;
        }

        public Criteria andMinBookingIsNull() {
            addCriterion("MIN_BOOKING is null");
            return (Criteria) this;
        }

        public Criteria andMinBookingIsNotNull() {
            addCriterion("MIN_BOOKING is not null");
            return (Criteria) this;
        }

        public Criteria andMinBookingEqualTo(Integer value) {
            addCriterion("MIN_BOOKING =", value, "minBooking");
            return (Criteria) this;
        }

        public Criteria andMinBookingNotEqualTo(Integer value) {
            addCriterion("MIN_BOOKING <>", value, "minBooking");
            return (Criteria) this;
        }

        public Criteria andMinBookingGreaterThan(Integer value) {
            addCriterion("MIN_BOOKING >", value, "minBooking");
            return (Criteria) this;
        }

        public Criteria andMinBookingGreaterThanOrEqualTo(Integer value) {
            addCriterion("MIN_BOOKING >=", value, "minBooking");
            return (Criteria) this;
        }

        public Criteria andMinBookingLessThan(Integer value) {
            addCriterion("MIN_BOOKING <", value, "minBooking");
            return (Criteria) this;
        }

        public Criteria andMinBookingLessThanOrEqualTo(Integer value) {
            addCriterion("MIN_BOOKING <=", value, "minBooking");
            return (Criteria) this;
        }

        public Criteria andMinBookingIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MIN_BOOKING in", values, "minBooking");
            return (Criteria) this;
        }

        public Criteria andMinBookingNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MIN_BOOKING not in", values, "minBooking");
            return (Criteria) this;
        }

        public Criteria andMinBookingBetween(Integer value1, Integer value2) {
            addCriterion("MIN_BOOKING between", value1, value2, "minBooking");
            return (Criteria) this;
        }

        public Criteria andMinBookingNotBetween(Integer value1, Integer value2) {
            addCriterion("MIN_BOOKING not between", value1, value2, "minBooking");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekIsNull() {
            addCriterion("DAY_OF_WEEK is null");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekIsNotNull() {
            addCriterion("DAY_OF_WEEK is not null");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekEqualTo(Integer value) {
            addCriterion("DAY_OF_WEEK =", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekNotEqualTo(Integer value) {
            addCriterion("DAY_OF_WEEK <>", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekGreaterThan(Integer value) {
            addCriterion("DAY_OF_WEEK >", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("DAY_OF_WEEK >=", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekLessThan(Integer value) {
            addCriterion("DAY_OF_WEEK <", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekLessThanOrEqualTo(Integer value) {
            addCriterion("DAY_OF_WEEK <=", value, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekIn(java.util.List<java.lang.Integer> values) {
            addCriterion("DAY_OF_WEEK in", values, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("DAY_OF_WEEK not in", values, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekBetween(Integer value1, Integer value2) {
            addCriterion("DAY_OF_WEEK between", value1, value2, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("DAY_OF_WEEK not between", value1, value2, "dayOfWeek");
            return (Criteria) this;
        }

        public Criteria andCutoffIsNull() {
            addCriterion("CUTOFF is null");
            return (Criteria) this;
        }

        public Criteria andCutoffIsNotNull() {
            addCriterion("CUTOFF is not null");
            return (Criteria) this;
        }

        public Criteria andCutoffEqualTo(Integer value) {
            addCriterion("CUTOFF =", value, "cutoff");
            return (Criteria) this;
        }

        public Criteria andCutoffNotEqualTo(Integer value) {
            addCriterion("CUTOFF <>", value, "cutoff");
            return (Criteria) this;
        }

        public Criteria andCutoffGreaterThan(Integer value) {
            addCriterion("CUTOFF >", value, "cutoff");
            return (Criteria) this;
        }

        public Criteria andCutoffGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUTOFF >=", value, "cutoff");
            return (Criteria) this;
        }

        public Criteria andCutoffLessThan(Integer value) {
            addCriterion("CUTOFF <", value, "cutoff");
            return (Criteria) this;
        }

        public Criteria andCutoffLessThanOrEqualTo(Integer value) {
            addCriterion("CUTOFF <=", value, "cutoff");
            return (Criteria) this;
        }

        public Criteria andCutoffIn(java.util.List<java.lang.Integer> values) {
            addCriterion("CUTOFF in", values, "cutoff");
            return (Criteria) this;
        }

        public Criteria andCutoffNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("CUTOFF not in", values, "cutoff");
            return (Criteria) this;
        }

        public Criteria andCutoffBetween(Integer value1, Integer value2) {
            addCriterion("CUTOFF between", value1, value2, "cutoff");
            return (Criteria) this;
        }

        public Criteria andCutoffNotBetween(Integer value1, Integer value2) {
            addCriterion("CUTOFF not between", value1, value2, "cutoff");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceIsNull() {
            addCriterion("OVERBOOKING_ALLOWANCE is null");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceIsNotNull() {
            addCriterion("OVERBOOKING_ALLOWANCE is not null");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceEqualTo(Integer value) {
            addCriterion("OVERBOOKING_ALLOWANCE =", value, "overbookingAllowance");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceNotEqualTo(Integer value) {
            addCriterion("OVERBOOKING_ALLOWANCE <>", value, "overbookingAllowance");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceGreaterThan(Integer value) {
            addCriterion("OVERBOOKING_ALLOWANCE >", value, "overbookingAllowance");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("OVERBOOKING_ALLOWANCE >=", value, "overbookingAllowance");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceLessThan(Integer value) {
            addCriterion("OVERBOOKING_ALLOWANCE <", value, "overbookingAllowance");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceLessThanOrEqualTo(Integer value) {
            addCriterion("OVERBOOKING_ALLOWANCE <=", value, "overbookingAllowance");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceIn(java.util.List<java.lang.Integer> values) {
            addCriterion("OVERBOOKING_ALLOWANCE in", values, "overbookingAllowance");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("OVERBOOKING_ALLOWANCE not in", values, "overbookingAllowance");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceBetween(Integer value1, Integer value2) {
            addCriterion("OVERBOOKING_ALLOWANCE between", value1, value2, "overbookingAllowance");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceNotBetween(Integer value1, Integer value2) {
            addCriterion("OVERBOOKING_ALLOWANCE not between", value1, value2, "overbookingAllowance");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowIsNull() {
            addCriterion("FORWARD_BOOKING_WINDOW is null");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowIsNotNull() {
            addCriterion("FORWARD_BOOKING_WINDOW is not null");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowEqualTo(Integer value) {
            addCriterion("FORWARD_BOOKING_WINDOW =", value, "forwardBookingWindow");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowNotEqualTo(Integer value) {
            addCriterion("FORWARD_BOOKING_WINDOW <>", value, "forwardBookingWindow");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowGreaterThan(Integer value) {
            addCriterion("FORWARD_BOOKING_WINDOW >", value, "forwardBookingWindow");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowGreaterThanOrEqualTo(Integer value) {
            addCriterion("FORWARD_BOOKING_WINDOW >=", value, "forwardBookingWindow");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowLessThan(Integer value) {
            addCriterion("FORWARD_BOOKING_WINDOW <", value, "forwardBookingWindow");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowLessThanOrEqualTo(Integer value) {
            addCriterion("FORWARD_BOOKING_WINDOW <=", value, "forwardBookingWindow");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowIn(java.util.List<java.lang.Integer> values) {
            addCriterion("FORWARD_BOOKING_WINDOW in", values, "forwardBookingWindow");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("FORWARD_BOOKING_WINDOW not in", values, "forwardBookingWindow");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowBetween(Integer value1, Integer value2) {
            addCriterion("FORWARD_BOOKING_WINDOW between", value1, value2, "forwardBookingWindow");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowNotBetween(Integer value1, Integer value2) {
            addCriterion("FORWARD_BOOKING_WINDOW not between", value1, value2, "forwardBookingWindow");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowIsNull() {
            addCriterion("PAST_BOOKING_WINDOW is null");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowIsNotNull() {
            addCriterion("PAST_BOOKING_WINDOW is not null");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowEqualTo(Integer value) {
            addCriterion("PAST_BOOKING_WINDOW =", value, "pastBookingWindow");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowNotEqualTo(Integer value) {
            addCriterion("PAST_BOOKING_WINDOW <>", value, "pastBookingWindow");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowGreaterThan(Integer value) {
            addCriterion("PAST_BOOKING_WINDOW >", value, "pastBookingWindow");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAST_BOOKING_WINDOW >=", value, "pastBookingWindow");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowLessThan(Integer value) {
            addCriterion("PAST_BOOKING_WINDOW <", value, "pastBookingWindow");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowLessThanOrEqualTo(Integer value) {
            addCriterion("PAST_BOOKING_WINDOW <=", value, "pastBookingWindow");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowIn(java.util.List<java.lang.Integer> values) {
            addCriterion("PAST_BOOKING_WINDOW in", values, "pastBookingWindow");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("PAST_BOOKING_WINDOW not in", values, "pastBookingWindow");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowBetween(Integer value1, Integer value2) {
            addCriterion("PAST_BOOKING_WINDOW between", value1, value2, "pastBookingWindow");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowNotBetween(Integer value1, Integer value2) {
            addCriterion("PAST_BOOKING_WINDOW not between", value1, value2, "pastBookingWindow");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyIsNull() {
            addCriterion("MAX_MEONY is null");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyIsNotNull() {
            addCriterion("MAX_MEONY is not null");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyEqualTo(String value) {
            addCriterion("MAX_MEONY =", value, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyNotEqualTo(String value) {
            addCriterion("MAX_MEONY <>", value, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyGreaterThan(String value) {
            addCriterion("MAX_MEONY >", value, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyGreaterThanOrEqualTo(String value) {
            addCriterion("MAX_MEONY >=", value, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyLessThan(String value) {
            addCriterion("MAX_MEONY <", value, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyLessThanOrEqualTo(String value) {
            addCriterion("MAX_MEONY <=", value, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyLike(String value) {
            addCriterion("MAX_MEONY like", value, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyNotLike(String value) {
            addCriterion("MAX_MEONY not like", value, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyIn(java.util.List<java.lang.String> values) {
            addCriterion("MAX_MEONY in", values, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MAX_MEONY not in", values, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyBetween(String value1, String value2) {
            addCriterion("MAX_MEONY between", value1, value2, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyNotBetween(String value1, String value2) {
            addCriterion("MAX_MEONY not between", value1, value2, "maxMeony");
            return (Criteria) this;
        }

        public Criteria andMinMoneyIsNull() {
            addCriterion("MIN_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andMinMoneyIsNotNull() {
            addCriterion("MIN_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andMinMoneyEqualTo(String value) {
            addCriterion("MIN_MONEY =", value, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMinMoneyNotEqualTo(String value) {
            addCriterion("MIN_MONEY <>", value, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMinMoneyGreaterThan(String value) {
            addCriterion("MIN_MONEY >", value, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMinMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("MIN_MONEY >=", value, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMinMoneyLessThan(String value) {
            addCriterion("MIN_MONEY <", value, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMinMoneyLessThanOrEqualTo(String value) {
            addCriterion("MIN_MONEY <=", value, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMinMoneyLike(String value) {
            addCriterion("MIN_MONEY like", value, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMinMoneyNotLike(String value) {
            addCriterion("MIN_MONEY not like", value, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMinMoneyIn(java.util.List<java.lang.String> values) {
            addCriterion("MIN_MONEY in", values, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMinMoneyNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MIN_MONEY not in", values, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMinMoneyBetween(String value1, String value2) {
            addCriterion("MIN_MONEY between", value1, value2, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMinMoneyNotBetween(String value1, String value2) {
            addCriterion("MIN_MONEY not between", value1, value2, "minMoney");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToIsNull() {
            addCriterion("MAX_DURATION_APPLY_TO is null");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToIsNotNull() {
            addCriterion("MAX_DURATION_APPLY_TO is not null");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToEqualTo(String value) {
            addCriterion("MAX_DURATION_APPLY_TO =", value, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToNotEqualTo(String value) {
            addCriterion("MAX_DURATION_APPLY_TO <>", value, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToGreaterThan(String value) {
            addCriterion("MAX_DURATION_APPLY_TO >", value, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToGreaterThanOrEqualTo(String value) {
            addCriterion("MAX_DURATION_APPLY_TO >=", value, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToLessThan(String value) {
            addCriterion("MAX_DURATION_APPLY_TO <", value, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToLessThanOrEqualTo(String value) {
            addCriterion("MAX_DURATION_APPLY_TO <=", value, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToLike(String value) {
            addCriterion("MAX_DURATION_APPLY_TO like", value, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToNotLike(String value) {
            addCriterion("MAX_DURATION_APPLY_TO not like", value, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToIn(java.util.List<java.lang.String> values) {
            addCriterion("MAX_DURATION_APPLY_TO in", values, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MAX_DURATION_APPLY_TO not in", values, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToBetween(String value1, String value2) {
            addCriterion("MAX_DURATION_APPLY_TO between", value1, value2, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxDurationApplyToNotBetween(String value1, String value2) {
            addCriterion("MAX_DURATION_APPLY_TO not between", value1, value2, "maxDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToIsNull() {
            addCriterion("MIN_DURATION_APPLY_TO is null");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToIsNotNull() {
            addCriterion("MIN_DURATION_APPLY_TO is not null");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToEqualTo(String value) {
            addCriterion("MIN_DURATION_APPLY_TO =", value, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToNotEqualTo(String value) {
            addCriterion("MIN_DURATION_APPLY_TO <>", value, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToGreaterThan(String value) {
            addCriterion("MIN_DURATION_APPLY_TO >", value, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToGreaterThanOrEqualTo(String value) {
            addCriterion("MIN_DURATION_APPLY_TO >=", value, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToLessThan(String value) {
            addCriterion("MIN_DURATION_APPLY_TO <", value, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToLessThanOrEqualTo(String value) {
            addCriterion("MIN_DURATION_APPLY_TO <=", value, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToLike(String value) {
            addCriterion("MIN_DURATION_APPLY_TO like", value, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToNotLike(String value) {
            addCriterion("MIN_DURATION_APPLY_TO not like", value, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToIn(java.util.List<java.lang.String> values) {
            addCriterion("MIN_DURATION_APPLY_TO in", values, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MIN_DURATION_APPLY_TO not in", values, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToBetween(String value1, String value2) {
            addCriterion("MIN_DURATION_APPLY_TO between", value1, value2, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinDurationApplyToNotBetween(String value1, String value2) {
            addCriterion("MIN_DURATION_APPLY_TO not between", value1, value2, "minDurationApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToIsNull() {
            addCriterion("MAX_BOOKING_APPLY_TO is null");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToIsNotNull() {
            addCriterion("MAX_BOOKING_APPLY_TO is not null");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToEqualTo(String value) {
            addCriterion("MAX_BOOKING_APPLY_TO =", value, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToNotEqualTo(String value) {
            addCriterion("MAX_BOOKING_APPLY_TO <>", value, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToGreaterThan(String value) {
            addCriterion("MAX_BOOKING_APPLY_TO >", value, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToGreaterThanOrEqualTo(String value) {
            addCriterion("MAX_BOOKING_APPLY_TO >=", value, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToLessThan(String value) {
            addCriterion("MAX_BOOKING_APPLY_TO <", value, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToLessThanOrEqualTo(String value) {
            addCriterion("MAX_BOOKING_APPLY_TO <=", value, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToLike(String value) {
            addCriterion("MAX_BOOKING_APPLY_TO like", value, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToNotLike(String value) {
            addCriterion("MAX_BOOKING_APPLY_TO not like", value, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToIn(java.util.List<java.lang.String> values) {
            addCriterion("MAX_BOOKING_APPLY_TO in", values, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MAX_BOOKING_APPLY_TO not in", values, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToBetween(String value1, String value2) {
            addCriterion("MAX_BOOKING_APPLY_TO between", value1, value2, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxBookingApplyToNotBetween(String value1, String value2) {
            addCriterion("MAX_BOOKING_APPLY_TO not between", value1, value2, "maxBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToIsNull() {
            addCriterion("MIN_BOOKING_APPLY_TO is null");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToIsNotNull() {
            addCriterion("MIN_BOOKING_APPLY_TO is not null");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToEqualTo(String value) {
            addCriterion("MIN_BOOKING_APPLY_TO =", value, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToNotEqualTo(String value) {
            addCriterion("MIN_BOOKING_APPLY_TO <>", value, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToGreaterThan(String value) {
            addCriterion("MIN_BOOKING_APPLY_TO >", value, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToGreaterThanOrEqualTo(String value) {
            addCriterion("MIN_BOOKING_APPLY_TO >=", value, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToLessThan(String value) {
            addCriterion("MIN_BOOKING_APPLY_TO <", value, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToLessThanOrEqualTo(String value) {
            addCriterion("MIN_BOOKING_APPLY_TO <=", value, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToLike(String value) {
            addCriterion("MIN_BOOKING_APPLY_TO like", value, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToNotLike(String value) {
            addCriterion("MIN_BOOKING_APPLY_TO not like", value, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToIn(java.util.List<java.lang.String> values) {
            addCriterion("MIN_BOOKING_APPLY_TO in", values, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MIN_BOOKING_APPLY_TO not in", values, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToBetween(String value1, String value2) {
            addCriterion("MIN_BOOKING_APPLY_TO between", value1, value2, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinBookingApplyToNotBetween(String value1, String value2) {
            addCriterion("MIN_BOOKING_APPLY_TO not between", value1, value2, "minBookingApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToIsNull() {
            addCriterion("DAY_OF_WEEK_APPLY_TO is null");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToIsNotNull() {
            addCriterion("DAY_OF_WEEK_APPLY_TO is not null");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToEqualTo(String value) {
            addCriterion("DAY_OF_WEEK_APPLY_TO =", value, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToNotEqualTo(String value) {
            addCriterion("DAY_OF_WEEK_APPLY_TO <>", value, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToGreaterThan(String value) {
            addCriterion("DAY_OF_WEEK_APPLY_TO >", value, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToGreaterThanOrEqualTo(String value) {
            addCriterion("DAY_OF_WEEK_APPLY_TO >=", value, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToLessThan(String value) {
            addCriterion("DAY_OF_WEEK_APPLY_TO <", value, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToLessThanOrEqualTo(String value) {
            addCriterion("DAY_OF_WEEK_APPLY_TO <=", value, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToLike(String value) {
            addCriterion("DAY_OF_WEEK_APPLY_TO like", value, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToNotLike(String value) {
            addCriterion("DAY_OF_WEEK_APPLY_TO not like", value, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToIn(java.util.List<java.lang.String> values) {
            addCriterion("DAY_OF_WEEK_APPLY_TO in", values, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("DAY_OF_WEEK_APPLY_TO not in", values, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToBetween(String value1, String value2) {
            addCriterion("DAY_OF_WEEK_APPLY_TO between", value1, value2, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andDayOfWeekApplyToNotBetween(String value1, String value2) {
            addCriterion("DAY_OF_WEEK_APPLY_TO not between", value1, value2, "dayOfWeekApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToIsNull() {
            addCriterion("CUTOFF_APPLY_TO is null");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToIsNotNull() {
            addCriterion("CUTOFF_APPLY_TO is not null");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToEqualTo(String value) {
            addCriterion("CUTOFF_APPLY_TO =", value, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToNotEqualTo(String value) {
            addCriterion("CUTOFF_APPLY_TO <>", value, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToGreaterThan(String value) {
            addCriterion("CUTOFF_APPLY_TO >", value, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToGreaterThanOrEqualTo(String value) {
            addCriterion("CUTOFF_APPLY_TO >=", value, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToLessThan(String value) {
            addCriterion("CUTOFF_APPLY_TO <", value, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToLessThanOrEqualTo(String value) {
            addCriterion("CUTOFF_APPLY_TO <=", value, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToLike(String value) {
            addCriterion("CUTOFF_APPLY_TO like", value, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToNotLike(String value) {
            addCriterion("CUTOFF_APPLY_TO not like", value, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToIn(java.util.List<java.lang.String> values) {
            addCriterion("CUTOFF_APPLY_TO in", values, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("CUTOFF_APPLY_TO not in", values, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToBetween(String value1, String value2) {
            addCriterion("CUTOFF_APPLY_TO between", value1, value2, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andCutoffApplyToNotBetween(String value1, String value2) {
            addCriterion("CUTOFF_APPLY_TO not between", value1, value2, "cutoffApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToIsNull() {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO is null");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToIsNotNull() {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO is not null");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToEqualTo(String value) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO =", value, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToNotEqualTo(String value) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO <>", value, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToGreaterThan(String value) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO >", value, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToGreaterThanOrEqualTo(String value) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO >=", value, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToLessThan(String value) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO <", value, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToLessThanOrEqualTo(String value) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO <=", value, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToLike(String value) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO like", value, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToNotLike(String value) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO not like", value, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToIn(java.util.List<java.lang.String> values) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO in", values, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO not in", values, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToBetween(String value1, String value2) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO between", value1, value2, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andOverbookingAllowanceApplyToNotBetween(String value1, String value2) {
            addCriterion("OVERBOOKING_ALLOWANCE_APPLY_TO not between", value1, value2, "overbookingAllowanceApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToIsNull() {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO is null");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToIsNotNull() {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO is not null");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToEqualTo(String value) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO =", value, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToNotEqualTo(String value) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO <>", value, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToGreaterThan(String value) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO >", value, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToGreaterThanOrEqualTo(String value) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO >=", value, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToLessThan(String value) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO <", value, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToLessThanOrEqualTo(String value) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO <=", value, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToLike(String value) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO like", value, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToNotLike(String value) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO not like", value, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToIn(java.util.List<java.lang.String> values) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO in", values, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO not in", values, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToBetween(String value1, String value2) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO between", value1, value2, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andForwardBookingWindowApplyToNotBetween(String value1, String value2) {
            addCriterion("FORWARD_BOOKING_WINDOW_APPLY_TO not between", value1, value2, "forwardBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToIsNull() {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO is null");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToIsNotNull() {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO is not null");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToEqualTo(String value) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO =", value, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToNotEqualTo(String value) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO <>", value, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToGreaterThan(String value) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO >", value, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToGreaterThanOrEqualTo(String value) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO >=", value, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToLessThan(String value) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO <", value, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToLessThanOrEqualTo(String value) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO <=", value, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToLike(String value) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO like", value, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToNotLike(String value) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO not like", value, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToIn(java.util.List<java.lang.String> values) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO in", values, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO not in", values, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToBetween(String value1, String value2) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO between", value1, value2, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andPastBookingWindowApplyToNotBetween(String value1, String value2) {
            addCriterion("PAST_BOOKING_WINDOW_APPLY_TO not between", value1, value2, "pastBookingWindowApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToIsNull() {
            addCriterion("MAX_MEONY_APPLY_TO is null");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToIsNotNull() {
            addCriterion("MAX_MEONY_APPLY_TO is not null");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToEqualTo(String value) {
            addCriterion("MAX_MEONY_APPLY_TO =", value, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToNotEqualTo(String value) {
            addCriterion("MAX_MEONY_APPLY_TO <>", value, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToGreaterThan(String value) {
            addCriterion("MAX_MEONY_APPLY_TO >", value, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToGreaterThanOrEqualTo(String value) {
            addCriterion("MAX_MEONY_APPLY_TO >=", value, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToLessThan(String value) {
            addCriterion("MAX_MEONY_APPLY_TO <", value, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToLessThanOrEqualTo(String value) {
            addCriterion("MAX_MEONY_APPLY_TO <=", value, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToLike(String value) {
            addCriterion("MAX_MEONY_APPLY_TO like", value, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToNotLike(String value) {
            addCriterion("MAX_MEONY_APPLY_TO not like", value, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToIn(java.util.List<java.lang.String> values) {
            addCriterion("MAX_MEONY_APPLY_TO in", values, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MAX_MEONY_APPLY_TO not in", values, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToBetween(String value1, String value2) {
            addCriterion("MAX_MEONY_APPLY_TO between", value1, value2, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMaxMeonyApplyToNotBetween(String value1, String value2) {
            addCriterion("MAX_MEONY_APPLY_TO not between", value1, value2, "maxMeonyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToIsNull() {
            addCriterion("MIN_MONEY_APPLY_TO is null");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToIsNotNull() {
            addCriterion("MIN_MONEY_APPLY_TO is not null");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToEqualTo(String value) {
            addCriterion("MIN_MONEY_APPLY_TO =", value, "minMoneyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToNotEqualTo(String value) {
            addCriterion("MIN_MONEY_APPLY_TO <>", value, "minMoneyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToGreaterThan(String value) {
            addCriterion("MIN_MONEY_APPLY_TO >", value, "minMoneyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToGreaterThanOrEqualTo(String value) {
            addCriterion("MIN_MONEY_APPLY_TO >=", value, "minMoneyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToLessThan(String value) {
            addCriterion("MIN_MONEY_APPLY_TO <", value, "minMoneyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToLessThanOrEqualTo(String value) {
            addCriterion("MIN_MONEY_APPLY_TO <=", value, "minMoneyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToLike(String value) {
            addCriterion("MIN_MONEY_APPLY_TO like", value, "minMoneyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToNotLike(String value) {
            addCriterion("MIN_MONEY_APPLY_TO not like", value, "minMoneyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToIn(java.util.List<java.lang.String> values) {
            addCriterion("MIN_MONEY_APPLY_TO in", values, "minMoneyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MIN_MONEY_APPLY_TO not in", values, "minMoneyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToBetween(String value1, String value2) {
            addCriterion("MIN_MONEY_APPLY_TO between", value1, value2, "minMoneyApplyTo");
            return (Criteria) this;
        }

        public Criteria andMinMoneyApplyToNotBetween(String value1, String value2) {
            addCriterion("MIN_MONEY_APPLY_TO not between", value1, value2, "minMoneyApplyTo");
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