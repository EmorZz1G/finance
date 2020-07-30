package com.finance.controller.admin.finance;

import com.finance.common.Result;
import com.finance.pojo.others.TermFinancial;
import com.finance.service.admin.finance.TermFinancialService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class TermFinancialController {
    @Autowired
    TermFinancialService termFinancialService;

    @RequestMapping(value = "/admin/deleteTermFinancialById/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteTermFinancialById(@PathVariable("id") int id) {
        int i = termFinancialService.deleteTermFinancial(id);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }


    @RequestMapping(value = "/admin/updateTermFinancial/{id}",
            method = RequestMethod.PUT)
    @ResponseBody
    public Result updateTermFinancial(@PathVariable("id") int id, TermFinancial termFinancial) {
        termFinancial.setId(id);
        int i = termFinancialService.updateTermFinancial(termFinancial);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }


    @RequestMapping(value = "/admin/getTermFinancialInfoById/{id}",
            method = RequestMethod.GET)
    @ResponseBody
    public Result getTermFinancialInfoById(@PathVariable("id") int id) {
        TermFinancial termFinancial = termFinancialService.selectTermFinancialById(id);
        Result result = Result.success().add("termFinancial", termFinancial);
        return result;
    }


    @RequestMapping(value = "/admin/addTermFinancial",
            method = RequestMethod.POST)
    @ResponseBody
    public Result addTermFinancial(TermFinancial termFinancial) {
        int i = termFinancialService.insertTermFinancial(termFinancial);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }


    /**
     * 去期限理财管理页面，获取期限理财信息
     * @param pageNum 页数
     * @param pageSize  页大小
     * @return
     */
    @RequestMapping(value = "/admin/finance/toTermFinancial.html",
            method = RequestMethod.GET)
    public ModelAndView toTermFinancial(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "5") int pageSize) {
        ModelAndView modelAndView = new ModelAndView("admin/finance/termfinancial.html");
        PageHelper.startPage(pageNum, pageSize);
        List<TermFinancial> termFinancialList = termFinancialService.selectAllTermFinancial();
        PageInfo<TermFinancial> termFinancialPageInfo = new PageInfo<>(termFinancialList);
        modelAndView.addObject("financeList", termFinancialList);
        modelAndView.addObject("financePageInfo", termFinancialPageInfo);
        return modelAndView;
    }
}
