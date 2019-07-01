package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TouristCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TouristCriteria() {
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

        public Criteria andTouristIdIsNull() {
            addCriterion("tourist_id is null");
            return (Criteria) this;
        }

        public Criteria andTouristIdIsNotNull() {
            addCriterion("tourist_id is not null");
            return (Criteria) this;
        }

        public Criteria andTouristIdEqualTo(Integer value) {
            addCriterion("tourist_id =", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdNotEqualTo(Integer value) {
            addCriterion("tourist_id <>", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdGreaterThan(Integer value) {
            addCriterion("tourist_id >", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tourist_id >=", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdLessThan(Integer value) {
            addCriterion("tourist_id <", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdLessThanOrEqualTo(Integer value) {
            addCriterion("tourist_id <=", value, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdIn(List<Integer> values) {
            addCriterion("tourist_id in", values, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdNotIn(List<Integer> values) {
            addCriterion("tourist_id not in", values, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdBetween(Integer value1, Integer value2) {
            addCriterion("tourist_id between", value1, value2, "touristId");
            return (Criteria) this;
        }

        public Criteria andTouristIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tourist_id not between", value1, value2, "touristId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTouristNameIsNull() {
            addCriterion("tourist_name is null");
            return (Criteria) this;
        }

        public Criteria andTouristNameIsNotNull() {
            addCriterion("tourist_name is not null");
            return (Criteria) this;
        }

        public Criteria andTouristNameEqualTo(String value) {
            addCriterion("tourist_name =", value, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNameNotEqualTo(String value) {
            addCriterion("tourist_name <>", value, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNameGreaterThan(String value) {
            addCriterion("tourist_name >", value, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNameGreaterThanOrEqualTo(String value) {
            addCriterion("tourist_name >=", value, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNameLessThan(String value) {
            addCriterion("tourist_name <", value, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNameLessThanOrEqualTo(String value) {
            addCriterion("tourist_name <=", value, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNameLike(String value) {
            addCriterion("tourist_name like", value, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNameNotLike(String value) {
            addCriterion("tourist_name not like", value, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNameIn(List<String> values) {
            addCriterion("tourist_name in", values, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNameNotIn(List<String> values) {
            addCriterion("tourist_name not in", values, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNameBetween(String value1, String value2) {
            addCriterion("tourist_name between", value1, value2, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNameNotBetween(String value1, String value2) {
            addCriterion("tourist_name not between", value1, value2, "touristName");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyIsNull() {
            addCriterion("tourist_name_py is null");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyIsNotNull() {
            addCriterion("tourist_name_py is not null");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyEqualTo(String value) {
            addCriterion("tourist_name_py =", value, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyNotEqualTo(String value) {
            addCriterion("tourist_name_py <>", value, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyGreaterThan(String value) {
            addCriterion("tourist_name_py >", value, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyGreaterThanOrEqualTo(String value) {
            addCriterion("tourist_name_py >=", value, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyLessThan(String value) {
            addCriterion("tourist_name_py <", value, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyLessThanOrEqualTo(String value) {
            addCriterion("tourist_name_py <=", value, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyLike(String value) {
            addCriterion("tourist_name_py like", value, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyNotLike(String value) {
            addCriterion("tourist_name_py not like", value, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyIn(List<String> values) {
            addCriterion("tourist_name_py in", values, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyNotIn(List<String> values) {
            addCriterion("tourist_name_py not in", values, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyBetween(String value1, String value2) {
            addCriterion("tourist_name_py between", value1, value2, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andTouristNamePyNotBetween(String value1, String value2) {
            addCriterion("tourist_name_py not between", value1, value2, "touristNamePy");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayIsNull() {
            addCriterion("rourist_birthday is null");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayIsNotNull() {
            addCriterion("rourist_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayEqualTo(String value) {
            addCriterion("rourist_birthday =", value, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayNotEqualTo(String value) {
            addCriterion("rourist_birthday <>", value, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayGreaterThan(String value) {
            addCriterion("rourist_birthday >", value, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("rourist_birthday >=", value, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayLessThan(String value) {
            addCriterion("rourist_birthday <", value, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayLessThanOrEqualTo(String value) {
            addCriterion("rourist_birthday <=", value, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayLike(String value) {
            addCriterion("rourist_birthday like", value, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayNotLike(String value) {
            addCriterion("rourist_birthday not like", value, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayIn(List<String> values) {
            addCriterion("rourist_birthday in", values, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayNotIn(List<String> values) {
            addCriterion("rourist_birthday not in", values, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayBetween(String value1, String value2) {
            addCriterion("rourist_birthday between", value1, value2, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristBirthdayNotBetween(String value1, String value2) {
            addCriterion("rourist_birthday not between", value1, value2, "rouristBirthday");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceIsNull() {
            addCriterion("rourist_reg_place is null");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceIsNotNull() {
            addCriterion("rourist_reg_place is not null");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceEqualTo(String value) {
            addCriterion("rourist_reg_place =", value, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceNotEqualTo(String value) {
            addCriterion("rourist_reg_place <>", value, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceGreaterThan(String value) {
            addCriterion("rourist_reg_place >", value, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("rourist_reg_place >=", value, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceLessThan(String value) {
            addCriterion("rourist_reg_place <", value, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceLessThanOrEqualTo(String value) {
            addCriterion("rourist_reg_place <=", value, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceLike(String value) {
            addCriterion("rourist_reg_place like", value, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceNotLike(String value) {
            addCriterion("rourist_reg_place not like", value, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceIn(List<String> values) {
            addCriterion("rourist_reg_place in", values, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceNotIn(List<String> values) {
            addCriterion("rourist_reg_place not in", values, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceBetween(String value1, String value2) {
            addCriterion("rourist_reg_place between", value1, value2, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andRouristRegPlaceNotBetween(String value1, String value2) {
            addCriterion("rourist_reg_place not between", value1, value2, "rouristRegPlace");
            return (Criteria) this;
        }

        public Criteria andTouristEmailIsNull() {
            addCriterion("tourist_email is null");
            return (Criteria) this;
        }

        public Criteria andTouristEmailIsNotNull() {
            addCriterion("tourist_email is not null");
            return (Criteria) this;
        }

        public Criteria andTouristEmailEqualTo(String value) {
            addCriterion("tourist_email =", value, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristEmailNotEqualTo(String value) {
            addCriterion("tourist_email <>", value, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristEmailGreaterThan(String value) {
            addCriterion("tourist_email >", value, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristEmailGreaterThanOrEqualTo(String value) {
            addCriterion("tourist_email >=", value, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristEmailLessThan(String value) {
            addCriterion("tourist_email <", value, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristEmailLessThanOrEqualTo(String value) {
            addCriterion("tourist_email <=", value, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristEmailLike(String value) {
            addCriterion("tourist_email like", value, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristEmailNotLike(String value) {
            addCriterion("tourist_email not like", value, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristEmailIn(List<String> values) {
            addCriterion("tourist_email in", values, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristEmailNotIn(List<String> values) {
            addCriterion("tourist_email not in", values, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristEmailBetween(String value1, String value2) {
            addCriterion("tourist_email between", value1, value2, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristEmailNotBetween(String value1, String value2) {
            addCriterion("tourist_email not between", value1, value2, "touristEmail");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdIsNull() {
            addCriterion("tourist_nation_id is null");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdIsNotNull() {
            addCriterion("tourist_nation_id is not null");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdEqualTo(String value) {
            addCriterion("tourist_nation_id =", value, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdNotEqualTo(String value) {
            addCriterion("tourist_nation_id <>", value, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdGreaterThan(String value) {
            addCriterion("tourist_nation_id >", value, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdGreaterThanOrEqualTo(String value) {
            addCriterion("tourist_nation_id >=", value, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdLessThan(String value) {
            addCriterion("tourist_nation_id <", value, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdLessThanOrEqualTo(String value) {
            addCriterion("tourist_nation_id <=", value, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdLike(String value) {
            addCriterion("tourist_nation_id like", value, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdNotLike(String value) {
            addCriterion("tourist_nation_id not like", value, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdIn(List<String> values) {
            addCriterion("tourist_nation_id in", values, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdNotIn(List<String> values) {
            addCriterion("tourist_nation_id not in", values, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdBetween(String value1, String value2) {
            addCriterion("tourist_nation_id between", value1, value2, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andTouristNationIdNotBetween(String value1, String value2) {
            addCriterion("tourist_nation_id not between", value1, value2, "touristNationId");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("card_type like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("card_type not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("card_no in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("card_no not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andPasgTypeIsNull() {
            addCriterion("pasg_type is null");
            return (Criteria) this;
        }

        public Criteria andPasgTypeIsNotNull() {
            addCriterion("pasg_type is not null");
            return (Criteria) this;
        }

        public Criteria andPasgTypeEqualTo(String value) {
            addCriterion("pasg_type =", value, "pasgType");
            return (Criteria) this;
        }

        public Criteria andPasgTypeNotEqualTo(String value) {
            addCriterion("pasg_type <>", value, "pasgType");
            return (Criteria) this;
        }

        public Criteria andPasgTypeGreaterThan(String value) {
            addCriterion("pasg_type >", value, "pasgType");
            return (Criteria) this;
        }

        public Criteria andPasgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pasg_type >=", value, "pasgType");
            return (Criteria) this;
        }

        public Criteria andPasgTypeLessThan(String value) {
            addCriterion("pasg_type <", value, "pasgType");
            return (Criteria) this;
        }

        public Criteria andPasgTypeLessThanOrEqualTo(String value) {
            addCriterion("pasg_type <=", value, "pasgType");
            return (Criteria) this;
        }

        public Criteria andPasgTypeLike(String value) {
            addCriterion("pasg_type like", value, "pasgType");
            return (Criteria) this;
        }

        public Criteria andPasgTypeNotLike(String value) {
            addCriterion("pasg_type not like", value, "pasgType");
            return (Criteria) this;
        }

        public Criteria andPasgTypeIn(List<String> values) {
            addCriterion("pasg_type in", values, "pasgType");
            return (Criteria) this;
        }

        public Criteria andPasgTypeNotIn(List<String> values) {
            addCriterion("pasg_type not in", values, "pasgType");
            return (Criteria) this;
        }

        public Criteria andPasgTypeBetween(String value1, String value2) {
            addCriterion("pasg_type between", value1, value2, "pasgType");
            return (Criteria) this;
        }

        public Criteria andPasgTypeNotBetween(String value1, String value2) {
            addCriterion("pasg_type not between", value1, value2, "pasgType");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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

        public Criteria andUpdatTimeIsNull() {
            addCriterion("updat_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatTimeIsNotNull() {
            addCriterion("updat_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatTimeEqualTo(Date value) {
            addCriterion("updat_time =", value, "updatTime");
            return (Criteria) this;
        }

        public Criteria andUpdatTimeNotEqualTo(Date value) {
            addCriterion("updat_time <>", value, "updatTime");
            return (Criteria) this;
        }

        public Criteria andUpdatTimeGreaterThan(Date value) {
            addCriterion("updat_time >", value, "updatTime");
            return (Criteria) this;
        }

        public Criteria andUpdatTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updat_time >=", value, "updatTime");
            return (Criteria) this;
        }

        public Criteria andUpdatTimeLessThan(Date value) {
            addCriterion("updat_time <", value, "updatTime");
            return (Criteria) this;
        }

        public Criteria andUpdatTimeLessThanOrEqualTo(Date value) {
            addCriterion("updat_time <=", value, "updatTime");
            return (Criteria) this;
        }

        public Criteria andUpdatTimeIn(List<Date> values) {
            addCriterion("updat_time in", values, "updatTime");
            return (Criteria) this;
        }

        public Criteria andUpdatTimeNotIn(List<Date> values) {
            addCriterion("updat_time not in", values, "updatTime");
            return (Criteria) this;
        }

        public Criteria andUpdatTimeBetween(Date value1, Date value2) {
            addCriterion("updat_time between", value1, value2, "updatTime");
            return (Criteria) this;
        }

        public Criteria andUpdatTimeNotBetween(Date value1, Date value2) {
            addCriterion("updat_time not between", value1, value2, "updatTime");
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