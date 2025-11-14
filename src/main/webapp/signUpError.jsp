<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 14/11/2025
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password Error</title>
</head>
<body>

<h3>There was an error with the passwords you inputted. Please, sign up again.</h3>

<form action="signup" method="post">
    Username: <input type="text" name="username1"><br>
    password: <input type="text" name="password1"><br>
    Confirm password: <input type="text" name="password2"><br>
    <input type="submit" name="sign up"><br>
    <br>
    <h3 style="color: #ff0000">Please note, you're only going to be inputting your username once and password twice(the second is to confirm password) which you'll use to log in afterwards.</h3><br>
    <h4 style="color: #11a439">Afterwards, you'll be redirected to the login page to use the username and password you just entered</h4><br>

</form>

</body>
</html>
