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

    /**
     * 去银行页面 查询银行
     * @param pageNum 页数
     * @param pageSize 页大小
     * @return
     */
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

    /**
     *添加银行信息
     * @param bank 银行实体类
     * @return
     */
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

    /**
     * 通过银行id获取银行信息
     * @param id 银行id
     * @return
     */
    @GetMapping("/admin/getBankInfoById/{id}")
    @ResponseBody
    public Result getBankById(@PathVariable("id") int id) {
        Bank bank = bankService.selectBankById(id);
        Result result = Result.success().add("bank", bank);
        return result;
    }

    /**
     * 通过银行id更新银行信息
     * @param id 银行id
     * @param bank 银行实体类
     * @return
     */
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

    /**
     * 通过银行id删除
     * @param id 银行id
     * @return
     */
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
