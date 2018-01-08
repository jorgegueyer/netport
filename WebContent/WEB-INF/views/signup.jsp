<%     
	String error = (String)request.getAttribute("error");    
	String success = (String)request.getAttribute("success");    
%>
<div class="col-md-6 remove-float center-block big-top-space">
		<form action="${pageContext.request.contextPath}/postsignup" method="POST">
			<div class="form-group">
				<label for="username"> Username </label>
				<input type="text" name="username" placeholder="Username" id="username" class="form-control" maxlength="20" pattern="[0-9A-Za-z]{1,20}" required>
			</div>	
			<div class="form-group">
				<label for="name"> Name </label>
				<input type="text" name="name" placeholder="Name" id="name" class="form-control" maxlength="20" pattern="[0-9A-Za-z]{1,20}" required>
			</div>	
			<div class="form-group">
				<label for="surname"> Surname </label>
				<input type="text" name="surname" placeholder="Surname" id="surname" class="form-control" maxlength="20" pattern="[0-9A-Za-z]{1,20}" required>
			</div>	
			<div class="form-group">
				<label for="surname"> Birthday </label>
				<input type="date" name="birthday" placeholder="dd/mm/yyyy" id="birthday" class="form-control" pattern="dd/mm/yyyy" required>
			</div>	
			<div class="form-group">
				<label for="email"> Email </label>
				<input type="text" name="email" placeholder="Email" id="email" class="form-control" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required>
			</div>			
			<div class="form-group">
				<label for="password"> Password </label>
				<input type="password" name="password" placeholder="Password" id="password" class="form-control" maxlength="6" pattern="[0-9A-Za-z]{6}" required>
			</div>
			<div class="form-group">
				<label for="password"> Confirm your password </label>
				<input type="password" name="password_confirmation" placeholder="Confirma contraseña" id="password" maxlength="6" pattern="[0-9A-Za-z]{6}" class="form-control" required>
			</div>
			<div class="col-sx-12 col-sm-6 top-space remove-padding">
				<input type="submit" value="Confirm" class="btn btn-info">
			</div>			
		</form>	
		<form action="${pageContext.request.contextPath}/login" method="POST">			
			<div class="col-sx-12 col-sm-6 top-space remove-padding text-right">
				<input type="submit" value="Already have an account!" class="btn btn-info">
			</div>			
		</form>
		<%
		if (error != null) {
	    %>
		<div class="col-sx-12 col-sm-6 top-space remove-padding text-right">
			<div class="alert alert-danger">
	    		<strong>$error</strong>
	  		</div>
		</div>
		<%
		}
	    %>
		<%
		if (success != null) {
	    %>
		<div class="col-sx-12 col-sm-6 top-space remove-padding text-right">
			<div class="alert alert-success">
	    		<strong><%=success%></strong>
	  		</div>
		</div>
		<%
		}
	    %>		
</div>				