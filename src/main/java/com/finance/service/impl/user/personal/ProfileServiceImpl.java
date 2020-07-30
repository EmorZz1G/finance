package com.finance.service.impl.user.personal;


import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.service.user.personal.ProfileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Resource
    UserMapper userMapper;

    @Override
    public int updateUserProfile(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
