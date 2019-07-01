package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.List;

public class FAirportTouristCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FAirportTouristCriteria() {
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

        public Criteria andFTouristIdIsNull() {
            addCriterion("f_tourist_id is null");
            return (Criteria) this;
        }

        public Criteria andFTouristIdIsNotNull() {
            addCriterion("f_tourist_id is not null");
            return (Criteria) this;
        }

        public Criteria andFTouristIdEqualTo(Integer value) {
            addCriterion("f_tourist_id =", value, "fTouristId");
            return (Criteria) this;
        }

        public Criteria andFTouristIdNotEqualTo(Integer value) {
            addCriterion("f_tourist_id <>", value, "fTouristId");
            return (Criteria) this;
        }

        public Criteria andFTouristIdGreaterThan(Integer value) {
            addCriterion("f_tourist_id >", value, "fTouristId");
            return (Criteria) this;
        }

        public Criteria andFTouristIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_tourist_id >=", value, "fTouristId");
            return (Criteria) this;
        }

        public Criteria andFTouristIdLessThan(Integer value) {
            addCriterion("f_tourist_id <", value, "fTouristId");
            return (Criteria) this;
        }

        public Criteria andFTouristIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_tourist_id <=", value, "fTouristId");
            return (Criteria) this;
        }

        public Criteria andFTouristIdIn(List<Integer> values) {
            addCriterion("f_tourist_id in", values, "fTouristId");
            return (Criteria) this;
        }

        public Criteria andFTouristIdNotIn(List<Integer> values) {
            addCriterion("f_tourist_id not in", values, "fTouristId");
            return (Criteria) this;
        }

        public Criteria andFTouristIdBetween(Integer value1, Integer value2) {
            addCriterion("f_tourist_id between", value1, value2, "fTouristId");
            return (Criteria) this;
        }

        public Criteria andFTouristIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_tourist_id not between", value1, value2, "fTouristId");
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

        public Criteria andFTouristNameIsNull() {
            addCriterion("f_tourist_name is null");
            return (Criteria) this;
        }

        public Criteria andFTouristNameIsNotNull() {
            addCriterion("f_tourist_name is not null");
            return (Criteria) this;
        }

        public Criteria andFTouristNameEqualTo(String value) {
            addCriterion("f_tourist_name =", value, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNameNotEqualTo(String value) {
            addCriterion("f_tourist_name <>", value, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNameGreaterThan(String value) {
            addCriterion("f_tourist_name >", value, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_tourist_name >=", value, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNameLessThan(String value) {
            addCriterion("f_tourist_name <", value, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNameLessThanOrEqualTo(String value) {
            addCriterion("f_tourist_name <=", value, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNameLike(String value) {
            addCriterion("f_tourist_name like", value, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNameNotLike(String value) {
            addCriterion("f_tourist_name not like", value, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNameIn(List<String> values) {
            addCriterion("f_tourist_name in", values, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNameNotIn(List<String> values) {
            addCriterion("f_tourist_name not in", values, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNameBetween(String value1, String value2) {
            addCriterion("f_tourist_name between", value1, value2, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNameNotBetween(String value1, String value2) {
            addCriterion("f_tourist_name not between", value1, value2, "fTouristName");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyIsNull() {
            addCriterion("f_tourist_name_py is null");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyIsNotNull() {
            addCriterion("f_tourist_name_py is not null");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyEqualTo(String value) {
            addCriterion("f_tourist_name_py =", value, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyNotEqualTo(String value) {
            addCriterion("f_tourist_name_py <>", value, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyGreaterThan(String value) {
            addCriterion("f_tourist_name_py >", value, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyGreaterThanOrEqualTo(String value) {
            addCriterion("f_tourist_name_py >=", value, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyLessThan(String value) {
            addCriterion("f_tourist_name_py <", value, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyLessThanOrEqualTo(String value) {
            addCriterion("f_tourist_name_py <=", value, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyLike(String value) {
            addCriterion("f_tourist_name_py like", value, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyNotLike(String value) {
            addCriterion("f_tourist_name_py not like", value, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyIn(List<String> values) {
            addCriterion("f_tourist_name_py in", values, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyNotIn(List<String> values) {
            addCriterion("f_tourist_name_py not in", values, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyBetween(String value1, String value2) {
            addCriterion("f_tourist_name_py between", value1, value2, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFTouristNamePyNotBetween(String value1, String value2) {
            addCriterion("f_tourist_name_py not between", value1, value2, "fTouristNamePy");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeIsNull() {
            addCriterion("f_age_type is null");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeIsNotNull() {
            addCriterion("f_age_type is not null");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeEqualTo(String value) {
            addCriterion("f_age_type =", value, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeNotEqualTo(String value) {
            addCriterion("f_age_type <>", value, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeGreaterThan(String value) {
            addCriterion("f_age_type >", value, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_age_type >=", value, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeLessThan(String value) {
            addCriterion("f_age_type <", value, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeLessThanOrEqualTo(String value) {
            addCriterion("f_age_type <=", value, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeLike(String value) {
            addCriterion("f_age_type like", value, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeNotLike(String value) {
            addCriterion("f_age_type not like", value, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeIn(List<String> values) {
            addCriterion("f_age_type in", values, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeNotIn(List<String> values) {
            addCriterion("f_age_type not in", values, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeBetween(String value1, String value2) {
            addCriterion("f_age_type between", value1, value2, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFAgeTypeNotBetween(String value1, String value2) {
            addCriterion("f_age_type not between", value1, value2, "fAgeType");
            return (Criteria) this;
        }

        public Criteria andFTelephoneIsNull() {
            addCriterion("f_telephone is null");
            return (Criteria) this;
        }

        public Criteria andFTelephoneIsNotNull() {
            addCriterion("f_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andFTelephoneEqualTo(String value) {
            addCriterion("f_telephone =", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNotEqualTo(String value) {
            addCriterion("f_telephone <>", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneGreaterThan(String value) {
            addCriterion("f_telephone >", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("f_telephone >=", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneLessThan(String value) {
            addCriterion("f_telephone <", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneLessThanOrEqualTo(String value) {
            addCriterion("f_telephone <=", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneLike(String value) {
            addCriterion("f_telephone like", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNotLike(String value) {
            addCriterion("f_telephone not like", value, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneIn(List<String> values) {
            addCriterion("f_telephone in", values, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNotIn(List<String> values) {
            addCriterion("f_telephone not in", values, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneBetween(String value1, String value2) {
            addCriterion("f_telephone between", value1, value2, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFTelephoneNotBetween(String value1, String value2) {
            addCriterion("f_telephone not between", value1, value2, "fTelephone");
            return (Criteria) this;
        }

        public Criteria andFBirthdayIsNull() {
            addCriterion("f_birthday is null");
            return (Criteria) this;
        }

        public Criteria andFBirthdayIsNotNull() {
            addCriterion("f_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andFBirthdayEqualTo(String value) {
            addCriterion("f_birthday =", value, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andFBirthdayNotEqualTo(String value) {
            addCriterion("f_birthday <>", value, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andFBirthdayGreaterThan(String value) {
            addCriterion("f_birthday >", value, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andFBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("f_birthday >=", value, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andFBirthdayLessThan(String value) {
            addCriterion("f_birthday <", value, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andFBirthdayLessThanOrEqualTo(String value) {
            addCriterion("f_birthday <=", value, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andFBirthdayLike(String value) {
            addCriterion("f_birthday like", value, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andFBirthdayNotLike(String value) {
            addCriterion("f_birthday not like", value, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andFBirthdayIn(List<String> values) {
            addCriterion("f_birthday in", values, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andFBirthdayNotIn(List<String> values) {
            addCriterion("f_birthday not in", values, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andFBirthdayBetween(String value1, String value2) {
            addCriterion("f_birthday between", value1, value2, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andFBirthdayNotBetween(String value1, String value2) {
            addCriterion("f_birthday not between", value1, value2, "fBirthday");
            return (Criteria) this;
        }

        public Criteria andCardNumIsNull() {
            addCriterion("card_num is null");
            return (Criteria) this;
        }

        public Criteria andCardNumIsNotNull() {
            addCriterion("card_num is not null");
            return (Criteria) this;
        }

        public Criteria andCardNumEqualTo(String value) {
            addCriterion("card_num =", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotEqualTo(String value) {
            addCriterion("card_num <>", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThan(String value) {
            addCriterion("card_num >", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumGreaterThanOrEqualTo(String value) {
            addCriterion("card_num >=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThan(String value) {
            addCriterion("card_num <", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLessThanOrEqualTo(String value) {
            addCriterion("card_num <=", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumLike(String value) {
            addCriterion("card_num like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotLike(String value) {
            addCriterion("card_num not like", value, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumIn(List<String> values) {
            addCriterion("card_num in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotIn(List<String> values) {
            addCriterion("card_num not in", values, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumBetween(String value1, String value2) {
            addCriterion("card_num between", value1, value2, "cardNum");
            return (Criteria) this;
        }

        public Criteria andCardNumNotBetween(String value1, String value2) {
            addCriterion("card_num not between", value1, value2, "cardNum");
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