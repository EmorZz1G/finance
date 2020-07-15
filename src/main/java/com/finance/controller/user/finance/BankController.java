package com.finance.controller.user.finance;

import com.finance.pojo.others.Bank;
import com.finance.service.user.finance.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("userBankController")
public class BankController {
    @Autowired
    BankService bankService;

    @RequestMapping(value = "/user/finance/toBank.html",
    method = RequestMethod.GET)
    public ModelAndView toBank(){
       List<Bank> bankList = bankService.selectAllBank();
       ModelAndView modelAndView = new ModelAndView("/user/finance/bank.html");
       modelAndView.addObject("bankList",bankList);
       return modelAndView;
    }
}
