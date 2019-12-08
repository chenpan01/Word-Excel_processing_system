<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String islogin_out=request.getParameter("loginout");
	if("1".equals(islogin_out))
	{
		session.invalidate();
		System.out.println("invalidate");
	}
%>
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
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
<script type="text/javascript" 	src="js/stu_js.js"></script>
<script type="text/javascript">
window.history.forward();
</script>
<title>学生管理平台</title>

<link href="css/login.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div id="login">
		<div id="login_header">
			<h1 class="login_logo">
				<a href="#"><img src="images/stu_login.png" /></a>
			</h1>
			<div class="login_headerContent">
				<h2 class="login_title"><img src="images/stu_title.png" /></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form action="stu_ht.jsp" method="post" onSubmit="return check(this);">
					<p>${requestScope.remind } </p>
					<p>
						<label>学号：</label>
						<input id='num' type="text" size="20" name="Xuehao" class="login_input" />
					</p>
					<p>
						<label>密码：</label>
						<input id='pwd' type="password" size="20" name="Mm" class="login_input" />
						
					</p>
					<p style="margin-left:60px">
						<input class="sub" type="submit" value="提交"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="" type="reset" value="重置" />
					</p>
					
				</form>
					<div class="login_bar">
					</div>
			</div>
			<img src="images/xuesheng.jpg" height="258" width="620"/>
		</div>
		<div id="login_footer">
			Copyright &copy; 江西理工大学信息工程学院 All Rights Reserved.
		</div>
        
	</div>
</body>
</html>