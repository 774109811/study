package com.mybatis.example.blog;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.example.po.Blog;

public class TestBlog {
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void init()throws IOException{
		String resource = "mybatis-config.xml";
		InputStream inputStream = 
		Resources.getResourceAsStream(resource);
		sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testBlog(){
		SqlSession session = sqlSessionFactory.openSession();
		try {
		  Blog blog = session.selectOne(
		  "org.mybatis.example.BlogMapper.selectBlog",1);
		  System.out.println(blog);
		} finally {
		  session.close();
		}
	}
	
}
