<div class="big-top-space-login">
	<%     
	String error = (String)request.getAttribute("error"); 
	String success = (String)request.getAttribute("success");
		
	if (error != null) {
	%>
		<div class="row">
			<div class="col-md-4 login-width remove-float center-block">
			 	<div class="alert alert-danger alert-dismissable">
			 		<a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
	   				<strong><%=error%></strong>
	 			</div>
	 		</div>
		</div>
	<%
	}
	else if (success != null) {
	%>		
		<div class="row">
			<div class="col-md-4 login-width remove-float center-block">
				<div class="alert alert-success alert-dismissable">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
		  			<strong><%=success%></strong>
				</div>
			</div>
		</div>
	<%
	}	
	%>
	<div class="row">
		<form action="${pageContext.request.contextPath}/session" method="POST">
			<div class="col-md-4 login-width remove-float center-block top-space">
				<div class="form-group">
					<label for="username"> Username </label>
					<input type="text" name="username" placeholder="Username or Email" id="username" class="form-control" maxlength="35" pattern="[0-9A-Za-z@]{1,25}" required>
				</div>		
				<div class="form-group">
					<label for="password"> Password </label>
					<input type="password" name="password" placeholder="Password" id="password" class="form-control" maxlength="6" pattern="[0-9A-Za-z]{6}" required>
				</div>	
			</div>			
			<div class="col-md-4 login-width remove-float center-block top-space">	
				<input type="submit" value="Iniciar sesion" class="btn btn-info btn-block">
			</div>		
		</form>
	</div>
	<div class="row">
		<form action="${pageContext.request.contextPath}/presignup" method="POST">	
			<div class="col-md-4 login-width remove-float center-block top-space">						
				<input type="submit" value="No tengo cuenta" class="btn btn-info btn-block">				
			</div>
		</form>
	</div>	
</div>