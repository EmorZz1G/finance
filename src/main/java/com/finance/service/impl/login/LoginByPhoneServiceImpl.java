package com.finance.service.impl.login;

import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.login.LoginByPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginByPhoneServiceImpl implements LoginByPhoneService {
    @Resource
    UserMapper userMapper;

    public Object getObject(Object example){
        if (example instanceof UserExample){
            List<User> objs = userMapper.selectByExample((UserExample)example);
            if (objs!=null&&objs.size()==1){
                return objs.get(0);
            }
        }
        return null;
    }


    @Override
    public User loginVerifyUserPhone(String userPhone) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(userPhone);
        return (User) getObject(userExample);
    }

    @Override
    public User loginUserByPhone(String userPhone, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(userPhone);
        criteria.andPasswordEqualTo(password);
        return (User) getObject(userExample);
    }

    @Override
    public int status2online(User user) {
        user.setStatus(1);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int status2Disconnected(User user) {
        user.setStatus(0);
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
