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
	<script type="text/javascript">
			$(function(){

					/**
					 * 	对于form表单的验证 
					 */
					//数值验证组件 
					$('#age').numberbox({
						min:0 , 
						max:150 ,
						required:true , 
						missingMessage:'年龄必填!' ,
						precision:0
					});
					
					//日期组件
					$('#birthday').datebox({
						required:true , 
						missingMessage:'生日必填!' ,
						editable:false
					});
					
					$('#salary').numberbox({
						min:1000 , 
						max:20000 ,
						required:true , 
						missingMessage:'薪水必填!' ,
						precision:2
					});
					
					//日期时间组件
					$('#startTime,#endTime').datetimebox({
						required:true , 
						missingMessage:'时间必填!' ,
						editable:false
					});
				
					
					var flag ;		//undefined 判断新增和修改方法 
					/**
					 *	初始化数据表格  
					 */
					$('#t_user').datagrid({
							idField:'id' ,		//只要创建数据表格 就必须要加 ifField
							title:'监考信息列表' ,
							//width:1300 ,
							fit:true ,
							height:450 ,
							url:'UserServlet2?method=getList' ,
							fitColumns:true ,  
							striped: true ,					//隔行变色特性 
							//nowrap: false ,				//折行显示 为true 显示在一会 
							loadMsg: '数据正在加载,请耐心的等待...' ,
							rownumbers:true ,
							//singleSelect:true ,				//单选模式 
							//remoteSort: false ,
							//sortName: 'salary' ,
							//sortOrder: 'desc' ,
							frozenColumns:[[				
								{
									field:'ck' ,
									width:50 ,
									checkbox: true
								}
							]],
							columns:[[
								{
									field:'examTime' ,
									title:'监考时间' ,
									width:100 ,
									align:'center' ,
									
								},
								{
									field:'className' ,
									title:'班级名称' ,
									width:100 ,
									hidden: true
								},{
									field:'kcName' ,
									title:'课程名称' ,
									width:100 ,
									sortable : true 
								},{
									field:'classNum' , 
									title:'班级数量' ,
									width:50 ,
									
								},{
									field:'TotalNum' ,
									title:'教室总人数' ,
									width:50 ,
									sortable : true
								},{
									field:'ksposition' , 
									title:'考试场所' , 
									width:100
								},{
									field:'teacher' , 
									title:'任课老师' ,  
									width:100
								},{
									field:'style' ,
									title:'考核方式' ,
									width:50
								}
							]] ,
							pagination: true , 
							pageSize: 10 ,
							pageList:[5,10,15,20,50] ,
							toolbar:[
								{
									text:'新增用户' ,
									iconCls:'icon-add' , 
									handler:function(){
										flag = 'add';
										$('#mydialog').dialog({
												title:'新增用户' 
										});
										//$('#myform').find('input[name!=sex]').val("");
										$('#myform').get(0).reset();
										//$('#myform').form('clear');
										$('#mydialog').dialog('open');
									
									}
									
								},{
									text:'修改用户' ,
									iconCls:'icon-edit' , 
									handler:function(){
										flag = 'edit';
										var arr =$('#t_user').datagrid('getSelections');
										if(arr.length != 1){
											$.messager.show({
												title:'提示信息!',
												msg:'只能选择一行记录进行修改!'
											});
										} else {
											$('#mydialog').dialog({
												title:'修改用户'
											});
											$('#mydialog').dialog('open'); //打开窗口
											$('#myform').get(0).reset();   //清空表单数据 
											$('#myform').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
												id:arr[0].id ,
												examTime:arr[0].examTime ,
												className:arr[0].className ,
												kcName:arr[0].kcName ,
												classNum:arr[0].classNum ,
												TotalNum:arr[0].TotalNum ,
												ksposition:arr[0].ksposition ,
												teacher:arr[0].teacher ,
												style:arr[0].style
											});
										}
									
									}
								},{
									text:'删除用户' ,
									iconCls:'icon-remove' , 
									handler:function(){
											var arr =$('#t_user').datagrid('getSelections');
											if(arr.length <=0){
												$.messager.show({
													title:'提示信息!',
													msg:'至少选择一行记录进行删除!'
												});
											} else {
												
												$.messager.confirm('提示信息' , '确认删除?' , function(r){
														if(r){
																var ids = '';
																for(var i =0 ;i<arr.length;i++){
																	ids += arr[i].id + ',' ;
																}
																ids = ids.substring(0 , ids.length-1);
																$.post('UserServlet2?method=delete' , {ids:ids} , function(result){
																	//1 刷新数据表格 
																	$('#t_user').datagrid('reload');
																	//2 清空idField   
																	$('#t_user').datagrid('unselectAll');
																	//3 给提示信息 
																	$.messager.show({
																		title:'提示信息!' , 
																		msg:'操作成功!'
																	});
																});
														} else {
															return ;
														}
												});
											}
									}								
								},{
									text:'查询用户' , 
									iconCls:'icon-search' , 
									handler:function(){
											$('#lay').layout('expand' , 'north');
									}
								}	
							]
					});
					
					
					/**
					 *  提交表单方法
					 */
					$('#btn1').click(function(){
							if($('#myform').form('validate')){
								$.ajax({
									type: 'post' ,
									url: flag=='add'?'UserServlet2?method=save':'UserServlet2?method=update' ,
									cache:false ,
									data:$('#myform').serialize() ,
									dataType:'json' ,
									success:function(result){
										//1 关闭窗口
										$('#mydialog').dialog('close');
										//2刷新datagrid 
										$('#t_user').datagrid('reload');
										//3 提示信息
										$.messager.show({
											title:result.status , 
											msg:result.message
										});
									} ,
									error:function(result){
										$.meesager.show({
											title:result.status , 
											msg:result.message
										});
									}
								});
							} else {
								$.messager.show({
									title:'提示信息!' ,
									msg:'数据验证不通过,不能保存!'
								});
							}
					});
					
					/**
					 * 关闭窗口方法
					 */
					$('#btn2').click(function(){
						$('#mydialog').dialog('close');
					});
					
						
					$('#searchbtn').click(function(){
						$('#t_user').datagrid('load' ,serializeForm($('#mysearch')));
					});
					
					
					$('#clearbtn').click(function(){
						$('#mysearch').form('clear');
						$('#t_user').datagrid('load' ,{});
					});
					

			});
			
			
			
		
			//js方法：序列化表单 			
			function serializeForm(form){
				var obj = {};
				$.each(form.serializeArray(),function(index){
					if(obj[this['name']]){
						obj[this['name']] = obj[this['name']] + ','+this['value'];
					} else {
						obj[this['name']] =this['value'];
					}
				});
				return obj;
			}

	</script>
  </head>
  
  <body>
			<div id="lay" class="easyui-layout" style="width: 100%;height:100%" >
				<div region="north" title="用户查询" collapsed=true style="height:100px;" >
					<form id="mysearch" method="post">
							用户名:&nbsp;&nbsp;&nbsp;<input name="username" class="easyui-validatebox"  value="" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<!-- "startTime"  -->考试时间:<input name="examTime"  class="easyui-datetimebox" editable="false" style="width:160px;"  value="" />	
							班级名称:<input name="className"  class="easyui-validatebox"  value="" />	
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
	    						<td>监考时间:</td>
	    						<td><input id="birthday" style="width:160px;"  type="text" name="examTime" value="" /></td>
	    					</tr>
	    					<tr>
	    						<td>班级名称:</td>
	    						<td><input type="text" name="className" class="easyui-validatebox" required=true  missingMessage="班级必填!" value="" /></td>
	    					</tr>
	    					<tr>
	    						<td>课程名称:</td>
	    						<td><input type="text" name="kcName" class="easyui-validatebox" required=true  missingMessage="课程名称必填!" value="" /></td>
	    					</tr>
	    					<tr>
	    						<td>班级数量:</td>
	    						<td><input name="classNum" style="width:160px;"  type="text" value="" /></td>
	    					</tr>
	    					<tr>
	    						<td>教室总人数:</td>
	    						<td>
	    							<input name="TotalNum" class="easyui-combobox" value="" />
	    						</td>
	    					</tr>
	    					<tr>
	    						<td>考试场所:</td>
	    						<td><input  type="text" name="ksposition" value="" /></td>
	    					</tr>
	    					<tr>
	    						<td>任课老师:</td>
	    						<td><input style="width:160px;"  type="text" name="teacher"  value="" /></td>
	    					</tr>
	    					<tr>
	    						<td>考核方式:</td>
	    						<td><input style="width:100px;"   type="text" name="style"  value="" /></td>
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
