package com.finance.common;

import com.finance.pojo.admin.Admin;
import com.finance.service.admin.permission.AdminPermissionsService;
import com.finance.service.login.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class AdminRealm extends AuthorizingRealm {

    @Autowired
    LoginService loginService;

    @Autowired
    AdminPermissionsService permissionsService;

    @Override
    // 授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Object primaryPrincipal = principals.getPrimaryPrincipal();
        Admin admin;
        if (primaryPrincipal instanceof Admin) {
            admin = (Admin) primaryPrincipal;
        } else {
            return null;
        }
        Set<String> set = permissionsService.selectPermsSetByAdmin(admin);
        //TODO
        System.out.println("管理员");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
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
        /*User user = loginService.loginVerifyUsernameForUser(username);
        if (user != null) {
            return new SimpleAuthenticationInfo(user, user.getPassword(), "userRealm");
        }*/
        return null;
    }
}
