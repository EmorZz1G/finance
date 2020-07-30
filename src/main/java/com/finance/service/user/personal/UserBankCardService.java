package com.finance.service.user.personal;

import com.finance.pojo.others.Bankcard;

import java.util.List;

public interface UserBankCardService {
    List<Bankcard> selectBankCardById(int id);

    int addBankCard(Bankcard bankcard);
}
