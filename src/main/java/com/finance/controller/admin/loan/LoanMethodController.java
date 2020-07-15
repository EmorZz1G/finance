package com.finance.controller.admin.loan;

import com.finance.common.Result;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.others.Loan;
import com.finance.service.admin.loan.LoanExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoanMethodController {
    @Autowired
    private LoanExamService loanExamService;

    private Result extraction(HttpSession session,Loan loan,int type){
        Admin admin = (Admin) session.getAttribute("loginAdmin");
        int result = loanExamService.updateLoanExam(loan,admin,type);
        if(result==1){
            return Result.success();
        }
        else{
            return Result.failure();
        }
    }

    @RequestMapping(value = "/loan/passApplyStatus/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Result updateLoanExam(@PathVariable("id") Integer id,
                                 HttpSession session){
        Loan loan = new Loan();
        loan.setId(id);
        return extraction(session,loan,1);
    }

    @RequestMapping(value = "/loan/notPassApplyStatus/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public Result updateLoanExam2(@PathVariable("id") Integer id,
                                  HttpSession session){
        Loan loan = new Loan();
        loan.setId(id);
        return extraction(session,loan,0);
    }

    @PutMapping("/loan/remindPay/{id}")
    @ResponseBody
    public Result remindPay(@PathVariable("id")int id,
                            Loan loan,
                            HttpSession session){
        loan.setId(id);
        Admin admin = (Admin) session.getAttribute("loginAdmin");
        int i = loanExamService.remindPay(loan, admin);
        if (i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
}
