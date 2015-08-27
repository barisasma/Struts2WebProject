<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<script>
function myFunction(obj) {   		
        var inputValue=prompt("Please enter quantity");
        if (inputValue!=null){
           obj.href += '&quantity='+inputValue;
        }
        else
        	null;
}
</script>
<sx:head />
<style type="text/css">
@import url(style.css);
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Basket</title>
</head>
<body>	
	
	<s:include value="menu.jsp"></s:include>
	<div class="wrapper">
		<s:if test="Mybasket.size() > 0">
			<p class="paragraph">
				<s:text name="list" />
			</p>
			
			<table class="basketTable">
				<tr class="even">
					<td><b>Name</b></td>
					<td><b>Quantity</b></td>
					<td><b>Price</b></td>
				</tr>
				<s:iterator value="Mybasket" status="index">
					<tr
						class="<s:if test="#index.odd == true ">odd</s:if><s:else>even</s:else>">
						<td><s:property value="productName" /></td>
						<td><s:property value="Quantity"/></td>
						<td><s:property value="price" /></td>
						<td><s:url action="remove" var="removed">
								<s:param name="id" value="productId"/>
							    <s:param name="username" value="#session.name"/>
							</s:url> <s:a cssClass="updateButton" href="%{removed}">Remove</s:a>
						</td>
						<td>
							<s:url action="updateQuantity" var="updateQ">
								<s:param name="id" value="productId"/>
							    <s:param name="username" value="#session.name"/>
							</s:url> <s:a id="newval" cssClass="updateButton" href="%{updateQ}" onclick="myFunction(this)">Update</s:a>			
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
		<div class="totalPrice"><h3>Your Total Price: <s:property value="totalPrice"/></h3></div>
		<div class="totalPrice">
		<s:url action="goorder" var="gorderv">
			<s:param name="customerId" value="#session.userID"/>
	    </s:url>
		<s:a cssClass="updateButton" href="%{gorderv}">Complete Purchase</s:a></div>
	</div>

</body>
</html>