package com.finance.service.impl.user.userinfo;

import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.service.user.userinfo.ReputationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ReputationServiceImpl implements ReputationService {

    @Resource
    UserMapper userMapper;


    @Override
    public List<User> selectUsers() {
        return userMapper.selectByExample(null);
    }
}
