package com.finance.service.admin.historyinfo;

import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.Info;

import java.util.List;
import java.util.Map;

public interface InfoService {
    List<Info> selectAllInfo();

    int deleteInfoById(int id);

    List<Info> selectInfoByQuery(Map<String,Object> query);
}
