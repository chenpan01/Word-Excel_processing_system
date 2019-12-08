<%@ page language="java" import="java.util.*" pageEncoding="gb2312"
	contentType="text/html; charset=gb2312"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'mail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
<script type="text/javascript" charset="utf-8"
	src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="ueditor/ueditor.all.js"></script>
<link href="ueditor/themes/default/css/ueditor.css" rel="stylesheet">
<script type="text/javascript" charset="utf-8"
	src="ueditor/lang/zh-cn/zh-cn.js"></script>
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
<!-- 	<script type="text/javascript"	src="js/mail.js"></script> -->
<script type="text/javascript">


	UE.getEditor('editor');
	function submitit() 
	{
		var action1="";
		var rec = document.getElementById("rec");
		var sub = document.getElementById("sub");
		var content= document.getElementById("editor");
// 	    action1="UserServlet?method=domail&";
// 		action1+="rec="+rec;
// 		action1+="&sub="+sub;
		//action+="&content="+content;
		document.getElementById('form1').action = "&rec="+rec+"&sub="+sub;
		document.getElementById("form1").submit();
	}
</script>
</head>

<body>
<!-- 

				<tr><input type="hidden" name="method" value="domail" />
 -->
	<div class="easyui-panel" style="width:1400px;height:1400px;position:absolute; left:10px; top:10px">
		<form id="form1" action="SendAttachment" method="post" ENCTYPE="multipart/form-data">
			<table>
				<tr>
					<td>收件人:<input type="text" id="rec" name="to"  style="width:160px;height:30px"></td>
				</tr>
				<tr>
					Sender: <input type="text" size="40" name="from" value="jxlgcp@163.com">
				</tr>
				<tr></tr><tr></tr>
				<tr>
					<td>主题:<input type="text" id="sub" name="subject" class="easyui-textbox"	style="width:800px;height:30px"></td>
				</tr>
<!-- 				<tr></tr><tr></tr><tr></tr> -->
<!-- 					<tr>添加附件：<input type="file" name="filename" size="28" /></tr> -->
				<tr></tr><tr></tr>
				<tr>
					<td><textarea id="editor" name="content" type="text" style="width: 1000px; height: 500px"></textarea></td>
	 			</tr>
	 		</table>
 			<input type="submit" value="发送">
		</form>
		
	</div>
</body>
</html>
<!-- 
		<div>
			<input type="button" value="发送" onClick="submitit();" />
		</div>
		<br>
		<div style="margin-bottom:10px">
			收件人:<input id="rec" class="easyui-textbox"
				style="width:300px;height:30px">
		</div>
		<div style="margin-bottom:10px">
			主题:<input id="sub" class="easyui-textbox"
				style="width:800px;height:30px">
		</div>
		<div style="margin-bottom:10px">
			<form id="form1" action="" method="post">
				
				
			</form>
		</div>


添加附件:<input type="file" name="filename" size="45"><br>
				<br>
		<div style="margin:20px 0;"></div>
		<div style="margin-bottom:20px">
			<div>Company:</div>
			<input class="easyui-textbox" style="width:100%;height:32px">
		</div>
		<div>
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
				style="width:100%;height:32px">Register</a>
		</div>
		 -->

<!--  
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'mail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
<script type="text/javascript" charset="utf-8"
	src="ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="ueditor/ueditor.all.js"></script>
<link href="ueditor/themes/default/css/ueditor.css" rel="stylesheet">
<script type="text/javascript" charset="utf-8"
	src="ueditor/lang/zh-cn/zh-cn.js"></script>
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
<script type="text/javascript">
	UE.getEditor('editor');
	function submitit() 
	{
		var action1="";
		var rec = document.getElementById("rec");
		var sub = document.getElementById("sub");
		var content= document.getElementById("editor");
// 	    action1="UserServlet?method=domail&";
// 		action1+="rec="+rec;
// 		action1+="&sub="+sub;
		//action+="&content="+content;
		document.getElementById('form1').action = "&rec="+rec+"&sub="+sub;
		document.getElementById("form1").submit();
	}
</script>
</head>

<body>


				<tr><input type="hidden" name="method" value="domail" />

	<div class="easyui-panel" style="width:1400px;height:1400px;position:absolute; left:10px; top:10px">
		<form id="form1" action="SendAttachment"  method="post">
			<table>
				<tr>
					<td>收件人:<input id="rec" name="to" class="easyui-textbox" style="width:160px;height:30px"></td>
				</tr>
				<tr></tr><tr></tr><tr></tr>
				<tr>
					<td>主题:<input id="sub" name="subject"  class="easyui-textbox"	style="width:800px;height:30px"></td>
				</tr>
				<tr></tr><tr></tr><tr></tr>
					<tr>添加附件：<input type="file" name="filename" size="28" /></tr>
				<tr></tr><tr></tr>
				<tr>
					<td><textarea id="editor" name="content" type="text/plain" style="width: 1000px; height: 500px"></textarea></td>
	 			</tr>
	 		</table>
 			<input type="submit" value="发送">
		</form>
		
	</div>
</body>
</htm>
		<div>
			<input type="button" value="发送" onClick="submitit();" />
		</div>
		<br>
		<div style="margin-bottom:10px">
			收件人:<input id="rec" class="easyui-textbox"
				style="width:300px;height:30px">
		</div>
		<div style="margin-bottom:10px">
			主题:<input id="sub" class="easyui-textbox"
				style="width:800px;height:30px">
		</div>
		<div style="margin-bottom:10px">
			<form id="form1" action="" method="post">
				
				
			</form>
		</div>


添加附件:<input type="file" name="filename" size="45"><br>
				<br>
		<div style="margin:20px 0;"></div>
		<div style="margin-bottom:20px">
			<div>Company:</div>
			<input class="easyui-textbox" style="width:100%;height:32px">
		</div>
		<div>
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok"
				style="width:100%;height:32px">Register</a>
		</div>
		 -->