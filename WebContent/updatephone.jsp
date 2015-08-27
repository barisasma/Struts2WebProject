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
<title>Update Phone</title>
</head>
<body>
	<body>
	<s:include value="menu.jsp"></s:include>
	<!-- name,date,os,cpu,memory,display,physical; -->
	<center>
	<s:property value="message" />
	<s:form action="savephone">  
		<s:property value="name" /><br>
		<s:textfield cssClass="textbox" name="name" label="Cell Phone Name: " value="%{name}"></s:textfield>  
		<s:textfield cssClass="textbox" name="date" label="Release Date: " value="%{date}"></s:textfield>  
		<s:textfield cssClass="textbox" name="os" label="Operating System: " value="%{os}"></s:textfield>
		<s:textfield cssClass="textbox" name="cpu" label="CPU: " value="%{cpu}"></s:textfield>
		<s:textfield cssClass="textbox" name="memory" label="Memory: " value="%{memory}"></s:textfield>
		<s:textfield cssClass="textbox" name="display" label="Display: " value="%{display}"></s:textfield>
		<s:textfield cssClass="textbox" name="physical" label="Physical: " value="%{physical}"></s:textfield>
		<s:textfield cssClass="textbox" name="price" label="Price: " value="%{price}"></s:textfield> 
		<s:textfield cssClass="textbox" name="path" label="Image: " value="%{path}"></s:textfield> 
		<s:hidden name="id"></s:hidden><!-- id hidden olarak alinmali -->
		<s:submit cssClass="loginbutton" value="Update"></s:submit>  
	</s:form>  
	</center>
</body>
</body>
</html>