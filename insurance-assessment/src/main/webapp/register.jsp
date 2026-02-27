<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Registration</title>
</head>
<body>
<h2>Customer Registration</h2>
<%
    String success = (String) request.getAttribute("successMessage");
    if (success != null) {
%>
    <p><%= success %></p>
    <a href="login.jsp">Back to Login</a>
<%
    } else {
%>
<form action="register" method="post">
    Name: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email" required><br><br>
    Phone: <input type="tel" name="phone" required><br><br>
    Address: <textarea name="address" required></textarea><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Register">
</form>
<p><a href="login.jsp">Already have account? Login</a></p>
<%
    }
%>
</body>
</html>
