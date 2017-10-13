package Servlets;

import Entities.Host;
import Entities.Receptionist;
import Enums.Gender;
import Interfaces.HostI;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "addHost")
public class AddHost extends Custom {
    @EJB
   private HostI hostI;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AddHost.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Host host = new Host();
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        addHost(req, host);
        if (hostI.add(host)) {
            out.print("<html><body><p> Successfully Added! : <a href=\"HostLogin.jsp\">Login</a> </p></body></html>");
        } else {
            out.print("<html><body><p>Error Occured! : <a href=\"addHost\">Back</a> </p></body></html>");
        }
    }

    private void addHost(HttpServletRequest req, Host host) {
        host.setPassword(get(req, "password"));
        host.setUsername(get(req, "username"));
        host.setWorkId(get(req, "workid"));
        host.setAddress(get(req, "address"));
        host.setEmail(get(req, "email"));
        host.setName(get(req, "name"));
        host.setPhoneNumber(get(req, "contact"));
        if (get(req, "gender").equals("male")) {
            host.setGender(Gender.MALE);
        } else if (get(req, "gender").equals("female")) {
            host.setGender(Gender.FEMALE);
        }
    }
}
