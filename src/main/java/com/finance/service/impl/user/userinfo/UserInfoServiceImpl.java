package com.finance.service.impl.user.userinfo;

import com.finance.common.utils.FuzzySearchUtils;
import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.user.userinfo.UserInfoService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
            UserExample example = (UserExample) FuzzySearchUtils.autoWrapper(UserExample.class, query);
            List<User> users = userMapper.selectByExample(example);
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Resource
    UserMapper userMapper;

    private int checkUserValid(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria c1 = userExample.createCriteria();
        c1.andPhoneEqualTo(user.getPhone());
        UserExample.Criteria c2 = userExample.createCriteria();
        c2.andEmailEqualTo(user.getEmail());
        userExample.or(c2);
        List<User> users = userMapper.selectByExample(userExample);
        if (users != null && users.size() > 0) {
            return 0;
        }
        return 1;
    }


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
    @Caching(evict = {@CacheEvict(cacheNames = "userInfo", key = "#user.id"),
            @CacheEvict(cacheNames = {"userPermsSet", "userPermsList"}, key = "#user.id")})
    public int updateUser(User user) {
        if (checkUserValid(user) == 1) {
            return userMapper.updateByPrimaryKeySelective(user);
        }
        return 0;
    }

    @Override
    @CacheEvict(key = "#id")
    public int deleteUserById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertUser(User user) {
        if (checkUserValid(user) == 1) {
            return userMapper.updateByPrimaryKeySelective(user);
        }
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
