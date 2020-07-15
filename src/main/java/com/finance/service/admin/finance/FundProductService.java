package com.finance.service.admin.finance;



import com.finance.pojo.others.FundProduct;

import java.util.List;

public interface FundProductService {
    List<FundProduct> selectFundProductAll();
    int insertFundProduct(FundProduct fundProduct);

    FundProduct selectFundProductById(int id);

    int updateFundProduct(FundProduct fundProduct);

    int deleteFundProductById(int id);
}
