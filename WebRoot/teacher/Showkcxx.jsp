<%@ page language="java"
	import="java.util.*,java.sql.*,com.bjsxt.util.*,com.bjsxt.dao.impl.*,com.bjsxt.dao.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String totalxx = "", tem = "";
	String option[] = new String[40];
	String value[]=new String[40];
	String weekNow[]={"","第一周","第二周","第三周","第四周","第五周","第六周","第七周",
	"第八周","第九周","第十周","第十一周","第十二周","第十三周","第十四周","第十五周","第十六周","第十七周","第十八周"};
%>
<%
	UserDao udao = new UserDaoImpl();
	int week=0;
	String tday="";
	if(session.getAttribute("Day")==null||"".equals(session.getAttribute("Day")))
		week=udao.getWeekNum();
	else
		week=Integer.parseInt(session.getAttribute("Day").toString());
	session.setAttribute("week", week+"");
	conn = DBUtils.createConn();
	ps = DBUtils.getPs(conn,"select week1,week2,week3,week4,week5,week6,week7 from easyui.kcxx;");
	rs = ps.executeQuery();
	int j = 0;
	for (int jj = 1; jj < 6 && rs.next(); jj++) 
	{
		String jt=jj+"";
		for (int i = 1; i < 8; i++) 
		{
			String it=i+"";
			tem = rs.getString(i);
			if (!"".equals(tem)) 
			{
				value[j]=tem;
				option[j] = ""+jt + ""+it + tem;
// 				System.out.print("option[j]"+option[j]);
				j++;
			}
		}
	}
	DBUtils.close(conn, rs, ps);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP '008_datagrid.jsp' starting page</title>

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
<script  type="text/javascript"src="js/Showkcxx.js"></script>
<script  type="text/javascript" src="js/kcxx_add4.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<div id="DIV_toolbar" Style="margin:0px; padding:5px">
     	&nbsp;&nbsp;&nbsp; 
     	当前周: <select id="typeId" name="typeId">
     	  		<% 
     	  			for(int ii=1;ii<19;ii++)
     	  			{
     	  			if(week==ii){
     	  		%>
	            <option value="<%=ii %>" selected="selected"><%=weekNow[ii] %></option>  
              <%}else{ %>	
                      
	            <option value="<%=ii %>"><%=weekNow[ii] %></option>  
				<%}} %>                      
        	</select>  
     
   	</div>  
	<div id="lay" class="easyui-layout" style="width: 100%;height:100%">
		<div region="center">
			<table id="t_user"></table>
		</div>
	</div>
	<form id="xlform" action="" method="post">
		<input id="hidden" type="text" name="xlweek"/>		
	</form>
<!-- 	http://localhost:8080/EU/teacher/Showkcxx.jsp -->
	<div id="kcxx_update" title="修改信息" modal=true draggable=false class="easyui-dialog" closed=true style="width:600px">
		<form id="myform" action="" method="post">
			<input type="hidden" name="id" value="" />
			<table>
				<tr>
					<td >课程名称:</td>
					<td><select name="kcupdate" id="kcupdate" >
							<option value="-1" selected="selected">==先选择课程名称==</option>
							<%
								for (int i = 0; option[i] != null && !"".equals(option[i]); i++) 
								{
							%>
									<option value="<%=option[i]%>"><%=value[i]%></option>
							<%
								}
							%>
					</select></td>
				</tr> 
				<tr>
					 <td> 
						上课周数：
					 </td>
					  <td> 
						<select name="class_week" id="class_week">
								<option value="" selected="selected"></option>
								<option value="1">第一周</option>
								<option value="2">第二周</option>
								<option value="3">第三周</option>
								<option value="4">第四周</option>
								<option value="5">第五周</option>
								<option value="6">第六周</option>
								<option value="7">第七周</option>
								<option value="8">第八周</option>
								<option value="9">第九周</option>
								<option value="10">第十周</option>
								<option value="11">第十一周</option>
								<option value="12">第十二周</option>
								<option value="13">第十三周</option>
								<option value="14">第十四周</option>
								<option value="15">第十五周</option>
								<option value="16">第十六周</option>
						</select>
					 </td>
				</tr>
<!-- 				<tr> -->
<!-- 					<td>开始周:</td> -->
<!-- 					<td><input type="text" id="beg" name="beg" size="5"/></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>结束周:</td> -->
<!-- 					<td><input type="text" id="end" name="end" size="5"/></td> -->
<!-- 				</tr> -->
				<tr>
					<td>上课地点:</td>
					<td><input type="text" id="classPosition" name="classPosition"	size="15"/></td>
				</tr>
				<tr>
					<td>上课班级:</td>
					<td><input type="text" id="classbj" name="classbj" size="15"/></td>
				</tr>
					<tr>
					<td>上课时间:</td>
					<td>
						<select name="updateTimeday" id="updateTimeday">
								<option value="0" selected="selected"></option>
								<option value="周一">周一</option>
								<option value="周二">周二</option>
								<option value="周三">周三</option>
								<option value="周四">周四</option>
								<option value="周五">周五</option>
								<option value="周六">周六</option>
								<option value="周日">周日</option>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<select name="updateTimejs" id="updateTimejs">
								<option value="0" selected="selected"></option>
								<option value="1,2节课">1,2节课</option>
								<option value="3,4节课">3,4节课</option>
								<option value="5,6节课">5,6节课</option>
								<option value="7,8节课">7,8节课</option>
								<option value="9,10节课">9,10节课</option>
						</select>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2"><a id="btn1" class="easyui-linkbutton">确定</a>
					<a id="btn2" class="easyui-linkbutton">关闭</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="kcxx_add" title="新增用户" modal=true draggable=false	class="easyui-dialog" closed=true style="width:300px;">
		<form id="myformadd" action="" method="post">
			<input type="hidden" name="id" value="" />
			<table>
				<tr>
					<td>课程名称:</td>
					<td><input type="text" name="kcName"
						class="easyui-validatebox" required=true
						validType="midLength[2,20]" missingMessage="课程名称必填!"
						invalidMessage="课程名称为2到20个字符" value="" />
					</td>
				</tr>
				<tr>
					<td>开始周:</td>
					<td>
						 <select name="beg" id="beg">
								<option value="0" selected="selected">==请选择==</option>
								<option value="1">第一周</option>
								<option value="2">第二周</option>
								<option value="3">第三周</option>
								<option value="4">第四周</option>
								<option value="5">第五周</option>
								<option value="6">第六周</option>
								<option value="7">第七周</option>
								<option value="8">第八周</option>
								<option value="9">第九周</option>
								<option value="10">第十周</option>
								<option value="11">第十一周</option>
								<option value="12">第十二周</option>
								<option value="13">第十三周</option>
								<option value="14">第十四周</option>
								<option value="15">第十五周</option>
								<option value="16">第十六周</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>结束周:</td>
					<td><select name="end" id="end">
							<option value="0" selected="selected">==请选择==</option>
							<option value="1">第一周</option>
								<option value="2">第二周</option>
								<option value="3">第三周</option>
								<option value="4">第四周</option>
								<option value="5">第五周</option>
								<option value="6">第六周</option>
								<option value="7">第七周</option>
								<option value="8">第八周</option>
								<option value="9">第九周</option>
								<option value="10">第十周</option>
								<option value="11">第十一周</option>
								<option value="12">第十二周</option>
								<option value="13">第十三周</option>
								<option value="14">第十四周</option>
								<option value="15">第十五周</option>
								<option value="16">第十六周</option>
					</select></td>
				</tr>
				<tr>
					<td>上课地点:</td>
					<td><input type="text" name="classPosition"
						class="easyui-validatebox" required=true
						validType="midLength[4,20]" missingMessage="上课地点必填!"
						invalidMessage="上课地点为5到20个字符" value="" /></td>
				</tr>
				<tr>
					<td>上课班级:</td>
					<td><input id="classNum" type="text" name="classing"
						validType="midLength[4,20]" missingMessage="上课班级必填!"
						invalidMessage="上课班级为4到20个字符之间!" value="" />
					</td>
				</tr>
				<tr>
					<td>上课时间:</td>
					<td>
						<select name="classTimeday" id="classTime">
								<option value="0" selected="selected">==请选择==</option>
								<option value="1">周一</option>
								<option value="2">周二</option>
								<option value="3">周三</option>
								<option value="4">周四</option>
								<option value="5">周五</option>
								<option value="6">周六</option>
								<option value="7">周日</option>
						</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<select name="classTimejs" id="classTime">
								<option value="0" selected="selected">==请选择==</option>
								<option value="1">1,2节</option>
								<option value="2">3,4节</option>
								<option value="3">5,6节</option>
								<option value="4">7,8节</option>
								<option value="5">9,10节</option>
						</select>
					</td>
				</tr>
				<tr align="center">
					<td colspan="2"><a id="btn3" class="easyui-linkbutton">确定</a>
						<a id="btn4" class="easyui-linkbutton">关闭</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
