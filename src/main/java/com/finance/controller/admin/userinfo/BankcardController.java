package com.finance.controller.admin.userinfo;


import com.finance.common.Result;
import com.finance.pojo.others.Bankcard;
import com.finance.pojo.user.User;
import com.finance.service.user.userinfo.BankcardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class BankcardController {


    @Autowired
    BankcardService bankcardService;


    @GetMapping("/admin/userinfo/toBankCard.html")
    public String toBankCard(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                             @RequestParam(value = "username",defaultValue = "") String username,
                             @RequestParam(value = "cardBank",defaultValue = "") String cardBank,
                             Model model){
        HashMap<String, Object> query = new HashMap<>();
        query.put("cardBank", cardBank);
        query.put("username",username);
        /*if(username.equals("")||cardBank.equals("")){
            model.addAttribute("query",query);
            PageHelper.startPage(pageNum,pageSize);
            List<Bankcard> bankcards = bankcardService.selectBankCards();
            PageInfo<Bankcard> bankcardPageInfo = new PageInfo<>(bankcards);
            model.addAttribute("bankcardPageInfo", bankcardPageInfo);
            model.addAttribute("bankcardList", bankcards);
            return "admin/userinfo/bankcard";
        }*/
        PageHelper.startPage(pageNum,pageSize);
        List<Bankcard> bankcards = bankcardService.selectUsersByQuery(query);
        PageInfo<Bankcard> bankcardPageInfo = new PageInfo<>(bankcards);
        model.addAttribute("bankcardPageInfo", bankcardPageInfo);
        model.addAttribute("query",query);
        model.addAttribute("bankcardList", bankcards);
        return "admin/userinfo/bankcard";
    }
    
    @GetMapping("/user/getBankCardById/{id}")
    @ResponseBody
    public Result getBankCardById(@PathVariable("id") int id){
        Bankcard bankCardById = bankcardService.getBankCardById(id);
        if (bankCardById!=null){
            return Result.success().add("bankcard",bankCardById);
        }else {
            return Result.failure();
        }
    }

    @PutMapping("/user/updateBankCard/{id}")
    @ResponseBody
    public Result updateBankCard(@PathVariable("id") int id,
                                 Bankcard bankcard){
        bankcard.setId(id);
        int i = bankcardService.updateBankCard(bankcard);
        if(i==1){
            return Result.success().add("bankcard", bankcard);
        }else {
            return Result.failure();
        }
    }

    @DeleteMapping("/user/deleteBankCard/{id}")
    @ResponseBody
    public Result deleteBankCard(@PathVariable("id") int id){
        int i = bankcardService.deleteBankCardById(id);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
}
