<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% out.println("hellowrold"); %> <%-- "out.println() no help ~" --%>
	
	
	<% out.print(new Date()); %>
	<br>
	<% out.print(new java.util.Date()); %>
	<p>
	<%= new Date() %> <!-- equals to out.print(new Date()) -->
	
</body>
</html>