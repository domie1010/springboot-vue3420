<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="kehuxinxihsgb" scope="page" class="com.bean.KehuxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=kehuxinxi.xls");
%>
<html>
  <head>
    <title>客户信息</title>
  </head>

  <body >
 <%
			String sql="select * from kehuxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>客户</td>    <td  width='40' align='center'>性别</td>    <td align='center'>联系手机</td>    <td align='center'>地址</td>    <td align='center'>备注</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=kehuxinxihsgb.getAllKehuxinxi(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.kehu}</td>    <td align='center'>${u.xingbie}</td>    <td>${u.lianxishouji}</td>    <td>${u.dizhi}</td>    <td>${u.beizhu}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

