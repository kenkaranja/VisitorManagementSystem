package Servlets;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "HostNotify")
public class HostChat extends Custom {
//    @EJB
//    private MessageReceiverSync receiverSync;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
//        String message = receiverSync.receiveMessage();
//        out.println("Message received" + message);
        RequestDispatcher rd = req.getRequestDispatcher("HostNotify.jsp");
        rd.forward(req, resp);
    }
}
