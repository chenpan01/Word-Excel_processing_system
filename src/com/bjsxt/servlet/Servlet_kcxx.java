package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.model.Teacher_kcxx;
import com.bjsxt.model.User;
import com.bjsxt.util.CreatExcel;
import com.bjsxt.util.DBUtils;
import com.bjsxt.util.ShowkcxxUtil;

public class Servlet_kcxx extends HttpServlet {

	private UserDao udao = new UserDaoImpl();
	/**
	 * Constructor of the object.
	 */
	public Servlet_kcxx() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException 
	{
		res.setContentType("text/html; charset=utf-8");
		res.setCharacterEncoding("utf-8");
		String method = "";
		String content = "";
		method=req.getParameter("method");
		if ("getList_kcxx".equals(method)) 
		{
			getList_kcxx(req, res);
		} 
		else if ("save".equals(method)) {
			save(req, res);
		} //
		else if ("update".equals(method)) {
			update(req, res);
		} 
		else if ("IsgetWeek".equals(method)) {
			IsgetWeek(req, res);
		} 
	}
	
	private void IsgetWeek(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		int Day=Integer.parseInt(req.getParameter("xlweek"));
		System.out.println("IsgetWeek xlweek "+Day);
		HttpSession session=req.getSession();
		session.setAttribute("Day", Day+"");
		try 
		{
			List<Teacher_kcxx> ulist;
			ulist = this.udao.fingByPagination_kcxx(0, 0,Day);
			int total = this.udao.getTotalkcxx();
			res.setContentType("text/html;charset=utf-8");
			String json = "{\"total\":" + total + " , \"rows\":"
					+ JSONArray.fromObject(ulist).toString() + "}";
			res.getWriter().write(json);
			res.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"ok\" , \"message\":\"操作成功!\"}";
		
			res.getWriter().write(str);
		} 
		catch (Exception e) 
		{
			res.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"fail\" , \"message\":\"操作失败!\"}";
			res.getWriter().write(str);
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			req.getRequestDispatcher("teacher/Showkcxx.jsp").forward(req, res);
		}
		
	}
	private void updatejsxx(String oldweek, String newxx) //updatejsxx(oldweek, newxx);
	{
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int id=0;
		try {
		Calendar now = Calendar.getInstance();  
		int  Month=now.get(Calendar.MONTH) + 1;
		int Day=now.get(Calendar.DAY_OF_MONTH);
		conn = DBUtils.createConn();
		String sql = " select * from updatexx";
			ps = DBUtils.getPs(conn, sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				id=rs.getInt("id");
			}
			id=id+1;
		 sql="insert into updatexx values('"+id+"','"+Month+"月"+Day+"日','"+
			oldweek+"调为"+newxx+"');";
			//+id+"',+Month+"月"+Day+"日','"+oldweek+"调为"+newxx+"');";
		 ps = DBUtils.getPs(conn, sql);
		 System.out.println("updatejsxx sql "+sql);
		 ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn, rs, ps);
		}
	}
	private void update(HttpServletRequest req, HttpServletResponse res) 
	{
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
//		System.out.println("update ");
		try 
		{
			String info="";
			CreatExcel ce=new CreatExcel();
			String Kcname=req.getParameter("kcupdate");
			HttpSession session=req.getSession();
			int oldDay=Integer.parseInt(session.getAttribute("week").toString());
			char c1=Kcname.charAt(0);//id号
			char c2=Kcname.charAt(1);//周数
			
			int index=Kcname.indexOf('{');
			int index1=Kcname.indexOf('}');
			
			String Time=Kcname.substring(index,index1+1);
			
			String oldweek=ShowkcxxUtil.isWeek_num(c2);//周数
			System.out.println("oldweek "+oldweek);
			char cx=oldweek.charAt(oldweek.length()-1);
			
			String week=(String) session.getAttribute("week");
			System.out.println("week "+week);
			
			Kcname=Kcname.substring(2,index);
			String oldxx=ShowkcxxUtil.swap_week(week+"")+ShowkcxxUtil.isWeek(cx)+Kcname;
			
			int updateaf=Integer.parseInt(req.getParameter("class_week"));
			String classPosition=req.getParameter("classPosition");
			String classbj  = req.getParameter("classbj");
			String updateTimeday = req.getParameter("updateTimeday");
			String updateTimejs = req.getParameter("updateTimejs");
			
			String newxx=ShowkcxxUtil.swap_week(updateaf+"")+updateTimeday+updateTimejs+Kcname;
			System.out.println("oldxx "+oldxx+" newxx "+newxx);
			updatejsxx(oldxx, newxx);
			//建筑设计原理与设计(四){第1-2周},第二综合楼711,13建筑2班
			//int beg1=Kcname.indexOf('')    +"{第"+beg.charAt(1)+"-"+end.charAt(1)+"周},"
			
			info=Kcname+Time+classPosition+","+classbj;
			int Id=Integer.parseInt(""+updateTimejs.charAt(0));
			Id=Id/2+1;
			
			String sql="update kcxx"+oldDay+" set "+oldweek+" = ' ' where id ="+c1;
			System.out.println("sql "+sql);
			conn=DBUtils.createConn();
			ps=DBUtils.getPs(conn, sql);
			ps.execute();
			
			sql="update kcxx"+updateaf+" set "+ShowkcxxUtil.getWeek_zw((updateTimeday.charAt(1)))+" = '"+info+"' where id ="+Id;
			ps=DBUtils.getPs(conn, sql);
			ps.execute();
			
			res.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"ok\" , \"message\":\"操作成功!\"}";
		
			res.getWriter().write(str);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			res.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"fail\" , \"message\":\"操作失败!\"}";
			try {
				res.getWriter().write(str);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn,null,ps);
		}

	}
	
	
	private void save(HttpServletRequest req, HttpServletResponse res) 
	{
		Connection conn=null;
		PreparedStatement ps=null;
		// TODO Auto-generated method stub
		String kcName=req.getParameter("kcName");
		String beg=req.getParameter("beg");
		String end=req.getParameter("end");
		System.out.println("end "+end);
		String classPosition=req.getParameter("classPosition");
		String classing=req.getParameter("classing");
		String classTimeday=req.getParameter("classTimeday");
		String classTimejs=req.getParameter("classTimejs");
		
		
		String info=kcName+"{第"+beg+"-"+end+"周},"+classPosition+","+classing;
		
		int b=Integer.parseInt(beg);
		int e=Integer.parseInt(end);
		
		try 
		{
			conn = DBUtils.createConn();
			for(int i=b;i<=e;i++)
			{
				String sql="update kcxx"+i+" set "+ShowkcxxUtil.isWeek_num(classTimeday.charAt(0))+" = '"+info+"'  where id= "+classTimejs;
				ps=DBUtils.getPs(conn, sql);
				ps.execute();
			}
			res.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"ok\" , \"message\":\"操作成功!\"}";
		
			res.getWriter().write(str);
		} 
		catch (Exception e1) {
			// TODO: handle exception
			res.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"fail\" , \"message\":\"操作失败!\"}";
			try {
				res.getWriter().write(str);
			} catch (IOException e11) {
				e11.printStackTrace();
			}
			e1.printStackTrace();
		}
		finally
		{
			DBUtils.close(conn, null, ps);
		}
		
	}

	private void getList_kcxx(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			HttpSession session=req.getSession();
			int xl=13;
			String xlweek=(String) session.getAttribute("Day");
			if("".equals(xlweek)||xlweek==null)
			{
				
				System.out.println("xlweek  "+xlweek);
				xl=this.udao.getWeekNum();
			}
			else
				xl=Integer.parseInt(xlweek);
//			int currentPage = Integer.parseInt(req.getParameter("page"));
//			int pageSize = Integer.parseInt(req.getParameter("rows"));
			List<Teacher_kcxx> ulist;
			System.out.println("day "+xl);
			ulist = this.udao.fingByPagination_kcxx(0, 0,xl);
			int total = this.udao.getTotalkcxx();
			res.setContentType("text/html;charset=utf-8");
			// {"total":10 , "rows":[{},{}]}
			String json = "{\"total\":" + total + " , \"rows\":"
					+ JSONArray.fromObject(ulist).toString() + "}";
			res.getWriter().write(json);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
