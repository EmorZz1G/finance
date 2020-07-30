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


    /**
     *  公用的处理方法，用于判断查询是否成功，且用于将List<xxx>转化为xxx并只取首个结果
     * @param example 要查询的example对象
     * @return 返回查询结果，成功返回查询结果中的首个结果，失败返回null
     */
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

    /**
     * 查询管理员用户名是否存在
     * @param username 要验证管理员的用户名
     * @return 返回查询结果
     */
    @Override
    public Admin loginVerifyUsername(String username) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return (Admin) getObject(adminExample);
    }

    /**
     * 查询用户用户名是否存在
     * @param username 要验证用户的用户名
     * @return 返回查询结果
     */
    @Override
    public User loginVerifyUsernameForUser(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return (User) getObject(userExample);
    }

    /**
     * 查询与传过来的用户的用户名密码相同的用户账号
     * @param username 用户的用户名
     * @param password 密码
     * @return 返回查询结果
     */
    @Override
    public User loginForUser(String username, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        return (User) getObject(userExample);
    }

    /**
     * 查询与传过来的管理员的用户名密码相同的用户账号
     * @param username 管理员的用户名
     * @param password 密码
     * @return 返回查询结果
     */
    @Override
    public Admin loginForAdmin(String username, String password) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andUsernameLike(username);
        criteria.andPasswordEqualTo(password);
        return (Admin) getObject(adminExample);
    }

    /**
     * 修改用户为在线状态
     * @param user 要修改的用户
     * @return 返回更新是否成功（成功为1，失败为0）
     */
    @Override
    public int status2online(User user) {
        user.setStatus(1);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 修改用户为离线状态
     * @param user 要修改的用户
     * @return 返回更新是否成功（成功为1，失败为0）
     */
    @Override
    public int status2Disconnected(User user) {
        user.setStatus(0);
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
