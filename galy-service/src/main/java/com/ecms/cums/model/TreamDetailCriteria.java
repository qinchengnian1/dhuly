package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TreamDetailCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TreamDetailCriteria() {
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

        public Criteria andIIdIsNull() {
            addCriterion("i_id is null");
            return (Criteria) this;
        }

        public Criteria andIIdIsNotNull() {
            addCriterion("i_id is not null");
            return (Criteria) this;
        }

        public Criteria andIIdEqualTo(Integer value) {
            addCriterion("i_id =", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotEqualTo(Integer value) {
            addCriterion("i_id <>", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdGreaterThan(Integer value) {
            addCriterion("i_id >", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("i_id >=", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdLessThan(Integer value) {
            addCriterion("i_id <", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdLessThanOrEqualTo(Integer value) {
            addCriterion("i_id <=", value, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdIn(List<Integer> values) {
            addCriterion("i_id in", values, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotIn(List<Integer> values) {
            addCriterion("i_id not in", values, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdBetween(Integer value1, Integer value2) {
            addCriterion("i_id between", value1, value2, "iId");
            return (Criteria) this;
        }

        public Criteria andIIdNotBetween(Integer value1, Integer value2) {
            addCriterion("i_id not between", value1, value2, "iId");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNull() {
            addCriterion("is_hot is null");
            return (Criteria) this;
        }

        public Criteria andIsHotIsNotNull() {
            addCriterion("is_hot is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotEqualTo(String value) {
            addCriterion("is_hot =", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotEqualTo(String value) {
            addCriterion("is_hot <>", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThan(String value) {
            addCriterion("is_hot >", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotGreaterThanOrEqualTo(String value) {
            addCriterion("is_hot >=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThan(String value) {
            addCriterion("is_hot <", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLessThanOrEqualTo(String value) {
            addCriterion("is_hot <=", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotLike(String value) {
            addCriterion("is_hot like", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotLike(String value) {
            addCriterion("is_hot not like", value, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotIn(List<String> values) {
            addCriterion("is_hot in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotIn(List<String> values) {
            addCriterion("is_hot not in", values, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotBetween(String value1, String value2) {
            addCriterion("is_hot between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andIsHotNotBetween(String value1, String value2) {
            addCriterion("is_hot not between", value1, value2, "isHot");
            return (Criteria) this;
        }

        public Criteria andMinNumIsNull() {
            addCriterion("min_num is null");
            return (Criteria) this;
        }

        public Criteria andMinNumIsNotNull() {
            addCriterion("min_num is not null");
            return (Criteria) this;
        }

        public Criteria andMinNumEqualTo(String value) {
            addCriterion("min_num =", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotEqualTo(String value) {
            addCriterion("min_num <>", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumGreaterThan(String value) {
            addCriterion("min_num >", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumGreaterThanOrEqualTo(String value) {
            addCriterion("min_num >=", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumLessThan(String value) {
            addCriterion("min_num <", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumLessThanOrEqualTo(String value) {
            addCriterion("min_num <=", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumLike(String value) {
            addCriterion("min_num like", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotLike(String value) {
            addCriterion("min_num not like", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumIn(List<String> values) {
            addCriterion("min_num in", values, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotIn(List<String> values) {
            addCriterion("min_num not in", values, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumBetween(String value1, String value2) {
            addCriterion("min_num between", value1, value2, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotBetween(String value1, String value2) {
            addCriterion("min_num not between", value1, value2, "minNum");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("start_date is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("start_date is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(String value) {
            addCriterion("start_date =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(String value) {
            addCriterion("start_date <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(String value) {
            addCriterion("start_date >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("start_date >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(String value) {
            addCriterion("start_date <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(String value) {
            addCriterion("start_date <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLike(String value) {
            addCriterion("start_date like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotLike(String value) {
            addCriterion("start_date not like", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<String> values) {
            addCriterion("start_date in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<String> values) {
            addCriterion("start_date not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(String value1, String value2) {
            addCriterion("start_date between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(String value1, String value2) {
            addCriterion("start_date not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNull() {
            addCriterion("return_date is null");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNotNull() {
            addCriterion("return_date is not null");
            return (Criteria) this;
        }

        public Criteria andReturnDateEqualTo(String value) {
            addCriterion("return_date =", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotEqualTo(String value) {
            addCriterion("return_date <>", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThan(String value) {
            addCriterion("return_date >", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThanOrEqualTo(String value) {
            addCriterion("return_date >=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThan(String value) {
            addCriterion("return_date <", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThanOrEqualTo(String value) {
            addCriterion("return_date <=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLike(String value) {
            addCriterion("return_date like", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotLike(String value) {
            addCriterion("return_date not like", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateIn(List<String> values) {
            addCriterion("return_date in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotIn(List<String> values) {
            addCriterion("return_date not in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateBetween(String value1, String value2) {
            addCriterion("return_date between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotBetween(String value1, String value2) {
            addCriterion("return_date not between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateIsNull() {
            addCriterion("deadline_date is null");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateIsNotNull() {
            addCriterion("deadline_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateEqualTo(String value) {
            addCriterion("deadline_date =", value, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateNotEqualTo(String value) {
            addCriterion("deadline_date <>", value, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateGreaterThan(String value) {
            addCriterion("deadline_date >", value, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateGreaterThanOrEqualTo(String value) {
            addCriterion("deadline_date >=", value, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateLessThan(String value) {
            addCriterion("deadline_date <", value, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateLessThanOrEqualTo(String value) {
            addCriterion("deadline_date <=", value, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateLike(String value) {
            addCriterion("deadline_date like", value, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateNotLike(String value) {
            addCriterion("deadline_date not like", value, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateIn(List<String> values) {
            addCriterion("deadline_date in", values, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateNotIn(List<String> values) {
            addCriterion("deadline_date not in", values, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateBetween(String value1, String value2) {
            addCriterion("deadline_date between", value1, value2, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andDeadlineDateNotBetween(String value1, String value2) {
            addCriterion("deadline_date not between", value1, value2, "deadlineDate");
            return (Criteria) this;
        }

        public Criteria andAdultPriceIsNull() {
            addCriterion("adult_price is null");
            return (Criteria) this;
        }

        public Criteria andAdultPriceIsNotNull() {
            addCriterion("adult_price is not null");
            return (Criteria) this;
        }

        public Criteria andAdultPriceEqualTo(String value) {
            addCriterion("adult_price =", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceNotEqualTo(String value) {
            addCriterion("adult_price <>", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceGreaterThan(String value) {
            addCriterion("adult_price >", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceGreaterThanOrEqualTo(String value) {
            addCriterion("adult_price >=", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceLessThan(String value) {
            addCriterion("adult_price <", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceLessThanOrEqualTo(String value) {
            addCriterion("adult_price <=", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceLike(String value) {
            addCriterion("adult_price like", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceNotLike(String value) {
            addCriterion("adult_price not like", value, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceIn(List<String> values) {
            addCriterion("adult_price in", values, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceNotIn(List<String> values) {
            addCriterion("adult_price not in", values, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceBetween(String value1, String value2) {
            addCriterion("adult_price between", value1, value2, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andAdultPriceNotBetween(String value1, String value2) {
            addCriterion("adult_price not between", value1, value2, "adultPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceIsNull() {
            addCriterion("child_price is null");
            return (Criteria) this;
        }

        public Criteria andChildPriceIsNotNull() {
            addCriterion("child_price is not null");
            return (Criteria) this;
        }

        public Criteria andChildPriceEqualTo(String value) {
            addCriterion("child_price =", value, "childPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceNotEqualTo(String value) {
            addCriterion("child_price <>", value, "childPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceGreaterThan(String value) {
            addCriterion("child_price >", value, "childPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceGreaterThanOrEqualTo(String value) {
            addCriterion("child_price >=", value, "childPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceLessThan(String value) {
            addCriterion("child_price <", value, "childPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceLessThanOrEqualTo(String value) {
            addCriterion("child_price <=", value, "childPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceLike(String value) {
            addCriterion("child_price like", value, "childPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceNotLike(String value) {
            addCriterion("child_price not like", value, "childPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceIn(List<String> values) {
            addCriterion("child_price in", values, "childPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceNotIn(List<String> values) {
            addCriterion("child_price not in", values, "childPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceBetween(String value1, String value2) {
            addCriterion("child_price between", value1, value2, "childPrice");
            return (Criteria) this;
        }

        public Criteria andChildPriceNotBetween(String value1, String value2) {
            addCriterion("child_price not between", value1, value2, "childPrice");
            return (Criteria) this;
        }

        public Criteria andLeftNumIsNull() {
            addCriterion("left_num is null");
            return (Criteria) this;
        }

        public Criteria andLeftNumIsNotNull() {
            addCriterion("left_num is not null");
            return (Criteria) this;
        }

        public Criteria andLeftNumEqualTo(String value) {
            addCriterion("left_num =", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumNotEqualTo(String value) {
            addCriterion("left_num <>", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumGreaterThan(String value) {
            addCriterion("left_num >", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumGreaterThanOrEqualTo(String value) {
            addCriterion("left_num >=", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumLessThan(String value) {
            addCriterion("left_num <", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumLessThanOrEqualTo(String value) {
            addCriterion("left_num <=", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumLike(String value) {
            addCriterion("left_num like", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumNotLike(String value) {
            addCriterion("left_num not like", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumIn(List<String> values) {
            addCriterion("left_num in", values, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumNotIn(List<String> values) {
            addCriterion("left_num not in", values, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumBetween(String value1, String value2) {
            addCriterion("left_num between", value1, value2, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumNotBetween(String value1, String value2) {
            addCriterion("left_num not between", value1, value2, "leftNum");
            return (Criteria) this;
        }

        public Criteria andWeekDateIsNull() {
            addCriterion("week_date is null");
            return (Criteria) this;
        }

        public Criteria andWeekDateIsNotNull() {
            addCriterion("week_date is not null");
            return (Criteria) this;
        }

        public Criteria andWeekDateEqualTo(String value) {
            addCriterion("week_date =", value, "weekDate");
            return (Criteria) this;
        }

        public Criteria andWeekDateNotEqualTo(String value) {
            addCriterion("week_date <>", value, "weekDate");
            return (Criteria) this;
        }

        public Criteria andWeekDateGreaterThan(String value) {
            addCriterion("week_date >", value, "weekDate");
            return (Criteria) this;
        }

        public Criteria andWeekDateGreaterThanOrEqualTo(String value) {
            addCriterion("week_date >=", value, "weekDate");
            return (Criteria) this;
        }

        public Criteria andWeekDateLessThan(String value) {
            addCriterion("week_date <", value, "weekDate");
            return (Criteria) this;
        }

        public Criteria andWeekDateLessThanOrEqualTo(String value) {
            addCriterion("week_date <=", value, "weekDate");
            return (Criteria) this;
        }

        public Criteria andWeekDateLike(String value) {
            addCriterion("week_date like", value, "weekDate");
            return (Criteria) this;
        }

        public Criteria andWeekDateNotLike(String value) {
            addCriterion("week_date not like", value, "weekDate");
            return (Criteria) this;
        }

        public Criteria andWeekDateIn(List<String> values) {
            addCriterion("week_date in", values, "weekDate");
            return (Criteria) this;
        }

        public Criteria andWeekDateNotIn(List<String> values) {
            addCriterion("week_date not in", values, "weekDate");
            return (Criteria) this;
        }

        public Criteria andWeekDateBetween(String value1, String value2) {
            addCriterion("week_date between", value1, value2, "weekDate");
            return (Criteria) this;
        }

        public Criteria andWeekDateNotBetween(String value1, String value2) {
            addCriterion("week_date not between", value1, value2, "weekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateIsNull() {
            addCriterion("re_week_date is null");
            return (Criteria) this;
        }

        public Criteria andReWeekDateIsNotNull() {
            addCriterion("re_week_date is not null");
            return (Criteria) this;
        }

        public Criteria andReWeekDateEqualTo(String value) {
            addCriterion("re_week_date =", value, "reWeekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateNotEqualTo(String value) {
            addCriterion("re_week_date <>", value, "reWeekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateGreaterThan(String value) {
            addCriterion("re_week_date >", value, "reWeekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateGreaterThanOrEqualTo(String value) {
            addCriterion("re_week_date >=", value, "reWeekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateLessThan(String value) {
            addCriterion("re_week_date <", value, "reWeekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateLessThanOrEqualTo(String value) {
            addCriterion("re_week_date <=", value, "reWeekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateLike(String value) {
            addCriterion("re_week_date like", value, "reWeekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateNotLike(String value) {
            addCriterion("re_week_date not like", value, "reWeekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateIn(List<String> values) {
            addCriterion("re_week_date in", values, "reWeekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateNotIn(List<String> values) {
            addCriterion("re_week_date not in", values, "reWeekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateBetween(String value1, String value2) {
            addCriterion("re_week_date between", value1, value2, "reWeekDate");
            return (Criteria) this;
        }

        public Criteria andReWeekDateNotBetween(String value1, String value2) {
            addCriterion("re_week_date not between", value1, value2, "reWeekDate");
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

        public Criteria andCreateManIsNull() {
            addCriterion("create_man is null");
            return (Criteria) this;
        }

        public Criteria andCreateManIsNotNull() {
            addCriterion("create_man is not null");
            return (Criteria) this;
        }

        public Criteria andCreateManEqualTo(Integer value) {
            addCriterion("create_man =", value, "createMan");
            return (Criteria) this;
        }

        public Criteria andCreateManNotEqualTo(Integer value) {
            addCriterion("create_man <>", value, "createMan");
            return (Criteria) this;
        }

        public Criteria andCreateManGreaterThan(Integer value) {
            addCriterion("create_man >", value, "createMan");
            return (Criteria) this;
        }

        public Criteria andCreateManGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_man >=", value, "createMan");
            return (Criteria) this;
        }

        public Criteria andCreateManLessThan(Integer value) {
            addCriterion("create_man <", value, "createMan");
            return (Criteria) this;
        }

        public Criteria andCreateManLessThanOrEqualTo(Integer value) {
            addCriterion("create_man <=", value, "createMan");
            return (Criteria) this;
        }

        public Criteria andCreateManIn(List<Integer> values) {
            addCriterion("create_man in", values, "createMan");
            return (Criteria) this;
        }

        public Criteria andCreateManNotIn(List<Integer> values) {
            addCriterion("create_man not in", values, "createMan");
            return (Criteria) this;
        }

        public Criteria andCreateManBetween(Integer value1, Integer value2) {
            addCriterion("create_man between", value1, value2, "createMan");
            return (Criteria) this;
        }

        public Criteria andCreateManNotBetween(Integer value1, Integer value2) {
            addCriterion("create_man not between", value1, value2, "createMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManIsNull() {
            addCriterion("update_man is null");
            return (Criteria) this;
        }

        public Criteria andUpdateManIsNotNull() {
            addCriterion("update_man is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateManEqualTo(Integer value) {
            addCriterion("update_man =", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManNotEqualTo(Integer value) {
            addCriterion("update_man <>", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManGreaterThan(Integer value) {
            addCriterion("update_man >", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_man >=", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManLessThan(Integer value) {
            addCriterion("update_man <", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManLessThanOrEqualTo(Integer value) {
            addCriterion("update_man <=", value, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManIn(List<Integer> values) {
            addCriterion("update_man in", values, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManNotIn(List<Integer> values) {
            addCriterion("update_man not in", values, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManBetween(Integer value1, Integer value2) {
            addCriterion("update_man between", value1, value2, "updateMan");
            return (Criteria) this;
        }

        public Criteria andUpdateManNotBetween(Integer value1, Integer value2) {
            addCriterion("update_man not between", value1, value2, "updateMan");
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