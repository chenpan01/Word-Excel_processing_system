<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.2.6/themes/icon.css" />
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/jquery-easyui-1.2.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="js/commons.js"></script>
	<script type="text/javascript" src="js/jkxxadd4.js"></script>
	<script type="text/javascript">
			

	</script>
  </head>
  
  <body>
  
			<div id="lay" class="easyui-layout" style="width: 100%;height:100%" >
				<div region="north" title="用户查询" collapsed=true style="height:100px;" >
					<form id="mysearch" method="post">
							考试时间:&nbsp;&nbsp;&nbsp;<input name="KsTime" class="easyui-validatebox"  value="" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							班级名称:<input name="ClassName"  editable="false" style="width:160px;"  value="" />	
							考场:<input name="Position" 	editable="false" style="width:160px;"  value="" />	
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a id="searchbtn" class="easyui-linkbutton">查询</a> 
							<a id="clearbtn" class="easyui-linkbutton">清空</a>
					</form>
				
				</div>
				<div region="center" >
					<table id="t_user"></table>
				</div>
			</div>
 			<div id="mydialog" title="新增用户" modal=true  draggable=false class="easyui-dialog" closed=true style="width:300px;">
	    		<form id="myform" action="" method="post">
	    				<input type="hidden" name="id" value="" />
	    				<table>
	    					<tr>
	    						<td>考试时间:</td>
	    						<td><input type="text" name="ksTime" class="easyui-validatebox" required=true validType="midLength[8,10]" missingMessage="考试时间必填!" invalidMessage="考试时间为8到10个字符"  value="" /></td>
	    					</tr>
	    					<tr>
	    						<td>课程名称:</td>
	    						<td><input type="text" name="kcName" class="easyui-validatebox" required=true validType="midLength[2,20]" missingMessage="课程名称必填!" invalidMessage="考试时间为2到20个字符" value="" /></td>
	    					</tr>
	    		
	    					<tr>
	    						<td>班级名称:</td>
	    						<td>
	    							<input type="text" name="className" class="easyui-validatebox" required=true validType="midLength[5,20]" missingMessage="班级名称必填!" invalidMessage="班级名称为5到20个字符" value="" />
	    						</td>
	    					</tr>
	    					<tr>
	    						<td>班级人数:</td>
	    						<td><input id="classNum" type="text"  name="classNum" validType="midLength[1,3]" missingMessage="班级人数必填!" invalidMessage="班级人数必须在5到50个字符之间!" value="" /></td>
	    					</tr>
	    					<tr>
	    						<td>同教室标记:</td>
	    						<td><input id="similar" style="width:160px;"  type="text" name="similar"  validType="midLength[0,10]"/></td>
	    					</tr>
	    					<tr>
	    						<td>考场:</td>
	    						<td>
	    							<input name="position" class="easyui-validatebox" required=true  valueField="id" validType="midLength[4,10]" missingMessage="考场信息必填!" invalidMessage="场信息必须在4到10个字符之间!" value="" />
	    						</td>
	    					</tr>
	    					<tr>
	    						<td>考场人数:</td>
	    						<td><input id="posi_num" type="text" name="posi_num" class="easyui-validatebox" required=true validType="midLength[1,50]" missingMessage="考场人数必填!" invalidMessage="考场人数必须在1到50个字符之间!" value="" /></td>
	    					</tr>
	    					<tr>
	    						<td>派监考学院:</td>
	    						<td><input id="supervisor" style="width:160px;" class="easyui-validatebox" required=true  type="text" name="supervisor" validType="midLength[3,20]" missingMessage="派监考学院必填!" invalidMessage="派监考学院必须在3到20个字符之间!" value="" /></td>
	    					</tr>
	    					<tr>
	    						<td>监考1:</td>
	    						<td><input id="jk1" style="width:160px;"   type="text" name="jk1"  validType="midLength[0,10]"/></td>
	    					</tr> 
	    					<tr>
	    						<td>监考2:</td>
	    						<td><input id="jk2" style="width:160px;"   type="text" name="jk2"  validType="midLength[0,10]"/></td>
	    					</tr> 
	    					<tr>
	    						<td>监考3:</td>
	    						<td><input id="jk3" style="width:160px;"   type="text" name="jk3" validType="midLength[0,10]"  /></td>
	    					</tr> 
	    					<tr>
	    						<td>监考4:</td>
	    						<td><input id="jk4" style="width:160px;"   type="text" name="jk4" validType="midLength[0,10]" /></td>
	    					</tr>   
	    					<tr>
	    						<td>任课教师:</td>
	    						<td><input type="text" name="tea_teacher" class="easyui-validatebox" required=true validType="midLength[2,10]" missingMessage="任课教师必填!" invalidMessage="任课教师必须在5到50个字符之间!"  value="" /></td>
	    					</tr> 
	    					<tr>
	    						<td>考核方式:</td>
	    						<td><input type="text" name="kh_Style" validType="midLength[0,10]" /></td>
	    					</tr> 
	    					<tr>
	    						<td>备注:</td>
	    						<td><input type="text" name="note"  validType="midLength[0,50]"/></td>
	    					</tr> 
	    					<tr align="center">
	    						<td colspan="2">
	    							<a id="btn1" class="easyui-linkbutton">确定</a>
	    							<a id="btn2" class="easyui-linkbutton">关闭</a>
	    						</td>
	    					</tr>   					 					    					    					    					    					    					    					    					
	    				</table>
	    		</form> 			
 			</div>
  </body>
</html>
