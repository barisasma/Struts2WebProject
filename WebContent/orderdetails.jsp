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
<title>Order Details</title>
</head>
<body>
	<s:include value="menu.jsp"></s:include>
	<table class="basketTable">
				<tr class="odd">
					<td><b>Product Name</b></td>
					<td><b>Price</b></td>
					<td><b>Quantity</b></td>
				</tr>
				<s:iterator value="orderDetails" status="index">
					<tr
						class="even">
						<td><s:property value="myPhone.getName()" /></td>
						<td><s:property value="myPhone.getPrice()"/></td>
						<td><s:property value="quantity" /></td>
					</tr>
				</s:iterator>
			</table>

</body>
</html>