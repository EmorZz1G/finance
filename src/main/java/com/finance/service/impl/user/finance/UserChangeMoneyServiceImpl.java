package com.finance.service.impl.user.finance;

import com.finance.controller.user.finance.UserChangeMoneyController;
import com.finance.mapper.others.ChangeMoneyMapper;
import com.finance.mapper.others.FlowOfFundsMapper;
import com.finance.mapper.user.UserChangeMoneyMapper;
import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserChangeMoney;
import com.finance.service.user.finance.UserChangeMoneyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class UserChangeMoneyServiceImpl implements UserChangeMoneyService {
    @Resource
    private ChangeMoneyMapper changeMoneyMapper;
    @Resource
    private UserChangeMoneyMapper userChangeMoneyMapper;
    @Resource
    private FlowOfFundsMapper flowOfFundsMapper;

    @Override
    public List<ChangeMoney> selectChangeMoneyAll() {
        return changeMoneyMapper.selectByExample(null);
    }

    @Override
    @Transactional
    public int insertUserChangeMoney(User user, ChangeMoney changeMoney) {
        UserChangeMoney userChangeMoney = new UserChangeMoney();

        BigDecimal averYield = changeMoney.getAnnualIncome();
        BigDecimal invesMoney = changeMoney.getInvesMoney();
        BigDecimal profit = averYield.multiply(invesMoney);
        userChangeMoney.setUserId(user.getId());
        userChangeMoney.setAverYield(averYield);
        userChangeMoney.setProfit(profit);
        userChangeMoney.setChangeId(changeMoney.getId());
        userChangeMoney.setStartTime(new Date());
        userChangeMoney.setStatus(1);
        String source = changeMoney.getName();
        FlowOfFunds flowOfFunds = new FlowOfFunds(null,
                user.getId(),
                invesMoney,
                1, source,
                new Date(),
                "零钱理财");

/*        flowOfFunds.setUserId(changeMoney.getId());
        flowOfFunds.setFlowMoney(invesMoney);
        flowOfFunds.setType(1);
        flowOfFunds.setSource(source);
        flowOfFunds.setCreateTime(new Date());
        flowOfFunds.setFundDesc("零钱理财");*/
        int i = userChangeMoneyMapper.insertSelective(userChangeMoney);
        if (i == 1) {
            return flowOfFundsMapper.insertSelective(flowOfFunds);
        } else {
            return 0;
        }

    }

}
