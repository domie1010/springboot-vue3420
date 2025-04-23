<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="caigouhsgb" scope="page" class="com.bean.CaigouBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=caigou.xls");
%>
<html>
  <head>
    <title>入库</title>
  </head>

  <body >
 <%
			String sql="select * from caigou  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>药品编号</td>
    <td align='center'>药品名称</td>
    <td align='center'>类别</td>
    <td align='center'>库存</td>
    <td align='center'>供应商</td>
    <td align='center'>入库数量</td>
    <td  width='65' align='center'>批次</td>
    <td align='center'>入库员</td>
    <td align='center'>退货数量</td>
    <td align='center'>退货原因</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
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

