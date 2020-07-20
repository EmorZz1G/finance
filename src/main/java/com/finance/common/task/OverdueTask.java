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

@Configuration
public class OverdueTask {
    Logger log = LoggerFactory.getLogger(RepayTask.class);

    @Autowired
    LoanExamService loanExamService;

    @Resource
    InfoMapper infoMapper;

    @Resource
    AutoTaskMapper autoTaskMapper;

    private int count = 0;
//    private int pageNum = 0;
//    private static int pageSize = 1000;

    private int errorRow = 0;

    @Scheduled(cron = "0/30 0 7 * * ?")
//    @Scheduled(cron = "* * * * * ?")
    public void overdue(){
        if (count == 0) {
            count = loanExamService.getTotalCount(0);
        }
        log.info("重置逾期");
        int effectRow = loanExamService.updateOverdue();

//        pageNum += pageSize;

        AutoTask autoTask = new AutoTask();
        autoTask.setInvokeTime(new Date());
        autoTask.setName("修改逾期");
        autoTask.setType(3);
        autoTask.setTargetStatus("执行的修改逾期记录数量：" + effectRow);
        int i = autoTaskMapper.insertSelective(autoTask);
        log.info("执行成功的自动任务数量：" + effectRow + "；失败的数量：" + i);

    }
}
