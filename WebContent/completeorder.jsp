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
<title>Complete Order</title>
</head>
<body>
	
	
	<s:include value="menu.jsp"></s:include>
	<!-- name,date,os,cpu,memory,display,physical; -->
	<center><s:form action="completeorder">  
		<s:property value="name" /><br>
		<s:textfield cssClass="textbox" name="cardnumber" label="Credit Card Number: "></s:textfield>  
		<s:password cssClass="textbox" name="password" label="Password: "></s:password>  
		<s:textfield cssClass="textbox" name="cvc" label="CVC: " ></s:textfield>
		<s:textarea cssClass="textarea" name="address" label="Address "></s:textarea>
		<s:select cssClass="textbox"
			label="Shipment Channel" 
			headerKey="-1" headerValue="--- Select ---"
			list="shipment" 
			name="logistic"
		    />
		<s:property  value="#session.userID"/><!-- id hidden olarak alinmali -->
		<s:hidden name="customerId"></s:hidden>
		<s:submit cssClass="loginbutton" value="Purchase"></s:submit>  
	</s:form>  
	</center>
</body>
</html>