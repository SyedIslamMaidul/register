<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Details</title>
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
        .user-details {
            background-color: #fff;
            padding: 20px;
            max-width: 500px;
            margin: 0 auto;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        .user-details p {
            font-size: 18px;
        }
        .error {
            color: red;
            text-align: center;
        }
        .success {
            color: green;
            text-align: center;
        }
    </style>
</head>
<body>

    <h2>User Details</h2>

    <div class="user-details">
        <% 
            // Get the user data from the request
            String name = (String) request.getAttribute("name");
            String phone = (String) request.getAttribute("phone");
            String city = (String) request.getAttribute("city");
            String gender = (String) request.getAttribute("gender");

            if (name != null) {
        %>
            <p><strong>Name:</strong> <%= name %></p>
            <p><strong>Phone:</strong> <%= phone %></p>
            <p><strong>City:</strong> <%= city %></p>
            <p><strong>Gender:</strong> <%= gender %></p>
        <% } else { %>
            <p class="error">No user details found.</p>
        <% } %>
    </div>

</body>
</html>
