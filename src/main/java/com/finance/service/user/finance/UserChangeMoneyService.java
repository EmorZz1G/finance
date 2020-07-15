package com.finance.service.user.finance;

import com.finance.pojo.others.ChangeMoney;
import com.finance.pojo.user.UserChangeMoney;

import java.util.List;

public interface UserChangeMoneyService {
    List<ChangeMoney> selectChangeMoneyAll();
    int insertUserChangeMoney(UserChangeMoney userChangeMoney);

}
