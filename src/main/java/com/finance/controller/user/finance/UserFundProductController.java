package com.finance.controller.user.finance;

import com.finance.common.Result;
import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.others.FundProduct;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserChangeMoney;
import com.finance.pojo.user.UserFundProduct;
import com.finance.service.admin.finance.FundProductService;
import com.finance.service.user.finance.UserFundProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Emor
 */
@Controller
public class UserFundProductController {

    @Autowired
    FundProductService fundProductService;
    @Autowired
    UserFundProductService userFundProductService;
    @GetMapping ("/user/finance/toFundProduct.html")
    public ModelAndView toFundProduct()
    {
        ModelAndView modelAndView = new ModelAndView("user/finance/fundproduct.html");
        List<FundProduct> fundProductList=userFundProductService.selectFundProductAll();
        modelAndView.addObject("fundProductList",fundProductList);

        return modelAndView;

    }
    @PostMapping("/user/buyFundProduct")
    @ResponseBody
    public Result addUserFundProduct(@RequestParam("fundProductId")int id, @SessionAttribute("loginUser") User user){
        FundProduct fundProduct=fundProductService.selectFundProductById(id);
        int i = userFundProductService.insertUserFundProduct(user,fundProduct);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

}
