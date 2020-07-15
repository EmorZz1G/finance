package com.finance.controller.user.personal;

import com.finance.common.Result;
import com.finance.pojo.user.*;
import com.finance.service.user.personal.MyFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class MyFinanceController {
    @Autowired
    MyFinanceService myFinanceService;

    @PutMapping("/user/revokeUserChangeMoney")
    @ResponseBody
    public Result revokeUserChangeMoney(@PathParam("userChangeMoneyId") int userChangeMoneyId,UserChangeMoney userChangeMoney){
        userChangeMoney.setId(userChangeMoneyId);
        userChangeMoney.setStatus(3);
        int i = myFinanceService.updateUserChangeMoneyById(userChangeMoney);
        if(i == 1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

    @PutMapping("/user/revokeUserPayMoney")
    @ResponseBody
    public Result revokeUserPayMoney(@PathParam("userPayMoneyId") int userPayMoneyId,UserPayMoney userPayMoney){
        userPayMoney.setId(userPayMoneyId);
        userPayMoney.setStatus(3);
        int i = myFinanceService.updateUserPayMoneyById(userPayMoney);
        if(i == 1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

    @PutMapping("/user/revokeUserTermFinancial")
    @ResponseBody
    public Result revokeUserTermFinancial(@PathParam("userTermFinancialId") int userTermFinancialId,UserTermFinancial userTermFinancial){
        userTermFinancial.setId(userTermFinancialId);
        userTermFinancial.setStatus(3);
        int i = myFinanceService.updateUserTermFinancialById(userTermFinancial);
        if(i == 1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

    @PutMapping("/user/revokeUserFundProduct")
    @ResponseBody
    public Result revokeUserFundProduct(@PathParam("userFundProductId") int userFundProductId,UserFundProduct userFundProduct){
        userFundProduct.setId(userFundProductId);
        userFundProduct.setStatus(3);
        int i = myFinanceService.updateUserFundProductById(userFundProduct);
        if(i == 1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

    @GetMapping("/user/personal/toMyFinance.html")
    public ModelAndView toMyFinance(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("/user/personal/myfinance.html");
        User user = (User) request.getSession().getAttribute("loginUser");
        int id = user.getId();
        List<UserPayMoney> userPayMoneyList = myFinanceService.selectUserPayMoneyById(id);
        List<UserChangeMoney> userChangeMoneyList = myFinanceService.selectUserChangeMoneyById(id);
        List<UserTermFinancial> userTermFinancialList = myFinanceService.selectUserTermFinancialById(id);
        List<UserFundProduct> userFundProductList = myFinanceService.selectUserFundProductById(id);
        modelAndView.addObject("userChangeMoneyList",userChangeMoneyList);
        modelAndView.addObject("userPayMoneyList",userPayMoneyList);
        modelAndView.addObject("userTermFinancialList",userTermFinancialList);
        modelAndView.addObject("userFundProductList",userFundProductList);
        return modelAndView;
    }
}
