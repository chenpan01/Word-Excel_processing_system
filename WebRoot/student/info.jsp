<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

https://q.cnblogs.com/q/69488/
1、把编辑按钮变成保存按钮；

2、获取当前行的表格内容；

3、在需要编辑的地方动态生成input框，并把2中的信息写入到input框中；

4、检测用户输入的信息，如果合法，那么当用户点击保存按钮时就进行了保存；

5、form元素提交表单后，页面自动刷新。

改为 $("input").removeAttr("disabled");//disabled是属性，不是元素，用removeAttr()可以移除属性 当然你也可以这样用 $("input").attr("disabled",false); 如果要是添加属性的话就可以这样 $("input").attr("disabled",true);
</body>
</html>