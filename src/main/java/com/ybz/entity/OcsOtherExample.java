package com.ybz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OcsOtherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OcsOtherExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPkIsNull() {
            addCriterion("pk is null");
            return (Criteria) this;
        }

        public Criteria andPkIsNotNull() {
            addCriterion("pk is not null");
            return (Criteria) this;
        }

        public Criteria andPkEqualTo(String value) {
            addCriterion("pk =", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkNotEqualTo(String value) {
            addCriterion("pk <>", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkGreaterThan(String value) {
            addCriterion("pk >", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkGreaterThanOrEqualTo(String value) {
            addCriterion("pk >=", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkLessThan(String value) {
            addCriterion("pk <", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkLessThanOrEqualTo(String value) {
            addCriterion("pk <=", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkLike(String value) {
            addCriterion("pk like", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkNotLike(String value) {
            addCriterion("pk not like", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkIn(List<String> values) {
            addCriterion("pk in", values, "pk");
            return (Criteria) this;
        }

        public Criteria andPkNotIn(List<String> values) {
            addCriterion("pk not in", values, "pk");
            return (Criteria) this;
        }

        public Criteria andPkBetween(String value1, String value2) {
            addCriterion("pk between", value1, value2, "pk");
            return (Criteria) this;
        }

        public Criteria andPkNotBetween(String value1, String value2) {
            addCriterion("pk not between", value1, value2, "pk");
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

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("tenant_id is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("tenant_id is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("tenant_id =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("tenant_id <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("tenant_id >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_id >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("tenant_id <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("tenant_id <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("tenant_id like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("tenant_id not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("tenant_id in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("tenant_id not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("tenant_id between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("tenant_id not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Double value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Double value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Double value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Double value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Double value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Double value1, Double value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Double value1, Double value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andOtherDateIsNull() {
            addCriterion("other_date is null");
            return (Criteria) this;
        }

        public Criteria andOtherDateIsNotNull() {
            addCriterion("other_date is not null");
            return (Criteria) this;
        }

        public Criteria andOtherDateEqualTo(Date value) {
            addCriterionForJDBCDate("other_date =", value, "otherDate");
            return (Criteria) this;
        }

        public Criteria andOtherDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("other_date <>", value, "otherDate");
            return (Criteria) this;
        }

        public Criteria andOtherDateGreaterThan(Date value) {
            addCriterionForJDBCDate("other_date >", value, "otherDate");
            return (Criteria) this;
        }

        public Criteria andOtherDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("other_date >=", value, "otherDate");
            return (Criteria) this;
        }

        public Criteria andOtherDateLessThan(Date value) {
            addCriterionForJDBCDate("other_date <", value, "otherDate");
            return (Criteria) this;
        }

        public Criteria andOtherDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("other_date <=", value, "otherDate");
            return (Criteria) this;
        }

        public Criteria andOtherDateIn(List<Date> values) {
            addCriterionForJDBCDate("other_date in", values, "otherDate");
            return (Criteria) this;
        }

        public Criteria andOtherDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("other_date not in", values, "otherDate");
            return (Criteria) this;
        }

        public Criteria andOtherDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("other_date between", value1, value2, "otherDate");
            return (Criteria) this;
        }

        public Criteria andOtherDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("other_date not between", value1, value2, "otherDate");
            return (Criteria) this;
        }

        public Criteria andExpenseIsNull() {
            addCriterion("expense is null");
            return (Criteria) this;
        }

        public Criteria andExpenseIsNotNull() {
            addCriterion("expense is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseEqualTo(Boolean value) {
            addCriterion("expense =", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotEqualTo(Boolean value) {
            addCriterion("expense <>", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseGreaterThan(Boolean value) {
            addCriterion("expense >", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("expense >=", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseLessThan(Boolean value) {
            addCriterion("expense <", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseLessThanOrEqualTo(Boolean value) {
            addCriterion("expense <=", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseIn(List<Boolean> values) {
            addCriterion("expense in", values, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotIn(List<Boolean> values) {
            addCriterion("expense not in", values, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseBetween(Boolean value1, Boolean value2) {
            addCriterion("expense between", value1, value2, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("expense not between", value1, value2, "expense");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("valid is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("valid is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(Boolean value) {
            addCriterion("valid =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(Boolean value) {
            addCriterion("valid <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(Boolean value) {
            addCriterion("valid >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("valid >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(Boolean value) {
            addCriterion("valid <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(Boolean value) {
            addCriterion("valid <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<Boolean> values) {
            addCriterion("valid in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<Boolean> values) {
            addCriterion("valid not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(Boolean value1, Boolean value2) {
            addCriterion("valid between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("valid not between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andTsIsNull() {
            addCriterion("ts is null");
            return (Criteria) this;
        }

        public Criteria andTsIsNotNull() {
            addCriterion("ts is not null");
            return (Criteria) this;
        }

        public Criteria andTsEqualTo(Date value) {
            addCriterion("ts =", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotEqualTo(Date value) {
            addCriterion("ts <>", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThan(Date value) {
            addCriterion("ts >", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsGreaterThanOrEqualTo(Date value) {
            addCriterion("ts >=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThan(Date value) {
            addCriterion("ts <", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsLessThanOrEqualTo(Date value) {
            addCriterion("ts <=", value, "ts");
            return (Criteria) this;
        }

        public Criteria andTsIn(List<Date> values) {
            addCriterion("ts in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotIn(List<Date> values) {
            addCriterion("ts not in", values, "ts");
            return (Criteria) this;
        }

        public Criteria andTsBetween(Date value1, Date value2) {
            addCriterion("ts between", value1, value2, "ts");
            return (Criteria) this;
        }

        public Criteria andTsNotBetween(Date value1, Date value2) {
            addCriterion("ts not between", value1, value2, "ts");
            return (Criteria) this;
        }

        public Criteria andTaxrateIsNull() {
            addCriterion("taxrate is null");
            return (Criteria) this;
        }

        public Criteria andTaxrateIsNotNull() {
            addCriterion("taxrate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxrateEqualTo(Double value) {
            addCriterion("taxrate =", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateNotEqualTo(Double value) {
            addCriterion("taxrate <>", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateGreaterThan(Double value) {
            addCriterion("taxrate >", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateGreaterThanOrEqualTo(Double value) {
            addCriterion("taxrate >=", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateLessThan(Double value) {
            addCriterion("taxrate <", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateLessThanOrEqualTo(Double value) {
            addCriterion("taxrate <=", value, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateIn(List<Double> values) {
            addCriterion("taxrate in", values, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateNotIn(List<Double> values) {
            addCriterion("taxrate not in", values, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateBetween(Double value1, Double value2) {
            addCriterion("taxrate between", value1, value2, "taxrate");
            return (Criteria) this;
        }

        public Criteria andTaxrateNotBetween(Double value1, Double value2) {
            addCriterion("taxrate not between", value1, value2, "taxrate");
            return (Criteria) this;
        }

        public Criteria andIncludtaxIsNull() {
            addCriterion("includtax is null");
            return (Criteria) this;
        }

        public Criteria andIncludtaxIsNotNull() {
            addCriterion("includtax is not null");
            return (Criteria) this;
        }

        public Criteria andIncludtaxEqualTo(Double value) {
            addCriterion("includtax =", value, "includtax");
            return (Criteria) this;
        }

        public Criteria andIncludtaxNotEqualTo(Double value) {
            addCriterion("includtax <>", value, "includtax");
            return (Criteria) this;
        }

        public Criteria andIncludtaxGreaterThan(Double value) {
            addCriterion("includtax >", value, "includtax");
            return (Criteria) this;
        }

        public Criteria andIncludtaxGreaterThanOrEqualTo(Double value) {
            addCriterion("includtax >=", value, "includtax");
            return (Criteria) this;
        }

        public Criteria andIncludtaxLessThan(Double value) {
            addCriterion("includtax <", value, "includtax");
            return (Criteria) this;
        }

        public Criteria andIncludtaxLessThanOrEqualTo(Double value) {
            addCriterion("includtax <=", value, "includtax");
            return (Criteria) this;
        }

        public Criteria andIncludtaxIn(List<Double> values) {
            addCriterion("includtax in", values, "includtax");
            return (Criteria) this;
        }

        public Criteria andIncludtaxNotIn(List<Double> values) {
            addCriterion("includtax not in", values, "includtax");
            return (Criteria) this;
        }

        public Criteria andIncludtaxBetween(Double value1, Double value2) {
            addCriterion("includtax between", value1, value2, "includtax");
            return (Criteria) this;
        }

        public Criteria andIncludtaxNotBetween(Double value1, Double value2) {
            addCriterion("includtax not between", value1, value2, "includtax");
            return (Criteria) this;
        }

        public Criteria andNottaxIsNull() {
            addCriterion("nottax is null");
            return (Criteria) this;
        }

        public Criteria andNottaxIsNotNull() {
            addCriterion("nottax is not null");
            return (Criteria) this;
        }

        public Criteria andNottaxEqualTo(Double value) {
            addCriterion("nottax =", value, "nottax");
            return (Criteria) this;
        }

        public Criteria andNottaxNotEqualTo(Double value) {
            addCriterion("nottax <>", value, "nottax");
            return (Criteria) this;
        }

        public Criteria andNottaxGreaterThan(Double value) {
            addCriterion("nottax >", value, "nottax");
            return (Criteria) this;
        }

        public Criteria andNottaxGreaterThanOrEqualTo(Double value) {
            addCriterion("nottax >=", value, "nottax");
            return (Criteria) this;
        }

        public Criteria andNottaxLessThan(Double value) {
            addCriterion("nottax <", value, "nottax");
            return (Criteria) this;
        }

        public Criteria andNottaxLessThanOrEqualTo(Double value) {
            addCriterion("nottax <=", value, "nottax");
            return (Criteria) this;
        }

        public Criteria andNottaxIn(List<Double> values) {
            addCriterion("nottax in", values, "nottax");
            return (Criteria) this;
        }

        public Criteria andNottaxNotIn(List<Double> values) {
            addCriterion("nottax not in", values, "nottax");
            return (Criteria) this;
        }

        public Criteria andNottaxBetween(Double value1, Double value2) {
            addCriterion("nottax between", value1, value2, "nottax");
            return (Criteria) this;
        }

        public Criteria andNottaxNotBetween(Double value1, Double value2) {
            addCriterion("nottax not between", value1, value2, "nottax");
            return (Criteria) this;
        }

        public Criteria andInvoicenumIsNull() {
            addCriterion("invoicenum is null");
            return (Criteria) this;
        }

        public Criteria andInvoicenumIsNotNull() {
            addCriterion("invoicenum is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicenumEqualTo(String value) {
            addCriterion("invoicenum =", value, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicenumNotEqualTo(String value) {
            addCriterion("invoicenum <>", value, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicenumGreaterThan(String value) {
            addCriterion("invoicenum >", value, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicenumGreaterThanOrEqualTo(String value) {
            addCriterion("invoicenum >=", value, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicenumLessThan(String value) {
            addCriterion("invoicenum <", value, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicenumLessThanOrEqualTo(String value) {
            addCriterion("invoicenum <=", value, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicenumLike(String value) {
            addCriterion("invoicenum like", value, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicenumNotLike(String value) {
            addCriterion("invoicenum not like", value, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicenumIn(List<String> values) {
            addCriterion("invoicenum in", values, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicenumNotIn(List<String> values) {
            addCriterion("invoicenum not in", values, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicenumBetween(String value1, String value2) {
            addCriterion("invoicenum between", value1, value2, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicenumNotBetween(String value1, String value2) {
            addCriterion("invoicenum not between", value1, value2, "invoicenum");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeIsNull() {
            addCriterion("invoicetype is null");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeIsNotNull() {
            addCriterion("invoicetype is not null");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeEqualTo(String value) {
            addCriterion("invoicetype =", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotEqualTo(String value) {
            addCriterion("invoicetype <>", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeGreaterThan(String value) {
            addCriterion("invoicetype >", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeGreaterThanOrEqualTo(String value) {
            addCriterion("invoicetype >=", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeLessThan(String value) {
            addCriterion("invoicetype <", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeLessThanOrEqualTo(String value) {
            addCriterion("invoicetype <=", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeLike(String value) {
            addCriterion("invoicetype like", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotLike(String value) {
            addCriterion("invoicetype not like", value, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeIn(List<String> values) {
            addCriterion("invoicetype in", values, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotIn(List<String> values) {
            addCriterion("invoicetype not in", values, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeBetween(String value1, String value2) {
            addCriterion("invoicetype between", value1, value2, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andInvoicetypeNotBetween(String value1, String value2) {
            addCriterion("invoicetype not between", value1, value2, "invoicetype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeIsNull() {
            addCriterion("imagesystemtype is null");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeIsNotNull() {
            addCriterion("imagesystemtype is not null");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeEqualTo(String value) {
            addCriterion("imagesystemtype =", value, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeNotEqualTo(String value) {
            addCriterion("imagesystemtype <>", value, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeGreaterThan(String value) {
            addCriterion("imagesystemtype >", value, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeGreaterThanOrEqualTo(String value) {
            addCriterion("imagesystemtype >=", value, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeLessThan(String value) {
            addCriterion("imagesystemtype <", value, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeLessThanOrEqualTo(String value) {
            addCriterion("imagesystemtype <=", value, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeLike(String value) {
            addCriterion("imagesystemtype like", value, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeNotLike(String value) {
            addCriterion("imagesystemtype not like", value, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeIn(List<String> values) {
            addCriterion("imagesystemtype in", values, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeNotIn(List<String> values) {
            addCriterion("imagesystemtype not in", values, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeBetween(String value1, String value2) {
            addCriterion("imagesystemtype between", value1, value2, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andImagesystemtypeNotBetween(String value1, String value2) {
            addCriterion("imagesystemtype not between", value1, value2, "imagesystemtype");
            return (Criteria) this;
        }

        public Criteria andOverStandardIsNull() {
            addCriterion("over_standard is null");
            return (Criteria) this;
        }

        public Criteria andOverStandardIsNotNull() {
            addCriterion("over_standard is not null");
            return (Criteria) this;
        }

        public Criteria andOverStandardEqualTo(Boolean value) {
            addCriterion("over_standard =", value, "overStandard");
            return (Criteria) this;
        }

        public Criteria andOverStandardNotEqualTo(Boolean value) {
            addCriterion("over_standard <>", value, "overStandard");
            return (Criteria) this;
        }

        public Criteria andOverStandardGreaterThan(Boolean value) {
            addCriterion("over_standard >", value, "overStandard");
            return (Criteria) this;
        }

        public Criteria andOverStandardGreaterThanOrEqualTo(Boolean value) {
            addCriterion("over_standard >=", value, "overStandard");
            return (Criteria) this;
        }

        public Criteria andOverStandardLessThan(Boolean value) {
            addCriterion("over_standard <", value, "overStandard");
            return (Criteria) this;
        }

        public Criteria andOverStandardLessThanOrEqualTo(Boolean value) {
            addCriterion("over_standard <=", value, "overStandard");
            return (Criteria) this;
        }

        public Criteria andOverStandardIn(List<Boolean> values) {
            addCriterion("over_standard in", values, "overStandard");
            return (Criteria) this;
        }

        public Criteria andOverStandardNotIn(List<Boolean> values) {
            addCriterion("over_standard not in", values, "overStandard");
            return (Criteria) this;
        }

        public Criteria andOverStandardBetween(Boolean value1, Boolean value2) {
            addCriterion("over_standard between", value1, value2, "overStandard");
            return (Criteria) this;
        }

        public Criteria andOverStandardNotBetween(Boolean value1, Boolean value2) {
            addCriterion("over_standard not between", value1, value2, "overStandard");
            return (Criteria) this;
        }

        public Criteria andItemPkIsNull() {
            addCriterion("item_pk is null");
            return (Criteria) this;
        }

        public Criteria andItemPkIsNotNull() {
            addCriterion("item_pk is not null");
            return (Criteria) this;
        }

        public Criteria andItemPkEqualTo(String value) {
            addCriterion("item_pk =", value, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemPkNotEqualTo(String value) {
            addCriterion("item_pk <>", value, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemPkGreaterThan(String value) {
            addCriterion("item_pk >", value, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemPkGreaterThanOrEqualTo(String value) {
            addCriterion("item_pk >=", value, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemPkLessThan(String value) {
            addCriterion("item_pk <", value, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemPkLessThanOrEqualTo(String value) {
            addCriterion("item_pk <=", value, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemPkLike(String value) {
            addCriterion("item_pk like", value, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemPkNotLike(String value) {
            addCriterion("item_pk not like", value, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemPkIn(List<String> values) {
            addCriterion("item_pk in", values, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemPkNotIn(List<String> values) {
            addCriterion("item_pk not in", values, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemPkBetween(String value1, String value2) {
            addCriterion("item_pk between", value1, value2, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemPkNotBetween(String value1, String value2) {
            addCriterion("item_pk not between", value1, value2, "itemPk");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("item_name is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("item_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("item_name =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("item_name <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("item_name >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_name >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("item_name <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("item_name <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("item_name like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("item_name not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("item_name in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("item_name not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("item_name between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("item_name not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andSzitemPkIsNull() {
            addCriterion("szitem_pk is null");
            return (Criteria) this;
        }

        public Criteria andSzitemPkIsNotNull() {
            addCriterion("szitem_pk is not null");
            return (Criteria) this;
        }

        public Criteria andSzitemPkEqualTo(String value) {
            addCriterion("szitem_pk =", value, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemPkNotEqualTo(String value) {
            addCriterion("szitem_pk <>", value, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemPkGreaterThan(String value) {
            addCriterion("szitem_pk >", value, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemPkGreaterThanOrEqualTo(String value) {
            addCriterion("szitem_pk >=", value, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemPkLessThan(String value) {
            addCriterion("szitem_pk <", value, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemPkLessThanOrEqualTo(String value) {
            addCriterion("szitem_pk <=", value, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemPkLike(String value) {
            addCriterion("szitem_pk like", value, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemPkNotLike(String value) {
            addCriterion("szitem_pk not like", value, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemPkIn(List<String> values) {
            addCriterion("szitem_pk in", values, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemPkNotIn(List<String> values) {
            addCriterion("szitem_pk not in", values, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemPkBetween(String value1, String value2) {
            addCriterion("szitem_pk between", value1, value2, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemPkNotBetween(String value1, String value2) {
            addCriterion("szitem_pk not between", value1, value2, "szitemPk");
            return (Criteria) this;
        }

        public Criteria andSzitemNameIsNull() {
            addCriterion("szitem_name is null");
            return (Criteria) this;
        }

        public Criteria andSzitemNameIsNotNull() {
            addCriterion("szitem_name is not null");
            return (Criteria) this;
        }

        public Criteria andSzitemNameEqualTo(String value) {
            addCriterion("szitem_name =", value, "szitemName");
            return (Criteria) this;
        }

        public Criteria andSzitemNameNotEqualTo(String value) {
            addCriterion("szitem_name <>", value, "szitemName");
            return (Criteria) this;
        }

        public Criteria andSzitemNameGreaterThan(String value) {
            addCriterion("szitem_name >", value, "szitemName");
            return (Criteria) this;
        }

        public Criteria andSzitemNameGreaterThanOrEqualTo(String value) {
            addCriterion("szitem_name >=", value, "szitemName");
            return (Criteria) this;
        }

        public Criteria andSzitemNameLessThan(String value) {
            addCriterion("szitem_name <", value, "szitemName");
            return (Criteria) this;
        }

        public Criteria andSzitemNameLessThanOrEqualTo(String value) {
            addCriterion("szitem_name <=", value, "szitemName");
            return (Criteria) this;
        }

        public Criteria andSzitemNameLike(String value) {
            addCriterion("szitem_name like", value, "szitemName");
            return (Criteria) this;
        }

        public Criteria andSzitemNameNotLike(String value) {
            addCriterion("szitem_name not like", value, "szitemName");
            return (Criteria) this;
        }

        public Criteria andSzitemNameIn(List<String> values) {
            addCriterion("szitem_name in", values, "szitemName");
            return (Criteria) this;
        }

        public Criteria andSzitemNameNotIn(List<String> values) {
            addCriterion("szitem_name not in", values, "szitemName");
            return (Criteria) this;
        }

        public Criteria andSzitemNameBetween(String value1, String value2) {
            addCriterion("szitem_name between", value1, value2, "szitemName");
            return (Criteria) this;
        }

        public Criteria andSzitemNameNotBetween(String value1, String value2) {
            addCriterion("szitem_name not between", value1, value2, "szitemName");
            return (Criteria) this;
        }

        public Criteria andReductionAmountIsNull() {
            addCriterion("reduction_amount is null");
            return (Criteria) this;
        }

        public Criteria andReductionAmountIsNotNull() {
            addCriterion("reduction_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReductionAmountEqualTo(Double value) {
            addCriterion("reduction_amount =", value, "reductionAmount");
            return (Criteria) this;
        }

        public Criteria andReductionAmountNotEqualTo(Double value) {
            addCriterion("reduction_amount <>", value, "reductionAmount");
            return (Criteria) this;
        }

        public Criteria andReductionAmountGreaterThan(Double value) {
            addCriterion("reduction_amount >", value, "reductionAmount");
            return (Criteria) this;
        }

        public Criteria andReductionAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("reduction_amount >=", value, "reductionAmount");
            return (Criteria) this;
        }

        public Criteria andReductionAmountLessThan(Double value) {
            addCriterion("reduction_amount <", value, "reductionAmount");
            return (Criteria) this;
        }

        public Criteria andReductionAmountLessThanOrEqualTo(Double value) {
            addCriterion("reduction_amount <=", value, "reductionAmount");
            return (Criteria) this;
        }

        public Criteria andReductionAmountIn(List<Double> values) {
            addCriterion("reduction_amount in", values, "reductionAmount");
            return (Criteria) this;
        }

        public Criteria andReductionAmountNotIn(List<Double> values) {
            addCriterion("reduction_amount not in", values, "reductionAmount");
            return (Criteria) this;
        }

        public Criteria andReductionAmountBetween(Double value1, Double value2) {
            addCriterion("reduction_amount between", value1, value2, "reductionAmount");
            return (Criteria) this;
        }

        public Criteria andReductionAmountNotBetween(Double value1, Double value2) {
            addCriterion("reduction_amount not between", value1, value2, "reductionAmount");
            return (Criteria) this;
        }

        public Criteria andReductionInfoIsNull() {
            addCriterion("reduction_info is null");
            return (Criteria) this;
        }

        public Criteria andReductionInfoIsNotNull() {
            addCriterion("reduction_info is not null");
            return (Criteria) this;
        }

        public Criteria andReductionInfoEqualTo(String value) {
            addCriterion("reduction_info =", value, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionInfoNotEqualTo(String value) {
            addCriterion("reduction_info <>", value, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionInfoGreaterThan(String value) {
            addCriterion("reduction_info >", value, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionInfoGreaterThanOrEqualTo(String value) {
            addCriterion("reduction_info >=", value, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionInfoLessThan(String value) {
            addCriterion("reduction_info <", value, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionInfoLessThanOrEqualTo(String value) {
            addCriterion("reduction_info <=", value, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionInfoLike(String value) {
            addCriterion("reduction_info like", value, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionInfoNotLike(String value) {
            addCriterion("reduction_info not like", value, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionInfoIn(List<String> values) {
            addCriterion("reduction_info in", values, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionInfoNotIn(List<String> values) {
            addCriterion("reduction_info not in", values, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionInfoBetween(String value1, String value2) {
            addCriterion("reduction_info between", value1, value2, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionInfoNotBetween(String value1, String value2) {
            addCriterion("reduction_info not between", value1, value2, "reductionInfo");
            return (Criteria) this;
        }

        public Criteria andReductionTimeIsNull() {
            addCriterion("reduction_time is null");
            return (Criteria) this;
        }

        public Criteria andReductionTimeIsNotNull() {
            addCriterion("reduction_time is not null");
            return (Criteria) this;
        }

        public Criteria andReductionTimeEqualTo(Date value) {
            addCriterion("reduction_time =", value, "reductionTime");
            return (Criteria) this;
        }

        public Criteria andReductionTimeNotEqualTo(Date value) {
            addCriterion("reduction_time <>", value, "reductionTime");
            return (Criteria) this;
        }

        public Criteria andReductionTimeGreaterThan(Date value) {
            addCriterion("reduction_time >", value, "reductionTime");
            return (Criteria) this;
        }

        public Criteria andReductionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reduction_time >=", value, "reductionTime");
            return (Criteria) this;
        }

        public Criteria andReductionTimeLessThan(Date value) {
            addCriterion("reduction_time <", value, "reductionTime");
            return (Criteria) this;
        }

        public Criteria andReductionTimeLessThanOrEqualTo(Date value) {
            addCriterion("reduction_time <=", value, "reductionTime");
            return (Criteria) this;
        }

        public Criteria andReductionTimeIn(List<Date> values) {
            addCriterion("reduction_time in", values, "reductionTime");
            return (Criteria) this;
        }

        public Criteria andReductionTimeNotIn(List<Date> values) {
            addCriterion("reduction_time not in", values, "reductionTime");
            return (Criteria) this;
        }

        public Criteria andReductionTimeBetween(Date value1, Date value2) {
            addCriterion("reduction_time between", value1, value2, "reductionTime");
            return (Criteria) this;
        }

        public Criteria andReductionTimeNotBetween(Date value1, Date value2) {
            addCriterion("reduction_time not between", value1, value2, "reductionTime");
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