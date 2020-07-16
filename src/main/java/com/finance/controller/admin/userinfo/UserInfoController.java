package com.finance.controller.admin.userinfo;

import com.finance.common.LockHelper;
import com.finance.common.Result;
import com.finance.pojo.user.User;
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
import java.util.List;
import java.util.concurrent.locks.Lock;

@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

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

    @PutMapping("/user/updateUserProfile/{id}")
    @ResponseBody
    public Result updateUserProfile(@PathVariable("id") int id, User user) {
        user.setId(id);
        int i = userInfoService.updateUser(user);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
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
                             Model model) {
        ReputationController.extraction(pageNum,pageSize,model,userInfoService.selectUsers());

/*        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userInfoService.selectUsers();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        model.addAttribute("userList", users);
        model.addAttribute("userPageInfo", userPageInfo);*/

        return "admin/userinfo/userinfo.html";
    }
}
