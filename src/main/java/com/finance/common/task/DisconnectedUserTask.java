package com.finance.common.task;


import com.finance.common.LockHelper;
import com.finance.mapper.others.task.AutoTaskMapper;
import com.finance.pojo.others.task.AutoTask;
import com.finance.pojo.user.User;
import com.finance.service.login.LoginService;
import com.finance.service.user.userinfo.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 定期修改用户状态
 */
@Configuration
public class DisconnectedUserTask {
    Logger log = LoggerFactory.getLogger(DisconnectedUserTask.class);
    @Autowired
    UserInfoService userInfoService;

    @Autowired
    LoginService loginService;

    @Autowired
    AutoTaskMapper autoTaskMapper;


    @Scheduled(cron = "0 0 * * * ?")
    public void disconnectedUsers() {
        log.info("准备清理不在线用户");
        List<User> users = userInfoService.selectOnlineStatusUsers();
        ConcurrentHashMap<Integer, HttpSession> map = LockHelper.getHelperMap();
        int er = 0;
        for (User user : users) {
            if (!map.containsKey(user.getId())) {
                er += loginService.status2Disconnected(user);
            }
        }
        log.info("修改用户状态的用户数量：" + er);
        AutoTask autoTask = new AutoTask();
        autoTask.setName("准备清理不在线用户");
        autoTask.setType(4);
        autoTask.setInvokeTime(new Date());
        autoTask.setTargetStatus("修改用户状态的用户数量：" + er);
        autoTaskMapper.insertSelective(autoTask);
    }
}
