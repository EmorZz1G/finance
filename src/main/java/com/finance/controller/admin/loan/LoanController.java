package com.finance.controller.admin.loan;

import com.finance.pojo.others.Loan;
import com.finance.pojo.user.User;
import com.finance.service.admin.loan.LoanExamService;
import com.finance.service.admin.loan.LoanInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin/loan")
public class LoanController {
    @Autowired
    private LoanExamService loanExamService;

    @RequestMapping(value = "/toLoanexam.html",method = RequestMethod.GET)
    public String selectAllExam(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                            @RequestParam(value = "term",defaultValue = "") Integer term,
                            @RequestParam(value = "applyStatus",defaultValue = "") Integer applyStatus,
                            Model model) {
        //引入pageHelper插件
        HashMap<String, Object> query = new HashMap<>();
        System.out.println(term);
        System.out.println(applyStatus);
        query.put("applyStatus",applyStatus);
        query.put("term",term);
        System.out.println(query);
        PageHelper.startPage(pageNum, pageSize);
        List<Loan> loanList = loanExamService.selectLoanByQuery(query);
        System.out.println(loanList);
        //PageInfo封装分页信息
        PageInfo<Loan> pageInfo = new PageInfo<Loan>(loanList);
        model.addAttribute("loanPageInfo", pageInfo);
        model.addAttribute("query",query);
        model.addAttribute("loanList", loanList);model.addAttribute("activeUrl1", "loanActive");
        return "admin/loan/loanexam";
    }

    @Autowired
    private LoanInfoService loanInfoService;

    @RequestMapping(value = "/toLoaninfo.html",method = RequestMethod.GET)
    public String selectAllInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                            @RequestParam(value = "username", defaultValue = "") String username,
                            @RequestParam(value = "loanStatus", defaultValue = "") Integer loanStatus,
                            Model model) {
        HashMap<String, Object> query = new HashMap<>();
        query.put("username", username);
        query.put("loanStatus",loanStatus);
        //引入pageHelper插件
        PageHelper.startPage(pageNum, pageSize);
        List<Loan> loanList;
        if(loanStatus != null){
            loanList = loanInfoService.selectUsersByQuery(query);
        }else {
            loanList=loanInfoService.selectUsersByQueryHa(query);
        }
        //PageInfo封装分页信息
        PageInfo<Loan> pageInfo = new PageInfo<Loan>(loanList);
        model.addAttribute("loanPageInfo", pageInfo);
        model.addAttribute("loanList", loanList);
        model.addAttribute("query",query);
        return "admin/loan/loaninfo";
    }
}
