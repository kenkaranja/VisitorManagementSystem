package Servlets;

import Entities.AuditTrail;
import Entities.Receptionist;
import Events.AuditTrailEvent;
import Interfaces.LoginI;
import Qualifier.Login;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "ReceptionistLogin")
public class ReceptionistLogin extends Custom {
    @Inject
    @Login(value = Login.login.RECEPTIONIST)
    LoginI loginI;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("receptionistLogin.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (loginI.login(get(req, "username"), get(req, "password"))) {
            HttpSession session = req.getSession();
            session.setAttribute("user", get(req, "username"));
            resp.sendRedirect("receptionistHome");
        } else {
            doGet(req, resp);
        }
    }
}


