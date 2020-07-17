package com.finance.service.impl.admin.historyinfo;

import com.finance.mapper.others.InfoMapper;
import com.finance.pojo.others.Info;
import com.finance.service.admin.historyinfo.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService {
    @Resource
    InfoMapper infoMapper;


    @Override
    public List<Info> selectAllInfo() {
        return infoMapper.selectByExample(null);
    }

    @Override
    public int deleteInfoById(int id) {
        return infoMapper.deleteByPrimaryKey(id);
    }
}
