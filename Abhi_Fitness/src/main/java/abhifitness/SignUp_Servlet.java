package abhifitness;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp_Servlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String fname=req.getParameter("name");
		String emailid=req.getParameter("eid");
		String password=req.getParameter("psw");
		String cpassword=req.getParameter("cpsw");
		
		try
		{
			if(password.equals(cpassword))
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("loaded");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Sumal@777");
			System.out.println("connected");
			
			PreparedStatement ps=con.prepareStatement("insert into abhi_fitness.user_signup values(?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, emailid);
			ps.setString(3, password);
			ps.setString(4, cpassword);
			
			ps.executeUpdate();
			
			System.out.println("Data Inserted into table");
			}
			else
			{
				PrintWriter out=resp.getWriter();
				RequestDispatcher rd=req.getRequestDispatcher("signup.html");
				
				out.print("<html><body><br><h1 style='color:red'>Password Missmatch</h1><br><br>");
				rd.include(req, resp);
				out.print("</body></html>");
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			resp.sendRedirect("http://localhost:8080/Abhi_Fitness/signup.html");
		}
		
		//		resp.sendRedirect("http://localhost:8080/Abhi_Fitness/login.html");
	}
}
