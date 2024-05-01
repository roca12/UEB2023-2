<%@page import="co.edu.unbosque.model.AlphanumericStringDTO"%>

<p>You are successfully logged in!</p>
<%
AlphanumericStringDTO bean=(AlphanumericStringDTO)request.getAttribute("user");
out.print("Welcome, "+bean.getName());
%>
