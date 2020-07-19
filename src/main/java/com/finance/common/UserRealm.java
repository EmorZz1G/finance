package com.finance.common;

import com.finance.pojo.user.User;
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

public class UserRealm extends AuthorizingRealm {

    @Autowired
    LoginService loginService;

    @Autowired
    com.finance.service.admin.permission.UserPermissionsService permissionsService;

    @Override
    // 授权
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

