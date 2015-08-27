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
<title><s:property value="cellphone.name" /></title>
</head>
<body>
	<s:include value="menu.jsp"></s:include>
<div class="mycart">
	<s:if test="#session.isAdmin==0">
		<s:url action="showBasket.action" var="showbasket" >
			<s:param name="username" value="#session.name"/>
		</s:url>
		<a href="<s:property value="showbasket" />" >My Basket(<s:property value="#session.basketSize"/>)</a>
	</s:if>
	</div>
	

	<div class="paragraph">	<s:property value="message"/></div>
	<div class="bigbox">
					<s:property value="ID" />
					<table class="cellPhoneTablebig">	
					<tr>
						<th colspan="2"><img src="<s:property value="cellphone.path"/>" width="300" height="300"></th>
					</tr>					
					<tr>
						<th>Name: </th>
						<th><s:property value="cellphone.name" /> </th>
					</tr>
					<tr>
						<th>Release Date: </th>
						<th><s:property value="cellphone.date" /></th>
					</tr>
					<tr>
						<th>OS: </th>
						<th><s:property value="cellphone.ops" /></th>
					</tr>
					<tr>
						<th>CPU: </th>
						<th><s:property value="cellphone.cpu" /></th>
					</tr>
					<tr>
						<th>Memory: </th>
						<th><s:property value="cellphone.memory" /></th>
					</tr>
					<tr>
						<th>Display: </th>
						<th><s:property value="cellphone.display" /></th>
					</tr>
					<tr>
						<th>Physical: </th>
						<th><s:property value="cellphone.physical" /></th>
					</tr>
					<tr>
						<th>Price: </th>
						<th><s:property value="cellphone.price" /></th>
					</tr>
					<s:hidden name="where" value="where" />
					<s:if test="#session.isAdmin==2">	
						<tr>
						<td colspan="2">
							<s:url action="updatephone" var="updatedphone">
							    <s:param name="id" value="phoneid"/>
							</s:url><s:a cssClass="addtoChartBig" href="%{updatedphone}">Update</s:a>
						</td>
						</tr>
					</s:if>
					<s:elseif test="#session.isAdmin==0">
						<tr>
						<td colspan="2">
							<s:url action="addchart" var="addtochart">
							    <s:param name="id" value="phoneid"/>
							    <s:param name="username" value="#session.name"/>
							    <s:param name="price" value="cellphone.price"/>
							    <s:param name="customerID" value="#session.userID"/>
							    <s:param name="productName" value="cellphone.name"/>
							    <s:param name="isDetail">Yes</s:param> 
 							</s:url>
							<s:a cssClass="addtoChartBig" href="%{addtochart}">Add to Chart</s:a>
						</td>
						</tr>
					</s:elseif>
					</table>	
			</div>

</body>
</html>