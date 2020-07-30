package com.finance.service.user.personal;

public interface SecurityService {

    int updateUserPassword(int id,String oldpwd,String newpwd);
}
