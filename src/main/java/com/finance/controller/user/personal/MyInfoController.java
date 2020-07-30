package com.finance.controller.user.personal;


import com.finance.common.Result;
import com.finance.pojo.others.Info;
import com.finance.pojo.user.User;
import com.finance.service.user.personal.MyInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyInfoController {

    @Autowired
    MyInfoService myInfoService;

    /**
     * 显示个人信息
     * @param pageNum：页数
     * @param pageSize：页大小
     * @param modelAndView
     * @param session
     * @return
     */
    @GetMapping("/user/personal/toMyInfo.html")
    public ModelAndView toMyInfo(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                 @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                 ModelAndView modelAndView,
                                 HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        User loginUser = (User) session.getAttribute("loginUser");
        List<Info> infos = myInfoService.selectInfosByUserId(loginUser.getId());
        PageInfo<Info> infoPageInfo = new PageInfo<>(infos);
        modelAndView.setViewName("user/personal/myinfo");
        modelAndView.addObject("infoList", infos);
        modelAndView.addObject("infoPageInfo", infoPageInfo);
        return modelAndView;
    }

    /**
     * 更新消息
     * @param infoId：用户id
     * @return
     */
    @PutMapping("/user/updateInfo/{infoId}")
    @ResponseBody
    public Result updateInfo(@PathVariable("infoId")int infoId){
        int i = myInfoService.updateInfoStatus(infoId);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

    /**
     * 删除消息
     * @param infoId；用户id
     * @return
     */
    @DeleteMapping("/user/deleteInfo/{infoId}")
    @ResponseBody
    public Result deleteInfo(@PathVariable("infoId")int infoId){
        int i = myInfoService.deleteInfoById(infoId);
        if(i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
}
