<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'shiyan.jsp' starting page</title>

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
<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/commons.js"></script>
<script type="text/javascript">
		var value;
		window.onload = function(){
	  		doSomething();
		};
		function doSomething() {
		//alert("sdfsdf");
		var fruit = document.getElementById("rtl");
		fruit.onchange = function() {
			var option = document.getElementsByTagName("option");
			value = option[fruit.selectedIndex].value;
			console.log(option[fruit.selectedIndex]);
		}
	}
		function submitit() {
		
			document.getElementById('formid').action = "UserServlet?method=upload&num="+value;
			document.getElementById("formid").submit();
		}
</script>
</head>

<body>
		<form action="" id="formid" method="post" enctype="multipart/form-data">
				<select name="num" id="rtl" >
					<option value="0"></option>
					<option value="1">导入教师监考信息</option>
					<option value="2">导入教师课程信息</option>
					<option value="3">导入教师个人信息</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上传文件：
				<input type="file" name="filename" size="45"> 
				<input type="button" value="提交" onClick="submitit();" />
			</form>
	
</body>
</html>

<!-- 

<span>
	<form action="Shiyan" id="formid2" method="post" >
		
	</form>
	<form action="" id="formid1" method="post" enctype="multipart/form-data">
		上传域 <input type="file" name="myFile" /> 
		<input type="button" value="提交" onClick="javascript:submitit();">
	</form>
</span>
		<select name="text" id="rtl">
			<option value="1">导入教师监考信息</option>
			<option value="2">导入教师课程信息</option>
			<option value="3">导入教师个人信息</option>
		</select> 
 -->