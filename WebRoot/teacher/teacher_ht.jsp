<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import=" com.bjsxt.util.*" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String Name="",Zhigh="",flag="";
 %>
<%
 Name=(String)session.getAttribute("Name");
if("".equals(Name)||Name==null)
{
	Zhigh=request.getParameter("Zhigh");
	session.setAttribute("Zhigh", Zhigh);
	conn=DBUtils.createConn();
	System.out.println("Zhigh "+Zhigh);
	
	ps=DBUtils.getPs(conn, "select * from easyui.jsgh where id="+Zhigh);
	rs=ps.executeQuery();
	while(rs.next()){
		Name=rs.getString("name");
	}
	session.setAttribute("Name", Name);
	DBUtils.close(conn, rs, ps);
}

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP '007_layout.jsp' starting page</title>

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
<!-- 
	$('#btn1').click(
			function() {
				//if ($('#myform').form('validate')) {
					alert(asdfsdf);
					$.ajax({
						type : 'post',
						url : 'UserServlet?method=upload',
					});
				//}
			});
 -->
<script type="text/javascript">
		var value="";
		window.onload = function(){
	  		doSomething();
		};
		function doSomething() {
		var fruit = document.getElementById("rtl");
		fruit.onchange = function() {
			var option = document.getElementsByTagName("option");
			value = option[fruit.selectedIndex].value;
			console.log(option[fruit.selectedIndex]);
		}
	}
		function submitit() {
		
			document.getElementById('formid').action = "UserServlet?method=upload&num=" + value;
			document.getElementById("formid").submit();
		}
	$(function() {
		$('a[title]')
				.click(
						function() {
							var src = $(this).attr('title');
							var title = $(this).html();
							if ($('#tt').tabs('exists', title)) {
								$('#tt').tabs('select', title);
							} else {
								$('#tt')
										.tabs(
												'add',
												{
													title : title,
													content : '<iframe frameborder=0 style=width:100%;height:100% src='
															+ src
															+ ' ></iframe>',
													closable : true
												});
							}

						});

	});
</script>
<link rel="stylesheet" href="css/common.css" type="text/css"></link>

</head>
<!-- 
192.168.1.116
String url="http://180.84.33.181:8080/AndroidJSP/Login"
 -->
<body>
	<div id="cc" class="easyui-layout" fit=true
		style="width:100%;height:100%;"><!-- ?method=upload -->
		<div region="north" title="导入教师信息" split="false" style="height:100px;">
		<p>欢迎您！<%=Name%>老师&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="login_tea.jsp?loginout=1">注销</a></p>
			<form action="" id="formid" method="post" enctype="multipart/form-data">
				<select name="text" id="rtl" >
					<option value="0" selected="selected">==请选择==</option>
					<option value="1">教师监考信息</option>
					<option value="2">教师课程信息</option>
					<option value="3">教师工号</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上传文件：
				<input type="file" name="filename" size="45"> 
				<input type="button" value="提交" onClick="submitit();" />
			</form>
		</div>
		<div region="west" iconCls="icon-ok" split="true" title="教师信息"
			style="width:200px;">

			<div id="aa" class="easyui-tree" animate="true" dnd="true" fit=true>
				<div title="用户管理" style="overflow:auto;padding:10px;">

					<ul id="tt1" class="easyui-tree" animate="true" dnd="true">
						<li><span>教师信息菜单</span>
							<ul>
								<li><a title="teacher/Showjkxx.jsp">教师监考信息</a></li>
								<li><a title="teacher/Showkcxx.jsp">教师课程信息</a>
								<li><a title="teacher/Showupdate.jsp">修改记录</a>
								</li>
							</ul></li>
					</ul>
				</div>
			</div>

		</div>
		<div region="center" title="主界面" style="padding:5px;">
			<div id="tt" class="easyui-tabs" fit=true>
				<div title="主界面""><img src="images/jljs.png"></div>
						
			</div>
		</div>
	</div>

</body>
</html>
