package javaPostgres;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

 //Definimos la ruta con el webservlet("ruta"), do post es la respuesta que uno espera
 

 
public class InsertDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;     
 
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Manejo de excepciones o errores con try y catch
		//Try hace algo y en caso de que sea un error con catch me lo mande como parametro para ver que hacer con el
		//si immprimirlo o lo que sea, pero que no dañe el programa
		
		try {
			//Vamos a establecer la conexion con la base de datos
			
			Class.forName(DbUtil.driver);
			
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found " + e);
		}
		try {
			Connection conn = DriverManager.getConnection(DbUtil.url,DbUtil.user,DbUtil.password);
			System.out.println("Conexion hecha");
			
			
			// Definimos st donde el va a 
			PreparedStatement st = conn.prepareStatement("insert into estudiante values (?,?,?,?)");
			
			
			//Obteniendo lo que recibimos de la Url
			String id = request.getParameter("id");
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String email = request.getParameter("email");
			
			//Mandar lo que se recibio de la url al preparedStatement = Sql query
			
			st.setInt(1, Integer.valueOf(id));
			st.setString(2, nombre);
			st.setString(3, apellido);
			st.setString(4, email);
			
			//Hacer la accion
			
			st.executeUpdate();
			
			//Cerrar la bd
			
			st.close();
			conn.close();
			
			
			//Enviarlo a la siguiente ruta
			
			/*
			 *Parametro url, inician con ? y se ponen clave=valor y si son más de uno se continua con & 
			 **/
			response.sendRedirect("Success.jsp?msg=Insert");
			
		} catch(Exception e){
			System.out.println(e);
			
		}
	}

}
