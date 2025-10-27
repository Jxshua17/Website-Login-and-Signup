package com.example.dao;
import java.sql.*;
public class Jdbc {

    String url = "jdbc:mysql://localhost:3306/datab";
    String username = "root";
    String password = "1955";

    String query = "select * from users where username=? and password = ?";

    String query1 = "insert into users values(?,?,?)";

    Connection con = null;

    public void connection() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url,username, password);
    }

    public boolean check(String uname, String pass){


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, uname);
            st.setString(2, pass);

            ResultSet rs = st.executeQuery();

            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public void insertValue(String uname, String pass) throws Exception {
        //i want to use this method to input data into the database from the signup page of a new user.
        connection();
        PreparedStatement st = con.prepareStatement(query1);

        st.setInt(1, 6);
        st.setString(2, uname);
        st.setString(3, pass);

        int rs = st.executeUpdate();

        System.out.println(rs+" row(s) affected.");

        //inserting values in jdbc using the DAO is completely different from fetching this data

    }
}
