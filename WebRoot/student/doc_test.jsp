<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
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

<title>My JSP 'doc_test.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
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
<script type="text/javascript" src="js/Doc.js"></script>
<script language="javascript">
</script>
<!-- <form action="UserServlet?method=doWord" method="post"> -->
<!--   <textarea name="id" cols="100" rows="6" ></textarea> -->
<!--   <input type="submit" value="提交"> -->
<!-- </form> -->
<!-- position:absolute -->
</head>
<body>
	<div align="center" class="easyui-panel" style="position:absolute; left:10px; top:10px">
		<p style="font-size:22px">（ 2017   —  2018 学年）国家励志奖学金申请审批表</p><br>
			<form  id="form1" action="UserServlet?method=doWord" method="post">
				 <p>
					  学校:<input id="school" name="School" class="easyui-textbox"	style="width:100px;height:20px">
					   院系：<input id="xueyuan" name="Yunmi" class="easyui-textbox"	style="width:100px;height:20px">  
					   学号：<input id="school" name="Stadium" class="easyui-textbox"	style="width:100px;height:20px">
				 </p>
				 <table width="710" border="1">
<!-- 				<tbody>	</tbody> 
width="100%" border="1" height="50%"
size="20"
 width="10"
-->
					  <tr style="height:150px">
					    <td >基本情况</td>
					    <td height="100%">
					    	<table  width="100%" border="1" height="100%">
					            <tr>
					                <td>姓名</td>
					                <td > <input  type="text"  name="Name"  width="100%"/></td>
					                <td>性别</td>
					                <td><input    name="Sex"  size="15"/></td>
					                <td>出生年月</td>
					                <td><input   name="birthday" size="15"/></td>
					          </tr>
					          <tr>
					                <td>政治面貌</td>
					                <td><input  name="Public"  width="100%"/></td>
					                <td>民族</td>
					                <td><input  name="National" size="15" /></td>
					                <td>入学时间</td>
					                <td><input  name="Begin" size="15"/></td>
					          </tr>
					          <tr>
					            <td>专业</td>
					            <td><input  name="Profession" width="100%" /></td>
					            <td>学制</td>
					            <td><input name="Yuezhi" size="15" /></td>
					            <td>联系电话</td>
					            <td><input  name="Telephone" size="15" /></td>
					          </tr>
					          <tr>
					            <td>身份证号</td>
					            <td><input name="ID" width="100%"/></td>
					          </tr>
					    </table>
					    </td>
					  </tr>
					  <tr>
					    <td>学习情况</td>
					    <td>
					    	<table width="100%" border="1">
					          <tr>
					            <td width="250">成绩排名:<input name="Rank" type="text" size="10"  width="2">（名次/总人数）</td>
					            <td width="120">是否实行综合考评排名：<input class="easyui-textbox"  name="Isuzu" size="5"  width="10"/> </td>
					          </tr>
					          <tr>
					            <td>必修:<input name="classful" type="text" size="2"  width="2"> 门课，其中及格以上:<input name="classier" type="text" size="1"  width="2">  门</td>
					            <td>如是，排名：<input size="8"  name="hour"> （名次/总人数）</td>
					          </tr>
							</table>
					    </td>
					  </tr>
					  <tr>
					    <td>家庭经济情况</td>
					    <td>
					    	<table width="100%" border="1">
										  
										  <tr height="20">
											<td width="18%">家庭户籍</td>
											<td width="18%"><input type="text" size="8" name="Hajji">（城镇/农村）</td>
											<td width="18%">家庭人口总数</td>
											<td width="18%"><input type="text" size="8" name="Family"></td>              
										  </tr>	
										  <tr>
											<td>家庭住址</td>
											<td><input class="easyui-textbox"  name="Station" size="14" /></td>
											<td>邮政编码</td>
											<td><input class="easyui-textbox"  name="Code" size="14" /></td>
										  </tr>
										  <tr>
											<td width="18%">家庭月收入</td>
											<td width="18%"><input class="easyui-textbox"  name="One" size="14" /></td>
											<td width="18%">人均月收入</td>
											<td width="18%"><input class="easyui-textbox"  name="Two" size="14" /></td>
											<td width="18%">收入来源</td>
											<td width="18%"><input class="easyui-textbox"  name="from" size="8" /></td>
										  </tr>
						</table>
					
					    </td>
					  </tr>
					  <tr>
					    <td>大学期间获奖情况</td>
					    <td>
					    	<table width="100%" border="1">
					              <tr>
					                <td>日期</td>
					                <td>奖项名称</td>
					                <td>颁奖单位</td>
					              </tr>
					              <tr>
					                <td><input class="easyui-textbox"  name="Datome" size="14" /></td>
					                <td><input class="easyui-textbox"  name="Prizemoney" size="14" /></td>
					                <td><input class="easyui-textbox"  name="Unatoned" size="14" /></td>
					              </tr>
					              <tr>
					                <td><input class="easyui-textbox"  name="Date" size="14" /></td>
					                <td><input class="easyui-textbox"  name="Prieto" size="14" /></td>
					                <td><input class="easyui-textbox"  name="Unit" size="14" /></td>
					              </tr>
					              <tr>
					                <td><input class="easyui-textbox"  name="Three" size="14" /></td>
					                <td><input class="easyui-textbox"  name="Prize" size="14" /></td>
					                <td><input class="easyui-textbox"  name="come" size="14" /></td>
					              </tr>
							</table>
					
					    </td>
					  </tr>
					  <tr>
					    <td>申请理由&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					    
					        <td style="height:100px;">
					        </td>
					            
					 </tr>
					  <tr>
					    <td>推荐理由</td>
					   <td style="height:80px;">
					        	                  			      
					                                    				
					    </td>
					  </tr>
					  <tr>
					    <td>院（系）意见</td>
					    <td style="height:80px;">
					        
					        	                			
					    </td>
					  </tr>
					  <tr>
					    <td>学校意见</td>
					    <td style="height:80px"></td>
					    
					  </tr>
				
				</table> 
				<p></p><p></p>
				<input type="hidden" name="Applying" id="Applying" />
				<input type="hidden" name="Signature" id="Signature" />
				<input type="hidden" name="January" id="January" />
				<input type="hidden" name="February" id="February" />
				<input type="hidden" name="March" id="March" />
				<input type="hidden" name="Applied" id="Applied" />
				<input type="hidden" name="Monogram" id="Monogram" />
				<input type="hidden" name="Jan" id="Jan" />
				<input type="hidden" name="Feb" id="Feb" />
				<input type="hidden" name="Mar" id="Mar" />
				<input type="hidden" name="Schools" id="Schools" />
				<input type="hidden" name="April" id="April" />
				<input type="hidden" name="Apr" id="Apr" />
				<input type="hidden" name="May" id="May" />
				<input type="hidden" name="August" id="August" />
				<input type="hidden" name="October" id="October" />
				<input type="hidden" name="November" id="November" />
				<input type="hidden" name="Dec" id="Dec" />
				
				<input type="submit" value="提交" onClick="DoSubmit();">
			</form> 
	</div>
<!-- 			114 -->
		  <div id="divsq" style="position:absolute; left:310px; top:464px">
 				<textarea id="sq" name="Applying" cols="96" rows="3" ></textarea> 
 		  </div>
 		  
 		 <div id="divsqqm" style="position:absolute;left:721px; top:514px">
				   申请人签名（手签）:<input name="Signature" size="8" id="sig"/><br>
		   <input name="January" size="4" style="" id="jan"/> 年 <input name="February" size="2" id="feb"/>月<input name="March" size="2" id="mar"/>日 
 		 </div>
				        
		 <div id="divtj" style="position:absolute;left:310px; top:566px">
 				<textarea name="Applied" cols="96" rows="2" id="appli"></textarea> 
 		 </div>
		 <div id="divtjqm" style="position:absolute;left:644px; top:599px"> 
	        	                推荐人（辅导员或班主任）签名：<input  name="Monogram" size="8" id="mon"/> <br>
	                 <input name="Jan" size="4" id="jjan"/> 年 <input name="Feb" size="2" id="ffeb"/>月<input name="Mar" size="2" id="mmar"/>  日 
	     </div> 
		<div id="divyj" style="position:absolute;left:310px; top:647px">
 				<textarea name="Schools" cols="96" rows="2" id="school"></textarea> 
 		 </div>	
 		 <div id="divyj" style="position:absolute;left:644px; top:677px">	        
			   院系主管学生工作领导签名（签章）： <br>
			 <input name="April" size="4" id="april"/> 年 <input name="Apr" size="2" id="aapr"/>月<input name="May" size="2" id="mmaar"/>日
		</div>
		
		<div id="xxyj" style="position:absolute;left:310px; top:730px">
			    经评审，并在校内公示<input type="text" name="August" size="5" id="augg"/>  个工作日，无异议，现报请批准该同学获得国家励志奖学金。
		</div>
		<div id="xxyjqz" style="position:absolute;left:644px; top:765px">			
				（学校公章）：
			    <input name="October" size="4" id="ooct"/> 年 <input name="November" size="2" id="nnov"/>月<input name="Dec" size="2" id="ddec"/>日
	   </div>
</body>
</html>
