package Servlets;

import Interfaces.LoginI;
import Qualifier.Login;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "hostLogin")
public class HostLogin extends Custom {
    @Inject
    @Login(Login.login.HOST)
    LoginI loginI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("HostLogin.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (loginI.login(get(req, "username"), get(req, "password"))) {
            HttpSession session = req.getSession();
            session.setAttribute("user", get(req, "username"));
            resp.sendRedirect("hostHome");
        }
    }
}
