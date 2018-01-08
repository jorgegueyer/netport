<%@page import="org.w3c.dom.Document"%>
<%@page import="com.jgy.dao.to.EstudianteTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Información del estudiante</title>
    </head>
    <body>
    
    <!-- Creamos los enlaces que nos permitirán cambiar de página. -->
        
        <h2>        	
        	<table border="1">
        		<td>Información del estudiante</td>            
            	<td><a href="<%=pageContext.getRequest().getServletContext().getContextPath() %>/ListadoEstudiantes">Listado de estudiantes</a></td>            
        	</table>
        </h2>
        <br />
    
        <h1>Formulario de alta de un estudiante.</h1>
       
        <%
        // Recogemos el estudiante almacenado en la request y si es nulo creamos uno nuevo. 
        EstudianteTO estudiante = (EstudianteTO)request.getAttribute("estudiante");
        if (estudiante == null)
        	estudiante = new EstudianteTO();
        
        String error = (String)request.getAttribute("error");        
        %>
		
		<!-- Creamos el formulario -->
        <form action="<%=pageContext.getRequest().getServletContext().getContextPath() %>/EstudianteServlet" method="POST">
            <table>            	
                <!-- Añadir los campos del formuario. Ya se aportan los botones del formulario.  -->
                 <tr>
                    <td colspan="2">
                    <label for="fid">ID</label>
                    <input type="text" id="fid" name="id" value="<%=estudiante.getEstudianteID()!=null ? estudiante.getEstudianteID() : ""%>" />                    
                    </td>
                </tr>  
                <tr>
                    <td colspan="2">
                    <label for="fname">Nombre</label>
                    <input type="text" id="fname" name="nombre" value="<%=estudiante.getNombre()!=null ? estudiante.getNombre() : ""%>" />                    
                    </td>
                </tr>  
                <tr>
                    <td colspan="2">
                    <label for="faddress">Dirección</label>
                    <input type="text" id="faddress" name="direccion" value="<%=estudiante.getDireccion()!=null ? estudiante.getDireccion() : ""%>" />                    
                    </td>
                </tr>  
                <tr>
                    <td colspan="2">
                    <input type="Submit" name="operacion" value="Crear" />
                    <input type="Submit" name="operacion" value="Editar" />
                    <input type="Submit" name="operacion" value="Borrar" />
                    <input type="Submit" name="operacion" value="Buscar" />
                    </td>
                </tr>                
            </table>
        </form>
        <br>
        <%
			if (error != null) {
        %>
        	<div>
        		<h3 id="error" style="color:red;"><%=error%></h3>
        	</div>
        <%
			}
        %>
    </body>
</html>
