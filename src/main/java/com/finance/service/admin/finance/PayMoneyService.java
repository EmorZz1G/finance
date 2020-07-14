package com.finance.service.admin.finance;

import com.finance.pojo.others.PayMoney;

import java.util.List;

public interface PayMoneyService {
    List<PayMoney> selectAllPayMoney();

    int insertPayMoney(PayMoney payMoney);

    PayMoney selectPayMoneyById(int id);

    int updatePayMoney(PayMoney payMoney);

    int deletePayMoneyById(int id);
}
