package com.finance.service.getpasw;

import com.finance.pojo.user.User;

public interface GetPasswordService {
    User getPasswordVerifyUsername(String username);

    User getPasswordVerifyUserInfoByPhone(String username, String getPasw);

    User getPasswordVerifyUserInfoByEmail(String username, String getPasw);

    boolean getPassword(User user);
}
