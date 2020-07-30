package com.finance.controller.user.personal;


import com.finance.common.Result;
import com.finance.common.annotation.UserAvatarAnno;
import com.finance.pojo.user.User;
import com.finance.service.admin.permission.UserPermissionsService;
import com.finance.service.user.personal.ProfileService;
import com.finance.service.user.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    /**
     * 查询显示信息
     * @param modelAndView：显示信息
     * @param session
     * @return
     */
    @GetMapping("/user/personal/toProfile.html")
    public ModelAndView toProfile(ModelAndView modelAndView,
                                  HttpSession session) {
        modelAndView.setViewName("user/personal/profile");
        User loginUser = (User) session.getAttribute("loginUser");
        User user = profileService.selectUserById(loginUser.getId());
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PutMapping("/user/updateUserProfile/{id}")
    @ResponseBody
    @UserAvatarAnno
    public Result updateUserProfile(@PathVariable("id") int id,
                                    User user,
                                    HttpSession session) {
        user.setId(id);
        int i = userInfoService.updateUser(user);
        if (i == 1) {
            Result success = Result.success();
            if(user.getPhone()!=null&&user.getIDcard()!=null){
                permissionsService.giveAuthorization(user);
                success.setMsg("修改成功！");
            }
            session.setAttribute("loginUser",user);
            return success;
        } else {
            return Result.failure();
        }
    }

}
