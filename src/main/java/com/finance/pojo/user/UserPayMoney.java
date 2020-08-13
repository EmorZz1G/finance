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
public class UserPayMoney implements Serializable {

    private static final long serialVersionUID=1L;
    @TableField(exist = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserPayMoney{" +
                "user=" + user +
                ", id=" + id +
                ", userId=" + userId +
                ", payId=" + payId +
                ", startTime=" + startTime +
                ", averYield=" + averYield +
                ", profit=" + profit +
                ", status=" + status +
                '}';
    }

    /**
     * 用户-工资理财 投资表id 主键自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 工资理财产品id
     */
    @TableField("payId")
    private Integer payId;

    /**
     * 起投时间
     */
    @TableField("startTime")
    private LocalDate startTime;

    /**
     * 平均收益率
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

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
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
