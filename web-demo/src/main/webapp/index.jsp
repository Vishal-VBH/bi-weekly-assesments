<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>Welcome to web application  - served by jsp</h1>
 <!--<a href=<%=request.getContextPath()%>/home> Click here for home dynamic context path</a>-->
 
 <form action="<%=request.getContextPath()%>/login" method="post">
 <hr/>
 Username : <input type = "text" placeholder="Enter name" name = "userName"/> <br/><br/>
 Password : <input type = "text" placeholder="Enter password" name = "password"/> <br/><br/>
 
 <input  type = "submit" value="login"/> 
 </form>
</body>
</html>