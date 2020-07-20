package com.finance.controller.login;

import com.finance.common.LockHelper;
import com.finance.common.Result;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.user.User;
import com.finance.service.login.LoginByEmailService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginByEmailController {
    @Autowired
    LoginByEmailService loginByEmailService;

    @GetMapping("/tologinByEmail.html")
    public String loginByEmail(){
        return "loginbyemail";
    }

    @GetMapping("/login/loginByEmail/loginVerifyUserEmail/{userEmail}")
    @ResponseBody
    public Result loginVerifyUserEmail(@PathVariable("userEmail") String userEmail){
        User user = loginByEmailService.loginVerifyUserEmail(userEmail);
        if (user != null) {
            return Result.success();
        }
        return Result.failure();
    }

    @GetMapping("/login/loginByEmail/verifyLogin")
    @ResponseBody
    public Result verifyLogin(@RequestParam("userEmail") String userEmail,
                              @RequestParam("password") String password,
                              HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userEmail, password);
        String msg="";
        try {
            subject.login(token);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        User user = loginByEmailService.loginUserByEmail(userEmail, password);
        if (user != null) {
            LockHelper.addUser(session, user);
            loginByEmailService.status2online(user);
            Result success = Result.success();
            success.add("url", "/user/toUserMain")
                    .add("msg", msg);
            return success;
        }
        return Result.failure();
    }

}
