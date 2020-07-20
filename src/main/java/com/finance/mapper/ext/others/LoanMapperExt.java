package com.finance.mapper.ext.others;

import com.finance.mapper.others.LoanMapper;
import com.finance.pojo.others.Loan;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface LoanMapperExt extends LoanMapper {

    @Select("SELECT * from loan\n" +
            "where loanStatus = #{loanStatus}\n" +
            "limit #{pageNum},#{pageSize}")
    List<Loan> autoRemindPay(int pageNum, int pageSize, int loanStatus);


    @Select("SELECT count(0) from loan\n" +
            "where loanStatus = #{loanStatus}\n")
    int getTotalCount(int loanStatus);

    @Select("SELECT * from loan\n" +
            "where loanStatus = #{loanStatus}\n" +
            "and DATE_ADD( now(),INTERVAL 3 day) >= loanTime;\n" +
            "limit #{pageNum},#{pageSize}")
    List<Loan> notOverdue(int pageNum, int pageSize, int loanStatus);


    @Select("SELECT * from loan\n" +
            "where loanStatus = #{loanStatus}\n" +
            "and DATE_ADD( loanTime,INTERVAL 1 day) >= now();")
    List<Loan> overdue(int pageNum, int pageSize, int loanStatus);

    @Update("UPDATE loan\n" +
            "set loanStatus = 1\n" +
            "WHERE loanStatus = 0\n" +
            "and DATE_ADD( loanTime,INTERVAL 1 day) <= now();")
    int updateOverdue();
}
