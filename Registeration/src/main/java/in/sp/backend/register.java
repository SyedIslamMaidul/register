package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerForm")
public class register extends HttpServlet

{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	
	{
		PrintWriter out = response.getWriter();
		
		String myname = request.getParameter("name");
		String myemail = request.getParameter("email");
		 String dobStr = request.getParameter("dob");
		 String myphone = request.getParameter("phone");
		 
		 String mygender = request.getParameter("gender");
		 String mycity = request.getParameter("city");

	        // Try to convert the String to an integer (e.g., 19850821)
	        try {
	            int mydob = Integer.parseInt(dobStr);
	            // Do something with the DOB integer
	            System.out.println("Date of Birth as integer: " + mydob);
	        } catch (NumberFormatException e) {
	            // Handle invalid format
	            response.getWriter().println("Invalid DOB format. Please enter in YYYYMMDD format.");
	        }	
	        
	        try {
	            // Convert phone number string to a long (if needed, phone numbers may exceed integer range)
	            long phoneNumber = Long.parseLong(myphone);
	            System.out.println("Phone Number as long: " + phoneNumber);

	            // Process the phone number (e.g., save to database)
	        } catch (NumberFormatException e) {
	            // Handle invalid input for phone number
	            response.getWriter().println("Invalid phone number format. Please enter a 10-digit number.");
	        }
	        
	// to connect databaseConnection
	        try 
	        {
	        
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_regist","root","12345678");
	        	
      //---------------- Inserting the data into the data base	        	
	        	PreparedStatement ps = con.prepareStatement("insert into register value(?,?,?,?,?,?)");
	        	
	        	ps.setString(1, myname);
	        	ps.setString(2,myemail);
	        	ps.setString(3,dobStr);
	        	ps.setString(4,myphone);
	        	ps.setString(5,mygender);
	        	ps.setString(6,mycity);

	        	int count = ps.executeUpdate();
	        	if(count >0 ) 
	        	{
	        		response.setContentType("text/html");
	        		out.print("<h3 style = 'color:green'> User register Successfully </h3>");
	        		
	        		RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
	        		rd.include(request, response);
	        		
	        	}
	        	else
	        	{
	        		response.setContentType("text/html");
	        		out.print("<h3 style = 'color:red'> User  not register due to error </h3>");
	        		
	        		RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
	        		rd.include(request, response);
	        		
	        	}

	        	
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        }
	}

}
