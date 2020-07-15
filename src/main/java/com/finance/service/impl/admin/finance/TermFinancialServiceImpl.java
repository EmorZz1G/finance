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

    @Override
    public List<TermFinancial> selectAllTermFinancial() {
        return termFinancialMapper.selectByExample(null);
    }

    @Override
    public int insertTermFinancial(TermFinancial termFinancial) {
        return termFinancialMapper.insertSelective(termFinancial);
    }

    @Override
    public TermFinancial selectTermFinancialById(int id) {
        return termFinancialMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateTermFinancial(TermFinancial termFinancial) {
        return termFinancialMapper.updateByPrimaryKeySelective(termFinancial);
    }

    @Override
    public int deleteTermFinancial(int id) {
       return termFinancialMapper.deleteByPrimaryKey(id);
    }
}
