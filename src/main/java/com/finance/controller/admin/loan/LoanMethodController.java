package com.finance.controller.admin.loan;

import com.finance.common.Result;
import com.finance.pojo.others.Loan;
import com.finance.service.admin.loan.LoanExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoanMethodController {
    @Autowired
    private LoanExamService loanExamService;

    @RequestMapping("/loan/passApplyStatus/{id}")
    @ResponseBody
    public Result updateLoanExam(@PathVariable("id") Integer id){
        Loan loan = new Loan();
        loan.setId(id);
        loan.setApplyStatus(2);
        System.out.println("更新");

        int result = loanExamService.updateLoanExam(loan);
        if(result==1){
            System.out.println("成功");
            return Result.success();
        }
        else{
            System.out.println("失败");
            return Result.failure();
        }
    }

    @RequestMapping("/loan/notPassApplyStatus/{id}")
    @ResponseBody
    public Result updateLoanExam2(@PathVariable("id") Integer id){
        Loan loan = new Loan();
        loan.setId(id);
        loan.setApplyStatus(1);
        System.out.println("更新");

        int result = loanExamService.updateLoanExam(loan);
        if(result==1){
            System.out.println("成功");
            return Result.success();
        }
        else{
            System.out.println("失败");
            return Result.failure();
        }
    }
}
