package com.finance.service.impl.admin.finance;

import com.finance.mapper.others.PayMoneyMapper;
import com.finance.pojo.others.PayMoney;
import com.finance.service.admin.finance.PayMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PayMoneyServiceImpl implements PayMoneyService {

    @Resource
    private PayMoneyMapper payMoneyMapper;

    /**
     * 查询所有工资理财信息
     * @return
     */
    @Override
    public List<PayMoney> selectAllPayMoney() {
        return payMoneyMapper.selectByExample(null);
    }

    /**
     * 插入工资理财信息
     * @param payMoney 工资理财实体类
     * @return
     */
    @Override
    public int insertPayMoney(PayMoney payMoney) {
        return payMoneyMapper.insertSelective(payMoney);
    }

    /**
     * 根据工资理财id查询工资理财信息
     * @param id 工资理财id
     * @return
     */
    @Override
    public PayMoney selectPayMoneyById(int id) {
        return payMoneyMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新工资理财信息
     * @param payMoney 工资理财实体类
     * @return
     */
    @Override
    public int updatePayMoney(PayMoney payMoney) {
        return payMoneyMapper.updateByPrimaryKeySelective(payMoney);
    }

    /**
     * 根据工资理财id删除工资理财信息
     * @param id 工资理财id
     * @return
     */
    @Override
    public int deletePayMoneyById(int id) {
        return payMoneyMapper.deleteByPrimaryKey(id);
    }
}
