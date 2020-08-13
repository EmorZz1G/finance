package com.finance.service.impl.user.personal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finance.mapper.others.BankcardMapper;
import com.finance.mapper.plus.others.BankcardMapperPlus;
import com.finance.pojo.others.Bankcard;
import com.finance.pojo.others.BankcardExample;
import com.finance.service.user.personal.UserBankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserBankCardServiceImpl implements UserBankCardService {
    @Resource
    BankcardMapper bankcardMapper;
    @Resource
    BankcardMapperPlus bankcardMapperPlus;

    @Override
    public List<Bankcard> selectBankCardById(int id) {
        /*BankcardExample bankcardExample = new BankcardExample();
        BankcardExample.Criteria criteria = bankcardExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        return bankcardMapper.selectByExample(bankcardExample);*/
        return bankcardMapperPlus.selectList(new QueryWrapper<Bankcard>().lambda()
                .eq(Bankcard::getUserId, id));
    }

    @Override
    public int addBankCard(Bankcard bankcard) {
        return bankcardMapperPlus.insert(bankcard);
    }
}
