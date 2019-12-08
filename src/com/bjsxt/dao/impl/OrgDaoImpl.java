package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bjsxt.base.BaseDaoImpl;
import com.bjsxt.dao.OrgDao;
import com.bjsxt.model.Org;
import com.bjsxt.model.Resource;
import com.bjsxt.util.DBUtils;

public class OrgDaoImpl extends BaseDaoImpl<Org> implements OrgDao{

	public List<Org> findList(String id) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = "";
		if("".equals(id) || id == null){
			sql = "select * from org where parent_id = 999999";
		} else {
			sql = "select * from org where parent_id = " + id ;
		}
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		
		List<Org> rlist = new ArrayList<Org>();
		while(rs.next()){
			Org org = new Org();
			org.setId(rs.getInt("id"));
			org.setIconCls(rs.getString("iconCls")); 
			org.setName(rs.getString("name"));
			org.setPrincipal(rs.getString("principal"));
			org.setCount(rs.getInt("count"));
			org.setParent_id(rs.getInt("parent_id"));
			org.setDescription(rs.getString("description"));
			if(getChildren(org.getId()).size() >0){
				org.setState("closed");
			}
			rlist.add(org);
		}
		return rlist;
	}
	
	
	public List<Org> getChildren(int id) throws Exception{
		
		Connection conn = DBUtils.createConn();
		String sql = "";
			sql = "select * from org where parent_id = " + id ;
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		
		List<Org> rlist = new ArrayList<Org>();	
		while(rs.next()){
			Org org = new Org();
			org.setId(rs.getInt("id"));
			org.setIconCls(rs.getString("iconCls")); 
			org.setName(rs.getString("name"));
			org.setPrincipal(rs.getString("principal"));
			org.setCount(rs.getInt("count"));
			org.setParent_id(rs.getInt("parent_id"));
			org.setDescription(rs.getString("description"));
			rlist.add(org);
		}		
		return rlist;
	}
	
	
	
	
	

}
