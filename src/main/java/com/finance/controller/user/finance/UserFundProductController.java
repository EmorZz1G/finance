package com.finance.controller.user.finance;

import com.finance.common.Result;
import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.others.FundProduct;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserChangeMoney;
import com.finance.pojo.user.UserFundProduct;
import com.finance.service.admin.finance.FundProductService;
import com.finance.service.user.finance.UserFundProductService;
import com.finance.service.user.userinfo.UserInfoService;
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
    @Autowired
    UserInfoService userInfoService;

    /**
     * 查询显示所有的基金理财产品的信息
     * @return
     */
    @GetMapping ("/user/finance/toFundProduct.html")
    public ModelAndView toFundProduct()
    {
        ModelAndView modelAndView = new ModelAndView("user/finance/fundproduct.html");
        List<FundProduct> fundProductList=userFundProductService.selectFundProductAll();
        modelAndView.addObject("fundProductList",fundProductList);

        return modelAndView;

    }

    /**
     * 对前端购买基金理财的ajax请求进行处理，在对应数据库里添加信息
     * @param id：用户点击的产品id
     * @param money：用户输入的购买资金
     * @param user：当前登录的用户实体
     * @return
     */
    @PostMapping("/user/buyFundProduct")
    @ResponseBody
    public Result addUserFundProduct(@RequestParam("fundProductId")int id,@RequestParam("paymoney")BigDecimal money, @SessionAttribute("loginUser") User user){
        FundProduct fundProduct=fundProductService.selectFundProductById(id);
        int i = userFundProductService.insertUserFundProduct(user,fundProduct,money);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

}
