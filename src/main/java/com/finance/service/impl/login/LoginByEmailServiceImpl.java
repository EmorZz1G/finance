package com.finance.service.impl.login;

import com.finance.mapper.user.UserMapper;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.admin.AdminExample;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.login.LoginByEmailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginByEmailServiceImpl implements LoginByEmailService {
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
    public User loginVerifyUserEmail(String userEmail) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(userEmail);
        return (User) getObject(userExample);
    }

    @Override
    public User loginUserByEmail(String userEmail, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(userEmail);
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
