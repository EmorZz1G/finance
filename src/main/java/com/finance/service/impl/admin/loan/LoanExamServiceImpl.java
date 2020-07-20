package com.finance.service.impl.admin.loan;

import com.finance.mapper.ext.others.LoanMapperExt;
import com.finance.mapper.others.FlowOfFundsMapper;
import com.finance.mapper.others.InfoMapper;
import com.finance.mapper.others.LoanMapper;
import com.finance.pojo.admin.Admin;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.Info;
import com.finance.pojo.others.Loan;
import com.finance.pojo.others.LoanExample;
import com.finance.pojo.user.UserExample;
import com.finance.service.admin.loan.LoanExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sound.sampled.DataLine;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LoanExamServiceImpl implements LoanExamService {
    @Resource
    private LoanMapper loanMapper;

    @Resource
    LoanMapperExt loanMapperExt;

    @Resource
    InfoMapper infoMapper;

    @Resource
    FlowOfFundsMapper flowOfFundsMapper;

    @Override
    public List<Loan> selectAllLoanExam() {
        return loanMapper.selectByExample(null);
    }

    @Override
    @Transactional
    public int updateLoanExam(Loan loan, Admin admin, int type) {
        Info info = new Info();
        info.setStatus(0);
        info.setCreateTime(new Date());
        info.setSendId(admin.getId());
        Loan loan1 = loanMapper.selectByPrimaryKey(loan.getId());
        info.setReceiveId(loan1.getLoanId());
        String desc;
        if (type == 1) {
            loan.setApplyStatus(2);
            info.setTitle("网贷审核通过");
            desc = "用户"+loan1.getUser().getUsername()+"的"+loan1.getAmount()
                    +"元网贷申请审核通过！审核人为："+admin.getUsername();
            FlowOfFunds flowOfFunds = new FlowOfFunds(null,
                    loan1.getLoanId(),
                    loan1.getAmount(),
                    2,
                    "网贷",
                    new Date(),
                    "网贷");
            flowOfFundsMapper.insertSelective(flowOfFunds);
        } else {
            loan.setApplyStatus(1);
            info.setTitle("网贷审核未通过");
            desc = "用户"+loan1.getUser().getUsername()+"的"+loan1.getAmount()
                    +"元网贷申请审核未通过！审核人为："+admin.getUsername();
        }
        info.setInfoDesc(desc);
        int i = loanMapper.updateByPrimaryKeySelective(loan);
        if(i==1){
            return infoMapper.insertSelective(info);
        }else {
            return 0;
        }
    }

    @Override
    public int remindPay(Loan loan, Admin admin) {
        Loan loan1 = loanMapper.selectByPrimaryKey(loan.getId());
        Info info = new Info();
        info.setTitle("还款通知");
        info.setSendId(admin.getId());
        info.setReceiveId(loan1.getLoanId());
        info.setCreateTime(new Date());
        String desc = "用户" + loan1.getUser().getUsername()
                + "申请的" + loan1.getAmount() + "元网贷该还款了！该提醒发送人为：" + admin.getUsername();
        info.setInfoDesc(desc);
        info.setStatus(0);
        return infoMapper.insertSelective(info);
    }

    @Override
    public List<Loan> autoRemindPay(int pageNum, int pageSize, int loanStatus) {
        return loanMapperExt.autoRemindPay(pageNum, pageSize, loanStatus);
    }

    @Override
    public int getTotalCount(int loanStatus) {
        return loanMapperExt.getTotalCount(loanStatus);
    }

    @Override
    public List<Loan> notOverdue(int pageNum, int pageSize, int loanStatus) {
        return loanMapperExt.notOverdue(pageNum,pageSize,loanStatus);
    }

    @Override
    public List<Loan> overdue(int pageNum, int pageSize, int loanStatus) {
        return loanMapperExt.overdue(pageNum,pageSize,loanStatus);
    }

    @Override
    public int updateOverdue(){
        return loanMapperExt.updateOverdue();
    }

}
