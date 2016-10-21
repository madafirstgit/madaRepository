package com.pzj.base.sku.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class XzSkuPkgExample {

    protected String orderByClause;

    protected boolean distinct;

    protected java.util.List<Criteria> oredCriteria;

    protected int start = -1;

    protected int pageSize = -1;

    public XzSkuPkgExample() {
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

        public Criteria andPackageTypeIsNull() {
            addCriterion("PACKAGE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPackageTypeIsNotNull() {
            addCriterion("PACKAGE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPackageTypeEqualTo(String value) {
            addCriterion("PACKAGE_TYPE =", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeNotEqualTo(String value) {
            addCriterion("PACKAGE_TYPE <>", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeGreaterThan(String value) {
            addCriterion("PACKAGE_TYPE >", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PACKAGE_TYPE >=", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeLessThan(String value) {
            addCriterion("PACKAGE_TYPE <", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeLessThanOrEqualTo(String value) {
            addCriterion("PACKAGE_TYPE <=", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeLike(String value) {
            addCriterion("PACKAGE_TYPE like", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeNotLike(String value) {
            addCriterion("PACKAGE_TYPE not like", value, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("PACKAGE_TYPE in", values, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("PACKAGE_TYPE not in", values, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeBetween(String value1, String value2) {
            addCriterion("PACKAGE_TYPE between", value1, value2, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageTypeNotBetween(String value1, String value2) {
            addCriterion("PACKAGE_TYPE not between", value1, value2, "packageType");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdIsNull() {
            addCriterion("PACKAGE_SKU_ID is null");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdIsNotNull() {
            addCriterion("PACKAGE_SKU_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdEqualTo(Integer value) {
            addCriterion("PACKAGE_SKU_ID =", value, "packageSkuId");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdNotEqualTo(Integer value) {
            addCriterion("PACKAGE_SKU_ID <>", value, "packageSkuId");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdGreaterThan(Integer value) {
            addCriterion("PACKAGE_SKU_ID >", value, "packageSkuId");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PACKAGE_SKU_ID >=", value, "packageSkuId");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdLessThan(Integer value) {
            addCriterion("PACKAGE_SKU_ID <", value, "packageSkuId");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdLessThanOrEqualTo(Integer value) {
            addCriterion("PACKAGE_SKU_ID <=", value, "packageSkuId");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdIn(java.util.List<java.lang.Integer> values) {
            addCriterion("PACKAGE_SKU_ID in", values, "packageSkuId");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("PACKAGE_SKU_ID not in", values, "packageSkuId");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdBetween(Integer value1, Integer value2) {
            addCriterion("PACKAGE_SKU_ID between", value1, value2, "packageSkuId");
            return (Criteria) this;
        }

        public Criteria andPackageSkuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PACKAGE_SKU_ID not between", value1, value2, "packageSkuId");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIsNull() {
            addCriterion("PACKAGE_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIsNotNull() {
            addCriterion("PACKAGE_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPackagePriceEqualTo(BigDecimal value) {
            addCriterion("PACKAGE_PRICE =", value, "packagePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePriceNotEqualTo(BigDecimal value) {
            addCriterion("PACKAGE_PRICE <>", value, "packagePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePriceGreaterThan(BigDecimal value) {
            addCriterion("PACKAGE_PRICE >", value, "packagePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PACKAGE_PRICE >=", value, "packagePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePriceLessThan(BigDecimal value) {
            addCriterion("PACKAGE_PRICE <", value, "packagePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PACKAGE_PRICE <=", value, "packagePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePriceIn(java.util.List<java.math.BigDecimal> values) {
            addCriterion("PACKAGE_PRICE in", values, "packagePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePriceNotIn(java.util.List<java.math.BigDecimal> values) {
            addCriterion("PACKAGE_PRICE not in", values, "packagePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PACKAGE_PRICE between", value1, value2, "packagePrice");
            return (Criteria) this;
        }

        public Criteria andPackagePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PACKAGE_PRICE not between", value1, value2, "packagePrice");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeIsNull() {
            addCriterion("PACKAGE_IN_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeIsNotNull() {
            addCriterion("PACKAGE_IN_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeEqualTo(String value) {
            addCriterion("PACKAGE_IN_TYPE =", value, "packageInType");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeNotEqualTo(String value) {
            addCriterion("PACKAGE_IN_TYPE <>", value, "packageInType");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeGreaterThan(String value) {
            addCriterion("PACKAGE_IN_TYPE >", value, "packageInType");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PACKAGE_IN_TYPE >=", value, "packageInType");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeLessThan(String value) {
            addCriterion("PACKAGE_IN_TYPE <", value, "packageInType");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeLessThanOrEqualTo(String value) {
            addCriterion("PACKAGE_IN_TYPE <=", value, "packageInType");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeLike(String value) {
            addCriterion("PACKAGE_IN_TYPE like", value, "packageInType");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeNotLike(String value) {
            addCriterion("PACKAGE_IN_TYPE not like", value, "packageInType");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeIn(java.util.List<java.lang.String> values) {
            addCriterion("PACKAGE_IN_TYPE in", values, "packageInType");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("PACKAGE_IN_TYPE not in", values, "packageInType");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeBetween(String value1, String value2) {
            addCriterion("PACKAGE_IN_TYPE between", value1, value2, "packageInType");
            return (Criteria) this;
        }

        public Criteria andPackageInTypeNotBetween(String value1, String value2) {
            addCriterion("PACKAGE_IN_TYPE not between", value1, value2, "packageInType");
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