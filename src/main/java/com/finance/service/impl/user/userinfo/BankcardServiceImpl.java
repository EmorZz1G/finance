package com.finance.service.impl.user.userinfo;

import com.finance.mapper.others.BankcardMapper;
import com.finance.pojo.others.Bankcard;
import com.finance.service.user.userinfo.BankcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class BankcardServiceImpl implements BankcardService {

    @Resource
    BankcardMapper bankcardMapper;

    @Override
    public Bankcard getBankCardById(int id) {
        bankcardMapper.selectByPrimaryKey(id);
        return null;
    }
}
