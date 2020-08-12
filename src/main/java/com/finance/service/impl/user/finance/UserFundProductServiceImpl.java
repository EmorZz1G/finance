package com.finance.service.impl.user.finance;

import com.finance.common.Result;
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
import com.finance.service.user.userinfo.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
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

    /**
     * 查询所有基金理财产品信息
     * @return
     */
    @Override
    public List<FundProduct> selectFundProductAll() {
        return fundProductMapper.selectByExample(null);
    }

    /**
     * 向相关数据库插入信息
     * @param user：用户
     * @param fundProduct：基金理财产品
     * @param money：用户输入金额
     * @return num
     */
    @Override
    @Transactional
    public int insertUserFundProduct(User user, FundProduct fundProduct,BigDecimal money) {
        UserFundProduct userFundProduct = new UserFundProduct();
        BigDecimal averYield = fundProduct.getMonthlyGrowth();

        BigDecimal profit = averYield.multiply(money);
        userFundProduct.setUserId(user.getId());
        userFundProduct.setAverYield(averYield);
        userFundProduct.setProfit(profit);
        userFundProduct.setFundId(fundProduct.getId());
        userFundProduct.setStartTime(LocalDate.now());
        userFundProduct.setStatus(1);
        String source = fundProduct.getFundDesc();
        FlowOfFunds flowOfFunds = new FlowOfFunds();
        flowOfFunds.setUserId(user.getId());
        flowOfFunds.setFlowMoney(money);
        flowOfFunds.setType(1);
        flowOfFunds.setSource(source);
        flowOfFunds.setCreateTime(LocalDate.now());
        flowOfFunds.setFundDesc("基金理财");
        int i = userFundProductMapper.insertSelective(userFundProduct);
        if (i == 1) {
            return flowOfFundsMapper.insertSelective(flowOfFunds);
        } else {
            return 0;
        }

    }

}
