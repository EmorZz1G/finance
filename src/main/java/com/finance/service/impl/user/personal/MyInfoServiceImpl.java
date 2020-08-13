package com.finance.service.impl.user.personal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finance.mapper.others.InfoMapper;
import com.finance.mapper.plus.others.InfoMapperPlus;
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
    @Resource
    InfoMapperPlus infoMapperPlus;


    @Override
    public List<Info> selectInfosByUserId(Integer id) {
        /*InfoExample infoExample = new InfoExample();
        InfoExample.Criteria criteria = infoExample.createCriteria();
        criteria.andReceiveIdEqualTo(id);
        criteria.andStatusNotEqualTo(2);
        return infoMapper.selectByExample(infoExample);*/
        return infoMapperPlus.selectList(new QueryWrapper<Info>().lambda()
        .eq(Info::getReceiveId,id)
        .ne(Info::getStatus,2));
    }

    @Override
    public int getUnReadInfoCountByUserId(Integer id) {
        /*InfoExample infoExample = new InfoExample();
        InfoExample.Criteria criteria = infoExample.createCriteria();
        criteria.andReceiveIdEqualTo(id);
        criteria.andStatusEqualTo(0);
        return infoMapper.countByExample(infoExample);*/
        return infoMapperPlus.selectCount(new QueryWrapper<Info>().lambda()
                .eq(Info::getReceiveId,id)
                .eq(Info::getStatus,0));
    }

    @Override
    public int updateInfoStatus(int id) {
        Info info = new Info();
        info.setId(id);
        info.setStatus(1);
        return infoMapperPlus.updateById(info);
    }

    @Override
    public int deleteInfoById(int id) {
        Info info = new Info();
        info.setId(id);
        info.setStatus(2);
        return infoMapperPlus.updateById(info);
    }
}
