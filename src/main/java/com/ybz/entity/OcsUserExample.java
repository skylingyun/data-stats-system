package com.ybz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OcsUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OcsUserExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
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

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIsNull() {
            addCriterion("registerdate is null");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIsNotNull() {
            addCriterion("registerdate is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterdateEqualTo(Date value) {
            addCriterion("registerdate =", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotEqualTo(Date value) {
            addCriterion("registerdate <>", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateGreaterThan(Date value) {
            addCriterion("registerdate >", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateGreaterThanOrEqualTo(Date value) {
            addCriterion("registerdate >=", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateLessThan(Date value) {
            addCriterion("registerdate <", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateLessThanOrEqualTo(Date value) {
            addCriterion("registerdate <=", value, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateIn(List<Date> values) {
            addCriterion("registerdate in", values, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotIn(List<Date> values) {
            addCriterion("registerdate not in", values, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateBetween(Date value1, Date value2) {
            addCriterion("registerdate between", value1, value2, "registerdate");
            return (Criteria) this;
        }

        public Criteria andRegisterdateNotBetween(Date value1, Date value2) {
            addCriterion("registerdate not between", value1, value2, "registerdate");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andTelnumIsNull() {
            addCriterion("telnum is null");
            return (Criteria) this;
        }

        public Criteria andTelnumIsNotNull() {
            addCriterion("telnum is not null");
            return (Criteria) this;
        }

        public Criteria andTelnumEqualTo(String value) {
            addCriterion("telnum =", value, "telnum");
            return (Criteria) this;
        }

        public Criteria andTelnumNotEqualTo(String value) {
            addCriterion("telnum <>", value, "telnum");
            return (Criteria) this;
        }

        public Criteria andTelnumGreaterThan(String value) {
            addCriterion("telnum >", value, "telnum");
            return (Criteria) this;
        }

        public Criteria andTelnumGreaterThanOrEqualTo(String value) {
            addCriterion("telnum >=", value, "telnum");
            return (Criteria) this;
        }

        public Criteria andTelnumLessThan(String value) {
            addCriterion("telnum <", value, "telnum");
            return (Criteria) this;
        }

        public Criteria andTelnumLessThanOrEqualTo(String value) {
            addCriterion("telnum <=", value, "telnum");
            return (Criteria) this;
        }

        public Criteria andTelnumLike(String value) {
            addCriterion("telnum like", value, "telnum");
            return (Criteria) this;
        }

        public Criteria andTelnumNotLike(String value) {
            addCriterion("telnum not like", value, "telnum");
            return (Criteria) this;
        }

        public Criteria andTelnumIn(List<String> values) {
            addCriterion("telnum in", values, "telnum");
            return (Criteria) this;
        }

        public Criteria andTelnumNotIn(List<String> values) {
            addCriterion("telnum not in", values, "telnum");
            return (Criteria) this;
        }

        public Criteria andTelnumBetween(String value1, String value2) {
            addCriterion("telnum between", value1, value2, "telnum");
            return (Criteria) this;
        }

        public Criteria andTelnumNotBetween(String value1, String value2) {
            addCriterion("telnum not between", value1, value2, "telnum");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNull() {
            addCriterion("avatar is null");
            return (Criteria) this;
        }

        public Criteria andAvatarIsNotNull() {
            addCriterion("avatar is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarEqualTo(String value) {
            addCriterion("avatar =", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotEqualTo(String value) {
            addCriterion("avatar <>", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThan(String value) {
            addCriterion("avatar >", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("avatar >=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThan(String value) {
            addCriterion("avatar <", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLessThanOrEqualTo(String value) {
            addCriterion("avatar <=", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarLike(String value) {
            addCriterion("avatar like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotLike(String value) {
            addCriterion("avatar not like", value, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarIn(List<String> values) {
            addCriterion("avatar in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotIn(List<String> values) {
            addCriterion("avatar not in", values, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarBetween(String value1, String value2) {
            addCriterion("avatar between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAvatarNotBetween(String value1, String value2) {
            addCriterion("avatar not between", value1, value2, "avatar");
            return (Criteria) this;
        }

        public Criteria andAssociationIsNull() {
            addCriterion("association is null");
            return (Criteria) this;
        }

        public Criteria andAssociationIsNotNull() {
            addCriterion("association is not null");
            return (Criteria) this;
        }

        public Criteria andAssociationEqualTo(String value) {
            addCriterion("association =", value, "association");
            return (Criteria) this;
        }

        public Criteria andAssociationNotEqualTo(String value) {
            addCriterion("association <>", value, "association");
            return (Criteria) this;
        }

        public Criteria andAssociationGreaterThan(String value) {
            addCriterion("association >", value, "association");
            return (Criteria) this;
        }

        public Criteria andAssociationGreaterThanOrEqualTo(String value) {
            addCriterion("association >=", value, "association");
            return (Criteria) this;
        }

        public Criteria andAssociationLessThan(String value) {
            addCriterion("association <", value, "association");
            return (Criteria) this;
        }

        public Criteria andAssociationLessThanOrEqualTo(String value) {
            addCriterion("association <=", value, "association");
            return (Criteria) this;
        }

        public Criteria andAssociationLike(String value) {
            addCriterion("association like", value, "association");
            return (Criteria) this;
        }

        public Criteria andAssociationNotLike(String value) {
            addCriterion("association not like", value, "association");
            return (Criteria) this;
        }

        public Criteria andAssociationIn(List<String> values) {
            addCriterion("association in", values, "association");
            return (Criteria) this;
        }

        public Criteria andAssociationNotIn(List<String> values) {
            addCriterion("association not in", values, "association");
            return (Criteria) this;
        }

        public Criteria andAssociationBetween(String value1, String value2) {
            addCriterion("association between", value1, value2, "association");
            return (Criteria) this;
        }

        public Criteria andAssociationNotBetween(String value1, String value2) {
            addCriterion("association not between", value1, value2, "association");
            return (Criteria) this;
        }

        public Criteria andDeptpkIsNull() {
            addCriterion("deptpk is null");
            return (Criteria) this;
        }

        public Criteria andDeptpkIsNotNull() {
            addCriterion("deptpk is not null");
            return (Criteria) this;
        }

        public Criteria andDeptpkEqualTo(String value) {
            addCriterion("deptpk =", value, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptpkNotEqualTo(String value) {
            addCriterion("deptpk <>", value, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptpkGreaterThan(String value) {
            addCriterion("deptpk >", value, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptpkGreaterThanOrEqualTo(String value) {
            addCriterion("deptpk >=", value, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptpkLessThan(String value) {
            addCriterion("deptpk <", value, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptpkLessThanOrEqualTo(String value) {
            addCriterion("deptpk <=", value, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptpkLike(String value) {
            addCriterion("deptpk like", value, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptpkNotLike(String value) {
            addCriterion("deptpk not like", value, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptpkIn(List<String> values) {
            addCriterion("deptpk in", values, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptpkNotIn(List<String> values) {
            addCriterion("deptpk not in", values, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptpkBetween(String value1, String value2) {
            addCriterion("deptpk between", value1, value2, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptpkNotBetween(String value1, String value2) {
            addCriterion("deptpk not between", value1, value2, "deptpk");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNull() {
            addCriterion("deptname is null");
            return (Criteria) this;
        }

        public Criteria andDeptnameIsNotNull() {
            addCriterion("deptname is not null");
            return (Criteria) this;
        }

        public Criteria andDeptnameEqualTo(String value) {
            addCriterion("deptname =", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotEqualTo(String value) {
            addCriterion("deptname <>", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThan(String value) {
            addCriterion("deptname >", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameGreaterThanOrEqualTo(String value) {
            addCriterion("deptname >=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThan(String value) {
            addCriterion("deptname <", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLessThanOrEqualTo(String value) {
            addCriterion("deptname <=", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameLike(String value) {
            addCriterion("deptname like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotLike(String value) {
            addCriterion("deptname not like", value, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameIn(List<String> values) {
            addCriterion("deptname in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotIn(List<String> values) {
            addCriterion("deptname not in", values, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameBetween(String value1, String value2) {
            addCriterion("deptname between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andDeptnameNotBetween(String value1, String value2) {
            addCriterion("deptname not between", value1, value2, "deptname");
            return (Criteria) this;
        }

        public Criteria andUserCodeIsNull() {
            addCriterion("user_code is null");
            return (Criteria) this;
        }

        public Criteria andUserCodeIsNotNull() {
            addCriterion("user_code is not null");
            return (Criteria) this;
        }

        public Criteria andUserCodeEqualTo(String value) {
            addCriterion("user_code =", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotEqualTo(String value) {
            addCriterion("user_code <>", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThan(String value) {
            addCriterion("user_code >", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeGreaterThanOrEqualTo(String value) {
            addCriterion("user_code >=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThan(String value) {
            addCriterion("user_code <", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLessThanOrEqualTo(String value) {
            addCriterion("user_code <=", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeLike(String value) {
            addCriterion("user_code like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotLike(String value) {
            addCriterion("user_code not like", value, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeIn(List<String> values) {
            addCriterion("user_code in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotIn(List<String> values) {
            addCriterion("user_code not in", values, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeBetween(String value1, String value2) {
            addCriterion("user_code between", value1, value2, "userCode");
            return (Criteria) this;
        }

        public Criteria andUserCodeNotBetween(String value1, String value2) {
            addCriterion("user_code not between", value1, value2, "userCode");
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

        public Criteria andDrIsNull() {
            addCriterion("dr is null");
            return (Criteria) this;
        }

        public Criteria andDrIsNotNull() {
            addCriterion("dr is not null");
            return (Criteria) this;
        }

        public Criteria andDrEqualTo(Boolean value) {
            addCriterion("dr =", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotEqualTo(Boolean value) {
            addCriterion("dr <>", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrGreaterThan(Boolean value) {
            addCriterion("dr >", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrGreaterThanOrEqualTo(Boolean value) {
            addCriterion("dr >=", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrLessThan(Boolean value) {
            addCriterion("dr <", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrLessThanOrEqualTo(Boolean value) {
            addCriterion("dr <=", value, "dr");
            return (Criteria) this;
        }

        public Criteria andDrIn(List<Boolean> values) {
            addCriterion("dr in", values, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotIn(List<Boolean> values) {
            addCriterion("dr not in", values, "dr");
            return (Criteria) this;
        }

        public Criteria andDrBetween(Boolean value1, Boolean value2) {
            addCriterion("dr between", value1, value2, "dr");
            return (Criteria) this;
        }

        public Criteria andDrNotBetween(Boolean value1, Boolean value2) {
            addCriterion("dr not between", value1, value2, "dr");
            return (Criteria) this;
        }

        public Criteria andPostpkIsNull() {
            addCriterion("postpk is null");
            return (Criteria) this;
        }

        public Criteria andPostpkIsNotNull() {
            addCriterion("postpk is not null");
            return (Criteria) this;
        }

        public Criteria andPostpkEqualTo(String value) {
            addCriterion("postpk =", value, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostpkNotEqualTo(String value) {
            addCriterion("postpk <>", value, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostpkGreaterThan(String value) {
            addCriterion("postpk >", value, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostpkGreaterThanOrEqualTo(String value) {
            addCriterion("postpk >=", value, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostpkLessThan(String value) {
            addCriterion("postpk <", value, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostpkLessThanOrEqualTo(String value) {
            addCriterion("postpk <=", value, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostpkLike(String value) {
            addCriterion("postpk like", value, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostpkNotLike(String value) {
            addCriterion("postpk not like", value, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostpkIn(List<String> values) {
            addCriterion("postpk in", values, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostpkNotIn(List<String> values) {
            addCriterion("postpk not in", values, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostpkBetween(String value1, String value2) {
            addCriterion("postpk between", value1, value2, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostpkNotBetween(String value1, String value2) {
            addCriterion("postpk not between", value1, value2, "postpk");
            return (Criteria) this;
        }

        public Criteria andPostnameIsNull() {
            addCriterion("postname is null");
            return (Criteria) this;
        }

        public Criteria andPostnameIsNotNull() {
            addCriterion("postname is not null");
            return (Criteria) this;
        }

        public Criteria andPostnameEqualTo(String value) {
            addCriterion("postname =", value, "postname");
            return (Criteria) this;
        }

        public Criteria andPostnameNotEqualTo(String value) {
            addCriterion("postname <>", value, "postname");
            return (Criteria) this;
        }

        public Criteria andPostnameGreaterThan(String value) {
            addCriterion("postname >", value, "postname");
            return (Criteria) this;
        }

        public Criteria andPostnameGreaterThanOrEqualTo(String value) {
            addCriterion("postname >=", value, "postname");
            return (Criteria) this;
        }

        public Criteria andPostnameLessThan(String value) {
            addCriterion("postname <", value, "postname");
            return (Criteria) this;
        }

        public Criteria andPostnameLessThanOrEqualTo(String value) {
            addCriterion("postname <=", value, "postname");
            return (Criteria) this;
        }

        public Criteria andPostnameLike(String value) {
            addCriterion("postname like", value, "postname");
            return (Criteria) this;
        }

        public Criteria andPostnameNotLike(String value) {
            addCriterion("postname not like", value, "postname");
            return (Criteria) this;
        }

        public Criteria andPostnameIn(List<String> values) {
            addCriterion("postname in", values, "postname");
            return (Criteria) this;
        }

        public Criteria andPostnameNotIn(List<String> values) {
            addCriterion("postname not in", values, "postname");
            return (Criteria) this;
        }

        public Criteria andPostnameBetween(String value1, String value2) {
            addCriterion("postname between", value1, value2, "postname");
            return (Criteria) this;
        }

        public Criteria andPostnameNotBetween(String value1, String value2) {
            addCriterion("postname not between", value1, value2, "postname");
            return (Criteria) this;
        }

        public Criteria andRankpkIsNull() {
            addCriterion("rankpk is null");
            return (Criteria) this;
        }

        public Criteria andRankpkIsNotNull() {
            addCriterion("rankpk is not null");
            return (Criteria) this;
        }

        public Criteria andRankpkEqualTo(String value) {
            addCriterion("rankpk =", value, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRankpkNotEqualTo(String value) {
            addCriterion("rankpk <>", value, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRankpkGreaterThan(String value) {
            addCriterion("rankpk >", value, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRankpkGreaterThanOrEqualTo(String value) {
            addCriterion("rankpk >=", value, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRankpkLessThan(String value) {
            addCriterion("rankpk <", value, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRankpkLessThanOrEqualTo(String value) {
            addCriterion("rankpk <=", value, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRankpkLike(String value) {
            addCriterion("rankpk like", value, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRankpkNotLike(String value) {
            addCriterion("rankpk not like", value, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRankpkIn(List<String> values) {
            addCriterion("rankpk in", values, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRankpkNotIn(List<String> values) {
            addCriterion("rankpk not in", values, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRankpkBetween(String value1, String value2) {
            addCriterion("rankpk between", value1, value2, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRankpkNotBetween(String value1, String value2) {
            addCriterion("rankpk not between", value1, value2, "rankpk");
            return (Criteria) this;
        }

        public Criteria andRanknameIsNull() {
            addCriterion("rankname is null");
            return (Criteria) this;
        }

        public Criteria andRanknameIsNotNull() {
            addCriterion("rankname is not null");
            return (Criteria) this;
        }

        public Criteria andRanknameEqualTo(String value) {
            addCriterion("rankname =", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameNotEqualTo(String value) {
            addCriterion("rankname <>", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameGreaterThan(String value) {
            addCriterion("rankname >", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameGreaterThanOrEqualTo(String value) {
            addCriterion("rankname >=", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameLessThan(String value) {
            addCriterion("rankname <", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameLessThanOrEqualTo(String value) {
            addCriterion("rankname <=", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameLike(String value) {
            addCriterion("rankname like", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameNotLike(String value) {
            addCriterion("rankname not like", value, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameIn(List<String> values) {
            addCriterion("rankname in", values, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameNotIn(List<String> values) {
            addCriterion("rankname not in", values, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameBetween(String value1, String value2) {
            addCriterion("rankname between", value1, value2, "rankname");
            return (Criteria) this;
        }

        public Criteria andRanknameNotBetween(String value1, String value2) {
            addCriterion("rankname not between", value1, value2, "rankname");
            return (Criteria) this;
        }

        public Criteria andDeptcodeIsNull() {
            addCriterion("deptcode is null");
            return (Criteria) this;
        }

        public Criteria andDeptcodeIsNotNull() {
            addCriterion("deptcode is not null");
            return (Criteria) this;
        }

        public Criteria andDeptcodeEqualTo(String value) {
            addCriterion("deptcode =", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotEqualTo(String value) {
            addCriterion("deptcode <>", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeGreaterThan(String value) {
            addCriterion("deptcode >", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeGreaterThanOrEqualTo(String value) {
            addCriterion("deptcode >=", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeLessThan(String value) {
            addCriterion("deptcode <", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeLessThanOrEqualTo(String value) {
            addCriterion("deptcode <=", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeLike(String value) {
            addCriterion("deptcode like", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotLike(String value) {
            addCriterion("deptcode not like", value, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeIn(List<String> values) {
            addCriterion("deptcode in", values, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotIn(List<String> values) {
            addCriterion("deptcode not in", values, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeBetween(String value1, String value2) {
            addCriterion("deptcode between", value1, value2, "deptcode");
            return (Criteria) this;
        }

        public Criteria andDeptcodeNotBetween(String value1, String value2) {
            addCriterion("deptcode not between", value1, value2, "deptcode");
            return (Criteria) this;
        }

        public Criteria andPersonidIsNull() {
            addCriterion("personId is null");
            return (Criteria) this;
        }

        public Criteria andPersonidIsNotNull() {
            addCriterion("personId is not null");
            return (Criteria) this;
        }

        public Criteria andPersonidEqualTo(String value) {
            addCriterion("personId =", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidNotEqualTo(String value) {
            addCriterion("personId <>", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidGreaterThan(String value) {
            addCriterion("personId >", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidGreaterThanOrEqualTo(String value) {
            addCriterion("personId >=", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidLessThan(String value) {
            addCriterion("personId <", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidLessThanOrEqualTo(String value) {
            addCriterion("personId <=", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidLike(String value) {
            addCriterion("personId like", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidNotLike(String value) {
            addCriterion("personId not like", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidIn(List<String> values) {
            addCriterion("personId in", values, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidNotIn(List<String> values) {
            addCriterion("personId not in", values, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidBetween(String value1, String value2) {
            addCriterion("personId between", value1, value2, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidNotBetween(String value1, String value2) {
            addCriterion("personId not between", value1, value2, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonnameIsNull() {
            addCriterion("personName is null");
            return (Criteria) this;
        }

        public Criteria andPersonnameIsNotNull() {
            addCriterion("personName is not null");
            return (Criteria) this;
        }

        public Criteria andPersonnameEqualTo(String value) {
            addCriterion("personName =", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonnameNotEqualTo(String value) {
            addCriterion("personName <>", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonnameGreaterThan(String value) {
            addCriterion("personName >", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonnameGreaterThanOrEqualTo(String value) {
            addCriterion("personName >=", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonnameLessThan(String value) {
            addCriterion("personName <", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonnameLessThanOrEqualTo(String value) {
            addCriterion("personName <=", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonnameLike(String value) {
            addCriterion("personName like", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonnameNotLike(String value) {
            addCriterion("personName not like", value, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonnameIn(List<String> values) {
            addCriterion("personName in", values, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonnameNotIn(List<String> values) {
            addCriterion("personName not in", values, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonnameBetween(String value1, String value2) {
            addCriterion("personName between", value1, value2, "personname");
            return (Criteria) this;
        }

        public Criteria andPersonnameNotBetween(String value1, String value2) {
            addCriterion("personName not between", value1, value2, "personname");
            return (Criteria) this;
        }

        public Criteria andOrgpkIsNull() {
            addCriterion("orgpk is null");
            return (Criteria) this;
        }

        public Criteria andOrgpkIsNotNull() {
            addCriterion("orgpk is not null");
            return (Criteria) this;
        }

        public Criteria andOrgpkEqualTo(String value) {
            addCriterion("orgpk =", value, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgpkNotEqualTo(String value) {
            addCriterion("orgpk <>", value, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgpkGreaterThan(String value) {
            addCriterion("orgpk >", value, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgpkGreaterThanOrEqualTo(String value) {
            addCriterion("orgpk >=", value, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgpkLessThan(String value) {
            addCriterion("orgpk <", value, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgpkLessThanOrEqualTo(String value) {
            addCriterion("orgpk <=", value, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgpkLike(String value) {
            addCriterion("orgpk like", value, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgpkNotLike(String value) {
            addCriterion("orgpk not like", value, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgpkIn(List<String> values) {
            addCriterion("orgpk in", values, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgpkNotIn(List<String> values) {
            addCriterion("orgpk not in", values, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgpkBetween(String value1, String value2) {
            addCriterion("orgpk between", value1, value2, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgpkNotBetween(String value1, String value2) {
            addCriterion("orgpk not between", value1, value2, "orgpk");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNull() {
            addCriterion("orgname is null");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNotNull() {
            addCriterion("orgname is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnameEqualTo(String value) {
            addCriterion("orgname =", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotEqualTo(String value) {
            addCriterion("orgname <>", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThan(String value) {
            addCriterion("orgname >", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("orgname >=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThan(String value) {
            addCriterion("orgname <", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThanOrEqualTo(String value) {
            addCriterion("orgname <=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLike(String value) {
            addCriterion("orgname like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotLike(String value) {
            addCriterion("orgname not like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameIn(List<String> values) {
            addCriterion("orgname in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotIn(List<String> values) {
            addCriterion("orgname not in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameBetween(String value1, String value2) {
            addCriterion("orgname between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotBetween(String value1, String value2) {
            addCriterion("orgname not between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidIsNull() {
            addCriterion("financeOrgId is null");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidIsNotNull() {
            addCriterion("financeOrgId is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidEqualTo(String value) {
            addCriterion("financeOrgId =", value, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidNotEqualTo(String value) {
            addCriterion("financeOrgId <>", value, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidGreaterThan(String value) {
            addCriterion("financeOrgId >", value, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidGreaterThanOrEqualTo(String value) {
            addCriterion("financeOrgId >=", value, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidLessThan(String value) {
            addCriterion("financeOrgId <", value, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidLessThanOrEqualTo(String value) {
            addCriterion("financeOrgId <=", value, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidLike(String value) {
            addCriterion("financeOrgId like", value, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidNotLike(String value) {
            addCriterion("financeOrgId not like", value, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidIn(List<String> values) {
            addCriterion("financeOrgId in", values, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidNotIn(List<String> values) {
            addCriterion("financeOrgId not in", values, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidBetween(String value1, String value2) {
            addCriterion("financeOrgId between", value1, value2, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgidNotBetween(String value1, String value2) {
            addCriterion("financeOrgId not between", value1, value2, "financeorgid");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameIsNull() {
            addCriterion("financeOrgName is null");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameIsNotNull() {
            addCriterion("financeOrgName is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameEqualTo(String value) {
            addCriterion("financeOrgName =", value, "financeorgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameNotEqualTo(String value) {
            addCriterion("financeOrgName <>", value, "financeorgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameGreaterThan(String value) {
            addCriterion("financeOrgName >", value, "financeorgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameGreaterThanOrEqualTo(String value) {
            addCriterion("financeOrgName >=", value, "financeorgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameLessThan(String value) {
            addCriterion("financeOrgName <", value, "financeorgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameLessThanOrEqualTo(String value) {
            addCriterion("financeOrgName <=", value, "financeorgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameLike(String value) {
            addCriterion("financeOrgName like", value, "financeorgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameNotLike(String value) {
            addCriterion("financeOrgName not like", value, "financeorgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameIn(List<String> values) {
            addCriterion("financeOrgName in", values, "financeorgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameNotIn(List<String> values) {
            addCriterion("financeOrgName not in", values, "financeorgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameBetween(String value1, String value2) {
            addCriterion("financeOrgName between", value1, value2, "financeorgname");
            return (Criteria) this;
        }

        public Criteria andFinanceorgnameNotBetween(String value1, String value2) {
            addCriterion("financeOrgName not between", value1, value2, "financeorgname");
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