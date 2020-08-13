package com.finance.service.impl.admin.permission;

import com.finance.mapper.others.PermissionsMapper;
import com.finance.mapper.plus.others.PermissionsMapperPlus;
import com.finance.pojo.others.Permissions;
import com.finance.service.admin.permission.CommonPermissionService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@CacheConfig(cacheNames = "commonPerms")
public class CommonPermissionServiceImpl implements CommonPermissionService{

    @Resource
    PermissionsMapper permissionsMapper;
    @Resource
    PermissionsMapperPlus permissionsMapperPlus;


    @Override
    @Cacheable(key = "methodName")
    public Map<String, List<Permissions>> selectPermsAll() {
        return permissionsMapperPlus.selectList(null).
                stream().
                collect(Collectors.groupingBy(Permissions::getPermission));
    }



}
