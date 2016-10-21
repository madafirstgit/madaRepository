package com.pzj.base.sku.entity;

import java.util.ArrayList;
import java.util.List;

public class XzSkuAttrExample {

    protected String orderByClause;

    protected boolean distinct;

    protected java.util.List<Criteria> oredCriteria;

    protected int start = -1;

    protected int pageSize = -1;

    public XzSkuAttrExample() {
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

        public Criteria andDefaultValueIsNull() {
            addCriterion("DEFAULT_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIsNotNull() {
            addCriterion("DEFAULT_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultValueEqualTo(Integer value) {
            addCriterion("DEFAULT_VALUE =", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotEqualTo(Integer value) {
            addCriterion("DEFAULT_VALUE <>", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThan(Integer value) {
            addCriterion("DEFAULT_VALUE >", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEFAULT_VALUE >=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThan(Integer value) {
            addCriterion("DEFAULT_VALUE <", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueLessThanOrEqualTo(Integer value) {
            addCriterion("DEFAULT_VALUE <=", value, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueIn(java.util.List<java.lang.Integer> values) {
            addCriterion("DEFAULT_VALUE in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("DEFAULT_VALUE not in", values, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueBetween(Integer value1, Integer value2) {
            addCriterion("DEFAULT_VALUE between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andDefaultValueNotBetween(Integer value1, Integer value2) {
            addCriterion("DEFAULT_VALUE not between", value1, value2, "defaultValue");
            return (Criteria) this;
        }

        public Criteria andHasPriceIsNull() {
            addCriterion("HAS_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andHasPriceIsNotNull() {
            addCriterion("HAS_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andHasPriceEqualTo(Boolean value) {
            addCriterion("HAS_PRICE =", value, "hasPrice");
            return (Criteria) this;
        }

        public Criteria andHasPriceNotEqualTo(Boolean value) {
            addCriterion("HAS_PRICE <>", value, "hasPrice");
            return (Criteria) this;
        }

        public Criteria andHasPriceGreaterThan(Boolean value) {
            addCriterion("HAS_PRICE >", value, "hasPrice");
            return (Criteria) this;
        }

        public Criteria andHasPriceGreaterThanOrEqualTo(Boolean value) {
            addCriterion("HAS_PRICE >=", value, "hasPrice");
            return (Criteria) this;
        }

        public Criteria andHasPriceLessThan(Boolean value) {
            addCriterion("HAS_PRICE <", value, "hasPrice");
            return (Criteria) this;
        }

        public Criteria andHasPriceLessThanOrEqualTo(Boolean value) {
            addCriterion("HAS_PRICE <=", value, "hasPrice");
            return (Criteria) this;
        }

        public Criteria andHasPriceIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("HAS_PRICE in", values, "hasPrice");
            return (Criteria) this;
        }

        public Criteria andHasPriceNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("HAS_PRICE not in", values, "hasPrice");
            return (Criteria) this;
        }

        public Criteria andHasPriceBetween(Boolean value1, Boolean value2) {
            addCriterion("HAS_PRICE between", value1, value2, "hasPrice");
            return (Criteria) this;
        }

        public Criteria andHasPriceNotBetween(Boolean value1, Boolean value2) {
            addCriterion("HAS_PRICE not between", value1, value2, "hasPrice");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeIsNull() {
            addCriterion("IS_DISPLAY_RANGE is null");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeIsNotNull() {
            addCriterion("IS_DISPLAY_RANGE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeEqualTo(Boolean value) {
            addCriterion("IS_DISPLAY_RANGE =", value, "isDisplayRange");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeNotEqualTo(Boolean value) {
            addCriterion("IS_DISPLAY_RANGE <>", value, "isDisplayRange");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeGreaterThan(Boolean value) {
            addCriterion("IS_DISPLAY_RANGE >", value, "isDisplayRange");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_DISPLAY_RANGE >=", value, "isDisplayRange");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeLessThan(Boolean value) {
            addCriterion("IS_DISPLAY_RANGE <", value, "isDisplayRange");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_DISPLAY_RANGE <=", value, "isDisplayRange");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("IS_DISPLAY_RANGE in", values, "isDisplayRange");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("IS_DISPLAY_RANGE not in", values, "isDisplayRange");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_DISPLAY_RANGE between", value1, value2, "isDisplayRange");
            return (Criteria) this;
        }

        public Criteria andIsDisplayRangeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_DISPLAY_RANGE not between", value1, value2, "isDisplayRange");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryIsNull() {
            addCriterion("IS_CTRL_INVENTORY is null");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryIsNotNull() {
            addCriterion("IS_CTRL_INVENTORY is not null");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryEqualTo(Boolean value) {
            addCriterion("IS_CTRL_INVENTORY =", value, "isCtrlInventory");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryNotEqualTo(Boolean value) {
            addCriterion("IS_CTRL_INVENTORY <>", value, "isCtrlInventory");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryGreaterThan(Boolean value) {
            addCriterion("IS_CTRL_INVENTORY >", value, "isCtrlInventory");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_CTRL_INVENTORY >=", value, "isCtrlInventory");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryLessThan(Boolean value) {
            addCriterion("IS_CTRL_INVENTORY <", value, "isCtrlInventory");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_CTRL_INVENTORY <=", value, "isCtrlInventory");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("IS_CTRL_INVENTORY in", values, "isCtrlInventory");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("IS_CTRL_INVENTORY not in", values, "isCtrlInventory");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_CTRL_INVENTORY between", value1, value2, "isCtrlInventory");
            return (Criteria) this;
        }

        public Criteria andIsCtrlInventoryNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_CTRL_INVENTORY not between", value1, value2, "isCtrlInventory");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIsNull() {
            addCriterion("IS_REQUIRED is null");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIsNotNull() {
            addCriterion("IS_REQUIRED is not null");
            return (Criteria) this;
        }

        public Criteria andIsRequiredEqualTo(Boolean value) {
            addCriterion("IS_REQUIRED =", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotEqualTo(Boolean value) {
            addCriterion("IS_REQUIRED <>", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredGreaterThan(Boolean value) {
            addCriterion("IS_REQUIRED >", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_REQUIRED >=", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredLessThan(Boolean value) {
            addCriterion("IS_REQUIRED <", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_REQUIRED <=", value, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("IS_REQUIRED in", values, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("IS_REQUIRED not in", values, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_REQUIRED between", value1, value2, "isRequired");
            return (Criteria) this;
        }

        public Criteria andIsRequiredNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_REQUIRED not between", value1, value2, "isRequired");
            return (Criteria) this;
        }

        public Criteria andVisibilityIsNull() {
            addCriterion("VISIBILITY is null");
            return (Criteria) this;
        }

        public Criteria andVisibilityIsNotNull() {
            addCriterion("VISIBILITY is not null");
            return (Criteria) this;
        }

        public Criteria andVisibilityEqualTo(String value) {
            addCriterion("VISIBILITY =", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityNotEqualTo(String value) {
            addCriterion("VISIBILITY <>", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityGreaterThan(String value) {
            addCriterion("VISIBILITY >", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityGreaterThanOrEqualTo(String value) {
            addCriterion("VISIBILITY >=", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityLessThan(String value) {
            addCriterion("VISIBILITY <", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityLessThanOrEqualTo(String value) {
            addCriterion("VISIBILITY <=", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityLike(String value) {
            addCriterion("VISIBILITY like", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityNotLike(String value) {
            addCriterion("VISIBILITY not like", value, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityIn(java.util.List<java.lang.String> values) {
            addCriterion("VISIBILITY in", values, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityNotIn(java.util.List<java.lang.String> values) {
            addCriterion("VISIBILITY not in", values, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityBetween(String value1, String value2) {
            addCriterion("VISIBILITY between", value1, value2, "visibility");
            return (Criteria) this;
        }

        public Criteria andVisibilityNotBetween(String value1, String value2) {
            addCriterion("VISIBILITY not between", value1, value2, "visibility");
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