<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 20/10/2025
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Videos</title>
</head>
<body bgcolor="navy">
<%
    if (session.getAttribute("uname")==null){
        response.sendRedirect("login.jsp");
    }
%>

<h1>Videos</h1>
<h6>welcome to the videos section, ${uname}.</h6><br>

Video is loading... :)

</body>
</html>
