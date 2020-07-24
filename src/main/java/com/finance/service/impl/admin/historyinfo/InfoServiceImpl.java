package com.finance.service.impl.admin.historyinfo;

import com.finance.common.utils.FuzzySearchUtils;
import com.finance.mapper.others.InfoMapper;
import com.finance.pojo.others.FlowOfFunds;
import com.finance.pojo.others.FlowOfFundsExample;
import com.finance.pojo.others.Info;
import com.finance.pojo.others.InfoExample;
import com.finance.service.admin.historyinfo.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Info> selectInfoByQuery(Map<String, Object> query) {
        try {
            InfoExample example = (InfoExample) FuzzySearchUtils.autoWrapper(InfoExample.class, query);
            List<Info> infos= infoMapper.selectByExample(example);
            return infos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
