package com.finance.service.impl.user.userinfo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finance.common.utils.FuzzySearchUtils;
import com.finance.mapper.plus.user.UserMapperPlus;
import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.user.userinfo.ReputationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service
public class ReputationServiceImpl implements ReputationService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserMapperPlus userMapperPlus;


    @Override
    public List<User> selectUsers() {
//        return userMapper.selectByExample(null);
        return userMapperPlus.selectList(null);
    }

    @Override
    public List<User> selectUsersByQuery(Map<String, Object> query) {
        try {
            /*UserExample example = (UserExample) FuzzySearchUtils.autoWrapper(UserExample.class, query);
            List<User> users = userMapper.selectByExample(example);
            return users;*/
            return userMapperPlus.selectList(FuzzySearchUtils.autoWrapper(new QueryWrapper<User>(), query));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
