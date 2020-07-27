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

    /**
     * 实现注册账号注册，将账号信息添加到数据库中
     * @param user 要注册的用户信息（用户名，密码...）
     * @return 返回注册结果成功或失败，成功再返回个url跳转到登录界面
     */
    @PostMapping("/login/register")
    @ResponseBody
    public Result doRegister(User user){
        boolean register = registerService.register(user);
        if(register){
            return Result.success().add("url", "/login");
        }else {
            return Result.failure();
        }
    }

    /**
     * 实现用户注册路径请求到注册界面
     * @return 返回html文件，实现请求路径和界面的绑定
     */
    @GetMapping("toregister.html")
    public String toRegister(){
        return "register";
    }
}
