package com.finance.controller.user.tools;

import com.finance.common.Result;
import com.finance.pojo.others.Loan;
import com.finance.pojo.user.User;
import com.finance.service.user.tools.ApplyLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ApplyLoanController {

    @Autowired
    ApplyLoanService applyLoanService;

    @PostMapping("/user/applyLoan")
    @ResponseBody
    public Result applyLoan(@PathParam("amount" ) BigDecimal amount,
                            @PathParam("term") int term,
                            @PathParam("rate") BigDecimal rate,
                            HttpServletRequest request){
        Loan loan = new Loan();
        User user = (User) request.getSession().getAttribute("loginUser");
        int id = user.getId();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time_date = null;
        try {
            time_date = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        loan.setLoanId(id);
        loan.setAmount(amount);
        loan.setLoanTime(time_date);
        loan.setRate(rate);
        loan.setTerm(term);
        int i = applyLoanService.insertApplyLoan(loan);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }


    @GetMapping("/user/tools/toApplyLoan.html")
    public String toApplyLoan(){
        return "user/tools/applyloan";
    }
}
