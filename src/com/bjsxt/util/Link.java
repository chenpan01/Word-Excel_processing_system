package com.bjsxt.util;
import java.sql.*;
public class Link 
{
	private static Connection conn=null;
	private static final String password="rootchenpan";
	private static final String user="root";
	private static final String driver = "com.mysql.jdbc.Driver";           //ָ��MySQL JDBC�����
	private static final String url="jdbc:mysql://localhost/easyui?useUnicode=true&characterEncoding=UTF-8";
	static
	{
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection linksjk()
	{
		return conn;
	}
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs)
	{
		try {
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
