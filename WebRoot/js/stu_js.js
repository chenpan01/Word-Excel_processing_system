function check(form) {
	var xuehao=form.Xuehao.value;
	var Pwd=form.Mm.value;
	var Name='';
    if(xuehao=='') {
          alert("请输入用户帐号!");
          form.Xuehao.focus();
          return false;
     }
     if(Pwd==''){
          alert("请输入登录密码!");
          form.Mm.focus();
          return false;
       }
    //创建数据库连接对象
     var conn = new ActiveXObject("ADODB.Connection");
     //创建数据集对象
     var rs = new ActiveXObject("ADODB.Recordset");
//     try{
     //数据库连接串，具体配置请参考：http://www.connectionstrings.com/
     //如果不知道如何配置连接串，可以通过配置UDL文件后用文本编辑器打开获得  easyui.xsxh
     var connectionstring = "Driver={MySQL ODBC 5.2w Driver};Server=localhost;Database=easyui;User=root; Password=rootchenpan;Option=3;Port=3306";
     //打开连接
     conn.open(connectionstring);
      
     //查询语句  
     var sql = " select * from xsxh where id= '"+Xuehao+"' and pwd= '"+Pwd+"'";
     alert(sql);
     //打开数据集（即执行查询语句）
     rs.open(sql,conn);
     //(或者rs=conn.execute(sql);)
     //遍历所有记录
     while(!rs.eof){
      //WScript是Windows 的脚本宿主对象，详细情况请在windows帮助里查找。
      //WScript.Echo输出记录的内容
      Name=rs.Fields("name");
      
      //下一条记录
      rs.moveNext();
     }
     var flag=0;
     alert(Name);
     if(Name=='')
	 {
    	 alert("输入的密码或用户名错误!");
    	 flag=1;
	 }
     document.getElementById("user").value=Name;
     //关闭记录集
     rs.close();
     //关闭数据库连接
     conn.close();
     if(flag==0)
    	 return true;
     /*} catch(e){
     //异常报告
     WScript.Echo(e.message);
     } */
     return false;
}
	

	$(function() {
		$('a[title]')
				.click(
						function() {
							var src = $(this).attr('title');
							var title = $(this).html();
							if ($('#tt').tabs('exists', title)) 
							{
								$('#tt').tabs('select', title);
							} else {
								$('#tt')
										.tabs(
												'add',
												{
													title : title,
													content : '<iframe frameborder=0 style=width:100%;height:100%; position:absolute; left:0px; top:0px; src='
															+ src
															+ ' ></iframe>',
													closable : true
												});
							}

						});

	});
	



	
//	var value="";
//		window.onload = function(){
//	  		doSomething();
//		};
//		function doSomething() {
//		var fruit = document.getElementById("rtl");
//		fruit.onchange = function() {
//			var option = document.getElementsByTagName("option");
//			value = option[fruit.selectedIndex].value;
//			console.log(option[fruit.selectedIndex]);
//		}
//	}
//		function submitit() {
//		
//			document.getElementById('formid').action = "UserServlet?method=upload&num=" + value;
//			document.getElementById("formid").submit();
//		}
	 
	 