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

    @Override
    public Admin loginVerifyUsername(String username) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameLike(username);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins!=null&&admins.size()==1){
            return admins.get(0);
        }else {
            return null;
        }
    }

    @Override
    public User loginForUser(String username, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if(users!=null&&users.size()==1){
            return users.get(0);
        }else {
            return null;
        }
    }

    @Override
    public Admin loginForAdmin(String username, String password) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameLike(username);
        criteria.andPasswordEqualTo(password);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins!=null&&admins.size()==1){
            return admins.get(0);
        }else {
            return null;
        }
    }

    @Override
    public int status2online(User user) {
        user.setStatus(1);
        return userMapper.insertSelective(user);
    }

    @Override
    public int status2Disconnected(User user) {
        user.setStatus(0);
        return userMapper.insertSelective(user);
    }
}
