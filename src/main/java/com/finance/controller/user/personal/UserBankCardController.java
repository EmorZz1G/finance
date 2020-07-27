package com.finance.controller.user.personal;

import com.finance.common.Result;
import com.finance.pojo.others.Bank;
import com.finance.pojo.others.Bankcard;
import com.finance.pojo.user.User;
import com.finance.service.user.personal.UserBankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserBankCardController {
    @Autowired
    UserBankCardService userBankCardService;

    /**
     * 添加绑定银行卡
     * @param bankcard：银行卡实体
     * @param request：实体变量
     * @return
     */
    @PostMapping("/user/addBankCard")
    @ResponseBody
    public Result addBankCard(Bankcard bankcard,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("loginUser");
        int id = user.getId();
        bankcard.setUserId(id);
        int i = userBankCardService.addBankCard(bankcard);
        if(i == 1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }


    /**
     * 显示用户所绑定的银行卡
     * @param request：定义的实体变量
     * @return
     */
    @GetMapping("/user/personal/toBankCard.html")
    public ModelAndView toBankCard(HttpServletRequest request){
        ModelAndView modelAndView =new ModelAndView("/user/personal/bankcard.html");
        User user = (User) request.getSession().getAttribute("loginUser");
        int id = user.getId();
        List<Bankcard> bankcardList = userBankCardService.selectBankCardById(id);
        modelAndView.addObject("bankCardList",bankcardList);
        return modelAndView;
    }
}
