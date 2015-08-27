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
</head>
<body>

      <center>
		<s:form action="login" method="post">  
		<s:textfield cssClass="logbox" name="username" label="Name"></s:textfield>  
		<s:password cssClass="logbox" name="userpass" label="Password"></s:password> 
		<s:submit cssClass="loginbutton" value="login"></s:submit>
		</s:form>  
		<p>if you don't have an account please <a href="registerin.action">register</a></p>
	  </center>

</body>
</html>