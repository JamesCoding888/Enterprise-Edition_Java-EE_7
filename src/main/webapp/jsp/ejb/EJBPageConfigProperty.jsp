<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EJBPage</title>
</head>
<body>
	<h1>HelloServlet4EJBConfigProperty Example</h1>
	<form action="/javaWebEE/HelloServlet4EJBConfigProperty" method="post">
		<label for="name">Enter your name:</label> <input type="text"
			id="name" name="name" required> <br>
		<button type="submit">Say Hello</button>
	</form>

	<%-- Display the result of the web service call --%>
	<%
        String message = (String) request.getAttribute("message");
        if (message != null && !message.isEmpty()) {
            out.println("<p>" + message + "</p>");
        }
    %>
</body>
</html>