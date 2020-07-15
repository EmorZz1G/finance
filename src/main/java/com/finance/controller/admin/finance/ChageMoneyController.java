package com.finance.controller.admin.finance;

import com.finance.common.Result;
import com.finance.pojo.others.Bank;
import com.finance.pojo.others.ChangeMoney;
import com.finance.service.admin.finance.ChangeMoneyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ChageMoneyController {
    @Autowired
    ChangeMoneyService changeMoneyService;
    @RequestMapping("/admin/finance/toChangeMoney.html")
    public ModelAndView toChangeMoney(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                               @RequestParam(value = "pageSize",defaultValue = "5")int pageSize

    )
    {
        ModelAndView modelAndView = new ModelAndView("admin/finance/changemoney.html");
        PageHelper.startPage(pageNum,pageSize);
        List<ChangeMoney> financeList=changeMoneyService.selectChangeMoneyAll();
        PageInfo<ChangeMoney> pageInfo=new PageInfo<ChangeMoney>(financeList);
        modelAndView.addObject("financePageInfo",pageInfo);
        modelAndView.addObject("financeList",financeList);

        return modelAndView;

    }
    @PostMapping("/admin/addChangeMoney")
    @ResponseBody
    public Result addChangeMoney(ChangeMoney changeMoney){
        int i = changeMoneyService.insertChangeMoney(changeMoney);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
    @GetMapping("/admin/getChangeMoneyInfoById/{id}")
    @ResponseBody
    public Result getChangeMoneyById(@PathVariable("id") int id) {
        ChangeMoney changeMoney = changeMoneyService.selectChangeMoneyById(id);
        Result result = Result.success().add("changeMoney", changeMoney);
        return result;
    }
    @PutMapping("/admin/updateChangeMoney/{id}")
    @ResponseBody
    public Result updateChangeMoney(@PathVariable("id") int id, ChangeMoney changeMoney) {
        changeMoney.setId(id);
        int i = changeMoneyService.updateChangeMoney(changeMoney);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
    @DeleteMapping("/admin/deleteChangeMoneyById/{id}")
    @ResponseBody
    public Result deleteChangeMoneyById(@PathVariable("id") int id) {
        int i = changeMoneyService.deleteChangeMoneyById(id);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
}
