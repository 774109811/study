package com.db.sys.dao.impl;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
/**
 * SysLogDaoImpl -->ref-->SqlSessionFactory
 * SysLogDaoImpl<-->DI<---Spring IOC
 * @author ta
 */
@Repository
public class SysLogDaoImpl implements SysLogDao {
    /**
     * @Autowired 用于修饰属性，set方法，构造方法
     * 目的告诉告诉spring默认按类型(属性类型，参数类型)
     * 为属性赋值，假如类型有多个还可参考名字为对象注入值。
     */
	@Autowired
	private SqlSessionFactory factory;
	@Override
	public int getRowCount(String username) {
		System.out.println("dao.getRowCount(String username)");
		//1.获取SqlSession对象
		SqlSession session=factory.openSession();
		//DefaultSqlSession;
		//2.执行sql操作
		SysLogDao dao=session.getMapper(SysLogDao.class);
		int count=dao.getRowCount(username);
/*		String statement="com.db.sys.dao.SysLogDao.getRowCount";
		Map<String,Object> map=new HashMap<>();
		map.put("username", username);
		int count=session.selectOne(statement, map);*/
		//3.释放资源
		session.close();
		return count;
	}

	@Override
	public List<SysLog> findPageObjects(String username, Integer startIndex, Integer pageSize) {
		//SqlSession session=factory.openSession();
		//session.selectList(statement, parameter)
		//session.close();
		return null;
	}

}
