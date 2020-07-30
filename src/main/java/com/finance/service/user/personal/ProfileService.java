package com.finance.service.user.personal;

import com.finance.pojo.user.User;

public interface ProfileService {
    int updateUserProfile(User user);
    User selectUserById(int id);
}
