package com.example.login;

import com.example.dao.Jdbc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String uname = req.getParameter("username");
        String password = req.getParameter("password");

        Jdbc db = new Jdbc();

        try {
            if(db.check(uname, password)){
                HttpSession session = req.getSession();
                session.setAttribute("uname", uname);
                session.setAttribute("pass", password);

                res.sendRedirect("welcome.jsp");
            } else{
                res.sendRedirect("signUp.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //for(Users x: users){
            /*if ((uname.equals("Joshua17")) && (password.equals("1234"))){
                HttpSession session = req.getSession();
                session.setAttribute("uname", uname);
                session.setAttribute("pass", password);

                res.sendRedirect("welcome.jsp");
            } else{
                res.sendRedirect("login.jsp");
            }*/


        /*for(Users x: users){

            if ((uname.equals(x.username)) && (password.equals(x.password))){
                HttpSession session = req.getSession();
                session.setAttribute("uname", uname);
                session.setAttribute("pass", password);

                res.sendRedirect("welcome.jsp");
            } else{
                res.sendRedirect("login.jsp");
            }
        }*/






    }
}