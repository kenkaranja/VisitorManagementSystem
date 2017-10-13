package Servlets;

import Entities.Visitor;
import Interfaces.VisitorI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "SearchVisitor")
public class SearchVisitor extends Custom {
    @EJB
    private VisitorI visitorI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("SearchVisitor.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Visitor visitor = new Visitor();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        visitor.setIdNumber(get(req, "idNumber"));
        HttpSession session = req.getSession();
        session.setAttribute("id", get(req, "idNumber"));
        Visitor visitor1 = visitorI.getById(visitor);
        if (visitor1 != null) {
            out.print("<html><body><p>VisitorDao Exists! : <a href=\"CheckIn\">Check In visitor</a> </p></body></html>");
        } else {
            out.print("<html><body><p>VisitorDao Doesn't Exist! : <a href=\"AddVisitor\">Register VisitorDao</a> </p></body></html>");
        }
    }
}
