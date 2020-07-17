package com.finance.service.impl.admin.historyinfo;

import com.finance.mapper.others.FlowOfFundsMapper;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.service.admin.historyinfo.AdminRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminRecordServiceImpl implements AdminRecordService {
    @Resource
    FlowOfFundsMapper flowOfFundsMapper;

    @Override
    public List<FlowOfFunds> selectAll() {
        return flowOfFundsMapper.selectByExample(null);
    }
}
