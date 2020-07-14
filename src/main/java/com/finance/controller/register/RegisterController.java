package com.finance.controller.register;


import com.finance.common.Result;
import com.finance.pojo.user.User;
import com.finance.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @Autowired
    RegisterService registerService;

    @PostMapping("/login/register")
    @ResponseBody
    public Result doRegister(User user){
        boolean register = registerService.register(user);
        if(register){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

    @GetMapping("toregister.html")
    public String toRegister(){
        return "register";
    }
}
