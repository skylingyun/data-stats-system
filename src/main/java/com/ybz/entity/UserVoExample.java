package com.ybz.entity;

import java.util.ArrayList;
import java.util.List;

public class UserVoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserVoExample() {
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

        public Criteria andUserEmailIsNull() {
            addCriterion("user_email is null");
            return (Criteria) this;
        }

        public Criteria andUserEmailIsNotNull() {
            addCriterion("user_email is not null");
            return (Criteria) this;
        }

        public Criteria andUserEmailEqualTo(String value) {
            addCriterion("user_email =", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotEqualTo(String value) {
            addCriterion("user_email <>", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThan(String value) {
            addCriterion("user_email >", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailGreaterThanOrEqualTo(String value) {
            addCriterion("user_email >=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThan(String value) {
            addCriterion("user_email <", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLessThanOrEqualTo(String value) {
            addCriterion("user_email <=", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailLike(String value) {
            addCriterion("user_email like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotLike(String value) {
            addCriterion("user_email not like", value, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailIn(List<String> values) {
            addCriterion("user_email in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotIn(List<String> values) {
            addCriterion("user_email not in", values, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailBetween(String value1, String value2) {
            addCriterion("user_email between", value1, value2, "userEmail");
            return (Criteria) this;
        }

        public Criteria andUserEmailNotBetween(String value1, String value2) {
            addCriterion("user_email not between", value1, value2, "userEmail");
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

        public Criteria andUserAvatorIsNull() {
            addCriterion("user_avator is null");
            return (Criteria) this;
        }

        public Criteria andUserAvatorIsNotNull() {
            addCriterion("user_avator is not null");
            return (Criteria) this;
        }

        public Criteria andUserAvatorEqualTo(String value) {
            addCriterion("user_avator =", value, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserAvatorNotEqualTo(String value) {
            addCriterion("user_avator <>", value, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserAvatorGreaterThan(String value) {
            addCriterion("user_avator >", value, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserAvatorGreaterThanOrEqualTo(String value) {
            addCriterion("user_avator >=", value, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserAvatorLessThan(String value) {
            addCriterion("user_avator <", value, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserAvatorLessThanOrEqualTo(String value) {
            addCriterion("user_avator <=", value, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserAvatorLike(String value) {
            addCriterion("user_avator like", value, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserAvatorNotLike(String value) {
            addCriterion("user_avator not like", value, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserAvatorIn(List<String> values) {
            addCriterion("user_avator in", values, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserAvatorNotIn(List<String> values) {
            addCriterion("user_avator not in", values, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserAvatorBetween(String value1, String value2) {
            addCriterion("user_avator between", value1, value2, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserAvatorNotBetween(String value1, String value2) {
            addCriterion("user_avator not between", value1, value2, "userAvator");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNull() {
            addCriterion("user_mobile is null");
            return (Criteria) this;
        }

        public Criteria andUserMobileIsNotNull() {
            addCriterion("user_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andUserMobileEqualTo(String value) {
            addCriterion("user_mobile =", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotEqualTo(String value) {
            addCriterion("user_mobile <>", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThan(String value) {
            addCriterion("user_mobile >", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileGreaterThanOrEqualTo(String value) {
            addCriterion("user_mobile >=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThan(String value) {
            addCriterion("user_mobile <", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLessThanOrEqualTo(String value) {
            addCriterion("user_mobile <=", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileLike(String value) {
            addCriterion("user_mobile like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotLike(String value) {
            addCriterion("user_mobile not like", value, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileIn(List<String> values) {
            addCriterion("user_mobile in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotIn(List<String> values) {
            addCriterion("user_mobile not in", values, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileBetween(String value1, String value2) {
            addCriterion("user_mobile between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andUserMobileNotBetween(String value1, String value2) {
            addCriterion("user_mobile not between", value1, value2, "userMobile");
            return (Criteria) this;
        }

        public Criteria andNeedMergeIsNull() {
            addCriterion("need_merge is null");
            return (Criteria) this;
        }

        public Criteria andNeedMergeIsNotNull() {
            addCriterion("need_merge is not null");
            return (Criteria) this;
        }

        public Criteria andNeedMergeEqualTo(String value) {
            addCriterion("need_merge =", value, "needMerge");
            return (Criteria) this;
        }

        public Criteria andNeedMergeNotEqualTo(String value) {
            addCriterion("need_merge <>", value, "needMerge");
            return (Criteria) this;
        }

        public Criteria andNeedMergeGreaterThan(String value) {
            addCriterion("need_merge >", value, "needMerge");
            return (Criteria) this;
        }

        public Criteria andNeedMergeGreaterThanOrEqualTo(String value) {
            addCriterion("need_merge >=", value, "needMerge");
            return (Criteria) this;
        }

        public Criteria andNeedMergeLessThan(String value) {
            addCriterion("need_merge <", value, "needMerge");
            return (Criteria) this;
        }

        public Criteria andNeedMergeLessThanOrEqualTo(String value) {
            addCriterion("need_merge <=", value, "needMerge");
            return (Criteria) this;
        }

        public Criteria andNeedMergeLike(String value) {
            addCriterion("need_merge like", value, "needMerge");
            return (Criteria) this;
        }

        public Criteria andNeedMergeNotLike(String value) {
            addCriterion("need_merge not like", value, "needMerge");
            return (Criteria) this;
        }

        public Criteria andNeedMergeIn(List<String> values) {
            addCriterion("need_merge in", values, "needMerge");
            return (Criteria) this;
        }

        public Criteria andNeedMergeNotIn(List<String> values) {
            addCriterion("need_merge not in", values, "needMerge");
            return (Criteria) this;
        }

        public Criteria andNeedMergeBetween(String value1, String value2) {
            addCriterion("need_merge between", value1, value2, "needMerge");
            return (Criteria) this;
        }

        public Criteria andNeedMergeNotBetween(String value1, String value2) {
            addCriterion("need_merge not between", value1, value2, "needMerge");
            return (Criteria) this;
        }

        public Criteria andVerifiedIsNull() {
            addCriterion("verified is null");
            return (Criteria) this;
        }

        public Criteria andVerifiedIsNotNull() {
            addCriterion("verified is not null");
            return (Criteria) this;
        }

        public Criteria andVerifiedEqualTo(String value) {
            addCriterion("verified =", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedNotEqualTo(String value) {
            addCriterion("verified <>", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedGreaterThan(String value) {
            addCriterion("verified >", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedGreaterThanOrEqualTo(String value) {
            addCriterion("verified >=", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedLessThan(String value) {
            addCriterion("verified <", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedLessThanOrEqualTo(String value) {
            addCriterion("verified <=", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedLike(String value) {
            addCriterion("verified like", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedNotLike(String value) {
            addCriterion("verified not like", value, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedIn(List<String> values) {
            addCriterion("verified in", values, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedNotIn(List<String> values) {
            addCriterion("verified not in", values, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedBetween(String value1, String value2) {
            addCriterion("verified between", value1, value2, "verified");
            return (Criteria) this;
        }

        public Criteria andVerifiedNotBetween(String value1, String value2) {
            addCriterion("verified not between", value1, value2, "verified");
            return (Criteria) this;
        }

        public Criteria andValidateEmailIsNull() {
            addCriterion("validate_email is null");
            return (Criteria) this;
        }

        public Criteria andValidateEmailIsNotNull() {
            addCriterion("validate_email is not null");
            return (Criteria) this;
        }

        public Criteria andValidateEmailEqualTo(String value) {
            addCriterion("validate_email =", value, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andValidateEmailNotEqualTo(String value) {
            addCriterion("validate_email <>", value, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andValidateEmailGreaterThan(String value) {
            addCriterion("validate_email >", value, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andValidateEmailGreaterThanOrEqualTo(String value) {
            addCriterion("validate_email >=", value, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andValidateEmailLessThan(String value) {
            addCriterion("validate_email <", value, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andValidateEmailLessThanOrEqualTo(String value) {
            addCriterion("validate_email <=", value, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andValidateEmailLike(String value) {
            addCriterion("validate_email like", value, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andValidateEmailNotLike(String value) {
            addCriterion("validate_email not like", value, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andValidateEmailIn(List<String> values) {
            addCriterion("validate_email in", values, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andValidateEmailNotIn(List<String> values) {
            addCriterion("validate_email not in", values, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andValidateEmailBetween(String value1, String value2) {
            addCriterion("validate_email between", value1, value2, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andValidateEmailNotBetween(String value1, String value2) {
            addCriterion("validate_email not between", value1, value2, "validateEmail");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("user_password is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("user_password is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("user_password =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("user_password <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("user_password >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("user_password >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("user_password <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("user_password <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("user_password like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("user_password not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("user_password in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("user_password not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("user_password between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("user_password not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andSysIdIsNull() {
            addCriterion("sys_id is null");
            return (Criteria) this;
        }

        public Criteria andSysIdIsNotNull() {
            addCriterion("sys_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysIdEqualTo(String value) {
            addCriterion("sys_id =", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotEqualTo(String value) {
            addCriterion("sys_id <>", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThan(String value) {
            addCriterion("sys_id >", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThanOrEqualTo(String value) {
            addCriterion("sys_id >=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThan(String value) {
            addCriterion("sys_id <", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThanOrEqualTo(String value) {
            addCriterion("sys_id <=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLike(String value) {
            addCriterion("sys_id like", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotLike(String value) {
            addCriterion("sys_id not like", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdIn(List<String> values) {
            addCriterion("sys_id in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotIn(List<String> values) {
            addCriterion("sys_id not in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdBetween(String value1, String value2) {
            addCriterion("sys_id between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotBetween(String value1, String value2) {
            addCriterion("sys_id not between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNull() {
            addCriterion("register_date is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIsNotNull() {
            addCriterion("register_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDateEqualTo(String value) {
            addCriterion("register_date =", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotEqualTo(String value) {
            addCriterion("register_date <>", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThan(String value) {
            addCriterion("register_date >", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateGreaterThanOrEqualTo(String value) {
            addCriterion("register_date >=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThan(String value) {
            addCriterion("register_date <", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLessThanOrEqualTo(String value) {
            addCriterion("register_date <=", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateLike(String value) {
            addCriterion("register_date like", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotLike(String value) {
            addCriterion("register_date not like", value, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateIn(List<String> values) {
            addCriterion("register_date in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotIn(List<String> values) {
            addCriterion("register_date not in", values, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateBetween(String value1, String value2) {
            addCriterion("register_date between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDateNotBetween(String value1, String value2) {
            addCriterion("register_date not between", value1, value2, "registerDate");
            return (Criteria) this;
        }

        public Criteria andUserActivateIsNull() {
            addCriterion("user_activate is null");
            return (Criteria) this;
        }

        public Criteria andUserActivateIsNotNull() {
            addCriterion("user_activate is not null");
            return (Criteria) this;
        }

        public Criteria andUserActivateEqualTo(String value) {
            addCriterion("user_activate =", value, "userActivate");
            return (Criteria) this;
        }

        public Criteria andUserActivateNotEqualTo(String value) {
            addCriterion("user_activate <>", value, "userActivate");
            return (Criteria) this;
        }

        public Criteria andUserActivateGreaterThan(String value) {
            addCriterion("user_activate >", value, "userActivate");
            return (Criteria) this;
        }

        public Criteria andUserActivateGreaterThanOrEqualTo(String value) {
            addCriterion("user_activate >=", value, "userActivate");
            return (Criteria) this;
        }

        public Criteria andUserActivateLessThan(String value) {
            addCriterion("user_activate <", value, "userActivate");
            return (Criteria) this;
        }

        public Criteria andUserActivateLessThanOrEqualTo(String value) {
            addCriterion("user_activate <=", value, "userActivate");
            return (Criteria) this;
        }

        public Criteria andUserActivateLike(String value) {
            addCriterion("user_activate like", value, "userActivate");
            return (Criteria) this;
        }

        public Criteria andUserActivateNotLike(String value) {
            addCriterion("user_activate not like", value, "userActivate");
            return (Criteria) this;
        }

        public Criteria andUserActivateIn(List<String> values) {
            addCriterion("user_activate in", values, "userActivate");
            return (Criteria) this;
        }

        public Criteria andUserActivateNotIn(List<String> values) {
            addCriterion("user_activate not in", values, "userActivate");
            return (Criteria) this;
        }

        public Criteria andUserActivateBetween(String value1, String value2) {
            addCriterion("user_activate between", value1, value2, "userActivate");
            return (Criteria) this;
        }

        public Criteria andUserActivateNotBetween(String value1, String value2) {
            addCriterion("user_activate not between", value1, value2, "userActivate");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("type_id is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("type_id is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(String value) {
            addCriterion("type_id =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(String value) {
            addCriterion("type_id <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(String value) {
            addCriterion("type_id >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("type_id >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(String value) {
            addCriterion("type_id <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(String value) {
            addCriterion("type_id <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLike(String value) {
            addCriterion("type_id like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotLike(String value) {
            addCriterion("type_id not like", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<String> values) {
            addCriterion("type_id in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<String> values) {
            addCriterion("type_id not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(String value1, String value2) {
            addCriterion("type_id between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(String value1, String value2) {
            addCriterion("type_id not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andLoginTsIsNull() {
            addCriterion("login_ts is null");
            return (Criteria) this;
        }

        public Criteria andLoginTsIsNotNull() {
            addCriterion("login_ts is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTsEqualTo(String value) {
            addCriterion("login_ts =", value, "loginTs");
            return (Criteria) this;
        }

        public Criteria andLoginTsNotEqualTo(String value) {
            addCriterion("login_ts <>", value, "loginTs");
            return (Criteria) this;
        }

        public Criteria andLoginTsGreaterThan(String value) {
            addCriterion("login_ts >", value, "loginTs");
            return (Criteria) this;
        }

        public Criteria andLoginTsGreaterThanOrEqualTo(String value) {
            addCriterion("login_ts >=", value, "loginTs");
            return (Criteria) this;
        }

        public Criteria andLoginTsLessThan(String value) {
            addCriterion("login_ts <", value, "loginTs");
            return (Criteria) this;
        }

        public Criteria andLoginTsLessThanOrEqualTo(String value) {
            addCriterion("login_ts <=", value, "loginTs");
            return (Criteria) this;
        }

        public Criteria andLoginTsLike(String value) {
            addCriterion("login_ts like", value, "loginTs");
            return (Criteria) this;
        }

        public Criteria andLoginTsNotLike(String value) {
            addCriterion("login_ts not like", value, "loginTs");
            return (Criteria) this;
        }

        public Criteria andLoginTsIn(List<String> values) {
            addCriterion("login_ts in", values, "loginTs");
            return (Criteria) this;
        }

        public Criteria andLoginTsNotIn(List<String> values) {
            addCriterion("login_ts not in", values, "loginTs");
            return (Criteria) this;
        }

        public Criteria andLoginTsBetween(String value1, String value2) {
            addCriterion("login_ts between", value1, value2, "loginTs");
            return (Criteria) this;
        }

        public Criteria andLoginTsNotBetween(String value1, String value2) {
            addCriterion("login_ts not between", value1, value2, "loginTs");
            return (Criteria) this;
        }

        public Criteria andPara1IsNull() {
            addCriterion("para1 is null");
            return (Criteria) this;
        }

        public Criteria andPara1IsNotNull() {
            addCriterion("para1 is not null");
            return (Criteria) this;
        }

        public Criteria andPara1EqualTo(String value) {
            addCriterion("para1 =", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1NotEqualTo(String value) {
            addCriterion("para1 <>", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1GreaterThan(String value) {
            addCriterion("para1 >", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1GreaterThanOrEqualTo(String value) {
            addCriterion("para1 >=", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1LessThan(String value) {
            addCriterion("para1 <", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1LessThanOrEqualTo(String value) {
            addCriterion("para1 <=", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1Like(String value) {
            addCriterion("para1 like", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1NotLike(String value) {
            addCriterion("para1 not like", value, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1In(List<String> values) {
            addCriterion("para1 in", values, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1NotIn(List<String> values) {
            addCriterion("para1 not in", values, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1Between(String value1, String value2) {
            addCriterion("para1 between", value1, value2, "para1");
            return (Criteria) this;
        }

        public Criteria andPara1NotBetween(String value1, String value2) {
            addCriterion("para1 not between", value1, value2, "para1");
            return (Criteria) this;
        }

        public Criteria andPara2IsNull() {
            addCriterion("para2 is null");
            return (Criteria) this;
        }

        public Criteria andPara2IsNotNull() {
            addCriterion("para2 is not null");
            return (Criteria) this;
        }

        public Criteria andPara2EqualTo(String value) {
            addCriterion("para2 =", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2NotEqualTo(String value) {
            addCriterion("para2 <>", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2GreaterThan(String value) {
            addCriterion("para2 >", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2GreaterThanOrEqualTo(String value) {
            addCriterion("para2 >=", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2LessThan(String value) {
            addCriterion("para2 <", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2LessThanOrEqualTo(String value) {
            addCriterion("para2 <=", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2Like(String value) {
            addCriterion("para2 like", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2NotLike(String value) {
            addCriterion("para2 not like", value, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2In(List<String> values) {
            addCriterion("para2 in", values, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2NotIn(List<String> values) {
            addCriterion("para2 not in", values, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2Between(String value1, String value2) {
            addCriterion("para2 between", value1, value2, "para2");
            return (Criteria) this;
        }

        public Criteria andPara2NotBetween(String value1, String value2) {
            addCriterion("para2 not between", value1, value2, "para2");
            return (Criteria) this;
        }

        public Criteria andPara3IsNull() {
            addCriterion("para3 is null");
            return (Criteria) this;
        }

        public Criteria andPara3IsNotNull() {
            addCriterion("para3 is not null");
            return (Criteria) this;
        }

        public Criteria andPara3EqualTo(String value) {
            addCriterion("para3 =", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3NotEqualTo(String value) {
            addCriterion("para3 <>", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3GreaterThan(String value) {
            addCriterion("para3 >", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3GreaterThanOrEqualTo(String value) {
            addCriterion("para3 >=", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3LessThan(String value) {
            addCriterion("para3 <", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3LessThanOrEqualTo(String value) {
            addCriterion("para3 <=", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3Like(String value) {
            addCriterion("para3 like", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3NotLike(String value) {
            addCriterion("para3 not like", value, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3In(List<String> values) {
            addCriterion("para3 in", values, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3NotIn(List<String> values) {
            addCriterion("para3 not in", values, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3Between(String value1, String value2) {
            addCriterion("para3 between", value1, value2, "para3");
            return (Criteria) this;
        }

        public Criteria andPara3NotBetween(String value1, String value2) {
            addCriterion("para3 not between", value1, value2, "para3");
            return (Criteria) this;
        }

        public Criteria andPara4IsNull() {
            addCriterion("para4 is null");
            return (Criteria) this;
        }

        public Criteria andPara4IsNotNull() {
            addCriterion("para4 is not null");
            return (Criteria) this;
        }

        public Criteria andPara4EqualTo(String value) {
            addCriterion("para4 =", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4NotEqualTo(String value) {
            addCriterion("para4 <>", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4GreaterThan(String value) {
            addCriterion("para4 >", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4GreaterThanOrEqualTo(String value) {
            addCriterion("para4 >=", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4LessThan(String value) {
            addCriterion("para4 <", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4LessThanOrEqualTo(String value) {
            addCriterion("para4 <=", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4Like(String value) {
            addCriterion("para4 like", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4NotLike(String value) {
            addCriterion("para4 not like", value, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4In(List<String> values) {
            addCriterion("para4 in", values, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4NotIn(List<String> values) {
            addCriterion("para4 not in", values, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4Between(String value1, String value2) {
            addCriterion("para4 between", value1, value2, "para4");
            return (Criteria) this;
        }

        public Criteria andPara4NotBetween(String value1, String value2) {
            addCriterion("para4 not between", value1, value2, "para4");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
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