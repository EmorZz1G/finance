package com.finance.service.impl.main;

import com.finance.mapper.plus.others.NewsMapperPlus;
import com.finance.pojo.others.News;
import com.finance.service.user.main.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    NewsMapperPlus newsMapperPlus;


    /**
     * 查询新闻信息
     * @return 返回查询到的结果
     */
    @Override
    public List<News> selectNewsAll() {
        return newsMapperPlus.selectList(null);
    }
}
