package com.finance.service.user.finance;

import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserChangeMoney;

import java.util.List;

public interface UserChangeMoneyService {
    List<ChangeMoney> selectChangeMoneyAll();
    int insertUserChangeMoney(User user,ChangeMoney changeMoney);



}
