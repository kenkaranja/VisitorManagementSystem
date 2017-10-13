package Servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class Custom extends HttpServlet {
    public String get(HttpServletRequest request, String key) {
        return request.getParameter(key);
    }
}
