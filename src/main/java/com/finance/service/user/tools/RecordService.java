package com.finance.service.user.tools;

import com.finance.pojo.others.FlowOfFunds;

import java.util.List;

public interface RecordService {
    List<FlowOfFunds> selectAllOfUser(int id);
}
