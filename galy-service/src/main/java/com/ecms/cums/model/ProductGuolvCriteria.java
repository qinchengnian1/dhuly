package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.List;

public class ProductGuolvCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductGuolvCriteria() {
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

    public List<Criteria> getOredCriteria() {
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

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

        public List<Criterion> getCriteria() {
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

        public Criteria andPGIdIsNull() {
            addCriterion("p_g_id is null");
            return (Criteria) this;
        }

        public Criteria andPGIdIsNotNull() {
            addCriterion("p_g_id is not null");
            return (Criteria) this;
        }

        public Criteria andPGIdEqualTo(Integer value) {
            addCriterion("p_g_id =", value, "pGId");
            return (Criteria) this;
        }

        public Criteria andPGIdNotEqualTo(Integer value) {
            addCriterion("p_g_id <>", value, "pGId");
            return (Criteria) this;
        }

        public Criteria andPGIdGreaterThan(Integer value) {
            addCriterion("p_g_id >", value, "pGId");
            return (Criteria) this;
        }

        public Criteria andPGIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_g_id >=", value, "pGId");
            return (Criteria) this;
        }

        public Criteria andPGIdLessThan(Integer value) {
            addCriterion("p_g_id <", value, "pGId");
            return (Criteria) this;
        }

        public Criteria andPGIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_g_id <=", value, "pGId");
            return (Criteria) this;
        }

        public Criteria andPGIdIn(List<Integer> values) {
            addCriterion("p_g_id in", values, "pGId");
            return (Criteria) this;
        }

        public Criteria andPGIdNotIn(List<Integer> values) {
            addCriterion("p_g_id not in", values, "pGId");
            return (Criteria) this;
        }

        public Criteria andPGIdBetween(Integer value1, Integer value2) {
            addCriterion("p_g_id between", value1, value2, "pGId");
            return (Criteria) this;
        }

        public Criteria andPGIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_g_id not between", value1, value2, "pGId");
            return (Criteria) this;
        }

        public Criteria andPRouteMainIsNull() {
            addCriterion("p_route_main is null");
            return (Criteria) this;
        }

        public Criteria andPRouteMainIsNotNull() {
            addCriterion("p_route_main is not null");
            return (Criteria) this;
        }

        public Criteria andPRouteMainEqualTo(String value) {
            addCriterion("p_route_main =", value, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPRouteMainNotEqualTo(String value) {
            addCriterion("p_route_main <>", value, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPRouteMainGreaterThan(String value) {
            addCriterion("p_route_main >", value, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPRouteMainGreaterThanOrEqualTo(String value) {
            addCriterion("p_route_main >=", value, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPRouteMainLessThan(String value) {
            addCriterion("p_route_main <", value, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPRouteMainLessThanOrEqualTo(String value) {
            addCriterion("p_route_main <=", value, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPRouteMainLike(String value) {
            addCriterion("p_route_main like", value, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPRouteMainNotLike(String value) {
            addCriterion("p_route_main not like", value, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPRouteMainIn(List<String> values) {
            addCriterion("p_route_main in", values, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPRouteMainNotIn(List<String> values) {
            addCriterion("p_route_main not in", values, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPRouteMainBetween(String value1, String value2) {
            addCriterion("p_route_main between", value1, value2, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPRouteMainNotBetween(String value1, String value2) {
            addCriterion("p_route_main not between", value1, value2, "pRouteMain");
            return (Criteria) this;
        }

        public Criteria andPImageUrlIsNull() {
            addCriterion("p_image_url is null");
            return (Criteria) this;
        }

        public Criteria andPImageUrlIsNotNull() {
            addCriterion("p_image_url is not null");
            return (Criteria) this;
        }

        public Criteria andPImageUrlEqualTo(String value) {
            addCriterion("p_image_url =", value, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPImageUrlNotEqualTo(String value) {
            addCriterion("p_image_url <>", value, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPImageUrlGreaterThan(String value) {
            addCriterion("p_image_url >", value, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("p_image_url >=", value, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPImageUrlLessThan(String value) {
            addCriterion("p_image_url <", value, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPImageUrlLessThanOrEqualTo(String value) {
            addCriterion("p_image_url <=", value, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPImageUrlLike(String value) {
            addCriterion("p_image_url like", value, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPImageUrlNotLike(String value) {
            addCriterion("p_image_url not like", value, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPImageUrlIn(List<String> values) {
            addCriterion("p_image_url in", values, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPImageUrlNotIn(List<String> values) {
            addCriterion("p_image_url not in", values, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPImageUrlBetween(String value1, String value2) {
            addCriterion("p_image_url between", value1, value2, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPImageUrlNotBetween(String value1, String value2) {
            addCriterion("p_image_url not between", value1, value2, "pImageUrl");
            return (Criteria) this;
        }

        public Criteria andPStartDestIsNull() {
            addCriterion("p_start_dest is null");
            return (Criteria) this;
        }

        public Criteria andPStartDestIsNotNull() {
            addCriterion("p_start_dest is not null");
            return (Criteria) this;
        }

        public Criteria andPStartDestEqualTo(String value) {
            addCriterion("p_start_dest =", value, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPStartDestNotEqualTo(String value) {
            addCriterion("p_start_dest <>", value, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPStartDestGreaterThan(String value) {
            addCriterion("p_start_dest >", value, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPStartDestGreaterThanOrEqualTo(String value) {
            addCriterion("p_start_dest >=", value, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPStartDestLessThan(String value) {
            addCriterion("p_start_dest <", value, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPStartDestLessThanOrEqualTo(String value) {
            addCriterion("p_start_dest <=", value, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPStartDestLike(String value) {
            addCriterion("p_start_dest like", value, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPStartDestNotLike(String value) {
            addCriterion("p_start_dest not like", value, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPStartDestIn(List<String> values) {
            addCriterion("p_start_dest in", values, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPStartDestNotIn(List<String> values) {
            addCriterion("p_start_dest not in", values, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPStartDestBetween(String value1, String value2) {
            addCriterion("p_start_dest between", value1, value2, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPStartDestNotBetween(String value1, String value2) {
            addCriterion("p_start_dest not between", value1, value2, "pStartDest");
            return (Criteria) this;
        }

        public Criteria andPPriceIsNull() {
            addCriterion("p_price is null");
            return (Criteria) this;
        }

        public Criteria andPPriceIsNotNull() {
            addCriterion("p_price is not null");
            return (Criteria) this;
        }

        public Criteria andPPriceEqualTo(String value) {
            addCriterion("p_price =", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotEqualTo(String value) {
            addCriterion("p_price <>", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceGreaterThan(String value) {
            addCriterion("p_price >", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceGreaterThanOrEqualTo(String value) {
            addCriterion("p_price >=", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceLessThan(String value) {
            addCriterion("p_price <", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceLessThanOrEqualTo(String value) {
            addCriterion("p_price <=", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceLike(String value) {
            addCriterion("p_price like", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotLike(String value) {
            addCriterion("p_price not like", value, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceIn(List<String> values) {
            addCriterion("p_price in", values, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotIn(List<String> values) {
            addCriterion("p_price not in", values, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceBetween(String value1, String value2) {
            addCriterion("p_price between", value1, value2, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPPriceNotBetween(String value1, String value2) {
            addCriterion("p_price not between", value1, value2, "pPrice");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagIsNull() {
            addCriterion("p_system_flag is null");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagIsNotNull() {
            addCriterion("p_system_flag is not null");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagEqualTo(String value) {
            addCriterion("p_system_flag =", value, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagNotEqualTo(String value) {
            addCriterion("p_system_flag <>", value, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagGreaterThan(String value) {
            addCriterion("p_system_flag >", value, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagGreaterThanOrEqualTo(String value) {
            addCriterion("p_system_flag >=", value, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagLessThan(String value) {
            addCriterion("p_system_flag <", value, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagLessThanOrEqualTo(String value) {
            addCriterion("p_system_flag <=", value, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagLike(String value) {
            addCriterion("p_system_flag like", value, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagNotLike(String value) {
            addCriterion("p_system_flag not like", value, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagIn(List<String> values) {
            addCriterion("p_system_flag in", values, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagNotIn(List<String> values) {
            addCriterion("p_system_flag not in", values, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagBetween(String value1, String value2) {
            addCriterion("p_system_flag between", value1, value2, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPSystemFlagNotBetween(String value1, String value2) {
            addCriterion("p_system_flag not between", value1, value2, "pSystemFlag");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeIsNull() {
            addCriterion("p_route_type is null");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeIsNotNull() {
            addCriterion("p_route_type is not null");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeEqualTo(String value) {
            addCriterion("p_route_type =", value, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeNotEqualTo(String value) {
            addCriterion("p_route_type <>", value, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeGreaterThan(String value) {
            addCriterion("p_route_type >", value, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeGreaterThanOrEqualTo(String value) {
            addCriterion("p_route_type >=", value, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeLessThan(String value) {
            addCriterion("p_route_type <", value, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeLessThanOrEqualTo(String value) {
            addCriterion("p_route_type <=", value, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeLike(String value) {
            addCriterion("p_route_type like", value, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeNotLike(String value) {
            addCriterion("p_route_type not like", value, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeIn(List<String> values) {
            addCriterion("p_route_type in", values, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeNotIn(List<String> values) {
            addCriterion("p_route_type not in", values, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeBetween(String value1, String value2) {
            addCriterion("p_route_type between", value1, value2, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteTypeNotBetween(String value1, String value2) {
            addCriterion("p_route_type not between", value1, value2, "pRouteType");
            return (Criteria) this;
        }

        public Criteria andPRouteIdIsNull() {
            addCriterion("p_route_id is null");
            return (Criteria) this;
        }

        public Criteria andPRouteIdIsNotNull() {
            addCriterion("p_route_id is not null");
            return (Criteria) this;
        }

        public Criteria andPRouteIdEqualTo(String value) {
            addCriterion("p_route_id =", value, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andPRouteIdNotEqualTo(String value) {
            addCriterion("p_route_id <>", value, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andPRouteIdGreaterThan(String value) {
            addCriterion("p_route_id >", value, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andPRouteIdGreaterThanOrEqualTo(String value) {
            addCriterion("p_route_id >=", value, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andPRouteIdLessThan(String value) {
            addCriterion("p_route_id <", value, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andPRouteIdLessThanOrEqualTo(String value) {
            addCriterion("p_route_id <=", value, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andPRouteIdLike(String value) {
            addCriterion("p_route_id like", value, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andPRouteIdNotLike(String value) {
            addCriterion("p_route_id not like", value, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andPRouteIdIn(List<String> values) {
            addCriterion("p_route_id in", values, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andPRouteIdNotIn(List<String> values) {
            addCriterion("p_route_id not in", values, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andPRouteIdBetween(String value1, String value2) {
            addCriterion("p_route_id between", value1, value2, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andPRouteIdNotBetween(String value1, String value2) {
            addCriterion("p_route_id not between", value1, value2, "pRouteId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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