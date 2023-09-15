<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%-- anything but a closing tag here will be ignored --%>
	<!-- HTML comments hereMath.random()m() %> more comments -->
	
	<% if(true){
		out.write(new Date());
	} %>
	
	<p>
		The square root of 5 is
		<%=Math.sqrt(5)%>
	</p>
	
	<p>
		Current time is:
		<%=new java.util.Date()%></p>
	<form action="ControllerServlet" method="post">
		Name:<input type="text" name="name"><br> Password:<input
			type="password" name="password"><br> <input
			type="submit" value="login">
	</form>
</body>
</html>