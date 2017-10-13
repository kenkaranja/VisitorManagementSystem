package Servlets;

import Entities.Activity;
import Entities.Visitor;
import Enums.VisitStatus;
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

@WebServlet(urlPatterns = "CheckIn")
public class CheckIn extends Custom {

    @EJB
    private VisitorI visitorI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("checkin.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Activity activity = new Activity();
        Visitor visitor = new Visitor();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        HttpSession session = req.getSession(false);
        visitor.setIdNumber(String.valueOf(session.getAttribute("id")));
        Visitor v = visitorI.getById(visitor);
        if (v != null) {
            recordActivity(req, activity, v);
            if (visitorI.checkIn(v, activity)) {
                out.print("<html><body><p> Successfully CheckIn! : <a href=\"ReceptionistNotify\">Send Message</a> </p></body></html>");
            } else {
                out.print("<html><body><p>Error Occured! : <a href=\"CheckIn\">Back</a> </p></body></html>");
            }
        }


    }

    private void recordActivity(HttpServletRequest req, Activity activity, Visitor v) {
        activity.setDate(get(req, "date"));
        activity.setPersonVisited(get(req, "personvisited"));
        activity.setStatus(VisitStatus.CHECK_IN);
        activity.setPurpose(get(req, "purpose"));
        activity.setVisitor(v);
    }
}
