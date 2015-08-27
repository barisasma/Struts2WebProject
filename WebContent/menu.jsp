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
<title>Insert title here</title>
</head>
<body>
 <!-- Here's all it takes to make this navigation bar. -->
   <ul id="nav">
      <li><a href="gotoHome.action">Home</a></li>
      <li>
      	<s:url action="query.action" var="products">
			<s:param name="where"></s:param>
	    </s:url>
      	<a href=<s:property value="#products" />>Products</a>
      </li>
      	
      	<s:url action="updateprofile" var="updatemyprofile">
				<s:param name="id" value="#session.userID"/>
		</s:url>
     <s:if test="#session.login=='true'">
     <li>
      	<a href=<s:property value="#updatemyprofile" />>Profile</a>
     </li>  
     </s:if>    
     	
    <s:if test="#session.isAdmin==2">
     	<li><s:a href="gonewphone.action">Register Phone</s:a></li>
    </s:if>
    
    <s:if test="#session.isAdmin==2">
     	<li><s:a href="phonelist.action">Phone List</s:a></li>
    </s:if>
    
     <s:if test="#session.isAdmin==1">
     	<li><s:a href="userlist.action">User List</s:a></li>
    </s:if>
    
    <s:if test="#session.login=='true'">
      <li><a href="logout.action">Logout</a></li>
    </s:if>
    <s:else>
   		<li><a href="login.jsp">Login</a></li>
   	</s:else>
    </ul>
   <!-- That's it! -->
</body>
</html>