<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.training.entity.Policy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase Confirmation</title>
</head>
<body>
<%
    Policy policy = (Policy) request.getAttribute("policy");
    String message = (String) request.getAttribute("message");
%>
<h2>Purchase Successful!</h2>
<p>Name: <%= policy.getPolicyType() %></p>
<p>Premium: <%= policy.getPremium() %>/month</p>
<p>Duration: <%= policy.getDuration() %> months</p>
<p>Total Cost: <%= String.format("%.2f", policy.getPremium() * policy.getDuration()) %></p>
<p><%= message != null ? message : "Purchase recorded successfully!" %></p>
<br>
<a href="policies">Browse More Policies</a>
<a href="home.jsp">Dashboard</a>
</body>
</html>
