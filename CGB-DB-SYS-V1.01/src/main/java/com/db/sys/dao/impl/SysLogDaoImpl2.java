package com.db.sys.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;

public  class SysLogDaoImpl2 implements SysLogDao{
	@Autowired
	private DataSource dataSource;
	@Override
	public int getRowCount(String username) {
		//Connection conn=dataSource.getConnection();
		//conn.createStatement();
		//....
		return 0;
	}

	@Override
	public List<SysLog> findPageObjects(String username, Integer startIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
