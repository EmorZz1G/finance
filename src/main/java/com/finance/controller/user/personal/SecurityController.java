package com.finance.controller.user.personal;


import com.finance.common.Result;
import com.finance.service.user.personal.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController {

    @Autowired
    SecurityService securityService;

    @GetMapping("/user/personal/toSecurity.html")
    public String toSecurity(){
        return "/user/personal/security";
    }

    /**
     * 修改登录密码
     * @param id：当前用户id
     * @param oldpwd：旧密码
     * @param newpwd：新密码
     * @return
     */
    @PutMapping("/user/updatePwd")
    @ResponseBody
    public Result updatePwd(@RequestParam("id")int id,
                            @RequestParam("oldpwd")String oldpwd,
                            @RequestParam("newpwd")String newpwd){
        int i = securityService.updateUserPassword(id, oldpwd, newpwd);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
}
