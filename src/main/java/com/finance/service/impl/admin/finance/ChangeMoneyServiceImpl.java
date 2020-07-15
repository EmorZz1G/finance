package com.finance.service.impl.admin.finance;

import com.finance.mapper.others.BankMapper;
import com.finance.mapper.others.ChangeMoneyMapper;
import com.finance.pojo.others.Bank;
import com.finance.pojo.others.ChangeMoney;
import com.finance.service.admin.finance.ChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ChangeMoneyServiceImpl implements ChangeMoneyService {

    @Resource
    private ChangeMoneyMapper changeMoneyMapper;
    @Override
    public List<ChangeMoney> selectChangeMoneyAll(){
        return changeMoneyMapper.selectByExample(null);
    }
    @Override
    public int insertChangeMoney(ChangeMoney changeMoney){
        return changeMoneyMapper.insertSelective(changeMoney);
    }
    @Override
    public ChangeMoney selectChangeMoneyById(int id) {
        return changeMoneyMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateChangeMoney(ChangeMoney changeMoney) { return changeMoneyMapper.updateByPrimaryKeySelective(changeMoney); }

    @Override
    public int deleteChangeMoneyById(int id) {
        return changeMoneyMapper.deleteByPrimaryKey(id);
    }
}
