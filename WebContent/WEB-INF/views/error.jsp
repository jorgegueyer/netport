<%@ page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Error Page</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8;">
		<meta charset="utf-8">		 
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/app.css"> 
	</head>
	<body>					
		<div class="container">			
		  	<div class="alert alert-danger">
		    	<strong>${pageContext.errorData.statusCode}</strong>
		  	</div>	
		  	<div class="alert alert-danger">
		    	<strong>>{pageContext.errorData.statusCode}</strong>
		  	</div>			
		</div>
	</body>
</html>

