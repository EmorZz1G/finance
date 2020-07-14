package com.finance.service.user.userinfo;

import com.finance.pojo.user.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ReputationService {
    List<User> selectUsers();
}
