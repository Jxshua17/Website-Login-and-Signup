package com.example.signup;

import com.example.dao.Jdbc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/signup")
public class signUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username1 = req.getParameter("username1");
        String password1 = req.getParameter("password1");

        Jdbc inputData = new Jdbc();

        try {
            inputData.insertValue(username1, password1);
            HttpSession session = req.getSession();
            session.setAttribute("username1", username1);
            session.setAttribute("password1", password1);

            resp.sendRedirect("welcome.jsp");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
