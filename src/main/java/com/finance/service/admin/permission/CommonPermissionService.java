package com.finance.service.admin.permission;

import com.finance.pojo.others.Permissions;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CommonPermissionService {

    Map<String, List<Permissions>> selectPermsAll();


}
