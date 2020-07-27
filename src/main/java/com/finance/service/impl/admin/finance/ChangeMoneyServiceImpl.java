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

    /**
     * 查询所有零钱理财信息
     * @return
     */
    @Override
    public List<ChangeMoney> selectChangeMoneyAll(){
        return changeMoneyMapper.selectByExample(null);
    }

    /**
     * 插入零钱理财信息
     * @param changeMoney
     * @return
     */
    @Override
    public int insertChangeMoney(ChangeMoney changeMoney){
        return changeMoneyMapper.insertSelective(changeMoney);
    }

    /**
     *根据零钱理财id查询零钱理财信息
     * @param id 零钱理财id
     * @return
     */
    @Override
    public ChangeMoney selectChangeMoneyById(int id) {
        return changeMoneyMapper.selectByPrimaryKey(id);
    }

    /**
     *更新零钱理财信息
     * @param changeMoney
     * @return
     */
    @Override
    public int updateChangeMoney(ChangeMoney changeMoney) { return changeMoneyMapper.updateByPrimaryKeySelective(changeMoney); }

    /**
     *根据零钱理财id删除零钱理财信息
     * @param id 零钱理财id
     * @return
     */
    @Override
    public int deleteChangeMoneyById(int id) {
        return changeMoneyMapper.deleteByPrimaryKey(id);
    }
}
