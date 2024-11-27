<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Update User Information</h2>

    <!-- Form to Update User Information -->
    <form action="update" method="post">
        <!-- User Email (Required for identifying the user to update) -->
        <label for="email">Email (for identification):</label>
        <input type="email" id="email" name="email" placeholder="Enter the user's email" required>

        <!-- Name -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" placeholder="Enter your name" required>

        <!-- Phone -->
        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" placeholder="Enter phone number" required>

        <!-- City -->
        <label for="city">City:</label>
        <input type="text" id="city" name="city" placeholder="Enter your city" required>

        <!-- Gender -->
        <label for="gender">Gender:</label>
        <select id="gender" name="gender">
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select>

        <!-- Submit Button -->
        <button type="submit">Update Information</button>
    </form>

    <!-- Error/Success Message Display -->
    <div class="error">
        <% 
            // Display the success or error message from the update operation
            String message = (String) request.getAttribute("message");
            if (message != null) {
                out.print("<h3>" + message + "</h3>");
            }
        %>
    </div>

</body>
</html>