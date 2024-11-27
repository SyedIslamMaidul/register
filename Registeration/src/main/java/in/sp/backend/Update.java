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

@WebServlet("/update")
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String myemail = request.getParameter("email");
        String myname = request.getParameter("name");
        String myphone = request.getParameter("phone");
        String mycity = request.getParameter("city");
        String mygender = request.getParameter("gender");

        // Update query to change user details based on email (assuming email is unique)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yt_regist");

            // Check if the email exists in the database
            PreparedStatement psCheck = con.prepareStatement("SELECT * FROM register WHERE email = ?");
            psCheck.setString(1, myemail);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                // If email exists, update the record
                PreparedStatement psUpdate = con.prepareStatement("UPDATE register SET name = ?, phone = ?, city = ?, gender = ? WHERE email = ?");
                psUpdate.setString(1, myname);
                psUpdate.setString(2, myphone);
                psUpdate.setString(3, mycity);
                psUpdate.setString(4, mygender);
                psUpdate.setString(5, myemail);

                int count = psUpdate.executeUpdate();
                if (count > 0) {
                    request.setAttribute("message", "User data updated successfully");
                } else {
                    request.setAttribute("message", "Failed to update user data");
                }
            } else {
                request.setAttribute("message", "Email not found in the database");
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Database error occurred while updating");
        }

        // Forward to the update.jsp page to display the result message
        RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
        rd.forward(request, response);
    }
}
