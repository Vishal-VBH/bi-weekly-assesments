<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.training.entity.Policy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel - Manage Policies</title>
</head>
<body>
<%
    // Admin check
    if (session.getAttribute("isAdmin") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<h2>Admin Panel</h2>
<p>Welcome, <%= session.getAttribute("adminEmail") %> | 
   <a href="logout">Logout</a></p>

<!-- Add New Policies Button -->
<h4 >--Add New Policy--</h4>
<form action="admin" method="post">
    <input type="hidden" name="action" value="add">
    Policy Type (Health/Life/Vehicle): <input type="text" name="name" required><br><br>
    Premium (Rupees/month): <input type="number" name="premium" step="0.01" required><br><br>
    Duration (months): <input type="number" name="duration" required><br><br>
    Description: <textarea name="description" required></textarea><br><br>
    <input type="submit" value="Save Policy">
</form>

<!-- Current Policies Table -->
<h3>Current Policies</h3>
<%
    List<Policy> policies = (List<Policy>) request.getAttribute("policies");
    if (policies != null && !policies.isEmpty()) {
%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Policy Type</th>
        <th>Premium</th>
        <th>Duration</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
<%
    for (Policy p : policies) {
%>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getPolicyType() %></td> 
        <td><%= String.format("%.2f", p.getPremium()) %></td>
        <td><%= p.getDuration() %> months</td>
        <td><%= p.getDescription() %></td>
        <td>
            <form action="admin" method="post" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="policyId" value="<%= p.getId() %>">
                <input type="submit" value="Delete" onclick="return confirm('Delete policy: <%= p.getPolicyType() %>?')">
            </form>
        </td>
    </tr>
<%
    }
%>
</table>
<%
    } else {
%>
<p>No policies found. Add your first policy above!</p>
<%
    }
%>

<br>
<a href="policies">Viewall Customer Policies</a>
</body>
</html>
