package com.finance.controller.user.finance;

import com.finance.common.Result;
import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.user.UserChangeMoney;
import com.finance.service.admin.finance.ChangeMoneyService;
import com.finance.service.user.finance.UserChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Controller
public class UserChangeMoneyController {
    @Autowired
    UserChangeMoneyService userChangeMoneyService;
    @Autowired
    ChangeMoneyService changeMoneyService;
    @RequestMapping("/user/finance/toChangeMoney.html")
    public ModelAndView toChangeMoney()
    {
        ModelAndView modelAndView = new ModelAndView("user/finance/changemoney.html");
        List<ChangeMoney> changeMoneyList=userChangeMoneyService.selectChangeMoneyAll();
        modelAndView.addObject("changeMoneyList",changeMoneyList);

        return modelAndView;

    }
    @PostMapping("/user/buyChangeMoney")
    @ResponseBody
    public Result addUserChangeMoney(@RequestParam("changeMoneyId")int id,@RequestParam("userId")int userid){
        UserChangeMoney userChangeMoney=new UserChangeMoney();
        ChangeMoney changeMoney=changeMoneyService.selectChangeMoneyById(id);
        BigDecimal averYield= changeMoney.getAnnualIncome();
        BigDecimal invesMoney=changeMoney.getInvesMoney();
        BigDecimal profit= averYield.multiply(invesMoney);
        userChangeMoney.setUserId(userid);
        userChangeMoney.setAverYield(averYield);
        userChangeMoney.setProfit(profit);
        userChangeMoney.setChangeId(id);
        userChangeMoney.setStartTime(new Date());
        userChangeMoney.setStatus(1);
        int i = userChangeMoneyService.insertUserChangeMoney(userChangeMoney);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }


}
