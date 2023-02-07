package abhifitness;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login_Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	   
		//boolean flag=false;
		//String pass1="";
		//int count=0;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sumal@777");
			System.out.println("connected");
			
			String emailid=req.getParameter("eid");
			String password=req.getParameter("psw");
			
			PreparedStatement ps=con.prepareStatement("select password from abhi_fitness.user_signup where email=?");
			ps.setString(1, emailid);
			
			
			//ps.executeUpdate();
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				//pass1=rs.getString(3);
				//flag=true;
				resp.sendRedirect("http://localhost:8080/Abhi_Fitness/home.html");
			}else {
				resp.sendRedirect("http://localhost:8080/Abhi_Fitness/login.html");
			}
			
			//if(flag && password.equals(pass1)) {
				//resp.sendRedirect("http://localhost:8080/Abhi_Fitness/home.html");
			//}else {
				//resp.sendRedirect("http://localhost:8080/Abhi_Fitness/login.html");
			//}
			System.out.println("Data Inserted into table");
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			//resp.sendRedirect("http://localhost:8080/Abhi_Fitness/signup.html");
		}
		
		//resp.sendRedirect("http://localhost:8080/Abhi_Fitness/login.html");
	}
}
