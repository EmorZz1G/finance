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
     *  用于找回密码过程中查询要找回的账号是否存在
     * @param username 要找回的账号（用户名）
     * @return 返回查询结果
     */
    @Override
    public User getPasswordVerifyUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return (User) getObject(userExample);
    }

    /**
     * 在找回密码过程中，查询绑定的手机号，验证绑定的手机号是否正确
     * @param username 要找回的用户账号
     * @param getPasw 绑定的手机号
     * @return 返回查询结果
     */
    @Override
    public User getPasswordVerifyUserInfoByPhone(String username, String getPasw) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPhoneEqualTo(getPasw);
        return (User) getObject(userExample);
    }

    /**
     *  在找回密码过程中，查询绑定的邮箱号，验证绑定的邮箱号是否正确
     * @param username 要找回的用户账号
     * @param getPasw 绑定的邮箱号
     * @return 返回查询结果
     */
    @Override
    public User getPasswordVerifyUserInfoByEmail(String username, String getPasw) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andEmailEqualTo(getPasw);
        return (User) getObject(userExample);
    }

    /**
     * 进行用户信息更改，实现新密码的设置
     * @param user 找回的账号信息（用户名，新密码）
     * @return 返回更新成功标志
     */
    @Override
    public boolean getPassword(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        return userMapper.updateByExampleSelective(user,userExample)==1;
    }
}
