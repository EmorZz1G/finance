package com.finance.service.impl.admin.loan;

import com.finance.mapper.ext.others.LoanMapperExt;
import com.finance.mapper.others.LoanMapper;
import com.finance.pojo.others.Loan;
import com.finance.service.admin.loan.LoanInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LoanInfoServiceImpl implements LoanInfoService {

    @Resource
    private LoanMapper loanMapper;

    @Resource
    private LoanMapperExt loanMapperExt;

    /**
     * 查询所有网贷信息
     * @return
     */
    @Override
    public List<Loan> selectAllLoanInfo(){
        return loanMapper.selectByExample(null);
    }

    @Override
    public List<Loan> selectUsersByQuery(Map<String, Object> query) {
        try {
            return loanMapperExt.selectLoanFuzzy((String)query.get("username"),(Integer)query.get("loanStatus"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Loan> selectUsersByQueryHa(Map<String, Object> query) {
        try {
            return loanMapperExt.selectLoanFuzzyHa((String)query.get("username"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
