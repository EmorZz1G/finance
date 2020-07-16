package com.finance.service.user.permission;

import com.finance.pojo.perms.UserPermsView;
import com.finance.pojo.user.User;

import java.util.List;
import java.util.Set;

public interface UserPermissionsService {

    List<UserPermsView> selectPermsByUserId(int id);

    List<UserPermsView> selectPermsByUser(User user);

    List<String> selectPermsListByUser(User user);

    List<String> selectPermsListByUserId(int id);

    Set<String> selectPermsSetByUser(User user);

    Set<String> selectPermsSetByUserId(int id);
}
