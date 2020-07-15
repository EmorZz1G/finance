package com.finance.service.impl.admin.loan;

import com.finance.mapper.others.LoanMapper;
import com.finance.pojo.others.Loan;
import com.finance.pojo.others.LoanExample;
import com.finance.pojo.user.UserExample;
import com.finance.service.admin.loan.LoanExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanExamServiceImpl implements LoanExamService {
    @Autowired
    private LoanMapper loanMapper;

    @Override
    public List<Loan> selectAllLoanExam() {
        return loanMapper.selectByExample(null);
    }

    @Override
    public int updateLoanExam(Loan loan) {
        LoanExample loanExample = new LoanExample();
        LoanExample.Criteria criteria = loanExample.createCriteria();
        criteria.andIdEqualTo(loan.getId());
        return loanMapper.updateByPrimaryKeySelective(loan);
    }


}
