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
		<TITLE>修改供应商信息</TITLE>
	    
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
	document.location.href="gongyingshangxinxi_add.jsp?id=<%=id%>";
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
			<form action="updateGongyingshangxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">修改供应商信息<input type="hidden" name="id" value="${gongyingshangxinxi.id}" /></td>
						</tr>
						<tr ><td width="200">供应商：</td><td><input name='gongyingshang' type='text' id='gongyingshang' value='' onblur='hsgcheck()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelgongyingshang' /></td></tr>		<tr ><td width="200">负责人：</td><td><input name='fuzeren' type='text' id='fuzeren' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelfuzeren' /></td></tr>		<tr ><td width="200">联系手机：</td><td><input name='lianxishouji' type='text' id='lianxishouji' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;<label id='clabellianxishouji' />必需手机格式</td></tr>		<tr ><td width="200">地址：</td><td><input name='dizhi' type='text' id='dizhi' value='' onblur='' size='50' style='border:solid 1px #000000; color:#666666' /></td></tr>		<tr ><td width="200">备注：</td><td><textarea name='beizhu' cols='50' rows='5' id='beizhu' onblur='' style='border:solid 1px #000000; color:#666666' ></textarea></td></tr>		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
						<script language="javascript">document.form1.gongyingshang.value='${gongyingshangxinxi.gongyingshang}';</script>	<script language="javascript">document.form1.fuzeren.value='${gongyingshangxinxi.fuzeren}';</script>	<script language="javascript">document.form1.lianxishouji.value='${gongyingshangxinxi.lianxishouji}';</script>	<script language="javascript">document.form1.dizhi.value='${gongyingshangxinxi.dizhi}';</script>	<script language="javascript">document.form1.beizhu.value='${gongyingshangxinxi.beizhu}';</script>	
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var gongyingshangobj = document.getElementById("gongyingshang"); if(gongyingshangobj.value==""){document.getElementById("clabelgongyingshang").innerHTML="&nbsp;&nbsp;<font color=red>请输入供应商</font>";return false;}else{document.getElementById("clabelgongyingshang").innerHTML="  "; } 	var fuzerenobj = document.getElementById("fuzeren"); if(fuzerenobj.value==""){document.getElementById("clabelfuzeren").innerHTML="&nbsp;&nbsp;<font color=red>请输入负责人</font>";return false;}else{document.getElementById("clabelfuzeren").innerHTML="  "; } 	var lianxishoujiobj = document.getElementById("lianxishouji"); if(lianxishoujiobj.value!=""){ if(/^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/.test(lianxishoujiobj.value)){document.getElementById("clabellianxishouji").innerHTML=""; }else{document.getElementById("clabellianxishouji").innerHTML="&nbsp;&nbsp;<font color=red>必需手机格式</font>"; return false;}}      


return true;   
}   
popheight=450;
</script>  
