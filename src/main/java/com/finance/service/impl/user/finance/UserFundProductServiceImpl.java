package com.finance.service.impl.user.finance;

import com.finance.mapper.others.FundProductMapper;
import com.finance.mapper.user.UserFundProductMapper;
import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.others.FundProduct;
import com.finance.pojo.user.UserChangeMoney;
import com.finance.pojo.user.UserFundProduct;
import com.finance.service.user.finance.UserFundProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserFundProductServiceImpl implements UserFundProductService {
    @Resource
    private FundProductMapper fundProductMapper;
    @Resource
    private UserFundProductMapper userFundProductMapper;
    @Override
    public List<FundProduct> selectFundProductAll(){
        return fundProductMapper.selectByExample(null);
    }
    @Override
    public int insertUserFundProduct(UserFundProduct userFundProduct){ return userFundProductMapper.insertSelective(userFundProduct); }

}
