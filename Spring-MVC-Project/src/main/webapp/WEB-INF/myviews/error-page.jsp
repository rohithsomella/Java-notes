<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Duplicate Book Info </title>
				<!-- this below link is to add bootstrap classes to div tags -->
	    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	
	<!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    
    <style>
        .home-button {
            position: fixed;
            top: 10px;
            left: 10px;
            z-index: 1000;
        }
    </style>
	
	</head>
	<body>
	    <a href="/books" class="btn btn-light home-button">
        	<i class="fas fa-home"></i>
    	</a>
	
		<!-- header part of the page common for all the pages in this project -->
		<div class="container-fluid bg-success text-white text-center">
		    <h1>Spring Boot MVC Project</h1>
		    <h3>@Controller, @Service Exception Validation JSP layer</h3>
		</div>
	<!-- Error message or exception message with excisted book info of same isbn -->
		<div class="container-fluid text-white bg-danger text-center">
			<h1> Error: Duplicate Book Exception Message</h1>
			
			Book ISBN: ${book.isbn}  <br>
			Book Name: ${book.name}  <br>
			Book Author: ${book.author} <br>
			
			Message: ${message} <br>
		</div>
		
	</body>
</html>