package com.finance.controller.user.personal;


import com.finance.common.Result;
import com.finance.pojo.user.User;
import com.finance.service.admin.permission.UserPermissionsService;
import com.finance.service.user.personal.ProfileService;
import com.finance.service.user.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    UserPermissionsService permissionsService;


    @GetMapping("/user/personal/toProfile.html")
    public ModelAndView toProfile(ModelAndView modelAndView,
                                  HttpSession session) {
        modelAndView.setViewName("/user/personal/profile");
        User loginUser = (User) session.getAttribute("loginUser");
        User user = profileService.selectUserById(loginUser.getId());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PutMapping("/user/updateUserProfile/{id}")
    @ResponseBody
    public Result updateUserProfile(@PathVariable("id") int id,
                                    User user,
                                    HttpSession session) {
        user.setId(id);
        int i = userInfoService.updateUser(user);
        if (i == 1) {
            if(user.getPhone()!=null&&user.getIDcard()!=null){
                permissionsService.giveAuthorization(user);
            }
            session.setAttribute("loginUser",user);
            return Result.success();
        } else {
            return Result.failure();
        }
    }

}
