package com.finance.service.impl.admin.permission;


import com.finance.mapper.perms.UserPermsViewMapper;
import com.finance.mapper.user.UserPermissionsMapper;
import com.finance.pojo.perms.UserPermsView;
import com.finance.pojo.perms.UserPermsViewExample;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserPermissions;
import com.finance.service.admin.permission.UserPermissionsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserPermissionsServiceImpl implements UserPermissionsService {

    @Resource
    UserPermsViewMapper permsViewMapper;

    @Resource
    UserPermissionsMapper userPermissionsMapper;

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
