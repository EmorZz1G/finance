package com.finance.controller.user.userinfo;


import com.finance.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class BankcardController {

    @PutMapping("/user/updateUserProfile/{id}")
    public String updateUserProfile(){

    }

    @GetMapping("/user/getUserById/{id}")
    public Result getUserById(){

    }
}
