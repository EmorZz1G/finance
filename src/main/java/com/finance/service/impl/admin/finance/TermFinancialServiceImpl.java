package com.finance.service.impl.admin.finance;

import com.finance.mapper.others.TermFinancialMapper;
import com.finance.pojo.others.TermFinancial;
import com.finance.service.admin.finance.TermFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TermFinancialServiceImpl implements TermFinancialService {

    @Resource
    TermFinancialMapper termFinancialMapper;

    /**
     * 查询所有期限理财信息
     * @return
     */
    @Override
    public List<TermFinancial> selectAllTermFinancial() {
        return termFinancialMapper.selectByExample(null);
    }

    /**
     * 插入期限理财信息
     * @param termFinancial 期限理财实体类
     * @return
     */
    @Override
    public int insertTermFinancial(TermFinancial termFinancial) {
        return termFinancialMapper.insertSelective(termFinancial);
    }

    /**
     * 根据期限理财id查询期限理财信息
     * @param id 期限理财id
     * @return
     */
    @Override
    public TermFinancial selectTermFinancialById(int id) {
        return termFinancialMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新期限理财信息
     * @param termFinancial 期限理财实体类
     * @return
     */
    @Override
    public int updateTermFinancial(TermFinancial termFinancial) {
        return termFinancialMapper.updateByPrimaryKeySelective(termFinancial);
    }

    /**
     * 根据期限理财id删除期限理财信息
     * @param id 期限理财id
     * @return
     */
    @Override
    public int deleteTermFinancial(int id) {
       return termFinancialMapper.deleteByPrimaryKey(id);
    }
}
