package com.finance.service.impl.user.userinfo;

import com.finance.mapper.others.InfoMapper;
import com.finance.service.user.userinfo.UserInfoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
@RunWith(SpringRunner.class)
@SpringBootTest*/
class UserInfoServiceImplTest {

    @Autowired
    UserInfoService userInfoService;

    @Resource
    InfoMapper infoMapper;

    @Test
    void selectUsersByQuery() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ParseException {
        Map<String, Object> stringStringMap = new HashMap<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date min = simpleDateFormat.parse("2020-06-15");
        Date max = simpleDateFormat.parse("2020-08-20");
        stringStringMap.put("min-createTime", min);
        stringStringMap.put("max-createTime", max);
 /*       Object o = FuzzySearchUtils.autoWrapper(InfoExample.class, stringStringMap);
        List<Info> infos = infoMapper.selectByExample((InfoExample) o);
        System.out.println(infos);
        o = FuzzySearchUtils.autoWrapper(InfoExample.class, stringStringMap);
        stringStringMap.put("min-createTime", "2020-06-15");
        stringStringMap.put("max-createTime", "2020-08-15");
        infos = infoMapper.selectByExample((InfoExample) o);
        System.out.println(infos);

        o = FuzzySearchUtils.autoWrapper(InfoExample.class, stringStringMap);
        stringStringMap.put("min-createTime", "2020-06-15");
        stringStringMap.put("max-createTime", "2020-8-15");
        infos = infoMapper.selectByExample((InfoExample) o);
        System.out.println(infos);*/
    }
}