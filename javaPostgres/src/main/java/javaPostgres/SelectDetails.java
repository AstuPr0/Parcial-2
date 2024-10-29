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
import java.sql.ResultSet;


public class SelectDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	//Servlet para mostrar informacion
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Class.forName(DbUtil.driver);
			
		}catch(ClassNotFoundException error){
			System.out.println("Clase no encontrada: " + error);
		}
		
		try {
		     //Definiendo valores en 0
			int id = 0;
			String nombre = "", apellido="", email="";
			
			//A partir del id que se pone en consulta se obtendran todas las columnas que hay en estudiantes
			
			Connection conn =DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
			
			PreparedStatement st = conn.prepareStatement("select * from estudiante where est_id=?");
			
			st.setInt(1, Integer.valueOf(request.getParameter("id")));
			
			//La sentencia de rs  es como obtener lo que se ejecuta del Query sql
			//La cual se usaria el metodo .next(), que es similar a ejecutarlo y dime si funciona
			//Es un booleano osea True si se ejecuto bien la query o ffalse si paso lo contrario
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				id = rs.getInt(1);
				nombre = rs.getString(2);
				apellido = rs.getString(3);
				email = rs.getString(4);
			}
			
			rs.close();
			st.close();
			conn.close();
			
			response.sendRedirect("Result.jsp?id=" + id + "&nombre=" + nombre + 
					"&apellido=" + apellido + "&email=" + email);
			
			
		}catch(Exception error) {
			System.out.println(error);
		}
	}

}
