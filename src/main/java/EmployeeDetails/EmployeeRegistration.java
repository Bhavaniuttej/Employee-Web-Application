package EmployeeDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class EmployeeRegistration extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		PrintWriter pw = res.getWriter();
		String sql = "jdbc:mysql://localhost:3306/employee?user=root&password=12345";
		String insert="insert into employeedetails (Name, Email, Age, Dob) values (?,?,?,?)";
		res.setContentType("text/html");
		String name =req.getParameter("name");
		String email=req.getParameter("email");
		int age = Integer.parseInt(req.getParameter("age"));
		String dateString =req.getParameter("dateOfBirth");
		Date date = null;
		
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-dd-MM");
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection =DriverManager.getConnection(sql);
				PreparedStatement ps = connection.prepareStatement(insert);
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setInt(3, age);
				ps.setDate(4,  new java.sql.Date(date.getTime()));
				int count=ps.executeUpdate();
				if(count==1)
				{
					pw.println("<h2>Record is Registered Successfully</h2>");
				}
				else
				{
					pw.println("<h2>Record is Not Registered</h2>");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				pw.println(("<h1>")+e.getMessage()+"</h1>");
			}
			pw.println("<a href='registration.html'>Home</a>");
			pw.println("<br>");
			pw.println("<a href='EmployeeDetails'>EmployeeDetails</a>");
		
	}
}
