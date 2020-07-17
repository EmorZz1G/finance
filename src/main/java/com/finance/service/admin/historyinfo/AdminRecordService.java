package com.finance.service.admin.historyinfo;

import com.finance.pojo.others.FlowOfFunds;

import java.util.List;

public interface AdminRecordService {
    List<FlowOfFunds> selectAll();
}
