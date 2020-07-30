package com.finance.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.finance.common.AdminRealm;
import com.finance.common.UserRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * shiro授权与认证的核心
 */
@Configuration
public class ShiroConfig {

    /**
     * 添加访问规则
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        Map<String,String> filterMap = new LinkedHashMap<>();

        // 直接访问
        filterMap.put("/login","anon");
        filterMap.put("/login/**","anon");
        filterMap.put("/register","anon");
        filterMap.put("/register/*","anon");
        filterMap.put("/","anon");
        filterMap.put("/toregister.html","anon");

        // 认证
        filterMap.put("/user/*", "authc");
        filterMap.put("/admin/*", "authc");
        filterMap.put("/logout","authc");

        // 授权
        // Admin

        // userinfo
        filterMap.put("/admin/userinfo/*","perms[admin:userInfo]" );
        // level 2 category
        filterMap.put("/admin/userinfo/toUserInfo.html","perms[admin:userInfoElse]" );

        filterMap.put("/admin/userinfo/toBankCard.html","perms[admin:bankCard]" );

        filterMap.put("/admin/userinfo/toReputation.html","perms[admin:reputation]" );

        // finance
        filterMap.put("/admin/finance/*","perms[admin:finance]" );
        // level 2 category
        filterMap.put("/admin/finance/toChangeMoney.html","perms[admin:changeMoney]");

        filterMap.put("/admin/finance/toPayMoney.html","perms[admin:payMoney]" );

        filterMap.put("/admin/finance/toTermFinancial.html","perms[admin:termFinancial]" );

        filterMap.put("/admin/finance/toFundProduct.html","perms[admin:fundProduct]" );

        // permissions
        filterMap.put("/admin/permission/*","perms[admin:permission]" );
        filterMap.put("/admin/permission/toUserPermissions.html","perms[admin:userPermissions]" );
        filterMap.put("/admin/permission/toAdminPermissions.html","perms[admin:adminPermissions]" );

        // loan
        filterMap.put("/admin/loan/*","perms[admin:loan]" );
        filterMap.put("/admin/loan/toLoanexam.html","perms[admin:loanExam]" );
        filterMap.put("/admin/loan/toLoaninfo.html","perms[admin:loanInfo]" );

        // history info
        filterMap.put("/admin/historyinfo/toRecord.html","perms[admin:fund]" );
        filterMap.put("/admin/historyinfo/toInfo.html","perms[admin:info]" );

        filterMap.put("/admin/super/*","perms[admin:super]" );




        // User
        // finance
        filterMap.put("/user/finance/*","perms[user:finance]" );

        filterMap.put("/user/finance/toChangeMoney.html","perms[user:changeMoney]" );
        filterMap.put("/user/finance/toPayMoney.html","perms[user:payMoney]" );
        filterMap.put("/user/finance/toTermFinancial.html","perms[user:termFinancial]" );
        filterMap.put("/user/finance/toFundProduct.html","perms[user:fundProduct]" );
        filterMap.put("/user/finance/toBank.html","perms[user:bank]" );
        // tools
        filterMap.put("/user/tools/*","perms[user:tools]" );
        filterMap.put("/user/tools/toRecord.html","perms[user:record]" );
        filterMap.put("/user/tools/toApplyLoan.html","perms[user:loan]" );








        factoryBean.setLoginUrl("/login");
        factoryBean.setUnauthorizedUrl("/unUnauthorized");
        factoryBean.setFilterChainDefinitionMap(filterMap);
        return factoryBean;
    }


    /**
     * 配置安全管理器
     * @param userRealm
     * @param adminRealm
     * @return 安全管理器
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultSecurityManager(@Qualifier("userRealm")UserRealm userRealm,
                                                               @Qualifier("adminRealm")AdminRealm adminRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        Set<Realm> set = new HashSet<>();
        set.add(userRealm);
        set.add(adminRealm);
        securityManager.setRealms(set);
        return securityManager;
    }

    @Bean("userRealm")
    public UserRealm getUserRealm(){
        return new UserRealm();
    }

    @Bean("adminRealm")
    public AdminRealm getAdminRealm(){
        return new AdminRealm();
    }

    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
