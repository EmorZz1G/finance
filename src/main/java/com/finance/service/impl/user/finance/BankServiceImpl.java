package com.finance.service.impl.user.finance;

import com.finance.mapper.others.BankMapper;
import com.finance.mapper.plus.others.BankMapperPlus;
import com.finance.pojo.others.Bank;
import com.finance.service.user.finance.BankService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userBankServiceImpl")
public class BankServiceImpl implements BankService {

    @Resource
    BankMapper bankMapper;
    @Resource
    BankMapperPlus bankMapperPlus;

    /**
     * 查询所有银行信息
     *
     * @return
     */
    @Override
    public List<Bank> selectAllBank() {
        return bankMapperPlus.selectList(null);
    }
}
