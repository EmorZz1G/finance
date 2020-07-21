package com.finance.service.impl.admin.permission;

import com.finance.mapper.others.PermissionsMapper;
import com.finance.pojo.others.Permissions;
import com.finance.service.admin.permission.CommonPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class CommonPermissionServiceImpl implements CommonPermissionService{

    @Resource
    PermissionsMapper permissionsMapper;


    @Override
    public Map<String, List<Permissions>> selectPermsAll() {
        return permissionsMapper.selectByExample(null).
                stream().
                collect(Collectors.groupingBy(Permissions::getPermission));
    }



}
