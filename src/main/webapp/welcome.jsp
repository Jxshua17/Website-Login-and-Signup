<%@ page import="com.example.login.Users" %>
<%@ page import="static com.example.dao.UsersDAO.users" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 20/10/2025
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>welcome</title>
</head>
<body bgcolor="#dcdcdc">

<%
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");

    if (session.getAttribute("uname") == null) {
        response.sendRedirect("login.jsp");
    }
%>
debugging...<br>


welcome to debugging mode...<br>
<c:set var="joshua" value="${fn:toUpperCase(var)}"/>
WELCOME, ${fn:toUpperCase(uname)}
</body>
<br><br>

<br>

<%
    for (Users x : users) {
        response.getWriter().println(x.id + "......." + x.username + ".........." + x.password);
    }
%>

<br>


<a href="videos.jsp">Videos</a><br>

<form action="logout">
    <input type="submit" value="Logout">
</form>
</html>
