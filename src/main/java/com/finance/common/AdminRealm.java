package com.finance.common;

import com.finance.pojo.admin.Admin;
import com.finance.service.admin.permission.AdminPermissionsService;
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

public class AdminRealm extends AuthorizingRealm {

    @Autowired
    LoginService loginService;

    @Autowired
    AdminPermissionsService permissionsService;

    @Override
    // 授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object primaryPrincipal = SecurityUtils.getSubject().getPrincipal();
        Admin admin;
        if (primaryPrincipal instanceof Admin) {
            admin = (Admin) primaryPrincipal;
        } else {
            return null;
        }
        Set<String> set = permissionsService.selectPermsSetByAdmin(admin);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(set);
        return authorizationInfo;
    }

    @Override
    // 认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token1) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) token1;
        String username = token.getUsername();
        Admin admin = loginService.loginVerifyUsername(username);
        if (admin != null) {
            return new SimpleAuthenticationInfo(admin, admin.getPassword(), "adminRealm");
        }
        return null;
    }
}
