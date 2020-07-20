package com.finance.service.login;

import com.finance.pojo.user.User;

public interface LoginByEmailService {
    User loginVerifyUserEmail(String userEmail);

    User loginUserByEmail(String userEmail,String password);

    int status2online(User user);

    int status2Disconnected(User user);
}
