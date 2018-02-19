<%@page import="java.util.*"%>
<%@page import="com.jgy.dao.to.ActivityTO"%>

<div class="container">
	<%
	@SuppressWarnings("unchecked")
	ArrayList<ActivityTO> listActivities = (ArrayList<ActivityTO>) request.getAttribute("list");
	if (listActivities != null) {
	%>
	<h2>My Activities</h2>  
  	<table class="table table-striped">
    	<thead>
      		<tr>
        		<th>Name</th>
        		<th>Type</th>
        		<th>Duration (hh:mm:ss)</th>
        		<th>Average Rhythm (minutos/km)</th>
        		<th>Date</th>
      		</tr>
    	</thead>
    
    	<tbody>
    		<%    		
				for (ActivityTO activity: listActivities) {			
			%>  
      				<tr>
        				<td><%=activity.getName()%></td>
        				<td><%=activity.getType()%></td>
        				<td><%=activity.getDuration().toString()%></td>
        				<td><%=activity.getAverageRhythm().toString()%></td>
        				<td><%=activity.getCdate()%></td>
      				</tr>
    		<%
			}
 			%>
    	</tbody>
  	</table>
  	<%
	}
	else {		
		String message = (String)request.getAttribute("message");
  	%>
  	<div class="big-top-space">
		<div class="col-md-4 form-width remove-float center-block">
		 	<div class="alert alert-danger alert-dismissable">
		 		<a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
	  				<strong><%=message%></strong>
			</div>
		</div>		
  	</div>	
  	<%
	}
  	%>
  	
</div>