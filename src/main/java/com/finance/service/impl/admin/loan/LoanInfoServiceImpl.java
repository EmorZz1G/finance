package com.finance.service.impl.admin.loan;

import com.finance.mapper.others.LoanMapper;
import com.finance.pojo.others.Loan;
import com.finance.service.admin.loan.LoanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoanInfoServiceImpl implements LoanInfoService {
    @Autowired
    private LoanMapper loanMapper;

    @Override
    public List<Loan> selectAllLoanInfo(){
        return loanMapper.selectByExample(null);
    }
}
