package com.bjsxt.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.model.AttachmentSender;
import com.bjsxt.model.Updatexx;
import com.bjsxt.model.User;
import com.bjsxt.stumodel.Kspk;
import com.bjsxt.stumodel.Xscj;
import com.bjsxt.util.DBUtils;
import com.bjsxt.util.MainExcel;
import com.jspsmart.upload.SmartUpload;

public class Servler_xsdeal extends HttpServlet 
{
	private UserDao udao = new UserDaoImpl();
	public String Name="";
	MainExcel ME=new MainExcel();
	
	public Servler_xsdeal() {
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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String method = "",Name="";
		
		HttpSession session = request.getSession(); 
	    Name=(String)session.getAttribute("Name");
		
		method = request.getParameter("method");
		if ("upload".equals(method)) //getList_upxx
		{
			doupload(request, response);
		}
		else if("getList_xscj".equals(method))
		{
			getList_xscj(request, response);
		}
		else if("getList_kspk".equals(method))
		{
			getList_kspk(request, response);
		}
		else if("getList_upxx".equals(method))
		{
			getList_upxx(request, response);
		}//exe_update
	}


	private void getList_upxx(HttpServletRequest request,
			HttpServletResponse response) 
	{
		// TODO Auto-generated method stub
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		List<Updatexx> ulist;
		ulist = this.udao.getUpdatexx(currentPage, pageSize);
		int total = ulist.size();
		System.out.println("ulist "+ulist);
		response.setContentType("text/html;charset=utf-8");
		try 
		{
			// {"total":10 , "rows":[{},{}]}
			String json = "{\"total\":" + total + " , \"rows\":"
					+ JSONArray.fromObject(ulist).toString() + "}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	private void doupload(HttpServletRequest req,
			HttpServletResponse resp) 
	{
		String num = req.getParameter("num").trim();
		String name="";
		if ("1".equals(num)) {
			name = "xsxh";
		}
		if ("2".equals(num)) {
			name = "xscj";
		}
		if ("3".equals(num)) 
		{
			name = "kspk";
		}
		// TODO Auto-generated method stub
		String FilePath = "";
		//System.out.println("FilePath "+FilePath);
		FilePath = "F:/Biyesheji";
		File file = new File(FilePath);
		if (!file.exists()) 
		{
			file.mkdir();
		}
		String result = "上传成功！";
		SmartUpload su = new SmartUpload();
		try 
	   {
			// 初始化对象
			su.initialize(getServletConfig(), req, resp);
			// 设置上传文件大小
			su.setMaxFileSize(1024 * 1024 * 10);
			// 设置所有文件的大小
			su.setTotalMaxFileSize(1024 * 1024 * 100);
			// 设置允许上传文件类型
			su.setAllowedFilesList("xls,xlsx");
			// 设置禁止上传的文件类型
			su.setDeniedFilesList("txt,jpg,gif");
				// 上传文件
			su.upload();
			 for(int i =0; i < su.getFiles().getCount(); i++)
			 {
				 com.jspsmart.upload.File tempFile = su.getFiles().getFile(i);
				 tempFile.saveAs(FilePath+"/"+name+".xls");
			
			 }
		} catch (Exception e) {
			result = "上传失败！";
			e.printStackTrace();
		}
		try {
			upload(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void getList_xscj(HttpServletRequest request,
			HttpServletResponse response)
	{
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		List<Xscj> ulist;
		ulist = this.udao.getXscj(currentPage, pageSize);
		int total = ulist.size();
		System.out.println("ulist "+ulist);
		response.setContentType("text/html;charset=utf-8");
		try {
			// {"total":10 , "rows":[{},{}]}
			String json = "{\"total\":" + total + " , \"rows\":"
					+ JSONArray.fromObject(ulist).toString() + "}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	private void getList_kspk(HttpServletRequest request,
			HttpServletResponse response)
	{
		int currentPage = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		List<Kspk> ulist;
		ulist = this.udao.getKspk(currentPage, pageSize);
		int total = ulist.size();
		response.setContentType("text/html;charset=utf-8");
		try {
			// {"total":10 , "rows":[{},{}]}
			String json = "{\"total\":" + total + " , \"rows\":"
					+ JSONArray.fromObject(ulist).toString() + "}";
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	private void upload(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		// C:\Users\Administrator\Desktop\毕业设计\毕业设计excel文件
		//System.out.println(" num " + num + " num的长度 " + num.length());
		String filePath = "";
		String num = "", name = "";
		num = req.getParameter("num").trim();
		if ("1".equals(num)) {
			filePath = "E:/Biyesheji/xsxh.xls";// E:\Biyesheji
			name = "xsxh";
			ME.readExcel_hm(filePath, name, 0);
		}
		if ("2".equals(num)) {
			filePath = "E:/Biyesheji/xscj.xls";
			name = "xscj";
			String Name=(String) req.getSession().getAttribute("Name");
			ME.readExcel_xscj(filePath, Name);
		}
		if ("3".equals(num)) 
		{
			filePath = "E:/Biyesheji/kspk.xls";
			name = "kspk";
			String Name=(String) req.getSession().getAttribute("Name");
			ME.readExcel_kspk(filePath, Name);
		}
		String FilePath = "E:/Biyesheji";
		File file = new File(FilePath);
		if (!file.exists()) {
			file.mkdir();
		}

		SmartUpload su = new SmartUpload();
		// ((Object) su).setCharset("UTF-8");
		// 初始化对象
		su.initialize(getServletConfig(), req, resp);
		// 设置上传文件大小
		su.setMaxFileSize(1024 * 1024 * 10);
		// 设置所有文件的大小
		su.setTotalMaxFileSize(1024 * 1024 * 100);
		// 设置允许上传文件类型
		su.setAllowedFilesList("xls");
		String result = "上传成功！";
		// 设置禁止上传的文件类型
		try {
			su.setDeniedFilesList("txt,jpg,gif");
			// 上传文件
			su.upload();
		} catch (Exception e) {
			result = "上传失败！";
			e.printStackTrace();
		}
		req.getRequestDispatcher("student/stu_ht.jsp").forward(req, resp);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}

//private void exe_update(HttpServletRequest request,
//		HttpServletResponse response) 
//{
//	Connection conn=null;
//	PreparedStatement ps=null;
//	ResultSet rs=null;
//	int id=1;
//	String host = "smtp.163.com";
//	String content="";
//	String accountName = "jxlgcp";
//	String password = "683954997adef";
//	String[] ids = request.getParameter("ids").split(",");
//	for (int i = 0; i < ids.length; i++) {
//		id=Integer.parseInt(ids[i]);
//	}
//	try {
//		conn = DBUtils.createConn();
//		String sql = " select * from updatexx where id="+id;
//		ps = DBUtils.getPs(conn, sql);
//		rs = ps.executeQuery();
//		while (rs.next()) {
//			content=rs.getString("content");
//		}
//	} catch (Exception e) {
//		// TODO: handle exception
//		e.printStackTrace();
//	}
//	finally
//	{
//		DBUtils.close(conn, rs, ps);
//	}
//	AttachmentSender sender = new AttachmentSender(host,accountName,password,content,"调课通知","2562940854@qq.com");
//	sender.send();
//}