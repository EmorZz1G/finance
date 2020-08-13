package com.finance.service.impl.admin.historyinfo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.finance.common.utils.FuzzySearchUtils;
import com.finance.mapper.others.InfoMapper;
import com.finance.mapper.plus.others.InfoMapperPlus;
import com.finance.pojo.others.*;
import com.finance.service.admin.historyinfo.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {
    @Resource
    InfoMapper infoMapper;
    @Resource
    InfoMapperPlus infoMapperPlus;

    /**
     * 查询所有历史消息
     * @return
     */
    @Override
    public List<Info> selectAllInfo() {
        return infoMapperPlus.selectList(null);
    }

    /**
     * 根据历史消息id删除历史信息
     * @param id
     * @return
     */
    @Override
    public int deleteInfoById(int id) {
        return infoMapperPlus.deleteById(id);
    }

    /**
     *查询历史信息
     * @param query
     * @return
     */
    @Override
    public List<Info> selectInfoByQuery(Map<String, Object> query) {
        try {
            /*InfoExample example = (InfoExample) FuzzySearchUtils.autoWrapper(InfoExample.class, query);
            List<Info> infos= infoMapper.selectByExample(example);
            return infos;*/
            QueryWrapper<Info> infoQueryWrapper = FuzzySearchUtils.autoWrapper(new QueryWrapper<Info>(), query);
            return infoMapperPlus.selectList(infoQueryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
