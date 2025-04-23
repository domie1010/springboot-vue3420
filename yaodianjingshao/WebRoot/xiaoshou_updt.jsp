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
		<TITLE>修改出库</TITLE>
	    
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
       
	</head>
<%
  String id="";
 
   %>
<script language="javascript">

function gows()
{
	document.location.href="xiaoshou_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="updateXiaoshou.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改出库<input type="hidden" name="id" value="${xiaoshou.id}" /></td>
						</tr>
						<tr ><td width="200">药品编号：</td><td><select name='shangpinbianhao' id='shangpinbianhao' style='height:20px; border:solid 1px #000000; color:#666666' onChange='gows();'><%=connDbBean.hsggetoption2("shangpinxinxi","shangpinbianhao")%></select>&nbsp;*<label id='clabelshangpinbianhao' /></td></tr>
		<tr ><td width="200">药品名称：</td><td><input name='shangpinmingcheng' type='text' id='shangpinmingcheng' style='border:solid 1px #000000; color:#666666' >&nbsp;*<label id='clabelshangpinmingcheng' /></td></tr>
		<tr ><td width="200">类别：</td><td><input name='leibie' type='text' id='leibie' style='border:solid 1px #000000; color:#666666' ></td></tr>
		<tr ><td width="200">库存：</td><td><input name='kucun' type='text' id='kucun' style='border:solid 1px #000000; color:#666666' ></td></tr>
		<tr ><td width="200">客户：</td><td><select name='kehu' id='kehu' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption("kehuxinxi","kehu")%></select></td></tr>
		<tr ><td width="200">出库数量：</td><td><input name='xiaoshoushuliang' type='text' id='xiaoshoushuliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabelxiaoshoushuliang' />必需数字型</td></tr>
		<tr ><td width="200">出库时间：</td><td><input name='xiaoshoushijian' type='text' id='xiaoshoushijian' value='<%=connDbBean.getdate()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/></td></tr>
		<tr ><td width="200">出库员：</td><td><input name='xiaoshouyuan' type='text' id='xiaoshouyuan' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		<tr style='display:none'><td width="200">退货数量：</td><td><input name='tuihuoshuliang' type='text' id='tuihuoshuliang' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr 0><td width="200">退货原因：</td><td><textarea name='tuihuoyuanyin' cols='50' rows='5' id='tuihuoyuanyin' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.shangpinbianhao.value='${xiaoshou.shangpinbianhao}';</script>
	<script language="javascript">document.form1.shangpinmingcheng.value='${xiaoshou.shangpinmingcheng}';</script>
	<script language="javascript">document.form1.leibie.value='${xiaoshou.leibie}';</script>
	<script language="javascript">document.form1.kucun.value='${xiaoshou.kucun}';</script>
	<script language="javascript">document.form1.kehu.value='${xiaoshou.kehu}';</script>
	<script language="javascript">document.form1.xiaoshoushuliang.value='${xiaoshou.xiaoshoushuliang}';</script>
	<script language="javascript">document.form1.xiaoshoushijian.value='${xiaoshou.xiaoshoushijian}';</script>
	<script language="javascript">document.form1.xiaoshouyuan.value='${xiaoshou.xiaoshouyuan}';</script>
	<script language="javascript">document.form1.tuihuoshuliang.value='${xiaoshou.tuihuoshuliang}';</script>
	<script language="javascript">document.form1.tuihuoyuanyin.value='${xiaoshou.tuihuoyuanyin}';</script>
	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var shangpinbianhaoobj = document.getElementById("shangpinbianhao"); if(shangpinbianhaoobj.value==""){document.getElementById("clabelshangpinbianhao").innerHTML="&nbsp;&nbsp;<font color=red>请输入药品编号</font>";return false;}else{document.getElementById("clabelshangpinbianhao").innerHTML="  "; } 
	var shangpinmingchengobj = document.getElementById("shangpinmingcheng"); if(shangpinmingchengobj.value==""){document.getElementById("clabelshangpinmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入药品名称</font>";return false;}else{document.getElementById("clabelshangpinmingcheng").innerHTML="  "; } 
	
    if(parseInt(document.form1.kucun.value)<parseInt(document.form1.xiaoshoushuliang.value)){alert("对不起，库存必需大于出库数量");return false;}
	


return true;   
}   
popheight=450;
</script>  
