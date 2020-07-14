package com.finance.service.user.userinfo;

import com.finance.pojo.others.Bankcard;

import java.util.List;

public interface BankcardService {
    List<Bankcard> selectBankCards();
    Bankcard getBankCardById(int id);
    int updateBankCard(Bankcard bankcard);
    int deleteBankCardById(int id);
}
