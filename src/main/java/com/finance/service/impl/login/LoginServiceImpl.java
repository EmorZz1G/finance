package com.finance.service.impl.login;

import com.finance.mapper.admin.AdminMapper;
import com.finance.mapper.user.UserMapper;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.admin.AdminExample;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.login.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UserMapper userMapper;

    @Resource
    AdminMapper adminMapper;


    public Object getObject(Object example){
        if(example instanceof AdminExample){
            List<Admin> objs = adminMapper.selectByExample((AdminExample)example);
            if (objs!=null&&objs.size()==1){
                return objs.get(0);
            }
        }else if (example instanceof UserExample){
            List<User> objs = userMapper.selectByExample((UserExample)example);
            if (objs!=null&&objs.size()==1){
                return objs.get(0);
            }
        }
        return null;
    }

    @Override
    public Admin loginVerifyUsername(String username) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return (Admin) getObject(adminExample);
    }

    @Override
    public User loginVerifyUsernameForUser(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return (User) getObject(userExample);
    }

    @Override
    public User loginForUser(String username, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        return (User) getObject(userExample);
    }

    @Override
    public Admin loginForAdmin(String username, String password) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameLike(username);
        criteria.andPasswordEqualTo(password);
        return (Admin) getObject(adminExample);
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
