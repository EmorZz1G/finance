package com.finance.controller.admin.histroyinfo;

import com.finance.common.Result;
import com.finance.pojo.others.Info;
import com.finance.service.admin.historyinfo.InfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class InfoController {
    @Autowired
    InfoService infoService;

    @GetMapping("/admin/historyinfo/toInfo.html")
    public ModelAndView toMyInfo(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                 ModelAndView modelAndView){
        PageHelper.startPage(pageNum, pageSize);
        List<Info> infoList = infoService.selectAllInfo();
        PageInfo<Info> infoPageInfo = new PageInfo<>(infoList);
        modelAndView.setViewName("admin/historyinfo/info");
        modelAndView.addObject("infoList", infoList);
        modelAndView.addObject("infoPageInfo", infoPageInfo);
        return modelAndView;
    }

    @DeleteMapping("/admin/deleteInfo/{infoId}")
    @ResponseBody
    public Result deleteInfo(@PathVariable("infoId")int infoId){
        int i = infoService.deleteInfoById(infoId);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
}
