package com.finance.controller.login;

import com.finance.common.LockHelper;
import com.finance.common.Result;
import com.finance.common.annotation.UserAvatarAnno;
import com.finance.pojo.user.User;
import com.finance.service.login.LoginByPhoneService;
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
public class LoginByPhoneController {
    @Autowired
    LoginByPhoneService loginByPhoneService;

    @GetMapping("/tologinByPhone.html")
    public String loginByPhone(){
        return "loginbyphone";
    }

    @GetMapping("/login/loginByPhone/loginVerifyUserPhone/{userPhone}")
    @ResponseBody
    public Result loginVerifyUserPhone(@PathVariable("userPhone") String userPhone){
        User user = loginByPhoneService.loginVerifyUserPhone(userPhone);
        if (user != null) {
            return Result.success();
        }
        return Result.failure();
    }

    @GetMapping("/login/loginByPhone/verifyLogin")
    @ResponseBody
    @UserAvatarAnno
    public Result verifyLogin(@RequestParam("userPhone") String userPhone,
                              @RequestParam("password") String password,
                              HttpSession session){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userPhone, password);
        String msg="";
        try {
            subject.login(token);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        User user = loginByPhoneService.loginUserByPhone(userPhone, password);
        if (user != null) {
            LockHelper.addUser(session, user);
            loginByPhoneService.status2online(user);
            Result success = Result.success();
            success.add("url", "/user/toUserMain")
                    .add("msg", msg);
            return success;
        }
        return Result.failure();
    }
}
