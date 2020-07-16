package com.finance.service.admin.permission;

import com.finance.pojo.admin.Admin;
import com.finance.pojo.perms.AdminPermsView;
import com.finance.pojo.perms.UserPermsView;

import java.util.List;
import java.util.Set;

public interface AdminPermissionsService {

    List<AdminPermsView> selectPermsByAdminId(int id);

    List<AdminPermsView> selectPermsByAdmin(Admin admin);

    List<String> selectPermsListByAdmin(Admin admin);

    List<String> selectPermsListByAdminId(int id);

    Set<String> selectPermsSetByAdmin(Admin admin);

    Set<String> selectPermsSetByAdminId(int id);
}
