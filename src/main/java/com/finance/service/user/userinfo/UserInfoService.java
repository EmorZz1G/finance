package com.finance.service.user.userinfo;

import com.finance.pojo.user.User;

import java.util.List;
import java.util.Map;



public interface UserInfoService {
    List<User> selectUsers();

    User selectUserById(int id);

    int updateUser(User user);

    int deleteUserById(int id);

    int insertUser(User user);

    List<User> selectOnlineStatusUsers();


    /**
     * 下线功能
     * @param id
     * @return
     */
    int updateUserStatusById(int id);

    List<User> selectUsersByQuery(Map<String,Object> query);
}
