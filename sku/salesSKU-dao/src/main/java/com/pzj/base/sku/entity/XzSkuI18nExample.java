package com.pzj.base.sku.entity;

import java.util.ArrayList;
import java.util.List;

public class XzSkuI18nExample {

    protected String orderByClause;

    protected boolean distinct;

    protected java.util.List<Criteria> oredCriteria;

    protected int start = -1;

    protected int pageSize = -1;

    public XzSkuI18nExample() {
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

        public Criteria andSkuTitleIsNull() {
            addCriterion("SKU_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andSkuTitleIsNotNull() {
            addCriterion("SKU_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andSkuTitleEqualTo(String value) {
            addCriterion("SKU_TITLE =", value, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSkuTitleNotEqualTo(String value) {
            addCriterion("SKU_TITLE <>", value, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSkuTitleGreaterThan(String value) {
            addCriterion("SKU_TITLE >", value, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSkuTitleGreaterThanOrEqualTo(String value) {
            addCriterion("SKU_TITLE >=", value, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSkuTitleLessThan(String value) {
            addCriterion("SKU_TITLE <", value, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSkuTitleLessThanOrEqualTo(String value) {
            addCriterion("SKU_TITLE <=", value, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSkuTitleLike(String value) {
            addCriterion("SKU_TITLE like", value, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSkuTitleNotLike(String value) {
            addCriterion("SKU_TITLE not like", value, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSkuTitleIn(java.util.List<java.lang.String> values) {
            addCriterion("SKU_TITLE in", values, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSkuTitleNotIn(java.util.List<java.lang.String> values) {
            addCriterion("SKU_TITLE not in", values, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSkuTitleBetween(String value1, String value2) {
            addCriterion("SKU_TITLE between", value1, value2, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSkuTitleNotBetween(String value1, String value2) {
            addCriterion("SKU_TITLE not between", value1, value2, "skuTitle");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNull() {
            addCriterion("SUMMARY is null");
            return (Criteria) this;
        }

        public Criteria andSummaryIsNotNull() {
            addCriterion("SUMMARY is not null");
            return (Criteria) this;
        }

        public Criteria andSummaryEqualTo(String value) {
            addCriterion("SUMMARY =", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotEqualTo(String value) {
            addCriterion("SUMMARY <>", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThan(String value) {
            addCriterion("SUMMARY >", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryGreaterThanOrEqualTo(String value) {
            addCriterion("SUMMARY >=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThan(String value) {
            addCriterion("SUMMARY <", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLessThanOrEqualTo(String value) {
            addCriterion("SUMMARY <=", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryLike(String value) {
            addCriterion("SUMMARY like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotLike(String value) {
            addCriterion("SUMMARY not like", value, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryIn(java.util.List<java.lang.String> values) {
            addCriterion("SUMMARY in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotIn(java.util.List<java.lang.String> values) {
            addCriterion("SUMMARY not in", values, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryBetween(String value1, String value2) {
            addCriterion("SUMMARY between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andSummaryNotBetween(String value1, String value2) {
            addCriterion("SUMMARY not between", value1, value2, "summary");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("LOCATION =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("LOCATION <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("LOCATION >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("LOCATION >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("LOCATION <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("LOCATION <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("LOCATION like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("LOCATION not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(java.util.List<java.lang.String> values) {
            addCriterion("LOCATION in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(java.util.List<java.lang.String> values) {
            addCriterion("LOCATION not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("LOCATION between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("LOCATION not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleIsNull() {
            addCriterion("MARKER_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleIsNotNull() {
            addCriterion("MARKER_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleEqualTo(String value) {
            addCriterion("MARKER_TITLE =", value, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleNotEqualTo(String value) {
            addCriterion("MARKER_TITLE <>", value, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleGreaterThan(String value) {
            addCriterion("MARKER_TITLE >", value, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleGreaterThanOrEqualTo(String value) {
            addCriterion("MARKER_TITLE >=", value, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleLessThan(String value) {
            addCriterion("MARKER_TITLE <", value, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleLessThanOrEqualTo(String value) {
            addCriterion("MARKER_TITLE <=", value, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleLike(String value) {
            addCriterion("MARKER_TITLE like", value, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleNotLike(String value) {
            addCriterion("MARKER_TITLE not like", value, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleIn(java.util.List<java.lang.String> values) {
            addCriterion("MARKER_TITLE in", values, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MARKER_TITLE not in", values, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleBetween(String value1, String value2) {
            addCriterion("MARKER_TITLE between", value1, value2, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerTitleNotBetween(String value1, String value2) {
            addCriterion("MARKER_TITLE not between", value1, value2, "markerTitle");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionIsNull() {
            addCriterion("MARKER_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionIsNotNull() {
            addCriterion("MARKER_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionEqualTo(String value) {
            addCriterion("MARKER_DESCRIPTION =", value, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionNotEqualTo(String value) {
            addCriterion("MARKER_DESCRIPTION <>", value, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionGreaterThan(String value) {
            addCriterion("MARKER_DESCRIPTION >", value, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("MARKER_DESCRIPTION >=", value, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionLessThan(String value) {
            addCriterion("MARKER_DESCRIPTION <", value, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionLessThanOrEqualTo(String value) {
            addCriterion("MARKER_DESCRIPTION <=", value, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionLike(String value) {
            addCriterion("MARKER_DESCRIPTION like", value, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionNotLike(String value) {
            addCriterion("MARKER_DESCRIPTION not like", value, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionIn(java.util.List<java.lang.String> values) {
            addCriterion("MARKER_DESCRIPTION in", values, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MARKER_DESCRIPTION not in", values, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionBetween(String value1, String value2) {
            addCriterion("MARKER_DESCRIPTION between", value1, value2, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerDescriptionNotBetween(String value1, String value2) {
            addCriterion("MARKER_DESCRIPTION not between", value1, value2, "markerDescription");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextIsNull() {
            addCriterion("MARKER_LINK_TEXT is null");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextIsNotNull() {
            addCriterion("MARKER_LINK_TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextEqualTo(String value) {
            addCriterion("MARKER_LINK_TEXT =", value, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextNotEqualTo(String value) {
            addCriterion("MARKER_LINK_TEXT <>", value, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextGreaterThan(String value) {
            addCriterion("MARKER_LINK_TEXT >", value, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextGreaterThanOrEqualTo(String value) {
            addCriterion("MARKER_LINK_TEXT >=", value, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextLessThan(String value) {
            addCriterion("MARKER_LINK_TEXT <", value, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextLessThanOrEqualTo(String value) {
            addCriterion("MARKER_LINK_TEXT <=", value, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextLike(String value) {
            addCriterion("MARKER_LINK_TEXT like", value, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextNotLike(String value) {
            addCriterion("MARKER_LINK_TEXT not like", value, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextIn(java.util.List<java.lang.String> values) {
            addCriterion("MARKER_LINK_TEXT in", values, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MARKER_LINK_TEXT not in", values, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextBetween(String value1, String value2) {
            addCriterion("MARKER_LINK_TEXT between", value1, value2, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMarkerLinkTextNotBetween(String value1, String value2) {
            addCriterion("MARKER_LINK_TEXT not between", value1, value2, "markerLinkText");
            return (Criteria) this;
        }

        public Criteria andMapZoomIsNull() {
            addCriterion("MAP_ZOOM is null");
            return (Criteria) this;
        }

        public Criteria andMapZoomIsNotNull() {
            addCriterion("MAP_ZOOM is not null");
            return (Criteria) this;
        }

        public Criteria andMapZoomEqualTo(Integer value) {
            addCriterion("MAP_ZOOM =", value, "mapZoom");
            return (Criteria) this;
        }

        public Criteria andMapZoomNotEqualTo(Integer value) {
            addCriterion("MAP_ZOOM <>", value, "mapZoom");
            return (Criteria) this;
        }

        public Criteria andMapZoomGreaterThan(Integer value) {
            addCriterion("MAP_ZOOM >", value, "mapZoom");
            return (Criteria) this;
        }

        public Criteria andMapZoomGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAP_ZOOM >=", value, "mapZoom");
            return (Criteria) this;
        }

        public Criteria andMapZoomLessThan(Integer value) {
            addCriterion("MAP_ZOOM <", value, "mapZoom");
            return (Criteria) this;
        }

        public Criteria andMapZoomLessThanOrEqualTo(Integer value) {
            addCriterion("MAP_ZOOM <=", value, "mapZoom");
            return (Criteria) this;
        }

        public Criteria andMapZoomIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAP_ZOOM in", values, "mapZoom");
            return (Criteria) this;
        }

        public Criteria andMapZoomNotIn(java.util.List<java.lang.Integer> values) {
            addCriterion("MAP_ZOOM not in", values, "mapZoom");
            return (Criteria) this;
        }

        public Criteria andMapZoomBetween(Integer value1, Integer value2) {
            addCriterion("MAP_ZOOM between", value1, value2, "mapZoom");
            return (Criteria) this;
        }

        public Criteria andMapZoomNotBetween(Integer value1, Integer value2) {
            addCriterion("MAP_ZOOM not between", value1, value2, "mapZoom");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("LANGUAGE is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("LANGUAGE is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("LANGUAGE =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("LANGUAGE <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("LANGUAGE >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("LANGUAGE >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("LANGUAGE <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("LANGUAGE <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("LANGUAGE like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("LANGUAGE not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(java.util.List<java.lang.String> values) {
            addCriterion("LANGUAGE in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(java.util.List<java.lang.String> values) {
            addCriterion("LANGUAGE not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("LANGUAGE between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("LANGUAGE not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationIsNull() {
            addCriterion("EMAIL_NOTIFICATION is null");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationIsNotNull() {
            addCriterion("EMAIL_NOTIFICATION is not null");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationEqualTo(String value) {
            addCriterion("EMAIL_NOTIFICATION =", value, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationNotEqualTo(String value) {
            addCriterion("EMAIL_NOTIFICATION <>", value, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationGreaterThan(String value) {
            addCriterion("EMAIL_NOTIFICATION >", value, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL_NOTIFICATION >=", value, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationLessThan(String value) {
            addCriterion("EMAIL_NOTIFICATION <", value, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationLessThanOrEqualTo(String value) {
            addCriterion("EMAIL_NOTIFICATION <=", value, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationLike(String value) {
            addCriterion("EMAIL_NOTIFICATION like", value, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationNotLike(String value) {
            addCriterion("EMAIL_NOTIFICATION not like", value, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationIn(java.util.List<java.lang.String> values) {
            addCriterion("EMAIL_NOTIFICATION in", values, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationNotIn(java.util.List<java.lang.String> values) {
            addCriterion("EMAIL_NOTIFICATION not in", values, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationBetween(String value1, String value2) {
            addCriterion("EMAIL_NOTIFICATION between", value1, value2, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andEmailNotificationNotBetween(String value1, String value2) {
            addCriterion("EMAIL_NOTIFICATION not between", value1, value2, "emailNotification");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlIsNull() {
            addCriterion("MORE_INFO_URL is null");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlIsNotNull() {
            addCriterion("MORE_INFO_URL is not null");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlEqualTo(String value) {
            addCriterion("MORE_INFO_URL =", value, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlNotEqualTo(String value) {
            addCriterion("MORE_INFO_URL <>", value, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlGreaterThan(String value) {
            addCriterion("MORE_INFO_URL >", value, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("MORE_INFO_URL >=", value, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlLessThan(String value) {
            addCriterion("MORE_INFO_URL <", value, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlLessThanOrEqualTo(String value) {
            addCriterion("MORE_INFO_URL <=", value, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlLike(String value) {
            addCriterion("MORE_INFO_URL like", value, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlNotLike(String value) {
            addCriterion("MORE_INFO_URL not like", value, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("MORE_INFO_URL in", values, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("MORE_INFO_URL not in", values, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlBetween(String value1, String value2) {
            addCriterion("MORE_INFO_URL between", value1, value2, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andMoreInfoUrlNotBetween(String value1, String value2) {
            addCriterion("MORE_INFO_URL not between", value1, value2, "moreInfoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNull() {
            addCriterion("VIDEO_URL is null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNotNull() {
            addCriterion("VIDEO_URL is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlEqualTo(String value) {
            addCriterion("VIDEO_URL =", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotEqualTo(String value) {
            addCriterion("VIDEO_URL <>", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThan(String value) {
            addCriterion("VIDEO_URL >", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_URL >=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThan(String value) {
            addCriterion("VIDEO_URL <", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_URL <=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLike(String value) {
            addCriterion("VIDEO_URL like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotLike(String value) {
            addCriterion("VIDEO_URL not like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIn(java.util.List<java.lang.String> values) {
            addCriterion("VIDEO_URL in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotIn(java.util.List<java.lang.String> values) {
            addCriterion("VIDEO_URL not in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlBetween(String value1, String value2) {
            addCriterion("VIDEO_URL between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotBetween(String value1, String value2) {
            addCriterion("VIDEO_URL not between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeIsNull() {
            addCriterion("VIDEO_START_TIME is null");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeIsNotNull() {
            addCriterion("VIDEO_START_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeEqualTo(String value) {
            addCriterion("VIDEO_START_TIME =", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeNotEqualTo(String value) {
            addCriterion("VIDEO_START_TIME <>", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeGreaterThan(String value) {
            addCriterion("VIDEO_START_TIME >", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("VIDEO_START_TIME >=", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeLessThan(String value) {
            addCriterion("VIDEO_START_TIME <", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeLessThanOrEqualTo(String value) {
            addCriterion("VIDEO_START_TIME <=", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeLike(String value) {
            addCriterion("VIDEO_START_TIME like", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeNotLike(String value) {
            addCriterion("VIDEO_START_TIME not like", value, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeIn(java.util.List<java.lang.String> values) {
            addCriterion("VIDEO_START_TIME in", values, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeNotIn(java.util.List<java.lang.String> values) {
            addCriterion("VIDEO_START_TIME not in", values, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeBetween(String value1, String value2) {
            addCriterion("VIDEO_START_TIME between", value1, value2, "videoStartTime");
            return (Criteria) this;
        }

        public Criteria andVideoStartTimeNotBetween(String value1, String value2) {
            addCriterion("VIDEO_START_TIME not between", value1, value2, "videoStartTime");
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