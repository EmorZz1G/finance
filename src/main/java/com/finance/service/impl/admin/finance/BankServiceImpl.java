package com.finance.service.impl.admin.finance;


import com.finance.mapper.others.BankMapper;
import com.finance.mapper.plus.others.BankMapperPlus;
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

    @Resource
    private BankMapperPlus bankMapperPlus;

    /**
     * 查询所有银行信息
     * @return
     */
    @Override
    public List<Bank> selectBankAll(){
//        return bankMapper.selectByExample(null);
        return bankMapperPlus.selectList(null);
    }

    /**
     * 插入银行信息
     * @param bank 银行实体类
     * @return
     */
    @Override
    public int insertBank(Bank bank){
//        return bankMapper.insertSelective(bank);
        return bankMapperPlus.insert(bank);
    }

    /**
     * 根据银行id查询银行信息
     * @param id 银行id
     * @return
     */
    @Override
    public Bank selectBankById(int id) {
//        return bankMapper.selectByPrimaryKey(id);
        return bankMapperPlus.selectById(id);
    }

    /**
     * 更新银行信息
     * @param bank 银行实体类
     * @return
     */
    @Override
    public int updateBank(Bank bank) {
//        return bankMapper.updateByPrimaryKeySelective(bank);
        return bankMapperPlus.updateById(bank);
    }

    /**
     * 根据银行id删除银行信息
     * @param id 银行id
     * @return
     */
    @Override
    public int deleteBankById(int id) {
//        return bankMapper.deleteByPrimaryKey(id);
        return bankMapperPlus.deleteById(id);
    }


}
