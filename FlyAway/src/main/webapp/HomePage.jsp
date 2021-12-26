<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/26/21
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body style = "background-image: url('image/background.jpeg')">
<h1>FlyAway</h1>
<%
    @SuppressWarnings("unchecked")
    HashMap<String,String> user = (HashMap<String, String>) session.getAttribute("user");
    if(user != null){
%>
<p>welcome <%=user.get("name")%></p>
<a href="/LogOut">Logout</a>
<%
    }else{
%>
<a href="index.jsp">welcome page</a>
<%
    }
%>
<br><br>
<center>
    <div style="border: 3px solid black;width: 25%;border-radius: 20px;padding: 20px" align="center">
        <form action="FlightList" method="post">
            From: <input type="text" name="From"><br>
            To: <input type="text" name="To"><br>
            Departure: <input type="text" name="Departure"><br>
            <input type="submit" value="search"/> <input type="reset" value="reset"/>
        </form>
    </div>
</center>
</body>
</html>
