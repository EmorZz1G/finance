package com.finance.common;

import com.finance.pojo.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.util.concurrent.ConcurrentHashMap;

public class LockHelper {
    private static Logger log = LoggerFactory.getLogger(LockHelper.class);
    private static Integer count = 0;

    public static ConcurrentHashMap<Integer, HttpSession> getHelperMap() {
        return helperMap;
    }

    private static ConcurrentHashMap<Integer, HttpSession> helperMap = new ConcurrentHashMap<>();

    public static Integer getCount() {
        return count;
    }

    public static ConcurrentHashMap addUser(HttpSession curSession, User user){
        if(curSession==null){
            return helperMap;
        }
        HttpSession preSession = helperMap.get(user.getId());
        // 用户已经存在
        if(preSession!=null){
            helperMap.remove(user.getId());
            preSession.invalidate();
            --count;
        }
        // 不存在该用户，或者存在，再加入新用户
        curSession.setAttribute("loginUser", user);
        helperMap.put(user.getId(),curSession);
        ++count;
        log.info("User: {}上线，当前在线人数: {}",user.getUsername(),count);
        return helperMap;
    }

    public static ConcurrentHashMap removeSession(User user){
        HttpSession preSession;
        try {
            preSession = helperMap.get(user.getId());
        }catch (Exception e){
            return helperMap;
        }
        if(preSession==null){
            return helperMap;
        }
        helperMap.remove(user.getId());
        preSession.invalidate();
        --count;
        log.info("User: {}下线，当前在线人数: {}",user,count);
        return helperMap;
    }
}
