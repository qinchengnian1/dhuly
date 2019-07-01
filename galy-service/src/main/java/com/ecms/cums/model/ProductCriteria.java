package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductCriteria() {
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

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andTIdIsNull() {
            addCriterion("t_id is null");
            return (Criteria) this;
        }

        public Criteria andTIdIsNotNull() {
            addCriterion("t_id is not null");
            return (Criteria) this;
        }

        public Criteria andTIdEqualTo(Integer value) {
            addCriterion("t_id =", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotEqualTo(Integer value) {
            addCriterion("t_id <>", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThan(Integer value) {
            addCriterion("t_id >", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("t_id >=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThan(Integer value) {
            addCriterion("t_id <", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdLessThanOrEqualTo(Integer value) {
            addCriterion("t_id <=", value, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdIn(List<Integer> values) {
            addCriterion("t_id in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotIn(List<Integer> values) {
            addCriterion("t_id not in", values, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdBetween(Integer value1, Integer value2) {
            addCriterion("t_id between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andTIdNotBetween(Integer value1, Integer value2) {
            addCriterion("t_id not between", value1, value2, "tId");
            return (Criteria) this;
        }

        public Criteria andRouteMainIsNull() {
            addCriterion("route_main is null");
            return (Criteria) this;
        }

        public Criteria andRouteMainIsNotNull() {
            addCriterion("route_main is not null");
            return (Criteria) this;
        }

        public Criteria andRouteMainEqualTo(String value) {
            addCriterion("route_main =", value, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteMainNotEqualTo(String value) {
            addCriterion("route_main <>", value, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteMainGreaterThan(String value) {
            addCriterion("route_main >", value, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteMainGreaterThanOrEqualTo(String value) {
            addCriterion("route_main >=", value, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteMainLessThan(String value) {
            addCriterion("route_main <", value, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteMainLessThanOrEqualTo(String value) {
            addCriterion("route_main <=", value, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteMainLike(String value) {
            addCriterion("route_main like", value, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteMainNotLike(String value) {
            addCriterion("route_main not like", value, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteMainIn(List<String> values) {
            addCriterion("route_main in", values, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteMainNotIn(List<String> values) {
            addCriterion("route_main not in", values, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteMainBetween(String value1, String value2) {
            addCriterion("route_main between", value1, value2, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteMainNotBetween(String value1, String value2) {
            addCriterion("route_main not between", value1, value2, "routeMain");
            return (Criteria) this;
        }

        public Criteria andRouteSubIsNull() {
            addCriterion("route_sub is null");
            return (Criteria) this;
        }

        public Criteria andRouteSubIsNotNull() {
            addCriterion("route_sub is not null");
            return (Criteria) this;
        }

        public Criteria andRouteSubEqualTo(String value) {
            addCriterion("route_sub =", value, "routeSub");
            return (Criteria) this;
        }

        public Criteria andRouteSubNotEqualTo(String value) {
            addCriterion("route_sub <>", value, "routeSub");
            return (Criteria) this;
        }

        public Criteria andRouteSubGreaterThan(String value) {
            addCriterion("route_sub >", value, "routeSub");
            return (Criteria) this;
        }

        public Criteria andRouteSubGreaterThanOrEqualTo(String value) {
            addCriterion("route_sub >=", value, "routeSub");
            return (Criteria) this;
        }

        public Criteria andRouteSubLessThan(String value) {
            addCriterion("route_sub <", value, "routeSub");
            return (Criteria) this;
        }

        public Criteria andRouteSubLessThanOrEqualTo(String value) {
            addCriterion("route_sub <=", value, "routeSub");
            return (Criteria) this;
        }

        public Criteria andRouteSubLike(String value) {
            addCriterion("route_sub like", value, "routeSub");
            return (Criteria) this;
        }

        public Criteria andRouteSubNotLike(String value) {
            addCriterion("route_sub not like", value, "routeSub");
            return (Criteria) this;
        }

        public Criteria andRouteSubIn(List<String> values) {
            addCriterion("route_sub in", values, "routeSub");
            return (Criteria) this;
        }

        public Criteria andRouteSubNotIn(List<String> values) {
            addCriterion("route_sub not in", values, "routeSub");
            return (Criteria) this;
        }

        public Criteria andRouteSubBetween(String value1, String value2) {
            addCriterion("route_sub between", value1, value2, "routeSub");
            return (Criteria) this;
        }

        public Criteria andRouteSubNotBetween(String value1, String value2) {
            addCriterion("route_sub not between", value1, value2, "routeSub");
            return (Criteria) this;
        }

        public Criteria andPtNoIsNull() {
            addCriterion("pt_no is null");
            return (Criteria) this;
        }

        public Criteria andPtNoIsNotNull() {
            addCriterion("pt_no is not null");
            return (Criteria) this;
        }

        public Criteria andPtNoEqualTo(String value) {
            addCriterion("pt_no =", value, "ptNo");
            return (Criteria) this;
        }

        public Criteria andPtNoNotEqualTo(String value) {
            addCriterion("pt_no <>", value, "ptNo");
            return (Criteria) this;
        }

        public Criteria andPtNoGreaterThan(String value) {
            addCriterion("pt_no >", value, "ptNo");
            return (Criteria) this;
        }

        public Criteria andPtNoGreaterThanOrEqualTo(String value) {
            addCriterion("pt_no >=", value, "ptNo");
            return (Criteria) this;
        }

        public Criteria andPtNoLessThan(String value) {
            addCriterion("pt_no <", value, "ptNo");
            return (Criteria) this;
        }

        public Criteria andPtNoLessThanOrEqualTo(String value) {
            addCriterion("pt_no <=", value, "ptNo");
            return (Criteria) this;
        }

        public Criteria andPtNoLike(String value) {
            addCriterion("pt_no like", value, "ptNo");
            return (Criteria) this;
        }

        public Criteria andPtNoNotLike(String value) {
            addCriterion("pt_no not like", value, "ptNo");
            return (Criteria) this;
        }

        public Criteria andPtNoIn(List<String> values) {
            addCriterion("pt_no in", values, "ptNo");
            return (Criteria) this;
        }

        public Criteria andPtNoNotIn(List<String> values) {
            addCriterion("pt_no not in", values, "ptNo");
            return (Criteria) this;
        }

        public Criteria andPtNoBetween(String value1, String value2) {
            addCriterion("pt_no between", value1, value2, "ptNo");
            return (Criteria) this;
        }

        public Criteria andPtNoNotBetween(String value1, String value2) {
            addCriterion("pt_no not between", value1, value2, "ptNo");
            return (Criteria) this;
        }

        public Criteria andStartDateStrIsNull() {
            addCriterion("start_date_str is null");
            return (Criteria) this;
        }

        public Criteria andStartDateStrIsNotNull() {
            addCriterion("start_date_str is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateStrEqualTo(Date value) {
            addCriterion("start_date_str =", value, "startDateStr");
            return (Criteria) this;
        }

        public Criteria andStartDateStrNotEqualTo(Date value) {
            addCriterion("start_date_str <>", value, "startDateStr");
            return (Criteria) this;
        }

        public Criteria andStartDateStrGreaterThan(Date value) {
            addCriterion("start_date_str >", value, "startDateStr");
            return (Criteria) this;
        }

        public Criteria andStartDateStrGreaterThanOrEqualTo(Date value) {
            addCriterion("start_date_str >=", value, "startDateStr");
            return (Criteria) this;
        }

        public Criteria andStartDateStrLessThan(Date value) {
            addCriterion("start_date_str <", value, "startDateStr");
            return (Criteria) this;
        }

        public Criteria andStartDateStrLessThanOrEqualTo(Date value) {
            addCriterion("start_date_str <=", value, "startDateStr");
            return (Criteria) this;
        }

        public Criteria andStartDateStrIn(List<Date> values) {
            addCriterion("start_date_str in", values, "startDateStr");
            return (Criteria) this;
        }

        public Criteria andStartDateStrNotIn(List<Date> values) {
            addCriterion("start_date_str not in", values, "startDateStr");
            return (Criteria) this;
        }

        public Criteria andStartDateStrBetween(Date value1, Date value2) {
            addCriterion("start_date_str between", value1, value2, "startDateStr");
            return (Criteria) this;
        }

        public Criteria andStartDateStrNotBetween(Date value1, Date value2) {
            addCriterion("start_date_str not between", value1, value2, "startDateStr");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdIsNull() {
            addCriterion("start_place_id is null");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdIsNotNull() {
            addCriterion("start_place_id is not null");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdEqualTo(String value) {
            addCriterion("start_place_id =", value, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdNotEqualTo(String value) {
            addCriterion("start_place_id <>", value, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdGreaterThan(String value) {
            addCriterion("start_place_id >", value, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdGreaterThanOrEqualTo(String value) {
            addCriterion("start_place_id >=", value, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdLessThan(String value) {
            addCriterion("start_place_id <", value, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdLessThanOrEqualTo(String value) {
            addCriterion("start_place_id <=", value, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdLike(String value) {
            addCriterion("start_place_id like", value, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdNotLike(String value) {
            addCriterion("start_place_id not like", value, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdIn(List<String> values) {
            addCriterion("start_place_id in", values, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdNotIn(List<String> values) {
            addCriterion("start_place_id not in", values, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdBetween(String value1, String value2) {
            addCriterion("start_place_id between", value1, value2, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andStartPlaceIdNotBetween(String value1, String value2) {
            addCriterion("start_place_id not between", value1, value2, "startPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdIsNull() {
            addCriterion("dest_place_id is null");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdIsNotNull() {
            addCriterion("dest_place_id is not null");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdEqualTo(String value) {
            addCriterion("dest_place_id =", value, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdNotEqualTo(String value) {
            addCriterion("dest_place_id <>", value, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdGreaterThan(String value) {
            addCriterion("dest_place_id >", value, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdGreaterThanOrEqualTo(String value) {
            addCriterion("dest_place_id >=", value, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdLessThan(String value) {
            addCriterion("dest_place_id <", value, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdLessThanOrEqualTo(String value) {
            addCriterion("dest_place_id <=", value, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdLike(String value) {
            addCriterion("dest_place_id like", value, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdNotLike(String value) {
            addCriterion("dest_place_id not like", value, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdIn(List<String> values) {
            addCriterion("dest_place_id in", values, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdNotIn(List<String> values) {
            addCriterion("dest_place_id not in", values, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdBetween(String value1, String value2) {
            addCriterion("dest_place_id between", value1, value2, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andDestPlaceIdNotBetween(String value1, String value2) {
            addCriterion("dest_place_id not between", value1, value2, "destPlaceId");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIsNull() {
            addCriterion("agent_type is null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIsNotNull() {
            addCriterion("agent_type is not null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeEqualTo(String value) {
            addCriterion("agent_type =", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotEqualTo(String value) {
            addCriterion("agent_type <>", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThan(String value) {
            addCriterion("agent_type >", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("agent_type >=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThan(String value) {
            addCriterion("agent_type <", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThanOrEqualTo(String value) {
            addCriterion("agent_type <=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLike(String value) {
            addCriterion("agent_type like", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotLike(String value) {
            addCriterion("agent_type not like", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIn(List<String> values) {
            addCriterion("agent_type in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotIn(List<String> values) {
            addCriterion("agent_type not in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeBetween(String value1, String value2) {
            addCriterion("agent_type between", value1, value2, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotBetween(String value1, String value2) {
            addCriterion("agent_type not between", value1, value2, "agentType");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNull() {
            addCriterion("pic_path is null");
            return (Criteria) this;
        }

        public Criteria andPicPathIsNotNull() {
            addCriterion("pic_path is not null");
            return (Criteria) this;
        }

        public Criteria andPicPathEqualTo(String value) {
            addCriterion("pic_path =", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotEqualTo(String value) {
            addCriterion("pic_path <>", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThan(String value) {
            addCriterion("pic_path >", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathGreaterThanOrEqualTo(String value) {
            addCriterion("pic_path >=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThan(String value) {
            addCriterion("pic_path <", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLessThanOrEqualTo(String value) {
            addCriterion("pic_path <=", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathLike(String value) {
            addCriterion("pic_path like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotLike(String value) {
            addCriterion("pic_path not like", value, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathIn(List<String> values) {
            addCriterion("pic_path in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotIn(List<String> values) {
            addCriterion("pic_path not in", values, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathBetween(String value1, String value2) {
            addCriterion("pic_path between", value1, value2, "picPath");
            return (Criteria) this;
        }

        public Criteria andPicPathNotBetween(String value1, String value2) {
            addCriterion("pic_path not between", value1, value2, "picPath");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNull() {
            addCriterion("click_count is null");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNotNull() {
            addCriterion("click_count is not null");
            return (Criteria) this;
        }

        public Criteria andClickCountEqualTo(Integer value) {
            addCriterion("click_count =", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotEqualTo(Integer value) {
            addCriterion("click_count <>", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThan(Integer value) {
            addCriterion("click_count >", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_count >=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThan(Integer value) {
            addCriterion("click_count <", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThanOrEqualTo(Integer value) {
            addCriterion("click_count <=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIn(List<Integer> values) {
            addCriterion("click_count in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotIn(List<Integer> values) {
            addCriterion("click_count not in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountBetween(Integer value1, Integer value2) {
            addCriterion("click_count between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("click_count not between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andAskedCountIsNull() {
            addCriterion("asked_count is null");
            return (Criteria) this;
        }

        public Criteria andAskedCountIsNotNull() {
            addCriterion("asked_count is not null");
            return (Criteria) this;
        }

        public Criteria andAskedCountEqualTo(Integer value) {
            addCriterion("asked_count =", value, "askedCount");
            return (Criteria) this;
        }

        public Criteria andAskedCountNotEqualTo(Integer value) {
            addCriterion("asked_count <>", value, "askedCount");
            return (Criteria) this;
        }

        public Criteria andAskedCountGreaterThan(Integer value) {
            addCriterion("asked_count >", value, "askedCount");
            return (Criteria) this;
        }

        public Criteria andAskedCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("asked_count >=", value, "askedCount");
            return (Criteria) this;
        }

        public Criteria andAskedCountLessThan(Integer value) {
            addCriterion("asked_count <", value, "askedCount");
            return (Criteria) this;
        }

        public Criteria andAskedCountLessThanOrEqualTo(Integer value) {
            addCriterion("asked_count <=", value, "askedCount");
            return (Criteria) this;
        }

        public Criteria andAskedCountIn(List<Integer> values) {
            addCriterion("asked_count in", values, "askedCount");
            return (Criteria) this;
        }

        public Criteria andAskedCountNotIn(List<Integer> values) {
            addCriterion("asked_count not in", values, "askedCount");
            return (Criteria) this;
        }

        public Criteria andAskedCountBetween(Integer value1, Integer value2) {
            addCriterion("asked_count between", value1, value2, "askedCount");
            return (Criteria) this;
        }

        public Criteria andAskedCountNotBetween(Integer value1, Integer value2) {
            addCriterion("asked_count not between", value1, value2, "askedCount");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCityIdsIsNull() {
            addCriterion("city_ids is null");
            return (Criteria) this;
        }

        public Criteria andCityIdsIsNotNull() {
            addCriterion("city_ids is not null");
            return (Criteria) this;
        }

        public Criteria andCityIdsEqualTo(String value) {
            addCriterion("city_ids =", value, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCityIdsNotEqualTo(String value) {
            addCriterion("city_ids <>", value, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCityIdsGreaterThan(String value) {
            addCriterion("city_ids >", value, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCityIdsGreaterThanOrEqualTo(String value) {
            addCriterion("city_ids >=", value, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCityIdsLessThan(String value) {
            addCriterion("city_ids <", value, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCityIdsLessThanOrEqualTo(String value) {
            addCriterion("city_ids <=", value, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCityIdsLike(String value) {
            addCriterion("city_ids like", value, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCityIdsNotLike(String value) {
            addCriterion("city_ids not like", value, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCityIdsIn(List<String> values) {
            addCriterion("city_ids in", values, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCityIdsNotIn(List<String> values) {
            addCriterion("city_ids not in", values, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCityIdsBetween(String value1, String value2) {
            addCriterion("city_ids between", value1, value2, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCityIdsNotBetween(String value1, String value2) {
            addCriterion("city_ids not between", value1, value2, "cityIds");
            return (Criteria) this;
        }

        public Criteria andCompIdIsNull() {
            addCriterion("comp_id is null");
            return (Criteria) this;
        }

        public Criteria andCompIdIsNotNull() {
            addCriterion("comp_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompIdEqualTo(Integer value) {
            addCriterion("comp_id =", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotEqualTo(Integer value) {
            addCriterion("comp_id <>", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdGreaterThan(Integer value) {
            addCriterion("comp_id >", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("comp_id >=", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdLessThan(Integer value) {
            addCriterion("comp_id <", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdLessThanOrEqualTo(Integer value) {
            addCriterion("comp_id <=", value, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdIn(List<Integer> values) {
            addCriterion("comp_id in", values, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotIn(List<Integer> values) {
            addCriterion("comp_id not in", values, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdBetween(Integer value1, Integer value2) {
            addCriterion("comp_id between", value1, value2, "compId");
            return (Criteria) this;
        }

        public Criteria andCompIdNotBetween(Integer value1, Integer value2) {
            addCriterion("comp_id not between", value1, value2, "compId");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIsNull() {
            addCriterion("system_flag is null");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIsNotNull() {
            addCriterion("system_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSystemFlagEqualTo(String value) {
            addCriterion("system_flag =", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotEqualTo(String value) {
            addCriterion("system_flag <>", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagGreaterThan(String value) {
            addCriterion("system_flag >", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagGreaterThanOrEqualTo(String value) {
            addCriterion("system_flag >=", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLessThan(String value) {
            addCriterion("system_flag <", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLessThanOrEqualTo(String value) {
            addCriterion("system_flag <=", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLike(String value) {
            addCriterion("system_flag like", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotLike(String value) {
            addCriterion("system_flag not like", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIn(List<String> values) {
            addCriterion("system_flag in", values, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotIn(List<String> values) {
            addCriterion("system_flag not in", values, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagBetween(String value1, String value2) {
            addCriterion("system_flag between", value1, value2, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotBetween(String value1, String value2) {
            addCriterion("system_flag not between", value1, value2, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNull() {
            addCriterion("create_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateNameIsNotNull() {
            addCriterion("create_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateNameEqualTo(String value) {
            addCriterion("create_name =", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotEqualTo(String value) {
            addCriterion("create_name <>", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThan(String value) {
            addCriterion("create_name >", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_name >=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThan(String value) {
            addCriterion("create_name <", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLessThanOrEqualTo(String value) {
            addCriterion("create_name <=", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameLike(String value) {
            addCriterion("create_name like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotLike(String value) {
            addCriterion("create_name not like", value, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameIn(List<String> values) {
            addCriterion("create_name in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotIn(List<String> values) {
            addCriterion("create_name not in", values, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameBetween(String value1, String value2) {
            addCriterion("create_name between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andCreateNameNotBetween(String value1, String value2) {
            addCriterion("create_name not between", value1, value2, "createName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNull() {
            addCriterion("update_name is null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIsNotNull() {
            addCriterion("update_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateNameEqualTo(String value) {
            addCriterion("update_name =", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotEqualTo(String value) {
            addCriterion("update_name <>", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThan(String value) {
            addCriterion("update_name >", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameGreaterThanOrEqualTo(String value) {
            addCriterion("update_name >=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThan(String value) {
            addCriterion("update_name <", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLessThanOrEqualTo(String value) {
            addCriterion("update_name <=", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameLike(String value) {
            addCriterion("update_name like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotLike(String value) {
            addCriterion("update_name not like", value, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameIn(List<String> values) {
            addCriterion("update_name in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotIn(List<String> values) {
            addCriterion("update_name not in", values, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameBetween(String value1, String value2) {
            addCriterion("update_name between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andUpdateNameNotBetween(String value1, String value2) {
            addCriterion("update_name not between", value1, value2, "updateName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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