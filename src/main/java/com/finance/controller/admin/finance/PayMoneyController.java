package com.finance.controller.admin.finance;

import com.finance.common.Result;
import com.finance.pojo.others.PayMoney;
import com.finance.service.admin.finance.PayMoneyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PayMoneyController {
    @Autowired
    PayMoneyService payMoneyService;


    @RequestMapping(value = "/admin/deletePayMoneyById/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public Result deletePayMoneyById(@PathVariable("id") int id) {
        int i = payMoneyService.deletePayMoneyById(id);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }


    @RequestMapping(value = "/admin/updatePayMoney/{id}"
            , method = RequestMethod.PUT)
    @ResponseBody
    public Result updatePayMoney(@PathVariable("id") int id, PayMoney payMoney) {
        payMoney.setId(id);
        int i = payMoneyService.updatePayMoney(payMoney);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }


    @RequestMapping(value = "/admin/getPayMoneyInfoById/{id}"
            , method = RequestMethod.GET)
    @ResponseBody
    public Result getPayMoneyInfoById(@PathVariable("id") int id) {
        PayMoney payMoney = payMoneyService.selectPayMoneyById(id);
        Result result = Result.success().add("payMoney", payMoney);
        return result;
    }


    @RequestMapping(value = "/admin/addPayMoney",
            method = RequestMethod.POST)
    @ResponseBody
    public Result addPayMoney(PayMoney payMoney) {
        int i = payMoneyService.insertPayMoney(payMoney);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }

    /**
     * 去工资理财页面，获取工资理财信息
     * @param pageNum 页数
     * @param pageSize  页大小
     * @return
     */
    @GetMapping("/admin/finance/toPayMoney.html")
    public ModelAndView toPayMoney(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        ModelAndView modelAndView = new ModelAndView("admin/finance/paymoney.html");
        PageHelper.startPage(pageNum, pageSize);
        List<PayMoney> payMoneyList = payMoneyService.selectAllPayMoney();
        PageInfo<PayMoney> payMoneyPageInfo = new PageInfo<>(payMoneyList);
        modelAndView.addObject("financeList", payMoneyList);
        modelAndView.addObject("financePageInfo", payMoneyPageInfo);
        return modelAndView;
    }
}
