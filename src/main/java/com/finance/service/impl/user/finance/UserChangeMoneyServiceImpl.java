package com.finance.service.impl.user.finance;

import com.finance.mapper.others.ChangeMoneyMapper;
import com.finance.mapper.user.UserChangeMoneyMapper;
import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.user.UserChangeMoney;
import com.finance.service.user.finance.UserChangeMoneyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserChangeMoneyServiceImpl implements UserChangeMoneyService {
    @Resource
    private ChangeMoneyMapper changeMoneyMapper;
    @Resource
    private UserChangeMoneyMapper userChangeMoneyMapper;
    @Override
    public List<ChangeMoney> selectChangeMoneyAll(){
        return changeMoneyMapper.selectByExample(null);
    }
    @Override
    public int insertUserChangeMoney(UserChangeMoney userChangeMoney){ return userChangeMoneyMapper.insertSelective(userChangeMoney); }
}
