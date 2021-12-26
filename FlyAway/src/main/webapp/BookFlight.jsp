<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/26/21
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookFlight</title>
</head>
<body>
<br>
<a href="HomePage.jsp" style="color: black; text-decoration: none; font-size: 35px; font-weight: bold;">FlyAway</a>
<br>

<%
    @SuppressWarnings("unchecked")
    HashMap<String, String> user = (HashMap<String, String>) session.getAttribute("user");
    if (user == null){
        response.sendRedirect("UserPage.jsp");
    }
%>
<p align="center" style="color: greenyellow; font-size: 40px; font-weight: bold">Flight booked successful</p>
</body>
</html>
