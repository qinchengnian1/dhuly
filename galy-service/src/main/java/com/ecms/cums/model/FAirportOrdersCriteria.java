package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FAirportOrdersCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FAirportOrdersCriteria() {
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

        public Criteria andFCityNoIsNull() {
            addCriterion("f_city_no is null");
            return (Criteria) this;
        }

        public Criteria andFCityNoIsNotNull() {
            addCriterion("f_city_no is not null");
            return (Criteria) this;
        }

        public Criteria andFCityNoEqualTo(String value) {
            addCriterion("f_city_no =", value, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFCityNoNotEqualTo(String value) {
            addCriterion("f_city_no <>", value, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFCityNoGreaterThan(String value) {
            addCriterion("f_city_no >", value, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFCityNoGreaterThanOrEqualTo(String value) {
            addCriterion("f_city_no >=", value, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFCityNoLessThan(String value) {
            addCriterion("f_city_no <", value, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFCityNoLessThanOrEqualTo(String value) {
            addCriterion("f_city_no <=", value, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFCityNoLike(String value) {
            addCriterion("f_city_no like", value, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFCityNoNotLike(String value) {
            addCriterion("f_city_no not like", value, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFCityNoIn(List<String> values) {
            addCriterion("f_city_no in", values, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFCityNoNotIn(List<String> values) {
            addCriterion("f_city_no not in", values, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFCityNoBetween(String value1, String value2) {
            addCriterion("f_city_no between", value1, value2, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFCityNoNotBetween(String value1, String value2) {
            addCriterion("f_city_no not between", value1, value2, "fCityNo");
            return (Criteria) this;
        }

        public Criteria andFUserIdIsNull() {
            addCriterion("f_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFUserIdIsNotNull() {
            addCriterion("f_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFUserIdEqualTo(Integer value) {
            addCriterion("f_user_id =", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdNotEqualTo(Integer value) {
            addCriterion("f_user_id <>", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdGreaterThan(Integer value) {
            addCriterion("f_user_id >", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_user_id >=", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdLessThan(Integer value) {
            addCriterion("f_user_id <", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_user_id <=", value, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdIn(List<Integer> values) {
            addCriterion("f_user_id in", values, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdNotIn(List<Integer> values) {
            addCriterion("f_user_id not in", values, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdBetween(Integer value1, Integer value2) {
            addCriterion("f_user_id between", value1, value2, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_user_id not between", value1, value2, "fUserId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdIsNull() {
            addCriterion("f_order_group_id is null");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdIsNotNull() {
            addCriterion("f_order_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdEqualTo(String value) {
            addCriterion("f_order_group_id =", value, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdNotEqualTo(String value) {
            addCriterion("f_order_group_id <>", value, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdGreaterThan(String value) {
            addCriterion("f_order_group_id >", value, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_order_group_id >=", value, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdLessThan(String value) {
            addCriterion("f_order_group_id <", value, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdLessThanOrEqualTo(String value) {
            addCriterion("f_order_group_id <=", value, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdLike(String value) {
            addCriterion("f_order_group_id like", value, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdNotLike(String value) {
            addCriterion("f_order_group_id not like", value, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdIn(List<String> values) {
            addCriterion("f_order_group_id in", values, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdNotIn(List<String> values) {
            addCriterion("f_order_group_id not in", values, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdBetween(String value1, String value2) {
            addCriterion("f_order_group_id between", value1, value2, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderGroupIdNotBetween(String value1, String value2) {
            addCriterion("f_order_group_id not between", value1, value2, "fOrderGroupId");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtIsNull() {
            addCriterion("f_order_no_pt is null");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtIsNotNull() {
            addCriterion("f_order_no_pt is not null");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtEqualTo(String value) {
            addCriterion("f_order_no_pt =", value, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtNotEqualTo(String value) {
            addCriterion("f_order_no_pt <>", value, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtGreaterThan(String value) {
            addCriterion("f_order_no_pt >", value, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtGreaterThanOrEqualTo(String value) {
            addCriterion("f_order_no_pt >=", value, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtLessThan(String value) {
            addCriterion("f_order_no_pt <", value, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtLessThanOrEqualTo(String value) {
            addCriterion("f_order_no_pt <=", value, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtLike(String value) {
            addCriterion("f_order_no_pt like", value, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtNotLike(String value) {
            addCriterion("f_order_no_pt not like", value, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtIn(List<String> values) {
            addCriterion("f_order_no_pt in", values, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtNotIn(List<String> values) {
            addCriterion("f_order_no_pt not in", values, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtBetween(String value1, String value2) {
            addCriterion("f_order_no_pt between", value1, value2, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andFOrderNoPtNotBetween(String value1, String value2) {
            addCriterion("f_order_no_pt not between", value1, value2, "fOrderNoPt");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdIsNull() {
            addCriterion("card_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdIsNotNull() {
            addCriterion("card_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdEqualTo(String value) {
            addCriterion("card_coupon_id =", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdNotEqualTo(String value) {
            addCriterion("card_coupon_id <>", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdGreaterThan(String value) {
            addCriterion("card_coupon_id >", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdGreaterThanOrEqualTo(String value) {
            addCriterion("card_coupon_id >=", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdLessThan(String value) {
            addCriterion("card_coupon_id <", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdLessThanOrEqualTo(String value) {
            addCriterion("card_coupon_id <=", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdLike(String value) {
            addCriterion("card_coupon_id like", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdNotLike(String value) {
            addCriterion("card_coupon_id not like", value, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdIn(List<String> values) {
            addCriterion("card_coupon_id in", values, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdNotIn(List<String> values) {
            addCriterion("card_coupon_id not in", values, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdBetween(String value1, String value2) {
            addCriterion("card_coupon_id between", value1, value2, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andCardCouponIdNotBetween(String value1, String value2) {
            addCriterion("card_coupon_id not between", value1, value2, "cardCouponId");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLike(String value) {
            addCriterion("out_trade_no like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("out_trade_no not like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNull() {
            addCriterion("transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNotNull() {
            addCriterion("transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdEqualTo(String value) {
            addCriterion("transaction_id =", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotEqualTo(String value) {
            addCriterion("transaction_id <>", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThan(String value) {
            addCriterion("transaction_id >", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_id >=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThan(String value) {
            addCriterion("transaction_id <", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("transaction_id <=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLike(String value) {
            addCriterion("transaction_id like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotLike(String value) {
            addCriterion("transaction_id not like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIn(List<String> values) {
            addCriterion("transaction_id in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotIn(List<String> values) {
            addCriterion("transaction_id not in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdBetween(String value1, String value2) {
            addCriterion("transaction_id between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotBetween(String value1, String value2) {
            addCriterion("transaction_id not between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andPayplatformIsNull() {
            addCriterion("payPlatform is null");
            return (Criteria) this;
        }

        public Criteria andPayplatformIsNotNull() {
            addCriterion("payPlatform is not null");
            return (Criteria) this;
        }

        public Criteria andPayplatformEqualTo(String value) {
            addCriterion("payPlatform =", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformNotEqualTo(String value) {
            addCriterion("payPlatform <>", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformGreaterThan(String value) {
            addCriterion("payPlatform >", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformGreaterThanOrEqualTo(String value) {
            addCriterion("payPlatform >=", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformLessThan(String value) {
            addCriterion("payPlatform <", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformLessThanOrEqualTo(String value) {
            addCriterion("payPlatform <=", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformLike(String value) {
            addCriterion("payPlatform like", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformNotLike(String value) {
            addCriterion("payPlatform not like", value, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformIn(List<String> values) {
            addCriterion("payPlatform in", values, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformNotIn(List<String> values) {
            addCriterion("payPlatform not in", values, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformBetween(String value1, String value2) {
            addCriterion("payPlatform between", value1, value2, "payplatform");
            return (Criteria) this;
        }

        public Criteria andPayplatformNotBetween(String value1, String value2) {
            addCriterion("payPlatform not between", value1, value2, "payplatform");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeIsNull() {
            addCriterion("jipiao_type is null");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeIsNotNull() {
            addCriterion("jipiao_type is not null");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeEqualTo(String value) {
            addCriterion("jipiao_type =", value, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeNotEqualTo(String value) {
            addCriterion("jipiao_type <>", value, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeGreaterThan(String value) {
            addCriterion("jipiao_type >", value, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeGreaterThanOrEqualTo(String value) {
            addCriterion("jipiao_type >=", value, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeLessThan(String value) {
            addCriterion("jipiao_type <", value, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeLessThanOrEqualTo(String value) {
            addCriterion("jipiao_type <=", value, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeLike(String value) {
            addCriterion("jipiao_type like", value, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeNotLike(String value) {
            addCriterion("jipiao_type not like", value, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeIn(List<String> values) {
            addCriterion("jipiao_type in", values, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeNotIn(List<String> values) {
            addCriterion("jipiao_type not in", values, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeBetween(String value1, String value2) {
            addCriterion("jipiao_type between", value1, value2, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andJipiaoTypeNotBetween(String value1, String value2) {
            addCriterion("jipiao_type not between", value1, value2, "jipiaoType");
            return (Criteria) this;
        }

        public Criteria andTradeStateIsNull() {
            addCriterion("trade_state is null");
            return (Criteria) this;
        }

        public Criteria andTradeStateIsNotNull() {
            addCriterion("trade_state is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStateEqualTo(String value) {
            addCriterion("trade_state =", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateNotEqualTo(String value) {
            addCriterion("trade_state <>", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateGreaterThan(String value) {
            addCriterion("trade_state >", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateGreaterThanOrEqualTo(String value) {
            addCriterion("trade_state >=", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateLessThan(String value) {
            addCriterion("trade_state <", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateLessThanOrEqualTo(String value) {
            addCriterion("trade_state <=", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateLike(String value) {
            addCriterion("trade_state like", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateNotLike(String value) {
            addCriterion("trade_state not like", value, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateIn(List<String> values) {
            addCriterion("trade_state in", values, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateNotIn(List<String> values) {
            addCriterion("trade_state not in", values, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateBetween(String value1, String value2) {
            addCriterion("trade_state between", value1, value2, "tradeState");
            return (Criteria) this;
        }

        public Criteria andTradeStateNotBetween(String value1, String value2) {
            addCriterion("trade_state not between", value1, value2, "tradeState");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIsNull() {
            addCriterion("notify_time is null");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIsNotNull() {
            addCriterion("notify_time is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeEqualTo(Date value) {
            addCriterion("notify_time =", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotEqualTo(Date value) {
            addCriterion("notify_time <>", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThan(Date value) {
            addCriterion("notify_time >", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notify_time >=", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThan(Date value) {
            addCriterion("notify_time <", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeLessThanOrEqualTo(Date value) {
            addCriterion("notify_time <=", value, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeIn(List<Date> values) {
            addCriterion("notify_time in", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotIn(List<Date> values) {
            addCriterion("notify_time not in", values, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeBetween(Date value1, Date value2) {
            addCriterion("notify_time between", value1, value2, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andNotifyTimeNotBetween(Date value1, Date value2) {
            addCriterion("notify_time not between", value1, value2, "notifyTime");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(String value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(String value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(String value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(String value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLike(String value) {
            addCriterion("total_price like", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotLike(String value) {
            addCriterion("total_price not like", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<String> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<String> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(String value1, String value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(String value1, String value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceIsNull() {
            addCriterion("coupon_price is null");
            return (Criteria) this;
        }

        public Criteria andCouponPriceIsNotNull() {
            addCriterion("coupon_price is not null");
            return (Criteria) this;
        }

        public Criteria andCouponPriceEqualTo(String value) {
            addCriterion("coupon_price =", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceNotEqualTo(String value) {
            addCriterion("coupon_price <>", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceGreaterThan(String value) {
            addCriterion("coupon_price >", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_price >=", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceLessThan(String value) {
            addCriterion("coupon_price <", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceLessThanOrEqualTo(String value) {
            addCriterion("coupon_price <=", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceLike(String value) {
            addCriterion("coupon_price like", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceNotLike(String value) {
            addCriterion("coupon_price not like", value, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceIn(List<String> values) {
            addCriterion("coupon_price in", values, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceNotIn(List<String> values) {
            addCriterion("coupon_price not in", values, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceBetween(String value1, String value2) {
            addCriterion("coupon_price between", value1, value2, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andCouponPriceNotBetween(String value1, String value2) {
            addCriterion("coupon_price not between", value1, value2, "couponPrice");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoIsNull() {
            addCriterion("ldy_order_no is null");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoIsNotNull() {
            addCriterion("ldy_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoEqualTo(String value) {
            addCriterion("ldy_order_no =", value, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoNotEqualTo(String value) {
            addCriterion("ldy_order_no <>", value, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoGreaterThan(String value) {
            addCriterion("ldy_order_no >", value, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("ldy_order_no >=", value, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoLessThan(String value) {
            addCriterion("ldy_order_no <", value, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoLessThanOrEqualTo(String value) {
            addCriterion("ldy_order_no <=", value, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoLike(String value) {
            addCriterion("ldy_order_no like", value, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoNotLike(String value) {
            addCriterion("ldy_order_no not like", value, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoIn(List<String> values) {
            addCriterion("ldy_order_no in", values, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoNotIn(List<String> values) {
            addCriterion("ldy_order_no not in", values, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoBetween(String value1, String value2) {
            addCriterion("ldy_order_no between", value1, value2, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyOrderNoNotBetween(String value1, String value2) {
            addCriterion("ldy_order_no not between", value1, value2, "ldyOrderNo");
            return (Criteria) this;
        }

        public Criteria andLdyPnrIsNull() {
            addCriterion("ldy_pnr is null");
            return (Criteria) this;
        }

        public Criteria andLdyPnrIsNotNull() {
            addCriterion("ldy_pnr is not null");
            return (Criteria) this;
        }

        public Criteria andLdyPnrEqualTo(String value) {
            addCriterion("ldy_pnr =", value, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyPnrNotEqualTo(String value) {
            addCriterion("ldy_pnr <>", value, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyPnrGreaterThan(String value) {
            addCriterion("ldy_pnr >", value, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyPnrGreaterThanOrEqualTo(String value) {
            addCriterion("ldy_pnr >=", value, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyPnrLessThan(String value) {
            addCriterion("ldy_pnr <", value, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyPnrLessThanOrEqualTo(String value) {
            addCriterion("ldy_pnr <=", value, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyPnrLike(String value) {
            addCriterion("ldy_pnr like", value, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyPnrNotLike(String value) {
            addCriterion("ldy_pnr not like", value, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyPnrIn(List<String> values) {
            addCriterion("ldy_pnr in", values, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyPnrNotIn(List<String> values) {
            addCriterion("ldy_pnr not in", values, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyPnrBetween(String value1, String value2) {
            addCriterion("ldy_pnr between", value1, value2, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyPnrNotBetween(String value1, String value2) {
            addCriterion("ldy_pnr not between", value1, value2, "ldyPnr");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdIsNull() {
            addCriterion("ldy_order_id is null");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdIsNotNull() {
            addCriterion("ldy_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdEqualTo(String value) {
            addCriterion("ldy_order_id =", value, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdNotEqualTo(String value) {
            addCriterion("ldy_order_id <>", value, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdGreaterThan(String value) {
            addCriterion("ldy_order_id >", value, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("ldy_order_id >=", value, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdLessThan(String value) {
            addCriterion("ldy_order_id <", value, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdLessThanOrEqualTo(String value) {
            addCriterion("ldy_order_id <=", value, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdLike(String value) {
            addCriterion("ldy_order_id like", value, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdNotLike(String value) {
            addCriterion("ldy_order_id not like", value, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdIn(List<String> values) {
            addCriterion("ldy_order_id in", values, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdNotIn(List<String> values) {
            addCriterion("ldy_order_id not in", values, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdBetween(String value1, String value2) {
            addCriterion("ldy_order_id between", value1, value2, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andLdyOrderIdNotBetween(String value1, String value2) {
            addCriterion("ldy_order_id not between", value1, value2, "ldyOrderId");
            return (Criteria) this;
        }

        public Criteria andStatusNameIsNull() {
            addCriterion("status_name is null");
            return (Criteria) this;
        }

        public Criteria andStatusNameIsNotNull() {
            addCriterion("status_name is not null");
            return (Criteria) this;
        }

        public Criteria andStatusNameEqualTo(String value) {
            addCriterion("status_name =", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotEqualTo(String value) {
            addCriterion("status_name <>", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameGreaterThan(String value) {
            addCriterion("status_name >", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameGreaterThanOrEqualTo(String value) {
            addCriterion("status_name >=", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLessThan(String value) {
            addCriterion("status_name <", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLessThanOrEqualTo(String value) {
            addCriterion("status_name <=", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameLike(String value) {
            addCriterion("status_name like", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotLike(String value) {
            addCriterion("status_name not like", value, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameIn(List<String> values) {
            addCriterion("status_name in", values, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotIn(List<String> values) {
            addCriterion("status_name not in", values, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameBetween(String value1, String value2) {
            addCriterion("status_name between", value1, value2, "statusName");
            return (Criteria) this;
        }

        public Criteria andStatusNameNotBetween(String value1, String value2) {
            addCriterion("status_name not between", value1, value2, "statusName");
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

        public Criteria andFenrunOutTradeNoIsNull() {
            addCriterion("fenrun_out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoIsNotNull() {
            addCriterion("fenrun_out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoEqualTo(String value) {
            addCriterion("fenrun_out_trade_no =", value, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoNotEqualTo(String value) {
            addCriterion("fenrun_out_trade_no <>", value, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoGreaterThan(String value) {
            addCriterion("fenrun_out_trade_no >", value, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("fenrun_out_trade_no >=", value, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoLessThan(String value) {
            addCriterion("fenrun_out_trade_no <", value, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("fenrun_out_trade_no <=", value, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoLike(String value) {
            addCriterion("fenrun_out_trade_no like", value, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoNotLike(String value) {
            addCriterion("fenrun_out_trade_no not like", value, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoIn(List<String> values) {
            addCriterion("fenrun_out_trade_no in", values, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoNotIn(List<String> values) {
            addCriterion("fenrun_out_trade_no not in", values, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoBetween(String value1, String value2) {
            addCriterion("fenrun_out_trade_no between", value1, value2, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("fenrun_out_trade_no not between", value1, value2, "fenrunOutTradeNo");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceIsNull() {
            addCriterion("fenrun_total_price is null");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceIsNotNull() {
            addCriterion("fenrun_total_price is not null");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceEqualTo(String value) {
            addCriterion("fenrun_total_price =", value, "fenrunTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceNotEqualTo(String value) {
            addCriterion("fenrun_total_price <>", value, "fenrunTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceGreaterThan(String value) {
            addCriterion("fenrun_total_price >", value, "fenrunTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceGreaterThanOrEqualTo(String value) {
            addCriterion("fenrun_total_price >=", value, "fenrunTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceLessThan(String value) {
            addCriterion("fenrun_total_price <", value, "fenrunTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceLessThanOrEqualTo(String value) {
            addCriterion("fenrun_total_price <=", value, "fenrunTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceLike(String value) {
            addCriterion("fenrun_total_price like", value, "fenrunTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceNotLike(String value) {
            addCriterion("fenrun_total_price not like", value, "fenrunTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceIn(List<String> values) {
            addCriterion("fenrun_total_price in", values, "fenrunTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceNotIn(List<String> values) {
            addCriterion("fenrun_total_price not in", values, "fenrunTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceBetween(String value1, String value2) {
            addCriterion("fenrun_total_price between", value1, value2, "fenrunTotalPrice");
            return (Criteria) this;
        }

        public Criteria andFenrunTotalPriceNotBetween(String value1, String value2) {
            addCriterion("fenrun_total_price not between", value1, value2, "fenrunTotalPrice");
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