package com.office.rebates.dal.dataobj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionAnswerExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    public QuestionAnswerExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
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
     * This method corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
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

        public Criteria andQaIdIsNull() {
            addCriterion("qa_id is null");
            return (Criteria) this;
        }

        public Criteria andQaIdIsNotNull() {
            addCriterion("qa_id is not null");
            return (Criteria) this;
        }

        public Criteria andQaIdEqualTo(Long value) {
            addCriterion("qa_id =", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdNotEqualTo(Long value) {
            addCriterion("qa_id <>", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdGreaterThan(Long value) {
            addCriterion("qa_id >", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("qa_id >=", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdLessThan(Long value) {
            addCriterion("qa_id <", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdLessThanOrEqualTo(Long value) {
            addCriterion("qa_id <=", value, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdIn(List<Long> values) {
            addCriterion("qa_id in", values, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdNotIn(List<Long> values) {
            addCriterion("qa_id not in", values, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdBetween(Long value1, Long value2) {
            addCriterion("qa_id between", value1, value2, "qaId");
            return (Criteria) this;
        }

        public Criteria andQaIdNotBetween(Long value1, Long value2) {
            addCriterion("qa_id not between", value1, value2, "qaId");
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

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andRootQaIdIsNull() {
            addCriterion("root_qa_id is null");
            return (Criteria) this;
        }

        public Criteria andRootQaIdIsNotNull() {
            addCriterion("root_qa_id is not null");
            return (Criteria) this;
        }

        public Criteria andRootQaIdEqualTo(Long value) {
            addCriterion("root_qa_id =", value, "rootQaId");
            return (Criteria) this;
        }

        public Criteria andRootQaIdNotEqualTo(Long value) {
            addCriterion("root_qa_id <>", value, "rootQaId");
            return (Criteria) this;
        }

        public Criteria andRootQaIdGreaterThan(Long value) {
            addCriterion("root_qa_id >", value, "rootQaId");
            return (Criteria) this;
        }

        public Criteria andRootQaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("root_qa_id >=", value, "rootQaId");
            return (Criteria) this;
        }

        public Criteria andRootQaIdLessThan(Long value) {
            addCriterion("root_qa_id <", value, "rootQaId");
            return (Criteria) this;
        }

        public Criteria andRootQaIdLessThanOrEqualTo(Long value) {
            addCriterion("root_qa_id <=", value, "rootQaId");
            return (Criteria) this;
        }

        public Criteria andRootQaIdIn(List<Long> values) {
            addCriterion("root_qa_id in", values, "rootQaId");
            return (Criteria) this;
        }

        public Criteria andRootQaIdNotIn(List<Long> values) {
            addCriterion("root_qa_id not in", values, "rootQaId");
            return (Criteria) this;
        }

        public Criteria andRootQaIdBetween(Long value1, Long value2) {
            addCriterion("root_qa_id between", value1, value2, "rootQaId");
            return (Criteria) this;
        }

        public Criteria andRootQaIdNotBetween(Long value1, Long value2) {
            addCriterion("root_qa_id not between", value1, value2, "rootQaId");
            return (Criteria) this;
        }

        public Criteria andParentQaIdIsNull() {
            addCriterion("parent_qa_id is null");
            return (Criteria) this;
        }

        public Criteria andParentQaIdIsNotNull() {
            addCriterion("parent_qa_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentQaIdEqualTo(Long value) {
            addCriterion("parent_qa_id =", value, "parentQaId");
            return (Criteria) this;
        }

        public Criteria andParentQaIdNotEqualTo(Long value) {
            addCriterion("parent_qa_id <>", value, "parentQaId");
            return (Criteria) this;
        }

        public Criteria andParentQaIdGreaterThan(Long value) {
            addCriterion("parent_qa_id >", value, "parentQaId");
            return (Criteria) this;
        }

        public Criteria andParentQaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_qa_id >=", value, "parentQaId");
            return (Criteria) this;
        }

        public Criteria andParentQaIdLessThan(Long value) {
            addCriterion("parent_qa_id <", value, "parentQaId");
            return (Criteria) this;
        }

        public Criteria andParentQaIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_qa_id <=", value, "parentQaId");
            return (Criteria) this;
        }

        public Criteria andParentQaIdIn(List<Long> values) {
            addCriterion("parent_qa_id in", values, "parentQaId");
            return (Criteria) this;
        }

        public Criteria andParentQaIdNotIn(List<Long> values) {
            addCriterion("parent_qa_id not in", values, "parentQaId");
            return (Criteria) this;
        }

        public Criteria andParentQaIdBetween(Long value1, Long value2) {
            addCriterion("parent_qa_id between", value1, value2, "parentQaId");
            return (Criteria) this;
        }

        public Criteria andParentQaIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_qa_id not between", value1, value2, "parentQaId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
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

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table question_answer
     *
     * @mbggenerated do_not_delete_during_merge Mon Jul 25 14:41:39 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table question_answer
     *
     * @mbggenerated Mon Jul 25 14:41:39 CST 2016
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