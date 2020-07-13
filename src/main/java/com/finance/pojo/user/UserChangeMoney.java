package com.finance.pojo.user;

import java.math.BigDecimal;
import java.util.Date;

public class UserChangeMoney {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_change_money.id
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_change_money.userId
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_change_money.changeId
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    private Integer changeid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_change_money.startTime
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    private Date starttime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_change_money.averYield
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    private BigDecimal averyield;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_change_money.profit
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    private BigDecimal profit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_change_money.status
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_change_money.id
     *
     * @return the value of user_change_money.id
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_change_money.id
     *
     * @param id the value for user_change_money.id
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_change_money.userId
     *
     * @return the value of user_change_money.userId
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_change_money.userId
     *
     * @param userid the value for user_change_money.userId
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_change_money.changeId
     *
     * @return the value of user_change_money.changeId
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public Integer getChangeid() {
        return changeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_change_money.changeId
     *
     * @param changeid the value for user_change_money.changeId
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public void setChangeid(Integer changeid) {
        this.changeid = changeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_change_money.startTime
     *
     * @return the value of user_change_money.startTime
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_change_money.startTime
     *
     * @param starttime the value for user_change_money.startTime
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_change_money.averYield
     *
     * @return the value of user_change_money.averYield
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public BigDecimal getAveryield() {
        return averyield;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_change_money.averYield
     *
     * @param averyield the value for user_change_money.averYield
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public void setAveryield(BigDecimal averyield) {
        this.averyield = averyield;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_change_money.profit
     *
     * @return the value of user_change_money.profit
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public BigDecimal getProfit() {
        return profit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_change_money.profit
     *
     * @param profit the value for user_change_money.profit
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_change_money.status
     *
     * @return the value of user_change_money.status
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_change_money.status
     *
     * @param status the value for user_change_money.status
     *
     * @mbggenerated Mon Jul 13 11:22:29 CST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}