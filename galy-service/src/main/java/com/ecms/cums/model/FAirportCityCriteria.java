package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.List;

public class FAirportCityCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FAirportCityCriteria() {
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

        public Criteria andFCIdIsNull() {
            addCriterion("f_c_id is null");
            return (Criteria) this;
        }

        public Criteria andFCIdIsNotNull() {
            addCriterion("f_c_id is not null");
            return (Criteria) this;
        }

        public Criteria andFCIdEqualTo(Integer value) {
            addCriterion("f_c_id =", value, "fCId");
            return (Criteria) this;
        }

        public Criteria andFCIdNotEqualTo(Integer value) {
            addCriterion("f_c_id <>", value, "fCId");
            return (Criteria) this;
        }

        public Criteria andFCIdGreaterThan(Integer value) {
            addCriterion("f_c_id >", value, "fCId");
            return (Criteria) this;
        }

        public Criteria andFCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_c_id >=", value, "fCId");
            return (Criteria) this;
        }

        public Criteria andFCIdLessThan(Integer value) {
            addCriterion("f_c_id <", value, "fCId");
            return (Criteria) this;
        }

        public Criteria andFCIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_c_id <=", value, "fCId");
            return (Criteria) this;
        }

        public Criteria andFCIdIn(List<Integer> values) {
            addCriterion("f_c_id in", values, "fCId");
            return (Criteria) this;
        }

        public Criteria andFCIdNotIn(List<Integer> values) {
            addCriterion("f_c_id not in", values, "fCId");
            return (Criteria) this;
        }

        public Criteria andFCIdBetween(Integer value1, Integer value2) {
            addCriterion("f_c_id between", value1, value2, "fCId");
            return (Criteria) this;
        }

        public Criteria andFCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_c_id not between", value1, value2, "fCId");
            return (Criteria) this;
        }

        public Criteria andFNationIsNull() {
            addCriterion("f_nation is null");
            return (Criteria) this;
        }

        public Criteria andFNationIsNotNull() {
            addCriterion("f_nation is not null");
            return (Criteria) this;
        }

        public Criteria andFNationEqualTo(String value) {
            addCriterion("f_nation =", value, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationNotEqualTo(String value) {
            addCriterion("f_nation <>", value, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationGreaterThan(String value) {
            addCriterion("f_nation >", value, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationGreaterThanOrEqualTo(String value) {
            addCriterion("f_nation >=", value, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationLessThan(String value) {
            addCriterion("f_nation <", value, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationLessThanOrEqualTo(String value) {
            addCriterion("f_nation <=", value, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationLike(String value) {
            addCriterion("f_nation like", value, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationNotLike(String value) {
            addCriterion("f_nation not like", value, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationIn(List<String> values) {
            addCriterion("f_nation in", values, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationNotIn(List<String> values) {
            addCriterion("f_nation not in", values, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationBetween(String value1, String value2) {
            addCriterion("f_nation between", value1, value2, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationNotBetween(String value1, String value2) {
            addCriterion("f_nation not between", value1, value2, "fNation");
            return (Criteria) this;
        }

        public Criteria andFNationNameIsNull() {
            addCriterion("f_nation_name is null");
            return (Criteria) this;
        }

        public Criteria andFNationNameIsNotNull() {
            addCriterion("f_nation_name is not null");
            return (Criteria) this;
        }

        public Criteria andFNationNameEqualTo(String value) {
            addCriterion("f_nation_name =", value, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFNationNameNotEqualTo(String value) {
            addCriterion("f_nation_name <>", value, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFNationNameGreaterThan(String value) {
            addCriterion("f_nation_name >", value, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFNationNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_nation_name >=", value, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFNationNameLessThan(String value) {
            addCriterion("f_nation_name <", value, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFNationNameLessThanOrEqualTo(String value) {
            addCriterion("f_nation_name <=", value, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFNationNameLike(String value) {
            addCriterion("f_nation_name like", value, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFNationNameNotLike(String value) {
            addCriterion("f_nation_name not like", value, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFNationNameIn(List<String> values) {
            addCriterion("f_nation_name in", values, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFNationNameNotIn(List<String> values) {
            addCriterion("f_nation_name not in", values, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFNationNameBetween(String value1, String value2) {
            addCriterion("f_nation_name between", value1, value2, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFNationNameNotBetween(String value1, String value2) {
            addCriterion("f_nation_name not between", value1, value2, "fNationName");
            return (Criteria) this;
        }

        public Criteria andFCityNameIsNull() {
            addCriterion("f_city_name is null");
            return (Criteria) this;
        }

        public Criteria andFCityNameIsNotNull() {
            addCriterion("f_city_name is not null");
            return (Criteria) this;
        }

        public Criteria andFCityNameEqualTo(String value) {
            addCriterion("f_city_name =", value, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFCityNameNotEqualTo(String value) {
            addCriterion("f_city_name <>", value, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFCityNameGreaterThan(String value) {
            addCriterion("f_city_name >", value, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_city_name >=", value, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFCityNameLessThan(String value) {
            addCriterion("f_city_name <", value, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFCityNameLessThanOrEqualTo(String value) {
            addCriterion("f_city_name <=", value, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFCityNameLike(String value) {
            addCriterion("f_city_name like", value, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFCityNameNotLike(String value) {
            addCriterion("f_city_name not like", value, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFCityNameIn(List<String> values) {
            addCriterion("f_city_name in", values, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFCityNameNotIn(List<String> values) {
            addCriterion("f_city_name not in", values, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFCityNameBetween(String value1, String value2) {
            addCriterion("f_city_name between", value1, value2, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFCityNameNotBetween(String value1, String value2) {
            addCriterion("f_city_name not between", value1, value2, "fCityName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameIsNull() {
            addCriterion("f_airport_name is null");
            return (Criteria) this;
        }

        public Criteria andFAirportNameIsNotNull() {
            addCriterion("f_airport_name is not null");
            return (Criteria) this;
        }

        public Criteria andFAirportNameEqualTo(String value) {
            addCriterion("f_airport_name =", value, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameNotEqualTo(String value) {
            addCriterion("f_airport_name <>", value, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameGreaterThan(String value) {
            addCriterion("f_airport_name >", value, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_airport_name >=", value, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameLessThan(String value) {
            addCriterion("f_airport_name <", value, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameLessThanOrEqualTo(String value) {
            addCriterion("f_airport_name <=", value, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameLike(String value) {
            addCriterion("f_airport_name like", value, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameNotLike(String value) {
            addCriterion("f_airport_name not like", value, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameIn(List<String> values) {
            addCriterion("f_airport_name in", values, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameNotIn(List<String> values) {
            addCriterion("f_airport_name not in", values, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameBetween(String value1, String value2) {
            addCriterion("f_airport_name between", value1, value2, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNameNotBetween(String value1, String value2) {
            addCriterion("f_airport_name not between", value1, value2, "fAirportName");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyIsNull() {
            addCriterion("f_airport_name_py is null");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyIsNotNull() {
            addCriterion("f_airport_name_py is not null");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyEqualTo(String value) {
            addCriterion("f_airport_name_py =", value, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyNotEqualTo(String value) {
            addCriterion("f_airport_name_py <>", value, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyGreaterThan(String value) {
            addCriterion("f_airport_name_py >", value, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyGreaterThanOrEqualTo(String value) {
            addCriterion("f_airport_name_py >=", value, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyLessThan(String value) {
            addCriterion("f_airport_name_py <", value, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyLessThanOrEqualTo(String value) {
            addCriterion("f_airport_name_py <=", value, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyLike(String value) {
            addCriterion("f_airport_name_py like", value, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyNotLike(String value) {
            addCriterion("f_airport_name_py not like", value, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyIn(List<String> values) {
            addCriterion("f_airport_name_py in", values, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyNotIn(List<String> values) {
            addCriterion("f_airport_name_py not in", values, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyBetween(String value1, String value2) {
            addCriterion("f_airport_name_py between", value1, value2, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFAirportNamePyNotBetween(String value1, String value2) {
            addCriterion("f_airport_name_py not between", value1, value2, "fAirportNamePy");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeIsNull() {
            addCriterion("f_sanzi_code is null");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeIsNotNull() {
            addCriterion("f_sanzi_code is not null");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeEqualTo(String value) {
            addCriterion("f_sanzi_code =", value, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeNotEqualTo(String value) {
            addCriterion("f_sanzi_code <>", value, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeGreaterThan(String value) {
            addCriterion("f_sanzi_code >", value, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_sanzi_code >=", value, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeLessThan(String value) {
            addCriterion("f_sanzi_code <", value, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeLessThanOrEqualTo(String value) {
            addCriterion("f_sanzi_code <=", value, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeLike(String value) {
            addCriterion("f_sanzi_code like", value, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeNotLike(String value) {
            addCriterion("f_sanzi_code not like", value, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeIn(List<String> values) {
            addCriterion("f_sanzi_code in", values, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeNotIn(List<String> values) {
            addCriterion("f_sanzi_code not in", values, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeBetween(String value1, String value2) {
            addCriterion("f_sanzi_code between", value1, value2, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCodeNotBetween(String value1, String value2) {
            addCriterion("f_sanzi_code not between", value1, value2, "fSanziCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeIsNull() {
            addCriterion("f_sanzi_city_code is null");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeIsNotNull() {
            addCriterion("f_sanzi_city_code is not null");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeEqualTo(String value) {
            addCriterion("f_sanzi_city_code =", value, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeNotEqualTo(String value) {
            addCriterion("f_sanzi_city_code <>", value, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeGreaterThan(String value) {
            addCriterion("f_sanzi_city_code >", value, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("f_sanzi_city_code >=", value, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeLessThan(String value) {
            addCriterion("f_sanzi_city_code <", value, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeLessThanOrEqualTo(String value) {
            addCriterion("f_sanzi_city_code <=", value, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeLike(String value) {
            addCriterion("f_sanzi_city_code like", value, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeNotLike(String value) {
            addCriterion("f_sanzi_city_code not like", value, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeIn(List<String> values) {
            addCriterion("f_sanzi_city_code in", values, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeNotIn(List<String> values) {
            addCriterion("f_sanzi_city_code not in", values, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeBetween(String value1, String value2) {
            addCriterion("f_sanzi_city_code between", value1, value2, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFSanziCityCodeNotBetween(String value1, String value2) {
            addCriterion("f_sanzi_city_code not between", value1, value2, "fSanziCityCode");
            return (Criteria) this;
        }

        public Criteria andFIfHotIsNull() {
            addCriterion("f_if_hot is null");
            return (Criteria) this;
        }

        public Criteria andFIfHotIsNotNull() {
            addCriterion("f_if_hot is not null");
            return (Criteria) this;
        }

        public Criteria andFIfHotEqualTo(String value) {
            addCriterion("f_if_hot =", value, "fIfHot");
            return (Criteria) this;
        }

        public Criteria andFIfHotNotEqualTo(String value) {
            addCriterion("f_if_hot <>", value, "fIfHot");
            return (Criteria) this;
        }

        public Criteria andFIfHotGreaterThan(String value) {
            addCriterion("f_if_hot >", value, "fIfHot");
            return (Criteria) this;
        }

        public Criteria andFIfHotGreaterThanOrEqualTo(String value) {
            addCriterion("f_if_hot >=", value, "fIfHot");
            return (Criteria) this;
        }

        public Criteria andFIfHotLessThan(String value) {
            addCriterion("f_if_hot <", value, "fIfHot");
            return (Criteria) this;
        }

        public Criteria andFIfHotLessThanOrEqualTo(String value) {
            addCriterion("f_if_hot <=", value, "fIfHot");
            return (Criteria) this;
        }

        public Criteria andFIfHotLike(String value) {
            addCriterion("f_if_hot like", value, "fIfHot");
            return (Criteria) this;
        }

        public Criteria andFIfHotNotLike(String value) {
            addCriterion("f_if_hot not like", value, "fIfHot");
            return (Criteria) this;
        }

        public Criteria andFIfHotIn(List<String> values) {
            addCriterion("f_if_hot in", values, "fIfHot");
            return (Criteria) this;
        }

        public Criteria andFIfHotNotIn(List<String> values) {
            addCriterion("f_if_hot not in", values, "fIfHot");
            return (Criteria) this;
        }

        public Criteria andFIfHotBetween(String value1, String value2) {
            addCriterion("f_if_hot between", value1, value2, "fIfHot");
            return (Criteria) this;
        }

        public Criteria andFIfHotNotBetween(String value1, String value2) {
            addCriterion("f_if_hot not between", value1, value2, "fIfHot");
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