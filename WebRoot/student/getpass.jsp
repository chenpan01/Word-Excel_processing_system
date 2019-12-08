<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="s2pro.mng.dao.BaseDao"%>
<%@page import="s2pro.mng.entity.Users"%>

<%
	request.setCharacterEncoding("utf-8");
	String get = ""+request.getParameter("action");
	String upass = null;
	if(get.equals("get")){

		String num = request.getParameter("loginNum");
		String superPass = request.getParameter("loginSuperPass");
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "select uPass from Users where uUserNum = ? and uSuperNum = ?";
		try{
			conn = BaseDao.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,num);
			ps.setString(2,superPass);	
			ResultSet rs = ps.executeQuery();

			if(rs.next())
			{
				upass = rs.getString("upass");
			}
			else
			{
				upass = null;
			}
		}catch(Exception ex){
			ex.getMessage();
		}finally{
			BaseDao.CloseAll(conn,ps,null);
		}
	}
	if(upass!=null){
		out.print("<script type='text/javascript'>alert('密码已找回，请记录！');history.back();</script>");
	}else{
	out.print("<script type='text/javascript'>alert('员工编号或超级密码不正确，请重新输入');history.back();</script>");
	}
 %>
 
 <html>
  <head>    
    <title>密码找回页面</title>
        <script type="text/javascript" language="javascript">
			function checkLostPass()
			{
				if(form2.loginNum.value == "")
				{
					alert("请输入员工编号");
					form2.loginNum.focus();
					return false;
				}
				if(form2.loginSuperPass.value == "")
				{
					alert("请输入超级密码");
					form2.loginSuperPass.focus();
					return false;
				}
				return true;
			}
		</script>
  </head>

  <body>
    <form name="form2" method="post" action="getpass.jsp">
    	<table align="center">
			<tr>
				<th style="font-size:35px" colspan="2"> 
					密码找回 
				</th>
			</tr>
			<tr>
				<td>
					员工编号：<input type="text" name="loginNum">
				</td>
				<td> 

				</td>
			</tr>
			<tr>
				<td>
					超级密码：<input type="password" name="loginSuperPass">
				</td>
			</tr>
			<tr>
				<td>
					您的密码为:<input type="text" name="txtRPass" value="<%= upass%>" disabled>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="hidden" name="action" id="action" value="get">
				  <input type="submit" value="找回密码" onClick="return checkLostPass()">  
					<input type="reset" value="重填">
				</td>
			</tr>
	  </table>
	 </form>
  </body>
</html>
 