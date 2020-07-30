package com.finance.service.user.personal;

import com.finance.pojo.others.TermFinancial;
import com.finance.pojo.user.UserChangeMoney;
import com.finance.pojo.user.UserFundProduct;
import com.finance.pojo.user.UserPayMoney;
import com.finance.pojo.user.UserTermFinancial;

import java.util.List;

public interface MyFinanceService {
    List<UserChangeMoney> selectUserChangeMoneyById(int id);
    List<UserPayMoney> selectUserPayMoneyById(int id);
    List<UserFundProduct> selectUserFundProductById(int id);
    List<UserTermFinancial> selectUserTermFinancialById(int id);

    int updateUserChangeMoneyById(UserChangeMoney userChangeMoney);
    int updateUserPayMoneyById(UserPayMoney userPayMoney);
    int updateUserFundProductById(UserFundProduct userFundProduct);
    int updateUserTermFinancialById(UserTermFinancial userTermFinancial);
}
