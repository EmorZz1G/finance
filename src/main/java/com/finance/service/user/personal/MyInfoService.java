package com.finance.service.user.personal;

import com.finance.pojo.others.Info;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MyInfoService {
    List<Info> selectInfosByUserId(Integer id);

    int getUnReadInfoCountByUserId(Integer id);

    int updateInfoStatus(int id);

    int deleteInfoById(int id);
}
