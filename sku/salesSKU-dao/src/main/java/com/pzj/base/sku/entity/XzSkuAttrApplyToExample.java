package com.pzj.base.sku.entity;

import java.util.ArrayList;
import java.util.List;

public class XzSkuAttrApplyToExample {

    protected String orderByClause;

    protected boolean distinct;

    protected java.util.List<Criteria> oredCriteria;

    protected int start = -1;

    protected int pageSize = -1;

    public XzSkuAttrApplyToExample() {
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

        public Criteria andSkuAttrIdIsNull() {
            addCriterion("SKU_ATTR_ID is null");
            return (Criteria) this;
        }

        public Criteria andSkuAttrIdIsNotNull() {
            addCriterion("SKU_ATTR_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSkuAttrIdEqualTo(Integer value) {
            addCriterion("SKU_ATTR_ID =", value, "skuAttrId");
            return (Criteria) this;
        }

        public Criteria andSkuAttrIdNotEqualTo(Integer value) {
            addCriterion("SKU_ATTR_ID <>", value, "skuAttrId");
            return (Criteria) this;
        }

        public Criteria andSkuAttrIdGreaterThan(Integer value) {
            addCriterion("SKU_ATTR_ID >", value, "skuAttrId");
            return (Criteria) this;
        }

        public Criteria andSkuAttrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SKU_ATTR_ID >=", value, "skuAttrId");
            return (Criteria) this;
        }

        public Criteria andSkuAttrIdLessThan(Integer value) {
            addCriterion("SKU_ATTR_ID <", value, "skuAttrId");
            return (Criteria) this;
        }

        public Criteria andSkuAttrIdLessThanOrEqualTo(Integer value) {
            addCriterion("SKU_ATTR_ID <=", value, "skuAttrId");
            return (Criteria) this;
        }

        public Criteria andSkuAttrIdIn(java.util.List<java.lang.Integer> values) {
            addCriterion("SKU_ATTR_ID in", values, "skuAttrId");
            return (Criteria) this;
        }

        public Criteria andSkuAttrIdNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("SKU_ATTR_ID not in", values, "skuAttrId");
            return (Criteria) this;
        }

        public Criteria andSkuAttrIdBetween(Integer value1, Integer value2) {
            addCriterion("SKU_ATTR_ID between", value1, value2, "skuAttrId");
            return (Criteria) this;
        }

        public Criteria andSkuAttrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SKU_ATTR_ID not between", value1, value2, "skuAttrId");
            return (Criteria) this;
        }

        public Criteria andMinNumIsNull() {
            addCriterion("MIN_NUM is null");
            return (Criteria) this;
        }

        public Criteria andMinNumIsNotNull() {
            addCriterion("MIN_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andMinNumEqualTo(Integer value) {
            addCriterion("MIN_NUM =", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotEqualTo(Integer value) {
            addCriterion("MIN_NUM <>", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumGreaterThan(Integer value) {
            addCriterion("MIN_NUM >", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("MIN_NUM >=", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumLessThan(Integer value) {
            addCriterion("MIN_NUM <", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumLessThanOrEqualTo(Integer value) {
            addCriterion("MIN_NUM <=", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MIN_NUM in", values, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MIN_NUM not in", values, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumBetween(Integer value1, Integer value2) {
            addCriterion("MIN_NUM between", value1, value2, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotBetween(Integer value1, Integer value2) {
            addCriterion("MIN_NUM not between", value1, value2, "minNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumIsNull() {
            addCriterion("MAX_NUM is null");
            return (Criteria) this;
        }

        public Criteria andMaxNumIsNotNull() {
            addCriterion("MAX_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andMaxNumEqualTo(Integer value) {
            addCriterion("MAX_NUM =", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotEqualTo(Integer value) {
            addCriterion("MAX_NUM <>", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumGreaterThan(Integer value) {
            addCriterion("MAX_NUM >", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_NUM >=", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumLessThan(Integer value) {
            addCriterion("MAX_NUM <", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_NUM <=", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAX_NUM in", values, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAX_NUM not in", values, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumBetween(Integer value1, Integer value2) {
            addCriterion("MAX_NUM between", value1, value2, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_NUM not between", value1, value2, "maxNum");
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