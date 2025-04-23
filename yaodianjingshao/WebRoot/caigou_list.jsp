<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>入库查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">入库列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="caigouList.do" name="myform" method="post">
									查询   药品编号：<input name="shangpinbianhao" type="text" id="shangpinbianhao" style='border:solid 1px #000000; color:#666666' size="12" />  药品名称：<input name="shangpinmingcheng" type="text" id="shangpinmingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  类别：<input name="leibie" type="text" id="leibie" style='border:solid 1px #000000; color:#666666' size="12" /> 供应商：<select name='gongyingshang' id='gongyingshang' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><%=connDbBean.hsggetoption("gongyingshangxinxi","gongyingshang")%></select>  批次：<input name="caigoushijian1" type="text" id="caigoushijian1"  value='' style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />
									<input type="submit" value="查询" />
								<input type=button name=Submit54 value=添加入库 onClick="javascript:location.href='caigou_add.jsp'" /></form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
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
    
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
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
    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateCaigoulb.do?id=${u.id }">退货</a> <a href="doUpdateCaigou.do?id=${u.id }">编辑</a>  <a href="deleteCaigou.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> </td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		 <%
			String sql="select * from caigou where 1=1 ";
				
if(request.getParameter("shangpinbianhao")=="" ||request.getParameter("shangpinbianhao")==null ){}else{String nshangpinbianhao=new String(request.getParameter("shangpinbianhao").getBytes("8859_1"));if(nshangpinbianhao.contains("?")){nshangpinbianhao=request.getParameter("shangpinbianhao");}sql=sql+" and shangpinbianhao like '%"+nshangpinbianhao+"%'";}
if(request.getParameter("shangpinmingcheng")=="" ||request.getParameter("shangpinmingcheng")==null ){}else{String nshangpinmingcheng=new String(request.getParameter("shangpinmingcheng").getBytes("8859_1"));if(nshangpinmingcheng.contains("?")){nshangpinmingcheng=request.getParameter("shangpinmingcheng");}sql=sql+" and shangpinmingcheng like '%"+nshangpinmingcheng+"%'";}
if(request.getParameter("leibie")=="" ||request.getParameter("leibie")==null ){}else{String nleibie=new String(request.getParameter("leibie").getBytes("8859_1"));if(nleibie.contains("?")){nleibie=request.getParameter("leibie");}sql=sql+" and leibie like '%"+nleibie+"%'";}
if(request.getParameter("gongyingshang")=="" ||request.getParameter("gongyingshang")==null ){}else{sql=sql+" and gongyingshang like '%"+request.getParameter("gongyingshang")+"%'";}
if (request.getParameter("caigoushijian1")==""  ||request.getParameter("caigoushijian1")==null ) {}else{sql=sql+" and caigoushijian >= '"+request.getParameter("caigoushijian1")+"'";}
if (request.getParameter("caigoushijian2")==""  ||request.getParameter("caigoushijian2")==null ) {}else {sql=sql+" and caigoushijian <= '"+request.getParameter("caigoushijian2")+"'";}
			sql+=" order by id desc";
double caigoushuliangz=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						caigoushuliangz=caigoushuliangz+Float.valueOf(RS_result.getString("caigoushuliang")).floatValue();

						
						
			 }
			%>
		共计入库数量:<%=caigoushuliangz%>； 
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="caigouList.do?page=1" >首页</a>
             <a href="caigouList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="caigouList.do?page=${page.page+1 }">下一页</a>
			<a href="caigouList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
