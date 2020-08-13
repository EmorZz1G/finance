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
public class Loan implements Serializable {

    private static final long serialVersionUID=1L;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @TableField(exist = false)
    private User user;

    @Override
    public String toString() {
        return "Loan{" +
                "user=" + user +
                ", id=" + id +
                ", loanId=" + loanId +
                ", examineId=" + examineId +
                ", loanTime=" + loanTime +
                ", amount=" + amount +
                ", term=" + term +
                ", rate=" + rate +
                ", applyStatus=" + applyStatus +
                ", loanStatus=" + loanStatus +
                ", loancol='" + loancol + '\'' +
                '}';
    }

    /**
     * 网贷信息表id 主键自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 借贷人id（用户）
     */
    @TableField("loanId")
    private Integer loanId;

    /**
     * 审核人id（管理员）
     */
    @TableField("examineId")
    private Integer examineId;

    /**
     * 借贷时间
     */
    @TableField("loanTime")
    private LocalDate loanTime;

    /**
     * 借贷金额
     */
    private BigDecimal amount;

    /**
     * 借贷期限（天）
     */
    private Integer term;

    /**
     * 固定年借贷利率
     */
    private BigDecimal rate;

    /**
     * 申请状态（0：未审核  1：审核未通过  2：审核通过）
     */
    @TableField("applyStatus")
    private Integer applyStatus;

    /**
     * 借贷状态（0：未逾期  1：逾期  2：已还请）
     */
    @TableField("loanStatus")
    private Integer loanStatus;

    private String loancol;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    public LocalDate getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(LocalDate loanTime) {
        this.loanTime = loanTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getLoancol() {
        return loancol;
    }

    public void setLoancol(String loancol) {
        this.loancol = loancol;
    }

}
