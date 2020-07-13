package com.finance.controller.user.userinfo;

import com.finance.common.Result;
import com.finance.pojo.user.User;
import com.finance.service.user.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/getUserById/{id}")
    @ResponseBody
    public Result getUserById(@PathVariable("id") int id) {
        User user = userInfoService.selectUserById(id);
        Result result = Result.success().add("user", user);
        return result;
    }

    @PutMapping("/updateUserProfile/{id}")
    @ResponseBody
    public Result updateUserProfile(@PathVariable("id") int id, User user) {
        user.setId(id);
        int i = userInfoService.updateUser(user);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

    @DeleteMapping("/deleteUserById/{id}")
    @ResponseBody
    public Result deleteUserById(@PathVariable("id") int id) {
        int i = userInfoService.deleteUserById(id);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

    @PostMapping("/addUser")
    @ResponseBody
    public Result addUser(User user){
        int i = userInfoService.insertUser(user);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
}
