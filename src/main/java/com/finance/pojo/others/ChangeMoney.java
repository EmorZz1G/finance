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
public class ChangeMoney implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 零钱理财产品 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 理财产品名称
     */
    private String name;

    /**
     * 七日年化收益率
     */
    @TableField("annualIncome")
    private BigDecimal annualIncome;

    /**
     * 每万元收益
     */
    @TableField("peiIncome")
    private BigDecimal peiIncome;

    /**
     * 投资期限
     */
    @TableField("invesTerm")
    private String invesTerm;

    /**
     * 起投金额
     */
    @TableField("invesMoney")
    private BigDecimal invesMoney;


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

    public BigDecimal getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(BigDecimal annualIncome) {
        this.annualIncome = annualIncome;
    }

    public BigDecimal getPeiIncome() {
        return peiIncome;
    }

    public void setPeiIncome(BigDecimal peiIncome) {
        this.peiIncome = peiIncome;
    }

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    public BigDecimal getInvesMoney() {
        return invesMoney;
    }

    public void setInvesMoney(BigDecimal invesMoney) {
        this.invesMoney = invesMoney;
    }

    @Override
    public String toString() {
        return "ChangeMoney{" +
        "id=" + id +
        ", name=" + name +
        ", annualIncome=" + annualIncome +
        ", peiIncome=" + peiIncome +
        ", invesTerm=" + invesTerm +
        ", invesMoney=" + invesMoney +
        "}";
    }
}
