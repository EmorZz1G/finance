package com.finance.service.impl.register;

import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.register.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    UserMapper userMapper;

    /**
     * 向数据库中添加要注册的用户信息
     * @param user 要注册的用户信息
     * @return 返回添加的结果成功为1
     */
    @Override
    public boolean register(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        int i = userMapper.countByExample(userExample);
        if(i>=1){
            return false;
        }
        criteria.andPasswordEqualTo(user.getPassword());
        criteria.andStatusEqualTo(0);
        return userMapper.insertSelective(user)==1;
    }
}
