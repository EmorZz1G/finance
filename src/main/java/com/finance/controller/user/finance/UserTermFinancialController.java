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

    /**
     * 查询显示所有期限理财的信息
     * @return
     */
    @RequestMapping(value = "/user/finance/toTermFinancial.html",
            method = RequestMethod.GET)
    public ModelAndView toTermFinancial(){
        List<TermFinancial> termFinancialList = userTermFinancialService.selectAllUserTermFinancial();
        ModelAndView modelAndView = new ModelAndView("/user/finance/termfinancial.html");
        modelAndView.addObject("termFinancialList",termFinancialList);
        return modelAndView;
    }

    /**
     * 对前端购买期限理财的ajax请求进行处理，在对应数据库里添加信息
     * @param userId：当前登录的用户id
     * @param money：用户输入的资金
     * @param termFinancialId：用户点击的理财产品id
     * @return
     */
    @RequestMapping(value = "/user/buyTermFinancial",
            method = RequestMethod.POST)
    @ResponseBody
    public Result addUserTermFinancial(@RequestParam("userId") Integer userId,@RequestParam("paymoney")BigDecimal money,@RequestParam("termFinancialId") Integer termFinancialId ){

        UserTermFinancial userTermFinancial = new UserTermFinancial();
        FlowOfFunds flowOfFunds = new FlowOfFunds();
        TermFinancial termFinancial = userTermFinancialService.selectById(termFinancialId);

        userTermFinancial.setUserId(userId);
        userTermFinancial.setTermId(termFinancialId);
        userTermFinancial.setStartTime(new Date());
        userTermFinancial.setAverYield(termFinancial.getAnnualIncome());
        BigDecimal param1 = termFinancial.getAnnualIncome();

        BigDecimal param3 = param1.multiply(money);
        userTermFinancial.setProfit(param3);
        userTermFinancial.setStatus(1);

        flowOfFunds.setUserId(userId);
        flowOfFunds.setCreateTime(new Date());
        flowOfFunds.setFlowMoney(money);
        flowOfFunds.setSource(termFinancial.getName());
        flowOfFunds.setType(1);
        flowOfFunds.setFundDesc("期限理财");




        int result1 = userTermFinancialService.insertUserTermFinancial(userTermFinancial,money);
        int result2 = userTermFinancialService.insertFlowOfFunds(flowOfFunds,money);
        if (result1 == 1&&result2 == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }
}
