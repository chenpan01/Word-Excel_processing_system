$(function(){
				
					$('#age').numberbox({
						min:0 , 
						max:150 ,
						required:true , 
						missingMessage:'年龄必填!' ,
						precision:0
					});
			
				
					
					var flag ;		//undefined 判断新增和修改方法 
					/**
					 *	初始化数据表格  
					 */
					$('#xuser').datagrid({
							idField:'id' ,		//只要创建数据表格 就必须要加 ifField
							title:'用户列表' ,
							fit:true ,
							height:450 ,
							url:'Servler_xsdeal?method=getList_xscj' ,
							fitColumns:true ,  
							striped: true ,					//隔行变色特性 
							loadMsg: '数据正在加载,请耐心的等待...' ,
							rownumbers:true ,
							singleSelect:true ,				//单选模式 
							//"kcmc","sore","note","zscj","pkcj","pknote","cxcj","jdsore","kcxz"
//学号	姓名	课程名称	学分	备注	折算成绩	补考成绩	补考成绩备注	重修成绩	绩点	课程性质	课程归属	重修标记	选课课号	学年	学期	是否注册	学院	班级	正考学年学期	教师姓名

							columns:[[
								{
									field:'kcmc' ,
									title:'课程名称' ,
									width:100 ,
									align:'center' 
									
								},
								{
									field:'sore' ,
									title:'学分' ,
									width:100 ,
								},{
									field:'note' ,
									title:'备注' ,
									width:100 ,
// 									sortable : true 
								},{
									field:'zscj' , 
									title:'折算成绩' ,
									width:50 
									
								},{
									field:'pkcj' ,
									title:'补考成绩' ,
									width:100 ,
// 									sortable : true
								},{
									field:'pknote' , 
									title:'补考成绩备注' , 
									width:150
								},{
									field:'cxcj' , 
									title:'重修成绩' ,  
									width:150
								},
								{
									field:'jdsore' ,
									title:'绩点' ,
									width:100 
								
								},{
									field:'kcxz' ,
									title:'课程性质' ,
									width:100}
							]] ,
							pagination: true , 
							pageSize: 10 ,
							pageList:[5,10,15,20,50] ,
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