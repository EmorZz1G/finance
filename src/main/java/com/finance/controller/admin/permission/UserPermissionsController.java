package com.finance.controller.admin.permission;


import com.finance.common.Result;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.user.User;
import com.finance.service.admin.permission.AdminPermissionsService;
import com.finance.service.admin.permission.UserPermissionsService;
import com.finance.service.user.userinfo.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserPermissionsController {

    @Autowired
    UserPermissionsService permissionsService;

    @Autowired
    UserInfoService userInfoService;


    /**
     *  去用户权限管理页面
     * @param pageNum 页数
     * @param pageSize 页大小
     * @return
     */
    @GetMapping("/admin/permission/toUserPermissions.html")
    public ModelAndView toAdminPermissions(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                           ModelAndView model
    ) {


        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userInfoService.selectUsers();
        PageInfo<User> adminPageInfo = new PageInfo<>(users);
        model.addObject("userList", users);
        model.addObject("userPermsPageInfo", adminPageInfo);
        model.addObject("permissionsList", new HashMap<>());
        model.setViewName("admin/permission/userpermissions.html");
        return model;
    }

    @GetMapping("/admin/permission/user/perms/{id}")
    @ResponseBody
    public Result getAdminPerms(@PathVariable("id") int id) {
        List<String> list = permissionsService.selectPermsListByUserId(id);
        if (list != null) {
            return Result.success().add("permissionsList", list);
        } else {
            return Result.failure("该用户尚未拥有权限");
        }
    }

    @PutMapping("/admin/updateUserPermissions/{id}")
    @ResponseBody
    public Result updateAdminPermissions(@PathVariable("id") int id,
                                         String userPermissions) {
        System.out.println(userPermissions);
        String[] split = userPermissions.split(";");
        int i = permissionsService.updatePerms(id, split);
        if (i > 0) {
            return Result.success();
        } else {
            return Result.failure();
        }
    }
}
