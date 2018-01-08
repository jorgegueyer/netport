<%     
	String error = (String)request.getAttribute("error"); 
	String success = (String)request.getAttribute("success"); 
%>
<div class="col-md-6 remove-float center-block big-top-space">
	<form action="${pageContext.request.contextPath}/sessions" method="POST">
		<div class="form-group">
			<label for="email"> Email </label>
			<input type="text" name="email" placeholder="Email" id="email" class="form-control" required>
		</div>		
		<div class="form-group">
			<label for="password"> Password </label>
			<input type="password" name="password" placeholder="Password" id="password" class="form-control" required>
		</div>		
		<div class="col-sx-12 col-sm-6 top-space remove-padding">
			<input type="submit" value="Iniciar sesion" class="btn btn-info" >
		</div>
	</form>
	<form action="${pageContext.request.contextPath}/presignup" method="POST">		
		<div class="col-sx-12 col-sm-6 top-space remove-padding text-right">
			<input type="submit" value="No tengo cuenta" class="btn btn-info">				
		</div>		
	</form>
	<%
	if (error != null) {
    %>
	<div class="col-sx-12 col-sm-6 top-space remove-padding text-right">
		<div class="alert alert-danger">
    		<strong><%=error%></strong>
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