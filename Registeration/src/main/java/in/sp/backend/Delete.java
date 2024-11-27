package in.sp.backend;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class Delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the email parameter from the request
        String email = request.getParameter("email");

        // Message variable for status
        String message = "";

        if (email == null || email.isEmpty()) {
            message = "Email is required to delete a user.";
        } else {
            try {
                // Step 1: Set up the database connection
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_regist", "root", "password");

                // Step 2: Prepare and execute DELETE query
                PreparedStatement ps = con.prepareStatement("DELETE FROM register WHERE email = ?");
                ps.setString(1, email);
                
                int rowsAffected = ps.executeUpdate();
                
                // Step 3: Check if the user was successfully deleted
                if (rowsAffected > 0) {
                    message = "User with email " + email + " was successfully deleted.";
                } else {
                    message = "No user found with the provided email.";
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                message = "An error occurred while deleting the user.";
            }
        }

        // Set the message in the request and forward to confirmation page
        request.setAttribute("message", message);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/deleteConfirmation.jsp");
        dispatcher.forward(request, response);
    }
}
