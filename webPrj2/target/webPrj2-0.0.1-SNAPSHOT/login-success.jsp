<%@page import="co.edu.unbosque.model.User"%>

<p>You are successfully logged in!</p>
<%
User bean=(User)request.getAttribute("bean");
out.print("Welcome, "+bean.getName());
%>
