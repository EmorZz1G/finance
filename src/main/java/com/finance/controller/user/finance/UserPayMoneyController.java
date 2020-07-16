package com.finance.controller.user.finance;

import com.finance.common.Result;
import com.finance.pojo.others.Bank;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.Loan;
import com.finance.pojo.others.PayMoney;
import com.finance.pojo.user.UserPayMoney;
import com.finance.service.admin.finance.PayMoneyService;
import com.finance.service.user.finance.UserPayMoneyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class UserPayMoneyController {
    @Autowired
    UserPayMoneyService userPayMoneyService;
    @Autowired
    PayMoneyService payMoneyService;

    @RequestMapping(value = "/user/finance/toPayMoney.html",
    method = RequestMethod.GET)
    public ModelAndView toPayMoney(){
        List<PayMoney> payMoneyList = userPayMoneyService.selectAllUserPayMoney();
        ModelAndView modelAndView = new ModelAndView("/user/finance/paymoney.html");
        modelAndView.addObject("payMoneyList",payMoneyList);
        return modelAndView;
    }


    @RequestMapping(value = "/user/buyPayMoney",
            method = RequestMethod.POST)
    @ResponseBody
    public Result addUserPayMoney(@RequestParam("userId") Integer userId,@RequestParam("payMoneyId") Integer payMoneyId) {
        UserPayMoney userPayMoney = new UserPayMoney() ;
        FlowOfFunds flowOfFunds = new FlowOfFunds();
        PayMoney payMoney = payMoneyService.selectPayMoneyById(payMoneyId);

        userPayMoney.setUserId(userId);
        userPayMoney.setPayId(payMoneyId);
        userPayMoney.setStartTime(new Date());
        BigDecimal param1 = payMoney.getMonthMoney();
        BigDecimal param2 = new BigDecimal("0.03123");
        BigDecimal param3 = param1.multiply(param2);
        userPayMoney.setAverYield(param2);
        userPayMoney.setProfit(param3);
        userPayMoney.setStatus(1);





        flowOfFunds.setUserId(userId);
        flowOfFunds.setCreateTime(new Date());
        flowOfFunds.setFlowMoney(payMoney.getMonthMoney());
        flowOfFunds.setSource("工资理财");
        flowOfFunds.setType(1);
        int i =  payMoney.getType();
        String str;
        if(i==1){
             str = "国债";
        }else{
            str = "期货";
        }
        flowOfFunds.setFundDesc(str);








        int result1 = userPayMoneyService.insertUserPayMoney(userPayMoney);
        int result2 = userPayMoneyService.insertFlowOfFunds(flowOfFunds);
        if (result1==1&&result2==2) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }


}
