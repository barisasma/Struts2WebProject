<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %> 
<html>
<head>
<style type="text/css">
@import url(style.css);
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Open New Account</title>
</head>
<body>
	<!-- 
    username varchar(255) not null,
    pass	varchar(255) not null,
    full_name varchar(255) not null,
    e_mail varchar(255) not null,
    adress varchar(255) not null,
	 -->

	<center>
	<s:form action="createaccount">  
		<s:textfield cssClass="textbox" name="username" label="User Name"></s:textfield>  
		<s:password cssClass="textbox" name="pass" label="Password"></s:password>  
		<s:password cssClass="textbox" name="confirmpass" label="Confirm Password"></s:password>  
		<s:textfield cssClass="textbox" name="fullname" label="Full Name"></s:textfield>
		<s:textfield cssClass="textbox" name="email" label="E-Mail"></s:textfield>
		<s:textarea cssClass="textbox" name="address" label="Address"></s:textarea>
		<s:submit cssClass="loginbutton" value="Register"></s:submit>  
	</s:form>
	
	</center>  
	
</body>
</html>