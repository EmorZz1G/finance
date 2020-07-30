package com.finance.controller.admin.histroyinfo;

import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.user.User;
import com.finance.service.admin.historyinfo.AdminRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminRecordController {
    @Autowired
    AdminRecordService adminRecordService;

    /**
     * 去资金记录页面，查询资金记录
     * @param pageNum 页数
     * @param pageSize 页大小
     * @param minDate 查询开始时间
     * @param maxDate 结束时间
     * @return
     * @throws ParseException
     */
    @GetMapping("/admin/historyinfo/toRecord.html")
    public String toRecord(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                 @RequestParam(value = "minDate",defaultValue = "") String minDate,
                                 @RequestParam(value = "maxDate",defaultValue = "") String maxDate,
                                 Model model) throws ParseException {
        Date min_Date;
        Date max_Date;
        System.out.println(minDate);
        System.out.println(maxDate);
        if (!minDate.trim().equals("")&&!maxDate.trim().equals("")){
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            min_Date = ft.parse(minDate);
            max_Date = ft.parse(maxDate);
        }else {
            min_Date = null;
            max_Date = null;
        }
        HashMap<String, Object> query = new HashMap<>();
        query.put("min-createTime",min_Date);
        query.put("max-createTime",max_Date);
        query.put("minDate",minDate);
        query.put("maxDate",maxDate);
        PageHelper.startPage(pageNum,pageSize);
        List<FlowOfFunds> flowOfFundsList = adminRecordService.selectFlowOfFundsByQuery(query);
        PageInfo<FlowOfFunds> flowOfFundsPageInfo = new PageInfo<>(flowOfFundsList);
        System.out.println(flowOfFundsList);
        model.addAttribute("flowOfFundsPageInfo",flowOfFundsPageInfo);
        model.addAttribute("flowOfFundsList",flowOfFundsList);
        model.addAttribute("query",query);
        return "admin/historyinfo/record.html";
    }


}
