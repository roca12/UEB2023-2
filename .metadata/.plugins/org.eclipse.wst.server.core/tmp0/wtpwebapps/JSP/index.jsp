<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="shortcut icon" href="icon.ico" type="image/x-icon" />

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" ></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>

<link href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" rel="stylesheet" >
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

</head>
<body>
	<%-- anything but a closing tag here will be ignored --%>
	<!-- HTML comments hereMath.random()m() %> more comments -->

	<%
	if (true) {
		out.write(new Date().toString());
	}
	%>

	<p>
		The square root of 5 is
		<%=Math.sqrt(5)%>
	</p>

	<p>
		Current time is:
		<%=new Date()%></p>
	<form action="ControllerServlet" method="post">
		Name:<input type="text" name="name"><br> Password:<input
			type="password" name="password"><br> <input
			type="submit" value="login">
	</form>
	
	<form action="ControllerServlet" method="get">
		<br> <input type="submit" value="Get list">
	</form>
	
	
</body>
</html>