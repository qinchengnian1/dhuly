package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDestLocalCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductDestLocalCriteria() {
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

        public Criteria andPDIdIsNull() {
            addCriterion("p_d_id is null");
            return (Criteria) this;
        }

        public Criteria andPDIdIsNotNull() {
            addCriterion("p_d_id is not null");
            return (Criteria) this;
        }

        public Criteria andPDIdEqualTo(Integer value) {
            addCriterion("p_d_id =", value, "pDId");
            return (Criteria) this;
        }

        public Criteria andPDIdNotEqualTo(Integer value) {
            addCriterion("p_d_id <>", value, "pDId");
            return (Criteria) this;
        }

        public Criteria andPDIdGreaterThan(Integer value) {
            addCriterion("p_d_id >", value, "pDId");
            return (Criteria) this;
        }

        public Criteria andPDIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_d_id >=", value, "pDId");
            return (Criteria) this;
        }

        public Criteria andPDIdLessThan(Integer value) {
            addCriterion("p_d_id <", value, "pDId");
            return (Criteria) this;
        }

        public Criteria andPDIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_d_id <=", value, "pDId");
            return (Criteria) this;
        }

        public Criteria andPDIdIn(List<Integer> values) {
            addCriterion("p_d_id in", values, "pDId");
            return (Criteria) this;
        }

        public Criteria andPDIdNotIn(List<Integer> values) {
            addCriterion("p_d_id not in", values, "pDId");
            return (Criteria) this;
        }

        public Criteria andPDIdBetween(Integer value1, Integer value2) {
            addCriterion("p_d_id between", value1, value2, "pDId");
            return (Criteria) this;
        }

        public Criteria andPDIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_d_id not between", value1, value2, "pDId");
            return (Criteria) this;
        }

        public Criteria andDestIdIsNull() {
            addCriterion("dest_id is null");
            return (Criteria) this;
        }

        public Criteria andDestIdIsNotNull() {
            addCriterion("dest_id is not null");
            return (Criteria) this;
        }

        public Criteria andDestIdEqualTo(String value) {
            addCriterion("dest_id =", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdNotEqualTo(String value) {
            addCriterion("dest_id <>", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdGreaterThan(String value) {
            addCriterion("dest_id >", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdGreaterThanOrEqualTo(String value) {
            addCriterion("dest_id >=", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdLessThan(String value) {
            addCriterion("dest_id <", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdLessThanOrEqualTo(String value) {
            addCriterion("dest_id <=", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdLike(String value) {
            addCriterion("dest_id like", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdNotLike(String value) {
            addCriterion("dest_id not like", value, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdIn(List<String> values) {
            addCriterion("dest_id in", values, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdNotIn(List<String> values) {
            addCriterion("dest_id not in", values, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdBetween(String value1, String value2) {
            addCriterion("dest_id between", value1, value2, "destId");
            return (Criteria) this;
        }

        public Criteria andDestIdNotBetween(String value1, String value2) {
            addCriterion("dest_id not between", value1, value2, "destId");
            return (Criteria) this;
        }

        public Criteria andDestNameIsNull() {
            addCriterion("dest_name is null");
            return (Criteria) this;
        }

        public Criteria andDestNameIsNotNull() {
            addCriterion("dest_name is not null");
            return (Criteria) this;
        }

        public Criteria andDestNameEqualTo(String value) {
            addCriterion("dest_name =", value, "destName");
            return (Criteria) this;
        }

        public Criteria andDestNameNotEqualTo(String value) {
            addCriterion("dest_name <>", value, "destName");
            return (Criteria) this;
        }

        public Criteria andDestNameGreaterThan(String value) {
            addCriterion("dest_name >", value, "destName");
            return (Criteria) this;
        }

        public Criteria andDestNameGreaterThanOrEqualTo(String value) {
            addCriterion("dest_name >=", value, "destName");
            return (Criteria) this;
        }

        public Criteria andDestNameLessThan(String value) {
            addCriterion("dest_name <", value, "destName");
            return (Criteria) this;
        }

        public Criteria andDestNameLessThanOrEqualTo(String value) {
            addCriterion("dest_name <=", value, "destName");
            return (Criteria) this;
        }

        public Criteria andDestNameLike(String value) {
            addCriterion("dest_name like", value, "destName");
            return (Criteria) this;
        }

        public Criteria andDestNameNotLike(String value) {
            addCriterion("dest_name not like", value, "destName");
            return (Criteria) this;
        }

        public Criteria andDestNameIn(List<String> values) {
            addCriterion("dest_name in", values, "destName");
            return (Criteria) this;
        }

        public Criteria andDestNameNotIn(List<String> values) {
            addCriterion("dest_name not in", values, "destName");
            return (Criteria) this;
        }

        public Criteria andDestNameBetween(String value1, String value2) {
            addCriterion("dest_name between", value1, value2, "destName");
            return (Criteria) this;
        }

        public Criteria andDestNameNotBetween(String value1, String value2) {
            addCriterion("dest_name not between", value1, value2, "destName");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNull() {
            addCriterion("pinyin is null");
            return (Criteria) this;
        }

        public Criteria andPinyinIsNotNull() {
            addCriterion("pinyin is not null");
            return (Criteria) this;
        }

        public Criteria andPinyinEqualTo(String value) {
            addCriterion("pinyin =", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotEqualTo(String value) {
            addCriterion("pinyin <>", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThan(String value) {
            addCriterion("pinyin >", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinGreaterThanOrEqualTo(String value) {
            addCriterion("pinyin >=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThan(String value) {
            addCriterion("pinyin <", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLessThanOrEqualTo(String value) {
            addCriterion("pinyin <=", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinLike(String value) {
            addCriterion("pinyin like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotLike(String value) {
            addCriterion("pinyin not like", value, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinIn(List<String> values) {
            addCriterion("pinyin in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotIn(List<String> values) {
            addCriterion("pinyin not in", values, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinBetween(String value1, String value2) {
            addCriterion("pinyin between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andPinyinNotBetween(String value1, String value2) {
            addCriterion("pinyin not between", value1, value2, "pinyin");
            return (Criteria) this;
        }

        public Criteria andDestPIdIsNull() {
            addCriterion("dest_p_id is null");
            return (Criteria) this;
        }

        public Criteria andDestPIdIsNotNull() {
            addCriterion("dest_p_id is not null");
            return (Criteria) this;
        }

        public Criteria andDestPIdEqualTo(String value) {
            addCriterion("dest_p_id =", value, "destPId");
            return (Criteria) this;
        }

        public Criteria andDestPIdNotEqualTo(String value) {
            addCriterion("dest_p_id <>", value, "destPId");
            return (Criteria) this;
        }

        public Criteria andDestPIdGreaterThan(String value) {
            addCriterion("dest_p_id >", value, "destPId");
            return (Criteria) this;
        }

        public Criteria andDestPIdGreaterThanOrEqualTo(String value) {
            addCriterion("dest_p_id >=", value, "destPId");
            return (Criteria) this;
        }

        public Criteria andDestPIdLessThan(String value) {
            addCriterion("dest_p_id <", value, "destPId");
            return (Criteria) this;
        }

        public Criteria andDestPIdLessThanOrEqualTo(String value) {
            addCriterion("dest_p_id <=", value, "destPId");
            return (Criteria) this;
        }

        public Criteria andDestPIdLike(String value) {
            addCriterion("dest_p_id like", value, "destPId");
            return (Criteria) this;
        }

        public Criteria andDestPIdNotLike(String value) {
            addCriterion("dest_p_id not like", value, "destPId");
            return (Criteria) this;
        }

        public Criteria andDestPIdIn(List<String> values) {
            addCriterion("dest_p_id in", values, "destPId");
            return (Criteria) this;
        }

        public Criteria andDestPIdNotIn(List<String> values) {
            addCriterion("dest_p_id not in", values, "destPId");
            return (Criteria) this;
        }

        public Criteria andDestPIdBetween(String value1, String value2) {
            addCriterion("dest_p_id between", value1, value2, "destPId");
            return (Criteria) this;
        }

        public Criteria andDestPIdNotBetween(String value1, String value2) {
            addCriterion("dest_p_id not between", value1, value2, "destPId");
            return (Criteria) this;
        }

        public Criteria andENameIsNull() {
            addCriterion("e_name is null");
            return (Criteria) this;
        }

        public Criteria andENameIsNotNull() {
            addCriterion("e_name is not null");
            return (Criteria) this;
        }

        public Criteria andENameEqualTo(String value) {
            addCriterion("e_name =", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotEqualTo(String value) {
            addCriterion("e_name <>", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThan(String value) {
            addCriterion("e_name >", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameGreaterThanOrEqualTo(String value) {
            addCriterion("e_name >=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThan(String value) {
            addCriterion("e_name <", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLessThanOrEqualTo(String value) {
            addCriterion("e_name <=", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameLike(String value) {
            addCriterion("e_name like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotLike(String value) {
            addCriterion("e_name not like", value, "eName");
            return (Criteria) this;
        }

        public Criteria andENameIn(List<String> values) {
            addCriterion("e_name in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotIn(List<String> values) {
            addCriterion("e_name not in", values, "eName");
            return (Criteria) this;
        }

        public Criteria andENameBetween(String value1, String value2) {
            addCriterion("e_name between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andENameNotBetween(String value1, String value2) {
            addCriterion("e_name not between", value1, value2, "eName");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIsNull() {
            addCriterion("system_flag is null");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIsNotNull() {
            addCriterion("system_flag is not null");
            return (Criteria) this;
        }

        public Criteria andSystemFlagEqualTo(String value) {
            addCriterion("system_flag =", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotEqualTo(String value) {
            addCriterion("system_flag <>", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagGreaterThan(String value) {
            addCriterion("system_flag >", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagGreaterThanOrEqualTo(String value) {
            addCriterion("system_flag >=", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLessThan(String value) {
            addCriterion("system_flag <", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLessThanOrEqualTo(String value) {
            addCriterion("system_flag <=", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagLike(String value) {
            addCriterion("system_flag like", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotLike(String value) {
            addCriterion("system_flag not like", value, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagIn(List<String> values) {
            addCriterion("system_flag in", values, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotIn(List<String> values) {
            addCriterion("system_flag not in", values, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagBetween(String value1, String value2) {
            addCriterion("system_flag between", value1, value2, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andSystemFlagNotBetween(String value1, String value2) {
            addCriterion("system_flag not between", value1, value2, "systemFlag");
            return (Criteria) this;
        }

        public Criteria andHotDestIsNull() {
            addCriterion("hot_dest is null");
            return (Criteria) this;
        }

        public Criteria andHotDestIsNotNull() {
            addCriterion("hot_dest is not null");
            return (Criteria) this;
        }

        public Criteria andHotDestEqualTo(String value) {
            addCriterion("hot_dest =", value, "hotDest");
            return (Criteria) this;
        }

        public Criteria andHotDestNotEqualTo(String value) {
            addCriterion("hot_dest <>", value, "hotDest");
            return (Criteria) this;
        }

        public Criteria andHotDestGreaterThan(String value) {
            addCriterion("hot_dest >", value, "hotDest");
            return (Criteria) this;
        }

        public Criteria andHotDestGreaterThanOrEqualTo(String value) {
            addCriterion("hot_dest >=", value, "hotDest");
            return (Criteria) this;
        }

        public Criteria andHotDestLessThan(String value) {
            addCriterion("hot_dest <", value, "hotDest");
            return (Criteria) this;
        }

        public Criteria andHotDestLessThanOrEqualTo(String value) {
            addCriterion("hot_dest <=", value, "hotDest");
            return (Criteria) this;
        }

        public Criteria andHotDestLike(String value) {
            addCriterion("hot_dest like", value, "hotDest");
            return (Criteria) this;
        }

        public Criteria andHotDestNotLike(String value) {
            addCriterion("hot_dest not like", value, "hotDest");
            return (Criteria) this;
        }

        public Criteria andHotDestIn(List<String> values) {
            addCriterion("hot_dest in", values, "hotDest");
            return (Criteria) this;
        }

        public Criteria andHotDestNotIn(List<String> values) {
            addCriterion("hot_dest not in", values, "hotDest");
            return (Criteria) this;
        }

        public Criteria andHotDestBetween(String value1, String value2) {
            addCriterion("hot_dest between", value1, value2, "hotDest");
            return (Criteria) this;
        }

        public Criteria andHotDestNotBetween(String value1, String value2) {
            addCriterion("hot_dest not between", value1, value2, "hotDest");
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