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
    <title>Admin Home</title>
</head>
<body style = "background-image: url('image/background.jpeg')">
    <br>
    <a href="HomePage.jsp" style="color: black; text-decoration: none; font-size: 35px; font-weight: bold;">FlyAway</a>
    <br>
    <center>
        <h1>Please Insert New Flight Details</h1>
        <div style="border: 3px solid black;width: 25%;border-radius: 20px;padding: 20px" align="center">
            <form action="InsertFlight" method="post">
                Name:       <input type="text" name="Name"> <br>
                From:       <input type="text" name="From"> <br>
                To:         <input type="text" name="To"> <br>
                Departure:  <input type="date" name="Departure"> <br>
                Time:       <input type="time" name="Time"> <br>
                Price:      <input type="text" name="Price"> <br>
                <input type="submit" value="submit">
                <input type="reset">
            </form>
        </div>
    </center>
<%
    String message = (String) session.getAttribute("message");
    if (message != null){
%>
<p style="color: red"><%=message%></p>
<%
        session.setAttribute("message",null);
    }
%>
</body>
</html>
