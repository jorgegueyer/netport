<div class="big-top-space-signup">
	<%     
	String error = (String)request.getAttribute("error");    
	String success = (String)request.getAttribute("success"); 

	if (error != null) {
		%>
			<div class="row">
				<div class="col-md-4 form-width remove-float center-block">
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
				<div class="col-md-4 form-width remove-float center-block">
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
		<form action="${pageContext.request.contextPath}/postsignup" method="POST">
			<div class="col-md-4 form-width remove-float center-block top-space">		
				<div class="form-group">
					<label for="username"> Username </label>
					<input type="text" name="username" placeholder="Username" id="username" class="form-control" maxlength="15" pattern="[0-9A-Za-z]{1,15}" required>
				</div>	
				<div class="form-group">
					<label for="name"> Name </label>
					<input type="text" name="name" placeholder="Name" id="name" class="form-control" maxlength="25" pattern="[0-9A-Za-z]{1,25}" required>
				</div>	
				<div class="form-group">
					<label for="surname"> Surname </label>
					<input type="text" name="surname" placeholder="Surname" id="surname" class="form-control" maxlength="30" pattern="[0-9A-Za-z]{1,30}" required>
				</div>	
				<div class="form-group">
					<label for="birthday"> Birthday </label>
					<input type="date" name="birthday" placeholder="dd/mm/yyyy" id="birthday" class="form-control" pattern="dd/mm/yyyy" required>
				</div>	
				<div class="form-group">
					<label for="email"> Email </label>
					<input type="text" name="email" placeholder="Email" id="email" class="form-control" maxlength="35" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
				</div>			
				<div class="form-group">
					<label for="password"> Password </label>
					<input type="password" name="password" placeholder="Password" id="password" class="form-control" maxlength="6" pattern="[0-9A-Za-z]{6}" required>
				</div>
				<div class="form-group">
					<label for="password_confirmation"> Confirm your password </label>
					<input type="password" name="password_confirmation" placeholder="Confirm password" id="password_confirmation" class="form-control" maxlength="6" pattern="[0-9A-Za-z]{6}" required>
				</div>
			</div>
			<div class="col-md-4 button-signup-width remove-float center-block top-space">	
				<input type="submit" value="Confirm" class="btn btn-info btn-block">
			</div>
		</form>	
	</div>	
</div>

			