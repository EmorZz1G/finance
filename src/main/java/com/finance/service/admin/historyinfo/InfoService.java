package com.finance.service.admin.historyinfo;

import com.finance.pojo.others.Info;

import java.util.List;

public interface InfoService {
    List<Info> selectAllInfo();

    int deleteInfoById(int id);
}
