<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.training.entity.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insurance Dashboard</title>
</head>
<body>
<%
    if (session.getAttribute("isAdmin") != null) {
        response.sendRedirect("admin.jsp");
        return;
    }
    
    Customer customer = (Customer) session.getAttribute("customer");
    if (customer == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<h2>Welcome, <%= customer.getName() %>!</h2>
<p>Email: <%= customer.getEmail() %></p>

<a href="purchases">My Purchases</a><br><br>
<a href="policies">Browse Policies</a><br><br>
<a href="logout">Logout</a>
</body>
</html>
