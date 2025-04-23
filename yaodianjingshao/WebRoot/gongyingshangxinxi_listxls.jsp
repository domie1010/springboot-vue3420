<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="gongyingshangxinxihsgb" scope="page" class="com.bean.GongyingshangxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=gongyingshangxinxi.xls");
%>
<html>
  <head>
    <title>供应商信息</title>
  </head>

  <body >
 <%
			String sql="select * from gongyingshangxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>供应商</td>    <td align='center'>负责人</td>    <td align='center'>联系手机</td>    <td align='center'>地址</td>    <td align='center'>备注</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=gongyingshangxinxihsgb.getAllGongyingshangxinxi(7);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.gongyingshang}</td>    <td>${u.fuzeren}</td>    <td>${u.lianxishouji}</td>    <td>${u.dizhi}</td>    <td>${u.beizhu}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

