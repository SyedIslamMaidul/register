package in.sp.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class select extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get email from the request parameter (this could be from a form or URL)
        String email = request.getParameter("email");

        if (email == null || email.isEmpty()) {
            // If no email is provided, redirect back to a page with a warning or error
            request.setAttribute("message", "Email is required to fetch user data.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Variables to hold the user data
        String name = "", phone = "", city = "", gender = "";

        // Database query to fetch user data based on the provided email
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_regist", "root", "password");

            // Query to select user data based on the email
            PreparedStatement ps = con.prepareStatement("SELECT * FROM register WHERE email = ?");
            ps.setString(1, email);

            // Execute the query
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // If user is found, retrieve their data
                name = rs.getString("name");
                phone = rs.getString("phone");
                city = rs.getString("city");
                gender = rs.getString("gender");
            } else {
                // If no user is found with the given email
                request.setAttribute("message", "No user found with the provided email.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred while retrieving user data.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Set the retrieved user data in the request
        request.setAttribute("name", name);
        request.setAttribute("phone", phone);
        request.setAttribute("city", city);
        request.setAttribute("gender", gender);

        // Forward to the JSP page to display the user data
        RequestDispatcher dispatcher = request.getRequestDispatcher("/userDetails.jsp");
        dispatcher.forward(request, response);
    }
}
