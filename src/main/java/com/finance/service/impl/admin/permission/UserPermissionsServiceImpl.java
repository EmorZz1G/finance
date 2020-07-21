package com.finance.service.impl.admin.permission;


import com.finance.mapper.others.PermissionsMapper;
import com.finance.mapper.perms.UserPermsViewMapper;
import com.finance.mapper.user.UserPermissionsMapper;
import com.finance.pojo.admin.AdminPermissions;
import com.finance.pojo.admin.AdminPermissionsExample;
import com.finance.pojo.others.Permissions;
import com.finance.pojo.others.PermissionsExample;
import com.finance.pojo.perms.UserPermsView;
import com.finance.pojo.perms.UserPermsViewExample;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserPermissions;
import com.finance.pojo.user.UserPermissionsExample;
import com.finance.service.admin.permission.CommonPermissionService;
import com.finance.service.admin.permission.UserPermissionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserPermissionsServiceImpl implements UserPermissionsService {

    @Resource
    UserPermsViewMapper permsViewMapper;

    @Resource
    UserPermissionsMapper userPermissionsMapper;

    @Resource
    CommonPermissionService commonPermissionService;

    @Resource
    PermissionsMapper permissionsMapper;

    Logger log = LoggerFactory.getLogger(UserPermissionsServiceImpl.class);

    @Override
    public int updatePerms(int userId, String[] _newPerms) throws RuntimeException {
        Set<String> prePerms = selectPermsSetByUserId(userId);
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
            UserPermissions userPermissions = new UserPermissions();
            userPermissions.setUserId(userId);
            try {
                userPermissions.setPermissionId(permissionss.get(s).get(0).getId());
            } catch (Exception e) {
                log.info("这个权限不存在，请检查传入的权限字符串:{}", s);
                continue;
            }
            effectRow += userPermissionsMapper.insert(userPermissions);
        }
        UserPermissionsExample userPermissionsExample = new UserPermissionsExample();
        UserPermissionsExample.Criteria criteria = userPermissionsExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        for (String s : delPerms) {
            try {
                criteria.andPermissionIdEqualTo(permissionss.get(s).get(0).getId());
            } catch (Exception e) {
                log.info("这个权限不存在，请检查传入的权限字符串:{}", s);
                continue;
            }
            effectRow += userPermissionsMapper.deleteByExample(userPermissionsExample);
        }
        return effectRow;
    }

    @Override
    public int giveAuthorization(User user) {
        UserPermissions userPermissions = new UserPermissions();
        userPermissions.setUserId(user.getId());
        int effect = 0;
        for (int i = 1; i <= 9; ++i) {
            userPermissions.setPermissionId(i);
            effect += userPermissionsMapper.insert(userPermissions);
        }
        return effect;
    }

    @Override
    public List<UserPermsView> selectPermsByUserId(int id) {
        UserPermsViewExample example = new UserPermsViewExample();
        UserPermsViewExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(id);
        return permsViewMapper.selectByExample(example);
    }

    @Override
    public List<UserPermsView> selectPermsByUser(User user) {
        UserPermsViewExample example = new UserPermsViewExample();
        UserPermsViewExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user.getId());
        return permsViewMapper.selectByExample(example);
    }

    @Override
    public List<String> selectPermsListByUser(User user) {
        List<UserPermsView> userPermsViews = selectPermsByUser(user);
        return userPermsViews.stream().
                map(UserPermsView::getPermission)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectPermsListByUserId(int id) {
        List<UserPermsView> userPermsViews = selectPermsByUserId(id);
        return userPermsViews.stream().
                map(UserPermsView::getPermission)
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> selectPermsSetByUser(User user) {
        List<UserPermsView> userPermsViews = selectPermsByUser(user);
        return userPermsViews.stream().
                map(UserPermsView::getPermission)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> selectPermsSetByUserId(int id) {
        List<UserPermsView> userPermsViews = selectPermsByUserId(id);
        return userPermsViews.stream().
                map(UserPermsView::getPermission)
                .collect(Collectors.toSet());
    }
}
