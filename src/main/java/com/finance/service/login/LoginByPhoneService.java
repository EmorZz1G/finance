package com.finance.service.login;

import com.finance.pojo.user.User;

public interface LoginByPhoneService {
    User loginVerifyUserPhone(String userPhone);

    User loginUserByPhone(String userPhone,String password);

    int status2online(User user);

    int status2Disconnected(User user);
}
