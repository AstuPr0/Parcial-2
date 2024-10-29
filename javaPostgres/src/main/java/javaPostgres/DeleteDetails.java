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



//Servlet para el delete de la bd
public class DeleteDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Comprobar la existencia de la clase de la bd
		try {
			
			Class.forName(DbUtil.driver);
			
		} catch(ClassNotFoundException error){
			
			System.out.println("Clase no encontrada: " + error);
		}
		
		try {
			
			Connection conn = DriverManager.getConnection(DbUtil.url, DbUtil.user, DbUtil.password);
			
			PreparedStatement st = conn.prepareStatement("delete from estudiante where est_id=?");
			
			String id = request.getParameter("id");
			
			st.setInt(1, Integer.valueOf(id));
			
			st.executeUpdate();
			st.close();
			conn.close();
			
			response.sendRedirect("Success.jsp?msg=Delete");
		
		}catch(Exception error){
			
			System.out.println(error);
			
		}
		
		
	}

}
