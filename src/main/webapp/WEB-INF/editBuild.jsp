<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage = "true" %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edit a Build</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

<div class = "background">

	<div>
	
		<h1>Build-A-PC</h1>
	
	</div>
	
	<div class = "add_build">
	
		<h4>Edit a Build</h4>
		
		<div class = "top_links">
		
			<a href = "/home"><button>Dashboard</button></a>
			
			<a href = "/logout"><button>Logout</button></a>
		
		</div>
	
		<form:form action = "/builds/${builds.getId()}/edit" method = "post" modelAttribute = "builds">
		
			<p>
			
				<form:errors class = "errors" path = "buildName"></form:errors>
				
			</p>
			
			<p>
			
				<form:label path = "buildName">Name of Build: </form:label>
				
				<form:input type = "text" path = "buildName"></form:input>
				
			</p>
			
			<p>
				
				<form:label path = "CPU">CPU: </form:label>
				
				<form:select path = "CPU">
				
					<form:option value = "NONE">--SELECT--</form:option>
					
					<c:forEach var = "cpus" items = "${cpus}">
					
						<form:option value = "${cpus.getId()}">${cpus.getChoice()}</form:option>
						
					</c:forEach>
				
				</form:select>
				
			</p>
			
			<p>
				
				<form:label path = "CPUCooler">CPU Cooler: </form:label>
				
				<form:select path = "CPUCooler">
				
					<form:option value = "NONE">--SELECT--</form:option>
					
					<c:forEach var = "coolers" items = "${coolers}">
					
						<form:option value = "${coolers.getId()}">${coolers.getChoice()}</form:option>
						
					</c:forEach>
				
				</form:select>
				
			</p>
			
			<p>
				
				<form:label path = "Motherboard">Motherboard: </form:label>
				
				<form:select path = "Motherboard">
				
					<form:option value = "NONE">--SELECT--</form:option>
					
					<c:forEach var = "mobos" items = "${mobos}">
					
						<form:option value = "${mobos.getId()}">${mobos.getChoice()}</form:option>
						
					</c:forEach>
				
				</form:select>
				
			</p>
			
			<p>
				
				<form:label path = "RAM">RAM: </form:label>
				
				<form:select path = "RAM">
				
					<form:option value = "NONE">--SELECT--</form:option>
					
					<c:forEach var = "rams" items = "${rams}">
					
						<form:option value = "${rams.getId()}">${rams.getChoice()}</form:option>
						
					</c:forEach>
				
				</form:select>
				
			</p>
			
			<p>
				
				<form:label path = "GPU">GPU: </form:label>
				
				<form:select path = "GPU">
				
					<form:option value = "NONE">--SELECT--</form:option>
					
					<c:forEach var = "gpus" items = "${gpus}">
					
						<form:option value = "${gpus.getId()}">${gpus.getChoice()}</form:option>
						
					</c:forEach>
				
				</form:select>
				
			</p>
			
			<p>
				
				<form:label path = "PSU">Power Supply Unit: </form:label>
				
				<form:select path = "PSU">
				
					<form:option value = "NONE">--SELECT--</form:option>
					
					<c:forEach var = "psus" items = "${psus}">
					
						<form:option value = "${psus.getId()}">${psus.getChoice()}</form:option>
						
					</c:forEach>
				
				</form:select>
				
			</p>
			
			<p>
				
				<form:label path = "computerCase">Case: </form:label>
				
				<form:select path = "computerCase">
				
					<form:option value = "NONE">--SELECT--</form:option>
					
					<c:forEach var = "cases" items = "${cases}">
					
						<form:option value = "${cases.getId()}">${cases.getChoice()}</form:option>
						
					</c:forEach>
				
				</form:select>
				
			</p>
			
			
			<input class = "add_build_button" type = "submit" value = "Edit this build">
			
		</form:form>
	
	</div>
	
</div>
	
</body>
</html>