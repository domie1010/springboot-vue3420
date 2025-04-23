<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="xiaoshouhsgb" scope="page" class="com.bean.XiaoshouBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=xiaoshou.xls");
%>
<html>
  <head>
    <title>出库</title>
  </head>

  <body >
 <%
			String sql="select * from xiaoshou  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>药品编号</td>
    <td align='center'>药品名称</td>
    <td align='center'>类别</td>
    <td align='center'>库存</td>
    <td align='center'>客户</td>
    <td align='center'>出库数量</td>
    <td  width='65' align='center'>出库时间</td>
    <td align='center'>出库员</td>
    <td align='center'>退货数量</td>
    <td align='center'>退货原因</td>
    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=xiaoshouhsgb.getAllXiaoshou(12);
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
    <td>${u.kehu}</td>
    <td>${u.xiaoshoushuliang}</td>
    <td>${u.xiaoshoushijian}</td>
    <td>${u.xiaoshouyuan}</td>
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

