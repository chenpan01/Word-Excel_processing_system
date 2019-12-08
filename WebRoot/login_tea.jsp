<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String islogin_out=request.getParameter("loginout");
	if("1".equals(islogin_out))
		request.getSession().invalidate();
%>
<!-- login_tea页面的前端布局 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.2.6/themes/icon.css" />
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
<title>教师管理平台</title>

<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="#"><img src="images/login_logo01.png" /></a>
			</h1>
			<div class="login_headerContent">
				<h2 class="login_title"><img src="images/login_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form action="teacher/teacher_ht.jsp">
					
					<p>
						<label>职工号：</label>
						<input name="Zhigh" type="text" size="20" class="login_input" />
					</p>
					<p>
						<label>密码：</label>
						<input type="password" size="20" class="login_input" />
					</p>
					<p style="margin-left:60px">
						<input class="sub" type="submit" value="提交" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="" type="reset" value="重置" />
					</p>
				</form>
					<div class="login_bar">
					</div>
			</div>
			<div class="login_banner"><img src="images/login_banner.jpg" /></div>
		</div>
		<div id="login_footer">
			Copyright &copy; 江西理工大学信息工程学院 All Rights Reserved.
		</div>
        
	</div>
</body>
</html>