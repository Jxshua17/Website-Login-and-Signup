package com.example.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.example.dao.UsersDAO.users;


@WebServlet("/demo")
public class demo extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Users a = new Users();

        a.password = "2234";
        a.username = "joshua";
        a.id = 314;


        for (Users x : users) {
            res.getWriter().println(a.id + "......." + a.username + ".........." + a.password);
            System.out.println(a.id);
        }

        res.getWriter().println("hello from the demo servlet in this website.");
        res.getWriter().println(a.id + "......." + a.username + ".........." + a.password);

        res.getWriter().println(users.size());

    }
}
