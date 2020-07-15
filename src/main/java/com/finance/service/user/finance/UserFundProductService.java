package com.finance.service.user.finance;

import com.finance.pojo.others.FundProduct;
import com.finance.pojo.user.UserFundProduct;

import java.util.List;

public interface UserFundProductService {
    List<FundProduct> selectFundProductAll();
    int insertUserFundProduct(UserFundProduct userFundProduct);
}
