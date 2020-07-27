package com.finance.common;

import com.finance.pojo.user.User;
import com.finance.service.login.LoginByEmailService;
import com.finance.service.login.LoginByPhoneService;
import com.finance.service.login.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户授权认证
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    LoginService loginService;

    @Autowired
    LoginByEmailService loginByEmailService;

    @Autowired
    LoginByPhoneService loginByPhoneService;

    @Autowired
    com.finance.service.admin.permission.UserPermissionsService permissionsService;


    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object principal = SecurityUtils.getSubject().getPrincipal();
        User user;
        if (principal instanceof User) {
            user = (User) principal;
        } else {
            return null;
        }
        Set<String> set = permissionsService.selectPermsSetByUser(user);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add("USER");
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(set);
        return authorizationInfo;
    }

    /**
     * 认证
     * @param token1
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token1) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) token1;
        String username = token.getUsername();
        User user = loginService.loginVerifyUsernameForUser(username);
        if(user == null){
            user = loginByEmailService.loginVerifyUserEmail(username);
        }
        if(user == null){
            user = loginByPhoneService.loginVerifyUserPhone(username);
        }
        if (user != null) {
            return new SimpleAuthenticationInfo(user, user.getPassword(), "userRealm");
        }
        return null;
    }
}

