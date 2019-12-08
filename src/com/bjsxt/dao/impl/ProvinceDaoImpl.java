package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.base.BaseDaoImpl;
import com.bjsxt.dao.ProvinceDao;
import com.bjsxt.model.City;
import com.bjsxt.model.Province;
import com.bjsxt.util.DBUtils;

public class ProvinceDaoImpl extends BaseDaoImpl<Province> implements ProvinceDao{

	public List<City> findCitiesByProId(int pid) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "select * from city where pro_id =" +pid;
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<City> clist = new ArrayList<City>();
		while(rs.next()){
			City c =new City();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			//c.setPro_id(rs.getInt("pro_id"));
			clist.add(c);
		}
		
		return clist;
	}


	
}
