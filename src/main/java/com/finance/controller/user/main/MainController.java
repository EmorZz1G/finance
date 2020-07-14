package com.finance.controller.user.main;


import com.finance.pojo.others.News;
import com.finance.service.user.main.NewsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MainController {

    @Resource
    NewsService newsService;

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

}
