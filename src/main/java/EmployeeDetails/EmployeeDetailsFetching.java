package EmployeeDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EmployeeDetails")
public class EmployeeDetailsFetching extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter pw = res.getWriter();
		String sql = "jdbc:mysql://localhost:3306/employee?user=root&password=12345";
		String select="select ID, Name, Email, Age, Dob from employeedetails";
		res.setContentType("text/html");
		String name =req.getParameter("name");
		
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection =DriverManager.getConnection(sql);
				PreparedStatement ps = connection.prepareStatement(select);
				ResultSet rs=ps.executeQuery();
				pw.println("<table border='1' align='center'>");
				pw.println("<tr>");
				pw.println("<th>Id</th>");
				pw.println("<th>Name</th>");
				pw.println("<th>Email</th>");
				pw.println("<th>Age</th>");
				pw.println("<th>Date of Birth</th>");
				while(rs.next())
				{
					pw.println("<tr>");
					pw.println("<td>"+rs.getInt(1)+"</td>");
					pw.println("<td>"+rs.getString(2)+"</td>");
					pw.println("<td>"+rs.getString(3)+"</td>");
					pw.println("<td>"+rs.getInt(4)+"</td>");
					pw.println("<td>"+rs.getDate(5)+"</td>");
				}
				pw.println("</table>");
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
