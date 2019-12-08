package com.bjsxt.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	
	private static Properties props = new Properties();
	
	static{
		InputStream is = null;
		
		is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static String getfath()
	{
		String s=(String)props.get("Filepath");
		return s;
	}
		
	//获得连接
	public static Connection createConn(){
		Connection conn = null; 
		try {
			Class.forName((String)props.get("driver"));
			//ip地址 + 数据库名称
			conn = DriverManager.getConnection((String)props.get("url"), (String)props.get("username"), (String)props.get("password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//编译执行
	public static PreparedStatement getPs(Connection conn , String sql){
		PreparedStatement ps = null; 
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps ; 
	}

	public static void close(Connection conn,ResultSet rs,PreparedStatement ps){
		try {
				if(conn != null){
					conn.close();
				} 
				if(rs != null){
					rs.close();
				} 
				if(ps != null){
					ps.close();
				} 
		}
				catch (Exception e) {
					e.printStackTrace();
				}
	}
		
	
	
}
