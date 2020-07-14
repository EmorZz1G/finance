package com.finance.service.user.personal;

import com.finance.pojo.others.Info;

import java.util.List;

public interface MyInfoService {
    List<Info> selectInfosByUserId(Integer id);
}
