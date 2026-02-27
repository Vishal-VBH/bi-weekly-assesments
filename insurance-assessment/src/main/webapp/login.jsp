<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insurance Portal - Login</title>
</head>
<body>
<h2>Insurance Policy Management System</h2>

<%
    String logoutMsg = (String) request.getAttribute("logoutMessage");
    if (logoutMsg != null) {
%>
    <p><%= logoutMsg %></p>
<%
    }
    
    String error = (String) request.getAttribute("errorMessage");
    if (error != null) {
%>
    <p><%= error %></p>
<%
    }
%>

<form action="login" method="post">
    Login As: 
    <select name="userType" required>
        <option value="">Select...</option>
        <option value="admin">Admin</option>
        <option value="customer">Customer</option>
    </select><br><br>
    
    Email: <input type="email" name="email" required><br><br>
    Password: <input type="password" name="password" required><br><br>
    <input type="submit" value="Login">
</form>

<hr>
<p>New Customer? <a href="register.jsp">Register Here</a></p>

<script>
document.querySelector('select[name="userType"]').addEventListener('change', function() {
    var hint = document.getElementById('adminHint');
    if (this.value === 'admin') {
        hint.style.display = 'block';
    } else {
        hint.style.display = 'none';
    }
});
</script>

<div id="adminHint" style="display:none;">
    <p><strong>Admin:</strong> admin@insurance.com / Admin@123</p>
</div>
</body>
</html>
