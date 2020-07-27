package com.finance.config;

import com.finance.pojo.user.User;
import com.finance.service.admin.permission.AdminPermissionsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class MyRedisConfigTest {


    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

@Autowired
    AdminPermissionsService permissionsService;

    @Test
    public void test() {
        User user = new User();
        user.setUsername("hehe");
        List<String> strings = permissionsService.selectPermsListByAdminId(1);
        System.out.println(strings);
        redisTemplate.opsForValue().set("myList::"+1,strings);

    }
}