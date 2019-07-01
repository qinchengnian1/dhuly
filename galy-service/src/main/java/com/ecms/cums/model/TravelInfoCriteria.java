package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.List;

public class TravelInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TravelInfoCriteria() {
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

        public Criteria andPIIdIsNull() {
            addCriterion("p_i_id is null");
            return (Criteria) this;
        }

        public Criteria andPIIdIsNotNull() {
            addCriterion("p_i_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIIdEqualTo(Integer value) {
            addCriterion("p_i_id =", value, "pIId");
            return (Criteria) this;
        }

        public Criteria andPIIdNotEqualTo(Integer value) {
            addCriterion("p_i_id <>", value, "pIId");
            return (Criteria) this;
        }

        public Criteria andPIIdGreaterThan(Integer value) {
            addCriterion("p_i_id >", value, "pIId");
            return (Criteria) this;
        }

        public Criteria andPIIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_i_id >=", value, "pIId");
            return (Criteria) this;
        }

        public Criteria andPIIdLessThan(Integer value) {
            addCriterion("p_i_id <", value, "pIId");
            return (Criteria) this;
        }

        public Criteria andPIIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_i_id <=", value, "pIId");
            return (Criteria) this;
        }

        public Criteria andPIIdIn(List<Integer> values) {
            addCriterion("p_i_id in", values, "pIId");
            return (Criteria) this;
        }

        public Criteria andPIIdNotIn(List<Integer> values) {
            addCriterion("p_i_id not in", values, "pIId");
            return (Criteria) this;
        }

        public Criteria andPIIdBetween(Integer value1, Integer value2) {
            addCriterion("p_i_id between", value1, value2, "pIId");
            return (Criteria) this;
        }

        public Criteria andPIIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_i_id not between", value1, value2, "pIId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNull() {
            addCriterion("room_type is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNotNull() {
            addCriterion("room_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeEqualTo(String value) {
            addCriterion("room_type =", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotEqualTo(String value) {
            addCriterion("room_type <>", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThan(String value) {
            addCriterion("room_type >", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("room_type >=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThan(String value) {
            addCriterion("room_type <", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThanOrEqualTo(String value) {
            addCriterion("room_type <=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLike(String value) {
            addCriterion("room_type like", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotLike(String value) {
            addCriterion("room_type not like", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIn(List<String> values) {
            addCriterion("room_type in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotIn(List<String> values) {
            addCriterion("room_type not in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeBetween(String value1, String value2) {
            addCriterion("room_type between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotBetween(String value1, String value2) {
            addCriterion("room_type not between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameIsNull() {
            addCriterion("room_type_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameIsNotNull() {
            addCriterion("room_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameEqualTo(String value) {
            addCriterion("room_type_name =", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameNotEqualTo(String value) {
            addCriterion("room_type_name <>", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameGreaterThan(String value) {
            addCriterion("room_type_name >", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_type_name >=", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameLessThan(String value) {
            addCriterion("room_type_name <", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameLessThanOrEqualTo(String value) {
            addCriterion("room_type_name <=", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameLike(String value) {
            addCriterion("room_type_name like", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameNotLike(String value) {
            addCriterion("room_type_name not like", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameIn(List<String> values) {
            addCriterion("room_type_name in", values, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameNotIn(List<String> values) {
            addCriterion("room_type_name not in", values, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameBetween(String value1, String value2) {
            addCriterion("room_type_name between", value1, value2, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameNotBetween(String value1, String value2) {
            addCriterion("room_type_name not between", value1, value2, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomMemoIsNull() {
            addCriterion("room_memo is null");
            return (Criteria) this;
        }

        public Criteria andRoomMemoIsNotNull() {
            addCriterion("room_memo is not null");
            return (Criteria) this;
        }

        public Criteria andRoomMemoEqualTo(String value) {
            addCriterion("room_memo =", value, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andRoomMemoNotEqualTo(String value) {
            addCriterion("room_memo <>", value, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andRoomMemoGreaterThan(String value) {
            addCriterion("room_memo >", value, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andRoomMemoGreaterThanOrEqualTo(String value) {
            addCriterion("room_memo >=", value, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andRoomMemoLessThan(String value) {
            addCriterion("room_memo <", value, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andRoomMemoLessThanOrEqualTo(String value) {
            addCriterion("room_memo <=", value, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andRoomMemoLike(String value) {
            addCriterion("room_memo like", value, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andRoomMemoNotLike(String value) {
            addCriterion("room_memo not like", value, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andRoomMemoIn(List<String> values) {
            addCriterion("room_memo in", values, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andRoomMemoNotIn(List<String> values) {
            addCriterion("room_memo not in", values, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andRoomMemoBetween(String value1, String value2) {
            addCriterion("room_memo between", value1, value2, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andRoomMemoNotBetween(String value1, String value2) {
            addCriterion("room_memo not between", value1, value2, "roomMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgIsNull() {
            addCriterion("breakfast_flg is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgIsNotNull() {
            addCriterion("breakfast_flg is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgEqualTo(String value) {
            addCriterion("breakfast_flg =", value, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgNotEqualTo(String value) {
            addCriterion("breakfast_flg <>", value, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgGreaterThan(String value) {
            addCriterion("breakfast_flg >", value, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgGreaterThanOrEqualTo(String value) {
            addCriterion("breakfast_flg >=", value, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgLessThan(String value) {
            addCriterion("breakfast_flg <", value, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgLessThanOrEqualTo(String value) {
            addCriterion("breakfast_flg <=", value, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgLike(String value) {
            addCriterion("breakfast_flg like", value, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgNotLike(String value) {
            addCriterion("breakfast_flg not like", value, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgIn(List<String> values) {
            addCriterion("breakfast_flg in", values, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgNotIn(List<String> values) {
            addCriterion("breakfast_flg not in", values, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgBetween(String value1, String value2) {
            addCriterion("breakfast_flg between", value1, value2, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastFlgNotBetween(String value1, String value2) {
            addCriterion("breakfast_flg not between", value1, value2, "breakfastFlg");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameIsNull() {
            addCriterion("breakfast_type_name is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameIsNotNull() {
            addCriterion("breakfast_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameEqualTo(String value) {
            addCriterion("breakfast_type_name =", value, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameNotEqualTo(String value) {
            addCriterion("breakfast_type_name <>", value, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameGreaterThan(String value) {
            addCriterion("breakfast_type_name >", value, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("breakfast_type_name >=", value, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameLessThan(String value) {
            addCriterion("breakfast_type_name <", value, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameLessThanOrEqualTo(String value) {
            addCriterion("breakfast_type_name <=", value, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameLike(String value) {
            addCriterion("breakfast_type_name like", value, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameNotLike(String value) {
            addCriterion("breakfast_type_name not like", value, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameIn(List<String> values) {
            addCriterion("breakfast_type_name in", values, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameNotIn(List<String> values) {
            addCriterion("breakfast_type_name not in", values, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameBetween(String value1, String value2) {
            addCriterion("breakfast_type_name between", value1, value2, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNameNotBetween(String value1, String value2) {
            addCriterion("breakfast_type_name not between", value1, value2, "breakfastTypeName");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeIsNull() {
            addCriterion("breakfast_type is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeIsNotNull() {
            addCriterion("breakfast_type is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeEqualTo(String value) {
            addCriterion("breakfast_type =", value, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNotEqualTo(String value) {
            addCriterion("breakfast_type <>", value, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeGreaterThan(String value) {
            addCriterion("breakfast_type >", value, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeGreaterThanOrEqualTo(String value) {
            addCriterion("breakfast_type >=", value, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeLessThan(String value) {
            addCriterion("breakfast_type <", value, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeLessThanOrEqualTo(String value) {
            addCriterion("breakfast_type <=", value, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeLike(String value) {
            addCriterion("breakfast_type like", value, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNotLike(String value) {
            addCriterion("breakfast_type not like", value, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeIn(List<String> values) {
            addCriterion("breakfast_type in", values, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNotIn(List<String> values) {
            addCriterion("breakfast_type not in", values, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeBetween(String value1, String value2) {
            addCriterion("breakfast_type between", value1, value2, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastTypeNotBetween(String value1, String value2) {
            addCriterion("breakfast_type not between", value1, value2, "breakfastType");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoIsNull() {
            addCriterion("breakfast_memo is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoIsNotNull() {
            addCriterion("breakfast_memo is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoEqualTo(String value) {
            addCriterion("breakfast_memo =", value, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoNotEqualTo(String value) {
            addCriterion("breakfast_memo <>", value, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoGreaterThan(String value) {
            addCriterion("breakfast_memo >", value, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoGreaterThanOrEqualTo(String value) {
            addCriterion("breakfast_memo >=", value, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoLessThan(String value) {
            addCriterion("breakfast_memo <", value, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoLessThanOrEqualTo(String value) {
            addCriterion("breakfast_memo <=", value, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoLike(String value) {
            addCriterion("breakfast_memo like", value, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoNotLike(String value) {
            addCriterion("breakfast_memo not like", value, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoIn(List<String> values) {
            addCriterion("breakfast_memo in", values, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoNotIn(List<String> values) {
            addCriterion("breakfast_memo not in", values, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoBetween(String value1, String value2) {
            addCriterion("breakfast_memo between", value1, value2, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andBreakfastMemoNotBetween(String value1, String value2) {
            addCriterion("breakfast_memo not between", value1, value2, "breakfastMemo");
            return (Criteria) this;
        }

        public Criteria andLunchFlgIsNull() {
            addCriterion("lunch_flg is null");
            return (Criteria) this;
        }

        public Criteria andLunchFlgIsNotNull() {
            addCriterion("lunch_flg is not null");
            return (Criteria) this;
        }

        public Criteria andLunchFlgEqualTo(String value) {
            addCriterion("lunch_flg =", value, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchFlgNotEqualTo(String value) {
            addCriterion("lunch_flg <>", value, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchFlgGreaterThan(String value) {
            addCriterion("lunch_flg >", value, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchFlgGreaterThanOrEqualTo(String value) {
            addCriterion("lunch_flg >=", value, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchFlgLessThan(String value) {
            addCriterion("lunch_flg <", value, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchFlgLessThanOrEqualTo(String value) {
            addCriterion("lunch_flg <=", value, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchFlgLike(String value) {
            addCriterion("lunch_flg like", value, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchFlgNotLike(String value) {
            addCriterion("lunch_flg not like", value, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchFlgIn(List<String> values) {
            addCriterion("lunch_flg in", values, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchFlgNotIn(List<String> values) {
            addCriterion("lunch_flg not in", values, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchFlgBetween(String value1, String value2) {
            addCriterion("lunch_flg between", value1, value2, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchFlgNotBetween(String value1, String value2) {
            addCriterion("lunch_flg not between", value1, value2, "lunchFlg");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameIsNull() {
            addCriterion("lunch_type_name is null");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameIsNotNull() {
            addCriterion("lunch_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameEqualTo(String value) {
            addCriterion("lunch_type_name =", value, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameNotEqualTo(String value) {
            addCriterion("lunch_type_name <>", value, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameGreaterThan(String value) {
            addCriterion("lunch_type_name >", value, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("lunch_type_name >=", value, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameLessThan(String value) {
            addCriterion("lunch_type_name <", value, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameLessThanOrEqualTo(String value) {
            addCriterion("lunch_type_name <=", value, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameLike(String value) {
            addCriterion("lunch_type_name like", value, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameNotLike(String value) {
            addCriterion("lunch_type_name not like", value, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameIn(List<String> values) {
            addCriterion("lunch_type_name in", values, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameNotIn(List<String> values) {
            addCriterion("lunch_type_name not in", values, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameBetween(String value1, String value2) {
            addCriterion("lunch_type_name between", value1, value2, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNameNotBetween(String value1, String value2) {
            addCriterion("lunch_type_name not between", value1, value2, "lunchTypeName");
            return (Criteria) this;
        }

        public Criteria andLunchTypeIsNull() {
            addCriterion("lunch_type is null");
            return (Criteria) this;
        }

        public Criteria andLunchTypeIsNotNull() {
            addCriterion("lunch_type is not null");
            return (Criteria) this;
        }

        public Criteria andLunchTypeEqualTo(String value) {
            addCriterion("lunch_type =", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNotEqualTo(String value) {
            addCriterion("lunch_type <>", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeGreaterThan(String value) {
            addCriterion("lunch_type >", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeGreaterThanOrEqualTo(String value) {
            addCriterion("lunch_type >=", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeLessThan(String value) {
            addCriterion("lunch_type <", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeLessThanOrEqualTo(String value) {
            addCriterion("lunch_type <=", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeLike(String value) {
            addCriterion("lunch_type like", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNotLike(String value) {
            addCriterion("lunch_type not like", value, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeIn(List<String> values) {
            addCriterion("lunch_type in", values, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNotIn(List<String> values) {
            addCriterion("lunch_type not in", values, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeBetween(String value1, String value2) {
            addCriterion("lunch_type between", value1, value2, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchTypeNotBetween(String value1, String value2) {
            addCriterion("lunch_type not between", value1, value2, "lunchType");
            return (Criteria) this;
        }

        public Criteria andLunchMemoIsNull() {
            addCriterion("lunch_memo is null");
            return (Criteria) this;
        }

        public Criteria andLunchMemoIsNotNull() {
            addCriterion("lunch_memo is not null");
            return (Criteria) this;
        }

        public Criteria andLunchMemoEqualTo(String value) {
            addCriterion("lunch_memo =", value, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andLunchMemoNotEqualTo(String value) {
            addCriterion("lunch_memo <>", value, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andLunchMemoGreaterThan(String value) {
            addCriterion("lunch_memo >", value, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andLunchMemoGreaterThanOrEqualTo(String value) {
            addCriterion("lunch_memo >=", value, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andLunchMemoLessThan(String value) {
            addCriterion("lunch_memo <", value, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andLunchMemoLessThanOrEqualTo(String value) {
            addCriterion("lunch_memo <=", value, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andLunchMemoLike(String value) {
            addCriterion("lunch_memo like", value, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andLunchMemoNotLike(String value) {
            addCriterion("lunch_memo not like", value, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andLunchMemoIn(List<String> values) {
            addCriterion("lunch_memo in", values, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andLunchMemoNotIn(List<String> values) {
            addCriterion("lunch_memo not in", values, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andLunchMemoBetween(String value1, String value2) {
            addCriterion("lunch_memo between", value1, value2, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andLunchMemoNotBetween(String value1, String value2) {
            addCriterion("lunch_memo not between", value1, value2, "lunchMemo");
            return (Criteria) this;
        }

        public Criteria andSupperFlgIsNull() {
            addCriterion("supper_flg is null");
            return (Criteria) this;
        }

        public Criteria andSupperFlgIsNotNull() {
            addCriterion("supper_flg is not null");
            return (Criteria) this;
        }

        public Criteria andSupperFlgEqualTo(String value) {
            addCriterion("supper_flg =", value, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperFlgNotEqualTo(String value) {
            addCriterion("supper_flg <>", value, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperFlgGreaterThan(String value) {
            addCriterion("supper_flg >", value, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperFlgGreaterThanOrEqualTo(String value) {
            addCriterion("supper_flg >=", value, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperFlgLessThan(String value) {
            addCriterion("supper_flg <", value, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperFlgLessThanOrEqualTo(String value) {
            addCriterion("supper_flg <=", value, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperFlgLike(String value) {
            addCriterion("supper_flg like", value, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperFlgNotLike(String value) {
            addCriterion("supper_flg not like", value, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperFlgIn(List<String> values) {
            addCriterion("supper_flg in", values, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperFlgNotIn(List<String> values) {
            addCriterion("supper_flg not in", values, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperFlgBetween(String value1, String value2) {
            addCriterion("supper_flg between", value1, value2, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperFlgNotBetween(String value1, String value2) {
            addCriterion("supper_flg not between", value1, value2, "supperFlg");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameIsNull() {
            addCriterion("supper_type_name is null");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameIsNotNull() {
            addCriterion("supper_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameEqualTo(String value) {
            addCriterion("supper_type_name =", value, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameNotEqualTo(String value) {
            addCriterion("supper_type_name <>", value, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameGreaterThan(String value) {
            addCriterion("supper_type_name >", value, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("supper_type_name >=", value, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameLessThan(String value) {
            addCriterion("supper_type_name <", value, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameLessThanOrEqualTo(String value) {
            addCriterion("supper_type_name <=", value, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameLike(String value) {
            addCriterion("supper_type_name like", value, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameNotLike(String value) {
            addCriterion("supper_type_name not like", value, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameIn(List<String> values) {
            addCriterion("supper_type_name in", values, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameNotIn(List<String> values) {
            addCriterion("supper_type_name not in", values, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameBetween(String value1, String value2) {
            addCriterion("supper_type_name between", value1, value2, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNameNotBetween(String value1, String value2) {
            addCriterion("supper_type_name not between", value1, value2, "supperTypeName");
            return (Criteria) this;
        }

        public Criteria andSupperTypeIsNull() {
            addCriterion("supper_type is null");
            return (Criteria) this;
        }

        public Criteria andSupperTypeIsNotNull() {
            addCriterion("supper_type is not null");
            return (Criteria) this;
        }

        public Criteria andSupperTypeEqualTo(String value) {
            addCriterion("supper_type =", value, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNotEqualTo(String value) {
            addCriterion("supper_type <>", value, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperTypeGreaterThan(String value) {
            addCriterion("supper_type >", value, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("supper_type >=", value, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperTypeLessThan(String value) {
            addCriterion("supper_type <", value, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperTypeLessThanOrEqualTo(String value) {
            addCriterion("supper_type <=", value, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperTypeLike(String value) {
            addCriterion("supper_type like", value, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNotLike(String value) {
            addCriterion("supper_type not like", value, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperTypeIn(List<String> values) {
            addCriterion("supper_type in", values, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNotIn(List<String> values) {
            addCriterion("supper_type not in", values, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperTypeBetween(String value1, String value2) {
            addCriterion("supper_type between", value1, value2, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperTypeNotBetween(String value1, String value2) {
            addCriterion("supper_type not between", value1, value2, "supperType");
            return (Criteria) this;
        }

        public Criteria andSupperMemoIsNull() {
            addCriterion("supper_memo is null");
            return (Criteria) this;
        }

        public Criteria andSupperMemoIsNotNull() {
            addCriterion("supper_memo is not null");
            return (Criteria) this;
        }

        public Criteria andSupperMemoEqualTo(String value) {
            addCriterion("supper_memo =", value, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andSupperMemoNotEqualTo(String value) {
            addCriterion("supper_memo <>", value, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andSupperMemoGreaterThan(String value) {
            addCriterion("supper_memo >", value, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andSupperMemoGreaterThanOrEqualTo(String value) {
            addCriterion("supper_memo >=", value, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andSupperMemoLessThan(String value) {
            addCriterion("supper_memo <", value, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andSupperMemoLessThanOrEqualTo(String value) {
            addCriterion("supper_memo <=", value, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andSupperMemoLike(String value) {
            addCriterion("supper_memo like", value, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andSupperMemoNotLike(String value) {
            addCriterion("supper_memo not like", value, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andSupperMemoIn(List<String> values) {
            addCriterion("supper_memo in", values, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andSupperMemoNotIn(List<String> values) {
            addCriterion("supper_memo not in", values, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andSupperMemoBetween(String value1, String value2) {
            addCriterion("supper_memo between", value1, value2, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andSupperMemoNotBetween(String value1, String value2) {
            addCriterion("supper_memo not between", value1, value2, "supperMemo");
            return (Criteria) this;
        }

        public Criteria andPocPathIsNull() {
            addCriterion("poc_path is null");
            return (Criteria) this;
        }

        public Criteria andPocPathIsNotNull() {
            addCriterion("poc_path is not null");
            return (Criteria) this;
        }

        public Criteria andPocPathEqualTo(String value) {
            addCriterion("poc_path =", value, "pocPath");
            return (Criteria) this;
        }

        public Criteria andPocPathNotEqualTo(String value) {
            addCriterion("poc_path <>", value, "pocPath");
            return (Criteria) this;
        }

        public Criteria andPocPathGreaterThan(String value) {
            addCriterion("poc_path >", value, "pocPath");
            return (Criteria) this;
        }

        public Criteria andPocPathGreaterThanOrEqualTo(String value) {
            addCriterion("poc_path >=", value, "pocPath");
            return (Criteria) this;
        }

        public Criteria andPocPathLessThan(String value) {
            addCriterion("poc_path <", value, "pocPath");
            return (Criteria) this;
        }

        public Criteria andPocPathLessThanOrEqualTo(String value) {
            addCriterion("poc_path <=", value, "pocPath");
            return (Criteria) this;
        }

        public Criteria andPocPathLike(String value) {
            addCriterion("poc_path like", value, "pocPath");
            return (Criteria) this;
        }

        public Criteria andPocPathNotLike(String value) {
            addCriterion("poc_path not like", value, "pocPath");
            return (Criteria) this;
        }

        public Criteria andPocPathIn(List<String> values) {
            addCriterion("poc_path in", values, "pocPath");
            return (Criteria) this;
        }

        public Criteria andPocPathNotIn(List<String> values) {
            addCriterion("poc_path not in", values, "pocPath");
            return (Criteria) this;
        }

        public Criteria andPocPathBetween(String value1, String value2) {
            addCriterion("poc_path between", value1, value2, "pocPath");
            return (Criteria) this;
        }

        public Criteria andPocPathNotBetween(String value1, String value2) {
            addCriterion("poc_path not between", value1, value2, "pocPath");
            return (Criteria) this;
        }

        public Criteria andTrafficNoIsNull() {
            addCriterion("traffic_no is null");
            return (Criteria) this;
        }

        public Criteria andTrafficNoIsNotNull() {
            addCriterion("traffic_no is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficNoEqualTo(String value) {
            addCriterion("traffic_no =", value, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andTrafficNoNotEqualTo(String value) {
            addCriterion("traffic_no <>", value, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andTrafficNoGreaterThan(String value) {
            addCriterion("traffic_no >", value, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andTrafficNoGreaterThanOrEqualTo(String value) {
            addCriterion("traffic_no >=", value, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andTrafficNoLessThan(String value) {
            addCriterion("traffic_no <", value, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andTrafficNoLessThanOrEqualTo(String value) {
            addCriterion("traffic_no <=", value, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andTrafficNoLike(String value) {
            addCriterion("traffic_no like", value, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andTrafficNoNotLike(String value) {
            addCriterion("traffic_no not like", value, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andTrafficNoIn(List<String> values) {
            addCriterion("traffic_no in", values, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andTrafficNoNotIn(List<String> values) {
            addCriterion("traffic_no not in", values, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andTrafficNoBetween(String value1, String value2) {
            addCriterion("traffic_no between", value1, value2, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andTrafficNoNotBetween(String value1, String value2) {
            addCriterion("traffic_no not between", value1, value2, "trafficNo");
            return (Criteria) this;
        }

        public Criteria andFromCityIdIsNull() {
            addCriterion("from_city_id is null");
            return (Criteria) this;
        }

        public Criteria andFromCityIdIsNotNull() {
            addCriterion("from_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromCityIdEqualTo(Integer value) {
            addCriterion("from_city_id =", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdNotEqualTo(Integer value) {
            addCriterion("from_city_id <>", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdGreaterThan(Integer value) {
            addCriterion("from_city_id >", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_city_id >=", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdLessThan(Integer value) {
            addCriterion("from_city_id <", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdLessThanOrEqualTo(Integer value) {
            addCriterion("from_city_id <=", value, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdIn(List<Integer> values) {
            addCriterion("from_city_id in", values, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdNotIn(List<Integer> values) {
            addCriterion("from_city_id not in", values, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdBetween(Integer value1, Integer value2) {
            addCriterion("from_city_id between", value1, value2, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("from_city_id not between", value1, value2, "fromCityId");
            return (Criteria) this;
        }

        public Criteria andFromCityNameIsNull() {
            addCriterion("from_city_name is null");
            return (Criteria) this;
        }

        public Criteria andFromCityNameIsNotNull() {
            addCriterion("from_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andFromCityNameEqualTo(String value) {
            addCriterion("from_city_name =", value, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andFromCityNameNotEqualTo(String value) {
            addCriterion("from_city_name <>", value, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andFromCityNameGreaterThan(String value) {
            addCriterion("from_city_name >", value, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andFromCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("from_city_name >=", value, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andFromCityNameLessThan(String value) {
            addCriterion("from_city_name <", value, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andFromCityNameLessThanOrEqualTo(String value) {
            addCriterion("from_city_name <=", value, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andFromCityNameLike(String value) {
            addCriterion("from_city_name like", value, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andFromCityNameNotLike(String value) {
            addCriterion("from_city_name not like", value, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andFromCityNameIn(List<String> values) {
            addCriterion("from_city_name in", values, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andFromCityNameNotIn(List<String> values) {
            addCriterion("from_city_name not in", values, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andFromCityNameBetween(String value1, String value2) {
            addCriterion("from_city_name between", value1, value2, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andFromCityNameNotBetween(String value1, String value2) {
            addCriterion("from_city_name not between", value1, value2, "fromCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdIsNull() {
            addCriterion("arrive_city_id is null");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdIsNotNull() {
            addCriterion("arrive_city_id is not null");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdEqualTo(String value) {
            addCriterion("arrive_city_id =", value, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdNotEqualTo(String value) {
            addCriterion("arrive_city_id <>", value, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdGreaterThan(String value) {
            addCriterion("arrive_city_id >", value, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdGreaterThanOrEqualTo(String value) {
            addCriterion("arrive_city_id >=", value, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdLessThan(String value) {
            addCriterion("arrive_city_id <", value, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdLessThanOrEqualTo(String value) {
            addCriterion("arrive_city_id <=", value, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdLike(String value) {
            addCriterion("arrive_city_id like", value, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdNotLike(String value) {
            addCriterion("arrive_city_id not like", value, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdIn(List<String> values) {
            addCriterion("arrive_city_id in", values, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdNotIn(List<String> values) {
            addCriterion("arrive_city_id not in", values, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdBetween(String value1, String value2) {
            addCriterion("arrive_city_id between", value1, value2, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityIdNotBetween(String value1, String value2) {
            addCriterion("arrive_city_id not between", value1, value2, "arriveCityId");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameIsNull() {
            addCriterion("arrive_city_name is null");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameIsNotNull() {
            addCriterion("arrive_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameEqualTo(String value) {
            addCriterion("arrive_city_name =", value, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameNotEqualTo(String value) {
            addCriterion("arrive_city_name <>", value, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameGreaterThan(String value) {
            addCriterion("arrive_city_name >", value, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("arrive_city_name >=", value, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameLessThan(String value) {
            addCriterion("arrive_city_name <", value, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameLessThanOrEqualTo(String value) {
            addCriterion("arrive_city_name <=", value, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameLike(String value) {
            addCriterion("arrive_city_name like", value, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameNotLike(String value) {
            addCriterion("arrive_city_name not like", value, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameIn(List<String> values) {
            addCriterion("arrive_city_name in", values, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameNotIn(List<String> values) {
            addCriterion("arrive_city_name not in", values, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameBetween(String value1, String value2) {
            addCriterion("arrive_city_name between", value1, value2, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andArriveCityNameNotBetween(String value1, String value2) {
            addCriterion("arrive_city_name not between", value1, value2, "arriveCityName");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeIsNull() {
            addCriterion("traffic_type is null");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeIsNotNull() {
            addCriterion("traffic_type is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeEqualTo(String value) {
            addCriterion("traffic_type =", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeNotEqualTo(String value) {
            addCriterion("traffic_type <>", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeGreaterThan(String value) {
            addCriterion("traffic_type >", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeGreaterThanOrEqualTo(String value) {
            addCriterion("traffic_type >=", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeLessThan(String value) {
            addCriterion("traffic_type <", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeLessThanOrEqualTo(String value) {
            addCriterion("traffic_type <=", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeLike(String value) {
            addCriterion("traffic_type like", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeNotLike(String value) {
            addCriterion("traffic_type not like", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeIn(List<String> values) {
            addCriterion("traffic_type in", values, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeNotIn(List<String> values) {
            addCriterion("traffic_type not in", values, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeBetween(String value1, String value2) {
            addCriterion("traffic_type between", value1, value2, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeNotBetween(String value1, String value2) {
            addCriterion("traffic_type not between", value1, value2, "trafficType");
            return (Criteria) this;
        }

        public Criteria andCityTypeIsNull() {
            addCriterion("city_type is null");
            return (Criteria) this;
        }

        public Criteria andCityTypeIsNotNull() {
            addCriterion("city_type is not null");
            return (Criteria) this;
        }

        public Criteria andCityTypeEqualTo(String value) {
            addCriterion("city_type =", value, "cityType");
            return (Criteria) this;
        }

        public Criteria andCityTypeNotEqualTo(String value) {
            addCriterion("city_type <>", value, "cityType");
            return (Criteria) this;
        }

        public Criteria andCityTypeGreaterThan(String value) {
            addCriterion("city_type >", value, "cityType");
            return (Criteria) this;
        }

        public Criteria andCityTypeGreaterThanOrEqualTo(String value) {
            addCriterion("city_type >=", value, "cityType");
            return (Criteria) this;
        }

        public Criteria andCityTypeLessThan(String value) {
            addCriterion("city_type <", value, "cityType");
            return (Criteria) this;
        }

        public Criteria andCityTypeLessThanOrEqualTo(String value) {
            addCriterion("city_type <=", value, "cityType");
            return (Criteria) this;
        }

        public Criteria andCityTypeLike(String value) {
            addCriterion("city_type like", value, "cityType");
            return (Criteria) this;
        }

        public Criteria andCityTypeNotLike(String value) {
            addCriterion("city_type not like", value, "cityType");
            return (Criteria) this;
        }

        public Criteria andCityTypeIn(List<String> values) {
            addCriterion("city_type in", values, "cityType");
            return (Criteria) this;
        }

        public Criteria andCityTypeNotIn(List<String> values) {
            addCriterion("city_type not in", values, "cityType");
            return (Criteria) this;
        }

        public Criteria andCityTypeBetween(String value1, String value2) {
            addCriterion("city_type between", value1, value2, "cityType");
            return (Criteria) this;
        }

        public Criteria andCityTypeNotBetween(String value1, String value2) {
            addCriterion("city_type not between", value1, value2, "cityType");
            return (Criteria) this;
        }

        public Criteria andAirCompIsNull() {
            addCriterion("air_comp is null");
            return (Criteria) this;
        }

        public Criteria andAirCompIsNotNull() {
            addCriterion("air_comp is not null");
            return (Criteria) this;
        }

        public Criteria andAirCompEqualTo(String value) {
            addCriterion("air_comp =", value, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirCompNotEqualTo(String value) {
            addCriterion("air_comp <>", value, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirCompGreaterThan(String value) {
            addCriterion("air_comp >", value, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirCompGreaterThanOrEqualTo(String value) {
            addCriterion("air_comp >=", value, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirCompLessThan(String value) {
            addCriterion("air_comp <", value, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirCompLessThanOrEqualTo(String value) {
            addCriterion("air_comp <=", value, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirCompLike(String value) {
            addCriterion("air_comp like", value, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirCompNotLike(String value) {
            addCriterion("air_comp not like", value, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirCompIn(List<String> values) {
            addCriterion("air_comp in", values, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirCompNotIn(List<String> values) {
            addCriterion("air_comp not in", values, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirCompBetween(String value1, String value2) {
            addCriterion("air_comp between", value1, value2, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirCompNotBetween(String value1, String value2) {
            addCriterion("air_comp not between", value1, value2, "airComp");
            return (Criteria) this;
        }

        public Criteria andAirNameIsNull() {
            addCriterion("air_name is null");
            return (Criteria) this;
        }

        public Criteria andAirNameIsNotNull() {
            addCriterion("air_name is not null");
            return (Criteria) this;
        }

        public Criteria andAirNameEqualTo(String value) {
            addCriterion("air_name =", value, "airName");
            return (Criteria) this;
        }

        public Criteria andAirNameNotEqualTo(String value) {
            addCriterion("air_name <>", value, "airName");
            return (Criteria) this;
        }

        public Criteria andAirNameGreaterThan(String value) {
            addCriterion("air_name >", value, "airName");
            return (Criteria) this;
        }

        public Criteria andAirNameGreaterThanOrEqualTo(String value) {
            addCriterion("air_name >=", value, "airName");
            return (Criteria) this;
        }

        public Criteria andAirNameLessThan(String value) {
            addCriterion("air_name <", value, "airName");
            return (Criteria) this;
        }

        public Criteria andAirNameLessThanOrEqualTo(String value) {
            addCriterion("air_name <=", value, "airName");
            return (Criteria) this;
        }

        public Criteria andAirNameLike(String value) {
            addCriterion("air_name like", value, "airName");
            return (Criteria) this;
        }

        public Criteria andAirNameNotLike(String value) {
            addCriterion("air_name not like", value, "airName");
            return (Criteria) this;
        }

        public Criteria andAirNameIn(List<String> values) {
            addCriterion("air_name in", values, "airName");
            return (Criteria) this;
        }

        public Criteria andAirNameNotIn(List<String> values) {
            addCriterion("air_name not in", values, "airName");
            return (Criteria) this;
        }

        public Criteria andAirNameBetween(String value1, String value2) {
            addCriterion("air_name between", value1, value2, "airName");
            return (Criteria) this;
        }

        public Criteria andAirNameNotBetween(String value1, String value2) {
            addCriterion("air_name not between", value1, value2, "airName");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(String value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(String value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(String value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(String value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(String value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLike(String value) {
            addCriterion("start_time like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotLike(String value) {
            addCriterion("start_time not like", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<String> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<String> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(String value1, String value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(String value1, String value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNull() {
            addCriterion("arrival_time is null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIsNotNull() {
            addCriterion("arrival_time is not null");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeEqualTo(String value) {
            addCriterion("arrival_time =", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotEqualTo(String value) {
            addCriterion("arrival_time <>", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThan(String value) {
            addCriterion("arrival_time >", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeGreaterThanOrEqualTo(String value) {
            addCriterion("arrival_time >=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThan(String value) {
            addCriterion("arrival_time <", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLessThanOrEqualTo(String value) {
            addCriterion("arrival_time <=", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeLike(String value) {
            addCriterion("arrival_time like", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotLike(String value) {
            addCriterion("arrival_time not like", value, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeIn(List<String> values) {
            addCriterion("arrival_time in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotIn(List<String> values) {
            addCriterion("arrival_time not in", values, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeBetween(String value1, String value2) {
            addCriterion("arrival_time between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andArrivalTimeNotBetween(String value1, String value2) {
            addCriterion("arrival_time not between", value1, value2, "arrivalTime");
            return (Criteria) this;
        }

        public Criteria andTimeLengthIsNull() {
            addCriterion("time_length is null");
            return (Criteria) this;
        }

        public Criteria andTimeLengthIsNotNull() {
            addCriterion("time_length is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLengthEqualTo(String value) {
            addCriterion("time_length =", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotEqualTo(String value) {
            addCriterion("time_length <>", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthGreaterThan(String value) {
            addCriterion("time_length >", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthGreaterThanOrEqualTo(String value) {
            addCriterion("time_length >=", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthLessThan(String value) {
            addCriterion("time_length <", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthLessThanOrEqualTo(String value) {
            addCriterion("time_length <=", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthLike(String value) {
            addCriterion("time_length like", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotLike(String value) {
            addCriterion("time_length not like", value, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthIn(List<String> values) {
            addCriterion("time_length in", values, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotIn(List<String> values) {
            addCriterion("time_length not in", values, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthBetween(String value1, String value2) {
            addCriterion("time_length between", value1, value2, "timeLength");
            return (Criteria) this;
        }

        public Criteria andTimeLengthNotBetween(String value1, String value2) {
            addCriterion("time_length not between", value1, value2, "timeLength");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(String value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(String value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(String value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(String value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(String value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(String value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLike(String value) {
            addCriterion("distance like", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotLike(String value) {
            addCriterion("distance not like", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<String> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<String> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(String value1, String value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(String value1, String value2) {
            addCriterion("distance not between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andFlightNumIsNull() {
            addCriterion("flight_num is null");
            return (Criteria) this;
        }

        public Criteria andFlightNumIsNotNull() {
            addCriterion("flight_num is not null");
            return (Criteria) this;
        }

        public Criteria andFlightNumEqualTo(String value) {
            addCriterion("flight_num =", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumNotEqualTo(String value) {
            addCriterion("flight_num <>", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumGreaterThan(String value) {
            addCriterion("flight_num >", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumGreaterThanOrEqualTo(String value) {
            addCriterion("flight_num >=", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumLessThan(String value) {
            addCriterion("flight_num <", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumLessThanOrEqualTo(String value) {
            addCriterion("flight_num <=", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumLike(String value) {
            addCriterion("flight_num like", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumNotLike(String value) {
            addCriterion("flight_num not like", value, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumIn(List<String> values) {
            addCriterion("flight_num in", values, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumNotIn(List<String> values) {
            addCriterion("flight_num not in", values, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumBetween(String value1, String value2) {
            addCriterion("flight_num between", value1, value2, "flightNum");
            return (Criteria) this;
        }

        public Criteria andFlightNumNotBetween(String value1, String value2) {
            addCriterion("flight_num not between", value1, value2, "flightNum");
            return (Criteria) this;
        }

        public Criteria andCityNamesIsNull() {
            addCriterion("city_names is null");
            return (Criteria) this;
        }

        public Criteria andCityNamesIsNotNull() {
            addCriterion("city_names is not null");
            return (Criteria) this;
        }

        public Criteria andCityNamesEqualTo(String value) {
            addCriterion("city_names =", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesNotEqualTo(String value) {
            addCriterion("city_names <>", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesGreaterThan(String value) {
            addCriterion("city_names >", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesGreaterThanOrEqualTo(String value) {
            addCriterion("city_names >=", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesLessThan(String value) {
            addCriterion("city_names <", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesLessThanOrEqualTo(String value) {
            addCriterion("city_names <=", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesLike(String value) {
            addCriterion("city_names like", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesNotLike(String value) {
            addCriterion("city_names not like", value, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesIn(List<String> values) {
            addCriterion("city_names in", values, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesNotIn(List<String> values) {
            addCriterion("city_names not in", values, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesBetween(String value1, String value2) {
            addCriterion("city_names between", value1, value2, "cityNames");
            return (Criteria) this;
        }

        public Criteria andCityNamesNotBetween(String value1, String value2) {
            addCriterion("city_names not between", value1, value2, "cityNames");
            return (Criteria) this;
        }

        public Criteria andViewpointIdIsNull() {
            addCriterion("viewpoint_id is null");
            return (Criteria) this;
        }

        public Criteria andViewpointIdIsNotNull() {
            addCriterion("viewpoint_id is not null");
            return (Criteria) this;
        }

        public Criteria andViewpointIdEqualTo(String value) {
            addCriterion("viewpoint_id =", value, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointIdNotEqualTo(String value) {
            addCriterion("viewpoint_id <>", value, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointIdGreaterThan(String value) {
            addCriterion("viewpoint_id >", value, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointIdGreaterThanOrEqualTo(String value) {
            addCriterion("viewpoint_id >=", value, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointIdLessThan(String value) {
            addCriterion("viewpoint_id <", value, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointIdLessThanOrEqualTo(String value) {
            addCriterion("viewpoint_id <=", value, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointIdLike(String value) {
            addCriterion("viewpoint_id like", value, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointIdNotLike(String value) {
            addCriterion("viewpoint_id not like", value, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointIdIn(List<String> values) {
            addCriterion("viewpoint_id in", values, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointIdNotIn(List<String> values) {
            addCriterion("viewpoint_id not in", values, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointIdBetween(String value1, String value2) {
            addCriterion("viewpoint_id between", value1, value2, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointIdNotBetween(String value1, String value2) {
            addCriterion("viewpoint_id not between", value1, value2, "viewpointId");
            return (Criteria) this;
        }

        public Criteria andViewpointNameIsNull() {
            addCriterion("viewpoint_name is null");
            return (Criteria) this;
        }

        public Criteria andViewpointNameIsNotNull() {
            addCriterion("viewpoint_name is not null");
            return (Criteria) this;
        }

        public Criteria andViewpointNameEqualTo(String value) {
            addCriterion("viewpoint_name =", value, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andViewpointNameNotEqualTo(String value) {
            addCriterion("viewpoint_name <>", value, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andViewpointNameGreaterThan(String value) {
            addCriterion("viewpoint_name >", value, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andViewpointNameGreaterThanOrEqualTo(String value) {
            addCriterion("viewpoint_name >=", value, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andViewpointNameLessThan(String value) {
            addCriterion("viewpoint_name <", value, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andViewpointNameLessThanOrEqualTo(String value) {
            addCriterion("viewpoint_name <=", value, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andViewpointNameLike(String value) {
            addCriterion("viewpoint_name like", value, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andViewpointNameNotLike(String value) {
            addCriterion("viewpoint_name not like", value, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andViewpointNameIn(List<String> values) {
            addCriterion("viewpoint_name in", values, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andViewpointNameNotIn(List<String> values) {
            addCriterion("viewpoint_name not in", values, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andViewpointNameBetween(String value1, String value2) {
            addCriterion("viewpoint_name between", value1, value2, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andViewpointNameNotBetween(String value1, String value2) {
            addCriterion("viewpoint_name not between", value1, value2, "viewpointName");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdIsNull() {
            addCriterion("daodao_id is null");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdIsNotNull() {
            addCriterion("daodao_id is not null");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdEqualTo(String value) {
            addCriterion("daodao_id =", value, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdNotEqualTo(String value) {
            addCriterion("daodao_id <>", value, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdGreaterThan(String value) {
            addCriterion("daodao_id >", value, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdGreaterThanOrEqualTo(String value) {
            addCriterion("daodao_id >=", value, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdLessThan(String value) {
            addCriterion("daodao_id <", value, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdLessThanOrEqualTo(String value) {
            addCriterion("daodao_id <=", value, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdLike(String value) {
            addCriterion("daodao_id like", value, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdNotLike(String value) {
            addCriterion("daodao_id not like", value, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdIn(List<String> values) {
            addCriterion("daodao_id in", values, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdNotIn(List<String> values) {
            addCriterion("daodao_id not in", values, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdBetween(String value1, String value2) {
            addCriterion("daodao_id between", value1, value2, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andDaodaoIdNotBetween(String value1, String value2) {
            addCriterion("daodao_id not between", value1, value2, "daodaoId");
            return (Criteria) this;
        }

        public Criteria andSordIsNull() {
            addCriterion("sord is null");
            return (Criteria) this;
        }

        public Criteria andSordIsNotNull() {
            addCriterion("sord is not null");
            return (Criteria) this;
        }

        public Criteria andSordEqualTo(String value) {
            addCriterion("sord =", value, "sord");
            return (Criteria) this;
        }

        public Criteria andSordNotEqualTo(String value) {
            addCriterion("sord <>", value, "sord");
            return (Criteria) this;
        }

        public Criteria andSordGreaterThan(String value) {
            addCriterion("sord >", value, "sord");
            return (Criteria) this;
        }

        public Criteria andSordGreaterThanOrEqualTo(String value) {
            addCriterion("sord >=", value, "sord");
            return (Criteria) this;
        }

        public Criteria andSordLessThan(String value) {
            addCriterion("sord <", value, "sord");
            return (Criteria) this;
        }

        public Criteria andSordLessThanOrEqualTo(String value) {
            addCriterion("sord <=", value, "sord");
            return (Criteria) this;
        }

        public Criteria andSordLike(String value) {
            addCriterion("sord like", value, "sord");
            return (Criteria) this;
        }

        public Criteria andSordNotLike(String value) {
            addCriterion("sord not like", value, "sord");
            return (Criteria) this;
        }

        public Criteria andSordIn(List<String> values) {
            addCriterion("sord in", values, "sord");
            return (Criteria) this;
        }

        public Criteria andSordNotIn(List<String> values) {
            addCriterion("sord not in", values, "sord");
            return (Criteria) this;
        }

        public Criteria andSordBetween(String value1, String value2) {
            addCriterion("sord between", value1, value2, "sord");
            return (Criteria) this;
        }

        public Criteria andSordNotBetween(String value1, String value2) {
            addCriterion("sord not between", value1, value2, "sord");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdIsNull() {
            addCriterion("from_daodao_id is null");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdIsNotNull() {
            addCriterion("from_daodao_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdEqualTo(String value) {
            addCriterion("from_daodao_id =", value, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdNotEqualTo(String value) {
            addCriterion("from_daodao_id <>", value, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdGreaterThan(String value) {
            addCriterion("from_daodao_id >", value, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdGreaterThanOrEqualTo(String value) {
            addCriterion("from_daodao_id >=", value, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdLessThan(String value) {
            addCriterion("from_daodao_id <", value, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdLessThanOrEqualTo(String value) {
            addCriterion("from_daodao_id <=", value, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdLike(String value) {
            addCriterion("from_daodao_id like", value, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdNotLike(String value) {
            addCriterion("from_daodao_id not like", value, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdIn(List<String> values) {
            addCriterion("from_daodao_id in", values, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdNotIn(List<String> values) {
            addCriterion("from_daodao_id not in", values, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdBetween(String value1, String value2) {
            addCriterion("from_daodao_id between", value1, value2, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoIdNotBetween(String value1, String value2) {
            addCriterion("from_daodao_id not between", value1, value2, "fromDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdIsNull() {
            addCriterion("arrive_daodao_id is null");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdIsNotNull() {
            addCriterion("arrive_daodao_id is not null");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdEqualTo(String value) {
            addCriterion("arrive_daodao_id =", value, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdNotEqualTo(String value) {
            addCriterion("arrive_daodao_id <>", value, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdGreaterThan(String value) {
            addCriterion("arrive_daodao_id >", value, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdGreaterThanOrEqualTo(String value) {
            addCriterion("arrive_daodao_id >=", value, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdLessThan(String value) {
            addCriterion("arrive_daodao_id <", value, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdLessThanOrEqualTo(String value) {
            addCriterion("arrive_daodao_id <=", value, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdLike(String value) {
            addCriterion("arrive_daodao_id like", value, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdNotLike(String value) {
            addCriterion("arrive_daodao_id not like", value, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdIn(List<String> values) {
            addCriterion("arrive_daodao_id in", values, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdNotIn(List<String> values) {
            addCriterion("arrive_daodao_id not in", values, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdBetween(String value1, String value2) {
            addCriterion("arrive_daodao_id between", value1, value2, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoIdNotBetween(String value1, String value2) {
            addCriterion("arrive_daodao_id not between", value1, value2, "arriveDaodaoId");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameIsNull() {
            addCriterion("from_daodao_name is null");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameIsNotNull() {
            addCriterion("from_daodao_name is not null");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameEqualTo(String value) {
            addCriterion("from_daodao_name =", value, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameNotEqualTo(String value) {
            addCriterion("from_daodao_name <>", value, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameGreaterThan(String value) {
            addCriterion("from_daodao_name >", value, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameGreaterThanOrEqualTo(String value) {
            addCriterion("from_daodao_name >=", value, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameLessThan(String value) {
            addCriterion("from_daodao_name <", value, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameLessThanOrEqualTo(String value) {
            addCriterion("from_daodao_name <=", value, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameLike(String value) {
            addCriterion("from_daodao_name like", value, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameNotLike(String value) {
            addCriterion("from_daodao_name not like", value, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameIn(List<String> values) {
            addCriterion("from_daodao_name in", values, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameNotIn(List<String> values) {
            addCriterion("from_daodao_name not in", values, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameBetween(String value1, String value2) {
            addCriterion("from_daodao_name between", value1, value2, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andFromDaodaoNameNotBetween(String value1, String value2) {
            addCriterion("from_daodao_name not between", value1, value2, "fromDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameIsNull() {
            addCriterion("arrive_daodao_name is null");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameIsNotNull() {
            addCriterion("arrive_daodao_name is not null");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameEqualTo(String value) {
            addCriterion("arrive_daodao_name =", value, "arriveDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameNotEqualTo(String value) {
            addCriterion("arrive_daodao_name <>", value, "arriveDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameGreaterThan(String value) {
            addCriterion("arrive_daodao_name >", value, "arriveDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameGreaterThanOrEqualTo(String value) {
            addCriterion("arrive_daodao_name >=", value, "arriveDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameLessThan(String value) {
            addCriterion("arrive_daodao_name <", value, "arriveDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameLessThanOrEqualTo(String value) {
            addCriterion("arrive_daodao_name <=", value, "arriveDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameLike(String value) {
            addCriterion("arrive_daodao_name like", value, "arriveDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameNotLike(String value) {
            addCriterion("arrive_daodao_name not like", value, "arriveDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameIn(List<String> values) {
            addCriterion("arrive_daodao_name in", values, "arriveDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameNotIn(List<String> values) {
            addCriterion("arrive_daodao_name not in", values, "arriveDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameBetween(String value1, String value2) {
            addCriterion("arrive_daodao_name between", value1, value2, "arriveDaodaoName");
            return (Criteria) this;
        }

        public Criteria andArriveDaodaoNameNotBetween(String value1, String value2) {
            addCriterion("arrive_daodao_name not between", value1, value2, "arriveDaodaoName");
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