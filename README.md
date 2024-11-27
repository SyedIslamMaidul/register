Java Web Application with Servlets and JSP (CRUD Operations)
This is a Java web application that uses Servlets and JSP to perform basic CRUD (Create, Read, Update, Delete) operations. The application interacts with a MySQL database to register, update, select, and delete user information.

Table of Contents
Prerequisites
Setup and Configuration
Database Setup
Application Setup
Running the Application
Testing the Application
Troubleshooting
1. Prerequisites
Before you begin, make sure you have the following installed on your local machine:

JDK 11 or higher (Java Development Kit)
Apache Tomcat 9+ (or any other Java EE compatible server)
MySQL 5.7 or higher
IDE like Eclipse, IntelliJ IDEA, or NetBeans (optional but recommended)
Steps to Install the Prerequisites:
JDK Installation:
Download the JDK from the official Oracle JDK website.
Follow the instructions to install it on your system.
Verify the installation by running:
bash
Copy code
java -version
Apache Tomcat Installation:
Download Apache Tomcat from the official Apache Tomcat Downloads.
Extract the ZIP file and set the CATALINA_HOME environment variable to the Tomcat directory.
Verify the installation by navigating to http://localhost:8080 in your web browser. You should see the Tomcat welcome page.
MySQL Installation:
Download and install MySQL from the official MySQL Downloads.

After installation, make sure to start the MySQL service:

On Windows, you can start it from the MySQL Workbench or command line.
On Linux, you can run: sudo service mysql start.
Verify the installation by running:

bash
Copy code
mysql -u root -p
2. Setup and Configuration
A. Database Setup
Create Database:

Open MySQL Workbench or connect to MySQL via command line.
Run the following command to create a database:
sql
Copy code
CREATE DATABASE yt_regist;
Create Table:

Run the following SQL script to create the register table:
sql
Copy code
USE yt_regist;

CREATE TABLE register (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) NOT NULL UNIQUE,
    dob VARCHAR(8),
    phone VARCHAR(15),
    gender VARCHAR(10),
    city VARCHAR(100)
);
Insert Sample Data (Optional): If you want to insert sample data for testing:

sql
Copy code
INSERT INTO register (name, email, dob, phone, gender, city) VALUES
('John Doe', 'john.doe@example.com', '19901231', '1234567890', 'Male', 'New York'),
('Jane Smith', 'jane.smith@example.com', '19850625', '9876543210', 'Female', 'Los Angeles');
B. Application Setup
Clone or Download the Application:

If you’re cloning the repository:
bash
Copy code
git clone https://github.com/yourusername/yt-regist-app.git
cd yt-regist-app
Set up Database Connection in web.xml or Java Code:

Ensure that your DeleteServlet.java, SelectServlet.java, RegisterServlet.java, and UpdateServlet.java files have the correct database connection details (localhost:3306/yt_regist).
You may use the following connection URL format in your Java code:
java
Copy code
String url = "jdbc:mysql://localhost:3306/yt_regist";
String user = "root";
String password = "password";  // Change this to your MySQL root password
Build and Deploy the Application:

If you are using Eclipse or IntelliJ IDEA, import the project as a Dynamic Web Project.
Add the mysql-connector-java dependency to your lib folder or include it in your pom.xml if using Maven.
Deploy to Apache Tomcat:

Copy your project into the webapps folder of the Tomcat installation directory (e.g., C:/apache-tomcat-9/webapps/yourapp).
Alternatively, use your IDE’s Tomcat plugin to deploy the application.
3. Running the Application
Start Tomcat:

Run startup.sh (Linux/Mac) or startup.bat (Windows) from the bin folder in your Tomcat directory.
If using an IDE like Eclipse or IntelliJ, simply start the Tomcat server from the IDE.
Access the Application:

Open your browser and navigate to:
bash
Copy code
http://localhost:8080/yourapp/register.jsp
Testing CRUD Operations:

Register a User: Use the register.jsp form to create a new user.
Select (View) User Details: Use the select.jsp form to search for a user by email.
Update User: Use the update.jsp form to edit the user's information.
Delete User: Use the deleteUser.jsp form to delete a user by email.
4. Testing the Application
Register a user via the register.jsp page by entering the details.
Select a user by email via the select.jsp page to view the registered user's details.
Update the user’s information via the update.jsp page, and check if the changes reflect in the database.
Delete a user by email via the deleteUser.jsp page.
Example URLs for Testing:
Register User: http://localhost:8080/yourapp/register.jsp
View User: http://localhost:8080/yourapp/select.jsp?email=user@example.com
Update User: http://localhost:8080/yourapp/update.jsp?email=user@example.com
Delete User: http://localhost:8080/yourapp/deleteUser.jsp
5. Troubleshooting
MySQL Connection Error: Ensure that the MySQL service is running, and the connection URL in your Java code is correct (localhost:3306/yt_regist).

Tomcat Errors: Check the logs directory in the Tomcat installation for detailed error logs (catalina.out or localhost.<date>.log).

Servlet Mapping Errors: Ensure that all servlet mappings in web.xml or annotations in the servlet classes (@WebServlet) are correct.

Database Error: Double-check the database credentials, table structure, and MySQL server status.
