package com.bjsxt.dao.impl;

import java.sql.*;
import java.util.*;
import java.util.Map.Entry;

import com.bjsxt.base.BaseDaoImpl;
import com.bjsxt.dao.UserDao;
import com.bjsxt.model.Teacher_kcxx;
import com.bjsxt.model.User;
import com.bjsxt.util.*;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	
	/**
	 * 分页查询列表信息 
	 */
	public int getTotalkcxx(int Day)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=1;
		try {
			conn = DBUtils.createConn();
			String sql = " select count(*) from kcxx"+Day+"  where 1=1 ";
			
			ps = DBUtils.getPs(conn, sql);
			rs = ps.executeQuery();		
			count = 0;
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn, rs, ps);
		}
		return count;
	}
	public List<Teacher_kcxx> fingByPagination_kcxx(int currentPage, int pageSize ,int Day)
	{
		List<Teacher_kcxx> ulist = new ArrayList<Teacher_kcxx>();
		Connection conn =null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			 conn = DBUtils.createConn();
			 String sql = " select * from kcxx"+Day+" ";
			// sql = sql +" limit " + (currentPage-1)*pageSize +" , "  + pageSize ;
		     ps = DBUtils.getPs(conn, sql);
			 rs = ps.executeQuery();
			while(rs.next())
			{
				//System.out.println(rs.getString("ClassName"));
				Teacher_kcxx tk = new Teacher_kcxx();
				tk.setId(rs.getInt("id"));
				tk.setTime(rs.getString("time"));
				tk.setWeek1(rs.getString("week1"));
				tk.setWeek2(rs.getString("week2"));
				tk.setWeek3(rs.getString("week3"));
				tk.setWeek4(rs.getString("week4"));
				tk.setWeek5(rs.getString("week5"));
				tk.setWeek6(rs.getString("week6"));
				tk.setWeek7(rs.getString("week7"));
				ulist.add(tk);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn, rs, ps);
		}
		return ulist;
	}
	public List<User> findByPagination(int currentPage, int pageSize  ,Map<String ,Object> m) throws Exception
	{
		Connection conn = DBUtils.createConn();
		String sql = " select * from jkxx  where 1=1 ";
		Set<Entry<String, Object>> set = m.entrySet();
		Iterator io = set.iterator();
		while (io.hasNext()) {
			Map.Entry<String, Object> me = (Map.Entry<String, Object>) io.next();
			if("KsTime".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " and " + me.getKey() + " like '%"+ me.getValue()  +"%'" ;
				System.out.println(sql);
			}
			if("ClassName".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " and " + me.getKey() + " like '%"+ me.getValue()  +"%'";
				System.out.println(sql);
			}
			if("Position".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " and " + me.getKey() + " like '%"+ me.getValue()  +"%'";
				System.out.println(sql);
			}
			if("sort".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " order by " + me.getValue() ;
				System.out.println(sql);
			}
			if("order".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " " + me.getValue();
				System.out.println(sql);
			}			
		}
		sql = sql +" limit " + (currentPage-1)*pageSize +" , "  + pageSize ;
//		System.out.println("findByPagination "+sql);
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		
		List<User> ulist = new ArrayList<User>();
		while(rs.next()){
			//System.out.println(rs.getString("ClassName"));
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setKsTime(rs.getString("KsTime"));
			user.setKcName(rs.getString("KcName"));
			user.setClassName(rs.getString("ClassName"));
			user.setClassNum(rs.getString("ClassNum"));
			user.setSimilar(rs.getString("Similar"));
			user.setPosition(rs.getString("Position"));
			user.setPosi_num(rs.getString("Posi_num"));
			user.setSupervisor(rs.getString("Supervisor"));
			user.setJk1(rs.getString("jk1"));
			user.setJk2(rs.getString("jk2"));
			user.setJk3(rs.getString("jk3"));
			user.setJk4(rs.getString("jk4"));
			user.setTea_teacher(rs.getString("Tea_teacher"));
			user.setKh_Style(rs.getString("Kh_Style"));
			user.setNote(rs.getString("Note"));
			
			ulist.add(user);
		}
		DBUtils.close(conn, rs, ps);
		return ulist;
		
	}
	
	
	
	/**
	 * 查询表中的所有记录数 
	 */
	public int getTotal(Map<String ,Object> m) throws Exception {
		
		Connection conn = DBUtils.createConn();
		String sql = " select count(*) from jkxx  where 1=1 ";
		//int flag=0;
		Set<Entry<String, Object>> set = m.entrySet();
		Iterator io = set.iterator();
		while (io.hasNext()) {
			Map.Entry<String, Object> me = (Map.Entry<String, Object>) io.next();
			if("KsTime".equals(me.getKey()) && !"".equals(me.getValue()))
			{
				sql += " and "+me.getKey() + " like '%"+ me.getValue()  +"%'" ;
			}
			if("ClassName".equals(me.getKey()) && !"".equals(me.getValue()))
			{
				sql += " and " + me.getKey() + " >= '" + me.getValue() +"'";
			}
			if("Position".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " and " + me.getKey() + " <= '" + me.getValue() +"'";
			}
			if("sort".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " order by " + me.getValue() ;
			}
			if("order".equals(me.getKey()) && !"".equals(me.getValue())){
				sql += " " + me.getValue();
			}	
		}
		
		System.out.println(sql);
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();		
		int count = 0 ;
		if(rs.next()){
			count = rs.getInt(1);
		}
		DBUtils.close(conn, rs, ps);
		return count;
	}

	
	
	/**
	 * 根据名字查询记录
	 */
	public List<User> searchByName(String q) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql =" select * from jkxx where username like '%" + q + "%'" ;
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		List<User> ulist = new ArrayList<User>();
		while(rs.next())
		{
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setClassName(rs.getString("ClassName"));
			user.setKsTime(rs.getString("KsTime"));
			user.setKcName(rs.getString("KcName"));
			user.setClassNum(rs.getString("ClassNum"));
			user.setSimilar(rs.getString("Similar"));
			user.setPosition(rs.getString("Position"));
			user.setPosi_num(rs.getString("Posi_num"));
			user.setSupervisor(rs.getString("Supervisor"));
			user.setJk1(rs.getString("jk1"));
			user.setJk2(rs.getString("jk2"));
			user.setJk3(rs.getString("jk3"));
			user.setJk4(rs.getString("jk4"));
			user.setTea_teacher(rs.getString("Tea_teacher"));
			user.setKh_Style(rs.getString("Kh_Style"));
			user.setNote(rs.getString("Note"));
			ulist.add(user);
		}		
		DBUtils.close(conn, rs, ps);
		return ulist;
	}
	@Override
	public int getTotalkcxx() {
		// TODO Auto-generated method stub
		return 5;
	}

	
	


	
}
