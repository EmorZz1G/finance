package com.finance.service.admin.finance;

import com.finance.pojo.others.TermFinancial;

import java.util.List;

public interface TermFinancialService {
    List<TermFinancial> selectAllTermFinancial();

    int insertTermFinancial(TermFinancial termFinancial);

    TermFinancial selectTermFinancialById(int id);

    int updateTermFinancial(TermFinancial termFinancial);

    int deleteTermFinancial(int id);
}
