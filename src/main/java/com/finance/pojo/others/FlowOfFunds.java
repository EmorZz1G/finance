package com.finance.pojo.others;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.finance.pojo.user.User;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Emor
 * @since 2020-08-12
 */
public class FlowOfFunds implements Serializable {

    private static final long serialVersionUID=1L;
    @TableField(exist = false)
    private User user;

    @Override
    public String toString() {
        return "FlowOfFunds{" +
                "user=" + user +
                ", id=" + id +
                ", userId=" + userId +
                ", flowMoney=" + flowMoney +
                ", type=" + type +
                ", source='" + source + '\'' +
                ", createTime=" + createTime +
                ", fundDesc='" + fundDesc + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static class Builder {
        private User user;

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        private Integer id;

        public Builder id(Integer id) {
            this.id = id;
            return this;
        }

        private Integer userId;

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        private BigDecimal flowMoney;

        public Builder flowMoney(BigDecimal flowMoney) {
            this.flowMoney = flowMoney;
            return this;
        }

        private Integer type;

        public Builder type(Integer type) {
            this.type = type;
            return this;
        }

        private String source;

        public Builder source(String source) {
            this.source = source;
            return this;
        }

        private LocalDate createTime;

        public Builder createTime(LocalDate createTime) {
            this.createTime = createTime;
            return this;
        }

        private String fundDesc;

        public Builder fundDesc(String fundDesc) {
            this.fundDesc = fundDesc;
            return this;
        }

        public Builder() {
        }

        public FlowOfFunds build() {
            return new FlowOfFunds(this);
        }

    }

    private static final Integer flowIn = 2;
    private static final Integer flowOut = 1;

    public static Integer flowIn() {
        return flowIn;
    }

    public static Integer flowOut() {
        return flowOut;
    }
    public FlowOfFunds() {
    }
    private FlowOfFunds(Builder builder) {
        this.user = builder.user;
        this.id = builder.id;
        this.userId = builder.userId;
        this.flowMoney = builder.flowMoney;
        this.type = builder.type;
        this.source = builder.source;
        this.createTime = builder.createTime;
        this.fundDesc = builder.fundDesc;
    }
    public FlowOfFunds(User user, Integer id, Integer userId, BigDecimal flowMoney, Integer type, String source, LocalDate createTime, String fundDesc) {
        this.user = user;
        this.id = id;
        this.userId = userId;
        this.flowMoney = flowMoney;
        this.type = type;
        this.source = source;
        this.createTime = createTime;
        this.fundDesc = fundDesc;
    }

    public FlowOfFunds(Integer id, Integer userId, BigDecimal flowMoney, Integer type, String source, LocalDate createTime, String fundDesc) {
        this.id = id;
        this.userId = userId;
        this.flowMoney = flowMoney;
        this.type = type;
        this.source = source;
        this.createTime = createTime;
        this.fundDesc = fundDesc;
    }

    /**
     * 资金记录表 id主键自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属用户
     */
    @TableField("userId")
    private Integer userId;

    /**
     * 金额
     */
    @TableField("flowMoney")
    private BigDecimal flowMoney;

    /**
     * 类型（1：支出  2：收入）
     */
    private Integer type;

    /**
     * 来源
     */
    private String source;

    /**
     * 创建时间
     */
    @TableField("createTime")
    private LocalDate createTime;

    /**
     * 备注
     */
    @TableField("fundDesc")
    private String fundDesc;


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

    public BigDecimal getFlowMoney() {
        return flowMoney;
    }

    public void setFlowMoney(BigDecimal flowMoney) {
        this.flowMoney = flowMoney;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getFundDesc() {
        return fundDesc;
    }

    public void setFundDesc(String fundDesc) {
        this.fundDesc = fundDesc;
    }

}
