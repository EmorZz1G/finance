package com.finance.service.impl.user.personal;


import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.user.personal.SecurityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Resource
    UserMapper userMapper;

    /**
     * 修改密码
     * @param id：用户id
     * @param oldpwd：旧密码
     * @param newpwd：新密码
     * @return
     */
    @Override
    public int updateUserPassword(int id, String oldpwd, String newpwd) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andPasswordEqualTo(oldpwd);
        List<User> users = userMapper.selectByExample(userExample);
        if(users==null||users.size()<=0){
            return 0;
        }
        User user = new User();
        user.setId(id);
        user.setPassword(newpwd);
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
