<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>  
<html>
<head>
<script type="text/javascript">
<!--
function delayer(){
    window.location = "login.jsp"
}
//-->
</script>
<style type="text/css">
@import url(style.css);
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register a new phone</title>
</head>
<body>
	<s:include value="menu.jsp"></s:include>
	<!-- name,date,os,cpu,memory,display,physical; -->
	<center>
	<s:if test="#session.isAdmin==2">
	<s:property value="message"/>
	<s:form action="newphone">  
		<s:textfield cssClass="textbox" name="name" label="Cell Phone Name "></s:textfield>  
		<s:textfield cssClass="textbox" name="date" label="Release Date "></s:textfield>  
		<s:textfield cssClass="textbox" name="os" label="Operating System "></s:textfield>
		<s:textfield cssClass="textbox" name="cpu" label="CPU "></s:textfield>
		<s:textfield cssClass="textbox" name="memory" label="Memory "></s:textfield>
		<s:textfield cssClass="textbox" name="display" label="Display "></s:textfield>
		<s:textfield cssClass="textbox" name="physical" label="Physical "></s:textfield>
		<s:textfield cssClass="textbox" name="price" label="Price "></s:textfield> 
		<s:select cssClass="textbox"
			label="Brand" 
			headerKey="-1" headerValue="--- Select ---"
			list="brands" 
			name="brand"
		    />
		<s:textfield cssClass="textbox" name="image" label="Image "></s:textfield>
		<s:submit cssClass="loginbutton" value="register"></s:submit>  
	</s:form>
	</s:if>
	<s:else><body onLoad="setTimeout('delayer()', 3000)">
			<p>You do not have authorization to see this page
			<br>You will be directed log in page</p></body>
			
	</s:else>
	</center>  
</body>
</html>