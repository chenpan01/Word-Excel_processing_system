$(function(){
					
					var flag ;		//undefined 判断新增和修改方法 
					/**
					 *	初始化数据表格  
					 */
					$('#t_user').datagrid({
							idField:'id' ,		//只要创建数据表格 就必须要加 ifField
							title:'用户列表' ,
							//width:1300 ,
							fit:true ,
							height:450 ,
							url:'UserServlet?method=getList_jkxx' ,
							fitColumns:true ,  
							striped: true ,					//隔行变色特性 
							//nowrap: false ,				//折行显示 为true 显示在一会 
							loadMsg: '数据正在加载,请耐心的等待...' ,
							rownumbers:true ,
							singleSelect:true ,				//单选模式 
							//remoteSort: false ,
							//sortName: 'salary' ,
							//sortOrder: 'desc' ,
							 frozenColumns:[[				//冻结列特性 ,不要与fitColumns 特性一起使用 
								{
									field:'ck' ,
									width:50 ,
									checkbox: true
								}
							]],
							
							columns:[[
								{
									field:'ksTime' ,
									title:'考试时间' ,
									width:150 ,
									align:'center' 
									
								},
								{
									field:'kcName' ,
									title:'课程名称' ,
									width:150 ,
								},{
									field:'className' ,
									title:'班级名称' ,
									width:100 ,
// 									sortable : true 
								},{
									field:'classNum' , 
									title:'班级人数' ,
									width:80 
									
								},{
									field:'similar' ,
									title:'同教室标记' ,
									width:100 ,
// 									sortable : true
								},{
									field:'position' , 
									title:'考场' , 
									width:80
								},{
									field:'posi_num' , 
									title:'考场人数' ,  
									width:80
								},
								{
									field:'supervisor' ,
									title:'派监考学院' ,
									width:150 
								
								},{
									field:'jk1' ,
									title:'监考1' ,
									width:100
								},{
									field:'jk2' ,
									title:'监考2' ,
									width:100  
									
								},{
									field:'jk3' ,
									title:'监考3' ,
									width:100
								},{
									field:'jk4' ,
									title:'监考4' ,
									width:100  
									
								},{
									field:'tea_teacher' ,
									title:'任课教师' ,
									width:100
								},{
									field:'kh_Style' ,
									title:'考核方式' ,
									width:100  
								},
								{
									field:'note' ,
									title:'备注' ,
									width:40  
								}
							]] ,
							pagination: true , 
							pageSize: 10 ,
							pageList:[5,10,15,20,50] ,
							toolbar:[
								{
									text:'新增信息' ,
									iconCls:'icon-add' , 
									handler:function(){
										flag = 'add';
										$('#mydialog').dialog({
												title:'新增信息' 
										});
										//$('#myform').find('input[name!=sex]').val("");
										$('#myform').get(0).reset();
										//$('#myform').form('clear');
										$('#mydialog').dialog('open');
									
									}
									
								},{
									text:'修改信息' ,
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
												title:'修改信息'
											});
											$('#mydialog').dialog('open'); //打开窗口
											$('#myform').get(0).reset();   //清空表单数据 
											$('#myform').form('load',{	   //调用load方法把所选中的数据load到表单中,非常方便
												id:arr[0].id ,
												ksTime:arr[0].ksTime ,
												kcName:arr[0].kcName ,
												className:arr[0].className ,
												classNum:arr[0].classNum ,
												similar:arr[0].similar ,
												position:arr[0].position ,
												posi_num:arr[0].posi_num ,
												supervisor:arr[0].supervisor,
												jk1:arr[0].jk1 ,
												jk2:arr[0].jk2 ,
												jk3:arr[0].jk3 ,
												jk4:arr[0].jk4 ,
												tea_teacher:arr[0].tea_teacher,
												kh_Style:arr[0].kh_Style,
												note:arr[0].note
											});
										}
									
									}
								},{
									text:'删除信息' ,
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
																$.post('UserServlet?method=delete' , {ids:ids} , function(result){
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
									text:'查询信息' , 
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
									url: flag=='add'?'UserServlet?method=save':'UserServlet?method=update' ,
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