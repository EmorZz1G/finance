package com.finance.pojo.others;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TermFinancialExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public TermFinancialExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andInvesTermIsNull() {
            addCriterion("invesTerm is null");
            return (Criteria) this;
        }

        public Criteria andInvesTermIsNotNull() {
            addCriterion("invesTerm is not null");
            return (Criteria) this;
        }

        public Criteria andInvesTermEqualTo(String value) {
            addCriterion("invesTerm =", value, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andInvesTermNotEqualTo(String value) {
            addCriterion("invesTerm <>", value, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andInvesTermGreaterThan(String value) {
            addCriterion("invesTerm >", value, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andInvesTermGreaterThanOrEqualTo(String value) {
            addCriterion("invesTerm >=", value, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andInvesTermLessThan(String value) {
            addCriterion("invesTerm <", value, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andInvesTermLessThanOrEqualTo(String value) {
            addCriterion("invesTerm <=", value, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andInvesTermLike(String value) {
            addCriterion("invesTerm like", value, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andInvesTermNotLike(String value) {
            addCriterion("invesTerm not like", value, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andInvesTermIn(List<String> values) {
            addCriterion("invesTerm in", values, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andInvesTermNotIn(List<String> values) {
            addCriterion("invesTerm not in", values, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andInvesTermBetween(String value1, String value2) {
            addCriterion("invesTerm between", value1, value2, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andInvesTermNotBetween(String value1, String value2) {
            addCriterion("invesTerm not between", value1, value2, "invesTerm");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyIsNull() {
            addCriterion("leastMoney is null");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyIsNotNull() {
            addCriterion("leastMoney is not null");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyEqualTo(BigDecimal value) {
            addCriterion("leastMoney =", value, "leastMoney");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyNotEqualTo(BigDecimal value) {
            addCriterion("leastMoney <>", value, "leastMoney");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyGreaterThan(BigDecimal value) {
            addCriterion("leastMoney >", value, "leastMoney");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("leastMoney >=", value, "leastMoney");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyLessThan(BigDecimal value) {
            addCriterion("leastMoney <", value, "leastMoney");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("leastMoney <=", value, "leastMoney");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyIn(List<BigDecimal> values) {
            addCriterion("leastMoney in", values, "leastMoney");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyNotIn(List<BigDecimal> values) {
            addCriterion("leastMoney not in", values, "leastMoney");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("leastMoney between", value1, value2, "leastMoney");
            return (Criteria) this;
        }

        public Criteria andLeastMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("leastMoney not between", value1, value2, "leastMoney");
            return (Criteria) this;
        }

        public Criteria andProfitIsNull() {
            addCriterion("profit is null");
            return (Criteria) this;
        }

        public Criteria andProfitIsNotNull() {
            addCriterion("profit is not null");
            return (Criteria) this;
        }

        public Criteria andProfitEqualTo(Integer value) {
            addCriterion("profit =", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotEqualTo(Integer value) {
            addCriterion("profit <>", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThan(Integer value) {
            addCriterion("profit >", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThanOrEqualTo(Integer value) {
            addCriterion("profit >=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThan(Integer value) {
            addCriterion("profit <", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThanOrEqualTo(Integer value) {
            addCriterion("profit <=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitIn(List<Integer> values) {
            addCriterion("profit in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotIn(List<Integer> values) {
            addCriterion("profit not in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitBetween(Integer value1, Integer value2) {
            addCriterion("profit between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotBetween(Integer value1, Integer value2) {
            addCriterion("profit not between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeIsNull() {
            addCriterion("annualIncome is null");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeIsNotNull() {
            addCriterion("annualIncome is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeEqualTo(BigDecimal value) {
            addCriterion("annualIncome =", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeNotEqualTo(BigDecimal value) {
            addCriterion("annualIncome <>", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeGreaterThan(BigDecimal value) {
            addCriterion("annualIncome >", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("annualIncome >=", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeLessThan(BigDecimal value) {
            addCriterion("annualIncome <", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("annualIncome <=", value, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeIn(List<BigDecimal> values) {
            addCriterion("annualIncome in", values, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeNotIn(List<BigDecimal> values) {
            addCriterion("annualIncome not in", values, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annualIncome between", value1, value2, "annualIncome");
            return (Criteria) this;
        }

        public Criteria andAnnualIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("annualIncome not between", value1, value2, "annualIncome");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table term_financial
     *
     * @mbggenerated do_not_delete_during_merge Wed Jul 15 08:54:07 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table term_financial
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
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