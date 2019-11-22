package com.jarvis.gmall.mapper;

import com.google.gson.Gson;
import com.jarvis.gmall.entity.T_MALL_CLASS_1;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * gmall : com.jarvis.gmall.mapper
 *
 * @author jarvis
 * @create 2019-11-18 21:43
 */
public class T_MALL_CLASS_1_mapperTest {

    @org.junit.Test
    public void getList() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        T_MALL_CLASS_1_mapper mapper = sqlSession.getMapper(T_MALL_CLASS_1_mapper.class);

        List<T_MALL_CLASS_1> list = mapper.getList();
        System.out.println(list.size());

        Gson gson = new Gson();
        String listStr = gson.toJson(list);

        FileOutputStream fos = new FileOutputStream("t_class_1.js");
        fos.write(listStr.getBytes());
        fos.close();
    }
}