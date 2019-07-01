package com.ecms.cums.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInfoCriteria {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public OrderInfoCriteria() {
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
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

		public Criteria andCityIdIsNull() {
			addCriterion("city_id is null");
			return (Criteria) this;
		}

		public Criteria andCityIdIsNotNull() {
			addCriterion("city_id is not null");
			return (Criteria) this;
		}

		public Criteria andCityIdEqualTo(Integer value) {
			addCriterion("city_id =", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotEqualTo(Integer value) {
			addCriterion("city_id <>", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThan(Integer value) {
			addCriterion("city_id >", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("city_id >=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThan(Integer value) {
			addCriterion("city_id <", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdLessThanOrEqualTo(Integer value) {
			addCriterion("city_id <=", value, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdIn(List<Integer> values) {
			addCriterion("city_id in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotIn(List<Integer> values) {
			addCriterion("city_id not in", values, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdBetween(Integer value1, Integer value2) {
			addCriterion("city_id between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andCityIdNotBetween(Integer value1, Integer value2) {
			addCriterion("city_id not between", value1, value2, "cityId");
			return (Criteria) this;
		}

		public Criteria andProductIdIsNull() {
			addCriterion("product_id is null");
			return (Criteria) this;
		}

		public Criteria andProductIdIsNotNull() {
			addCriterion("product_id is not null");
			return (Criteria) this;
		}

		public Criteria andProductIdEqualTo(Integer value) {
			addCriterion("product_id =", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdNotEqualTo(Integer value) {
			addCriterion("product_id <>", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdGreaterThan(Integer value) {
			addCriterion("product_id >", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("product_id >=", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdLessThan(Integer value) {
			addCriterion("product_id <", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdLessThanOrEqualTo(Integer value) {
			addCriterion("product_id <=", value, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdIn(List<Integer> values) {
			addCriterion("product_id in", values, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdNotIn(List<Integer> values) {
			addCriterion("product_id not in", values, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdBetween(Integer value1, Integer value2) {
			addCriterion("product_id between", value1, value2, "productId");
			return (Criteria) this;
		}

		public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
			addCriterion("product_id not between", value1, value2, "productId");
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

		public Criteria andStoreIdIsNull() {
			addCriterion("store_id is null");
			return (Criteria) this;
		}

		public Criteria andStoreIdIsNotNull() {
			addCriterion("store_id is not null");
			return (Criteria) this;
		}

		public Criteria andStoreIdEqualTo(String value) {
			addCriterion("store_id =", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotEqualTo(String value) {
			addCriterion("store_id <>", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThan(String value) {
			addCriterion("store_id >", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdGreaterThanOrEqualTo(String value) {
			addCriterion("store_id >=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThan(String value) {
			addCriterion("store_id <", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLessThanOrEqualTo(String value) {
			addCriterion("store_id <=", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdLike(String value) {
			addCriterion("store_id like", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotLike(String value) {
			addCriterion("store_id not like", value, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdIn(List<String> values) {
			addCriterion("store_id in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotIn(List<String> values) {
			addCriterion("store_id not in", values, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdBetween(String value1, String value2) {
			addCriterion("store_id between", value1, value2, "storeId");
			return (Criteria) this;
		}

		public Criteria andStoreIdNotBetween(String value1, String value2) {
			addCriterion("store_id not between", value1, value2, "storeId");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtIsNull() {
			addCriterion("order_no_pt is null");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtIsNotNull() {
			addCriterion("order_no_pt is not null");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtEqualTo(String value) {
			addCriterion("order_no_pt =", value, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtNotEqualTo(String value) {
			addCriterion("order_no_pt <>", value, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtGreaterThan(String value) {
			addCriterion("order_no_pt >", value, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtGreaterThanOrEqualTo(String value) {
			addCriterion("order_no_pt >=", value, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtLessThan(String value) {
			addCriterion("order_no_pt <", value, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtLessThanOrEqualTo(String value) {
			addCriterion("order_no_pt <=", value, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtLike(String value) {
			addCriterion("order_no_pt like", value, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtNotLike(String value) {
			addCriterion("order_no_pt not like", value, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtIn(List<String> values) {
			addCriterion("order_no_pt in", values, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtNotIn(List<String> values) {
			addCriterion("order_no_pt not in", values, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtBetween(String value1, String value2) {
			addCriterion("order_no_pt between", value1, value2, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoPtNotBetween(String value1, String value2) {
			addCriterion("order_no_pt not between", value1, value2, "orderNoPt");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlIsNull() {
			addCriterion("order_no_gl is null");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlIsNotNull() {
			addCriterion("order_no_gl is not null");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlEqualTo(String value) {
			addCriterion("order_no_gl =", value, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlNotEqualTo(String value) {
			addCriterion("order_no_gl <>", value, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlGreaterThan(String value) {
			addCriterion("order_no_gl >", value, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlGreaterThanOrEqualTo(String value) {
			addCriterion("order_no_gl >=", value, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlLessThan(String value) {
			addCriterion("order_no_gl <", value, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlLessThanOrEqualTo(String value) {
			addCriterion("order_no_gl <=", value, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlLike(String value) {
			addCriterion("order_no_gl like", value, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlNotLike(String value) {
			addCriterion("order_no_gl not like", value, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlIn(List<String> values) {
			addCriterion("order_no_gl in", values, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlNotIn(List<String> values) {
			addCriterion("order_no_gl not in", values, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlBetween(String value1, String value2) {
			addCriterion("order_no_gl between", value1, value2, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoGlNotBetween(String value1, String value2) {
			addCriterion("order_no_gl not between", value1, value2, "orderNoGl");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalIsNull() {
			addCriterion("order_no_local is null");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalIsNotNull() {
			addCriterion("order_no_local is not null");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalEqualTo(String value) {
			addCriterion("order_no_local =", value, "orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalNotEqualTo(String value) {
			addCriterion("order_no_local <>", value, "orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalGreaterThan(String value) {
			addCriterion("order_no_local >", value, "orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalGreaterThanOrEqualTo(String value) {
			addCriterion("order_no_local >=", value, "orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalLessThan(String value) {
			addCriterion("order_no_local <", value, "orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalLessThanOrEqualTo(String value) {
			addCriterion("order_no_local <=", value, "orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalLike(String value) {
			addCriterion("order_no_local like", value, "orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalNotLike(String value) {
			addCriterion("order_no_local not like", value, "orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalIn(List<String> values) {
			addCriterion("order_no_local in", values, "orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalNotIn(List<String> values) {
			addCriterion("order_no_local not in", values, "orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalBetween(String value1, String value2) {
			addCriterion("order_no_local between", value1, value2,
					"orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andOrderNoLocalNotBetween(String value1, String value2) {
			addCriterion("order_no_local not between", value1, value2,
					"orderNoLocal");
			return (Criteria) this;
		}

		public Criteria andPerNameIsNull() {
			addCriterion("per_name is null");
			return (Criteria) this;
		}

		public Criteria andPerNameIsNotNull() {
			addCriterion("per_name is not null");
			return (Criteria) this;
		}

		public Criteria andPerNameEqualTo(String value) {
			addCriterion("per_name =", value, "perName");
			return (Criteria) this;
		}

		public Criteria andPerNameNotEqualTo(String value) {
			addCriterion("per_name <>", value, "perName");
			return (Criteria) this;
		}

		public Criteria andPerNameGreaterThan(String value) {
			addCriterion("per_name >", value, "perName");
			return (Criteria) this;
		}

		public Criteria andPerNameGreaterThanOrEqualTo(String value) {
			addCriterion("per_name >=", value, "perName");
			return (Criteria) this;
		}

		public Criteria andPerNameLessThan(String value) {
			addCriterion("per_name <", value, "perName");
			return (Criteria) this;
		}

		public Criteria andPerNameLessThanOrEqualTo(String value) {
			addCriterion("per_name <=", value, "perName");
			return (Criteria) this;
		}

		public Criteria andPerNameLike(String value) {
			addCriterion("per_name like", value, "perName");
			return (Criteria) this;
		}

		public Criteria andPerNameNotLike(String value) {
			addCriterion("per_name not like", value, "perName");
			return (Criteria) this;
		}

		public Criteria andPerNameIn(List<String> values) {
			addCriterion("per_name in", values, "perName");
			return (Criteria) this;
		}

		public Criteria andPerNameNotIn(List<String> values) {
			addCriterion("per_name not in", values, "perName");
			return (Criteria) this;
		}

		public Criteria andPerNameBetween(String value1, String value2) {
			addCriterion("per_name between", value1, value2, "perName");
			return (Criteria) this;
		}

		public Criteria andPerNameNotBetween(String value1, String value2) {
			addCriterion("per_name not between", value1, value2, "perName");
			return (Criteria) this;
		}

		public Criteria andPerEmailIsNull() {
			addCriterion("per_email is null");
			return (Criteria) this;
		}

		public Criteria andPerEmailIsNotNull() {
			addCriterion("per_email is not null");
			return (Criteria) this;
		}

		public Criteria andPerEmailEqualTo(String value) {
			addCriterion("per_email =", value, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerEmailNotEqualTo(String value) {
			addCriterion("per_email <>", value, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerEmailGreaterThan(String value) {
			addCriterion("per_email >", value, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerEmailGreaterThanOrEqualTo(String value) {
			addCriterion("per_email >=", value, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerEmailLessThan(String value) {
			addCriterion("per_email <", value, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerEmailLessThanOrEqualTo(String value) {
			addCriterion("per_email <=", value, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerEmailLike(String value) {
			addCriterion("per_email like", value, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerEmailNotLike(String value) {
			addCriterion("per_email not like", value, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerEmailIn(List<String> values) {
			addCriterion("per_email in", values, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerEmailNotIn(List<String> values) {
			addCriterion("per_email not in", values, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerEmailBetween(String value1, String value2) {
			addCriterion("per_email between", value1, value2, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerEmailNotBetween(String value1, String value2) {
			addCriterion("per_email not between", value1, value2, "perEmail");
			return (Criteria) this;
		}

		public Criteria andPerTelIsNull() {
			addCriterion("per_tel is null");
			return (Criteria) this;
		}

		public Criteria andPerTelIsNotNull() {
			addCriterion("per_tel is not null");
			return (Criteria) this;
		}

		public Criteria andPerTelEqualTo(String value) {
			addCriterion("per_tel =", value, "perTel");
			return (Criteria) this;
		}

		public Criteria andPerTelNotEqualTo(String value) {
			addCriterion("per_tel <>", value, "perTel");
			return (Criteria) this;
		}

		public Criteria andPerTelGreaterThan(String value) {
			addCriterion("per_tel >", value, "perTel");
			return (Criteria) this;
		}

		public Criteria andPerTelGreaterThanOrEqualTo(String value) {
			addCriterion("per_tel >=", value, "perTel");
			return (Criteria) this;
		}

		public Criteria andPerTelLessThan(String value) {
			addCriterion("per_tel <", value, "perTel");
			return (Criteria) this;
		}

		public Criteria andPerTelLessThanOrEqualTo(String value) {
			addCriterion("per_tel <=", value, "perTel");
			return (Criteria) this;
		}

		public Criteria andPerTelLike(String value) {
			addCriterion("per_tel like", value, "perTel");
			return (Criteria) this;
		}

		public Criteria andPerTelNotLike(String value) {
			addCriterion("per_tel not like", value, "perTel");
			return (Criteria) this;
		}

		public Criteria andPerTelIn(List<String> values) {
			addCriterion("per_tel in", values, "perTel");
			return (Criteria) this;
		}

		public Criteria andPerTelNotIn(List<String> values) {
			addCriterion("per_tel not in", values, "perTel");
			return (Criteria) this;
		}

		public Criteria andPerTelBetween(String value1, String value2) {
			addCriterion("per_tel between", value1, value2, "perTel");
			return (Criteria) this;
		}

		public Criteria andPerTelNotBetween(String value1, String value2) {
			addCriterion("per_tel not between", value1, value2, "perTel");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlIsNull() {
			addCriterion("product_img_url is null");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlIsNotNull() {
			addCriterion("product_img_url is not null");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlEqualTo(String value) {
			addCriterion("product_img_url =", value, "productImgUrl");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlNotEqualTo(String value) {
			addCriterion("product_img_url <>", value, "productImgUrl");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlGreaterThan(String value) {
			addCriterion("product_img_url >", value, "productImgUrl");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlGreaterThanOrEqualTo(String value) {
			addCriterion("product_img_url >=", value, "productImgUrl");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlLessThan(String value) {
			addCriterion("product_img_url <", value, "productImgUrl");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlLessThanOrEqualTo(String value) {
			addCriterion("product_img_url <=", value, "productImgUrl");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlLike(String value) {
			addCriterion("product_img_url like", value, "productImgUrl");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlNotLike(String value) {
			addCriterion("product_img_url not like", value, "productImgUrl");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlIn(List<String> values) {
			addCriterion("product_img_url in", values, "productImgUrl");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlNotIn(List<String> values) {
			addCriterion("product_img_url not in", values, "productImgUrl");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlBetween(String value1, String value2) {
			addCriterion("product_img_url between", value1, value2,
					"productImgUrl");
			return (Criteria) this;
		}

		public Criteria andProductImgUrlNotBetween(String value1, String value2) {
			addCriterion("product_img_url not between", value1, value2,
					"productImgUrl");
			return (Criteria) this;
		}

		public Criteria andRouteNameIsNull() {
			addCriterion("route_name is null");
			return (Criteria) this;
		}

		public Criteria andRouteNameIsNotNull() {
			addCriterion("route_name is not null");
			return (Criteria) this;
		}

		public Criteria andRouteNameEqualTo(String value) {
			addCriterion("route_name =", value, "routeName");
			return (Criteria) this;
		}

		public Criteria andRouteNameNotEqualTo(String value) {
			addCriterion("route_name <>", value, "routeName");
			return (Criteria) this;
		}

		public Criteria andRouteNameGreaterThan(String value) {
			addCriterion("route_name >", value, "routeName");
			return (Criteria) this;
		}

		public Criteria andRouteNameGreaterThanOrEqualTo(String value) {
			addCriterion("route_name >=", value, "routeName");
			return (Criteria) this;
		}

		public Criteria andRouteNameLessThan(String value) {
			addCriterion("route_name <", value, "routeName");
			return (Criteria) this;
		}

		public Criteria andRouteNameLessThanOrEqualTo(String value) {
			addCriterion("route_name <=", value, "routeName");
			return (Criteria) this;
		}

		public Criteria andRouteNameLike(String value) {
			addCriterion("route_name like", value, "routeName");
			return (Criteria) this;
		}

		public Criteria andRouteNameNotLike(String value) {
			addCriterion("route_name not like", value, "routeName");
			return (Criteria) this;
		}

		public Criteria andRouteNameIn(List<String> values) {
			addCriterion("route_name in", values, "routeName");
			return (Criteria) this;
		}

		public Criteria andRouteNameNotIn(List<String> values) {
			addCriterion("route_name not in", values, "routeName");
			return (Criteria) this;
		}

		public Criteria andRouteNameBetween(String value1, String value2) {
			addCriterion("route_name between", value1, value2, "routeName");
			return (Criteria) this;
		}

		public Criteria andRouteNameNotBetween(String value1, String value2) {
			addCriterion("route_name not between", value1, value2, "routeName");
			return (Criteria) this;
		}

		public Criteria andStartPlaceIsNull() {
			addCriterion("start_place is null");
			return (Criteria) this;
		}

		public Criteria andStartPlaceIsNotNull() {
			addCriterion("start_place is not null");
			return (Criteria) this;
		}

		public Criteria andStartPlaceEqualTo(String value) {
			addCriterion("start_place =", value, "startPlace");
			return (Criteria) this;
		}

		public Criteria andStartPlaceNotEqualTo(String value) {
			addCriterion("start_place <>", value, "startPlace");
			return (Criteria) this;
		}

		public Criteria andStartPlaceGreaterThan(String value) {
			addCriterion("start_place >", value, "startPlace");
			return (Criteria) this;
		}

		public Criteria andStartPlaceGreaterThanOrEqualTo(String value) {
			addCriterion("start_place >=", value, "startPlace");
			return (Criteria) this;
		}

		public Criteria andStartPlaceLessThan(String value) {
			addCriterion("start_place <", value, "startPlace");
			return (Criteria) this;
		}

		public Criteria andStartPlaceLessThanOrEqualTo(String value) {
			addCriterion("start_place <=", value, "startPlace");
			return (Criteria) this;
		}

		public Criteria andStartPlaceLike(String value) {
			addCriterion("start_place like", value, "startPlace");
			return (Criteria) this;
		}

		public Criteria andStartPlaceNotLike(String value) {
			addCriterion("start_place not like", value, "startPlace");
			return (Criteria) this;
		}

		public Criteria andStartPlaceIn(List<String> values) {
			addCriterion("start_place in", values, "startPlace");
			return (Criteria) this;
		}

		public Criteria andStartPlaceNotIn(List<String> values) {
			addCriterion("start_place not in", values, "startPlace");
			return (Criteria) this;
		}

		public Criteria andStartPlaceBetween(String value1, String value2) {
			addCriterion("start_place between", value1, value2, "startPlace");
			return (Criteria) this;
		}

		public Criteria andStartPlaceNotBetween(String value1, String value2) {
			addCriterion("start_place not between", value1, value2,
					"startPlace");
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

		public Criteria andStateLocalIsNull() {
			addCriterion("state_local is null");
			return (Criteria) this;
		}

		public Criteria andStateLocalIsNotNull() {
			addCriterion("state_local is not null");
			return (Criteria) this;
		}

		public Criteria andStateLocalEqualTo(String value) {
			addCriterion("state_local =", value, "stateLocal");
			return (Criteria) this;
		}

		public Criteria andStateLocalNotEqualTo(String value) {
			addCriterion("state_local <>", value, "stateLocal");
			return (Criteria) this;
		}

		public Criteria andStateLocalGreaterThan(String value) {
			addCriterion("state_local >", value, "stateLocal");
			return (Criteria) this;
		}

		public Criteria andStateLocalGreaterThanOrEqualTo(String value) {
			addCriterion("state_local >=", value, "stateLocal");
			return (Criteria) this;
		}

		public Criteria andStateLocalLessThan(String value) {
			addCriterion("state_local <", value, "stateLocal");
			return (Criteria) this;
		}

		public Criteria andStateLocalLessThanOrEqualTo(String value) {
			addCriterion("state_local <=", value, "stateLocal");
			return (Criteria) this;
		}

		public Criteria andStateLocalLike(String value) {
			addCriterion("state_local like", value, "stateLocal");
			return (Criteria) this;
		}

		public Criteria andStateLocalNotLike(String value) {
			addCriterion("state_local not like", value, "stateLocal");
			return (Criteria) this;
		}

		public Criteria andStateLocalIn(List<String> values) {
			addCriterion("state_local in", values, "stateLocal");
			return (Criteria) this;
		}

		public Criteria andStateLocalNotIn(List<String> values) {
			addCriterion("state_local not in", values, "stateLocal");
			return (Criteria) this;
		}

		public Criteria andStateLocalBetween(String value1, String value2) {
			addCriterion("state_local between", value1, value2, "stateLocal");
			return (Criteria) this;
		}

		public Criteria andStateLocalNotBetween(String value1, String value2) {
			addCriterion("state_local not between", value1, value2,
					"stateLocal");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceIsNull() {
			addCriterion("online_price is null");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceIsNotNull() {
			addCriterion("online_price is not null");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceEqualTo(String value) {
			addCriterion("online_price =", value, "onlinePrice");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceNotEqualTo(String value) {
			addCriterion("online_price <>", value, "onlinePrice");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceGreaterThan(String value) {
			addCriterion("online_price >", value, "onlinePrice");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceGreaterThanOrEqualTo(String value) {
			addCriterion("online_price >=", value, "onlinePrice");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceLessThan(String value) {
			addCriterion("online_price <", value, "onlinePrice");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceLessThanOrEqualTo(String value) {
			addCriterion("online_price <=", value, "onlinePrice");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceLike(String value) {
			addCriterion("online_price like", value, "onlinePrice");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceNotLike(String value) {
			addCriterion("online_price not like", value, "onlinePrice");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceIn(List<String> values) {
			addCriterion("online_price in", values, "onlinePrice");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceNotIn(List<String> values) {
			addCriterion("online_price not in", values, "onlinePrice");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceBetween(String value1, String value2) {
			addCriterion("online_price between", value1, value2, "onlinePrice");
			return (Criteria) this;
		}

		public Criteria andOnlinePriceNotBetween(String value1, String value2) {
			addCriterion("online_price not between", value1, value2,
					"onlinePrice");
			return (Criteria) this;
		}

		public Criteria andProductUrlIsNull() {
			addCriterion("product_url is null");
			return (Criteria) this;
		}

		public Criteria andProductUrlIsNotNull() {
			addCriterion("product_url is not null");
			return (Criteria) this;
		}

		public Criteria andProductUrlEqualTo(String value) {
			addCriterion("product_url =", value, "productUrl");
			return (Criteria) this;
		}

		public Criteria andProductUrlNotEqualTo(String value) {
			addCriterion("product_url <>", value, "productUrl");
			return (Criteria) this;
		}

		public Criteria andProductUrlGreaterThan(String value) {
			addCriterion("product_url >", value, "productUrl");
			return (Criteria) this;
		}

		public Criteria andProductUrlGreaterThanOrEqualTo(String value) {
			addCriterion("product_url >=", value, "productUrl");
			return (Criteria) this;
		}

		public Criteria andProductUrlLessThan(String value) {
			addCriterion("product_url <", value, "productUrl");
			return (Criteria) this;
		}

		public Criteria andProductUrlLessThanOrEqualTo(String value) {
			addCriterion("product_url <=", value, "productUrl");
			return (Criteria) this;
		}

		public Criteria andProductUrlLike(String value) {
			addCriterion("product_url like", value, "productUrl");
			return (Criteria) this;
		}

		public Criteria andProductUrlNotLike(String value) {
			addCriterion("product_url not like", value, "productUrl");
			return (Criteria) this;
		}

		public Criteria andProductUrlIn(List<String> values) {
			addCriterion("product_url in", values, "productUrl");
			return (Criteria) this;
		}

		public Criteria andProductUrlNotIn(List<String> values) {
			addCriterion("product_url not in", values, "productUrl");
			return (Criteria) this;
		}

		public Criteria andProductUrlBetween(String value1, String value2) {
			addCriterion("product_url between", value1, value2, "productUrl");
			return (Criteria) this;
		}

		public Criteria andProductUrlNotBetween(String value1, String value2) {
			addCriterion("product_url not between", value1, value2,
					"productUrl");
			return (Criteria) this;
		}

		public Criteria andTeamIdIsNull() {
			addCriterion("team_id is null");
			return (Criteria) this;
		}

		public Criteria andTeamIdIsNotNull() {
			addCriterion("team_id is not null");
			return (Criteria) this;
		}

		public Criteria andTeamIdEqualTo(String value) {
			addCriterion("team_id =", value, "teamId");
			return (Criteria) this;
		}

		public Criteria andTeamIdNotEqualTo(String value) {
			addCriterion("team_id <>", value, "teamId");
			return (Criteria) this;
		}

		public Criteria andTeamIdGreaterThan(String value) {
			addCriterion("team_id >", value, "teamId");
			return (Criteria) this;
		}

		public Criteria andTeamIdGreaterThanOrEqualTo(String value) {
			addCriterion("team_id >=", value, "teamId");
			return (Criteria) this;
		}

		public Criteria andTeamIdLessThan(String value) {
			addCriterion("team_id <", value, "teamId");
			return (Criteria) this;
		}

		public Criteria andTeamIdLessThanOrEqualTo(String value) {
			addCriterion("team_id <=", value, "teamId");
			return (Criteria) this;
		}

		public Criteria andTeamIdLike(String value) {
			addCriterion("team_id like", value, "teamId");
			return (Criteria) this;
		}

		public Criteria andTeamIdNotLike(String value) {
			addCriterion("team_id not like", value, "teamId");
			return (Criteria) this;
		}

		public Criteria andTeamIdIn(List<String> values) {
			addCriterion("team_id in", values, "teamId");
			return (Criteria) this;
		}

		public Criteria andTeamIdNotIn(List<String> values) {
			addCriterion("team_id not in", values, "teamId");
			return (Criteria) this;
		}

		public Criteria andTeamIdBetween(String value1, String value2) {
			addCriterion("team_id between", value1, value2, "teamId");
			return (Criteria) this;
		}

		public Criteria andTeamIdNotBetween(String value1, String value2) {
			addCriterion("team_id not between", value1, value2, "teamId");
			return (Criteria) this;
		}

		public Criteria andIfLocalIsNull() {
			addCriterion("if_local is null");
			return (Criteria) this;
		}

		public Criteria andIfLocalIsNotNull() {
			addCriterion("if_local is not null");
			return (Criteria) this;
		}

		public Criteria andIfLocalEqualTo(String value) {
			addCriterion("if_local =", value, "ifLocal");
			return (Criteria) this;
		}

		public Criteria andIfLocalNotEqualTo(String value) {
			addCriterion("if_local <>", value, "ifLocal");
			return (Criteria) this;
		}

		public Criteria andIfLocalGreaterThan(String value) {
			addCriterion("if_local >", value, "ifLocal");
			return (Criteria) this;
		}

		public Criteria andIfLocalGreaterThanOrEqualTo(String value) {
			addCriterion("if_local >=", value, "ifLocal");
			return (Criteria) this;
		}

		public Criteria andIfLocalLessThan(String value) {
			addCriterion("if_local <", value, "ifLocal");
			return (Criteria) this;
		}

		public Criteria andIfLocalLessThanOrEqualTo(String value) {
			addCriterion("if_local <=", value, "ifLocal");
			return (Criteria) this;
		}

		public Criteria andIfLocalLike(String value) {
			addCriterion("if_local like", value, "ifLocal");
			return (Criteria) this;
		}

		public Criteria andIfLocalNotLike(String value) {
			addCriterion("if_local not like", value, "ifLocal");
			return (Criteria) this;
		}

		public Criteria andIfLocalIn(List<String> values) {
			addCriterion("if_local in", values, "ifLocal");
			return (Criteria) this;
		}

		public Criteria andIfLocalNotIn(List<String> values) {
			addCriterion("if_local not in", values, "ifLocal");
			return (Criteria) this;
		}

		public Criteria andIfLocalBetween(String value1, String value2) {
			addCriterion("if_local between", value1, value2, "ifLocal");
			return (Criteria) this;
		}

		public Criteria andIfLocalNotBetween(String value1, String value2) {
			addCriterion("if_local not between", value1, value2, "ifLocal");
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
			addCriterion("create_time not between", value1, value2,
					"createTime");
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
			addCriterion("update_time not between", value1, value2,
					"updateTime");
			return (Criteria) this;
		}

		public Criteria andCreateNameIsNull() {
			addCriterion("create_name is null");
			return (Criteria) this;
		}

		public Criteria andCreateNameIsNotNull() {
			addCriterion("create_name is not null");
			return (Criteria) this;
		}

		public Criteria andCreateNameEqualTo(String value) {
			addCriterion("create_name =", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameNotEqualTo(String value) {
			addCriterion("create_name <>", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameGreaterThan(String value) {
			addCriterion("create_name >", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameGreaterThanOrEqualTo(String value) {
			addCriterion("create_name >=", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameLessThan(String value) {
			addCriterion("create_name <", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameLessThanOrEqualTo(String value) {
			addCriterion("create_name <=", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameLike(String value) {
			addCriterion("create_name like", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameNotLike(String value) {
			addCriterion("create_name not like", value, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameIn(List<String> values) {
			addCriterion("create_name in", values, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameNotIn(List<String> values) {
			addCriterion("create_name not in", values, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameBetween(String value1, String value2) {
			addCriterion("create_name between", value1, value2, "createName");
			return (Criteria) this;
		}

		public Criteria andCreateNameNotBetween(String value1, String value2) {
			addCriterion("create_name not between", value1, value2,
					"createName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameIsNull() {
			addCriterion("update_name is null");
			return (Criteria) this;
		}

		public Criteria andUpdateNameIsNotNull() {
			addCriterion("update_name is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateNameEqualTo(String value) {
			addCriterion("update_name =", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameNotEqualTo(String value) {
			addCriterion("update_name <>", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameGreaterThan(String value) {
			addCriterion("update_name >", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameGreaterThanOrEqualTo(String value) {
			addCriterion("update_name >=", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameLessThan(String value) {
			addCriterion("update_name <", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameLessThanOrEqualTo(String value) {
			addCriterion("update_name <=", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameLike(String value) {
			addCriterion("update_name like", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameNotLike(String value) {
			addCriterion("update_name not like", value, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameIn(List<String> values) {
			addCriterion("update_name in", values, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameNotIn(List<String> values) {
			addCriterion("update_name not in", values, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameBetween(String value1, String value2) {
			addCriterion("update_name between", value1, value2, "updateName");
			return (Criteria) this;
		}

		public Criteria andUpdateNameNotBetween(String value1, String value2) {
			addCriterion("update_name not between", value1, value2,
					"updateName");
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

		public Criteria andRouteIdIsNull() {
			addCriterion("route_id is null");
			return (Criteria) this;
		}

		public Criteria andRouteIdIsNotNull() {
			addCriterion("route_id is not null");
			return (Criteria) this;
		}

		public Criteria andRouteIdEqualTo(String value) {
			addCriterion("route_id =", value, "routeId");
			return (Criteria) this;
		}

		public Criteria andRouteIdNotEqualTo(String value) {
			addCriterion("route_id <>", value, "routeId");
			return (Criteria) this;
		}

		public Criteria andRouteIdGreaterThan(String value) {
			addCriterion("route_id >", value, "routeId");
			return (Criteria) this;
		}

		public Criteria andRouteIdGreaterThanOrEqualTo(String value) {
			addCriterion("route_id >=", value, "routeId");
			return (Criteria) this;
		}

		public Criteria andRouteIdLessThan(String value) {
			addCriterion("route_id <", value, "routeId");
			return (Criteria) this;
		}

		public Criteria andRouteIdLessThanOrEqualTo(String value) {
			addCriterion("route_id <=", value, "routeId");
			return (Criteria) this;
		}

		public Criteria andRouteIdLike(String value) {
			addCriterion("route_id like", value, "routeId");
			return (Criteria) this;
		}

		public Criteria andRouteIdNotLike(String value) {
			addCriterion("route_id not like", value, "routeId");
			return (Criteria) this;
		}

		public Criteria andRouteIdIn(List<String> values) {
			addCriterion("route_id in", values, "routeId");
			return (Criteria) this;
		}

		public Criteria andRouteIdNotIn(List<String> values) {
			addCriterion("route_id not in", values, "routeId");
			return (Criteria) this;
		}

		public Criteria andRouteIdBetween(String value1, String value2) {
			addCriterion("route_id between", value1, value2, "routeId");
			return (Criteria) this;
		}

		public Criteria andRouteIdNotBetween(String value1, String value2) {
			addCriterion("route_id not between", value1, value2, "routeId");
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
			addCriterion("system_flag not between", value1, value2,
					"systemFlag");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeIsNull() {
			addCriterion("gl_order_type is null");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeIsNotNull() {
			addCriterion("gl_order_type is not null");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeEqualTo(String value) {
			addCriterion("gl_order_type =", value, "glOrderType");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeNotEqualTo(String value) {
			addCriterion("gl_order_type <>", value, "glOrderType");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeGreaterThan(String value) {
			addCriterion("gl_order_type >", value, "glOrderType");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeGreaterThanOrEqualTo(String value) {
			addCriterion("gl_order_type >=", value, "glOrderType");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeLessThan(String value) {
			addCriterion("gl_order_type <", value, "glOrderType");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeLessThanOrEqualTo(String value) {
			addCriterion("gl_order_type <=", value, "glOrderType");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeLike(String value) {
			addCriterion("gl_order_type like", value, "glOrderType");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeNotLike(String value) {
			addCriterion("gl_order_type not like", value, "glOrderType");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeIn(List<String> values) {
			addCriterion("gl_order_type in", values, "glOrderType");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeNotIn(List<String> values) {
			addCriterion("gl_order_type not in", values, "glOrderType");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeBetween(String value1, String value2) {
			addCriterion("gl_order_type between", value1, value2, "glOrderType");
			return (Criteria) this;
		}

		public Criteria andGlOrderTypeNotBetween(String value1, String value2) {
			addCriterion("gl_order_type not between", value1, value2,
					"glOrderType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeIsNull() {
			addCriterion("delivery_type is null");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeIsNotNull() {
			addCriterion("delivery_type is not null");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeEqualTo(String value) {
			addCriterion("delivery_type =", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeNotEqualTo(String value) {
			addCriterion("delivery_type <>", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeGreaterThan(String value) {
			addCriterion("delivery_type >", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeGreaterThanOrEqualTo(String value) {
			addCriterion("delivery_type >=", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeLessThan(String value) {
			addCriterion("delivery_type <", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeLessThanOrEqualTo(String value) {
			addCriterion("delivery_type <=", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeLike(String value) {
			addCriterion("delivery_type like", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeNotLike(String value) {
			addCriterion("delivery_type not like", value, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeIn(List<String> values) {
			addCriterion("delivery_type in", values, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeNotIn(List<String> values) {
			addCriterion("delivery_type not in", values, "deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeBetween(String value1, String value2) {
			addCriterion("delivery_type between", value1, value2,
					"deliveryType");
			return (Criteria) this;
		}

		public Criteria andDeliveryTypeNotBetween(String value1, String value2) {
			addCriterion("delivery_type not between", value1, value2,
					"deliveryType");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdIsNull() {
			addCriterion("employee_id is null");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdIsNotNull() {
			addCriterion("employee_id is not null");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdEqualTo(String value) {
			addCriterion("employee_id =", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdNotEqualTo(String value) {
			addCriterion("employee_id <>", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdGreaterThan(String value) {
			addCriterion("employee_id >", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdGreaterThanOrEqualTo(String value) {
			addCriterion("employee_id >=", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdLessThan(String value) {
			addCriterion("employee_id <", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdLessThanOrEqualTo(String value) {
			addCriterion("employee_id <=", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdLike(String value) {
			addCriterion("employee_id like", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdNotLike(String value) {
			addCriterion("employee_id not like", value, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdIn(List<String> values) {
			addCriterion("employee_id in", values, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdNotIn(List<String> values) {
			addCriterion("employee_id not in", values, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdBetween(String value1, String value2) {
			addCriterion("employee_id between", value1, value2, "employeeId");
			return (Criteria) this;
		}

		public Criteria andEmployeeIdNotBetween(String value1, String value2) {
			addCriterion("employee_id not between", value1, value2,
					"employeeId");
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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