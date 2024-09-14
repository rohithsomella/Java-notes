<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Lombok example with Model object</title>
	</head>
	
	<body>
	
		<h1> Persons List...</h1>
		<c:forEach items="${persons}" var ="person">
		Person ID: ${person.id} <br>
		Person Name: ${person.name} <br>
		Person Email: ${person.email} <br>
		***************************** <br>
		</c:forEach>

	</body>
</html>