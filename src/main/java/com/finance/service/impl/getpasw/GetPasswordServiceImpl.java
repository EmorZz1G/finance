package com.finance.service.impl.getpasw;

import com.finance.mapper.user.UserMapper;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.admin.AdminExample;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.getpasw.GetPasswordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GetPasswordServiceImpl implements GetPasswordService {
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
    public User getPasswordVerifyUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return (User) getObject(userExample);
    }

    @Override
    public User getPasswordVerifyUserInfoByPhone(String username, String getPasw) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPhoneEqualTo(getPasw);
        return (User) getObject(userExample);
    }

    @Override
    public User getPasswordVerifyUserInfoByEmail(String username, String getPasw) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andEmailEqualTo(getPasw);
        return (User) getObject(userExample);
    }

    @Override
    public boolean getPassword(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        return userMapper.updateByExampleSelective(user,userExample)==1;
    }
}
