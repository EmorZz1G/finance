package com.finance.service.user.userinfo;

import com.finance.pojo.user.User;

import java.util.List;
import java.util.Map;

public interface ReputationService {
    List<User> selectUsers();

    List<User> selectUsersByQuery(Map<String,Object> query);
}
