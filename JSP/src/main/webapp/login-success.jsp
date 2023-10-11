<%@page import="co.edu.unbosque.model.User"%>

<p>You are successfully logged in!</p>
<%
User bean=(User)request.getAttribute("user");
out.print("Welcome, "+bean.getName());

%>
