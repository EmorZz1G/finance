package com.finance.service.impl.register;

import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.register.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    UserMapper userMapper;

    @Override
    public boolean register(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        int i = userMapper.countByExample(userExample);
        if(i>=1){
            return false;
        }
        criteria.andPasswordEqualTo(user.getPassword());
        criteria.andStatusEqualTo(0);
        return userMapper.insertSelective(user)==1;
    }
}
