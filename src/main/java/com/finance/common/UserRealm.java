package com.finance.common;

import com.finance.pojo.user.User;
import com.finance.service.login.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    LoginService loginService;

    @Autowired
    com.finance.service.user.permission.UserPermissionsService permissionsService;

    @Override
    // 授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        User user;
        if (primaryPrincipal instanceof User) {
            user = (User) primaryPrincipal;
        } else {
            return null;
        }
        Set<String> set = permissionsService.selectPermsSetByUser(user);
//        System.out.println(set);
        //TODO
        System.out.println("用户");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(set);
        return authorizationInfo;
    }

    @Override
    // 认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token1) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) token1;
        String username = token.getUsername();
        User user = loginService.loginVerifyUsernameForUser(username);
        if (user != null) {
            return new SimpleAuthenticationInfo(user, user.getPassword(), "userRealm");
        }
        return null;
    }
}

