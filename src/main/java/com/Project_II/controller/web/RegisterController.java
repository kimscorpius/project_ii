package com.Project_II.controller.web;

import com.Project_II.service.IUserService;
import com.Project_II.service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String alert = request.getParameter("alert");
        if (alert != null) {
            String val = resourceBundle.getString(alert);
            request.setAttribute("alertMsg", new String(val.getBytes("ISO-8859-1"), "UTF-8"));
        }
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            response.sendRedirect(request.getContextPath() + "/admin");
            return;
        }
        // Check cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = request.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    response.sendRedirect(request.getContextPath() + "/admin");
                    return;
                }
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/views/register.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        IUserService service = new UserService();

        if (service.checkExistEmail(email)) {
            resp.sendRedirect(req.getContextPath() + "/register?alert=email_invalid");
            return;
        }
        if (service.checkExistUsername(username)) {
            resp.sendRedirect(req.getContextPath() + "/register?alert=username_invalid");
            return;
        }

        boolean isSuccess = service.register(name, email, username, password);

        if (isSuccess) {
            resp.sendRedirect(req.getContextPath() + "/register?alert=successful");
        } else {
            resp.sendRedirect(req.getContextPath() + "/register?alert=error");
        }
    }
}
