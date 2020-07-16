package com.finance.service.user.userinfo;

import com.finance.pojo.user.User;

import java.util.List;

public interface UserInfoService {
    List<User> selectUsers();

    User selectUserById(int id);

    int updateUser(User user);

    int deleteUserById(int id);

    int insertUser(User user);

    /**
     * 下线功能
     * @param id
     * @return
     */
    int updateUserStatusById(int id);
}
