package com.example.login;

import com.example.dao.Jdbc;
import com.example.entities.Usxrs;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws HibernateException, IOException {

        String uname = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            System.out.println("trying this hibernate thing instead of JDBC");

            Configuration config = new Configuration();
            config.configure();
            config.addAnnotatedClass(Usxrs.class);

            SessionFactory sf = config.buildSessionFactory();
            Session sessionOfHibernate = sf.openSession();
            //most of my confusion here had to do with the fact i thought you couldn't make a string an id
            //but i have experimented with my initial hibernate project and it works fine
            Usxrs user = sessionOfHibernate.find(Usxrs.class, uname);

            if(user == null){
                res.sendRedirect("signUp.jsp");
            } else{
                //assert user != null;
                String tempUsername = user.getUsername();
                String tempPassword = user.getPassword();

                System.out.println("the password of this user is "+ tempPassword);

                if(uname.equals(tempUsername) && password.equals(tempPassword)){

                    HttpSession session = req.getSession();
                    session.setAttribute("uname", uname);
                    session.setAttribute("pass", password); //i am questioning the relevance of this line because it is not really needed in  the welcome.jsp file
                    //i have thought long and hard about this line 49, and it is not needed at all.

                    res.sendRedirect("welcome.jsp");
                }
            }


        } catch (Exception e){
            System.out.println("the exception is "+ e);
            e.printStackTrace();
        }


        /*try {
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
        }*/

    }
}