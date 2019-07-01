package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductInfoCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductInfoCriteria() {
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

        public Criteria andJnyDaysIsNull() {
            addCriterion("jny_days is null");
            return (Criteria) this;
        }

        public Criteria andJnyDaysIsNotNull() {
            addCriterion("jny_days is not null");
            return (Criteria) this;
        }

        public Criteria andJnyDaysEqualTo(String value) {
            addCriterion("jny_days =", value, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andJnyDaysNotEqualTo(String value) {
            addCriterion("jny_days <>", value, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andJnyDaysGreaterThan(String value) {
            addCriterion("jny_days >", value, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andJnyDaysGreaterThanOrEqualTo(String value) {
            addCriterion("jny_days >=", value, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andJnyDaysLessThan(String value) {
            addCriterion("jny_days <", value, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andJnyDaysLessThanOrEqualTo(String value) {
            addCriterion("jny_days <=", value, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andJnyDaysLike(String value) {
            addCriterion("jny_days like", value, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andJnyDaysNotLike(String value) {
            addCriterion("jny_days not like", value, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andJnyDaysIn(List<String> values) {
            addCriterion("jny_days in", values, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andJnyDaysNotIn(List<String> values) {
            addCriterion("jny_days not in", values, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andJnyDaysBetween(String value1, String value2) {
            addCriterion("jny_days between", value1, value2, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andJnyDaysNotBetween(String value1, String value2) {
            addCriterion("jny_days not between", value1, value2, "jnyDays");
            return (Criteria) this;
        }

        public Criteria andOwnFlgIsNull() {
            addCriterion("own_flg is null");
            return (Criteria) this;
        }

        public Criteria andOwnFlgIsNotNull() {
            addCriterion("own_flg is not null");
            return (Criteria) this;
        }

        public Criteria andOwnFlgEqualTo(String value) {
            addCriterion("own_flg =", value, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andOwnFlgNotEqualTo(String value) {
            addCriterion("own_flg <>", value, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andOwnFlgGreaterThan(String value) {
            addCriterion("own_flg >", value, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andOwnFlgGreaterThanOrEqualTo(String value) {
            addCriterion("own_flg >=", value, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andOwnFlgLessThan(String value) {
            addCriterion("own_flg <", value, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andOwnFlgLessThanOrEqualTo(String value) {
            addCriterion("own_flg <=", value, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andOwnFlgLike(String value) {
            addCriterion("own_flg like", value, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andOwnFlgNotLike(String value) {
            addCriterion("own_flg not like", value, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andOwnFlgIn(List<String> values) {
            addCriterion("own_flg in", values, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andOwnFlgNotIn(List<String> values) {
            addCriterion("own_flg not in", values, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andOwnFlgBetween(String value1, String value2) {
            addCriterion("own_flg between", value1, value2, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andOwnFlgNotBetween(String value1, String value2) {
            addCriterion("own_flg not between", value1, value2, "ownFlg");
            return (Criteria) this;
        }

        public Criteria andIfEduteIsNull() {
            addCriterion("if_edute is null");
            return (Criteria) this;
        }

        public Criteria andIfEduteIsNotNull() {
            addCriterion("if_edute is not null");
            return (Criteria) this;
        }

        public Criteria andIfEduteEqualTo(String value) {
            addCriterion("if_edute =", value, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfEduteNotEqualTo(String value) {
            addCriterion("if_edute <>", value, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfEduteGreaterThan(String value) {
            addCriterion("if_edute >", value, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfEduteGreaterThanOrEqualTo(String value) {
            addCriterion("if_edute >=", value, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfEduteLessThan(String value) {
            addCriterion("if_edute <", value, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfEduteLessThanOrEqualTo(String value) {
            addCriterion("if_edute <=", value, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfEduteLike(String value) {
            addCriterion("if_edute like", value, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfEduteNotLike(String value) {
            addCriterion("if_edute not like", value, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfEduteIn(List<String> values) {
            addCriterion("if_edute in", values, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfEduteNotIn(List<String> values) {
            addCriterion("if_edute not in", values, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfEduteBetween(String value1, String value2) {
            addCriterion("if_edute between", value1, value2, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfEduteNotBetween(String value1, String value2) {
            addCriterion("if_edute not between", value1, value2, "ifEdute");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartIsNull() {
            addCriterion("if_price_start is null");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartIsNotNull() {
            addCriterion("if_price_start is not null");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartEqualTo(String value) {
            addCriterion("if_price_start =", value, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartNotEqualTo(String value) {
            addCriterion("if_price_start <>", value, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartGreaterThan(String value) {
            addCriterion("if_price_start >", value, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartGreaterThanOrEqualTo(String value) {
            addCriterion("if_price_start >=", value, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartLessThan(String value) {
            addCriterion("if_price_start <", value, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartLessThanOrEqualTo(String value) {
            addCriterion("if_price_start <=", value, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartLike(String value) {
            addCriterion("if_price_start like", value, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartNotLike(String value) {
            addCriterion("if_price_start not like", value, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartIn(List<String> values) {
            addCriterion("if_price_start in", values, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartNotIn(List<String> values) {
            addCriterion("if_price_start not in", values, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartBetween(String value1, String value2) {
            addCriterion("if_price_start between", value1, value2, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andIfPriceStartNotBetween(String value1, String value2) {
            addCriterion("if_price_start not between", value1, value2, "ifPriceStart");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkIsNull() {
            addCriterion("price_remark is null");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkIsNotNull() {
            addCriterion("price_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkEqualTo(String value) {
            addCriterion("price_remark =", value, "priceRemark");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkNotEqualTo(String value) {
            addCriterion("price_remark <>", value, "priceRemark");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkGreaterThan(String value) {
            addCriterion("price_remark >", value, "priceRemark");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("price_remark >=", value, "priceRemark");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkLessThan(String value) {
            addCriterion("price_remark <", value, "priceRemark");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkLessThanOrEqualTo(String value) {
            addCriterion("price_remark <=", value, "priceRemark");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkLike(String value) {
            addCriterion("price_remark like", value, "priceRemark");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkNotLike(String value) {
            addCriterion("price_remark not like", value, "priceRemark");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkIn(List<String> values) {
            addCriterion("price_remark in", values, "priceRemark");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkNotIn(List<String> values) {
            addCriterion("price_remark not in", values, "priceRemark");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkBetween(String value1, String value2) {
            addCriterion("price_remark between", value1, value2, "priceRemark");
            return (Criteria) this;
        }

        public Criteria andPriceRemarkNotBetween(String value1, String value2) {
            addCriterion("price_remark not between", value1, value2, "priceRemark");
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

        public Criteria andCreatePersonIsNull() {
            addCriterion("create_person is null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIsNotNull() {
            addCriterion("create_person is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonEqualTo(String value) {
            addCriterion("create_person =", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotEqualTo(String value) {
            addCriterion("create_person <>", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThan(String value) {
            addCriterion("create_person >", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("create_person >=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThan(String value) {
            addCriterion("create_person <", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThanOrEqualTo(String value) {
            addCriterion("create_person <=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLike(String value) {
            addCriterion("create_person like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotLike(String value) {
            addCriterion("create_person not like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIn(List<String> values) {
            addCriterion("create_person in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotIn(List<String> values) {
            addCriterion("create_person not in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonBetween(String value1, String value2) {
            addCriterion("create_person between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotBetween(String value1, String value2) {
            addCriterion("create_person not between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIsNull() {
            addCriterion("update_person is null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIsNotNull() {
            addCriterion("update_person is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonEqualTo(String value) {
            addCriterion("update_person =", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotEqualTo(String value) {
            addCriterion("update_person <>", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonGreaterThan(String value) {
            addCriterion("update_person >", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("update_person >=", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLessThan(String value) {
            addCriterion("update_person <", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLessThanOrEqualTo(String value) {
            addCriterion("update_person <=", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLike(String value) {
            addCriterion("update_person like", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotLike(String value) {
            addCriterion("update_person not like", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIn(List<String> values) {
            addCriterion("update_person in", values, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotIn(List<String> values) {
            addCriterion("update_person not in", values, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonBetween(String value1, String value2) {
            addCriterion("update_person between", value1, value2, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotBetween(String value1, String value2) {
            addCriterion("update_person not between", value1, value2, "updatePerson");
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