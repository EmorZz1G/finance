package com.finance.service.impl.user.finance;

import com.finance.mapper.others.FlowOfFundsMapper;
import com.finance.mapper.others.PayMoneyMapper;
import com.finance.mapper.user.UserPayMoneyMapper;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.PayMoney;
import com.finance.pojo.user.UserPayMoney;
import com.finance.service.user.finance.UserPayMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserPayMoneyServiceImpl implements UserPayMoneyService {

    @Resource
    private PayMoneyMapper payMoneyMapper;
    @Resource
    private UserPayMoneyMapper userPayMoneyMapper;
    @Resource
    private FlowOfFundsMapper flowOfFundsMapper;

    /**
     * 查询所有工资理财产品信息
     * @return
     */
    @Override
    public List<PayMoney> selectAllUserPayMoney(){
        return payMoneyMapper.selectByExample(null);
    }

    /**
     * 向数据库插入信息
     * @param userPayMoney
     * @return
     */
    @Override
    public int insertUserPayMoney(UserPayMoney userPayMoney) {
        return userPayMoneyMapper.insertSelective(userPayMoney);
    }

    /**
     * 根据id查找工资理财产品
     * @param id
     * @return
     */
    @Override
    public PayMoney selectById(Integer id){
        return payMoneyMapper.selectByPrimaryKey(id);
    }

    /**
     * 向数据库插入信息
     * @param flowOfFunds
     * @return
     */
    @Override
    public int insertFlowOfFunds(FlowOfFunds flowOfFunds){
        return flowOfFundsMapper.insertSelective(flowOfFunds);
    }


}
