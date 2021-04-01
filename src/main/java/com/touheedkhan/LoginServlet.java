package com.touheedkhan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    private UserValidataionService service = new UserValidataionService();
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean isValid = service.isUserValid(username, password);
        if(isValid) {
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, res);
        }
    }

}
