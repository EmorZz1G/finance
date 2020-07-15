package com.finance.service.admin.finance;


import com.finance.pojo.others.ChangeMoney;

import java.util.List;

public interface ChangeMoneyService {
    List<ChangeMoney> selectChangeMoneyAll();
    int insertChangeMoney(ChangeMoney changeMoney);

    ChangeMoney selectChangeMoneyById(int id);

    int updateChangeMoney(ChangeMoney changeMoney);

    int deleteChangeMoneyById(int id);

}
