<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        h2 {
            text-align: center;
        }
        .message {
            font-size: 18px;
            text-align: center;
            margin-top: 20px;
        }
        .success {
            color: green;
        }
        .error {
            color: red;
        }
        .back-button {
            display: block;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <h2>Delete User</h2>

    <div class="message">
        <% 
            // Retrieve the deletion message from the request
            String message = (String) request.getAttribute("message");
            if (message != null) {
                if (message.contains("successfully")) {
                    out.print("<p class='success'>" + message + "</p>");
                } else {
                    out.print("<p class='error'>" + message + "</p>");
                }
            }
        %>
    </div>

    <!-- Button to go back to the previous page -->
    <div class="back-button">
        <a href="deleteUser.jsp">Back to Delete User Page</a>
    </div>

</body>
</html>
