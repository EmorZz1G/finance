package com.finance.service.login;

import com.finance.pojo.admin.Admin;
import com.finance.pojo.user.User;

public interface LoginService {
    Admin loginVerifyUsername(String username);

    User loginForUser(String username, String password);

    Admin loginForAdmin(String username, String password);

    int status2online(User user);

    int status2Disconnected(User user);
}
