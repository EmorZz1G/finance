package com.finance.controller.user.finance;

import com.finance.common.Result;
import com.finance.mapper.user.UserMapper;
import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserChangeMoney;
import com.finance.service.admin.finance.ChangeMoneyService;
import com.finance.service.user.finance.UserChangeMoneyService;
import com.finance.service.user.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * @author Emor
 */
@Controller
public class UserChangeMoneyController {
    @Autowired
    UserChangeMoneyService userChangeMoneyService;
    @Autowired
    ChangeMoneyService changeMoneyService;
    @Autowired
    UserInfoService userInfoService;

    /**
     * 查询显示所有零钱理财产品的信息
     *
     */

    @GetMapping("/user/finance/toChangeMoney.html")
    public ModelAndView toChangeMoney()
    {
        ModelAndView modelAndView = new ModelAndView("user/finance/changemoney.html");
        List<ChangeMoney> changeMoneyList=userChangeMoneyService.selectChangeMoneyAll();
        modelAndView.addObject("changeMoneyList",changeMoneyList);

        return modelAndView;

    }

    /**
     * 对前端购买零钱理财的ajax请求进行处理，在对应数据库里添加信息
     * @param id：用户点击的产品id
     * @param money：用户输入的购买资金
     * @param user：当前登录的用户实体
     * @return
     */

    @PostMapping("/user/buyChangeMoney")
    @ResponseBody
    public Result addUserChangeMoney(@RequestParam("changeMoneyId")int id,@RequestParam("paymoney")BigDecimal money,@SessionAttribute("loginUser") User user){

        ChangeMoney changeMoney=changeMoneyService.selectChangeMoneyById(id);

        int i = userChangeMoneyService.insertUserChangeMoney(user,changeMoney,money);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }


    }


}
