package com.finance.service.impl.admin.permission;


import com.finance.mapper.admin.AdminMapper;
import com.finance.mapper.perms.AdminPermsViewMapper;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.admin.AdminExample;
import com.finance.pojo.perms.AdminPermsView;
import com.finance.pojo.perms.AdminPermsViewExample;
import com.finance.service.admin.permission.AdminPermissionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminPermissionsServiceImpl implements AdminPermissionsService {

    @Resource
    AdminPermsViewMapper permsViewMapper;

    @Resource
    AdminMapper adminMapper;

    @Override
    public List<Admin> selectAdminsButId(int id) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andIdNotEqualTo(id);
        return adminMapper.selectByExample(adminExample);
    }

    @Override
    public List<AdminPermsView> selectPermsByAdminId(int id) {
        AdminPermsViewExample example = new AdminPermsViewExample();
        AdminPermsViewExample.Criteria criteria = example.createCriteria();
        criteria.andAdminIdEqualTo(id);
        return permsViewMapper.selectByExample(example);
    }

    @Override
    public List<AdminPermsView> selectPermsByAdmin(Admin admin) {
        AdminPermsViewExample example = new AdminPermsViewExample();
        AdminPermsViewExample.Criteria criteria = example.createCriteria();
        criteria.andAdminIdEqualTo(admin.getId());
        return permsViewMapper.selectByExample(example);
    }

    @Override
    public List<String> selectPermsListByAdmin(Admin admin) {
        List<AdminPermsView> adminPermsViews = selectPermsByAdmin(admin);
        return adminPermsViews.stream().
                map(AdminPermsView::getPermission)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectPermsListByAdminId(int id) {
        List<AdminPermsView> adminPermsViews = selectPermsByAdminId(id);
        return adminPermsViews.stream().
                map(AdminPermsView::getPermission)
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> selectPermsSetByAdmin(Admin admin) {
        List<AdminPermsView> adminPermsViews = selectPermsByAdmin(admin);
        return adminPermsViews.stream().
                map(AdminPermsView::getPermission)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> selectPermsSetByAdminId(int id) {
        List<AdminPermsView> adminPermsViews = selectPermsByAdminId(id);
        return adminPermsViews.stream().
                map(AdminPermsView::getPermission)
                .collect(Collectors.toSet());
    }
}
