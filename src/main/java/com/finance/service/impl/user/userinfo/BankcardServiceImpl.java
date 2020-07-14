package com.finance.service.impl.user.userinfo;

import com.finance.mapper.others.BankcardMapper;
import com.finance.pojo.others.Bankcard;
import com.finance.service.user.userinfo.BankcardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class BankcardServiceImpl implements BankcardService {

    @Resource
    BankcardMapper bankcardMapper;

    @Override
    public List<Bankcard> selectBankCards() {
        return bankcardMapper.selectByExample(null);
    }

    @Override
    public Bankcard getBankCardById(int id) {
        return bankcardMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateBankCard(Bankcard bankcard) {
        return bankcardMapper.updateByPrimaryKeySelective(bankcard);
    }

    @Override
    public int deleteBankCardById(int id) {
        return bankcardMapper.deleteByPrimaryKey(id);
    }
}
