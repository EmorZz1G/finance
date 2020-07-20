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

    @GetMapping("/togetPasw.html")
    public String getPasw() {
        return "getpasw";
    }

    @GetMapping("/getPassword/getPasswordVerifyUsername/{username}")
    @ResponseBody
    public Result getPasswordVerifyUsername(@PathVariable("username") String username) {
        User user = getPasswordService.getPasswordVerifyUsername(username);
        if (user != null) {
            return Result.success();
        }
        return Result.failure();
    }

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
