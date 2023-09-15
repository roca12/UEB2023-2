<%@page import="co.edu.unbosque.model.UserDTO"%>

<p>You are successfully logged in!</p>
<%
UserDTO bean=(UserDTO)request.getAttribute("user");
out.print("Welcome, "+bean.getName());
%>
