<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Management Project</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <!-- Font Awesome for icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

<style>
        body {
            background-image: url('/images/bg.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            background-attachment: fixed;
             color: white;/* Optional: to make text readable against the background */
        }
        .code-button {
            position: fixed;
            bottom: 20px;
            right: 20px;
            z-index: 1000;
        }
</style>
</head>
<body>
<div class="container text-center mt-5">
    <div class="container text-center mt-5 p-3" style="background-color: rgba(0, 0, 0, 0.5); border-radius: 8px;">
    <h1 class="display-4 text-white">Product Management Project</h1>
    <h2 class="text-white">using Spring Boot MVC</h2>
    <h4 class="text-white">by Rohith Somella</h4>
	</div>


    <div class="mt-4">
        <a class="btn btn-success" href="/books/viewbooks">Open Project</a>
    </div>
    
    <div class="mt-4">
        <a class="btn btn-primary me-2" href="https://www.linkedin.com/in/rohithsomella" target="_blank">
            <i class="fab fa-linkedin"></i> LinkedIn
        </a>
        <a class="btn btn-dark me-2" href="https://github.com/rohithsomella" target="_blank">
            <i class="fab fa-github"></i> GitHub
        </a>
        <a class="btn btn-danger" href="mailto:rohithsomella@gmail.com">
            <i class="fas fa-envelope"></i> Email
        </a>
    </div>
</div>

<!-- Button with </> symbol -->
<a href="#" class="btn btn-dark code-button">
    <i class="fas fa-code"></i>
</a>

</body>
</html>
