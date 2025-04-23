<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<%@ page isELIgnored="false" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>数据备份</title>
    

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>
  
  <body>
  <%
 
if (request.getSession().getAttribute("cx").equals("超级管理员"))
{

String sql="";
  sql="backup database jspmdtgwwzhsg4567B294 to disk='D:/jspmdtgwwzhsg4567B294.dat'";
	  	
connDbBean.hsgexecute(sql); 
out.print("<script>alert('操作成功!!，您的数据库已成jspmdtgwwzhsg4567B294.dat');location.href='sy.jsp';</script>");
  	  
}
else
{
out.print("<script>alert('对不起,您没有该权限');location.href='sy.jsp';</script>");
}

 %>
  </body>
</html>


