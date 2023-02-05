<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
	  <title>isErrorPage and errorPage page directive example</title>
	</head>
	<body>
               	<h3>Hello this is an isErrorPage and 
                    errorPage page directive example.</h3>
		<br/>
		<h3>Some exception occurred.</h3>
		Exception: <%=exception %>
	</body>
</html>