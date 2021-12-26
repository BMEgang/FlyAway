<%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/26/21
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>reset password</title>
</head>
<body style = "background-image: url('image/background.jpeg')">
<br>
<a href="HomePage.jsp" style="color: black; text-decoration: none; font-size: 35px; font-weight: bold;">FlyAway</a>
<br><br>
<center>
    <div style="border: 3px solid black; width: 25%; border-radius: 20px; padding: 20px" align="center">
        <form action="ForgotPassword" method="post">
            email <input type="email" name="email"><br>
            password <input type="password" name="password"><br>
            <input type="submit" value="submit"/> <input type="reset" value="reset"/>
        </form>
    </div>
</center>
</body>
</html>
