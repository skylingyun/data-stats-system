package com.ybz.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NcInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NcInfoExample() {
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

        public Criteria andIpIsNull() {
            addCriterion("ip is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("ip is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("ip =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("ip <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("ip >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("ip >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("ip <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("ip <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("ip like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("ip not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("ip in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("ip not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("ip between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("ip not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("port like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("port not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<String> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<String> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andDsIsNull() {
            addCriterion("ds is null");
            return (Criteria) this;
        }

        public Criteria andDsIsNotNull() {
            addCriterion("ds is not null");
            return (Criteria) this;
        }

        public Criteria andDsEqualTo(String value) {
            addCriterion("ds =", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsNotEqualTo(String value) {
            addCriterion("ds <>", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsGreaterThan(String value) {
            addCriterion("ds >", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsGreaterThanOrEqualTo(String value) {
            addCriterion("ds >=", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsLessThan(String value) {
            addCriterion("ds <", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsLessThanOrEqualTo(String value) {
            addCriterion("ds <=", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsLike(String value) {
            addCriterion("ds like", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsNotLike(String value) {
            addCriterion("ds not like", value, "ds");
            return (Criteria) this;
        }

        public Criteria andDsIn(List<String> values) {
            addCriterion("ds in", values, "ds");
            return (Criteria) this;
        }

        public Criteria andDsNotIn(List<String> values) {
            addCriterion("ds not in", values, "ds");
            return (Criteria) this;
        }

        public Criteria andDsBetween(String value1, String value2) {
            addCriterion("ds between", value1, value2, "ds");
            return (Criteria) this;
        }

        public Criteria andDsNotBetween(String value1, String value2) {
            addCriterion("ds not between", value1, value2, "ds");
            return (Criteria) this;
        }

        public Criteria andTokenseedIsNull() {
            addCriterion("tokenseed is null");
            return (Criteria) this;
        }

        public Criteria andTokenseedIsNotNull() {
            addCriterion("tokenseed is not null");
            return (Criteria) this;
        }

        public Criteria andTokenseedEqualTo(String value) {
            addCriterion("tokenseed =", value, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andTokenseedNotEqualTo(String value) {
            addCriterion("tokenseed <>", value, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andTokenseedGreaterThan(String value) {
            addCriterion("tokenseed >", value, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andTokenseedGreaterThanOrEqualTo(String value) {
            addCriterion("tokenseed >=", value, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andTokenseedLessThan(String value) {
            addCriterion("tokenseed <", value, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andTokenseedLessThanOrEqualTo(String value) {
            addCriterion("tokenseed <=", value, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andTokenseedLike(String value) {
            addCriterion("tokenseed like", value, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andTokenseedNotLike(String value) {
            addCriterion("tokenseed not like", value, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andTokenseedIn(List<String> values) {
            addCriterion("tokenseed in", values, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andTokenseedNotIn(List<String> values) {
            addCriterion("tokenseed not in", values, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andTokenseedBetween(String value1, String value2) {
            addCriterion("tokenseed between", value1, value2, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andTokenseedNotBetween(String value1, String value2) {
            addCriterion("tokenseed not between", value1, value2, "tokenseed");
            return (Criteria) this;
        }

        public Criteria andMaipIsNull() {
            addCriterion("maip is null");
            return (Criteria) this;
        }

        public Criteria andMaipIsNotNull() {
            addCriterion("maip is not null");
            return (Criteria) this;
        }

        public Criteria andMaipEqualTo(String value) {
            addCriterion("maip =", value, "maip");
            return (Criteria) this;
        }

        public Criteria andMaipNotEqualTo(String value) {
            addCriterion("maip <>", value, "maip");
            return (Criteria) this;
        }

        public Criteria andMaipGreaterThan(String value) {
            addCriterion("maip >", value, "maip");
            return (Criteria) this;
        }

        public Criteria andMaipGreaterThanOrEqualTo(String value) {
            addCriterion("maip >=", value, "maip");
            return (Criteria) this;
        }

        public Criteria andMaipLessThan(String value) {
            addCriterion("maip <", value, "maip");
            return (Criteria) this;
        }

        public Criteria andMaipLessThanOrEqualTo(String value) {
            addCriterion("maip <=", value, "maip");
            return (Criteria) this;
        }

        public Criteria andMaipLike(String value) {
            addCriterion("maip like", value, "maip");
            return (Criteria) this;
        }

        public Criteria andMaipNotLike(String value) {
            addCriterion("maip not like", value, "maip");
            return (Criteria) this;
        }

        public Criteria andMaipIn(List<String> values) {
            addCriterion("maip in", values, "maip");
            return (Criteria) this;
        }

        public Criteria andMaipNotIn(List<String> values) {
            addCriterion("maip not in", values, "maip");
            return (Criteria) this;
        }

        public Criteria andMaipBetween(String value1, String value2) {
            addCriterion("maip between", value1, value2, "maip");
            return (Criteria) this;
        }

        public Criteria andMaipNotBetween(String value1, String value2) {
            addCriterion("maip not between", value1, value2, "maip");
            return (Criteria) this;
        }

        public Criteria andMaportIsNull() {
            addCriterion("maport is null");
            return (Criteria) this;
        }

        public Criteria andMaportIsNotNull() {
            addCriterion("maport is not null");
            return (Criteria) this;
        }

        public Criteria andMaportEqualTo(String value) {
            addCriterion("maport =", value, "maport");
            return (Criteria) this;
        }

        public Criteria andMaportNotEqualTo(String value) {
            addCriterion("maport <>", value, "maport");
            return (Criteria) this;
        }

        public Criteria andMaportGreaterThan(String value) {
            addCriterion("maport >", value, "maport");
            return (Criteria) this;
        }

        public Criteria andMaportGreaterThanOrEqualTo(String value) {
            addCriterion("maport >=", value, "maport");
            return (Criteria) this;
        }

        public Criteria andMaportLessThan(String value) {
            addCriterion("maport <", value, "maport");
            return (Criteria) this;
        }

        public Criteria andMaportLessThanOrEqualTo(String value) {
            addCriterion("maport <=", value, "maport");
            return (Criteria) this;
        }

        public Criteria andMaportLike(String value) {
            addCriterion("maport like", value, "maport");
            return (Criteria) this;
        }

        public Criteria andMaportNotLike(String value) {
            addCriterion("maport not like", value, "maport");
            return (Criteria) this;
        }

        public Criteria andMaportIn(List<String> values) {
            addCriterion("maport in", values, "maport");
            return (Criteria) this;
        }

        public Criteria andMaportNotIn(List<String> values) {
            addCriterion("maport not in", values, "maport");
            return (Criteria) this;
        }

        public Criteria andMaportBetween(String value1, String value2) {
            addCriterion("maport between", value1, value2, "maport");
            return (Criteria) this;
        }

        public Criteria andMaportNotBetween(String value1, String value2) {
            addCriterion("maport not between", value1, value2, "maport");
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

        public Criteria andOstypeIsNull() {
            addCriterion("ostype is null");
            return (Criteria) this;
        }

        public Criteria andOstypeIsNotNull() {
            addCriterion("ostype is not null");
            return (Criteria) this;
        }

        public Criteria andOstypeEqualTo(String value) {
            addCriterion("ostype =", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeNotEqualTo(String value) {
            addCriterion("ostype <>", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeGreaterThan(String value) {
            addCriterion("ostype >", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeGreaterThanOrEqualTo(String value) {
            addCriterion("ostype >=", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeLessThan(String value) {
            addCriterion("ostype <", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeLessThanOrEqualTo(String value) {
            addCriterion("ostype <=", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeLike(String value) {
            addCriterion("ostype like", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeNotLike(String value) {
            addCriterion("ostype not like", value, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeIn(List<String> values) {
            addCriterion("ostype in", values, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeNotIn(List<String> values) {
            addCriterion("ostype not in", values, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeBetween(String value1, String value2) {
            addCriterion("ostype between", value1, value2, "ostype");
            return (Criteria) this;
        }

        public Criteria andOstypeNotBetween(String value1, String value2) {
            addCriterion("ostype not between", value1, value2, "ostype");
            return (Criteria) this;
        }

        public Criteria andOsparamIsNull() {
            addCriterion("osparam is null");
            return (Criteria) this;
        }

        public Criteria andOsparamIsNotNull() {
            addCriterion("osparam is not null");
            return (Criteria) this;
        }

        public Criteria andOsparamEqualTo(String value) {
            addCriterion("osparam =", value, "osparam");
            return (Criteria) this;
        }

        public Criteria andOsparamNotEqualTo(String value) {
            addCriterion("osparam <>", value, "osparam");
            return (Criteria) this;
        }

        public Criteria andOsparamGreaterThan(String value) {
            addCriterion("osparam >", value, "osparam");
            return (Criteria) this;
        }

        public Criteria andOsparamGreaterThanOrEqualTo(String value) {
            addCriterion("osparam >=", value, "osparam");
            return (Criteria) this;
        }

        public Criteria andOsparamLessThan(String value) {
            addCriterion("osparam <", value, "osparam");
            return (Criteria) this;
        }

        public Criteria andOsparamLessThanOrEqualTo(String value) {
            addCriterion("osparam <=", value, "osparam");
            return (Criteria) this;
        }

        public Criteria andOsparamLike(String value) {
            addCriterion("osparam like", value, "osparam");
            return (Criteria) this;
        }

        public Criteria andOsparamNotLike(String value) {
            addCriterion("osparam not like", value, "osparam");
            return (Criteria) this;
        }

        public Criteria andOsparamIn(List<String> values) {
            addCriterion("osparam in", values, "osparam");
            return (Criteria) this;
        }

        public Criteria andOsparamNotIn(List<String> values) {
            addCriterion("osparam not in", values, "osparam");
            return (Criteria) this;
        }

        public Criteria andOsparamBetween(String value1, String value2) {
            addCriterion("osparam between", value1, value2, "osparam");
            return (Criteria) this;
        }

        public Criteria andOsparamNotBetween(String value1, String value2) {
            addCriterion("osparam not between", value1, value2, "osparam");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidIsNull() {
            addCriterion("bpmtenantid is null");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidIsNotNull() {
            addCriterion("bpmtenantid is not null");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidEqualTo(String value) {
            addCriterion("bpmtenantid =", value, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidNotEqualTo(String value) {
            addCriterion("bpmtenantid <>", value, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidGreaterThan(String value) {
            addCriterion("bpmtenantid >", value, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidGreaterThanOrEqualTo(String value) {
            addCriterion("bpmtenantid >=", value, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidLessThan(String value) {
            addCriterion("bpmtenantid <", value, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidLessThanOrEqualTo(String value) {
            addCriterion("bpmtenantid <=", value, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidLike(String value) {
            addCriterion("bpmtenantid like", value, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidNotLike(String value) {
            addCriterion("bpmtenantid not like", value, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidIn(List<String> values) {
            addCriterion("bpmtenantid in", values, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidNotIn(List<String> values) {
            addCriterion("bpmtenantid not in", values, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidBetween(String value1, String value2) {
            addCriterion("bpmtenantid between", value1, value2, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantidNotBetween(String value1, String value2) {
            addCriterion("bpmtenantid not between", value1, value2, "bpmtenantid");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidIsNull() {
            addCriterion("bpmtenantpid is null");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidIsNotNull() {
            addCriterion("bpmtenantpid is not null");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidEqualTo(String value) {
            addCriterion("bpmtenantpid =", value, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidNotEqualTo(String value) {
            addCriterion("bpmtenantpid <>", value, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidGreaterThan(String value) {
            addCriterion("bpmtenantpid >", value, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidGreaterThanOrEqualTo(String value) {
            addCriterion("bpmtenantpid >=", value, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidLessThan(String value) {
            addCriterion("bpmtenantpid <", value, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidLessThanOrEqualTo(String value) {
            addCriterion("bpmtenantpid <=", value, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidLike(String value) {
            addCriterion("bpmtenantpid like", value, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidNotLike(String value) {
            addCriterion("bpmtenantpid not like", value, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidIn(List<String> values) {
            addCriterion("bpmtenantpid in", values, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidNotIn(List<String> values) {
            addCriterion("bpmtenantpid not in", values, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidBetween(String value1, String value2) {
            addCriterion("bpmtenantpid between", value1, value2, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andBpmtenantpidNotBetween(String value1, String value2) {
            addCriterion("bpmtenantpid not between", value1, value2, "bpmtenantpid");
            return (Criteria) this;
        }

        public Criteria andSyncuserIsNull() {
            addCriterion("syncuser is null");
            return (Criteria) this;
        }

        public Criteria andSyncuserIsNotNull() {
            addCriterion("syncuser is not null");
            return (Criteria) this;
        }

        public Criteria andSyncuserEqualTo(Byte value) {
            addCriterion("syncuser =", value, "syncuser");
            return (Criteria) this;
        }

        public Criteria andSyncuserNotEqualTo(Byte value) {
            addCriterion("syncuser <>", value, "syncuser");
            return (Criteria) this;
        }

        public Criteria andSyncuserGreaterThan(Byte value) {
            addCriterion("syncuser >", value, "syncuser");
            return (Criteria) this;
        }

        public Criteria andSyncuserGreaterThanOrEqualTo(Byte value) {
            addCriterion("syncuser >=", value, "syncuser");
            return (Criteria) this;
        }

        public Criteria andSyncuserLessThan(Byte value) {
            addCriterion("syncuser <", value, "syncuser");
            return (Criteria) this;
        }

        public Criteria andSyncuserLessThanOrEqualTo(Byte value) {
            addCriterion("syncuser <=", value, "syncuser");
            return (Criteria) this;
        }

        public Criteria andSyncuserIn(List<Byte> values) {
            addCriterion("syncuser in", values, "syncuser");
            return (Criteria) this;
        }

        public Criteria andSyncuserNotIn(List<Byte> values) {
            addCriterion("syncuser not in", values, "syncuser");
            return (Criteria) this;
        }

        public Criteria andSyncuserBetween(Byte value1, Byte value2) {
            addCriterion("syncuser between", value1, value2, "syncuser");
            return (Criteria) this;
        }

        public Criteria andSyncuserNotBetween(Byte value1, Byte value2) {
            addCriterion("syncuser not between", value1, value2, "syncuser");
            return (Criteria) this;
        }

        public Criteria andSendemailIsNull() {
            addCriterion("sendemail is null");
            return (Criteria) this;
        }

        public Criteria andSendemailIsNotNull() {
            addCriterion("sendemail is not null");
            return (Criteria) this;
        }

        public Criteria andSendemailEqualTo(Byte value) {
            addCriterion("sendemail =", value, "sendemail");
            return (Criteria) this;
        }

        public Criteria andSendemailNotEqualTo(Byte value) {
            addCriterion("sendemail <>", value, "sendemail");
            return (Criteria) this;
        }

        public Criteria andSendemailGreaterThan(Byte value) {
            addCriterion("sendemail >", value, "sendemail");
            return (Criteria) this;
        }

        public Criteria andSendemailGreaterThanOrEqualTo(Byte value) {
            addCriterion("sendemail >=", value, "sendemail");
            return (Criteria) this;
        }

        public Criteria andSendemailLessThan(Byte value) {
            addCriterion("sendemail <", value, "sendemail");
            return (Criteria) this;
        }

        public Criteria andSendemailLessThanOrEqualTo(Byte value) {
            addCriterion("sendemail <=", value, "sendemail");
            return (Criteria) this;
        }

        public Criteria andSendemailIn(List<Byte> values) {
            addCriterion("sendemail in", values, "sendemail");
            return (Criteria) this;
        }

        public Criteria andSendemailNotIn(List<Byte> values) {
            addCriterion("sendemail not in", values, "sendemail");
            return (Criteria) this;
        }

        public Criteria andSendemailBetween(Byte value1, Byte value2) {
            addCriterion("sendemail between", value1, value2, "sendemail");
            return (Criteria) this;
        }

        public Criteria andSendemailNotBetween(Byte value1, Byte value2) {
            addCriterion("sendemail not between", value1, value2, "sendemail");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgIsNull() {
            addCriterion("isshowswitchorg is null");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgIsNotNull() {
            addCriterion("isshowswitchorg is not null");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgEqualTo(Byte value) {
            addCriterion("isshowswitchorg =", value, "isshowswitchorg");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgNotEqualTo(Byte value) {
            addCriterion("isshowswitchorg <>", value, "isshowswitchorg");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgGreaterThan(Byte value) {
            addCriterion("isshowswitchorg >", value, "isshowswitchorg");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgGreaterThanOrEqualTo(Byte value) {
            addCriterion("isshowswitchorg >=", value, "isshowswitchorg");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgLessThan(Byte value) {
            addCriterion("isshowswitchorg <", value, "isshowswitchorg");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgLessThanOrEqualTo(Byte value) {
            addCriterion("isshowswitchorg <=", value, "isshowswitchorg");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgIn(List<Byte> values) {
            addCriterion("isshowswitchorg in", values, "isshowswitchorg");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgNotIn(List<Byte> values) {
            addCriterion("isshowswitchorg not in", values, "isshowswitchorg");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgBetween(Byte value1, Byte value2) {
            addCriterion("isshowswitchorg between", value1, value2, "isshowswitchorg");
            return (Criteria) this;
        }

        public Criteria andIsshowswitchorgNotBetween(Byte value1, Byte value2) {
            addCriterion("isshowswitchorg not between", value1, value2, "isshowswitchorg");
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