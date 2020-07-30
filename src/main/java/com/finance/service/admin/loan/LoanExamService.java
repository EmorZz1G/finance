package com.finance.service.admin.loan;

import com.finance.pojo.admin.Admin;
import com.finance.pojo.others.Loan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoanExamService {
    List<Loan> selectAllLoanExam();

    int updateLoanExam(Loan loan,Admin admin,int type);

    int remindPay(Loan loan, Admin admin);

    List<Loan> autoRemindPay(int pageNum,int pageSize, int loanStatus);

    int getTotalCount(int loanStatus);

    List<Loan> notOverdue(int pageNum,int pageSize, int loanStatus);

    List<Loan> overdue(int pageNum,int pageSize, int loanStatus);

    int updateOverdue();

    List<Loan> selectLoanByQuery(Map<String,Object> query);

}
