package com.bjsxt.servlet;

import java.io.*;
import java.util.*;
import java.sql.*;
import com.bjsxt.dao.*;
import com.bjsxt.dao.impl.*;
import com.bjsxt.model.*;
import com.bjsxt.util.*;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

import net.sf.json.*;

public class UserServlet extends HttpServlet {

	private UserDao udao = new UserDaoImpl();
	public String Name="";
	MainExcel ME=new MainExcel();
    Properties props = new Properties();
	public UserServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String method = "";
		
		HttpSession session = request.getSession(); 
	    Name=(String)session.getAttribute("Name");
		
		method = request.getParameter("method");
		
		//System.out.println(method);
		if ("upload".equals(method)) 
		{
			doupload(request, response);
			//upload(request, response);
		} else if ("doWord".equals(method)) {
			doWord(request, response);
		} else if ("domail".equals(method)) {
			System.out.println("domail");
			try {
				domail(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("type_t".equals(method)) {
			type_t(request, response);
		}else if ("save".equals(method)) {
			save(request, response);
		} 
		else if ("getList_jkxx".equals(method))
		{
			//System.out.println("getList  ");
			getList_jkxx(request, response);
		} 
	
		else if ("update".equals(method)) {
			update(request, response);
		} else if ("delete".equals(method)) {
			delete(request, response);
		} else if ("searchName".equals(method)) {
			searchName(request, response);
		}

	}
	private void doupload(HttpServletRequest req,
			HttpServletResponse resp) 
	{
		String num = req.getParameter("num").trim();
		String name="";
		if ("1".equals(num)) {
			name = "jkxx";
		}
		if ("2".equals(num)) {
			name = "kcxx";
		}
		if ("3".equals(num)) 
		{
			name = "jsgh";
		}
		String FilePath = "";
		//System.out.println("FilePath "+FilePath);
		FilePath = "F:/Biyesheji";
		File file = new File(FilePath);
		if (!file.exists()) {
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
			su.setAllowedFilesList("xls");
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
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void domail(HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String content = req.getParameter("content");
		String rec = req.getParameter("rec");
		//System.out.println("rec" + rec);
		String sub = req.getParameter("sub");
		System.out.println(" domail " + content + " " + sub + " " + rec);
		JavaMail.sendmail(content, sub, rec);
	}

	private void getList_jkxx(HttpServletRequest request, HttpServletResponse res) {
		try {
			int currentPage = Integer.parseInt(request.getParameter("page"));
			int pageSize = Integer.parseInt(request.getParameter("rows"));
			String KsTime = request.getParameter("KsTime") == null ? ""
					: request.getParameter("KsTime");
			String ClassName = request.getParameter("ClassName") == null ? ""
					: request.getParameter("ClassName");
			String Position = request.getParameter("Position") == null ? ""
					: request.getParameter("Position");
			String order = request.getParameter("order") == null ? "" : request
					.getParameter("order"); // 排序的方式
			String sort = request.getParameter("sort") == null ? "" : request
					.getParameter("sort"); // 排序的字段
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("KsTime", KsTime);
			m.put("ClassName", ClassName);
			m.put("Position", Position);
			m.put("order", order);
			m.put("sort", sort);
			List<User> ulist;
			ulist = this.udao.findByPagination(currentPage, pageSize, m);
			int total = this.udao.getTotal(m);
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

	private void save(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			String KsTime = request.getParameter("ksTime");
			String KcName = request.getParameter("kcName");
			String ClassName = request.getParameter("className");
			String ClassNum = request.getParameter("classNum");
			String Similar = request.getParameter("similar");
			String Position = request.getParameter("position");
			String Posi_num = request.getParameter("posi_num");
			String Supervisor = request.getParameter("supervisor");
			String jk1 = request.getParameter("jk1");
			String jk2 = request.getParameter("jk2");
			String jk3 = request.getParameter("jk3");
			String jk4 = request.getParameter("jk4");
			String Tea_teacher = request.getParameter("tea_teacher");
			String kh_Style = request.getParameter("kh_Style");
			String Note = request.getParameter("note");
			
			User user=new User();
			user.setClassName(ClassName);
			user.setKsTime(KsTime);
			user.setKcName(KcName);
			user.setClassNum(ClassNum);
			user.setSimilar(Similar);
			user.setPosition(Position);
			user.setPosi_num(Posi_num);
			user.setSupervisor(Supervisor);
			user.setJk1(jk1);
			user.setJk2(jk2);
			user.setJk3(jk3);
			user.setJk4(jk4);
			user.setTea_teacher(Tea_teacher);
			user.setKh_Style(kh_Style);
			user.setNote(Note);

			this.udao.save(user);

			response.setContentType("text/html;charset=utf-8");
			// {"status":"ok" , "message":"操作成功"}
			String str = "{\"status\":\"ok\" , \"message\":\"操作成功!\"}";
			response.getWriter().write(str);

		} catch (Exception e) {
			response.setContentType("text/html;charset=utf-8");
			// {"status":"fail" , "message":"操作失败!"}
			String str = "{\"status\":\"fail\" , \"message\":\"操作失败!\"}";
			try {
				response.getWriter().write(str);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}
	private void upload(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		// C:\Users\Administrator\Desktop\毕业设计\毕业设计excel文件
		//System.out.println(" num " + num + " num的长度 " + num.length());
		
		String num = "", name = "",filePath=DBUtils.getfath();
		num = req.getParameter("num").trim();
		if ("1".equals(num)) {
			filePath = filePath+"/jkxx.xls";// E:\Biyesheji
			name = "jkxx";
			ME.readExcel_jkxx(filePath, Name, 0);
		}
		if ("2".equals(num)) {
			filePath = filePath+"/kcxx.xls";
			name = "kcxx";
			String Zhigh=(String) req.getSession().getAttribute("Zhigh");
			System.out.println("Zhigh "+Zhigh);
			//Session s=req.getSession();
			ME.readExcel_kcxx(filePath, Zhigh, 0);
		}
		if ("3".equals(num)) 
		{
			filePath = filePath+"/jsgh.xls";
			name = "jsgh";
			ME.readExcel_hm(filePath, name, 0);
		}
		

		
		req.getRequestDispatcher("teacher/teacher_ht.jsp").forward(req, resp);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			User user = this.udao.findById(id);
			
			String KsTime = request.getParameter("ksTime");
			String KcName = request.getParameter("kcName");
			String ClassName = request.getParameter("className");
			String ClassNum = request.getParameter("classNum");
			String Similar = request.getParameter("similar");
			String Position = request.getParameter("position");
			String Posi_num = request.getParameter("posi_num");
			String Supervisor = request.getParameter("supervisor");
			String jk1 = request.getParameter("jk1");
			String jk2 = request.getParameter("jk2");
			String jk3 = request.getParameter("jk3");
			String jk4 = request.getParameter("jk4");
			String Tea_teacher = request.getParameter("tea_teacher");
			String kh_Style = request.getParameter("kh_Style");
			String Note = request.getParameter("note");
			
			user.setClassName(ClassName);
			user.setKsTime(KsTime);
			user.setKcName(KcName);
			user.setClassNum(ClassNum);
			user.setSimilar(Similar);
			user.setPosition(Position);
			user.setPosi_num(Posi_num);
			user.setSupervisor(Supervisor);
			user.setJk1(jk1);
			user.setJk2(jk2);
			user.setJk3(jk3);
			user.setJk4(jk4);
			user.setTea_teacher(Tea_teacher);
			user.setKh_Style(kh_Style);
			user.setNote(Note);

			this.udao.update(user);

			response.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"ok\" , \"message\":\"操作成功!\"}";
			response.getWriter().write(str);

		} catch (Exception e) 
		{
			response.setContentType("text/html;charset=utf-8");
			String str = "{\"status\":\"fail\" , \"message\":\"操作失败!\"}";
			try {
				response.getWriter().write(str);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	private void doWord(HttpServletRequest req, HttpServletResponse res) 
	{
		try 
		{
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Enumeration<String> paramNames = req.getParameterNames();//ApplyReason TuijianReason  SchoolSug
		// 通过循环将表单参数放入键值对映射中
		while(paramNames.hasMoreElements()) 
		{
			String key = paramNames.nextElement();
			String value = req.getParameter(key);
			map.put(key, value);
		}
		System.out.println("map  ");
		WordUtils test = new WordUtils();
		try {
			test.exportMillCertificateWord(req, res, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
//			if("ApplyReason".equals(value))
//			{
//				int index=value.indexOf('<');
//				value=value.substring(0,index);
//			}
//			if("TuijianReason".equals(value))
//			{
//				int index=value.indexOf('<');
//				value=value.substring(0,index);
//			}
//			if("SchoolSug".equals(value))
//			{
//				int index=value.indexOf('<');
//				value=value.substring(0,index);
//			}



	private void type_t(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	private void searchName(HttpServletRequest request,
			HttpServletResponse response) {
	
	}

	

	private void delete(HttpServletRequest request, HttpServletResponse response) {

		try {
			String[] ids = request.getParameter("ids").split(",");
			for (int i = 0; i < ids.length; i++) {
				this.udao.delete(Integer.parseInt(ids[i]));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}




	/**
	 * 
	 * @param request
	 * @param response
	 */


	public void init() throws ServletException {
		// Put your code here
	}

}

//String varname[] = {"School", "Yuanxi", "StudyNum", "Name", "Sex",
//"birthday", "Public", "National", "Begintime", "Profession",
//"Xuezhi", "Telephone", "Id_number", "Rank", "Isfou",
//"class_num", "RankNum", "class_jige", "HuJi", "FamilyNum",
//"GetOne", "GetTwo", "Getfrom", "Station", "Code", "DateOne",
//"PrizeOne", "UnitOne", "DateTwo", "PrizeTwo", "UnitTwo",
//"DateThree", "PrizeThree", "UnitThree", "ApplyReason" };// 35
//String var_value[] = new String[35];
//for (int i = 0; i < 35; i++) {
//String s="";
//s=request.getParameter(varname[i]);
//var_value[i] = request.getParameter(s);
//}
//Map<String, Object> dataMap = new HashMap<String, Object>();
//for (int i = 0; i < var_value.length; i++) {
//dataMap.put(varname[i], var_value[i]);
//}
// WordUtils
