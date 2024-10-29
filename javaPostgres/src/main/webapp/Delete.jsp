<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
  <h2 align="center">ELIMINAR</h2>
  
  <form action="DeleteDetails" method="post" >
  
    <table>
       
       <tr>
         <td>ID:</td>
         <td><input type="text" name="id" maxlength="20" size="25" /></td>       
       </tr>
         
    </table>
    
    <input type="submit" value="Eliminar" />   
     
  </form> 
  <br>
  <input type="button" value="Inicio" onclick="window.location.href= 'index.jsp'" />

</body>
</html>