<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage = "true" %>


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
	
	<div class = "one_build">
	
		<h4>Build By: <c:out value = "${builds.getUser().getEmail()}"></c:out></h4>
		
		<div class = "top_links">
		
			<a href = "/home"><button>Dashboard</button></a>
		
			<a href = "/logout"><button>Logout</button></a>
		
		</div>
	
		<table class = "show_one_build">
		
			<thead>
			
				<tr>
				
					<th>Part</th>
					
					<th>Choice</th>
					
					<th>Store</th>
					
					<th>Price</th>
					
				</tr>
				
			</thead>
			
			<tbody>
			
				<tr>
				
					<td>CPU</td>
					
					<td><c:out value = "${cpus.choice}"></c:out></td> 
					
					<td><c:out value = "${cpus.store}"></c:out></td>
					
					<td><c:out value = "${cpus.price}"></c:out></td>
					
				</tr>
				
				<tr>
				
					<td>Cooler</td>
					
					<td><c:out value = "${cooler.choice}"></c:out></td> 
					
					<td><c:out value = "${cooler.store}"></c:out></td>
					
					<td><c:out value = "${cooler.price}"></c:out></td>
					
				</tr>
				
				<tr>
				
					<td>Motherboard</td>
					
					<td><c:out value = "${mobo.choice}"></c:out></td> 
					
					<td><c:out value = "${mobo.store}"></c:out></td>
					
					<td><c:out value = "${mobo.price}"></c:out></td>
					
				</tr>
				
				<tr>
				
					<td>RAM</td>
					
					<td><c:out value = "${rams.choice}"></c:out></td> 
					
					<td><c:out value = "${rams.store}"></c:out></td>
					
					<td><c:out value = "${rams.price}"></c:out></td>
					
				</tr>
				
				<tr>
				
					<td>GPU</td>
					
					<td><c:out value = "${gpus.choice}"></c:out></td> 
					
					<td><c:out value = "${gpus.store}"></c:out></td>
					
					<td><c:out value = "${gpus.price}"></c:out></td>
					
				</tr>
				
				<tr>
				
					<td>PSU</td>
					
					<td><c:out value = "${psus.choice}"></c:out></td> 
					
					<td><c:out value = "${psus.store}"></c:out></td>
					
					<td><c:out value = "${psus.price}"></c:out></td>
					
				</tr>
				
				<tr>
				
					<td>Case</td>
					
					<td><c:out value = "${cases.choice}"></c:out></td> 
					
					<td><c:out value = "${cases.store}"></c:out></td>
					
					<td><c:out value = "${cases.price}"></c:out></td>
					
				</tr>
			
			</tbody>
		
		</table>
		
		<h5>Total: $<c:out value = "${total}"></c:out></h5>
		
		<div class = "bottom_links">
		
			<c:if test = "${user == builds.getUser().getId()}">
				
				<a href = "/builds/${builds.getId()}/edit"><button>Edit</button></a>
					
				<a class = "move_link_left" href = "/builds/${builds.getId()}/delete"><button>Delete</button></a>
		
			</c:if>
		
		</div>
		
	</div>
	
</div>

</body>
</html>