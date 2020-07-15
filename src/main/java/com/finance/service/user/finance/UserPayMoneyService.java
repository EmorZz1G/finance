package com.finance.service.user.finance;


import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.PayMoney;
import com.finance.pojo.user.UserPayMoney;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserPayMoneyService {
     public List<PayMoney> selectAllUserPayMoney();

     int insertUserPayMoney(UserPayMoney userPayMoney);

     public PayMoney selectById(Integer id);

     int insertFlowOfFunds(FlowOfFunds flowOfFunds);


}
