package com.ybz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysTenantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysTenantExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andTenantNameIsNull() {
            addCriterion("tenant_name is null");
            return (Criteria) this;
        }

        public Criteria andTenantNameIsNotNull() {
            addCriterion("tenant_name is not null");
            return (Criteria) this;
        }

        public Criteria andTenantNameEqualTo(String value) {
            addCriterion("tenant_name =", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameNotEqualTo(String value) {
            addCriterion("tenant_name <>", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameGreaterThan(String value) {
            addCriterion("tenant_name >", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_name >=", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameLessThan(String value) {
            addCriterion("tenant_name <", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameLessThanOrEqualTo(String value) {
            addCriterion("tenant_name <=", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameLike(String value) {
            addCriterion("tenant_name like", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameNotLike(String value) {
            addCriterion("tenant_name not like", value, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameIn(List<String> values) {
            addCriterion("tenant_name in", values, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameNotIn(List<String> values) {
            addCriterion("tenant_name not in", values, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameBetween(String value1, String value2) {
            addCriterion("tenant_name between", value1, value2, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantNameNotBetween(String value1, String value2) {
            addCriterion("tenant_name not between", value1, value2, "tenantName");
            return (Criteria) this;
        }

        public Criteria andTenantCodeIsNull() {
            addCriterion("tenant_code is null");
            return (Criteria) this;
        }

        public Criteria andTenantCodeIsNotNull() {
            addCriterion("tenant_code is not null");
            return (Criteria) this;
        }

        public Criteria andTenantCodeEqualTo(String value) {
            addCriterion("tenant_code =", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotEqualTo(String value) {
            addCriterion("tenant_code <>", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeGreaterThan(String value) {
            addCriterion("tenant_code >", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_code >=", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLessThan(String value) {
            addCriterion("tenant_code <", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLessThanOrEqualTo(String value) {
            addCriterion("tenant_code <=", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeLike(String value) {
            addCriterion("tenant_code like", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotLike(String value) {
            addCriterion("tenant_code not like", value, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeIn(List<String> values) {
            addCriterion("tenant_code in", values, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotIn(List<String> values) {
            addCriterion("tenant_code not in", values, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeBetween(String value1, String value2) {
            addCriterion("tenant_code between", value1, value2, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantCodeNotBetween(String value1, String value2) {
            addCriterion("tenant_code not between", value1, value2, "tenantCode");
            return (Criteria) this;
        }

        public Criteria andTenantAddressIsNull() {
            addCriterion("tenant_address is null");
            return (Criteria) this;
        }

        public Criteria andTenantAddressIsNotNull() {
            addCriterion("tenant_address is not null");
            return (Criteria) this;
        }

        public Criteria andTenantAddressEqualTo(String value) {
            addCriterion("tenant_address =", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressNotEqualTo(String value) {
            addCriterion("tenant_address <>", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressGreaterThan(String value) {
            addCriterion("tenant_address >", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_address >=", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressLessThan(String value) {
            addCriterion("tenant_address <", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressLessThanOrEqualTo(String value) {
            addCriterion("tenant_address <=", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressLike(String value) {
            addCriterion("tenant_address like", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressNotLike(String value) {
            addCriterion("tenant_address not like", value, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressIn(List<String> values) {
            addCriterion("tenant_address in", values, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressNotIn(List<String> values) {
            addCriterion("tenant_address not in", values, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressBetween(String value1, String value2) {
            addCriterion("tenant_address between", value1, value2, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantAddressNotBetween(String value1, String value2) {
            addCriterion("tenant_address not between", value1, value2, "tenantAddress");
            return (Criteria) this;
        }

        public Criteria andTenantTelIsNull() {
            addCriterion("tenant_tel is null");
            return (Criteria) this;
        }

        public Criteria andTenantTelIsNotNull() {
            addCriterion("tenant_tel is not null");
            return (Criteria) this;
        }

        public Criteria andTenantTelEqualTo(String value) {
            addCriterion("tenant_tel =", value, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantTelNotEqualTo(String value) {
            addCriterion("tenant_tel <>", value, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantTelGreaterThan(String value) {
            addCriterion("tenant_tel >", value, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantTelGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_tel >=", value, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantTelLessThan(String value) {
            addCriterion("tenant_tel <", value, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantTelLessThanOrEqualTo(String value) {
            addCriterion("tenant_tel <=", value, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantTelLike(String value) {
            addCriterion("tenant_tel like", value, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantTelNotLike(String value) {
            addCriterion("tenant_tel not like", value, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantTelIn(List<String> values) {
            addCriterion("tenant_tel in", values, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantTelNotIn(List<String> values) {
            addCriterion("tenant_tel not in", values, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantTelBetween(String value1, String value2) {
            addCriterion("tenant_tel between", value1, value2, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantTelNotBetween(String value1, String value2) {
            addCriterion("tenant_tel not between", value1, value2, "tenantTel");
            return (Criteria) this;
        }

        public Criteria andTenantEmailIsNull() {
            addCriterion("tenant_email is null");
            return (Criteria) this;
        }

        public Criteria andTenantEmailIsNotNull() {
            addCriterion("tenant_email is not null");
            return (Criteria) this;
        }

        public Criteria andTenantEmailEqualTo(String value) {
            addCriterion("tenant_email =", value, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantEmailNotEqualTo(String value) {
            addCriterion("tenant_email <>", value, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantEmailGreaterThan(String value) {
            addCriterion("tenant_email >", value, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantEmailGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_email >=", value, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantEmailLessThan(String value) {
            addCriterion("tenant_email <", value, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantEmailLessThanOrEqualTo(String value) {
            addCriterion("tenant_email <=", value, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantEmailLike(String value) {
            addCriterion("tenant_email like", value, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantEmailNotLike(String value) {
            addCriterion("tenant_email not like", value, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantEmailIn(List<String> values) {
            addCriterion("tenant_email in", values, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantEmailNotIn(List<String> values) {
            addCriterion("tenant_email not in", values, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantEmailBetween(String value1, String value2) {
            addCriterion("tenant_email between", value1, value2, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantEmailNotBetween(String value1, String value2) {
            addCriterion("tenant_email not between", value1, value2, "tenantEmail");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameIsNull() {
            addCriterion("tenant_fullname is null");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameIsNotNull() {
            addCriterion("tenant_fullname is not null");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameEqualTo(String value) {
            addCriterion("tenant_fullname =", value, "tenantFullname");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameNotEqualTo(String value) {
            addCriterion("tenant_fullname <>", value, "tenantFullname");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameGreaterThan(String value) {
            addCriterion("tenant_fullname >", value, "tenantFullname");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameGreaterThanOrEqualTo(String value) {
            addCriterion("tenant_fullname >=", value, "tenantFullname");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameLessThan(String value) {
            addCriterion("tenant_fullname <", value, "tenantFullname");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameLessThanOrEqualTo(String value) {
            addCriterion("tenant_fullname <=", value, "tenantFullname");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameLike(String value) {
            addCriterion("tenant_fullname like", value, "tenantFullname");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameNotLike(String value) {
            addCriterion("tenant_fullname not like", value, "tenantFullname");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameIn(List<String> values) {
            addCriterion("tenant_fullname in", values, "tenantFullname");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameNotIn(List<String> values) {
            addCriterion("tenant_fullname not in", values, "tenantFullname");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameBetween(String value1, String value2) {
            addCriterion("tenant_fullname between", value1, value2, "tenantFullname");
            return (Criteria) this;
        }

        public Criteria andTenantFullnameNotBetween(String value1, String value2) {
            addCriterion("tenant_fullname not between", value1, value2, "tenantFullname");
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