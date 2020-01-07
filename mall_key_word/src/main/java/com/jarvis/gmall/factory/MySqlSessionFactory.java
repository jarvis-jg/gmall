package com.jarvis.gmall.factory;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MySqlSessionFactory {

	public static SqlSessionFactory getMyF() {

		InputStream resourceAsStream = MySqlSessionFactory.class.getClassLoader()
				.getResourceAsStream("mybatis-config.xml");

		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);

		return build;
	}

}
