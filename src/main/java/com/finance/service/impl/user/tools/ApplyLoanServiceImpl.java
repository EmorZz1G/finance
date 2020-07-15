package com.finance.service.impl.user.tools;

import com.finance.mapper.others.LoanMapper;
import com.finance.pojo.others.Loan;
import com.finance.service.user.tools.ApplyLoanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApplyLoanServiceImpl implements ApplyLoanService {
    @Resource
    LoanMapper loanMapper;

    @Override
    public int insertApplyLoan(Loan loan) {
        loan.setLoanStatus(0);
        loan.setApplyStatus(0);
        return loanMapper.insertSelective(loan);
    }
}
