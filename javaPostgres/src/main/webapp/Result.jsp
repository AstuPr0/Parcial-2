<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <h2>INFORMACIÓN</h2>
  
  <h3>Detalles</h3>
  
  <form>
     <input type="hidden" name="stid" value="<%=request.getParameter("id")%>" />
     <table>
        <tr>
           <td>ID</td>
           <td><%=request.getParameter("id")%></td>
        </tr>
        <tr>
           <td>Nombre</td>
           <td><%=request.getParameter("nombre")%></td>
        </tr>
        <tr>
           <td>Apellido</td>
           <td><%=request.getParameter("apellido")%></td>
        </tr>
        <tr>
           <td>Email</td>
           <td><%=request.getParameter("email")%></td>
        </tr>
     
     </table>
  
  </form>
  
  <input type="button" value="Actualizar Datos" onclick="update()" />
  <input type="button" value="Inicio" onclick="window.location.href='index.jsp'"/>

</body>

<script>
   function update(){
	   let stid = document.forms[0].elements['stid'].value;
	   window.location.href="Update.jsp?id="+ stid;
   }
</script>
</html>