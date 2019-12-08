$(function() {
	var flag; // undefined 判断新增和修改方法
	/**
	 * 初始化数据表格
	 */
	$('#xuser').datagrid({
		idField : 'id', // 只要创建数据表格 就必须要加 ifField
		title : '信息修改记录',
		fit : true,
		height : 450,
		url : 'Servler_xsdeal?method=getList_upxx',
		fitColumns : true,
		striped : true, // 隔行变色特性
		loadMsg : '数据正在加载,请耐心的等待...',
		rownumbers : true,
		singleSelect : true, // 单选模式
		frozenColumns : [ [ // 冻结列特性 ,不要与fitColumns 特性一起使用
		{
			field : 'ck',
			width : 50,
			checkbox : true
		} ] ],
		columns : [ [ {
			field : 'time',
			title : '修改时间',
			width : 100

		}, {
			field : 'content',
			title : '修改内容',
			width : 100
		} ] ],
		pagination : true,
		pageSize : 10,
		pageList : [ 5, 10, 15, 20, 50 ],

	});

});
// js方法：序列化表单
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