package com.finance.controller.admin.finance;

import com.finance.common.Result;
import com.finance.pojo.others.Bank;
import com.finance.pojo.user.User;
import com.finance.service.admin.finance.BankService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BankController {
    @Autowired
     BankService bankService;
    @RequestMapping ("/admin/finance/toBank.html")
    public ModelAndView toBank(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "5")int pageSize

    )
    {
        ModelAndView modelAndView = new ModelAndView("admin/finance/bank.html");
        PageHelper.startPage(pageNum,pageSize);
        List<Bank> financeList=bankService.selectBankAll();
        PageInfo<Bank> pageInfo=new PageInfo<Bank>(financeList);
        modelAndView.addObject("financePageInfo",pageInfo);
        modelAndView.addObject("financeList",financeList);

        return modelAndView;

    }
    @PostMapping("/admin/addBank")
    @ResponseBody
    public Result addBank(Bank bank){
        int i = bankService.insertBank(bank);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
    @GetMapping("/admin/getBankInfoById/{id}")
    @ResponseBody
    public Result getBankById(@PathVariable("id") int id) {
        Bank bank = bankService.selectBankById(id);
        Result result = Result.success().add("bank", bank);
        return result;
    }
    @PutMapping("/admin/updateBank/{id}")
    @ResponseBody
    public Result updateBank(@PathVariable("id") int id, Bank bank) {
        bank.setId(id);
        int i = bankService.updateBank(bank);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
    @DeleteMapping("/admin/deleteBankById/{id}")
    @ResponseBody
    public Result deleteBankById(@PathVariable("id") int id) {
        int i = bankService.deleteBankById(id);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }



}
