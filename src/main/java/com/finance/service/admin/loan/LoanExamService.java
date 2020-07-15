package com.finance.service.admin.loan;

import com.finance.pojo.others.Loan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Mapper
public interface LoanExamService {
    public List<Loan> selectAllLoanExam();
//    public int updateLoanExam(Loan loan);
     public int updateLoanExam(Loan loan);

}
