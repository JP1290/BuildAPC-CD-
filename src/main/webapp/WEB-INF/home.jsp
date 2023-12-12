<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage = "true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

<div class = "background">

	<div>
	
		<h1>Build-A-PC</h1>
		
	</div>
	
	<div class = "all_builds">
	
		<h3>Everyone's Builds</h3>
	
		<div class = "top_links">
		
			<a href = "/build/add"><button>Add a Build</button></a>
		
			<a href = "/logout"><button>Logout</button></a>
			
		</div>
	
		<c:forEach var = "builds" items = "${builds}">
		
			<div class = "builds">
			
				<p><a href = "/builds/${builds.getId()}">${builds.getBuildName()}</a> Posted By: <c:out value = "${builds.getUser().getEmail()}"></c:out></p>
				
				
			</div>
			
		</c:forEach>
		
	</div>
	
</div>

</body>
</html>