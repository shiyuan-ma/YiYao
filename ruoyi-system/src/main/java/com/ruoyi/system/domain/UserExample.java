package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andAccountIsNull() {
            addCriterion("account is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("account is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("account =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("account <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("account >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("account >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("account <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("account <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("account like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("account not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("account in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("account not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("account between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("account not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicIsNull() {
            addCriterion("allowUserDynamic is null");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicIsNotNull() {
            addCriterion("allowUserDynamic is not null");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicEqualTo(Boolean value) {
            addCriterion("allowUserDynamic =", value, "allowuserdynamic");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicNotEqualTo(Boolean value) {
            addCriterion("allowUserDynamic <>", value, "allowuserdynamic");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicGreaterThan(Boolean value) {
            addCriterion("allowUserDynamic >", value, "allowuserdynamic");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicGreaterThanOrEqualTo(Boolean value) {
            addCriterion("allowUserDynamic >=", value, "allowuserdynamic");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicLessThan(Boolean value) {
            addCriterion("allowUserDynamic <", value, "allowuserdynamic");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicLessThanOrEqualTo(Boolean value) {
            addCriterion("allowUserDynamic <=", value, "allowuserdynamic");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicIn(List<Boolean> values) {
            addCriterion("allowUserDynamic in", values, "allowuserdynamic");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicNotIn(List<Boolean> values) {
            addCriterion("allowUserDynamic not in", values, "allowuserdynamic");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicBetween(Boolean value1, Boolean value2) {
            addCriterion("allowUserDynamic between", value1, value2, "allowuserdynamic");
            return (Criteria) this;
        }

        public Criteria andAllowuserdynamicNotBetween(Boolean value1, Boolean value2) {
            addCriterion("allowUserDynamic not between", value1, value2, "allowuserdynamic");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAvatarnameIsNull() {
            addCriterion("avatarName is null");
            return (Criteria) this;
        }

        public Criteria andAvatarnameIsNotNull() {
            addCriterion("avatarName is not null");
            return (Criteria) this;
        }

        public Criteria andAvatarnameEqualTo(String value) {
            addCriterion("avatarName =", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameNotEqualTo(String value) {
            addCriterion("avatarName <>", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameGreaterThan(String value) {
            addCriterion("avatarName >", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameGreaterThanOrEqualTo(String value) {
            addCriterion("avatarName >=", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameLessThan(String value) {
            addCriterion("avatarName <", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameLessThanOrEqualTo(String value) {
            addCriterion("avatarName <=", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameLike(String value) {
            addCriterion("avatarName like", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameNotLike(String value) {
            addCriterion("avatarName not like", value, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameIn(List<String> values) {
            addCriterion("avatarName in", values, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameNotIn(List<String> values) {
            addCriterion("avatarName not in", values, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameBetween(String value1, String value2) {
            addCriterion("avatarName between", value1, value2, "avatarname");
            return (Criteria) this;
        }

        public Criteria andAvatarnameNotBetween(String value1, String value2) {
            addCriterion("avatarName not between", value1, value2, "avatarname");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeIsNull() {
            addCriterion("cancelAccountTime is null");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeIsNotNull() {
            addCriterion("cancelAccountTime is not null");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeEqualTo(Long value) {
            addCriterion("cancelAccountTime =", value, "cancelaccounttime");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeNotEqualTo(Long value) {
            addCriterion("cancelAccountTime <>", value, "cancelaccounttime");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeGreaterThan(Long value) {
            addCriterion("cancelAccountTime >", value, "cancelaccounttime");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeGreaterThanOrEqualTo(Long value) {
            addCriterion("cancelAccountTime >=", value, "cancelaccounttime");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeLessThan(Long value) {
            addCriterion("cancelAccountTime <", value, "cancelaccounttime");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeLessThanOrEqualTo(Long value) {
            addCriterion("cancelAccountTime <=", value, "cancelaccounttime");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeIn(List<Long> values) {
            addCriterion("cancelAccountTime in", values, "cancelaccounttime");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeNotIn(List<Long> values) {
            addCriterion("cancelAccountTime not in", values, "cancelaccounttime");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeBetween(Long value1, Long value2) {
            addCriterion("cancelAccountTime between", value1, value2, "cancelaccounttime");
            return (Criteria) this;
        }

        public Criteria andCancelaccounttimeNotBetween(Long value1, Long value2) {
            addCriterion("cancelAccountTime not between", value1, value2, "cancelaccounttime");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("deposit is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("deposit is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(BigDecimal value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(BigDecimal value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(BigDecimal value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(BigDecimal value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<BigDecimal> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<BigDecimal> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
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

        public Criteria andIssueIsNull() {
            addCriterion("issue is null");
            return (Criteria) this;
        }

        public Criteria andIssueIsNotNull() {
            addCriterion("issue is not null");
            return (Criteria) this;
        }

        public Criteria andIssueEqualTo(String value) {
            addCriterion("issue =", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotEqualTo(String value) {
            addCriterion("issue <>", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThan(String value) {
            addCriterion("issue >", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueGreaterThanOrEqualTo(String value) {
            addCriterion("issue >=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThan(String value) {
            addCriterion("issue <", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLessThanOrEqualTo(String value) {
            addCriterion("issue <=", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueLike(String value) {
            addCriterion("issue like", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotLike(String value) {
            addCriterion("issue not like", value, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueIn(List<String> values) {
            addCriterion("issue in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotIn(List<String> values) {
            addCriterion("issue not in", values, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueBetween(String value1, String value2) {
            addCriterion("issue between", value1, value2, "issue");
            return (Criteria) this;
        }

        public Criteria andIssueNotBetween(String value1, String value2) {
            addCriterion("issue not between", value1, value2, "issue");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull() {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickname not between", value1, value2, "nickname");
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

        public Criteria andPlatformuseridIsNull() {
            addCriterion("platformUserId is null");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridIsNotNull() {
            addCriterion("platformUserId is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridEqualTo(String value) {
            addCriterion("platformUserId =", value, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridNotEqualTo(String value) {
            addCriterion("platformUserId <>", value, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridGreaterThan(String value) {
            addCriterion("platformUserId >", value, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridGreaterThanOrEqualTo(String value) {
            addCriterion("platformUserId >=", value, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridLessThan(String value) {
            addCriterion("platformUserId <", value, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridLessThanOrEqualTo(String value) {
            addCriterion("platformUserId <=", value, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridLike(String value) {
            addCriterion("platformUserId like", value, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridNotLike(String value) {
            addCriterion("platformUserId not like", value, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridIn(List<String> values) {
            addCriterion("platformUserId in", values, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridNotIn(List<String> values) {
            addCriterion("platformUserId not in", values, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridBetween(String value1, String value2) {
            addCriterion("platformUserId between", value1, value2, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPlatformuseridNotBetween(String value1, String value2) {
            addCriterion("platformUserId not between", value1, value2, "platformuserid");
            return (Criteria) this;
        }

        public Criteria andPointIsNull() {
            addCriterion("point is null");
            return (Criteria) this;
        }

        public Criteria andPointIsNotNull() {
            addCriterion("point is not null");
            return (Criteria) this;
        }

        public Criteria andPointEqualTo(Long value) {
            addCriterion("point =", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotEqualTo(Long value) {
            addCriterion("point <>", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThan(Long value) {
            addCriterion("point >", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointGreaterThanOrEqualTo(Long value) {
            addCriterion("point >=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThan(Long value) {
            addCriterion("point <", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointLessThanOrEqualTo(Long value) {
            addCriterion("point <=", value, "point");
            return (Criteria) this;
        }

        public Criteria andPointIn(List<Long> values) {
            addCriterion("point in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotIn(List<Long> values) {
            addCriterion("point not in", values, "point");
            return (Criteria) this;
        }

        public Criteria andPointBetween(Long value1, Long value2) {
            addCriterion("point between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andPointNotBetween(Long value1, Long value2) {
            addCriterion("point not between", value1, value2, "point");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationIsNull() {
            addCriterion("realNameAuthentication is null");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationIsNotNull() {
            addCriterion("realNameAuthentication is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationEqualTo(Boolean value) {
            addCriterion("realNameAuthentication =", value, "realnameauthentication");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationNotEqualTo(Boolean value) {
            addCriterion("realNameAuthentication <>", value, "realnameauthentication");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationGreaterThan(Boolean value) {
            addCriterion("realNameAuthentication >", value, "realnameauthentication");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationGreaterThanOrEqualTo(Boolean value) {
            addCriterion("realNameAuthentication >=", value, "realnameauthentication");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationLessThan(Boolean value) {
            addCriterion("realNameAuthentication <", value, "realnameauthentication");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationLessThanOrEqualTo(Boolean value) {
            addCriterion("realNameAuthentication <=", value, "realnameauthentication");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationIn(List<Boolean> values) {
            addCriterion("realNameAuthentication in", values, "realnameauthentication");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationNotIn(List<Boolean> values) {
            addCriterion("realNameAuthentication not in", values, "realnameauthentication");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationBetween(Boolean value1, Boolean value2) {
            addCriterion("realNameAuthentication between", value1, value2, "realnameauthentication");
            return (Criteria) this;
        }

        public Criteria andRealnameauthenticationNotBetween(Boolean value1, Boolean value2) {
            addCriterion("realNameAuthentication not between", value1, value2, "realnameauthentication");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateIsNull() {
            addCriterion("registrationDate is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateIsNotNull() {
            addCriterion("registrationDate is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateEqualTo(Date value) {
            addCriterion("registrationDate =", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateNotEqualTo(Date value) {
            addCriterion("registrationDate <>", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateGreaterThan(Date value) {
            addCriterion("registrationDate >", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateGreaterThanOrEqualTo(Date value) {
            addCriterion("registrationDate >=", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateLessThan(Date value) {
            addCriterion("registrationDate <", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateLessThanOrEqualTo(Date value) {
            addCriterion("registrationDate <=", value, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateIn(List<Date> values) {
            addCriterion("registrationDate in", values, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateNotIn(List<Date> values) {
            addCriterion("registrationDate not in", values, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateBetween(Date value1, Date value2) {
            addCriterion("registrationDate between", value1, value2, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andRegistrationdateNotBetween(Date value1, Date value2) {
            addCriterion("registrationDate not between", value1, value2, "registrationdate");
            return (Criteria) this;
        }

        public Criteria andSaltIsNull() {
            addCriterion("salt is null");
            return (Criteria) this;
        }

        public Criteria andSaltIsNotNull() {
            addCriterion("salt is not null");
            return (Criteria) this;
        }

        public Criteria andSaltEqualTo(String value) {
            addCriterion("salt =", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotEqualTo(String value) {
            addCriterion("salt <>", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThan(String value) {
            addCriterion("salt >", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltGreaterThanOrEqualTo(String value) {
            addCriterion("salt >=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThan(String value) {
            addCriterion("salt <", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLessThanOrEqualTo(String value) {
            addCriterion("salt <=", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltLike(String value) {
            addCriterion("salt like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotLike(String value) {
            addCriterion("salt not like", value, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltIn(List<String> values) {
            addCriterion("salt in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotIn(List<String> values) {
            addCriterion("salt not in", values, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltBetween(String value1, String value2) {
            addCriterion("salt between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSaltNotBetween(String value1, String value2) {
            addCriterion("salt not between", value1, value2, "salt");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestIsNull() {
            addCriterion("securityDigest is null");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestIsNotNull() {
            addCriterion("securityDigest is not null");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestEqualTo(Long value) {
            addCriterion("securityDigest =", value, "securitydigest");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestNotEqualTo(Long value) {
            addCriterion("securityDigest <>", value, "securitydigest");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestGreaterThan(Long value) {
            addCriterion("securityDigest >", value, "securitydigest");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestGreaterThanOrEqualTo(Long value) {
            addCriterion("securityDigest >=", value, "securitydigest");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestLessThan(Long value) {
            addCriterion("securityDigest <", value, "securitydigest");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestLessThanOrEqualTo(Long value) {
            addCriterion("securityDigest <=", value, "securitydigest");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestIn(List<Long> values) {
            addCriterion("securityDigest in", values, "securitydigest");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestNotIn(List<Long> values) {
            addCriterion("securityDigest not in", values, "securitydigest");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestBetween(Long value1, Long value2) {
            addCriterion("securityDigest between", value1, value2, "securitydigest");
            return (Criteria) this;
        }

        public Criteria andSecuritydigestNotBetween(Long value1, Long value2) {
            addCriterion("securityDigest not between", value1, value2, "securitydigest");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUserversionIsNull() {
            addCriterion("userVersion is null");
            return (Criteria) this;
        }

        public Criteria andUserversionIsNotNull() {
            addCriterion("userVersion is not null");
            return (Criteria) this;
        }

        public Criteria andUserversionEqualTo(Integer value) {
            addCriterion("userVersion =", value, "userversion");
            return (Criteria) this;
        }

        public Criteria andUserversionNotEqualTo(Integer value) {
            addCriterion("userVersion <>", value, "userversion");
            return (Criteria) this;
        }

        public Criteria andUserversionGreaterThan(Integer value) {
            addCriterion("userVersion >", value, "userversion");
            return (Criteria) this;
        }

        public Criteria andUserversionGreaterThanOrEqualTo(Integer value) {
            addCriterion("userVersion >=", value, "userversion");
            return (Criteria) this;
        }

        public Criteria andUserversionLessThan(Integer value) {
            addCriterion("userVersion <", value, "userversion");
            return (Criteria) this;
        }

        public Criteria andUserversionLessThanOrEqualTo(Integer value) {
            addCriterion("userVersion <=", value, "userversion");
            return (Criteria) this;
        }

        public Criteria andUserversionIn(List<Integer> values) {
            addCriterion("userVersion in", values, "userversion");
            return (Criteria) this;
        }

        public Criteria andUserversionNotIn(List<Integer> values) {
            addCriterion("userVersion not in", values, "userversion");
            return (Criteria) this;
        }

        public Criteria andUserversionBetween(Integer value1, Integer value2) {
            addCriterion("userVersion between", value1, value2, "userversion");
            return (Criteria) this;
        }

        public Criteria andUserversionNotBetween(Integer value1, Integer value2) {
            addCriterion("userVersion not between", value1, value2, "userversion");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNull() {
            addCriterion("headimg is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNotNull() {
            addCriterion("headimg is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgEqualTo(String value) {
            addCriterion("headimg =", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotEqualTo(String value) {
            addCriterion("headimg <>", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThan(String value) {
            addCriterion("headimg >", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThanOrEqualTo(String value) {
            addCriterion("headimg >=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThan(String value) {
            addCriterion("headimg <", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThanOrEqualTo(String value) {
            addCriterion("headimg <=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLike(String value) {
            addCriterion("headimg like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotLike(String value) {
            addCriterion("headimg not like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgIn(List<String> values) {
            addCriterion("headimg in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotIn(List<String> values) {
            addCriterion("headimg not in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgBetween(String value1, String value2) {
            addCriterion("headimg between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotBetween(String value1, String value2) {
            addCriterion("headimg not between", value1, value2, "headimg");
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