package com.finance.controller.admin.permission;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PermsCommonController {

    /**
     * 未授予页面跳转
     * @return
     */
    @GetMapping("/unUnauthorized")
    public String toUnauthorized(){
        return "unAuth";
    }
}
