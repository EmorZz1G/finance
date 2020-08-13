package com.finance.service.impl.user.personal;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finance.mapper.others.LoanMapper;
import com.finance.mapper.plus.others.LoanMapperPlus;
import com.finance.pojo.others.Loan;
import com.finance.pojo.others.LoanExample;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.user.personal.MyLoanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MyLoanServiceImpl implements MyLoanService {

    @Resource
    LoanMapper loanMapper;
    @Resource
    LoanMapperPlus loanMapperPlus;

    @Override
    public List<Loan> selectMyLoans(User user) {
        /*LoanExample loanExample = new LoanExample();
        LoanExample.Criteria criteria = loanExample.createCriteria();
        criteria.andLoanIdEqualTo(user.getId());
        return loanMapper.selectByExample(loanExample);*/
        return loanMapperPlus.selectList(new QueryWrapper<Loan>().lambda()
        .eq(Loan::getLoanId,user.getId()));
    }

    @Override
    public int repayment(Loan loan) {
        loan.setLoanStatus(2);
        return loanMapperPlus.updateById(loan);
    }
}
