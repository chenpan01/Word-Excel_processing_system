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
	
	ps=DBUtils.getPs(conn, sql); // �ж������ѧ���Ƿ�����
	rs=ps.executeQuery();
	while(rs.next()){
		Name=rs.getString("name");
	} 
	
	if("".equals(Name)||Name==null) //�����ID�Ƿ�����
	{
		String remind="ѧ�Ż��������";
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

<title>ѧ��ҳ��</title>

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
		<div region="north" title="����ѧ����Ϣ" split="false" style="height:70px;">
		<p>��ӭ�㣡<%=Name%>ͬѧ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="login_stu.jsp?loginout=1">�˳�</a></p>
			<form action="" id="formid" method="post" enctype="multipart/form-data">
				<select name="text" id="rtl" >
					<option value="0" selected="selected">==ѡ���ļ�����==</option>
					<option value="1">ѧ��ѧ��</option>
					<option value="2">ѧ���ɼ���Ϣ</option>
					<option value="3">�˿�������Ϣ</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�ϴ��ļ���
				<input type="file" name="filename" size="45"> 
				<input type="button" value="�ύ" onClick="submitit();" />
			</form>
		</div>
		<div region="west"  split="true" title="ѧ����Ϣ" style="width:200px;height:500px">
			<div id="aa" class="easyui-tree" animate=true dnd="true" >
				<div title="�û�����" style="padding:10px;">
					<ul id="tt1" class="easyui-tree" animate="true" dnd="true">
						<li state="closed"><span>ѧ����Ϣ</span>
							<ul>
								<li><a title="student/Showxscj.jsp">ѧ����ĩ���Գɼ�</a></li>
								<li><a title="student/Showkspk.jsp">ѧ���˿�������Ϣ</a></li>
								<li><a title="student/info.jsp">ѧ���˿�������Ϣ</a></li>
							</ul>
						</li>
					</ul>
					<!--  <ul id="tt2" class="easyui-tree" animate="true" dnd="true">
						<li state="closed"><span>ѧ�����</span>
							<ul>
								<li><a title="">�ϴ����</a></li>
								<li><a title="">ѧ�����</a></li>
							</ul>
						</li>
					</ul>-->
					<!--  <ul id="tt3" class="easyui-tree" animate="true" dnd="true">
						<li state="closed"><span>�ļ�����</span>
							<ul>
								<li><a title="">wordת��pdf�ļ�</a></li>
								<li><a title="">excelת��pdf�ļ�</a></li>
								<li><a title="">pptת��pdf�ļ�</a></li>
								<li><a title="">pdfת��word�ļ�</a></li>
							</ul>
						</li>
					</ul>-->
					<ul id="tt4" class="easyui-tree" animate="true" dnd="true">
						<li state="closed"><span>word�ĵ���д����</span>
							<ul>
								<li><a title="student/doc_test.jsp">��ѧ����־��ѧ�������</a></li>
							</ul>
						</li>
					</ul>
					<ul id="tt5" class="easyui-tree" animate="true" dnd="true">
						<li state="closed"><span>�ʼ�����</span>
							<ul>
								<li><a title="jsp_stu/mail.jsp" >���ʼ�����</a></li>
							</ul>
						</li>
					</ul>
				
				</div>
			</div>

		</div>
		<div region="center" title="������">
			<div id="tt" class="easyui-tabs" fit=false border="false">
				<div title="������"><img src="images/jlxs.png"></div>
				
			</div>
		</div>
	</div>

</body>
</html>
