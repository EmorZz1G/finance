package com.finance.controller.admin.userinfo;


import com.finance.pojo.user.User;
import com.finance.service.user.userinfo.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/userinfo/toUserInfo.html")
    public ModelAndView toUserInfo(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        ModelAndView modelAndView = new ModelAndView("admin/userinfo/userinfo.html");
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userInfoService.selectUsers();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        modelAndView.addObject("userList",users);
        modelAndView.addObject("userPageInfo",userPageInfo);
        return modelAndView;
    }
}
