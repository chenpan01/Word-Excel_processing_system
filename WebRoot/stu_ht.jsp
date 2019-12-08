<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="GBK" contentType="text/html; charset=utf-8"%>
<%@ page import=" com.bjsxt.util.*" %>

<%
	request.setCharacterEncoding("utf-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%!
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String Pwd="";
	String Xuehao="";
	String sql="";
	String Name="";
 %>

<%
	
	session.removeAttribute("Name");

	Xuehao=request.getParameter("Xuehao");
	
	Pwd=request.getParameter("Mm");
	conn=DBUtils.createConn();
	sql="select * from easyui.xsxh where id= '"+Xuehao+"' and pwd= '"+Pwd+"'";
	System.out.println(sql);
	
	ps=DBUtils.getPs(conn, sql); // 判断密码和学号是否有误
	rs=ps.executeQuery();
	while(rs.next()){
		Name=rs.getString("name");
	} 
	
	if("".equals(Name)||Name==null) //密码和ID是否有误
	{
		String remind="学号或密码错误";
		request.setAttribute("remind", remind);
		
		request.getRequestDispatcher("login_stu.jsp").forward(request, response);
		//response.sendRedirect("../login_stu.jsp");
		/* 
		String site = new String("http://localhost:8080/EU/student/login_stu.jsp");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site); */
	} 

	session.setAttribute("Name", Name);
	DBUtils.close(conn, rs, ps);

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学生页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/icon.css" />
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/stu_js.js"></script>
<script type="text/javascript" src="stu_js/gettablevalue.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
var value="";
window.onload = function()
{
	  	doSomething();
};
function doSomething() 
{
		
		var fruit = document.getElementById("rtl");
		fruit.onchange = function()
		 {
			var option = document.getElementsByTagName("option");
			value = option[fruit.selectedIndex].value;
			console.log(option[fruit.selectedIndex]);
		}
}
function submitit() {
	document.getElementById('formid').action = "Servler_xsdeal?method=upload&num=" + value;
	document.getElementById("formid").submit();
}
</script>
<link rel="stylesheet" href="css/common.css" type="text/css"></link>

</head>

<body>
	<div id="cc" class="easyui-layout" fit=true
		style="width:100%;height:100%;">
		<div region="north" title="导入学生信息" split="false" style="height:70px;">
		<p>欢迎你！<%=Name%>同学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="login_stu.jsp?loginout=1">退出</a></p>
			<form action="" id="formid" method="post" enctype="multipart/form-data">
				<select name="text" id="rtl" >
					<option value="0" selected="selected">==选择文件类型==</option>
					<option value="1">学生学号</option>
					<option value="2">学生成绩信息</option>
					<option value="3">扑考考试信息</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上传文件：
				<input type="file" name="filename" size="45"> 
				<input type="button" value="提交" onClick="submitit();" />
			</form>
		</div>
		<div region="west"  split="true" title="学生信息" style="width:200px;height:500px">
			<div id="aa" class="easyui-tree" animate=true dnd="true" >
				<div title="用户管理" style="padding:10px;">
					<ul id="tt1" class="easyui-tree" animate="true" dnd="true">
						<li state="closed"><span>学生信息</span>
							<ul>
								<li><a title="student/Showxscj.jsp">学生期末考试成绩</a></li>
								<li><a title="student/Showkspk.jsp">学生扑考安排信息</a></li>
								<li><a title="student/info.jsp">学生扑考安排信息</a></li>
							</ul>
						</li>
					</ul>
					<!--  <ul id="tt2" class="easyui-tree" animate="true" dnd="true">
						<li state="closed"><span>学生相册</span>
							<ul>
								<li><a title="">上传相册</a></li>
								<li><a title="">学生相册</a></li>
							</ul>
						</li>
					</ul>-->
					<!--  <ul id="tt3" class="easyui-tree" animate="true" dnd="true">
						<li state="closed"><span>文件助手</span>
							<ul>
								<li><a title="">word转成pdf文件</a></li>
								<li><a title="">excel转成pdf文件</a></li>
								<li><a title="">ppt转成pdf文件</a></li>
								<li><a title="">pdf转成word文件</a></li>
							</ul>
						</li>
					</ul>-->
					<ul id="tt4" class="easyui-tree" animate="true" dnd="true">
						<li state="closed"><span>word文档填写助手</span>
							<ul>
								<li><a title="student/doc_test.jsp">大学生励志奖学金申请表</a></li>
							</ul>
						</li>
					</ul>
					<ul id="tt5" class="easyui-tree" animate="true" dnd="true">
						<li state="closed"><span>邮件助手</span>
							<ul>
								<li><a title="jsp_stu/mail.jsp" >发邮件界面</a></li>
							</ul>
						</li>
					</ul>
				
				</div>
			</div>

		</div>
		<div region="center" title="主界面">
			<div id="tt" class="easyui-tabs" fit=false border="false">
				<div title="主界面"><img src="images/jlxs.png"></div>
				
			</div>
		</div>
	</div>

</body>
</html>
