package com.finance.service.user.personal;

import com.finance.pojo.others.Loan;
import com.finance.pojo.user.User;

import java.util.List;

public interface MyLoanService {
    List<Loan> selectMyLoans(User user);

    /**
     * 还款
     * @param loan
     * @return
     */
    int repayment(Loan loan);
}
