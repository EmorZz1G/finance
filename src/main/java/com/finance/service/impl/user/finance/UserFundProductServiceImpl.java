package com.finance.service.impl.user.finance;

import com.finance.mapper.others.FlowOfFundsMapper;
import com.finance.mapper.others.FundProductMapper;
import com.finance.mapper.user.UserFundProductMapper;
import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.FundProduct;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserChangeMoney;
import com.finance.pojo.user.UserFundProduct;
import com.finance.service.user.finance.UserFundProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class UserFundProductServiceImpl implements UserFundProductService {
    @Resource
    private FundProductMapper fundProductMapper;
    @Resource
    private FlowOfFundsMapper flowOfFundsMapper;
    @Resource
    private UserFundProductMapper userFundProductMapper;

    @Override
    public List<FundProduct> selectFundProductAll() {
        return fundProductMapper.selectByExample(null);
    }

    @Override
    @Transactional
    public int insertUserFundProduct(User user, FundProduct fundProduct) {
        UserFundProduct userFundProduct = new UserFundProduct();
        BigDecimal averYield = fundProduct.getMonthlyGrowth();
        BigDecimal invesMoney = fundProduct.getLeastMoney();
        BigDecimal profit = averYield.multiply(invesMoney);
        userFundProduct.setUserId(user.getId());
        userFundProduct.setAverYield(averYield);
        userFundProduct.setProfit(profit);
        userFundProduct.setFundId(fundProduct.getId());
        userFundProduct.setStartTime(new Date());
        userFundProduct.setStatus(1);
        String source = fundProduct.getFundDesc();
        FlowOfFunds flowOfFunds = new FlowOfFunds();
        flowOfFunds.setUserId(user.getId());
        flowOfFunds.setFlowMoney(invesMoney);
        flowOfFunds.setType(1);
        flowOfFunds.setSource(source);
        flowOfFunds.setCreateTime(new Date());
        flowOfFunds.setFundDesc("基金理财");
        int i = userFundProductMapper.insertSelective(userFundProduct);
        if (i == 1) {
            return flowOfFundsMapper.insertSelective(flowOfFunds);
        } else {
            return 0;
        }

    }

}
