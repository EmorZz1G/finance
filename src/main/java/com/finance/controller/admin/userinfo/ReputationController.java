package com.finance.controller.admin.userinfo;


import com.finance.pojo.user.User;
import com.finance.service.user.userinfo.ReputationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReputationController {

    @Autowired
    ReputationService reputationService;

    public static void extraction(int pageNum, int pageSize, Model model, List<User> users2) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = users2;
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        model.addAttribute("userList", users);
        model.addAttribute("userPageInfo", userPageInfo);
    }

    @GetMapping("admin/userinfo/toReputation.html")
    public String toReputation(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                               Model model) {
        extraction(pageNum, pageSize, model, reputationService.selectUsers());
        return "admin/userinfo/reputation.html";
    }

}
