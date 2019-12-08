var flag;
$(function() {
		var week1=1+'';
		$('#t_user').datagrid({
			idField : 'id', //只要创建数据表格 就必须要加 ifField
			title : '用户列表',
			//width:1300 ,
			fit : true,
			height : 450,
			url : 'Servlet_kcxx?method=getList_kcxx',
			fitColumns : true,
			striped : true, //隔行变色特性 
			nowrap : false, //折行显示 为true 显示在一会 
			loadMsg : '数据正在加载,请耐心的等待...',
			rownumbers : true,
			singleSelect : true, //单选模式   &xlweek=
			//remoteSort: false ,
			//sortName: 'salary' ,
			//sortOrder: 'desc' ,
			columns : [ [ {
				field : 'time',
				title : '时间',
				width : 30,
				align : 'center'

			}, {
				field : 'week1',
				title : '星期一',
				width : 100,
				align : 'center'
			}, {
				field : 'week2',
				title : '星期二',
				width : 100,
				align : 'center'
			}, {
				field : 'week3',
				title : '星期三',
				width : 100,
				align : 'center'
			}, {
				field : 'week4',
				title : '星期四',
				width : 100,
				align : 'center'
			// 									sortable : true
			}, {
				field : 'week5',
				title : '星期五',
				width : 100,
				align : 'center'
			}, {
				field : 'week6',
				title : '星期六',
				width : 100,
				align : 'center'
			// 									sortable : true
			}, {
				field : 'week7',
				title : '星期天',
				width : 100,
				align : 'center'
			} ] ],
			pagination : true,
			pageSize : 10,
			pageList : [ 5, 10, 15, 20, 50 ],
			toolbar : [ {
				text : '新增课程',
				iconCls : 'icon-add',
				handler : function() 
				{
					flag = 'add';
					var arr = $('#t_user').datagrid('getSelections');
					$('#kcxx_add').dialog({
						title : '新增信息'
					});
					//$('#myform').find('input[name!=sex]').val("");
					$('#myformadd').get(0).reset();
					$('#kcxx_add').dialog('open');
					//$('#myform').form('clear');

				}

			}, {
				text : '调课',
				iconCls : 'icon-edit',
				handler : function() {
					flag = 'edit';
					var arr = $('#t_user').datagrid('getSelections');
						$('#kcxx_update').dialog({
							title : '修改课程信息'
						});
						$('#kcxx_update').dialog('open'); //打开窗口
						$('#myform').get(0).reset(); //清空表单数据 

				}
			} ]
		});
		
		/**
		 *  提交表单方法
		 */
		$('#btn1').click(
				function() {
					if ($('#myform').form('validate')) {
						$.ajax({
							type : 'post',
							url : 'Servlet_kcxx?method=update',
							cache : false,
							data : $('#myform').serialize(),
							dataType : 'json',
							success : function(result) {
								//1 关闭窗口
								$('#kcxx_update').dialog('close');
								//2刷新datagrid 
								$('#t_user').datagrid('reload');
								//3 提示信息
								$.messager.show({
									title : result.status,
									msg : result.message
								});
							},
							error : function(result) {
								$.meesager.show({
									title : result.status,
									msg : result.message
								});
							}
						});
					} else {
						$.messager.show({
							title : '提示信息!',
							msg : '数据验证不通过,不能修改!'
						});
					}
				});
		
		$('#btn3').click(
				function() {
					if ($('#myformadd').form('validate')) {
						$.ajax({
							
							type : 'post',
							url : 'Servlet_kcxx?method=save',
							cache : false,
							data : $('#myformadd').serialize(),
							dataType : 'json',
							success : function(result) {
								//1 关闭窗口
								$('#kcxx_add').dialog('close');
								//2刷新datagrid 
								$('#t_user').datagrid('reload');
								//3 提示信息
								$.messager.show({
									title : result.status,
									msg : result.message
								});
							},
							error : function(result) {
								$.meesager.show({
									title : result.status,
									msg : result.message
								});
							}
						});
					} else {
						$.messager.show({
							title : '提示信息!',
							msg : '数据验证不通过,不能保存!'
						});
					}
				});

		/**
		 * 关闭窗口方法
		 */
		$('#btn2').click(function() {
			$('#kcxx_update').dialog('close');
		});

		$('#btn4').click(function() {
			$('#kcxx_add').dialog('close');
		});
		
		$('#searchbtn').click(function() {
			$('#t_user').datagrid('load', serializeForm($('#mysearch')));
		});

		$('#clearbtn').click(function() {
			$('#mysearch').form('clear');
			$('#t_user').datagrid('load', {});
		});

	});

	//js方法：序列化表单 			
	function serializeForm(form) {
		var obj = {};
		$.each(form.serializeArray(), function(index) {
			if (obj[this['name']]) {
				obj[this['name']] = obj[this['name']] + ',' + this['value'];
			} else {
				obj[this['name']] = this['value'];
			}
		});
		return obj;
	}