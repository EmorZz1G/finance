package com.finance.pojo.user;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Emor
 * @since 2020-08-12
 */
public class UserFundProduct implements Serializable {

    private static final long serialVersionUID=1L;
    @TableField(exist = false)
    private User user;

    @Override
    public String toString() {
        return "UserFundProduct{" +
                "user=" + user +
                ", id=" + id +
                ", userId=" + userId +
                ", fundId=" + fundId +
                ", startTime=" + startTime +
                ", averYield=" + averYield +
                ", profit=" + profit +
                ", status=" + status +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 用户-基金理财 投资表id 主键 自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 基金产品id
     */
    @TableField("fundId")
    private Integer fundId;

    /**
     * 起投时间
     */
    @TableField("startTime")
    private LocalDate startTime;

    /**
     * 平均投资率
     */
    @TableField("averYield")
    private BigDecimal averYield;

    /**
     * 收益
     */
    private BigDecimal profit;

    /**
     * 投资状态（1：持有中  2：已失效  3：已撤销）
     */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public BigDecimal getAverYield() {
        return averYield;
    }

    public void setAverYield(BigDecimal averYield) {
        this.averYield = averYield;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
