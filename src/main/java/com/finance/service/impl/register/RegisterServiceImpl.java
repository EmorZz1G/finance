package com.finance.service.impl.register;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finance.mapper.plus.user.UserMapperPlus;
import com.finance.mapper.user.UserMapper;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.register.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    UserMapperPlus userMapperPlus;

    /**
     * 向数据库中添加要注册的用户信息
     * @param user 要注册的用户信息
     * @return 返回添加的结果成功为1
     */
    @Override
    public boolean register(User user) {
        /*UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        int i = userMapper.countByExample(userExample);*/

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        int i = userMapperPlus.selectCount((wrapper.eq("username",user.getUsername())));
        if(i>=1){
            return false;
        }
        user.setStatus(0);
        return userMapperPlus.insert(user)==1;
    }
}
