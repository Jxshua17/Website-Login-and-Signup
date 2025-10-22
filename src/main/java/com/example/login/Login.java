package com.example.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
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

        if ((uname.equals("Joshua17")) && (password.equals("1234"))){
            HttpSession session = req.getSession();
            session.setAttribute("uname", uname);
            session.setAttribute("pass", password);

            res.sendRedirect("welcome.jsp");
        } else{
            res.sendRedirect("login.jsp");
        }


    }
}