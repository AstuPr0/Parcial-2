<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="UpdateDetails" method="post">
     
     <table>
        <tr>
           <td>ID</td>
           <td><input type="text" name="id" value="<%=request.getParameter("id")%>" readonly=readonly /></td>
        </tr>
        <tr>
           <td>Nombre</td>
           <td><input type="text" name="nombre" value="<%=request.getParameter("nombre")%>" /></td>
        </tr>
        <tr>
           <td>Apellido</td>
           <td><input type="text" name="apellido" value="<%=request.getParameter("apellido")%>" /></td>
        </tr>
        <tr>
           <td>Email</td>
           <td><input type="text" name="email" value="<%=request.getParameter("email")%>" /></td>
        </tr>
     
     </table>
     
     <input type="submit" value="Actualizar Datos" />
  
  </form>
  
  <input type="button"  value="Inicio" onclick="window.location.href='index.jsp'"/>

</body>
</html>