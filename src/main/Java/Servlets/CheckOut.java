package Servlets;

import Entities.Activity;
import Entities.Visitor;
import Enums.VisitStatus;
import Interfaces.ActivityI;
import Interfaces.VisitorI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "CheckOut")
public class CheckOut extends Custom {
    @EJB
    private VisitorI visitorI;

    @EJB
    private ActivityI activityI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("CheckOut.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Activity activity = new Activity();
        Visitor visitor = new Visitor();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        visitor.setIdNumber(get(req, "idNumber"));
        Visitor v = visitorI.getById(visitor);
        if (v != null) {
            activity.setStatus(VisitStatus.CHECK_OUT);
            activity.setDate(get(req, "date"));
            activity.setVisitor(v);
            Activity a = activityI.getById(activity);
            activity.setPersonVisited(a.getPersonVisited());
            activity.setPurpose(a.getPurpose());
            v.setStatus(VisitStatus.CHECK_OUT);
            if (visitorI.checkOut(v, activity)) {
                out.print("<html><body><p> Successfully Checked Out! : <a href=\"receptionistHome\">Home</a> </p></body></html>");
            } else {
                out.print("<html><body><p>Error Occured! : <a href=\"CheckOut\">Back</a> </p></body></html>");
            }
        }
    }
}
