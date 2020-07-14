package com.finance.service.impl.admin.finance;

import com.finance.mapper.others.PayMoneyMapper;
import com.finance.pojo.others.PayMoney;
import com.finance.service.admin.finance.PayMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayMoneyServiceImpl implements PayMoneyService {
    @Autowired
    private PayMoneyMapper payMoneyMapper;

    @Override
    public List<PayMoney> selectAllPayMoney() {
        return payMoneyMapper.selectByExample(null);
    }

    @Override
    public int insertPayMoney(PayMoney payMoney) {
        return payMoneyMapper.insertSelective(payMoney);
    }

    @Override
    public PayMoney selectPayMoneyById(int id) {
        return payMoneyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updatePayMoney(PayMoney payMoney) {
        return payMoneyMapper.updateByPrimaryKeySelective(payMoney);
    }

    @Override
    public int deletePayMoneyById(int id) {
        return payMoneyMapper.deleteByPrimaryKey(id);
    }
}
