//rec sub editor  var obj = document.getElementById(Id+"");  $('#hidden').val(week);
function domail()
{
	var fujian="";
	var obj = document.getElementById("rec");
	fujian+="rec="+obj.value;
    obj = document.getElementById("sub");
	fujian+="&sub="+obj.value;
	var text=document.getElementById('editor').value;
	fujian+="&content="+text;
	obj=document.getElementById("form1");
	obj.action="UserServlet?method=domail&"+fujian;
	obj.submit();
}