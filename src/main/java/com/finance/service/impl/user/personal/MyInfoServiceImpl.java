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
        criteria.andReceiveidEqualTo(id);
        return infoMapper.selectByExample(infoExample);
    }
}
