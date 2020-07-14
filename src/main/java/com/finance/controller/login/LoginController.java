package com.finance.controller.login;


import com.finance.common.Result;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.user.User;
import com.finance.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {


    @Autowired
    LoginService loginService;

    @GetMapping({"/"})
    public String toLogin(){
        return "login";
    }

    @GetMapping("/toUserMain")
    public String toUserMain(){
        return "user/main";
    }


    @GetMapping("/toAdminMain")
    public String toAdminMain(){
        return "admin/main";
    }

    @GetMapping("/login/loginVerifyUsername/{username}")
    @ResponseBody
    public Result loginVerifyUsername(@PathVariable("username") String username){
        Admin admin = loginService.loginVerifyUsername(username);
        if (admin==null){
            return Result.failure();
        }else {
            return Result.success();
        }
    }

    @GetMapping("/login/verifyLogin")
    @ResponseBody
    public Result verifyLogin(@RequestParam("username") String username,
                              @RequestParam("password")String password){
        User user = loginService.loginForUser(username, password);
        if(user!=null){
            Result success = Result.success();
            success.add("url","toUserMain");
            return success;
        }
        Admin admin = loginService.loginForAdmin(username,password);
        if(admin!=null){
            Result success = Result.success();
            success.add("url","toAdminMain");
            return success;
        }
        return Result.failure();
    }
}
