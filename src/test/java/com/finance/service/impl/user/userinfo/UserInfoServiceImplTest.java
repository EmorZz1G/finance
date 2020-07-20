package com.finance.service.impl.user.userinfo;

import com.finance.pojo.user.User;
import com.finance.service.user.userinfo.UserInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserInfoServiceImplTest {

    @Autowired
    UserInfoService userInfoService;

    @Test
    void selectUsersByQuery() {
        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("username","li");
        List<User> users = userInfoService.selectUsersByQuery(stringStringMap);
        System.out.println(users);
        stringStringMap.put("password", "123");
        stringStringMap.put("realname", "李");
        users = userInfoService.selectUsersByQuery(stringStringMap);
        System.out.println(users);
    }
}