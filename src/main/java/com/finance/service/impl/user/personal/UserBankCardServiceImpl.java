package com.finance.service.impl.user.personal;

import com.finance.mapper.others.BankcardMapper;
import com.finance.pojo.others.Bankcard;
import com.finance.pojo.others.BankcardExample;
import com.finance.service.user.personal.UserBankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBankCardServiceImpl implements UserBankCardService {
    @Autowired
    BankcardMapper bankcardMapper;

    @Override
    public List<Bankcard> selectBankCardById(int id) {
        BankcardExample bankcardExample = new BankcardExample();
        BankcardExample.Criteria criteria = bankcardExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return bankcardMapper.selectByExample(bankcardExample);
    }

    @Override
    public int addBankCard(Bankcard bankcard) {
        return bankcardMapper.insertSelective(bankcard);
    }
}
