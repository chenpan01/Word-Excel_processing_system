package com.bjsxt.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.bjsxt.model.Updatexx;
import com.bjsxt.model.User;
import com.bjsxt.stumodel.*;
import com.bjsxt.util.*;

public class BaseDaoImpl<Entity> implements BaseDao<Entity>{

	//public 
	protected Class clazz ;
	
	public BaseDaoImpl(){

		//System.out.println(this.getClass());
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		//带有真实类型参数的对象
		clazz = (Class)pt.getActualTypeArguments()[0];
		System.out.println(clazz);
	}//getUpdatexx
	public List<Updatexx> getUpdatexx(int currentPage, int pageSize)
	{
		Connection conn=null;
		//		System.out.println("findByPagination "+sql);
		//name kcmc score kcxz kssj teacher xueyuan xq ksdd bz
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Updatexx> ulist=new ArrayList<Updatexx>();
		try {
			conn = DBUtils.createConn();
			String sql = " select * from updatexx ";
			sql = sql + " limit " + (currentPage - 1) * pageSize + " , "
					+ pageSize;
			ps = DBUtils.getPs(conn, sql);
			rs = ps.executeQuery();
			ulist = new ArrayList<Updatexx>();
			while (rs.next()) {
				//System.out.println(rs.getString("ClassName"));
				//"kcmc","score","kcxz","kssj","teacher","xueyuan","xq","ksdd","bz"
				Updatexx kspk = new Updatexx();
				kspk.setTime(rs.getString("time"));//rs.getString("cxcj")
				kspk.setContent(rs.getString("content"));
				ulist.add(kspk);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn, rs, ps);
		}
		return ulist;
	}
	public List<Kspk> getKspk(int currentPage, int pageSize)
	{
		Connection conn=null;
		//		System.out.println("findByPagination "+sql);
		//name kcmc score kcxz kssj teacher xueyuan xq ksdd bz
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Kspk> ulist=new ArrayList<Kspk>();
		try {
			conn = DBUtils.createConn();
			String sql = " select * from kspk ";
			sql = sql + " limit " + (currentPage - 1) * pageSize + " , "
					+ pageSize;
			ps = DBUtils.getPs(conn, sql);
			rs = ps.executeQuery();
			ulist = new ArrayList<Kspk>();
			while (rs.next()) {
				//System.out.println(rs.getString("ClassName"));
				//"kcmc","score","kcxz","kssj","teacher","xueyuan","xq","ksdd","bz"
				Kspk kspk = new Kspk();
				kspk.setScore(rs.getString("score"));//rs.getString("cxcj")
				kspk.setKcmc(rs.getString("kcmc"));
				kspk.setKcxz(rs.getString("kcxz"));
				kspk.setKssj(rs.getString("kssj"));
				kspk.setTeacher(rs.getString("teacher"));
				kspk.setXueyuan(rs.getString("xueyuan"));
				kspk.setXq(rs.getString("xq"));
				kspk.setKsdd(rs.getString("ksdd"));
				kspk.setBz(rs.getString("bz"));
				ulist.add(kspk);
				//return ulist;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn, rs, ps);
		}
		return ulist;
	}
	
	
	public List<Xscj> getXscj(int currentPage, int pageSize)
	{
		Connection conn=null;
		//		System.out.println("findByPagination "+sql);
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Xscj> ulist=new ArrayList<Xscj>();
		try {
			conn = DBUtils.createConn();
			String sql = " select * from xscj ";
			sql = sql + " limit " + (currentPage - 1) * pageSize + " , "
					+ pageSize;
			ps = DBUtils.getPs(conn, sql);
			rs = ps.executeQuery();
			ulist = new ArrayList<Xscj>();
			while (rs.next()) {
				//System.out.println(rs.getString("ClassName"));
				//kcmc,sore note zscj pkcj pknote cxcj jdsore kcxz
				Xscj xscj = new Xscj();
				xscj.setKcmc(rs.getString("kcmc"));
				xscj.setCxcj(rs.getString("cxcj"));//rs.getString("cxcj")
				xscj.setJdsore(rs.getString("jdsore"));
				xscj.setKcxz(rs.getString("kcxz"));
				xscj.setNote(rs.getString("note"));
				xscj.setZscj(rs.getString("zscj"));
				xscj.setSore(rs.getString("sore"));
				xscj.setPknote(rs.getString("pknote"));
				xscj.setPkcj(rs.getString("pkcj"));
				ulist.add(xscj);
				//return ulist;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn, rs, ps);
		}
		return ulist;
	}
	public int getWeekNum()
	{
		String[][] WeekNum= new String[][]{{"3.5","3.11"},{"3.5","3.11"},{"3.12","3.18"},{"3.19","3.25"}
		,{"3.26","4.1"},{"4.2","4.8"},{"4.9","4.15"},{"4.16","4.22"},{"4.23","4.29"}
		,{"4.30","5.6"},{"5.7","5.13"},{"5.14","5.20"},{"5.21","5.27"},{"5.28","6.3"}
		,{"6.4","6.10"},{"6.11","6.17"},{"6.18","6.24"},{"6.25","7.1"}};
		Calendar now = Calendar.getInstance();  
		int  Month=now.get(Calendar.MONTH) + 1;
		int Day=now.get(Calendar.DAY_OF_MONTH);
		System.out.println(Month+"----"+Day);
		int week=0,day=0;
		for(int i=0;i<18;i++)
		{
			String fir=""+WeekNum[i][0].charAt(0);
			String end=""+WeekNum[i][1].charAt(0);
			if(fir.equals(""+Month))
			{
				int index=WeekNum[i][0].indexOf('.');
				day=Integer.parseInt(WeekNum[i][0].substring(index+1));
				if(day>Day)
					continue;
				int max=0;
				if(Month==1||Month==3||Month==5||Month==7||Month==8||Month==10||Month==12)
					max=31;
				else if(Month==2)
					max=28;
				else
					max=30;
				for(int i1=day;i1<=max;i1++)
				{
					if(Day==i1)
					{
						week=i+1;
						break;
					}
				}
				
			}
			else if(end.equals(""+Month))
			{
				fir=""+WeekNum[i][1].charAt(0);
				int index=WeekNum[i][1].indexOf('.');
				day=Integer.parseInt(WeekNum[i][1].substring(index+1));
				if(Day>day)
					continue;
				else
				{
					week=i+1;
					break;
				}
			}
			
		}
		System.out.println("week "+week);
		return week;
	}
	public void save(Entity obj) throws Exception 
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//obj.getSimpleName();
		try{
			conn = DBUtils.createConn();
			ps=conn.prepareStatement("select id from jkxx;");
			int index=0;
			rs=ps.executeQuery();
			while(rs.next())
			{
				index=rs.getInt("id");
			}
			index=index+1;
			String sql = "insert into " + "jkxx" + " values("+index;
			// 可以获取本类所声明的变量
			Field[] fs = clazz.getDeclaredFields();
			//System.out.println(fs.length);
			
			for (int i = 1; i < fs.length; i++) {
				sql += ",? " ;
			}
			sql = sql + ")";
			System.out.println(sql);
			
			//进行预编译
			ps = DBUtils.getPs(conn, sql);
			
			//ps.setString(1, user.getName());
			
			for (int i = 1; i < fs.length; i++) {
				//拼接方法的名称
				//参考博客 http://blog.csdn.net/lufeng20/article/details/8643599
				String MethodName = "get" +Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1) ;
				Method m = clazz.getMethod(MethodName);
				ps.setObject(i, m.invoke(obj));
			}
			ps.executeUpdate();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn, rs, ps);
		}
		
	}
	
	/**
	 * 更新方法
	 */
	public void update(Entity obj) throws Exception {

			Connection conn = DBUtils.createConn();
			// update user set name = ? , age = ? where id = ?
			String sql = " update " + "jkxx" + " set  ";
			Field[] fs = clazz.getDeclaredFields();
			for (int i = 1; i < fs.length; i++) {
				sql += fs[i].getName() + "=?,";
			}
			sql = sql.substring(0, sql.length()-1) + " where id = ? ";
			
			PreparedStatement ps = DBUtils.getPs(conn, sql);
			
			for (int i = 1; i < fs.length; i++) {
				String methodName = "get" + Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1);
				Method m  = clazz.getMethod(methodName);
				ps.setObject(i, m.invoke(obj));// user.getName();
			}
			Method m2 = clazz.getMethod("getId");
			ps.setInt(fs.length,(Integer)m2.invoke(obj));
			
			ps.executeUpdate();
			DBUtils.close(conn, null, ps);;			
			
	}

	/**
	 * 根据一个id 查找对象
	 */
	public Entity findById(int id) throws Exception {
		Connection conn = DBUtils.createConn();
		String sql = " select * from  " + "jkxx" +  " where id = " + id ;
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		ResultSet rs = ps.executeQuery();
		Entity entity =  (Entity) clazz.newInstance();
		if(rs.next()){
			Field[]  fs = clazz.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {
				
				String methodName = "set" + Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1);
				Method m = clazz.getDeclaredMethod(methodName, fs[i].getType());
				m.invoke(entity, rs.getObject(fs[i].getName()));
			}
		}
		DBUtils.close(conn, rs, ps);
		return entity;
	}

	/**
	 * 查询所有
	 */
	public List<Entity> findAll() throws Exception {
		Connection conn = DBUtils.createConn();
		String sql =" select * from " + "jkxx";
		PreparedStatement ps = DBUtils.getPs(conn, sql);
		
		List<Entity> list = new ArrayList<Entity>();
		
		ResultSet rs =  ps.executeQuery();
		
		while(rs.next()){
			Entity entity = (Entity)clazz.newInstance();
			
			Field[] fs = clazz.getDeclaredFields();
			for (int i = 0; i < fs.length; i++) {
				String methodName = "set"+ Character.toUpperCase(fs[i].getName().charAt(0)) + fs[i].getName().substring(1);
				Method m = clazz.getMethod(methodName, fs[i].getType());
				m.invoke(entity, rs.getObject(fs[i].getName()));
			}
			
			list.add(entity);
		}
		DBUtils.close(conn, rs, ps);
		return list;
	}

	/**
	 * 删除方法
	 */
	public void delete(int id) throws Exception {
			Connection conn = DBUtils.createConn();
			String sql = " delete from " + "jkxx" + " where id =" +id;
			PreparedStatement ps = DBUtils.getPs(conn, sql);
			ps.executeUpdate(sql);
			DBUtils.close(conn, null, ps);	
	}


	
	/**
	 * 条件查询的反射封装方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public  List<Entity> queryListForParams(String sql,Object[] params ) throws Exception{
		Connection conn  = DBUtils.createConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			// 建立statement对象(封装了sql)
			ps = conn.prepareStatement(sql); // select * from org where id = ? and name = ?  [1 , z3]
			if(params!=null){
				for(int i=0;i<params.length;i++){
					ps.setObject(i+1, params[i]);
				}
			}
			Field[] fs = clazz.getDeclaredFields();
			rs = ps.executeQuery();
			while(rs.next()){
				Object obj = clazz.getConstructor().newInstance();
				for(int i = 0 ; i <fs.length;i++ ){
					String methodName = "set" +fs[i].getName().substring(0, 1).toUpperCase()+fs[i].getName().substring(1);
					Method m = clazz.getMethod(methodName, fs[i].getType());			
					Object value = rs.getObject(fs[i].getName());  
					m.invoke(obj, value); 
				}
				list.add(obj);
			}				

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn, rs, ps);
		}
		return list;
	}		
	
	
}
