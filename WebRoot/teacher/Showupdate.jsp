<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import=" com.bjsxt.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Showupdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript"
	src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" type="text/css"
		href="js/jquery-easyui-1.2.6/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css"
		href="js/jquery-easyui-1.2.6/themes/icon.css" />
	<script type="text/javascript"
		src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript"	src="js/tea_update.js"></script>
	<script type="text/javascript">
	
	</script>
  </head>
  
  <body>
	<div id="lay" class="easyui-layout" style="width: 100%;height:100%">
		<div region="center">
			<table id="xuser"></table>
		</div>
	</div>
  </body>
</html>
