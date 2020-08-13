package com.finance.service.impl.user.personal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finance.mapper.plus.user.UserChangeMoneyMapperPlus;
import com.finance.mapper.plus.user.UserFundProductMapperPlus;
import com.finance.mapper.plus.user.UserPayMoneyMapperPlus;
import com.finance.mapper.plus.user.UserTermFinancialMapperPlus;
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
    @Resource
    UserPayMoneyMapperPlus userPayMoneyMapperPlus;
    @Resource
    UserTermFinancialMapperPlus userTermFinancialMapperPlus;
    @Resource
    UserFundProductMapperPlus userFundProductMapperPlus;
    @Resource
    UserChangeMoneyMapperPlus userChangeMoneyMapperPlus;



    @Override
    public List<UserChangeMoney> selectUserChangeMoneyById(int id) {
        /*UserChangeMoneyExample userChangeMoneyExample = new UserChangeMoneyExample();
        UserChangeMoneyExample.Criteria criteria = userChangeMoneyExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return userChangeMoneyMapper.selectByExample(userChangeMoneyExample);*/
        return userChangeMoneyMapperPlus.selectList(new QueryWrapper<UserChangeMoney>().eq("userId",id));
    }

    @Override
    public List<UserPayMoney> selectUserPayMoneyById(int id) {
      /*  UserPayMoneyExample userPayMoneyExample = new UserPayMoneyExample();
        UserPayMoneyExample.Criteria criteria = userPayMoneyExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return userPayMoneyMapper.selectByExample(userPayMoneyExample);*/
        return userPayMoneyMapperPlus.selectList(new QueryWrapper<UserPayMoney>().eq("userId",id));
    }

    @Override
    public List<UserFundProduct> selectUserFundProductById(int id) {
      /*  UserFundProductExample userFundProductExample = new UserFundProductExample();
        UserFundProductExample.Criteria criteria = userFundProductExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return userFundProductMapper.selectByExample(userFundProductExample);*/
        return userFundProductMapperPlus.selectList(new QueryWrapper<UserFundProduct>().eq("userId",id));
    }

    @Override
    public List<UserTermFinancial> selectUserTermFinancialById(int id) {
        /*UserTermFinancialExample userTermFinancialExample = new UserTermFinancialExample();
        UserTermFinancialExample.Criteria criteria = userTermFinancialExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return userTermFinancialMapper.selectByExample(userTermFinancialExample);*/
        return userTermFinancialMapperPlus.selectList(new QueryWrapper<UserTermFinancial>().eq("userId",id));
    }

    @Override
    public int updateUserChangeMoneyById(UserChangeMoney userChangeMoney) {
        return userChangeMoneyMapperPlus.updateById(userChangeMoney);
    }

    @Override
    public int updateUserPayMoneyById(UserPayMoney userPayMoney) {
        return userPayMoneyMapperPlus.updateById(userPayMoney);
    }

    @Override
    public int updateUserFundProductById(UserFundProduct userFundProduct) {
        return userFundProductMapperPlus.updateById(userFundProduct);
    }

    @Override
    public int updateUserTermFinancialById(UserTermFinancial userTermFinancial) {
        return userTermFinancialMapperPlus.updateById(userTermFinancial);
    }

}
