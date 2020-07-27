package com.finance.controller.login;

import com.finance.common.LockHelper;
import com.finance.common.Result;
import com.finance.common.annotation.UserAvatarAnno;
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

    /**
     *  实现按邮箱登录请求到邮箱登入方式的界面
     * @return 返回html文件，实现请求路径和界面的绑定
     */
    @GetMapping("/tologinByEmail.html")
    public String loginByEmail(){
        return "loginbyemail";
    }

    /**
     * 查询判断要登入的邮箱账号是否存在
     * @param userEmail 用户账号绑定的邮箱
     * @return 返回查询结果（查询成功(存在)/查询失败（不存在））
     */
    @GetMapping("/login/loginByEmail/loginVerifyUserEmail/{userEmail}")
    @ResponseBody
    public Result loginVerifyUserEmail(@PathVariable("userEmail") String userEmail){
        User user = loginByEmailService.loginVerifyUserEmail(userEmail);
        if (user != null) {
            return Result.success();
        }
        return Result.failure();
    }

    /**
     * 判断登录密码是否正确
     * @param userEmail 要登录的邮箱账号
     * @param password 密码
     * @param session 浏览器的session，以便将要登入的信息存入session中
     * @return 返回验证结果，密码正确或错误，正确则再返回个url路径，跳转到用户主界面
     */
    @GetMapping("/login/loginByEmail/verifyLogin")
    @ResponseBody
    @UserAvatarAnno
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
