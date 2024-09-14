<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<title>view books</title>
		
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
            background-image: url('/images/bg4.jpg');
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
		
		<div class="container " >
			<a href="/books/addbook" class="btn btn-outline-success">Add Book Information</a>
			<h1><i> List of Books Information</i></h1>
			
		<!-- Messages to get print based on the operation performed -->
			
			<div class = "text-center bg-white">
				<c:if test="${savemessage}">
					<div class = "text-success">
					Data Saved Successfully
					</div>
				</c:if>
			</div>
			
			<div class = "text-center bg-dark">
				<c:if test="${deleteMessage}">
					<div class = "text">
					Data Deleted Successfully
					</div>
				</c:if>
			</div>
			
			
			<div class="text-center bg-white">
    			<c:if test="${editMessage}">
			        <div class="text-primary">
			            Data Updated Successfully
			        </div>
			    </c:if>
			</div>
			
			<!-- Table creation to store the book information from the array -->
			
			<table class="table table-striped table-bordered table-hover">
				<thead class= "table table-dark">
					<tr>
						<th>ISBN</th>
						<th>Name</th>
						<th>Author</th>
						<th>Action</th>
						
					</tr>
				</thead>
			
			<!-- data extracted from the save book page and stored in the table -->
			
				<tbody>		
					<c:forEach items="${books}" var = "book">
						<tr>
						<td>${book.isbn}</td>
						<td> ${book.name}</td>
						<td> ${book.author}</td>
						<td> <!-- buttons for operations -->
							<a href="/books/delete/${book.id}" class="btn btn-outline-danger btn-sm"><b>Delete</b></a>
							<a href="/books/edit/${book.id}" class="btn btn-outline-success btn-sm"><b>Edit<b/></a>
						</tr> 
					</c:forEach>
				</tbody>
			
			</table>
		
		</div>
	</body>
</html>