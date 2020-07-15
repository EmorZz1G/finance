package com.finance.controller.user.personal;


import com.finance.common.Result;
import com.finance.mapper.others.LoanMapper;
import com.finance.pojo.others.Loan;
import com.finance.pojo.user.User;
import com.finance.service.user.personal.MyLoanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyLoanController {
    @Autowired
    MyLoanService myLoanService;

    @GetMapping("user/personal/toMyLoan.html")
    public ModelAndView toMyLoan(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                  @RequestParam(value = "pageSize",defaultValue = "5")int pageSize,
                                  ModelAndView modelAndView,
                                  HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        PageHelper.startPage(pageNum,pageSize);
        List<Loan> loans = myLoanService.selectMyLoans(user);
        PageInfo<Loan> loanPageInfo = new PageInfo<>(loans);
        modelAndView.addObject("myLoansPageInfo", loanPageInfo);
        modelAndView.addObject("loansList",loans);
        modelAndView.setViewName("/user/personal/myloan");
        return modelAndView;
    }

    @PutMapping("/user/repayment/{id}")
    public Result repayment(@PathVariable("id")int id,
                            HttpSession session){
        User user = (User) session.getAttribute("loginUser");
        Loan loan = new Loan();
        loan.setLoanId(user.getId());
        loan.setId(id);
        int repayment = myLoanService.repayment(loan);
        if (repayment==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
}
