package Servlets;

import Entities.Visitor;
import Enums.Gender;
import Enums.VisitStatus;
import Enums.VisitorCategory;
import Interfaces.VisitorI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "AddVisitor")
public class AddVisitor extends Custom {
    @EJB
    private VisitorI visitorI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("addvisitor.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        Visitor visitor = new Visitor();
        addVisitor(req, visitor);
        if (visitorI.add(visitor)) {
            out.print("<html><body><p> Successfully Added! : <a href=\"receptionistHome\">Home</a> </p></body></html>");
        } else {
            out.print("<html><body><p>Error Occured! : <a href=\"AddVisitor\">Back</a> </p></body></html>");
        }
    }

    private void addVisitor(HttpServletRequest req, Visitor visitor) {
        visitor.setIdNumber(get(req, "idNumber"));

        visitor.setAddress(get(req, "address"));
        visitor.setPhoneNumber(get(req, "contact"));
        visitor.setEmail(get(req, "email"));
        visitor.setName(get(req, "name"));
        visitor.setStatus(VisitStatus.CHECK_OUT);
        if (get(req, "category").equals("vip")) {
            visitor.setVisitorCategory(VisitorCategory.VIP);
        } else if (get(req, "category").equals("normal")) {
            visitor.setVisitorCategory(VisitorCategory.NORMAL);
        }
        if (get(req, "gender").equals("male")) {
            visitor.setGender(Gender.MALE);
        } else if (get(req, "gender").equals("female")) {
            visitor.setGender(Gender.FEMALE);
        }
    }
}
