<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 24/10/2025
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.example.login.Users" %>
<%@ page import="static com.example.dao.UsersDAO.users" %>

<html>
<head>
    <title>demo</title>
</head>
<body>
<h1>Testing jdbc with jsp</h1><br>

<%!
  String url = "jdbc:mysql://localhost:3306/datab";
  String username = "root";
  String password = "1955";
  String query = "select * from footballer";
%>

<%
  Users u1 = new Users();

  try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection(url, username, password);
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery(query);
    rs.next();
    while(rs.next()){ //step6->process result
      response.getWriter().println(rs.getString("id")+".........."+rs.getString("username")+"..........."+rs.getString("password"));
      //users.add(rs.getString(1), rs.getString(2), rs.getString(3));
      u1.id = Integer.parseInt(rs.getString("id"));
      u1.username = rs.getString("username");
      u1.password = rs.getString("password");
      users.add(u1);
    }
  }catch (Exception e){
    response.getWriter().println("there is an error here which is:" + e);
  }






%>



</body>
</html>
