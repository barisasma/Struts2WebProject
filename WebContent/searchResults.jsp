<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
<sx:head />
<style type="text/css">
@import url(style.css);
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cell Phones you've searched</title>
</head>
<body>	
	
	<div class="mycart">
	<s:if test="#session.isAdmin==0">
		<s:url action="showBasket.action" var="showbasket" >
			<s:param name="username" value="#session.name"/>
		</s:url>
		<a href="<s:property value="showbasket" />" >My Basket(<s:property value="#session.basketSize"/>)</a>
	</s:if>
	</div>
	<s:include value="menu.jsp"></s:include>
	<div class="content">
		<div class="paragraph">			
				<br />
				<span>Query: </span>
				<b><s:property value="where" /> </b>		
		</div>
		
		
			<div class="paragraph">				
				Cell Phone Details
				<p><s:property value="message" /></p>
			</div>
			<div class="sortmenuWrap">
				
				
				<s:url action="query" var="queryAZ">
						<s:param name="where" value="where"/>
						<s:param name="sortType">AZ</s:param>	
						<s:param name="page" value="page"/>
	 		    </s:url>
	 		    <s:url action="query" var="queryZA">
						<s:param name="where" value="where"/>
						<s:param name="sortType">ZA</s:param>
						<s:param name="page" value="page"/>	
	 		    </s:url>
	 		    <s:url action="query" var="queryInc">
						<s:param name="where" value="where"/>
						<s:param name="sortType">Inc</s:param>	
			            <s:param name="page" value="page"/>
	 		    </s:url>
	 		    <s:url action="query" var="queryDec">
						<s:param name="where" value="where"/>
						<s:param name="sortType">Dec</s:param>	
						<s:param name="page" value="page"/>
	 		    </s:url>
				<s:a cssClass="updateButton" href="%{queryAZ}">Name Alfabethical A-Z</s:a>
				<s:a cssClass="updateButton" href="%{queryZA}">Name Alfabethical Z-A</s:a>
				<s:a cssClass="updateButton" href="%{queryInc}">Price Increasing</s:a>
				<s:a cssClass="updateButton" href="%{queryDec}">Price Decreasing</s:a>
			</div>
			<div class="page">
				<s:iterator value="initialPhones" status="stats">
				<s:if test="%{#stats.index<10}"> 	
					<div class="box">
					<s:hidden name="haveid" value="ID" />
					<table class="cellPhoneTable">	
					<tr>
						<s:url action="phoneDetail" var="phoneDetail">
							    <s:param name="phoneid" value="ID"/>
 						</s:url>
						<th colspan="2"><s:a href="%{phoneDetail}"><img src="<s:property value="path"/>" width="200px" height="200px"></s:a></th>
					</tr>					
					<tr>
						<th><s:property value="name" /> </th>
					</tr>
					<tr>
						<th><h1 class="tablePrice"><s:property value="price" /> TL </h1></th>
					</tr>
					<s:if test="#session.isAdmin==2">	
						<tr>
						<td colspan="2">
							<s:url action="updatephone" var="updatedphone">
							    <s:param name="id" value="ID"/>
							</s:url><s:a cssClass="updateButton" href="%{updatedphone}">Update</s:a>
						</td>
						</tr>
					</s:if>
					<s:elseif test="#session.isAdmin==0">
						<tr>
						
						<td colspan="2">
							<s:url action="addchart" var="addtochart">
							    <s:param name="id" value="ID"/>
							    <s:param name="where" value="where"></s:param>
							    <s:param name="username" value="#session.name"/>
							    <s:param name="price" value="price"/>
							    <s:param name="page" value="page"/>
							    <s:param name="customerID" value="#session.userID"/>
							    <s:param name="productName" value="name"/>
 							</s:url>
							<s:a cssClass="updateButton" href="%{addtochart}">Add to Chart</s:a>
						</td>
						</tr>
					</s:elseif>
					</table>	
					<!--<s:property value="%{#stats.index}" />-->				
				</div>
				</s:if>
			</s:iterator>
			  
		</div>
		
		<!--<s:property value="cellphones.size()"/> -->
	
	</div>
	
	<span class="paragraph">Pages</span>
		<table class="paging">
		<tr>
			<s:iterator value="numberOfPages">
			 <s:url action="query" var="handlepage">
						<s:param name="where" value="where"/>
						<s:param name="handlePaging" value="true"/>
						<s:param name="page"><s:property/></s:param>
	 		</s:url>
				<td><p class="paragraph"><s:a href="%{handlepage}"><s:property/></s:a></p></td>
			</s:iterator>
		</tr>
		</table>	
</body>
</html>