package com.finance.service.impl.admin.historyinfo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finance.common.utils.FuzzySearchUtils;
import com.finance.mapper.others.FlowOfFundsMapper;
import com.finance.mapper.plus.others.FlowOfFundsMapperPlus;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.FlowOfFundsExample;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserExample;
import com.finance.service.admin.historyinfo.AdminRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AdminRecordServiceImpl implements AdminRecordService {
    @Resource
    FlowOfFundsMapper flowOfFundsMapper;
    @Resource
    FlowOfFundsMapperPlus flowOfFundsMapperPlus;
    /**
     * 查询所有资金记录
     * @return
     */
    @Override
    public List<FlowOfFunds> selectAll() {
        return flowOfFundsMapperPlus.selectList(null);
    }

    /**
     *查询资金记录
     * @return
     */
    @Override
    public List<FlowOfFunds> selectFlowOfFundsByQuery(Map<String, Object> query) {
        try {
            /*FlowOfFundsExample example = (FlowOfFundsExample) FuzzySearchUtils.autoWrapper(FlowOfFundsExample.class, query);
            List<FlowOfFunds> flowOfFunds= flowOfFundsMapper.selectByExample(example);
            return flowOfFunds;*/
            return flowOfFundsMapperPlus.selectList(FuzzySearchUtils.autoWrapper(new QueryWrapper<FlowOfFunds>(), query));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
