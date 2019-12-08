<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	
<title>学校管理平台</title>
<!-- 

<img src="images/jljs.png" />
<img src="images/login_logo.gif" />
 -->
<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div id="login">
		<div id="login_header">
			<h1>
				<a ><img src="images/stu_tea.png" style="margin-left:170px"/></a>
			</h1>
			
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form action="">
					<p>
						<label>学生端：</label>&nbsp;&nbsp;&nbsp;
						<a href="login_stu.jsp"><input type="button" value="欢迎进入" /></a>
					</p>
					<p>
						<label>教师端：</label>&nbsp;&nbsp;&nbsp;
						<a href="login_tea.jsp"><input type="button" value="欢迎进入" /></a>
					</p>
					
				</form>
					<div class="login_bar">
					</div>
			</div>
			<img src="images/nvwo.jpg" height="258" width="500"/>
		</div>
		<div id="login_footer">
			Copyright &copy; 江西理工大学信息工程学院 All Rights Reserved.
		</div>
        
	</div>
</body>
</html>