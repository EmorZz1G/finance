package com.finance.service.impl.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finance.mapper.plus.user.UserMapperPlus;
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
    UserMapperPlus userMapperPlus;


    /**
     *  公用的处理方法，用于判断是否成功，且用于将List<xxx>转化为xxx并只取首个结果
     * @param example 要查询的example对象
     * @return 返回查询结果，成功返回查询结果中的首个结果，失败返回null
     */
    /*public Object getObject(Object example){
        if (example instanceof UserExample){
            List<User> objs = userMapper.selectByExample((UserExample)example);
            if (objs!=null&&objs.size()==1){
                return objs.get(0);
            }
        }
        return null;
    }*/


    /**
     * 查询手机号是否存在
     * @param userPhone 要验证的手机号
     * @return 返回查询结果
     */
    @Override
    public User loginVerifyUserPhone(String userPhone) {
        /*UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(userPhone);
        return (User) getObject(userExample);*/
        return userMapperPlus.selectOne(new QueryWrapper<User>().eq("phone",userPhone));
    }

    /**
     * 查询与传过来的用户名密码相同的用户账号
     * @param userPhone 要登录的手机号
     * @param password 密码
     * @return 返回查询结果
     */
    @Override
    public User loginUserByPhone(String userPhone, String password) {
        /*UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andPhoneEqualTo(userPhone);
        criteria.andPasswordEqualTo(password);
        return (User) getObject(userExample);*/
        return userMapperPlus.selectOne(new QueryWrapper<User>().eq("phone",userPhone)
                .eq("password",password));
    }


    /**
     * 修改用户为在线状态
     * @param user 要修改的用户
     * @return 返回更新是否成功（成功为1，失败为0）
     */
    @Override
    public int status2online(User user) {
        user.setStatus(1);
        return userMapperPlus.updateById(user);
    }

    /**
     * 修改用户为离线状态
     * @param user 要修改的用户
     * @return 返回更新是否成功（成功为1，失败为0）
     */
    @Override
    public int status2Disconnected(User user) {
        user.setStatus(0);
        return userMapperPlus.updateById(user);
    }
}
