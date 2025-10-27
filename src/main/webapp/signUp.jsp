<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 27/10/2025
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>

<h3>would you want to sign up instead?</h3>

<form action="signup" method="post">
    Username: <input type="text" name="username1"><br>
    password: <input type="text" name="password1"><br>
    <input type="submit" name="sign up"><br>
    <br>
    <h3 style="color: #ff0000">Please note, you're only going to be inputting your username and password once which you'll use to log in afterwards.</h3><br>
    <h4 style="color: #11a439">Afterwards, you'll be redirected to the login page to use the username and password you just entered</h4><br>

</form>

</body>
</html>
