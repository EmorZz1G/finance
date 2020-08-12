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
public class TermFinancial implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 期限理财产品 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 投资期限
     */
    @TableField("invesTerm")
    private String invesTerm;

    /**
     * 起投金额
     */
    @TableField("leastMoney")
    private BigDecimal leastMoney;

    /**
     * 收益方式(1:收益型  2:净值型)
     */
    private Integer profit;

    /**
     * 七日年化收益率
     */
    @TableField("annualIncome")
    private BigDecimal annualIncome;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    public BigDecimal getLeastMoney() {
        return leastMoney;
    }

    public void setLeastMoney(BigDecimal leastMoney) {
        this.leastMoney = leastMoney;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    @Override
    public String toString() {
        return "TermFinancial{" +
        "id=" + id +
        ", name=" + name +
        ", invesTerm=" + invesTerm +
        ", leastMoney=" + leastMoney +
        ", profit=" + profit +
        ", annualIncome=" + annualIncome +
        "}";
    }
}
