<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
	<html>
	<head>
	
		<title>ModelAndView Example</title>
	</head>
	<body>
		Student Name: ${name} <br>
		Student Age: ${age}<br>
		Student Email: ${email} <br>
		Student Mobile: ${mobile} 
		<!--  To iterate the list of marks use for-each loop in JSTL -->
		
		<c:forEach items="${marks}" var="marks">
			<h2>Your marks data: ${marks}</h2>
		</c:forEach>
		
	</body>
</html>