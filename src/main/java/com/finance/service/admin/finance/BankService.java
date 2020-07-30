package com.finance.service.admin.finance;

        import com.finance.pojo.others.Bank;


        import java.util.List;

public interface BankService {
    List<Bank> selectBankAll();
    int insertBank(Bank bank);

    Bank selectBankById(int id);

    int updateBank(Bank bank);

    int deleteBankById(int id);


}
