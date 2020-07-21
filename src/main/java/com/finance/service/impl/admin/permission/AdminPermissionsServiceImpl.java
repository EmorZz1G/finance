package com.finance.service.impl.admin.permission;


import com.finance.mapper.admin.AdminMapper;
import com.finance.mapper.admin.AdminPermissionsMapper;
import com.finance.mapper.others.PermissionsMapper;
import com.finance.mapper.perms.AdminPermsViewMapper;
import com.finance.mapper.user.UserMapper;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.admin.AdminExample;
import com.finance.pojo.admin.AdminPermissions;
import com.finance.pojo.admin.AdminPermissionsExample;
import com.finance.pojo.others.Permissions;
import com.finance.pojo.others.PermissionsExample;
import com.finance.pojo.perms.AdminPermsView;
import com.finance.pojo.perms.AdminPermsViewExample;
import com.finance.pojo.user.UserExample;
import com.finance.service.admin.permission.AdminPermissionsService;
import com.finance.service.admin.permission.CommonPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminPermissionsServiceImpl implements AdminPermissionsService {

    Logger log = LoggerFactory.getLogger(AdminPermissionsServiceImpl.class);

    @Resource
    AdminPermsViewMapper permsViewMapper;

    @Resource
    AdminPermissionsMapper adminPermissionsMapper;



    @Resource
    CommonPermissionService commonPermissionService;

    @Resource
    AdminMapper adminMapper;

    @Override
    public int updatePerms(int adminId, String[] _newPerms) throws RuntimeException {
        Set<String> prePerms = selectPermsSetByAdminId(adminId);
        Set<String> newPerms = new HashSet<>(Arrays.asList(_newPerms));
        int max = Math.max(prePerms.size(),newPerms.size());
        HashSet<String> delPerms = new HashSet<>(max);
        HashSet<String> addPerms = new HashSet<>(max);

        for (String s : newPerms) {
            if (!prePerms.contains(s)) {
                addPerms.add(s);
            }
        }
        for (String s : prePerms) {
            if (!newPerms.contains(s)) {
                delPerms.add(s);
            }
        }
        int effectRow = 0;
        Map<String, List<Permissions>> permissionss = commonPermissionService.selectPermsAll();
        for (String s : addPerms) {
            AdminPermissions adminPermissions = new AdminPermissions();
            adminPermissions.setAdminId(adminId);
            try {
                adminPermissions.setPermissionId(permissionss.get(s).get(0).getId());
            } catch (Exception e) {
                log.info("这个权限不存在，请检查传入的权限字符串:{}", s);
                continue;
            }
            effectRow += adminPermissionsMapper.insert(adminPermissions);
        }
        AdminPermissionsExample adminPermissionsExample = new AdminPermissionsExample();
        AdminPermissionsExample.Criteria criteria = adminPermissionsExample.createCriteria();
        criteria.andAdminIdEqualTo(adminId);
        for (String s : delPerms) {
            try {
                criteria.andPermissionIdEqualTo(permissionss.get(s).get(0).getId());
            } catch (Exception e) {
                log.info("这个权限不存在，请检查传入的权限字符串:{}", s);
                continue;
            }
            effectRow += adminPermissionsMapper.deleteByExample(adminPermissionsExample);
        }
        return effectRow;
    }



    @Resource
    UserMapper userMapper;

    @Override
    public int deleteAdminId(int id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertAdmin(Admin admin) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(admin.getUsername());
        if(userMapper.countByExample(userExample)!=0){
            return 0;
        }
        return adminMapper.insertSelective(admin);
    }

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
