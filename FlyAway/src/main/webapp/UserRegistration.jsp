<%--
  Created by IntelliJ IDEA.
  User: ganghu
  Date: 12/26/21
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body style = "background-image: url('image/background.jpeg')">
<br>
<a href="HomePage.jsp" style="color: black; text-decoration: none; font-size: 35px; font-weight: bold;">FlyAway</a>
<br><br>
<center>
    <div style="border: 3px solid black;width: 25%;border-radius: 20px;padding: 20px" align="center">
        <form action="UserRegistration" method="post">
            Email    <input type="email" name="email"><br>
            password <input type="password" name="password"><br>
            name <input type="text" name="name"><br>
            phone <input type="text" name="phone"><br>
            adress <input type="text" name="adress"><br>
            <input type="submit" value="submit"/> <input type="reset" value="reset"/>
        </form>
    </div>
</center>
<br><br>
</body>
</html>
