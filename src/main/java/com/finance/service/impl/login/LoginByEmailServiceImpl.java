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

    /**
     *  公用的处理方法，用于判断是否成功，且用于将List<xxx>转化为xxx并只取首个结果
     * @param example 要查询的example对象
     * @return 返回查询结果，成功返回查询结果中的首个结果，失败返回null
     */
    public Object getObject(Object example){
        if (example instanceof UserExample){
            List<User> objs = userMapper.selectByExample((UserExample)example);
            if (objs!=null&&objs.size()==1){
                return objs.get(0);
            }
        }
        return null;
    }

    /**
     * 查询邮箱是否存在
     * @param userEmail 要验证的邮箱号
     * @return 返回查询结果
     */
    @Override
    public User loginVerifyUserEmail(String userEmail) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(userEmail);
        return (User) getObject(userExample);
    }

    /**
     * 查询与传过来的用户名密码相同的用户账号
     * @param userEmail 要登录的邮箱
     * @param password 密码
     * @return 返回查询结果
     */
    @Override
    public User loginUserByEmail(String userEmail, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(userEmail);
        criteria.andPasswordEqualTo(password);
        return (User) getObject(userExample);
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
