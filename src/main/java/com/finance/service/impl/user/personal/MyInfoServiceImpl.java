package com.finance.service.impl.user.personal;

import com.finance.mapper.others.InfoMapper;
import com.finance.pojo.others.Info;
import com.finance.pojo.others.InfoExample;
import com.finance.service.user.personal.MyInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class MyInfoServiceImpl implements MyInfoService {

    @Resource
    InfoMapper infoMapper;


    @Override
    public List<Info> selectInfosByUserId(Integer id) {
        InfoExample infoExample = new InfoExample();
        InfoExample.Criteria criteria = infoExample.createCriteria();
        criteria.andReceiveIdEqualTo(id);
        criteria.andStatusNotEqualTo(2);
        return infoMapper.selectByExample(infoExample);
    }

    @Override
    public int getUnReadInfoCountByUserId(Integer id) {
        InfoExample infoExample = new InfoExample();
        InfoExample.Criteria criteria = infoExample.createCriteria();
        criteria.andReceiveIdEqualTo(id);
        criteria.andStatusEqualTo(0);
        return infoMapper.countByExample(infoExample);
    }

    @Override
    public int updateInfoStatus(int id) {
        Info info = new Info();
        info.setId(id);
        info.setStatus(1);
        return infoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public int deleteInfoById(int id) {
        Info info = new Info();
        info.setId(id);
        info.setStatus(2);
        return infoMapper.updateByPrimaryKeySelective(info);
    }
}
