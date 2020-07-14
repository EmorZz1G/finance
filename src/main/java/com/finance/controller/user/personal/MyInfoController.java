package com.finance.controller.user.personal;


import com.finance.pojo.others.Info;
import com.finance.pojo.user.User;
import com.finance.service.user.personal.MyInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyInfoController {

    @Autowired
    MyInfoService myInfoService;

    @GetMapping("/user/personal/toMyInfo.html")
    public ModelAndView toMyInfo(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                 ModelAndView modelAndView,
                                 HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        User loginUser = (User) session.getAttribute("loginUser");
        List<Info> infos = myInfoService.selectInfosByUserId(loginUser.getId());
        PageInfo<Info> infoPageInfo = new PageInfo<>(infos);
        modelAndView.setViewName("user/personal/myinfo");
        modelAndView.addObject("infoList", infos);
        modelAndView.addObject("infoPageInfo", infoPageInfo);
        return modelAndView;
    }
}
