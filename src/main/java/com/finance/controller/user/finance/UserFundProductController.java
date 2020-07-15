package com.finance.controller.user.finance;

import com.finance.common.Result;
import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.others.FundProduct;
import com.finance.pojo.user.UserChangeMoney;
import com.finance.pojo.user.UserFundProduct;
import com.finance.service.admin.finance.FundProductService;
import com.finance.service.user.finance.UserFundProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class UserFundProductController {
    @Autowired
    FundProductService fundProductService;
    @Autowired
    UserFundProductService userFundProductService;
    @RequestMapping("/user/finance/toFundProduct.html")
    public ModelAndView toFundProduct()
    {
        ModelAndView modelAndView = new ModelAndView("user/finance/fundproduct.html");
        List<FundProduct> fundProductList=userFundProductService.selectFundProductAll();
        modelAndView.addObject("fundProductList",fundProductList);

        return modelAndView;

    }
    @PostMapping("/user/buyFundProduct")
    @ResponseBody
    public Result addUserFundProduct(@RequestParam("fundProductId")int id, @RequestParam("userId")int userid){
        UserFundProduct userFundProduct=new UserFundProduct();
        FundProduct fundProduct=fundProductService.selectFundProductById(id);
        BigDecimal averYield= fundProduct.getMonthlyGrowth();
        BigDecimal invesMoney=fundProduct.getLeastMoney();
        BigDecimal profit= averYield.multiply(invesMoney);
        userFundProduct.setUserId(userid);
        userFundProduct.setAverYield(averYield);
        userFundProduct.setProfit(profit);
        userFundProduct.setFundId(id);
        userFundProduct.setStartTime(new Date());
        userFundProduct.setStatus(1);
        int i = userFundProductService.insertUserFundProduct(userFundProduct);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

}
