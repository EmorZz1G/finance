package com.finance.service.impl.user.tools;

import com.finance.mapper.others.FlowOfFundsMapper;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.FlowOfFundsExample;
import com.finance.service.user.tools.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    FlowOfFundsMapper flowOfFundsMapper;

    @Override
    public List<FlowOfFunds> selectAllOfUser(int id) {
        FlowOfFundsExample flowOfFundsExample = new FlowOfFundsExample();
        FlowOfFundsExample.Criteria criteria = flowOfFundsExample.createCriteria();
        criteria.andUseridEqualTo(id);
        return flowOfFundsMapper.selectByExample(flowOfFundsExample);
    }
}
