package com.finance.controller;

import com.finance.mapper.others.BankMapper;
import com.finance.mapper.others.BankcardMapper;
import com.finance.mapper.user.UserMapper;
import com.finance.pojo.others.Bankcard;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class TestController {

    @Resource
    BankcardMapper bankcardMapper;

//    @Resource
//    BankMapper bankMapper;


    @Resource
    UserMapper userMapper;

    @RequestMapping("/test")
    @ResponseBody
    public List<Bankcard> test(){
        System.out.println(userMapper);
        return bankcardMapper.selectByExample(null);
    }
}
