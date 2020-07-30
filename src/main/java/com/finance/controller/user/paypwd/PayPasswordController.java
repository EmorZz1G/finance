package com.finance.controller.user.paypwd;


import com.finance.common.Result;
import com.finance.pojo.user.User;
import com.finance.service.user.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PayPasswordController {
    @Autowired
    UserInfoService userInfoService;

    /**
     * 对前端支付密码的ajax请求进行处理，对其进行验证
     * @param paypassword：用户输入的支付密码
     * @param user：当前登录的用户实体
     * @return
     */
    @PostMapping("/user/verifyPayPassword")
    @ResponseBody
    public Result payPassword(@RequestParam("paypassword") Integer paypassword, @SessionAttribute("loginUser") User user) {
        User user1 = userInfoService.selectUserById(user.getId());

        Integer paypwd = user1.getPaypwd();
        if (paypwd == null) {
            return Result.failure("没有设置支付密码");
        } else {
            if (paypassword.equals(paypwd)) {
                return Result.success();
            } else {
                return Result.failure();
            }
        }
    }
}
