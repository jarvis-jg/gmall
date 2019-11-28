package com.jarvis.gmall.mapper;

import com.jarvis.gmall.dto.OBJECT_T_MALL_ATTR;
import com.jarvis.gmall.entity.T_MALL_VALUE;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * gmall : com.jarvis.gmall.mapper
 *
 * @author jarvis
 * @create 2019-11-27 21:38
 */
public interface AttrMapper {

    int insert_attr(@Param("flbh2") int flbh2, @Param("attr") OBJECT_T_MALL_ATTR attr);

    void insert_values(@Param("shxm_id") int shxm_id, @Param("value_list") List<T_MALL_VALUE> value_list);
}
