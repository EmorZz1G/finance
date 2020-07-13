package com.finance.controller.user.userinfo;

import com.finance.common.Result;
import com.finance.pojo.user.User;
import com.finance.service.user.userinfo.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("/user/getUserById/{id}")
    @ResponseBody
    public Result getUserById(@PathVariable("id") int id) {
        User user = userInfoService.selectUserById(id);
        Result result = Result.success().add("user", user);
        return result;
    }

    @PutMapping("/user/updateUserProfile/{id}")
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

    @DeleteMapping("/user/deleteUserById/{id}")
    @ResponseBody
    public Result deleteUserById(@PathVariable("id") int id) {
        int i = userInfoService.deleteUserById(id);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

    @PostMapping("/user/addUser")
    @ResponseBody
    public Result addUser(User user){
        int i = userInfoService.insertUser(user);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

    @RequestMapping("/admin/userinfo/toUserInfo.html")
    public ModelAndView toUserInfo(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        ModelAndView modelAndView = new ModelAndView("admin/userinfo/userinfo.html");
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userInfoService.selectUsers();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        modelAndView.addObject("userList",users);
        modelAndView.addObject("userPageInfo",userPageInfo);
        return modelAndView;
    }
}
