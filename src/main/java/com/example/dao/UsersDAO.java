package com.example.dao;
import com.example.login.Users;

import java.sql.*; //step1-> import the package.
import java.util.ArrayList;
import java.util.List;


//there is actually no use for this bunch of code. before stumbling upon how Navin checked...
//...the passwords of users before they are logged in, this was my attempt at a solution.
public class UsersDAO {

    public static List<Users> users = new ArrayList<>();

    //public void connect() throws Exception {
    public static void main(String [] args) throws ClassNotFoundException, SQLException {


        Class.forName("com.mysql.cj.jdbc.Driver"); //step2->load and register the driver

        String url = "jdbc:mysql://localhost:3306/datab";
        String username = "root";
        String password = "1955";
        String query = "select * from users";

        Users u1 = new Users();



        Connection con = DriverManager.getConnection(url, username, password); //step3-establish the connection.

        Statement st = con.createStatement(); //step4-> create the statement

        ResultSet rs = st.executeQuery(query); //step5->execute the query.

        rs.next();

        while(rs.next()){ //step6->process result
            System.out.println(rs.getString("id")+".........."+rs.getString("username")+"..........."+rs.getString("password"));
            //users.add(rs.getString(1), rs.getString(2), rs.getString(3));
            u1.id = Integer.parseInt(rs.getString("id"));
            u1.username = rs.getString("username");
            u1.password = rs.getString("password");
            users.add(u1);
        }



        st.close(); //step7->close the connection.
        con.close();

    }
}
