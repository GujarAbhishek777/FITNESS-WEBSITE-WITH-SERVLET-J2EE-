package abhifitness;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Abhi_Servlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String gender=req.getParameter("gender");
		String locality=req.getParameter("local");
		String mobno=req.getParameter("mno");
		String emailid=req.getParameter("eid");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sumal@777");
			System.out.println("connected");
			
			PreparedStatement ps=con.prepareStatement("insert into abhi_fitness.reg_user values(?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, age);
			ps.setString(3, gender);
			ps.setString(4, locality);
			ps.setString(5, mobno);
			ps.setString(6, emailid);
			
			ps.executeUpdate();
			
			System.out.println("Data Inserted into table");
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		resp.sendRedirect("http://localhost:8080/Abhi_Fitness/registered.html");
	}
	
	}


