package com.jarvis.mall.log.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * gmall : com.jarvis.mall.log.mapper
 *
 * @author jarvis
 * @create 2020-01-12 16:52
 */
public interface IndexMapper {

    void log(@Param("message") String message);
}
