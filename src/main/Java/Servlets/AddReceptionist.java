package Servlets;

import Entities.Receptionist;
import Enums.Gender;
import Interfaces.ReceptionistI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "AddReceptionist")
public class AddReceptionist extends Custom {
    @EJB
    private ReceptionistI receptionistI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AddReceptionist.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Receptionist receptionist = new Receptionist();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        addReceptionist(req, receptionist);
        if (receptionistI.add(receptionist)) {
            out.print("<html><body><p> Successfully Added! : <a href=\"receptionistLogin.jsp\">CheckIn</a> </p></body></html>");
        } else {
            out.print("<html><body><p>Error Occured! : <a href=\"AddReceptionist\">Back</a> </p></body></html>");
        }
    }

    private void addReceptionist(HttpServletRequest req, Receptionist receptionist) {
        receptionist.setPassword(get(req, "password"));
        receptionist.setUsername(get(req, "username"));
        receptionist.setWorkId(get(req, "workid"));
        receptionist.setAddress(get(req, "address"));
        receptionist.setEmail(get(req, "email"));
        receptionist.setName(get(req, "name"));
        receptionist.setPhoneNumber(get(req, "contact"));
        if (get(req, "gender").equals("male")) {
            receptionist.setGender(Gender.MALE);
        } else if (get(req, "gender").equals("female")) {
            receptionist.setGender(Gender.FEMALE);
        }
    }
}
