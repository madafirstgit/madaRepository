package com.pzj.base.sku.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class XzSkuExample {

    protected String orderByClause;

    protected boolean distinct;

    protected java.util.List<Criteria> oredCriteria;

    protected int start = -1;

    protected int pageSize = -1;

    public XzSkuExample() {
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

        public Criteria andCategoryIdIsNull() {
            addCriterion("CATEGORY_ID is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("CATEGORY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("CATEGORY_ID =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("CATEGORY_ID <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("CATEGORY_ID >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("CATEGORY_ID >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("CATEGORY_ID <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("CATEGORY_ID <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(java.util.List<java.lang.Integer> values) {
            addCriterion("CATEGORY_ID in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("CATEGORY_ID not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("CATEGORY_ID between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("CATEGORY_ID not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeIsNull() {
            addCriterion("SKU_EXT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeIsNotNull() {
            addCriterion("SKU_EXT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeEqualTo(String value) {
            addCriterion("SKU_EXT_CODE =", value, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeNotEqualTo(String value) {
            addCriterion("SKU_EXT_CODE <>", value, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeGreaterThan(String value) {
            addCriterion("SKU_EXT_CODE >", value, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SKU_EXT_CODE >=", value, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeLessThan(String value) {
            addCriterion("SKU_EXT_CODE <", value, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeLessThanOrEqualTo(String value) {
            addCriterion("SKU_EXT_CODE <=", value, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeLike(String value) {
            addCriterion("SKU_EXT_CODE like", value, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeNotLike(String value) {
            addCriterion("SKU_EXT_CODE not like", value, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("SKU_EXT_CODE in", values, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("SKU_EXT_CODE not in", values, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeBetween(String value1, String value2) {
            addCriterion("SKU_EXT_CODE between", value1, value2, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSkuExtCodeNotBetween(String value1, String value2) {
            addCriterion("SKU_EXT_CODE not between", value1, value2, "skuExtCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeIsNull() {
            addCriterion("SUPPLIER_CODE is null");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeIsNotNull() {
            addCriterion("SUPPLIER_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeEqualTo(String value) {
            addCriterion("SUPPLIER_CODE =", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotEqualTo(String value) {
            addCriterion("SUPPLIER_CODE <>", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeGreaterThan(String value) {
            addCriterion("SUPPLIER_CODE >", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeGreaterThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_CODE >=", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLessThan(String value) {
            addCriterion("SUPPLIER_CODE <", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLessThanOrEqualTo(String value) {
            addCriterion("SUPPLIER_CODE <=", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeLike(String value) {
            addCriterion("SUPPLIER_CODE like", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotLike(String value) {
            addCriterion("SUPPLIER_CODE not like", value, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeIn(java.util.List<java.lang.String> values) {
            addCriterion("SUPPLIER_CODE in", values, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("SUPPLIER_CODE not in", values, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeBetween(String value1, String value2) {
            addCriterion("SUPPLIER_CODE between", value1, value2, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andSupplierCodeNotBetween(String value1, String value2) {
            addCriterion("SUPPLIER_CODE not between", value1, value2, "supplierCode");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNull() {
            addCriterion("INVENTORY is null");
            return (Criteria) this;
        }

        public Criteria andInventoryIsNotNull() {
            addCriterion("INVENTORY is not null");
            return (Criteria) this;
        }

        public Criteria andInventoryEqualTo(Integer value) {
            addCriterion("INVENTORY =", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotEqualTo(Integer value) {
            addCriterion("INVENTORY <>", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThan(Integer value) {
            addCriterion("INVENTORY >", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("INVENTORY >=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThan(Integer value) {
            addCriterion("INVENTORY <", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryLessThanOrEqualTo(Integer value) {
            addCriterion("INVENTORY <=", value, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryIn(java.util.List<java.lang.Integer> values) {
            addCriterion("INVENTORY in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("INVENTORY not in", values, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryBetween(Integer value1, Integer value2) {
            addCriterion("INVENTORY between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andInventoryNotBetween(Integer value1, Integer value2) {
            addCriterion("INVENTORY not between", value1, value2, "inventory");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryIsNull() {
            addCriterion("UNLIMITED_INVENTORY is null");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryIsNotNull() {
            addCriterion("UNLIMITED_INVENTORY is not null");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryEqualTo(Boolean value) {
            addCriterion("UNLIMITED_INVENTORY =", value, "unlimitedInventory");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryNotEqualTo(Boolean value) {
            addCriterion("UNLIMITED_INVENTORY <>", value, "unlimitedInventory");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryGreaterThan(Boolean value) {
            addCriterion("UNLIMITED_INVENTORY >", value, "unlimitedInventory");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryGreaterThanOrEqualTo(Boolean value) {
            addCriterion("UNLIMITED_INVENTORY >=", value, "unlimitedInventory");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryLessThan(Boolean value) {
            addCriterion("UNLIMITED_INVENTORY <", value, "unlimitedInventory");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryLessThanOrEqualTo(Boolean value) {
            addCriterion("UNLIMITED_INVENTORY <=", value, "unlimitedInventory");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("UNLIMITED_INVENTORY in", values, "unlimitedInventory");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("UNLIMITED_INVENTORY not in", values, "unlimitedInventory");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryBetween(Boolean value1, Boolean value2) {
            addCriterion("UNLIMITED_INVENTORY between", value1, value2, "unlimitedInventory");
            return (Criteria) this;
        }

        public Criteria andUnlimitedInventoryNotBetween(Boolean value1, Boolean value2) {
            addCriterion("UNLIMITED_INVENTORY not between", value1, value2, "unlimitedInventory");
            return (Criteria) this;
        }

        public Criteria andIsSimpleIsNull() {
            addCriterion("IS_SIMPLE is null");
            return (Criteria) this;
        }

        public Criteria andIsSimpleIsNotNull() {
            addCriterion("IS_SIMPLE is not null");
            return (Criteria) this;
        }

        public Criteria andIsSimpleEqualTo(Boolean value) {
            addCriterion("IS_SIMPLE =", value, "isSimple");
            return (Criteria) this;
        }

        public Criteria andIsSimpleNotEqualTo(Boolean value) {
            addCriterion("IS_SIMPLE <>", value, "isSimple");
            return (Criteria) this;
        }

        public Criteria andIsSimpleGreaterThan(Boolean value) {
            addCriterion("IS_SIMPLE >", value, "isSimple");
            return (Criteria) this;
        }

        public Criteria andIsSimpleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_SIMPLE >=", value, "isSimple");
            return (Criteria) this;
        }

        public Criteria andIsSimpleLessThan(Boolean value) {
            addCriterion("IS_SIMPLE <", value, "isSimple");
            return (Criteria) this;
        }

        public Criteria andIsSimpleLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_SIMPLE <=", value, "isSimple");
            return (Criteria) this;
        }

        public Criteria andIsSimpleIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("IS_SIMPLE in", values, "isSimple");
            return (Criteria) this;
        }

        public Criteria andIsSimpleNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("IS_SIMPLE not in", values, "isSimple");
            return (Criteria) this;
        }

        public Criteria andIsSimpleBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_SIMPLE between", value1, value2, "isSimple");
            return (Criteria) this;
        }

        public Criteria andIsSimpleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_SIMPLE not between", value1, value2, "isSimple");
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

        public Criteria andMaintenanceTimeIsNull() {
            addCriterion("MAINTENANCE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeIsNotNull() {
            addCriterion("MAINTENANCE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeEqualTo(Integer value) {
            addCriterion("MAINTENANCE_TIME =", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeNotEqualTo(Integer value) {
            addCriterion("MAINTENANCE_TIME <>", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeGreaterThan(Integer value) {
            addCriterion("MAINTENANCE_TIME >", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAINTENANCE_TIME >=", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeLessThan(Integer value) {
            addCriterion("MAINTENANCE_TIME <", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeLessThanOrEqualTo(Integer value) {
            addCriterion("MAINTENANCE_TIME <=", value, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAINTENANCE_TIME in", values, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAINTENANCE_TIME not in", values, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeBetween(Integer value1, Integer value2) {
            addCriterion("MAINTENANCE_TIME between", value1, value2, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andMaintenanceTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("MAINTENANCE_TIME not between", value1, value2, "maintenanceTime");
            return (Criteria) this;
        }

        public Criteria andAliasToIsNull() {
            addCriterion("ALIAS_TO is null");
            return (Criteria) this;
        }

        public Criteria andAliasToIsNotNull() {
            addCriterion("ALIAS_TO is not null");
            return (Criteria) this;
        }

        public Criteria andAliasToEqualTo(Integer value) {
            addCriterion("ALIAS_TO =", value, "aliasTo");
            return (Criteria) this;
        }

        public Criteria andAliasToNotEqualTo(Integer value) {
            addCriterion("ALIAS_TO <>", value, "aliasTo");
            return (Criteria) this;
        }

        public Criteria andAliasToGreaterThan(Integer value) {
            addCriterion("ALIAS_TO >", value, "aliasTo");
            return (Criteria) this;
        }

        public Criteria andAliasToGreaterThanOrEqualTo(Integer value) {
            addCriterion("ALIAS_TO >=", value, "aliasTo");
            return (Criteria) this;
        }

        public Criteria andAliasToLessThan(Integer value) {
            addCriterion("ALIAS_TO <", value, "aliasTo");
            return (Criteria) this;
        }

        public Criteria andAliasToLessThanOrEqualTo(Integer value) {
            addCriterion("ALIAS_TO <=", value, "aliasTo");
            return (Criteria) this;
        }

        public Criteria andAliasToIn(java.util.List<java.lang.Integer> values) {
            addCriterion("ALIAS_TO in", values, "aliasTo");
            return (Criteria) this;
        }

        public Criteria andAliasToNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("ALIAS_TO not in", values, "aliasTo");
            return (Criteria) this;
        }

        public Criteria andAliasToBetween(Integer value1, Integer value2) {
            addCriterion("ALIAS_TO between", value1, value2, "aliasTo");
            return (Criteria) this;
        }

        public Criteria andAliasToNotBetween(Integer value1, Integer value2) {
            addCriterion("ALIAS_TO not between", value1, value2, "aliasTo");
            return (Criteria) this;
        }

        public Criteria andPricePerIsNull() {
            addCriterion("PRICE_PER is null");
            return (Criteria) this;
        }

        public Criteria andPricePerIsNotNull() {
            addCriterion("PRICE_PER is not null");
            return (Criteria) this;
        }

        public Criteria andPricePerEqualTo(String value) {
            addCriterion("PRICE_PER =", value, "pricePer");
            return (Criteria) this;
        }

        public Criteria andPricePerNotEqualTo(String value) {
            addCriterion("PRICE_PER <>", value, "pricePer");
            return (Criteria) this;
        }

        public Criteria andPricePerGreaterThan(String value) {
            addCriterion("PRICE_PER >", value, "pricePer");
            return (Criteria) this;
        }

        public Criteria andPricePerGreaterThanOrEqualTo(String value) {
            addCriterion("PRICE_PER >=", value, "pricePer");
            return (Criteria) this;
        }

        public Criteria andPricePerLessThan(String value) {
            addCriterion("PRICE_PER <", value, "pricePer");
            return (Criteria) this;
        }

        public Criteria andPricePerLessThanOrEqualTo(String value) {
            addCriterion("PRICE_PER <=", value, "pricePer");
            return (Criteria) this;
        }

        public Criteria andPricePerLike(String value) {
            addCriterion("PRICE_PER like", value, "pricePer");
            return (Criteria) this;
        }

        public Criteria andPricePerNotLike(String value) {
            addCriterion("PRICE_PER not like", value, "pricePer");
            return (Criteria) this;
        }

        public Criteria andPricePerIn(java.util.List<java.lang.String> values) {
            addCriterion("PRICE_PER in", values, "pricePer");
            return (Criteria) this;
        }

        public Criteria andPricePerNotIn(java.util.List<java.lang.String> values) {
            addCriterion("PRICE_PER not in", values, "pricePer");
            return (Criteria) this;
        }

        public Criteria andPricePerBetween(String value1, String value2) {
            addCriterion("PRICE_PER between", value1, value2, "pricePer");
            return (Criteria) this;
        }

        public Criteria andPricePerNotBetween(String value1, String value2) {
            addCriterion("PRICE_PER not between", value1, value2, "pricePer");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusIsNull() {
            addCriterion("DEFAULT_CALENDAR_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusIsNotNull() {
            addCriterion("DEFAULT_CALENDAR_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusEqualTo(String value) {
            addCriterion("DEFAULT_CALENDAR_STATUS =", value, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusNotEqualTo(String value) {
            addCriterion("DEFAULT_CALENDAR_STATUS <>", value, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusGreaterThan(String value) {
            addCriterion("DEFAULT_CALENDAR_STATUS >", value, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusGreaterThanOrEqualTo(String value) {
            addCriterion("DEFAULT_CALENDAR_STATUS >=", value, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusLessThan(String value) {
            addCriterion("DEFAULT_CALENDAR_STATUS <", value, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusLessThanOrEqualTo(String value) {
            addCriterion("DEFAULT_CALENDAR_STATUS <=", value, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusLike(String value) {
            addCriterion("DEFAULT_CALENDAR_STATUS like", value, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusNotLike(String value) {
            addCriterion("DEFAULT_CALENDAR_STATUS not like", value, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusIn(java.util.List<java.lang.String> values) {
            addCriterion("DEFAULT_CALENDAR_STATUS in", values, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusNotIn(java.util.List<java.lang.String> values) {
            addCriterion("DEFAULT_CALENDAR_STATUS not in", values, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusBetween(String value1, String value2) {
            addCriterion("DEFAULT_CALENDAR_STATUS between", value1, value2, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andDefaultCalendarStatusNotBetween(String value1, String value2) {
            addCriterion("DEFAULT_CALENDAR_STATUS not between", value1, value2, "defaultCalendarStatus");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNull() {
            addCriterion("START_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andStartPriceIsNotNull() {
            addCriterion("START_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andStartPriceEqualTo(BigDecimal value) {
            addCriterion("START_PRICE =", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotEqualTo(BigDecimal value) {
            addCriterion("START_PRICE <>", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThan(BigDecimal value) {
            addCriterion("START_PRICE >", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("START_PRICE >=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThan(BigDecimal value) {
            addCriterion("START_PRICE <", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("START_PRICE <=", value, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceIn(java.util.List<java.math.BigDecimal> values) {
            addCriterion("START_PRICE in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotIn(java.util.List<java.math.BigDecimal> values) {
            addCriterion("START_PRICE not in", values, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("START_PRICE between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andStartPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("START_PRICE not between", value1, value2, "startPrice");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentIsNull() {
            addCriterion("PKG_PRICE_PERCENT is null");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentIsNotNull() {
            addCriterion("PKG_PRICE_PERCENT is not null");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentEqualTo(Integer value) {
            addCriterion("PKG_PRICE_PERCENT =", value, "pkgPricePercent");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentNotEqualTo(Integer value) {
            addCriterion("PKG_PRICE_PERCENT <>", value, "pkgPricePercent");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentGreaterThan(Integer value) {
            addCriterion("PKG_PRICE_PERCENT >", value, "pkgPricePercent");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentGreaterThanOrEqualTo(Integer value) {
            addCriterion("PKG_PRICE_PERCENT >=", value, "pkgPricePercent");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentLessThan(Integer value) {
            addCriterion("PKG_PRICE_PERCENT <", value, "pkgPricePercent");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentLessThanOrEqualTo(Integer value) {
            addCriterion("PKG_PRICE_PERCENT <=", value, "pkgPricePercent");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentIn(java.util.List<java.lang.Integer> values) {
            addCriterion("PKG_PRICE_PERCENT in", values, "pkgPricePercent");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("PKG_PRICE_PERCENT not in", values, "pkgPricePercent");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentBetween(Integer value1, Integer value2) {
            addCriterion("PKG_PRICE_PERCENT between", value1, value2, "pkgPricePercent");
            return (Criteria) this;
        }

        public Criteria andPkgPricePercentNotBetween(Integer value1, Integer value2) {
            addCriterion("PKG_PRICE_PERCENT not between", value1, value2, "pkgPricePercent");
            return (Criteria) this;
        }

        public Criteria andListImageIsNull() {
            addCriterion("LIST_IMAGE is null");
            return (Criteria) this;
        }

        public Criteria andListImageIsNotNull() {
            addCriterion("LIST_IMAGE is not null");
            return (Criteria) this;
        }

        public Criteria andListImageEqualTo(String value) {
            addCriterion("LIST_IMAGE =", value, "listImage");
            return (Criteria) this;
        }

        public Criteria andListImageNotEqualTo(String value) {
            addCriterion("LIST_IMAGE <>", value, "listImage");
            return (Criteria) this;
        }

        public Criteria andListImageGreaterThan(String value) {
            addCriterion("LIST_IMAGE >", value, "listImage");
            return (Criteria) this;
        }

        public Criteria andListImageGreaterThanOrEqualTo(String value) {
            addCriterion("LIST_IMAGE >=", value, "listImage");
            return (Criteria) this;
        }

        public Criteria andListImageLessThan(String value) {
            addCriterion("LIST_IMAGE <", value, "listImage");
            return (Criteria) this;
        }

        public Criteria andListImageLessThanOrEqualTo(String value) {
            addCriterion("LIST_IMAGE <=", value, "listImage");
            return (Criteria) this;
        }

        public Criteria andListImageLike(String value) {
            addCriterion("LIST_IMAGE like", value, "listImage");
            return (Criteria) this;
        }

        public Criteria andListImageNotLike(String value) {
            addCriterion("LIST_IMAGE not like", value, "listImage");
            return (Criteria) this;
        }

        public Criteria andListImageIn(java.util.List<java.lang.String> values) {
            addCriterion("LIST_IMAGE in", values, "listImage");
            return (Criteria) this;
        }

        public Criteria andListImageNotIn(java.util.List<java.lang.String> values) {
            addCriterion("LIST_IMAGE not in", values, "listImage");
            return (Criteria) this;
        }

        public Criteria andListImageBetween(String value1, String value2) {
            addCriterion("LIST_IMAGE between", value1, value2, "listImage");
            return (Criteria) this;
        }

        public Criteria andListImageNotBetween(String value1, String value2) {
            addCriterion("LIST_IMAGE not between", value1, value2, "listImage");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("SORT is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("SORT is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("SORT =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("SORT <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("SORT >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("SORT <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("SORT <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(java.util.List<java.lang.Integer> values) {
            addCriterion("SORT in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("SORT not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("SORT between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("DELETE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("DELETE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("DELETE_TIME =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("DELETE_TIME <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("DELETE_TIME >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DELETE_TIME >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("DELETE_TIME <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("DELETE_TIME <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(java.util.List<java.util.Date> values) {
            addCriterion("DELETE_TIME in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(java.util.List<java.util.Date> values) {
            addCriterion("DELETE_TIME not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("DELETE_TIME between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("DELETE_TIME not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("IS_DELETED is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("IS_DELETED is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("IS_DELETED =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("IS_DELETED <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("IS_DELETED >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IS_DELETED >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("IS_DELETED <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("IS_DELETED <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("IS_DELETED in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(java.util.List<java.lang.Boolean> values) {
            addCriterion("IS_DELETED not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_DELETED between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IS_DELETED not between", value1, value2, "isDeleted");
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