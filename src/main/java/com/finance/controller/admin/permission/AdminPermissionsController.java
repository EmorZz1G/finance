package com.finance.controller.admin.permission;


import com.finance.pojo.admin.Admin;
import com.finance.service.admin.permission.AdminPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminPermissionsController {

    @Autowired
    AdminPermissionsService permissionsService;

    @GetMapping("/admin/permission/toAdminPermissions.html")
    public String toAdminPermissions(Model model,
                                     HttpSession session){
        Admin admin = (Admin) session.getAttribute("loginAdmin");
        List<String> list = permissionsService.selectPermsListByAdmin(admin);
        model.addAttribute("permissionsList", list);
        return "admin/permission/adminpermissions.html";
    }
}
