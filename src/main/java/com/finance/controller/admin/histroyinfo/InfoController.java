package com.finance.controller.admin.histroyinfo;

import com.finance.common.Result;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.Info;
import com.finance.service.admin.historyinfo.InfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class InfoController {
    @Autowired
    InfoService infoService;

    /**
     * 去历史消息页面，查询历史消息
     * @param pageNum 页数
     * @param pageSize 页大小
     * @param minDate 查询开始时间
     * @param maxDate 结束时间
     * @param username  用户名
     * @param status   状态
     * @return
     * @throws ParseException
     */
    @GetMapping("/admin/historyinfo/toInfo.html")
    public String toMyInfo(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                 @RequestParam(value = "minDate",defaultValue = "") String minDate,
                                 @RequestParam(value = "maxDate",defaultValue = "") String maxDate,
                                 @RequestParam(value = "username",defaultValue = "") String username,
                                 @RequestParam(value = "status",defaultValue = "") String status,
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
        query.put("infoDesc",username);
        query.put("minDate",minDate);
        query.put("maxDate",maxDate);
        if(!status.equals("")){
            query.put("status",Integer.parseInt(status));
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Info> infoList = infoService.selectInfoByQuery(query);
        PageInfo<Info> infoPageInfo = new PageInfo<>(infoList);
        System.out.println(infoList);
        model.addAttribute("infoPageInfo",infoPageInfo);
        model.addAttribute("infoList",infoList);
        if(status.equals("")){
            query.put("status","");
        }
        model.addAttribute("query",query);
        return "admin/historyinfo/info.html";
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
