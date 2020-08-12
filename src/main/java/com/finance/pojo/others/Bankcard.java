package com.finance.pojo.others;

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
public class Bankcard implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 银行卡编号 主键自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 银行卡所属银行
     */
    @TableField("cardBank")
    private String cardBank;

    /**
     * 银行卡类型（1：借记卡  2：信用卡）
     */
    private Integer type;

    /**
     * 银行卡号
     */
    @TableField("cardNum")
    private String cardNum;

    /**
     * 银行卡所属用户
     */
    @TableField("userId")
    private Integer userId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardBank() {
        return cardBank;
    }

    public void setCardBank(String cardBank) {
        this.cardBank = cardBank;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Bankcard{" +
        "id=" + id +
        ", cardBank=" + cardBank +
        ", type=" + type +
        ", cardNum=" + cardNum +
        ", userId=" + userId +
        "}";
    }
}
