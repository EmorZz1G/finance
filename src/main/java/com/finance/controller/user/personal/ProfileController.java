package com.finance.controller.user.personal;


import com.finance.common.Result;
import com.finance.pojo.user.User;
import com.finance.service.user.personal.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @Autowired
    ProfileService profileService;


    @GetMapping("/user/personal/toProfile.html")
    public ModelAndView toProfile(ModelAndView modelAndView,
                                  HttpSession session) {
        modelAndView.setViewName("/user/personal/profile");
        User loginUser = (User) session.getAttribute("loginUser");
        User user = profileService.selectUserById(loginUser.getId());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
