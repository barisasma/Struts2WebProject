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
<title>My Orders</title>
</head>
<body>
	
	<s:include value="menu.jsp"></s:include>
	<div class="wrapper">
		<s:if test="orders.size() > 0">
			<p class="paragraph">
				<s:text name="orders" />
			</p>
			
			<table class="basketTable">
				<tr class="even">
					<td><b>Address</b></td>
					<td><b>Logistics</b></td>
					<td><b>Total</b></td>
				</tr>
				<s:iterator value="orders" status="index">
					<tr
						class="odd">
						<td><s:property value="adress" /></td>
						<td><s:property value="logistic"/></td>
						<td><s:property value="total" /></td>
						<td>
							<s:url action="orderdetails" var="showDetails">
								<s:param name="orderID" value="orderID"/>
							</s:url> <s:a id="newval" cssClass="updateButton" href="%{showDetails}" >Details</s:a>			
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:else>
			<p class="paragraph">
				<s:text name="noPhones" />
			</p>
		</s:else>
		
		<!--<s:property value="cellphones.size()"/> -->
			
		</div>

	
</body>
</html>