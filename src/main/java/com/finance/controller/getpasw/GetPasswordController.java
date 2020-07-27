package com.finance.controller.getpasw;

import com.finance.common.Result;
import com.finance.pojo.user.User;
import com.finance.service.getpasw.GetPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class GetPasswordController {
    @Autowired
    GetPasswordService getPasswordService;

    /**
     * 实现找回密码路径请求到找回密码界面
     * @return 返回html文件，实现请求路径和界面的绑定
     */
    @GetMapping("/togetPasw.html")
    public String getPasw() {
        return "getpasw";
    }


    /**
     * 验证用户需要找回的账号是否存在
     * @param username 用户需要找回的用户名
     * @return 返回查找结果（存在/不存在）
     */
    @GetMapping("/getPassword/getPasswordVerifyUsername/{username}")
    @ResponseBody
    public Result getPasswordVerifyUsername(@PathVariable("username") String username) {
        User user = getPasswordService.getPasswordVerifyUsername(username);
        if (user != null) {
            return Result.success();
        }
        return Result.failure();
    }

    /**
     * 验证绑定的身份验证信息是否正确
     * @param getPasw 身份验证信息，绑定的电话号或邮箱
     * @param username 用户名
     * @return 返回验证结果(验证成功/验证不成功)
     */
    @GetMapping("/getPassword/getPasswordVerifyUserInfo/")
    @ResponseBody
    public Result getPasswordVerifyUserInfo(@PathParam("getPasw") String getPasw,
                                            @PathParam("username") String username){
        User user1 = getPasswordService.getPasswordVerifyUserInfoByEmail(username,getPasw);
        if (user1 != null){
            return Result.success();
        }
        User user2 = getPasswordService.getPasswordVerifyUserInfoByPhone(username,getPasw);
        if (user2 != null){
            return Result.success();
        }
        return Result.failure();
    }

    /**
     * 实现用户新密码的设置，将新密码更新到数据库里
     * @param user 验证成功的用户信息（用户名，新密码）
     * @return 成功返回跳转路径，跳转到登录界面
     */
    @PostMapping("/getPassword/getPassword/")
    @ResponseBody
    public Result doGetPassword(User user){
        boolean getPassword = getPasswordService.getPassword(user);
        if(getPassword){
            return Result.success().add("url","/login");
        }else {
            return Result.failure();
        }
    }
}
