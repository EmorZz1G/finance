package com.finance.service.admin.historyinfo;

import com.finance.pojo.others.FlowOfFunds;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AdminRecordService {
    List<FlowOfFunds> selectAll();

    List<FlowOfFunds> selectFlowOfFundsByQuery(Map<String,Object> query);
}
