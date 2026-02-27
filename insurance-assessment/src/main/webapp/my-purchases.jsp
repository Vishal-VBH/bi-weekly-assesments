<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.training.entity.Purchase" %>
<%@ page import="com.training.entity.Policy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Purchases</title>
</head>
<body>
<h2>My Purchase History</h2>
<%
    List<Purchase> purchases = (List<Purchase>) request.getAttribute("purchases");
    if (purchases != null && !purchases.isEmpty()) {
%>
<table border="1">
    <tr>
        <th>Policy Name</th>
        <th>Premium</th>
        <th>Duration</th>
        <th>Total Cost</th>
        <th>Purchase Date</th>
    </tr>
<%
    for (Purchase purchase : purchases) {
        Policy policy = purchase.getPolicy();
%>
    <tr>
        <td><%= policy.getPolicyType() %></td>
        <td><%= String.format("%.2f", policy.getPremium()) %>/month</td>
        <td><%= policy.getDuration() %> months</td>
        <td><%= String.format("%.2f", policy.getPremium() * policy.getDuration()) %></td>
        <td><%= purchase.getPurchaseDate() %></td>  
    </tr>
<%
    }
%>
</table>
<%
    } else {
%>
<p>No purchases yet. <a href="policies">Browse policies to purchase</a></p>
<%
    }
%>
<br><a href="home.jsp">← Dashboard</a>
</body>
</html>
