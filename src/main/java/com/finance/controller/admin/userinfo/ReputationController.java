package com.finance.controller.admin.userinfo;


import com.finance.common.LockHelper;
import com.finance.pojo.user.User;
import com.finance.service.user.userinfo.ReputationService;
import com.finance.service.user.userinfo.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@Controller
public class ReputationController {

    @Autowired
    ReputationService reputationService;

    public static void extraction(int pageNum, int pageSize, Model model,Object service) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users =null;
        if(service instanceof ReputationService){
            users = ((ReputationService) service).selectUsers();
        }else if(service instanceof UserInfoService){
            users = ((UserInfoService) service).selectUsers();
        }else {
            return;
        }
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        model.addAttribute("userList", users);
        model.addAttribute("userPageInfo", userPageInfo);
        model.addAttribute("count", LockHelper.getCount());
    }

    /**
     * 去用户信誉管理页面，管理用户信誉
     * @param pageNum 页数
     * @param pageSize 页大小
     * @param username 用户名
     * @param reputation 用户信誉
     * @return
     */
    @GetMapping("admin/userinfo/toReputation.html")
    public String toReputation(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                               @RequestParam(value = "username",defaultValue = "") String username,
                               @RequestParam(value = "reputation",defaultValue = "") String reputation,
                               Model model) {
        HashMap<String, Object> query = new HashMap<>();
        query.put("username", username);
        query.put("reputation", reputation);
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = reputationService.selectUsersByQuery(query);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        model.addAttribute("userList",users);
        model.addAttribute("query",query);
        model.addAttribute("userPageInfo",userPageInfo);
        return "admin/userinfo/reputation.html";
    }

}
