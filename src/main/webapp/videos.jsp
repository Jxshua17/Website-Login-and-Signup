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

    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

    if (session.getAttribute("uname")==null){
        response.sendRedirect("login.jsp");
    }
%>

<center>
    <h1>Videos</h1>
    <h6>welcome to the videos section, ${uname}.</h6><br>

    Video is loading... :)
    <br>

    <iframe width="560" height="315" src="https://www.youtube.com/embed/4XTsAAHW_Tc?si=UBaPbr50HBDf-HOR" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
    <br>
    <form action="logout">
        <input type="submit" value="Logout">
    </form>
</center>


</body>
</html>
