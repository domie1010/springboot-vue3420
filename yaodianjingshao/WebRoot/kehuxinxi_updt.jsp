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
		<TITLE>修改客户信息</TITLE>
	    
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
	document.location.href="kehuxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateKehuxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改客户信息<input type="hidden" name="id" value="${kehuxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">客户：</td><td><input name='kehu' type='text' id='kehu' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelkehu' /></td></tr>		<tr ><td width="200">性别：</td><td><select name='xingbie' id='xingbie'><option value="男">男</option><option value="女">女</option></select></td></tr>		<tr ><td width="200">联系手机：</td><td><input name='lianxishouji' type='text' id='lianxishouji' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabellianxishouji' /></td></tr>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.kehu.value='${kehuxinxi.kehu}';</script>	<script language="javascript">document.form1.xingbie.value='${kehuxinxi.xingbie}';</script>	<script language="javascript">document.form1.lianxishouji.value='${kehuxinxi.lianxishouji}';</script>	<script language="javascript">document.form1.dizhi.value='${kehuxinxi.dizhi}';</script>	<script language="javascript">document.form1.beizhu.value='${kehuxinxi.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var kehuobj = document.getElementById("kehu"); if(kehuobj.value==""){document.getElementById("clabelkehu").innerHTML="&nbsp;&nbsp;<font color=red>请输入客户</font>";return false;}else{document.getElementById("clabelkehu").innerHTML="  "; } 	var lianxishoujiobj = document.getElementById("lianxishouji"); if(lianxishoujiobj.value==""){document.getElementById("clabellianxishouji").innerHTML="&nbsp;&nbsp;<font color=red>请输入联系手机</font>";return false;}else{document.getElementById("clabellianxishouji").innerHTML="  "; } 	var lianxishoujiobj = document.getElementById("lianxishouji"); if(lianxishoujiobj.value!=""){ if(/^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxishoujiobj.value)){document.getElementById("clabellianxishouji").innerHTML=""; }else{document.getElementById("clabellianxishouji").innerHTML="&nbsp;&nbsp;<font color=red>必需手机格式</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
