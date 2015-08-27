<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%> 
<html>
<head>
<style type="text/css">
@import url(style.css);
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
</head>
<body>
	<s:include value="menu.jsp"></s:include>
	
	<center>
	<s:property value="message" />
	<s:if test="#session.login=='true'">
	<s:form action="saveprofile">  
		<s:property value="name" /><br>
		<s:textfield cssClass="textbox" name="full_name" label="Full Name " value="%{user.full_name}"></s:textfield>  
		<s:textfield cssClass="textbox" name="e_mail" label="Mail " value="%{user.e_mail}"></s:textfield>
		<s:textfield cssClass="textbox" name="address" label="Address " value="%{user.address}"></s:textfield>
		<!-- id hidden olarak alinmali -->
		<s:hidden name="id"></s:hidden>
		<s:submit cssClass="loginbutton" value="Update"></s:submit>  
	</s:form> 
	</s:if> 
	</center>
	
</body>
</html>