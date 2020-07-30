package com.finance.controller.login;


import com.finance.common.LockHelper;
import com.finance.common.Result;
import com.finance.common.annotation.UserAvatarAnno;
import com.finance.controller.admin.userinfo.ReputationController;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.user.User;
import com.finance.service.login.LoginService;
import com.finance.service.user.userinfo.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

@Controller
public class LoginController {


    @Autowired
    LoginService loginService;

    @Autowired
    UserInfoService userInfoService;

    /**
     * 实现用户（管理员）登录请求路径请求到登录界面
     * @return 返回html文件，实现请求路径和界面的绑定
     */
    @GetMapping({"/", "/login","/index.html"})
    public String toLogin() {
        return "login";
    }


    /**
     * 实现管理员主界面请求路径请求到管理员主界面，并将主页面上的用户在线信息查询显示出来
     * @param pageNum 页面数
     * @param pageSize 页面大小
     * @param model 绑定到页面的model
     * @return 绑定的管理员主页面的html文件
     */
    @GetMapping(value = {"/admin/toAdminMain",
            "/admin/index.html"})
    public String toAdminMain(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                              Model model) {
        ReputationController.extraction(pageNum, pageSize, model,userInfoService);
        return "admin/main";
    }


    /**
     * 验证用户（管理员）需要登录的账号是否存在
     * @param username 登录的账号（用户名）
     * @return 返回查找结果（存在/不存在）
     */
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

    /**
     *  判断登录密码是否正确
     * @param username 登录的用户名（管理员用户名）
     * @param password 密码
     * @param session 浏览器的session，以便将要登入的信息存入session中
     * @return 返回验证结果，密码正确或错误，正确则再返回个url路径，跳转到用户主界面（管理员主界面）
     */
    @GetMapping("/login/verifyLogin")
    @ResponseBody
    @UserAvatarAnno
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

    /**
     * 实现用户（管理员）的退出登录功能
     * @param logoutType 前端传过来的退出登录状态标志
     * @param session 浏览器的session，用于获取当前登录的账号信息，以便将其登录状态改为离线
     * @return 使退出登录后跳转到登录界面
     */
    @GetMapping("/logout")
    public String logout(@RequestParam(value = "logout", defaultValue = "") String logoutType,
                         HttpSession session) throws InterruptedException {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if ("adminLogout".equals(logoutType)) {
                    session.invalidate();
                } else if ("userLogout".equals(logoutType)) {
                    User user = (User) session.getAttribute("loginUser");
                    loginService.status2Disconnected(user);
                    LockHelper.removeSession(user);
                }
            }
        }, 1000);
        return "login";
    }
}
