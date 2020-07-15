package com.finance.service.impl.user.tools;

import com.finance.mapper.others.LoanMapper;
import com.finance.pojo.others.Loan;
import com.finance.service.user.tools.ApplyLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyLoanServiceImpl implements ApplyLoanService {
    @Autowired
    LoanMapper loanMapper;

    @Override
    public int insertApplyLoan(Loan loan) {
        return loanMapper.insertSelective(loan);
    }
}
