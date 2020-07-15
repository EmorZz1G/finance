package com.finance.service.impl.admin.finance;


import com.finance.mapper.others.BankMapper;
import com.finance.pojo.others.Bank;
import com.finance.pojo.others.PayMoney;
import com.finance.service.admin.finance.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BankServiceImpl implements BankService {
    @Resource
    private BankMapper bankMapper;
    @Override
    public List<Bank> selectBankAll(){
        return bankMapper.selectByExample(null);
    }
    @Override
    public int insertBank(Bank bank){
        return bankMapper.insertSelective(bank);
    }
    @Override
    public Bank selectBankById(int id) {
        return bankMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateBank(Bank bank) {
        return bankMapper.updateByPrimaryKeySelective(bank);
    }

    @Override
    public int deleteBankById(int id) {
        return bankMapper.deleteByPrimaryKey(id);
    }


}
