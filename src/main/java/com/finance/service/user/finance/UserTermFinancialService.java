package com.finance.service.user.finance;


import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.TermFinancial;
import com.finance.pojo.user.UserTermFinancial;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface UserTermFinancialService {
    public List<TermFinancial> selectAllUserTermFinancial();

    int insertUserTermFinancial(UserTermFinancial userTermFinancial, BigDecimal money);
    public TermFinancial selectById(Integer id);

    int insertFlowOfFunds(FlowOfFunds flowOfFunds, BigDecimal money);


}
