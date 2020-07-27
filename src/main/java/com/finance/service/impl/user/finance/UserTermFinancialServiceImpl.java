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

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
@Service
public class UserTermFinancialServiceImpl implements UserTermFinancialService {
    @Resource
    private TermFinancialMapper termFinancialMapper;
    @Resource
    private UserTermFinancialMapper userTermFinancialMapper;
    @Resource
    private FlowOfFundsMapper flowOfFundsMapper;

    /**
     * 查询所有期限理财产品信息
     * @return
     */
    @Override
    public List<TermFinancial> selectAllUserTermFinancial(){
        return termFinancialMapper.selectByExample(null);
    }

    /**
     * 向数据库插入信息
     * @param userTermFinancial
     * @param money
     * @return
     */
    @Override
    public int insertUserTermFinancial(UserTermFinancial userTermFinancial, BigDecimal money){
        return userTermFinancialMapper.insertSelective(userTermFinancial);
    }

    /**
     * 按id查询期限理财产品
     * @param id
     * @return
     */
    @Override
    public TermFinancial selectById(Integer id){
        return termFinancialMapper.selectByPrimaryKey(id);
    }

    /**
     * 向数据库插入信息
     * @param flowOfFunds
     * @param money：用户输入金额
     * @return
     */
    @Override
    public int insertFlowOfFunds(FlowOfFunds flowOfFunds, BigDecimal money){
        return flowOfFundsMapper.insertSelective(flowOfFunds);
    }

}
