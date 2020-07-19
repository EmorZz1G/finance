package com.finance.controller.admin.histroyinfo;

import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.user.User;
import com.finance.service.admin.historyinfo.AdminRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminRecordController {
    @Autowired
    AdminRecordService adminRecordService;

    @GetMapping("/admin/historyinfo/toRecord.html")
    public ModelAndView toRecord(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
        ModelAndView modelAndView = new ModelAndView("admin/historyinfo/record.html");

        PageHelper.startPage(pageNum,pageSize);
        List<FlowOfFunds> flowOfFundsList = adminRecordService.selectAll();
        PageInfo<FlowOfFunds> flowOfFundsPageInfo = new PageInfo<>(flowOfFundsList);
        System.out.println(flowOfFundsList);
        modelAndView.addObject("flowOfFundsPageInfo",flowOfFundsPageInfo);
        modelAndView.addObject("flowOfFundsList",flowOfFundsList);
        return modelAndView;
    }


}
