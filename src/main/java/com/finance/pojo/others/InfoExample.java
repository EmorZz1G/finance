package com.finance.pojo.others;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table info
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table info
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table info
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public InfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
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
     * This method corresponds to the database table info
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
     * This method corresponds to the database table info
     *
     * @mbggenerated Wed Jul 15 08:54:07 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
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
     * This class corresponds to the database table info
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

        public Criteria andSendIdIsNull() {
            addCriterion("sendId is null");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNotNull() {
            addCriterion("sendId is not null");
            return (Criteria) this;
        }

        public Criteria andSendIdEqualTo(Integer value) {
            addCriterion("sendId =", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotEqualTo(Integer value) {
            addCriterion("sendId <>", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThan(Integer value) {
            addCriterion("sendId >", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sendId >=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThan(Integer value) {
            addCriterion("sendId <", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThanOrEqualTo(Integer value) {
            addCriterion("sendId <=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdIn(List<Integer> values) {
            addCriterion("sendId in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotIn(List<Integer> values) {
            addCriterion("sendId not in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdBetween(Integer value1, Integer value2) {
            addCriterion("sendId between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sendId not between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdIsNull() {
            addCriterion("receiveId is null");
            return (Criteria) this;
        }

        public Criteria andReceiveIdIsNotNull() {
            addCriterion("receiveId is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveIdEqualTo(Integer value) {
            addCriterion("receiveId =", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdNotEqualTo(Integer value) {
            addCriterion("receiveId <>", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdGreaterThan(Integer value) {
            addCriterion("receiveId >", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("receiveId >=", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdLessThan(Integer value) {
            addCriterion("receiveId <", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("receiveId <=", value, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdIn(List<Integer> values) {
            addCriterion("receiveId in", values, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdNotIn(List<Integer> values) {
            addCriterion("receiveId not in", values, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdBetween(Integer value1, Integer value2) {
            addCriterion("receiveId between", value1, value2, "receiveId");
            return (Criteria) this;
        }

        public Criteria andReceiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("receiveId not between", value1, value2, "receiveId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andInfoDescIsNull() {
            addCriterion("infoDesc is null");
            return (Criteria) this;
        }

        public Criteria andInfoDescIsNotNull() {
            addCriterion("infoDesc is not null");
            return (Criteria) this;
        }

        public Criteria andInfoDescEqualTo(String value) {
            addCriterion("infoDesc =", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotEqualTo(String value) {
            addCriterion("infoDesc <>", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescGreaterThan(String value) {
            addCriterion("infoDesc >", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescGreaterThanOrEqualTo(String value) {
            addCriterion("infoDesc >=", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescLessThan(String value) {
            addCriterion("infoDesc <", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescLessThanOrEqualTo(String value) {
            addCriterion("infoDesc <=", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescLike(String value) {
            addCriterion("infoDesc like", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotLike(String value) {
            addCriterion("infoDesc not like", value, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescIn(List<String> values) {
            addCriterion("infoDesc in", values, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotIn(List<String> values) {
            addCriterion("infoDesc not in", values, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescBetween(String value1, String value2) {
            addCriterion("infoDesc between", value1, value2, "infoDesc");
            return (Criteria) this;
        }

        public Criteria andInfoDescNotBetween(String value1, String value2) {
            addCriterion("infoDesc not between", value1, value2, "infoDesc");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table info
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
     * This class corresponds to the database table info
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