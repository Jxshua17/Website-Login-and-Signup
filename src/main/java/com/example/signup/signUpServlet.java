package com.example.signup;

import com.example.dao.Jdbc;
import com.example.entities.Usxrs;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/signup")
public class signUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username1 = req.getParameter("username1");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");

        //Jdbc inputData = new Jdbc();

        //TODO first thing to do is to try and use a random method for creating the id of the new user -> there is no need for this since i implemented the second TODO.

        //TODO second thing(option more like) is fetching the total number of users in the dB and then adding one to that number and using that as the id of the new user -> implemented.

        //TODO it just occurred to me while testing this that it'll make sense to check the database first for the username first before then saving but i guess the merge method already does that.

        Usxrs user = new Usxrs();
        user.setUsername(username1);
        user.setPassword(password1);


        Configuration config = new Configuration();
        config.configure();
        config.addAnnotatedClass(Usxrs.class);

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        //getting the count worked in the hibernate project, now to test it out here.
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Usxrs> root = cq.from(Usxrs.class);

        cq.select(cb.count(root));

        Long count = session.createQuery(cq).getSingleResult(); //you never know the amount of users so it has to be Long to accommodate a much larger amount.

        Long userId = count+1;
        user.setId(userId);

        if(password1.equals(password2)){
            session.merge(user);

            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", username1);

            resp.sendRedirect("welcome.jsp");
        } else{
            resp.sendRedirect("signUpError.jsp");
        }

        tx.commit();

        sessionFactory.close();
        session.close();
    }
}


