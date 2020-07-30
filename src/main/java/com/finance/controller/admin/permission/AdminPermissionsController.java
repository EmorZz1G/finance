package com.finance.controller.admin.permission;


import com.finance.common.Result;
import com.finance.pojo.admin.Admin;
import com.finance.service.admin.permission.AdminPermissionsService;
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
public class AdminPermissionsController {

    @Autowired
    AdminPermissionsService permissionsService;

    /**
     * 去管理员权限管理页面
     * @param pageNum 页数
     * @param pageSize 页大小
     * @return
     */
    @GetMapping("/admin/permission/toAdminPermissions.html")
    public ModelAndView toAdminPermissions(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                           ModelAndView model,
                                           HttpSession session) {
        Admin admin = (Admin) session.getAttribute("loginAdmin");
//        List<String> list = permissionsService.selectPermsListByAdmin(admin);
        PageHelper.startPage(pageNum, pageSize);
        List<Admin> admins = permissionsService.selectAdminsButId(admin.getId());
        PageInfo<Admin> adminPageInfo = new PageInfo<>(admins);
        model.addObject("adminList", admins);
        model.addObject("adminPermsPageInfo", adminPageInfo);
        model.addObject("permissionsList", new HashMap<>());
        model.setViewName("admin/permission/adminpermissions.html");
        return model;
    }

    @GetMapping("/admin/permission/admin/perms/{id}")
    @ResponseBody
    public Result getAdminPerms(@PathVariable("id") int id) {
        List<String> list = permissionsService.selectPermsListByAdminId(id);
        if (list != null) {
            return Result.success().add("permissionsList", list);
        } else {
            return Result.failure("该管理员尚未拥有权限");
        }
    }

    @PutMapping("/admin/updateAdminPermissions/{id}")
    @ResponseBody
    public Result updateAdminPermissions(@PathVariable("id") int id,
                                         String adminPermissions) {

        String[] split = adminPermissions.split(";");
        int i;
        i = permissionsService.updatePerms(id, split);
        if(i>0){
            return Result.success();
        }else {
            return Result.failure();
        }
    }



    @PostMapping("/admin/super/addAdmin")
    @ResponseBody
    public Result addAdmin(Admin admin){
        int i = permissionsService.insertAdmin(admin);
        if (i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }

    @DeleteMapping("/admin/super/deleteAdmin/{id}")
    @ResponseBody
    public Result deleteAdmin(@PathVariable("id")int id){
        int i = permissionsService.deleteAdminId(id);
        if (i==1){
            return Result.success();
        }else {
            return Result.failure();
        }
    }
}
