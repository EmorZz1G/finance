package com.finance.service.admin.loan;

import com.finance.pojo.others.Loan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface LoanInfoService {
    List<Loan> selectAllLoanInfo();

    List<Loan> selectUsersByQuery(Map<String,Object> query);

    List<Loan> selectUsersByQueryHa(Map<String,Object> query);
}
