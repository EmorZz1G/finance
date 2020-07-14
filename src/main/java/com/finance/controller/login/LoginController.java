package com.finance.controller.login;


import com.finance.common.Result;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.user.User;
import com.finance.service.login.LoginService;
import com.finance.service.user.userinfo.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {


    @Autowired
    LoginService loginService;

    @Autowired
    UserInfoService userInfoService;


    @GetMapping({"/"})
    public String toLogin() {
        return "login";
    }

    @GetMapping("/toUserMain")
    public String toUserMain() {
        return "user/main";
    }


    @GetMapping(value = {"/toAdminMain",
                         "/admin/index.html"})
    public String toAdminMain(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                              Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userInfoService.selectUsers();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        model.addAttribute("userList", users);
        model.addAttribute("userPageInfo", userPageInfo);
        return "admin/main";
    }

    @GetMapping("/login/loginVerifyUsername/{username}")
    @ResponseBody
    public Result loginVerifyUsername(@PathVariable("username") String username) {
        Admin admin = loginService.loginVerifyUsername(username);
        if (admin == null) {
            return Result.failure();
        } else {
            return Result.success();
        }
    }

    @GetMapping("/login/verifyLogin")
    @ResponseBody
    public Result verifyLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        User user = loginService.loginForUser(username, password);
        if (user != null) {
            Result success = Result.success();
            success.add("url", "toUserMain");
            return success;
        }
        Admin admin = loginService.loginForAdmin(username, password);
        if (admin != null) {
            Result success = Result.success();
            success.add("url", "toAdminMain");
            return success;
        }
        return Result.failure();
    }
}
