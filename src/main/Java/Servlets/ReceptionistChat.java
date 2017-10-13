package Servlets;


import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "ReceptionistNotify")
public class ReceptionistChat extends Custom {
//    @EJB
//    private MessageSender sender;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
//        String message = "You have a message from Receptionist";
//        sender.sendMessage(message);
//        out.print("<body><html> Message Sent:" + message + "</html><body>");
        RequestDispatcher rd = req.getRequestDispatcher("ReceptionistNotify.jsp");
        rd.forward(req, resp);
    }
}
