package com.finance.service.impl.user.userinfo;

import com.finance.common.utils.FuzzySearchUtils;
import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.user.userinfo.UserInfoService;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
@CacheConfig(cacheNames = "userInfo")
public class UserInfoServiceImpl implements UserInfoService {
    @Override

    public List<User> selectUsersByQuery(Map<String, Object> query) {
        try {
            UserExample example = (UserExample)FuzzySearchUtils.autoWrapper(UserExample.class, query);
            List<User> users = userMapper.selectByExample(example);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Resource
    UserMapper userMapper;

    @Override
    public List<User> selectUsers() {
        return userMapper.selectByExample(null);
    }

    @Override
    @Cacheable(key = "#id")
    public User selectUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    // TODO
    @CacheEvict(key = "#id")
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @CacheEvict(key = "#id")
    public int deleteUserById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    // TODO
    @CacheEvict(key = "#id")
    public int insertUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> selectOnlineStatusUsers() {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andStatusEqualTo(1);
        return userMapper.selectByExample(userExample);
    }


    @Override
    @CacheEvict(key = "#id")
    public int updateUserStatusById(int id) {
        User user = new User();
        user.setId(id);
        user.setStatus(0);
        return userMapper.updateByPrimaryKeySelective(user);
    }

}
