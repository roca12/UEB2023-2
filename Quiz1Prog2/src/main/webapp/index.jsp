<%@page import="java.io.Writer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz1</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>

<link
	href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css"
	rel="stylesheet">
<script
	src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

</head>
<body>
	<form action="alphanumericstringservlet" method="post">
		Name:<input type="text" name="texto"> <br>
		<br> <input type="submit" value="Verificar">
	</form>

	<form action="alphanumericstringservlet" method="get">
		<br> <input type="submit" value="Get list">
	</form>
	
	<form action="countservlet" method="get">
		<br> <input type="submit" value="Get count">
	</form>
	


</body>
</html>