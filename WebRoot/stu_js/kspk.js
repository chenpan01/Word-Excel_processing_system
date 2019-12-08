$(function(){
				
					var flag ;		//undefined 判断新增和修改方法 
					/**
					 *	初始化数据表格  
					 */
					$('#xuser').datagrid({
							idField:'id' ,		//只要创建数据表格 就必须要加 ifField
							title:'用户列表' ,
							fit:true ,
							height:450 ,
							url:'Servler_xsdeal?method=getList_kspk' ,
							fitColumns:true ,  
							striped: true ,					//隔行变色特性 
							loadMsg: '数据正在加载,请耐心的等待...' ,
							rownumbers:true ,
							singleSelect:true ,				//单选模式 
							columns:[[
								{
									field:'kcmc' ,
									title:'课程名称' ,
									width:100 ,
									align:'center' 
									
								},
								{
									field:'score' ,
									title:'学分' ,
									width:100 
								},{
									field:'kcxz' ,
									title:'课程性质' ,
									width:100 
// 									sortable : true 
								},{
									field:'kssj' , 
									title:'考试时间' ,
									width:150 
									
								},{
									field:'teacher' ,
									title:'任课教师' ,
									width:100 
// 									sortable : true
								},{
									field:'xueyuan' , 
									title:'开课学院' , 
									width:150
								},{
									field:'xq' , 
									title:'校区' ,  
									width:150
								},
								{
									field:'ksdd' ,
									title:'考试地点' ,
									width:100 
								
								},{
									field:'bz' ,
									title:'备注' ,
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