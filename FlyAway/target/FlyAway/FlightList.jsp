<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/26/21
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style = "background-image: url('image/background.jpeg')">
<br>
<a href="HomePage.jsp" style="color: black; text-decoration: none; font-size: 35px; font-weight: bold;">FlyAway</a>
<br>
<%
    @SuppressWarnings("unchecked")
    List<String[]> flights = (List<String[]>) session.getAttribute("flights");
    if (flights != null){
%>
<h1>Available Fights</h1>
<center>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Time</th>
            <th>Price</th>
        </tr>

        <%
            for (String[] flight:flights) {
        %>

        <tr>
            <td><%=flight[0]%></td>
            <td><%=flight[1]%></td>
            <td><%=flight[2]%></td>
        </tr>
    </table>
</center>
<center><a href="BookFlight.jsp">Book Now</a> </center>
<%
    }
%>

<%
    }
    else{
%>
<h1>There are no available flights</h1>
<%
    }
%>
</body>
</html>
