package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FAirportOrderInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FAirportOrderInfoCriteria() {
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

        public Criteria andFOiIdIsNull() {
            addCriterion("f_oi_id is null");
            return (Criteria) this;
        }

        public Criteria andFOiIdIsNotNull() {
            addCriterion("f_oi_id is not null");
            return (Criteria) this;
        }

        public Criteria andFOiIdEqualTo(Integer value) {
            addCriterion("f_oi_id =", value, "fOiId");
            return (Criteria) this;
        }

        public Criteria andFOiIdNotEqualTo(Integer value) {
            addCriterion("f_oi_id <>", value, "fOiId");
            return (Criteria) this;
        }

        public Criteria andFOiIdGreaterThan(Integer value) {
            addCriterion("f_oi_id >", value, "fOiId");
            return (Criteria) this;
        }

        public Criteria andFOiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_oi_id >=", value, "fOiId");
            return (Criteria) this;
        }

        public Criteria andFOiIdLessThan(Integer value) {
            addCriterion("f_oi_id <", value, "fOiId");
            return (Criteria) this;
        }

        public Criteria andFOiIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_oi_id <=", value, "fOiId");
            return (Criteria) this;
        }

        public Criteria andFOiIdIn(List<Integer> values) {
            addCriterion("f_oi_id in", values, "fOiId");
            return (Criteria) this;
        }

        public Criteria andFOiIdNotIn(List<Integer> values) {
            addCriterion("f_oi_id not in", values, "fOiId");
            return (Criteria) this;
        }

        public Criteria andFOiIdBetween(Integer value1, Integer value2) {
            addCriterion("f_oi_id between", value1, value2, "fOiId");
            return (Criteria) this;
        }

        public Criteria andFOiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_oi_id not between", value1, value2, "fOiId");
            return (Criteria) this;
        }

        public Criteria andFOrderIdIsNull() {
            addCriterion("f_order_id is null");
            return (Criteria) this;
        }

        public Criteria andFOrderIdIsNotNull() {
            addCriterion("f_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andFOrderIdEqualTo(Integer value) {
            addCriterion("f_order_id =", value, "fOrderId");
            return (Criteria) this;
        }

        public Criteria andFOrderIdNotEqualTo(Integer value) {
            addCriterion("f_order_id <>", value, "fOrderId");
            return (Criteria) this;
        }

        public Criteria andFOrderIdGreaterThan(Integer value) {
            addCriterion("f_order_id >", value, "fOrderId");
            return (Criteria) this;
        }

        public Criteria andFOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_order_id >=", value, "fOrderId");
            return (Criteria) this;
        }

        public Criteria andFOrderIdLessThan(Integer value) {
            addCriterion("f_order_id <", value, "fOrderId");
            return (Criteria) this;
        }

        public Criteria andFOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_order_id <=", value, "fOrderId");
            return (Criteria) this;
        }

        public Criteria andFOrderIdIn(List<Integer> values) {
            addCriterion("f_order_id in", values, "fOrderId");
            return (Criteria) this;
        }

        public Criteria andFOrderIdNotIn(List<Integer> values) {
            addCriterion("f_order_id not in", values, "fOrderId");
            return (Criteria) this;
        }

        public Criteria andFOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("f_order_id between", value1, value2, "fOrderId");
            return (Criteria) this;
        }

        public Criteria andFOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_order_id not between", value1, value2, "fOrderId");
            return (Criteria) this;
        }

        public Criteria andFPerNameIsNull() {
            addCriterion("f_per_name is null");
            return (Criteria) this;
        }

        public Criteria andFPerNameIsNotNull() {
            addCriterion("f_per_name is not null");
            return (Criteria) this;
        }

        public Criteria andFPerNameEqualTo(String value) {
            addCriterion("f_per_name =", value, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerNameNotEqualTo(String value) {
            addCriterion("f_per_name <>", value, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerNameGreaterThan(String value) {
            addCriterion("f_per_name >", value, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_per_name >=", value, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerNameLessThan(String value) {
            addCriterion("f_per_name <", value, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerNameLessThanOrEqualTo(String value) {
            addCriterion("f_per_name <=", value, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerNameLike(String value) {
            addCriterion("f_per_name like", value, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerNameNotLike(String value) {
            addCriterion("f_per_name not like", value, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerNameIn(List<String> values) {
            addCriterion("f_per_name in", values, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerNameNotIn(List<String> values) {
            addCriterion("f_per_name not in", values, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerNameBetween(String value1, String value2) {
            addCriterion("f_per_name between", value1, value2, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerNameNotBetween(String value1, String value2) {
            addCriterion("f_per_name not between", value1, value2, "fPerName");
            return (Criteria) this;
        }

        public Criteria andFPerTelIsNull() {
            addCriterion("f_per_tel is null");
            return (Criteria) this;
        }

        public Criteria andFPerTelIsNotNull() {
            addCriterion("f_per_tel is not null");
            return (Criteria) this;
        }

        public Criteria andFPerTelEqualTo(String value) {
            addCriterion("f_per_tel =", value, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFPerTelNotEqualTo(String value) {
            addCriterion("f_per_tel <>", value, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFPerTelGreaterThan(String value) {
            addCriterion("f_per_tel >", value, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFPerTelGreaterThanOrEqualTo(String value) {
            addCriterion("f_per_tel >=", value, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFPerTelLessThan(String value) {
            addCriterion("f_per_tel <", value, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFPerTelLessThanOrEqualTo(String value) {
            addCriterion("f_per_tel <=", value, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFPerTelLike(String value) {
            addCriterion("f_per_tel like", value, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFPerTelNotLike(String value) {
            addCriterion("f_per_tel not like", value, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFPerTelIn(List<String> values) {
            addCriterion("f_per_tel in", values, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFPerTelNotIn(List<String> values) {
            addCriterion("f_per_tel not in", values, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFPerTelBetween(String value1, String value2) {
            addCriterion("f_per_tel between", value1, value2, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFPerTelNotBetween(String value1, String value2) {
            addCriterion("f_per_tel not between", value1, value2, "fPerTel");
            return (Criteria) this;
        }

        public Criteria andFromToCityIsNull() {
            addCriterion("from_to_city is null");
            return (Criteria) this;
        }

        public Criteria andFromToCityIsNotNull() {
            addCriterion("from_to_city is not null");
            return (Criteria) this;
        }

        public Criteria andFromToCityEqualTo(String value) {
            addCriterion("from_to_city =", value, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andFromToCityNotEqualTo(String value) {
            addCriterion("from_to_city <>", value, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andFromToCityGreaterThan(String value) {
            addCriterion("from_to_city >", value, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andFromToCityGreaterThanOrEqualTo(String value) {
            addCriterion("from_to_city >=", value, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andFromToCityLessThan(String value) {
            addCriterion("from_to_city <", value, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andFromToCityLessThanOrEqualTo(String value) {
            addCriterion("from_to_city <=", value, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andFromToCityLike(String value) {
            addCriterion("from_to_city like", value, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andFromToCityNotLike(String value) {
            addCriterion("from_to_city not like", value, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andFromToCityIn(List<String> values) {
            addCriterion("from_to_city in", values, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andFromToCityNotIn(List<String> values) {
            addCriterion("from_to_city not in", values, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andFromToCityBetween(String value1, String value2) {
            addCriterion("from_to_city between", value1, value2, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andFromToCityNotBetween(String value1, String value2) {
            addCriterion("from_to_city not between", value1, value2, "fromToCity");
            return (Criteria) this;
        }

        public Criteria andAirportNameIsNull() {
            addCriterion("airport_name is null");
            return (Criteria) this;
        }

        public Criteria andAirportNameIsNotNull() {
            addCriterion("airport_name is not null");
            return (Criteria) this;
        }

        public Criteria andAirportNameEqualTo(String value) {
            addCriterion("airport_name =", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameNotEqualTo(String value) {
            addCriterion("airport_name <>", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameGreaterThan(String value) {
            addCriterion("airport_name >", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameGreaterThanOrEqualTo(String value) {
            addCriterion("airport_name >=", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameLessThan(String value) {
            addCriterion("airport_name <", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameLessThanOrEqualTo(String value) {
            addCriterion("airport_name <=", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameLike(String value) {
            addCriterion("airport_name like", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameNotLike(String value) {
            addCriterion("airport_name not like", value, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameIn(List<String> values) {
            addCriterion("airport_name in", values, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameNotIn(List<String> values) {
            addCriterion("airport_name not in", values, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameBetween(String value1, String value2) {
            addCriterion("airport_name between", value1, value2, "airportName");
            return (Criteria) this;
        }

        public Criteria andAirportNameNotBetween(String value1, String value2) {
            addCriterion("airport_name not between", value1, value2, "airportName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameIsNull() {
            addCriterion("aircraft_name is null");
            return (Criteria) this;
        }

        public Criteria andAircraftNameIsNotNull() {
            addCriterion("aircraft_name is not null");
            return (Criteria) this;
        }

        public Criteria andAircraftNameEqualTo(String value) {
            addCriterion("aircraft_name =", value, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameNotEqualTo(String value) {
            addCriterion("aircraft_name <>", value, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameGreaterThan(String value) {
            addCriterion("aircraft_name >", value, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameGreaterThanOrEqualTo(String value) {
            addCriterion("aircraft_name >=", value, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameLessThan(String value) {
            addCriterion("aircraft_name <", value, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameLessThanOrEqualTo(String value) {
            addCriterion("aircraft_name <=", value, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameLike(String value) {
            addCriterion("aircraft_name like", value, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameNotLike(String value) {
            addCriterion("aircraft_name not like", value, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameIn(List<String> values) {
            addCriterion("aircraft_name in", values, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameNotIn(List<String> values) {
            addCriterion("aircraft_name not in", values, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameBetween(String value1, String value2) {
            addCriterion("aircraft_name between", value1, value2, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andAircraftNameNotBetween(String value1, String value2) {
            addCriterion("aircraft_name not between", value1, value2, "aircraftName");
            return (Criteria) this;
        }

        public Criteria andFromToTimeIsNull() {
            addCriterion("from_to_time is null");
            return (Criteria) this;
        }

        public Criteria andFromToTimeIsNotNull() {
            addCriterion("from_to_time is not null");
            return (Criteria) this;
        }

        public Criteria andFromToTimeEqualTo(String value) {
            addCriterion("from_to_time =", value, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andFromToTimeNotEqualTo(String value) {
            addCriterion("from_to_time <>", value, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andFromToTimeGreaterThan(String value) {
            addCriterion("from_to_time >", value, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andFromToTimeGreaterThanOrEqualTo(String value) {
            addCriterion("from_to_time >=", value, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andFromToTimeLessThan(String value) {
            addCriterion("from_to_time <", value, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andFromToTimeLessThanOrEqualTo(String value) {
            addCriterion("from_to_time <=", value, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andFromToTimeLike(String value) {
            addCriterion("from_to_time like", value, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andFromToTimeNotLike(String value) {
            addCriterion("from_to_time not like", value, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andFromToTimeIn(List<String> values) {
            addCriterion("from_to_time in", values, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andFromToTimeNotIn(List<String> values) {
            addCriterion("from_to_time not in", values, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andFromToTimeBetween(String value1, String value2) {
            addCriterion("from_to_time between", value1, value2, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andFromToTimeNotBetween(String value1, String value2) {
            addCriterion("from_to_time not between", value1, value2, "fromToTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeIsNull() {
            addCriterion("airport_time is null");
            return (Criteria) this;
        }

        public Criteria andAirportTimeIsNotNull() {
            addCriterion("airport_time is not null");
            return (Criteria) this;
        }

        public Criteria andAirportTimeEqualTo(String value) {
            addCriterion("airport_time =", value, "airportTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeNotEqualTo(String value) {
            addCriterion("airport_time <>", value, "airportTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeGreaterThan(String value) {
            addCriterion("airport_time >", value, "airportTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeGreaterThanOrEqualTo(String value) {
            addCriterion("airport_time >=", value, "airportTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeLessThan(String value) {
            addCriterion("airport_time <", value, "airportTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeLessThanOrEqualTo(String value) {
            addCriterion("airport_time <=", value, "airportTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeLike(String value) {
            addCriterion("airport_time like", value, "airportTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeNotLike(String value) {
            addCriterion("airport_time not like", value, "airportTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeIn(List<String> values) {
            addCriterion("airport_time in", values, "airportTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeNotIn(List<String> values) {
            addCriterion("airport_time not in", values, "airportTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeBetween(String value1, String value2) {
            addCriterion("airport_time between", value1, value2, "airportTime");
            return (Criteria) this;
        }

        public Criteria andAirportTimeNotBetween(String value1, String value2) {
            addCriterion("airport_time not between", value1, value2, "airportTime");
            return (Criteria) this;
        }

        public Criteria andFStoreIdIsNull() {
            addCriterion("f_store_id is null");
            return (Criteria) this;
        }

        public Criteria andFStoreIdIsNotNull() {
            addCriterion("f_store_id is not null");
            return (Criteria) this;
        }

        public Criteria andFStoreIdEqualTo(String value) {
            addCriterion("f_store_id =", value, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andFStoreIdNotEqualTo(String value) {
            addCriterion("f_store_id <>", value, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andFStoreIdGreaterThan(String value) {
            addCriterion("f_store_id >", value, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andFStoreIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_store_id >=", value, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andFStoreIdLessThan(String value) {
            addCriterion("f_store_id <", value, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andFStoreIdLessThanOrEqualTo(String value) {
            addCriterion("f_store_id <=", value, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andFStoreIdLike(String value) {
            addCriterion("f_store_id like", value, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andFStoreIdNotLike(String value) {
            addCriterion("f_store_id not like", value, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andFStoreIdIn(List<String> values) {
            addCriterion("f_store_id in", values, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andFStoreIdNotIn(List<String> values) {
            addCriterion("f_store_id not in", values, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andFStoreIdBetween(String value1, String value2) {
            addCriterion("f_store_id between", value1, value2, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andFStoreIdNotBetween(String value1, String value2) {
            addCriterion("f_store_id not between", value1, value2, "fStoreId");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNull() {
            addCriterion("store_type is null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIsNotNull() {
            addCriterion("store_type is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTypeEqualTo(String value) {
            addCriterion("store_type =", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotEqualTo(String value) {
            addCriterion("store_type <>", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThan(String value) {
            addCriterion("store_type >", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeGreaterThanOrEqualTo(String value) {
            addCriterion("store_type >=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThan(String value) {
            addCriterion("store_type <", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLessThanOrEqualTo(String value) {
            addCriterion("store_type <=", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeLike(String value) {
            addCriterion("store_type like", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotLike(String value) {
            addCriterion("store_type not like", value, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeIn(List<String> values) {
            addCriterion("store_type in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotIn(List<String> values) {
            addCriterion("store_type not in", values, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeBetween(String value1, String value2) {
            addCriterion("store_type between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andStoreTypeNotBetween(String value1, String value2) {
            addCriterion("store_type not between", value1, value2, "storeType");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNull() {
            addCriterion("coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCouponIdIsNotNull() {
            addCriterion("coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCouponIdEqualTo(String value) {
            addCriterion("coupon_id =", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotEqualTo(String value) {
            addCriterion("coupon_id <>", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThan(String value) {
            addCriterion("coupon_id >", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_id >=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThan(String value) {
            addCriterion("coupon_id <", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLessThanOrEqualTo(String value) {
            addCriterion("coupon_id <=", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdLike(String value) {
            addCriterion("coupon_id like", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotLike(String value) {
            addCriterion("coupon_id not like", value, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdIn(List<String> values) {
            addCriterion("coupon_id in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotIn(List<String> values) {
            addCriterion("coupon_id not in", values, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdBetween(String value1, String value2) {
            addCriterion("coupon_id between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andCouponIdNotBetween(String value1, String value2) {
            addCriterion("coupon_id not between", value1, value2, "couponId");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
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

        public Criteria andAdultTaxIsNull() {
            addCriterion("adult_tax is null");
            return (Criteria) this;
        }

        public Criteria andAdultTaxIsNotNull() {
            addCriterion("adult_tax is not null");
            return (Criteria) this;
        }

        public Criteria andAdultTaxEqualTo(String value) {
            addCriterion("adult_tax =", value, "adultTax");
            return (Criteria) this;
        }

        public Criteria andAdultTaxNotEqualTo(String value) {
            addCriterion("adult_tax <>", value, "adultTax");
            return (Criteria) this;
        }

        public Criteria andAdultTaxGreaterThan(String value) {
            addCriterion("adult_tax >", value, "adultTax");
            return (Criteria) this;
        }

        public Criteria andAdultTaxGreaterThanOrEqualTo(String value) {
            addCriterion("adult_tax >=", value, "adultTax");
            return (Criteria) this;
        }

        public Criteria andAdultTaxLessThan(String value) {
            addCriterion("adult_tax <", value, "adultTax");
            return (Criteria) this;
        }

        public Criteria andAdultTaxLessThanOrEqualTo(String value) {
            addCriterion("adult_tax <=", value, "adultTax");
            return (Criteria) this;
        }

        public Criteria andAdultTaxLike(String value) {
            addCriterion("adult_tax like", value, "adultTax");
            return (Criteria) this;
        }

        public Criteria andAdultTaxNotLike(String value) {
            addCriterion("adult_tax not like", value, "adultTax");
            return (Criteria) this;
        }

        public Criteria andAdultTaxIn(List<String> values) {
            addCriterion("adult_tax in", values, "adultTax");
            return (Criteria) this;
        }

        public Criteria andAdultTaxNotIn(List<String> values) {
            addCriterion("adult_tax not in", values, "adultTax");
            return (Criteria) this;
        }

        public Criteria andAdultTaxBetween(String value1, String value2) {
            addCriterion("adult_tax between", value1, value2, "adultTax");
            return (Criteria) this;
        }

        public Criteria andAdultTaxNotBetween(String value1, String value2) {
            addCriterion("adult_tax not between", value1, value2, "adultTax");
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

        public Criteria andChildTaxIsNull() {
            addCriterion("child_tax is null");
            return (Criteria) this;
        }

        public Criteria andChildTaxIsNotNull() {
            addCriterion("child_tax is not null");
            return (Criteria) this;
        }

        public Criteria andChildTaxEqualTo(String value) {
            addCriterion("child_tax =", value, "childTax");
            return (Criteria) this;
        }

        public Criteria andChildTaxNotEqualTo(String value) {
            addCriterion("child_tax <>", value, "childTax");
            return (Criteria) this;
        }

        public Criteria andChildTaxGreaterThan(String value) {
            addCriterion("child_tax >", value, "childTax");
            return (Criteria) this;
        }

        public Criteria andChildTaxGreaterThanOrEqualTo(String value) {
            addCriterion("child_tax >=", value, "childTax");
            return (Criteria) this;
        }

        public Criteria andChildTaxLessThan(String value) {
            addCriterion("child_tax <", value, "childTax");
            return (Criteria) this;
        }

        public Criteria andChildTaxLessThanOrEqualTo(String value) {
            addCriterion("child_tax <=", value, "childTax");
            return (Criteria) this;
        }

        public Criteria andChildTaxLike(String value) {
            addCriterion("child_tax like", value, "childTax");
            return (Criteria) this;
        }

        public Criteria andChildTaxNotLike(String value) {
            addCriterion("child_tax not like", value, "childTax");
            return (Criteria) this;
        }

        public Criteria andChildTaxIn(List<String> values) {
            addCriterion("child_tax in", values, "childTax");
            return (Criteria) this;
        }

        public Criteria andChildTaxNotIn(List<String> values) {
            addCriterion("child_tax not in", values, "childTax");
            return (Criteria) this;
        }

        public Criteria andChildTaxBetween(String value1, String value2) {
            addCriterion("child_tax between", value1, value2, "childTax");
            return (Criteria) this;
        }

        public Criteria andChildTaxNotBetween(String value1, String value2) {
            addCriterion("child_tax not between", value1, value2, "childTax");
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