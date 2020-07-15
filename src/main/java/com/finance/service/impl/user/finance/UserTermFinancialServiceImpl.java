package com.finance.service.impl.user.finance;

import com.finance.mapper.others.FlowOfFundsMapper;
import com.finance.mapper.others.TermFinancialMapper;
import com.finance.mapper.user.UserTermFinancialMapper;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.TermFinancial;
import com.finance.pojo.user.UserTermFinancial;
import com.finance.service.user.finance.UserTermFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserTermFinancialServiceImpl implements UserTermFinancialService {
    @Autowired
    private TermFinancialMapper termFinancialMapper;
    @Autowired
    private UserTermFinancialMapper userTermFinancialMapper;
    @Autowired
    private FlowOfFundsMapper flowOfFundsMapper;

    @Override
    public List<TermFinancial> selectAllUserTermFinancial(){
        return termFinancialMapper.selectByExample(null);
    }

    @Override
    public int insertUserTermFinancial(UserTermFinancial userTermFinancial){
        return userTermFinancialMapper.insertSelective(userTermFinancial);
    }
    @Override
    public TermFinancial selectById(Integer id){
        return termFinancialMapper.selectByPrimaryKey(id);
    }
    @Override
    public int insertFlowOfFunds(FlowOfFunds flowOfFunds){
        return flowOfFundsMapper.insertSelective(flowOfFunds);
    }

}
