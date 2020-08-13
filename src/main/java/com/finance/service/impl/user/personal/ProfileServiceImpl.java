package com.finance.service.impl.user.personal;


import com.finance.mapper.plus.user.UserMapperPlus;
import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.service.user.personal.ProfileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserMapperPlus userMapperPlus;
    @Override
    public int updateUserProfile(User user) {
        return userMapperPlus.updateById(user);
    }

    @Override
    public User selectUserById(int id) {
        return userMapperPlus.selectById(id);
    }
}
