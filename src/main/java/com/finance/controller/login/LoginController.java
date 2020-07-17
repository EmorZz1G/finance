package com.finance.controller.login;


import com.finance.common.LockHelper;
import com.finance.common.Result;
import com.finance.controller.admin.userinfo.ReputationController;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.user.User;
import com.finance.service.login.LoginService;
import com.finance.service.user.userinfo.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {


    @Autowired
    LoginService loginService;

    @Autowired
    UserInfoService userInfoService;

    @GetMapping({"/", "/login"})
    public String toLogin() {
        return "login";
    }


    @GetMapping(value = {"/admin/toAdminMain",
            "/admin/index.html"})
    public String toAdminMain(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                              Model model) {
        ReputationController.extraction(pageNum, pageSize, model,userInfoService);
        return "admin/main";
    }

    @GetMapping("/login/loginVerifyUsername/{username}")
    @ResponseBody
    public Result loginVerifyUsername(@PathVariable("username") String username) {
        Admin admin = loginService.loginVerifyUsername(username);
        if (admin != null) {
            return Result.success();
        }
        User user = loginService.loginVerifyUsernameForUser(username);
        if (user != null) {
            return Result.success();
        }
        return Result.failure();
    }

    @GetMapping("/login/verifyLogin")
    @ResponseBody
    public Result verifyLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        String msg="";
        try {
            subject.login(token);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        User user = loginService.loginForUser(username, password);
        if (user != null) {
            LockHelper.addUser(session, user);
            loginService.status2online(user);
            Result success = Result.success();
            success.add("url", "/user/toUserMain")
                    .add("msg", msg);
            return success;
        }
        Admin admin = loginService.loginForAdmin(username, password);
        if (admin != null) {
            session.setAttribute("loginAdmin", admin);
            Result success = Result.success();
            success.add("url", "/admin/toAdminMain").add("msg",msg);
            return success;
        }
        return Result.failure();
    }

    @GetMapping("/logout")
    public String logout(@RequestParam(value = "logout", defaultValue = "") String logoutType,
                         HttpSession session) {
        if ("adminLogout".equals(logoutType)) {
            session.invalidate();
        } else if ("userLogout".equals(logoutType)) {
            User user = (User) session.getAttribute("loginUser");
            loginService.status2Disconnected(user);
            LockHelper.removeSession(user);
        }
        return "login";
    }
}
