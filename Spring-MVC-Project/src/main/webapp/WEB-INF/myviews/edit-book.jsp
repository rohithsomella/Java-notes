<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book Information</title>
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
        body {
            background-image: url('/images/bg3.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
             color: white;/* Optional: to make text readable against the background */
        }
    </style>
    
</head>
<body>
	    <a href="/books" class="btn btn-light home-button">
        	<i class="fas fa-home"></i>
    	</a>
	<!-- header part of the page common for all the pages in this project -->
<div class="container-fluid text-white text-center" style="background-color: rgba(0, 0, 0, 0.4); border-radius: 8px;">
    <h1>Spring Boot MVC Project</h1>
    <h3>@Controller, @Service Exception Validation JSP layer</h3>
</div>

<div class="container" style="background-color: rgba(0, 0, 0, 0.4); border-radius: 8px;">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center mb-4">Add New Book Information</h2>
	<!-- form to add book info to the array or database from add book page -->
            <form method="post" action="/books/editsavebook">

                <div class="mb-3">
                    <label class="form-label">Book ISBN:</label>
                    <input type="text" class="form-control" name="isbn" readonly="readonly" value="${book.isbn}" placeholder="Book Number">
                <!-- validation error message to validate the book information while adding isbn -->
                    <c:if test="${not empty error.getFieldError('isbn')}">
					<div class = "text-danger">${error.getFieldError('isbn').defaultMessage }</div>
					</c:if>
				
                </div>
				
				
				
                <div class="mb-3">
                    <label class="form-label">Book Name:</label>
                    <input type="text" class="form-control" name="name" value="${book.name}" placeholder="Book Title">
                <!-- validation error message to validate the book information while adding book name -->
               		<c:if test="${not empty error.getFieldError('name')}">
					<div class = "text-danger">${error.getFieldError('name').defaultMessage }</div>
					</c:if>
                </div>


                <div class="mb-3">
                    <label class="form-label">Book Author:</label>
                    <input type="text" class="form-control" name="author" value="${book.author}" placeholder="Book Writer">
					<!-- validation error message to validate the book information while adding book author -->
                	<c:if test="${not empty error.getFieldError('author')}">
					<div class = "text-danger">${error.getFieldError('author').defaultMessage }</div>
					</c:if>
                </div>

                <button class="btn btn-primary">Update Book</button>
                <h2></h2> <!-- empty space for good look -->

            </form>
        </div>
    </div>
</div>
</body>
</html>
