<%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/26/21
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<body style = "background-image: url('image/background.jpeg')">
<br>
<a href="HomePage.jsp" style="color: black; text-decoration: none; font-size: 35px; font-weight: bold;">FlyAway</a>
<br><br>
<center>
    <h2>User Login</h2>
    <div style="border: 3px solid black;width: 25%;border-radius: 20px;padding: 20px" align="center">
        <form action="/UserLogin" method="post">
            Email    <input type="email" name="email"><br>
            password <input type="password" name="password"><br>
            <input type="submit" value="submit"/> <input type="reset" value="reset"/>
        </form>
    </div>
</center>
<br><br>
<i>New User-Create account</i>
<h4><a href="UserRegistration.jsp" style="font-size: 25px;color: red;">Create Account</a> </h4>

<%
    String message = (String) session.getAttribute("message");
    if (message != null) {
%>
<p style="color: red;"><%=message%>></p>
<%
        session.setAttribute("message",null);
    }
%>

</body>
</html>
