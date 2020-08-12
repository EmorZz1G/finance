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
public class PayMoney implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 工资理财 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 每月金额设定
     */
    @TableField("monthMoney")
    private BigDecimal monthMoney;

    /**
     * 1:每月自动转入   2：每月不自动转入
     */
    @TableField("autoInto")
    private Integer autoInto;

    /**
     * 产品类型（1：国债  2：期货）
     */
    private Integer type;

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

    public BigDecimal getMonthMoney() {
        return monthMoney;
    }

    public void setMonthMoney(BigDecimal monthMoney) {
        this.monthMoney = monthMoney;
    }

    public Integer getAutoInto() {
        return autoInto;
    }

    public void setAutoInto(Integer autoInto) {
        this.autoInto = autoInto;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    @Override
    public String toString() {
        return "PayMoney{" +
        "id=" + id +
        ", monthMoney=" + monthMoney +
        ", autoInto=" + autoInto +
        ", type=" + type +
        ", invesTerm=" + invesTerm +
        "}";
    }
}
