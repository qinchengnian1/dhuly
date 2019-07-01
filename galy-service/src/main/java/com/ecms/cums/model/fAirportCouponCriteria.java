package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class fAirportCouponCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public fAirportCouponCriteria() {
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

        public Criteria andFCardIdIsNull() {
            addCriterion("f_card_id is null");
            return (Criteria) this;
        }

        public Criteria andFCardIdIsNotNull() {
            addCriterion("f_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andFCardIdEqualTo(Integer value) {
            addCriterion("f_card_id =", value, "fCardId");
            return (Criteria) this;
        }

        public Criteria andFCardIdNotEqualTo(Integer value) {
            addCriterion("f_card_id <>", value, "fCardId");
            return (Criteria) this;
        }

        public Criteria andFCardIdGreaterThan(Integer value) {
            addCriterion("f_card_id >", value, "fCardId");
            return (Criteria) this;
        }

        public Criteria andFCardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("f_card_id >=", value, "fCardId");
            return (Criteria) this;
        }

        public Criteria andFCardIdLessThan(Integer value) {
            addCriterion("f_card_id <", value, "fCardId");
            return (Criteria) this;
        }

        public Criteria andFCardIdLessThanOrEqualTo(Integer value) {
            addCriterion("f_card_id <=", value, "fCardId");
            return (Criteria) this;
        }

        public Criteria andFCardIdIn(List<Integer> values) {
            addCriterion("f_card_id in", values, "fCardId");
            return (Criteria) this;
        }

        public Criteria andFCardIdNotIn(List<Integer> values) {
            addCriterion("f_card_id not in", values, "fCardId");
            return (Criteria) this;
        }

        public Criteria andFCardIdBetween(Integer value1, Integer value2) {
            addCriterion("f_card_id between", value1, value2, "fCardId");
            return (Criteria) this;
        }

        public Criteria andFCardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("f_card_id not between", value1, value2, "fCardId");
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

        public Criteria andFCardCouponIdIsNull() {
            addCriterion("f_card_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdIsNotNull() {
            addCriterion("f_card_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdEqualTo(String value) {
            addCriterion("f_card_coupon_id =", value, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdNotEqualTo(String value) {
            addCriterion("f_card_coupon_id <>", value, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdGreaterThan(String value) {
            addCriterion("f_card_coupon_id >", value, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdGreaterThanOrEqualTo(String value) {
            addCriterion("f_card_coupon_id >=", value, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdLessThan(String value) {
            addCriterion("f_card_coupon_id <", value, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdLessThanOrEqualTo(String value) {
            addCriterion("f_card_coupon_id <=", value, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdLike(String value) {
            addCriterion("f_card_coupon_id like", value, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdNotLike(String value) {
            addCriterion("f_card_coupon_id not like", value, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdIn(List<String> values) {
            addCriterion("f_card_coupon_id in", values, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdNotIn(List<String> values) {
            addCriterion("f_card_coupon_id not in", values, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdBetween(String value1, String value2) {
            addCriterion("f_card_coupon_id between", value1, value2, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFCardCouponIdNotBetween(String value1, String value2) {
            addCriterion("f_card_coupon_id not between", value1, value2, "fCardCouponId");
            return (Criteria) this;
        }

        public Criteria andFStartDateIsNull() {
            addCriterion("f_start_date is null");
            return (Criteria) this;
        }

        public Criteria andFStartDateIsNotNull() {
            addCriterion("f_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andFStartDateEqualTo(String value) {
            addCriterion("f_start_date =", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateNotEqualTo(String value) {
            addCriterion("f_start_date <>", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateGreaterThan(String value) {
            addCriterion("f_start_date >", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("f_start_date >=", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateLessThan(String value) {
            addCriterion("f_start_date <", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateLessThanOrEqualTo(String value) {
            addCriterion("f_start_date <=", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateLike(String value) {
            addCriterion("f_start_date like", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateNotLike(String value) {
            addCriterion("f_start_date not like", value, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateIn(List<String> values) {
            addCriterion("f_start_date in", values, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateNotIn(List<String> values) {
            addCriterion("f_start_date not in", values, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateBetween(String value1, String value2) {
            addCriterion("f_start_date between", value1, value2, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFStartDateNotBetween(String value1, String value2) {
            addCriterion("f_start_date not between", value1, value2, "fStartDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateIsNull() {
            addCriterion("f_expiration_date is null");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateIsNotNull() {
            addCriterion("f_expiration_date is not null");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateEqualTo(String value) {
            addCriterion("f_expiration_date =", value, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateNotEqualTo(String value) {
            addCriterion("f_expiration_date <>", value, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateGreaterThan(String value) {
            addCriterion("f_expiration_date >", value, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateGreaterThanOrEqualTo(String value) {
            addCriterion("f_expiration_date >=", value, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateLessThan(String value) {
            addCriterion("f_expiration_date <", value, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateLessThanOrEqualTo(String value) {
            addCriterion("f_expiration_date <=", value, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateLike(String value) {
            addCriterion("f_expiration_date like", value, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateNotLike(String value) {
            addCriterion("f_expiration_date not like", value, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateIn(List<String> values) {
            addCriterion("f_expiration_date in", values, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateNotIn(List<String> values) {
            addCriterion("f_expiration_date not in", values, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateBetween(String value1, String value2) {
            addCriterion("f_expiration_date between", value1, value2, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFExpirationDateNotBetween(String value1, String value2) {
            addCriterion("f_expiration_date not between", value1, value2, "fExpirationDate");
            return (Criteria) this;
        }

        public Criteria andFAmountIsNull() {
            addCriterion("f_amount is null");
            return (Criteria) this;
        }

        public Criteria andFAmountIsNotNull() {
            addCriterion("f_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFAmountEqualTo(String value) {
            addCriterion("f_amount =", value, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFAmountNotEqualTo(String value) {
            addCriterion("f_amount <>", value, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFAmountGreaterThan(String value) {
            addCriterion("f_amount >", value, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFAmountGreaterThanOrEqualTo(String value) {
            addCriterion("f_amount >=", value, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFAmountLessThan(String value) {
            addCriterion("f_amount <", value, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFAmountLessThanOrEqualTo(String value) {
            addCriterion("f_amount <=", value, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFAmountLike(String value) {
            addCriterion("f_amount like", value, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFAmountNotLike(String value) {
            addCriterion("f_amount not like", value, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFAmountIn(List<String> values) {
            addCriterion("f_amount in", values, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFAmountNotIn(List<String> values) {
            addCriterion("f_amount not in", values, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFAmountBetween(String value1, String value2) {
            addCriterion("f_amount between", value1, value2, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFAmountNotBetween(String value1, String value2) {
            addCriterion("f_amount not between", value1, value2, "fAmount");
            return (Criteria) this;
        }

        public Criteria andFCouponNameIsNull() {
            addCriterion("f_coupon_name is null");
            return (Criteria) this;
        }

        public Criteria andFCouponNameIsNotNull() {
            addCriterion("f_coupon_name is not null");
            return (Criteria) this;
        }

        public Criteria andFCouponNameEqualTo(String value) {
            addCriterion("f_coupon_name =", value, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andFCouponNameNotEqualTo(String value) {
            addCriterion("f_coupon_name <>", value, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andFCouponNameGreaterThan(String value) {
            addCriterion("f_coupon_name >", value, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andFCouponNameGreaterThanOrEqualTo(String value) {
            addCriterion("f_coupon_name >=", value, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andFCouponNameLessThan(String value) {
            addCriterion("f_coupon_name <", value, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andFCouponNameLessThanOrEqualTo(String value) {
            addCriterion("f_coupon_name <=", value, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andFCouponNameLike(String value) {
            addCriterion("f_coupon_name like", value, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andFCouponNameNotLike(String value) {
            addCriterion("f_coupon_name not like", value, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andFCouponNameIn(List<String> values) {
            addCriterion("f_coupon_name in", values, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andFCouponNameNotIn(List<String> values) {
            addCriterion("f_coupon_name not in", values, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andFCouponNameBetween(String value1, String value2) {
            addCriterion("f_coupon_name between", value1, value2, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andFCouponNameNotBetween(String value1, String value2) {
            addCriterion("f_coupon_name not between", value1, value2, "fCouponName");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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