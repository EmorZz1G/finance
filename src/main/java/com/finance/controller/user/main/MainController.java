package com.finance.controller.user.main;


import com.finance.common.Result;
import com.finance.pojo.others.News;
import com.finance.pojo.user.User;
import com.finance.service.user.main.NewsService;
import com.finance.service.user.personal.MyInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MainController {

    @Resource
    NewsService newsService;

    @Resource
    MyInfoService myInfoService;

    /**
     *显示新闻的信息
     * @param pageNum：分页数
     * @param pageSize：页大小
     * @param model：声明变量
     * @return
     */
    @GetMapping({"/user/toUserMain",
            "/user/index.html"})
    public String toAdminMain(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                              Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<News> news = newsService.selectNewsAll();
        PageInfo<News> newsPageInfo = new PageInfo<>(news);
        model.addAttribute("newsList", news);
        model.addAttribute("newsPageInfo", newsPageInfo);
        return "user/main";
    }

    @GetMapping("/user/historyinfo/unread")
    @ResponseBody
    public Result getUnreadMsg(@SessionAttribute("loginUser") User user) {
        int count = myInfoService.getUnReadInfoCountByUserId(user.getId());

        return Result.success().add("msgNum", count);
    }

}
