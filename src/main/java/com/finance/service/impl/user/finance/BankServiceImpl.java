package com.finance.service.impl.user.finance;

import com.finance.mapper.others.BankMapper;
import com.finance.pojo.others.Bank;
import com.finance.service.user.finance.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userBankServiceImpl")
public class BankServiceImpl implements BankService {

    @Resource
    BankMapper bankMapper;


    @Override
    public List<Bank> selectAllBank() {
        return bankMapper.selectByExample(null);
    }
}
