package com.finance.controller.admin.userinfo;

import com.finance.common.LockHelper;
import com.finance.common.Result;
import com.finance.pojo.user.User;
import com.finance.service.admin.permission.UserPermissionsService;
import com.finance.service.user.userinfo.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Lock;

@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    UserPermissionsService permissionsService;

    private Result LogoutUserById(int id, int status) {
        User user = userInfoService.selectUserById(id);
        LockHelper.removeSession(user);
        if (status == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }


    @GetMapping("/user/getUserById/{id}")
    @ResponseBody
    public Result getUserById(@PathVariable("id") int id) {
        User user = userInfoService.selectUserById(id);
        Result result = Result.success().add("user", user);
        return result;
    }



    @DeleteMapping("/user/deleteUserById/{id}")
    @ResponseBody
    public Result deleteUserById(@PathVariable("id") int id) {
        int i = userInfoService.deleteUserById(id);
        return LogoutUserById(id, i);
    }

    @PostMapping("/user/addUser")
    @ResponseBody
    public Result addUser(User user) {
        int i = userInfoService.insertUser(user);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }

    @PutMapping("/user/updateUserStatus/{id}")
    @ResponseBody
    public Result updateUserStatus(@PathVariable("id") int id
    ) {
        int i = userInfoService.updateUserStatusById(id);
        return LogoutUserById(id, i);
    }

    @RequestMapping("/admin/userinfo/toUserInfo.html")
    public String toUserInfo(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                             @RequestParam(value = "username",defaultValue = "") String username,
                             @RequestParam(value = "realname",defaultValue = "") String realname,
                             @RequestParam(value = "phone",defaultValue = "") String phone,
                             @RequestParam(value = "email",defaultValue = "") String email,
                             Model model) {
        HashMap<String, Object> query = new HashMap<>();
        System.out.println(username);
        query.put("username", username);
        query.put("realname", realname);
        query.put("phone", phone);
        query.put("email", email);
        System.out.println(query);
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userInfoService.selectUsersByQuery(query);
        System.out.println(users);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        model.addAttribute("userList",users);
        model.addAttribute("query",query);
        model.addAttribute("userPageInfo",userPageInfo);
        return "admin/userinfo/userinfo.html";
    }
}
