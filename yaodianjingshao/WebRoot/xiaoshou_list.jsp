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
	<TITLE>出库查询</TITLE>
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
							<td colspan="17" background="images/table_header.gif">出库列表</td>
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
								<form action="xiaoshouList.do" name="myform" method="post">
									查询   药品编号：<input name="shangpinbianhao" type="text" id="shangpinbianhao" style='border:solid 1px #000000; color:#666666' size="12" />  药品名称：<input name="shangpinmingcheng" type="text" id="shangpinmingcheng" style='border:solid 1px #000000; color:#666666' size="12" />  类别：<input name="leibie" type="text" id="leibie" style='border:solid 1px #000000; color:#666666' size="12" /> 客户：<select name='kehu' id='kehu' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><%=connDbBean.hsggetoption("kehuxinxi","kehu")%></select>  出库时间：<input name="xiaoshoushijian1" type="text" id="xiaoshoushijian1"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />-<input name="xiaoshoushijian2" type="text" id="xiaoshoushijian2"  value='' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:80px; height:20px; border:solid 1px #000000; color:#666666' />
									<input type="submit" value="查询" />
								<input type=button name=Submit54 value=添加出库出库 onClick="javascript:location.href='xiaoshou_add.jsp'" /></form>								</td>
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
    <td align='center'>客户</td>
    <td align='center'>出库数量</td>
    <td  width='65' align='center'>出库时间</td>
    <td align='center'>出库员</td>
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
    <td>${u.kehu}</td>
    <td>${u.xiaoshoushuliang}</td>
    <td>${u.xiaoshoushijian}</td>
    <td>${u.xiaoshouyuan}</td>
    <td>${u.tuihuoshuliang}</td>
    <td>${u.tuihuoyuanyin}</td>
    
                              <td align="center"> ${u.addtime } </td>
                              <td align="center"><a href="doUpdateXiaoshoulb.do?id=${u.id }">退货</a> <a href="doUpdateXiaoshou.do?id=${u.id }">编辑</a>  <a href="deleteXiaoshou.do?id=${u.id }"
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
			String sql="select * from xiaoshou where 1=1 ";
				
if(request.getParameter("shangpinbianhao")=="" ||request.getParameter("shangpinbianhao")==null ){}else{String nshangpinbianhao=new String(request.getParameter("shangpinbianhao").getBytes("8859_1"));if(nshangpinbianhao.contains("?")){nshangpinbianhao=request.getParameter("shangpinbianhao");}sql=sql+" and shangpinbianhao like '%"+nshangpinbianhao+"%'";}
if(request.getParameter("shangpinmingcheng")=="" ||request.getParameter("shangpinmingcheng")==null ){}else{String nshangpinmingcheng=new String(request.getParameter("shangpinmingcheng").getBytes("8859_1"));if(nshangpinmingcheng.contains("?")){nshangpinmingcheng=request.getParameter("shangpinmingcheng");}sql=sql+" and shangpinmingcheng like '%"+nshangpinmingcheng+"%'";}
if(request.getParameter("leibie")=="" ||request.getParameter("leibie")==null ){}else{String nleibie=new String(request.getParameter("leibie").getBytes("8859_1"));if(nleibie.contains("?")){nleibie=request.getParameter("leibie");}sql=sql+" and leibie like '%"+nleibie+"%'";}
if(request.getParameter("kehu")=="" ||request.getParameter("kehu")==null ){}else{sql=sql+" and kehu like '%"+request.getParameter("kehu")+"%'";}
if (request.getParameter("xiaoshoushijian1")==""  ||request.getParameter("xiaoshoushijian1")==null ) {}else{sql=sql+" and xiaoshoushijian >= '"+request.getParameter("xiaoshoushijian1")+"'";}
if (request.getParameter("xiaoshoushijian2")==""  ||request.getParameter("xiaoshoushijian2")==null ) {}else {sql=sql+" and xiaoshoushijian <= '"+request.getParameter("xiaoshoushijian2")+"'";}
			sql+=" order by id desc";
double xiaoshoushuliangz=0;
							
							
			ResultSet RS_result=connDbBean.executeQuery(sql);
while(RS_result.next()){
				
						
						xiaoshoushuliangz=xiaoshoushuliangz+Float.valueOf(RS_result.getString("xiaoshoushuliang")).floatValue();

						
						
			 }
			%>
		共计出库数量:<%=xiaoshoushuliangz%>； 
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="xiaoshouList.do?page=1" >首页</a>
             <a href="xiaoshouList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="xiaoshouList.do?page=${page.page+1 }">下一页</a>
			<a href="xiaoshouList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
