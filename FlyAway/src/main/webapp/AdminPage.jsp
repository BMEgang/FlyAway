<%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/26/21
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body style = "background-image: url('image/background.jpeg')">
<br>
<center>
    <h2>Admin Login</h2>
    <div style="border: 3px solid black; width: 25%; border-radius: 20px;padding: 20px" align="center">
        <form action="/AdminLogin" method="post">
            Email    <input type="email" name="email"><br>
            password <input type="password" name="password"><br>
            <input type="submit" value="submit"/> <input type="reset" value="reset"/>
        </form>
    </div>
</center><br>
<a href="ForgotPassWord.jsp" style="font-size: 25px;color: red;">Forgot Password</a>
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
