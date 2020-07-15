package com.finance.controller.user.finance;

import com.finance.common.Result;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.TermFinancial;
import com.finance.pojo.user.UserTermFinancial;
import com.finance.service.user.finance.UserTermFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class UserTermFinancialController {
    @Autowired
    UserTermFinancialService userTermFinancialService;

    @RequestMapping(value = "/user/finance/toTermFinancial.html",
            method = RequestMethod.GET)
    public ModelAndView toTermFinancial(){
        List<TermFinancial> termFinancialList = userTermFinancialService.selectAllUserTermFinancial();
        ModelAndView modelAndView = new ModelAndView("/user/finance/termfinancial.html");
        modelAndView.addObject("termFinancialList",termFinancialList);
        return modelAndView;
    }

    @RequestMapping(value = "/user/buyTermFinancial",
            method = RequestMethod.POST)
    @ResponseBody
    public Result addUserTermFinancial(@RequestParam("userId") Integer userId,@RequestParam("termFinancialId") Integer termFinancialId ){

        UserTermFinancial userTermFinancial = new UserTermFinancial();
        FlowOfFunds flowOfFunds = new FlowOfFunds();
        TermFinancial termFinancial = userTermFinancialService.selectById(termFinancialId);

        userTermFinancial.setUserId(userId);
        userTermFinancial.setTermId(termFinancialId);
        userTermFinancial.setStartTime(new Date());
        userTermFinancial.setAverYield(termFinancial.getAnnualIncome());
        BigDecimal param1 = termFinancial.getAnnualIncome();
        BigDecimal param2 = termFinancial.getLeastMoney();
        BigDecimal param3 = param1.multiply(param2);
        userTermFinancial.setProfit(param3);
        userTermFinancial.setStatus(1);

        flowOfFunds.setUserId(userId);
        flowOfFunds.setCreateTime(new Date());
        flowOfFunds.setFlowMoney(termFinancial.getLeastMoney());
        flowOfFunds.setSource(termFinancial.getName());
        flowOfFunds.setType(1);
        flowOfFunds.setFundDesc("期限理财");




        int result1 = userTermFinancialService.insertUserTermFinancial(userTermFinancial);
        int result2 = userTermFinancialService.insertFlowOfFunds(flowOfFunds);
        if (result1 == 1&&result2 == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }
}
