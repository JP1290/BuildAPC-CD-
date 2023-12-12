<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

<div class = "background">

	<div>
	
		<h1>Build-A-PC</h1>
		
		
	
	</div>
	
	<div class = "register">
	
		<h4>Sign Up</h4>
		
		<form:form action = "/register" method = "post" modelAttribute = "newUser">
			
			<p>
				<form:errors class = "errors" path = "email"></form:errors>
				
			</p>
			
			<p>
			
				<form:label path = "email">Email:</form:label>
				
				<form:input class = "register_email_input" type = "email" path = "email"></form:input>
				
			</p>
			
			<p>
				
				<form:errors class = "errors" path = "password"></form:errors>
				
			</p>
			
			<p>
			
				<form:label path = "password">Password:</form:label>
				
				<form:password class = "register_pw_input" path = "password"></form:password>
				
			</p>
			
			<p>
			
				<form:errors class = "errors" path = "confirm"></form:errors>
				
			</p>
			
			<p>
			
				<form:label path = "confirm">Confirm PW:</form:label>
				
				<form:password path = "confirm"></form:password>
				
			</p>
			
			<input class = "register_button" type = "submit" value = "Register">
			
		</form:form>
		
		<div class = "main_page">
		
			<a href = "/">Go back</a>
			
		</div>
		
	</div>
	
</div>
	
</body>
</html>