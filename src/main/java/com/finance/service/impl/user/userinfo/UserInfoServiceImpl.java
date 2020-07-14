package com.finance.service.impl.user.userinfo;

import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.service.user.userinfo.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> selectUsers() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User selectUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUserStatusById(int id) {
        User user = new User();
        user.setId(id);
        user.setStatus(0);
        return userMapper.updateByPrimaryKeySelective(user);
    }

}
