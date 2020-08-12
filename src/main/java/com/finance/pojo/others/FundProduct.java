package com.finance.pojo.others;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
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
public class FundProduct implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 基金理财产品  主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 基金类型(1:股票型基金  2:债券型基金  3:货币型基金  4:混合型基金)
     */
    private Integer type;

    /**
     * 基金代码
     */
    private Integer code;

    /**
     * 基金简称
     */
    @TableField("fundDesc")
    private String fundDesc;

    /**
     * 日增长率
     */
    @TableField("dailyGrowth")
    private BigDecimal dailyGrowth;

    /**
     * 月增长率
     */
    @TableField("monthlyGrowth")
    private BigDecimal monthlyGrowth;

    /**
     * 年增长率
     */
    @TableField("annualGrowth")
    private BigDecimal annualGrowth;

    /**
     * 起投金额
     */
    @TableField("leastMoney")
    private BigDecimal leastMoney;

    /**
     * 投资期限
     */
    @TableField("invesTerm")
    private String invesTerm;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getFundDesc() {
        return fundDesc;
    }

    public void setFundDesc(String fundDesc) {
        this.fundDesc = fundDesc;
    }

    public BigDecimal getDailyGrowth() {
        return dailyGrowth;
    }

    public void setDailyGrowth(BigDecimal dailyGrowth) {
        this.dailyGrowth = dailyGrowth;
    }

    public BigDecimal getMonthlyGrowth() {
        return monthlyGrowth;
    }

    public void setMonthlyGrowth(BigDecimal monthlyGrowth) {
        this.monthlyGrowth = monthlyGrowth;
    }

    public BigDecimal getAnnualGrowth() {
        return annualGrowth;
    }

    public void setAnnualGrowth(BigDecimal annualGrowth) {
        this.annualGrowth = annualGrowth;
    }

    public BigDecimal getLeastMoney() {
        return leastMoney;
    }

    public void setLeastMoney(BigDecimal leastMoney) {
        this.leastMoney = leastMoney;
    }

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    @Override
    public String toString() {
        return "FundProduct{" +
        "id=" + id +
        ", type=" + type +
        ", code=" + code +
        ", fundDesc=" + fundDesc +
        ", dailyGrowth=" + dailyGrowth +
        ", monthlyGrowth=" + monthlyGrowth +
        ", annualGrowth=" + annualGrowth +
        ", leastMoney=" + leastMoney +
        ", invesTerm=" + invesTerm +
        "}";
    }
}
