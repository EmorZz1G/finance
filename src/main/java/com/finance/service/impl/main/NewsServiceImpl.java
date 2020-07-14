package com.finance.service.impl.main;

import com.finance.mapper.others.NewsMapper;
import com.finance.pojo.others.News;
import com.finance.service.user.main.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    NewsMapper newsMapper;


    @Override
    public List<News> selectNewsAll() {
        return newsMapper.selectByExample(null);
    }
}
