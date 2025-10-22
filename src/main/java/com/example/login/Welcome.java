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

@WebServlet("/welcome")
public class Welcome extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String username = (String)session.getAttribute("uname");
        String password = (String)session.getAttribute("pass");

        if((username.equals("Joshua17")) && (password.equals("1234"))){
            res.sendRedirect("welcome.jsp");
        } else{
            res.sendRedirect("login.jsp");
        }
    }
}
