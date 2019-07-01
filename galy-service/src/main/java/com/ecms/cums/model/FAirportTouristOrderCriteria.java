package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FAirportTouristOrderCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FAirportTouristOrderCriteria() {
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

        public Criteria andFOTIdIsNull() {
            addCriterion("f_o_t_id is null");
            return (Criteria) this;
        }

        public Criteria andFOTIdIsNotNull() {
            addCriterion("f_o_t_id is not null");
            return (Criteria) this;
        }

        public Criteria andFOTIdEqualTo(Integer value) {
            addCriterion("f_o_t_id =", value, "fOTId");
            return (Criteria) this;
        }

        public Criteria andFOTIdNotEqualTo(Integer value) {
            addCriterion("f_o_t_id <>", value, "fOTId");
            return (Criteria) this;
        }

        public Criteria andFOTIdGreaterThan(Integer value) {
            addCriterion("f_o_t_id >", value, "fOTId");
            return (Criteria) this;
        }

        public Criteria andFOTIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_o_t_id >=", value, "fOTId");
            return (Criteria) this;
        }

        public Criteria andFOTIdLessThan(Integer value) {
            addCriterion("f_o_t_id <", value, "fOTId");
            return (Criteria) this;
        }

        public Criteria andFOTIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_o_t_id <=", value, "fOTId");
            return (Criteria) this;
        }

        public Criteria andFOTIdIn(List<Integer> values) {
            addCriterion("f_o_t_id in", values, "fOTId");
            return (Criteria) this;
        }

        public Criteria andFOTIdNotIn(List<Integer> values) {
            addCriterion("f_o_t_id not in", values, "fOTId");
            return (Criteria) this;
        }

        public Criteria andFOTIdBetween(Integer value1, Integer value2) {
            addCriterion("f_o_t_id between", value1, value2, "fOTId");
            return (Criteria) this;
        }

        public Criteria andFOTIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_o_t_id not between", value1, value2, "fOTId");
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

        public Criteria andReturnRefundFeeLdyIsNull() {
            addCriterion("return_refund_fee_ldy is null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyIsNotNull() {
            addCriterion("return_refund_fee_ldy is not null");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyEqualTo(String value) {
            addCriterion("return_refund_fee_ldy =", value, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyNotEqualTo(String value) {
            addCriterion("return_refund_fee_ldy <>", value, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyGreaterThan(String value) {
            addCriterion("return_refund_fee_ldy >", value, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyGreaterThanOrEqualTo(String value) {
            addCriterion("return_refund_fee_ldy >=", value, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyLessThan(String value) {
            addCriterion("return_refund_fee_ldy <", value, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyLessThanOrEqualTo(String value) {
            addCriterion("return_refund_fee_ldy <=", value, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyLike(String value) {
            addCriterion("return_refund_fee_ldy like", value, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyNotLike(String value) {
            addCriterion("return_refund_fee_ldy not like", value, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyIn(List<String> values) {
            addCriterion("return_refund_fee_ldy in", values, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyNotIn(List<String> values) {
            addCriterion("return_refund_fee_ldy not in", values, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyBetween(String value1, String value2) {
            addCriterion("return_refund_fee_ldy between", value1, value2, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andReturnRefundFeeLdyNotBetween(String value1, String value2) {
            addCriterion("return_refund_fee_ldy not between", value1, value2, "returnRefundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyIsNull() {
            addCriterion("refund_fee_ldy is null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyIsNotNull() {
            addCriterion("refund_fee_ldy is not null");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyEqualTo(String value) {
            addCriterion("refund_fee_ldy =", value, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyNotEqualTo(String value) {
            addCriterion("refund_fee_ldy <>", value, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyGreaterThan(String value) {
            addCriterion("refund_fee_ldy >", value, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyGreaterThanOrEqualTo(String value) {
            addCriterion("refund_fee_ldy >=", value, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyLessThan(String value) {
            addCriterion("refund_fee_ldy <", value, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyLessThanOrEqualTo(String value) {
            addCriterion("refund_fee_ldy <=", value, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyLike(String value) {
            addCriterion("refund_fee_ldy like", value, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyNotLike(String value) {
            addCriterion("refund_fee_ldy not like", value, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyIn(List<String> values) {
            addCriterion("refund_fee_ldy in", values, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyNotIn(List<String> values) {
            addCriterion("refund_fee_ldy not in", values, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyBetween(String value1, String value2) {
            addCriterion("refund_fee_ldy between", value1, value2, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andRefundFeeLdyNotBetween(String value1, String value2) {
            addCriterion("refund_fee_ldy not between", value1, value2, "refundFeeLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyIsNull() {
            addCriterion("passenger_id_ldy is null");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyIsNotNull() {
            addCriterion("passenger_id_ldy is not null");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyEqualTo(String value) {
            addCriterion("passenger_id_ldy =", value, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyNotEqualTo(String value) {
            addCriterion("passenger_id_ldy <>", value, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyGreaterThan(String value) {
            addCriterion("passenger_id_ldy >", value, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyGreaterThanOrEqualTo(String value) {
            addCriterion("passenger_id_ldy >=", value, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyLessThan(String value) {
            addCriterion("passenger_id_ldy <", value, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyLessThanOrEqualTo(String value) {
            addCriterion("passenger_id_ldy <=", value, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyLike(String value) {
            addCriterion("passenger_id_ldy like", value, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyNotLike(String value) {
            addCriterion("passenger_id_ldy not like", value, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyIn(List<String> values) {
            addCriterion("passenger_id_ldy in", values, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyNotIn(List<String> values) {
            addCriterion("passenger_id_ldy not in", values, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyBetween(String value1, String value2) {
            addCriterion("passenger_id_ldy between", value1, value2, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andPassengerIdLdyNotBetween(String value1, String value2) {
            addCriterion("passenger_id_ldy not between", value1, value2, "passengerIdLdy");
            return (Criteria) this;
        }

        public Criteria andRefundCauseIsNull() {
            addCriterion("refund_cause is null");
            return (Criteria) this;
        }

        public Criteria andRefundCauseIsNotNull() {
            addCriterion("refund_cause is not null");
            return (Criteria) this;
        }

        public Criteria andRefundCauseEqualTo(String value) {
            addCriterion("refund_cause =", value, "refundCause");
            return (Criteria) this;
        }

        public Criteria andRefundCauseNotEqualTo(String value) {
            addCriterion("refund_cause <>", value, "refundCause");
            return (Criteria) this;
        }

        public Criteria andRefundCauseGreaterThan(String value) {
            addCriterion("refund_cause >", value, "refundCause");
            return (Criteria) this;
        }

        public Criteria andRefundCauseGreaterThanOrEqualTo(String value) {
            addCriterion("refund_cause >=", value, "refundCause");
            return (Criteria) this;
        }

        public Criteria andRefundCauseLessThan(String value) {
            addCriterion("refund_cause <", value, "refundCause");
            return (Criteria) this;
        }

        public Criteria andRefundCauseLessThanOrEqualTo(String value) {
            addCriterion("refund_cause <=", value, "refundCause");
            return (Criteria) this;
        }

        public Criteria andRefundCauseLike(String value) {
            addCriterion("refund_cause like", value, "refundCause");
            return (Criteria) this;
        }

        public Criteria andRefundCauseNotLike(String value) {
            addCriterion("refund_cause not like", value, "refundCause");
            return (Criteria) this;
        }

        public Criteria andRefundCauseIn(List<String> values) {
            addCriterion("refund_cause in", values, "refundCause");
            return (Criteria) this;
        }

        public Criteria andRefundCauseNotIn(List<String> values) {
            addCriterion("refund_cause not in", values, "refundCause");
            return (Criteria) this;
        }

        public Criteria andRefundCauseBetween(String value1, String value2) {
            addCriterion("refund_cause between", value1, value2, "refundCause");
            return (Criteria) this;
        }

        public Criteria andRefundCauseNotBetween(String value1, String value2) {
            addCriterion("refund_cause not between", value1, value2, "refundCause");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllIsNull() {
            addCriterion("one_price_all is null");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllIsNotNull() {
            addCriterion("one_price_all is not null");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllEqualTo(String value) {
            addCriterion("one_price_all =", value, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllNotEqualTo(String value) {
            addCriterion("one_price_all <>", value, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllGreaterThan(String value) {
            addCriterion("one_price_all >", value, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllGreaterThanOrEqualTo(String value) {
            addCriterion("one_price_all >=", value, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllLessThan(String value) {
            addCriterion("one_price_all <", value, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllLessThanOrEqualTo(String value) {
            addCriterion("one_price_all <=", value, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllLike(String value) {
            addCriterion("one_price_all like", value, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllNotLike(String value) {
            addCriterion("one_price_all not like", value, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllIn(List<String> values) {
            addCriterion("one_price_all in", values, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllNotIn(List<String> values) {
            addCriterion("one_price_all not in", values, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllBetween(String value1, String value2) {
            addCriterion("one_price_all between", value1, value2, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andOnePriceAllNotBetween(String value1, String value2) {
            addCriterion("one_price_all not between", value1, value2, "onePriceAll");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeIsNull() {
            addCriterion("fact_return_fee is null");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeIsNotNull() {
            addCriterion("fact_return_fee is not null");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeEqualTo(String value) {
            addCriterion("fact_return_fee =", value, "factReturnFee");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeNotEqualTo(String value) {
            addCriterion("fact_return_fee <>", value, "factReturnFee");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeGreaterThan(String value) {
            addCriterion("fact_return_fee >", value, "factReturnFee");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeGreaterThanOrEqualTo(String value) {
            addCriterion("fact_return_fee >=", value, "factReturnFee");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeLessThan(String value) {
            addCriterion("fact_return_fee <", value, "factReturnFee");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeLessThanOrEqualTo(String value) {
            addCriterion("fact_return_fee <=", value, "factReturnFee");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeLike(String value) {
            addCriterion("fact_return_fee like", value, "factReturnFee");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeNotLike(String value) {
            addCriterion("fact_return_fee not like", value, "factReturnFee");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeIn(List<String> values) {
            addCriterion("fact_return_fee in", values, "factReturnFee");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeNotIn(List<String> values) {
            addCriterion("fact_return_fee not in", values, "factReturnFee");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeBetween(String value1, String value2) {
            addCriterion("fact_return_fee between", value1, value2, "factReturnFee");
            return (Criteria) this;
        }

        public Criteria andFactReturnFeeNotBetween(String value1, String value2) {
            addCriterion("fact_return_fee not between", value1, value2, "factReturnFee");
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