<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.training.entity.Policy" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Browse Policies</title>
</head>
<body>
<h2>Available Insurance Policies</h2>
<%
    List<Policy> policies = (List<Policy>) request.getAttribute("policies");
    if (policies != null && !policies.isEmpty()) {
%>
<table border="1">
    <tr>
        <th>Policy Name</th>
        <th>Premium/Month</th>
        <th>Duration</th>
        <th>Description</th>
        <th>Action</th>
    </tr>
<%
    for (Policy policy : policies) {
%>
    <tr>
        <td><%= policy.getPolicyType() %></td>
        <td>$<%= policy.getPremium() %></td>
        <td><%= policy.getDuration() %> months</td>
        <td><%= policy.getDescription() %></td>
        <td>
            <form action="purchase" method="post">
                <input type="hidden" name="policyId" value="<%= policy.getId() %>">
                <input type="submit" value="Purchase">
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
<p>No policies available. <a href="home.jsp">Back to Dashboard</a></p>
<%
    }
%>
<br><a href="home.jsp">Dashboard</a>
</body>
</html>
