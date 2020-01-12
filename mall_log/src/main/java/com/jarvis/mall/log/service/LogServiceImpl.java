package com.jarvis.mall.log.service;

import com.jarvis.mall.log.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * gmall : com.jarvis.mall.log.service
 *
 * @author jarvis
 * @create 2020-01-12 16:58
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    IndexMapper indexMapper;

    @Override
    public void log(String s) {
        indexMapper.log(s);
    }
}
