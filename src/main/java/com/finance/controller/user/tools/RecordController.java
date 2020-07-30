package com.finance.controller.user.tools;

import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.user.User;
import com.finance.service.user.tools.RecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RecordController {
    @Autowired
    RecordService recordService;

    /**
     * 显示资金出入信息
     * @param pageNum：页数
     * @param pageSize：页大小
     * @param request
     * @return
     */
    @RequestMapping(value = "/user/tools/toRecord.html",method = RequestMethod.GET)
    public ModelAndView toRecord(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                 HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("user/tools/record.html");
        PageHelper.startPage(pageNum,pageSize);
        User user = (User) request.getSession().getAttribute("loginUser");
        int id = user.getId();
        List<FlowOfFunds> flowOfFundsList = recordService.selectAllOfUser(id);
        PageInfo<FlowOfFunds> flowOfFundsPageInfo = new PageInfo<>(flowOfFundsList);
        modelAndView.addObject("flowOfFundsPageInfo",flowOfFundsPageInfo);
        modelAndView.addObject("flowOfFundsList",flowOfFundsList);
        return modelAndView;
    }
}
