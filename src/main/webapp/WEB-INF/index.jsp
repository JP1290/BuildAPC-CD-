<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

<div class = "background">

	<div>
	
		<h1>Build-A-PC</h1>
	
	</div>
	
	<div class = "login">
	
		<h4>Login</h4>
		
		<form:form action = "/login" method = "post" modelAttribute = "newLogin">
		
			<p>
			
				<form:errors class = "errors" path = "email"></form:errors>
				
			</p>
			
			<p>
			
				<form:label path = "email">Email:</form:label>
				
				<form:input class = "login_input" type = "text" path = "email"></form:input>
				
			</p>
			
			<p>
			
				<form:errors class = "errors" path = "password"></form:errors>
				
			</p>
			
			<p>
			
				<form:label path = "password">Password:</form:label>
				
				<form:password path = "password"></form:password>
				
			</p>
			
			<input class = "login_button" type = "submit" value = "Login">
			
		</form:form>
		
		<div class = "registerLink">
	
			<p>Don't have an account? <a href = "/register">Register here</a></p>
	
		</div>
		
	</div>
	
	
	
</div>
	
</body>
</html>