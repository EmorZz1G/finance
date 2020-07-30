package com.finance.service.user.userinfo;

import com.finance.pojo.others.Bankcard;
import com.finance.pojo.user.User;

import java.util.List;
import java.util.Map;

public interface BankcardService {
    List<Bankcard> selectBankCards();
    Bankcard getBankCardById(int id);
    int updateBankCard(Bankcard bankcard);
    int deleteBankCardById(int id);

    List<Bankcard> selectUsersByQuery(Map<String,Object> query);
    User selectUserByUsername(String username);
}
