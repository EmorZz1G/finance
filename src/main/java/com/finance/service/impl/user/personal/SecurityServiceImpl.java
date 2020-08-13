package com.finance.service.impl.user.personal;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finance.mapper.plus.user.UserMapperPlus;
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
    @Resource
    UserMapperPlus userMapperPlus;

    /**
     * 修改密码
     * @param id：用户id
     * @param oldpwd：旧密码
     * @param newpwd：新密码
     * @return
     */
    @Override
    public int updateUserPassword(int id, String oldpwd, String newpwd) {
        /*UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andPasswordEqualTo(oldpwd);
        List<User> users = userMapper.selectByExample(userExample);*/
        List<User> users = userMapperPlus.selectList(new QueryWrapper<User>().lambda()
                .eq(User::getId, id)
                .eq(User::getPassword, newpwd));
        if(users==null||users.size()<=0){
            return 0;
        }
        User user = new User();
        user.setId(id);
        user.setPassword(newpwd);
        return userMapperPlus.updateById(user);
    }
}
