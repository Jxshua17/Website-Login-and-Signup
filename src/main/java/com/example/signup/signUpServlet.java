package com.example.signup;

import com.example.dao.Jdbc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/signup")
public class signUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username1 = req.getParameter("username1");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        Jdbc inputData = new Jdbc();

        try {
            if(password1.equals(password2)){
                inputData.insertValue(username1, password1);
                /*HttpSession session = req.getSession();
                session.setAttribute("username1", username1);
                session.setAttribute("password1", password1);*/
                //i think i created this session because i wanted to create a jsp that was going to confirm the passwords before inserting it into the database.
                //as far as this is concerned, i don't really need a session because i will not be sending data to the welcome jsp.

                resp.sendRedirect("welcome.jsp");
            } else{
                resp.sendRedirect("signUpError.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
