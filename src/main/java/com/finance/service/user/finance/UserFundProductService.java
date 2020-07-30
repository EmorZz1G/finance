package com.finance.service.user.finance;

import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.FundProduct;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserFundProduct;

import java.math.BigDecimal;
import java.util.List;

public interface UserFundProductService {
    List<FundProduct> selectFundProductAll();
    int insertUserFundProduct(User user , FundProduct fundProduct, BigDecimal money);
}
