package com.finance.controller.user.userinfo;


import com.finance.pojo.user.User;
import com.finance.service.user.userinfo.ReputationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReputationController {

    @Autowired
    ReputationService reputationService;

    @GetMapping("admin/userinfo/toReputation.html")
    public ModelAndView toReputation(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        ModelAndView modelAndView = new ModelAndView("admin/userinfo/reputation.html");
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = reputationService.selectUsers();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        modelAndView.addObject("userList", users);
        modelAndView.addObject("userPageInfo", userPageInfo);
        return modelAndView;
    }
}
