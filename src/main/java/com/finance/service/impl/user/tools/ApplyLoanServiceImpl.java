package com.finance.service.impl.user.tools;

import com.finance.mapper.others.LoanMapper;
import com.finance.mapper.plus.others.LoanMapperPlus;
import com.finance.pojo.others.Loan;
import com.finance.service.user.tools.ApplyLoanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ApplyLoanServiceImpl implements ApplyLoanService {
    @Resource
    LoanMapper loanMapper;
    @Resource
    LoanMapperPlus loanMapperPlus;

    @Override
    public int insertApplyLoan(Loan loan) {
        loan.setApplyStatus(0);
        loan.setLoanStatus(0);
        return loanMapperPlus.insert(loan);
    }
}
