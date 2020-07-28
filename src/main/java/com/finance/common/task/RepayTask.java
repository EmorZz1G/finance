package com.finance.common.task;

import com.finance.mapper.others.InfoMapper;
import com.finance.mapper.others.task.AutoTaskMapper;
import com.finance.pojo.others.Info;
import com.finance.pojo.others.Loan;
import com.finance.pojo.others.task.AutoTask;
import com.finance.service.admin.loan.LoanExamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 自动发信息提醒还款
 */
@Configuration
public class RepayTask {

    Logger log = LoggerFactory.getLogger(RepayTask.class);

    @Autowired
    LoanExamService loanExamService;

    @Resource
    InfoMapper infoMapper;

    @Resource
    AutoTaskMapper autoTaskMapper;

    private int count = 0;
    private int pageNum = 0;
    private int pageSize = 1000;

    private int count2 = 0;
    private int pageNum2 = 0;


    private int effectRow = 0;
    private int errorRow = 0;

    public static Info creteInfo() {
        Info info = new Info();
        info.setStatus(0);
        info.setTitle("还款提醒");
        info.setSendId(3);
        info.setCreateTime(new Date());
        return info;
    }


    @Scheduled(cron = "0/30 0/20 10 * * ?")
    public void repayReminder() {
        if (count == 0) {
            count = loanExamService.getTotalCount(1);
        }
        List<Loan> loans = loanExamService.autoRemindPay(pageNum, pageSize, 1);
        log.info("准备执行提醒还款任务");
        if (loans == null) {
            count = loanExamService.getTotalCount(1);
            pageNum = 0;
            return;
        }
        Info info = creteInfo();

        effectRow = 0;
        errorRow = 0;
        for (Loan loan : loans) {
            BigDecimal amount = loan.getAmount();
            Integer loanId = loan.getLoanId();
            info.setInfoDesc("您申请的" + amount + "元网贷已经逾期了，请尽快还款了。（该消息由系统自动发送）");
            info.setReceiveId(loanId);
            int i = infoMapper.insertSelective(info);
            if (i == 1) {
                ++effectRow;
            } else {
                ++errorRow;
            }
        }

        pageNum += pageSize;

        AutoTask autoTask = new AutoTask();
        autoTask.setInvokeTime(new Date());
        autoTask.setName("还款提醒");
        autoTask.setType(1);
        autoTask.setTargetStatus("执行成功的消息提示数量：" + effectRow + "；失败的数量：" + errorRow);
        log.info("执行成功的消息提示数量：" + effectRow + "；失败的数量：" + errorRow);
        autoTaskMapper.insertSelective(autoTask);

    }

    @Scheduled(cron = "0/30 0/20 8 * * ?")
    // 未逾期提醒
    public void NotOverdueReminder() {
        if (count2 == 0) {
            count2 = loanExamService.getTotalCount(0);
        }
        List<Loan> loans = loanExamService.notOverdue(pageNum2, pageSize, 0);
        log.info("准备执行提醒还款任务/未逾期");
        if (loans == null) {
            count = loanExamService.getTotalCount(0);
            pageNum2 = 0;
            return;
        }
        Info info = creteInfo();

        effectRow = 0;
        errorRow = 0;
        for (Loan loan : loans) {
            BigDecimal amount = loan.getAmount();
            Integer loanId = loan.getLoanId();
            info.setInfoDesc("您申请的" + amount + "元网贷即将逾期了，请尽快还款。（该消息由系统自动发送）");
            info.setReceiveId(loanId);
            int i = infoMapper.insertSelective(info);
            effectRow+=i;
            errorRow += (i==0)?1:0;
        }

        pageNum2 += pageSize;

        AutoTask autoTask = new AutoTask();
        autoTask.setInvokeTime(new Date());
        autoTask.setName("还款提醒");
        autoTask.setType(2);
        autoTask.setTargetStatus("执行成功的消息提示数量：" + effectRow + "；失败的数量：" + errorRow);
        autoTaskMapper.insertSelective(autoTask);
        log.info("执行成功的消息提示数量：" + effectRow + "；失败的数量：" + errorRow);

    }
}
