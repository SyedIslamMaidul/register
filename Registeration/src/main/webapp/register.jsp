<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        /* Body styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            animation: fadeIn 1s ease-in-out;
        }
        
        /* Fade-in animation for the form */
        @keyframes fadeIn {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        h2 {
            text-align: center;
            color: #333;
            animation: slideDown 0.5s ease-out;
        }

        /* Slide down animation for header */
        @keyframes slideDown {
            0% {
                transform: translateY(-30px);
                opacity: 0;
            }
            100% {
                transform: translateY(0);
                opacity: 1;
            }
        }

        /* Form styling */
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin: 0 auto;
            opacity: 0;
            animation: formFadeIn 1s ease-in-out 0.5s forwards;
        }

        /* Fade-in animation for the form */
        @keyframes formFadeIn {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        label {
            font-size: 14px;
            color: #555;
            display: block;
            margin-bottom: 6px;
        }

        /* Styling for text fields, email, date, phone inputs */
        input[type="text"], input[type="email"], input[type="date"], input[type="phone"], textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            transition: border-color 0.3s ease-in-out;
        }

        /* Input focus effect */
        input[type="text"]:focus, input[type="email"]:focus, input[type="phone"]:focus, textarea:focus {
            border-color: #4CAF50;
            box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
        }

        input[type="radio"] {
            margin-right: 8px;
        }

        /* Textarea */
        textarea {
            resize: vertical;
            height: 80px;
        }

        .form-group {
            margin-bottom: 16px;
        }

        /* Submit button */
        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease-in-out;
            opacity: 0;
            animation: buttonFadeIn 1s ease-in-out 1s forwards;
        }

        /* Button hover effect */
        input[type="submit"]:hover {
            background-color: #45a049;
        }

        /* Button fade-in animation */
        @keyframes buttonFadeIn {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        /* Gender options (radio buttons) styling */
        .gender-options {
            margin-bottom: 12px;
            opacity: 0;
            animation: genderFadeIn 1s ease-in-out 1.5s forwards;
        }

        @keyframes genderFadeIn {
            0% {
                opacity: 0;
            }
            100% {
                opacity: 1;
            }
        }

        .form-group {
            margin-bottom: 16px;
        }

    </style>
</head>
<body>
    <h2>Registration Form</h2>
    <form action="registerForm" method="post">
        
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required><br><br>
        </div>
        
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required><br><br>
        </div>
        
        <div class="form-group">
            <label for="dob">Date of Birth:</label>
            <input type="text" id="dob" name="dob"  pattern="\d{8}" required placeholder="Enter DOB in YYYYMMDD format"><br><br>
        </div>
        
        <div class="form-group">
            <label for="phone">Phone Number:</label>
            <input type="text" id="phone" name="phone" pattern="\d{10}" required placeholder="Enter phone number (10 digits)"><br><br>
        </div>
        
        <div class="form-group">
            <label for="address">Address:</label>
            <textarea id="address" name="address"></textarea><br><br>
        </div>
        
        <!-- Gender Field -->
        <div class="gender-options">
            <label>Gender:</label><br>
            <input type="radio" id="male" name="gender" value="Male">
            <label for="male">Male</label><br>
            <input type="radio" id="female" name="gender" value="Female">
            <label for="female">Female</label><br>
            <input type="radio" id="other" name="gender" value="Other">
            <label for="other">Other</label><br><br>
        </div>

        <!-- City Field -->
        <div class="form-group">
            <label for="city">City:</label>
            <input type="text" id="city" name="city" required><br><br>
        </div>

        <input type="submit" value="Register">
    </form>
</body>
</html>
