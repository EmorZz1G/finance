package com.finance.service.impl.user.personal;

import com.finance.mapper.user.UserChangeMoneyMapper;
import com.finance.mapper.user.UserFundProductMapper;
import com.finance.mapper.user.UserPayMoneyMapper;
import com.finance.mapper.user.UserTermFinancialMapper;
import com.finance.pojo.user.*;
import com.finance.service.user.personal.MyFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MyFinanceServiceImpl implements MyFinanceService {
    @Resource
    UserPayMoneyMapper userPayMoneyMapper;
    @Resource
    UserTermFinancialMapper userTermFinancialMapper;
    @Resource
    UserFundProductMapper userFundProductMapper;
    @Resource
    UserChangeMoneyMapper userChangeMoneyMapper;



    @Override
    public List<UserChangeMoney> selectUserChangeMoneyById(int id) {
        UserChangeMoneyExample userChangeMoneyExample = new UserChangeMoneyExample();
        UserChangeMoneyExample.Criteria criteria = userChangeMoneyExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return userChangeMoneyMapper.selectByExample(userChangeMoneyExample);
    }

    @Override
    public List<UserPayMoney> selectUserPayMoneyById(int id) {
        UserPayMoneyExample userPayMoneyExample = new UserPayMoneyExample();
        UserPayMoneyExample.Criteria criteria = userPayMoneyExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return userPayMoneyMapper.selectByExample(userPayMoneyExample);
    }

    @Override
    public List<UserFundProduct> selectUserFundProductById(int id) {
        UserFundProductExample userFundProductExample = new UserFundProductExample();
        UserFundProductExample.Criteria criteria = userFundProductExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return userFundProductMapper.selectByExample(userFundProductExample);
    }

    @Override
    public List<UserTermFinancial> selectUserTermFinancialById(int id) {
        UserTermFinancialExample userTermFinancialExample = new UserTermFinancialExample();
        UserTermFinancialExample.Criteria criteria = userTermFinancialExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return userTermFinancialMapper.selectByExample(userTermFinancialExample);
    }

    @Override
    public int updateUserChangeMoneyById(UserChangeMoney userChangeMoney) {
        return userChangeMoneyMapper.updateByPrimaryKeySelective(userChangeMoney);
    }

    @Override
    public int updateUserPayMoneyById(UserPayMoney userPayMoney) {
        return userPayMoneyMapper.updateByPrimaryKeySelective(userPayMoney);
    }

    @Override
    public int updateUserFundProductById(UserFundProduct userFundProduct) {
        return userFundProductMapper.updateByPrimaryKeySelective(userFundProduct);
    }

    @Override
    public int updateUserTermFinancialById(UserTermFinancial userTermFinancial) {
        return userTermFinancialMapper.updateByPrimaryKeySelective(userTermFinancial);
    }

}
