<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<style type="text/css">
@import url(style.css);
</style>
<s:head />
<title>Search Cell Phones</title>
</head>
<body>
	<div class="wrapper">
	<div class="chartbar">
	<s:if test="#session.isAdmin==0">
		<div class="mycart">
		<s:url action="showBasket.action" var="showbasket" >
			<s:param name="username" value="#session.name"/>
		</s:url>
		<a href="<s:property value="showbasket" />" >My Basket</a>
		</div>
	</s:if>
	</div>
	<s:include value="menu.jsp"></s:include>
	<div class="header">
	  <s:if test="#session.login=='true'">
	  	<p class="welcome">Welcome <s:property value="#session.name"/></p>
	  </s:if>
	</div>
			    <p class="paragraph">Search Cell Phone Brands and Models</p>
				
				<s:iterator value="dummyPhoneList">
				<s:url action="phoneDetail" var="phoneDetail">
							    <s:param name="phoneid" value="ID"/>
 				</s:url>
				<div class="randomPhone">
					<table>
						<tr><th><h3><s:property value="name" /></h3></th></tr>
						<tr><th><s:a href="%{phoneDetail}"><img src="<s:property value="path"/>" width="200px" height="200px"></s:a><th></tr>
					</table>
				</div>
				</s:iterator>
				
						
				<s:url action="query.action" var="searchSamsung">
					<s:param name="where">SAMSUNG</s:param>
				</s:url>
				<s:url action="query.action" var="searchLG">
					<s:param name="where">LG</s:param>
				</s:url>
				<s:url action="query.action" var="searchSony">
					<s:param name="where">SONY</s:param>
				</s:url>
				<s:url action="query.action" var="searchApple">
					<s:param name="where">APPLE</s:param>
				</s:url>
				<s:url action="query.action" var="searchHtc">
					<s:param name="where">HTC</s:param>
				</s:url>
				<s:url action="query.action" var="searchAsus">
					<s:param name="where">ASUS</s:param>
				</s:url>
				<s:url action="query.action" var="searchNexus">
					<s:param name="where">NEXUS</s:param>
				</s:url>
								
			<div class="brands">
				<table class="brandTable">
					 <tr>
					    <th><s:a href="%{searchSamsung}" >Samsung</s:a></th>
					    <th><s:a href="%{searchLG}" >LG</s:a></th>
					    <th><s:a href="%{searchApple}" >Apple</s:a></th>
					    <th><s:a href="%{searchAsus}">Asus</s:a></th>
					    <th><s:a href="%{searchHtc}" >HTC</s:a></th>
					    <th><s:a href="%{searchSony}" >Sony</s:a></th>
					    <th><s:a href="%{searchNexus}" >Nexus</s:a></th>
					  </tr>
				</table>
			</div>
		
			<div class="query" align="center">
				<s:form action="query">
					<s:textfield name="where" cssClass="queryField" />
					<s:submit value="Search !!" cssClass="searchButton" />
				</s:form>
			</div>
	</div>
</body>
</html>