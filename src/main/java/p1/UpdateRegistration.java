package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateReg")
public class UpdateRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateRegistration() {

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("Email");
		String mobile = request.getParameter("Mobile");
		
		
		try {
			
		  
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Strudentinfo","root","Test");
			
			
			// Perform the SQL Configuration

			Statement stmnt = con.createStatement();
			stmnt.executeUpdate("update student set mobile = '"+mobile+"' where email= '"+email+"'");
			
			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			}
		}
	
	}


