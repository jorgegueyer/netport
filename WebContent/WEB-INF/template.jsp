<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Netport</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8;">
		<meta charset="utf-8">		 
		<link rel="stylesheet" href="./static/css/bootstrap.min.css">
		<link rel="stylesheet" href="./static/css/app.css">
		<script src="./static/js/jquery.min.js"></script>	
		<script src="./static/js/bootstrap.min.js"></script> 
			
	</head>
	<body>		
		 <nav class="large-padding black white-text">
		 	<ul>		 		
		 		<jsp:include page="${nav}" flush="true"></jsp:include>	
		 	</ul>
		 </nav>			
		<jsp:include page="${page}" flush="true"></jsp:include>	
	</body>
</html>