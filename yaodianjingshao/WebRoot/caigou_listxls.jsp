<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="caigouhsgb" scope="page" class="com.bean.CaigouBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=caigou.xls");
%>
<html>
  <head>
    <title>���</title>
  </head>

  <body >
 <%
			String sql="select * from caigou  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">���</td>
    <td align='center'>ҩƷ���</td>
    <td align='center'>ҩƷ����</td>
    <td align='center'>���</td>
    <td align='center'>���</td>
    <td align='center'>��Ӧ��</td>
    <td align='center'>�������</td>
    <td  width='65' align='center'>����</td>
    <td align='center'>���Ա</td>
    <td align='center'>�˻�����</td>
    <td align='center'>�˻�ԭ��</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">���ʱ��</td>
    
  </tr>
   <%		
				List pagelist3=caigouhsgb.getAllCaigou(12);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.shangpinbianhao}</td>
    <td>${u.shangpinmingcheng}</td>
    <td>${u.leibie}</td>
    <td>${u.kucun}</td>
    <td>${u.gongyingshang}</td>
    <td>${u.caigoushuliang}</td>
    <td>${u.caigoushijian}</td>
    <td>${u.caigouyuan}</td>
    <td>${u.tuihuoshuliang}</td>
    <td>${u.tuihuoyuanyin}</td>
    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

