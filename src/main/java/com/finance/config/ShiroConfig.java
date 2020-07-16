package com.finance.config;


import com.finance.common.AdminRealm;
import com.finance.common.UserRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        Map<String,String> filterMap = new LinkedHashMap<>();

        // 直接访问
        filterMap.put("/login","anon");
        filterMap.put("/login/*","anon");
        filterMap.put("/register","anon");
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


        //TODO
        factoryBean.setLoginUrl("/login");
        factoryBean.setUnauthorizedUrl("/login");
        factoryBean.setFilterChainDefinitionMap(filterMap);
        return factoryBean;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultSecurityManager(@Qualifier("userRealm")UserRealm userRealm,
                                                               @Qualifier("adminRealm")AdminRealm adminRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setRealm(adminRealm);
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
}
