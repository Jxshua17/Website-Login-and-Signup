<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 20/10/2025
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Welcome</h1><br>
<h4>Please, log in below</h4><br><br>
<%
    //TODO create a different input in the form for signing up straight away instead of doing there through the login page
%>
<form action="login">
  Username: <input type="text" name="username"><br>
  password: <input type="password" name="password"><br>
  <input type="submit" value="login">
</form>

</body>
</html>
