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
<title>Customer List</title>
</head>
<body>

<s:include value="menu.jsp"></s:include>
	
	<s:if test="#session.isAdmin==1">
	<div class="wrapper">
		<s:if test="users.size() > 0">
			<p class="paragraph">
				<s:text name="list" />
			</p>
			
			<table class="basketTable">
				<tr class="even">
					<td><b>User Name</b></td>
					<td><b>Full Name</b></td>
					<td><b>E-Mail</b></td>
					<td><b>Type</b></td>
					<td><b>Active</b></td>
				</tr>
				<s:iterator value="users" status="index">
					<tr
						class="<s:if test="#index.odd == true ">odd</s:if><s:else>even</s:else>">
						<td><s:property value="username" /></td>
						<td><s:property value="full_name" /></td>
						<td><s:property value="e_mail" /></td>
						<td><s:if test="status==0">
								Customer
							</s:if>
							<s:elseif test="status==2">Shopkeeper</s:elseif>
						</td>
						<td><s:url action="useractivity" var="useractiviy">
								<s:param name="id" value="id"/>
							</s:url> <s:a cssClass="updateButton" href="%{useractiviy}"><s:property value="active"/></s:a>
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
		</div>
	       </s:if>


</body>
</html>