package com.Project_II.controller.web;

import com.Project_II.model.User;
import com.Project_II.service.IUserService;
import com.Project_II.utils.Constant;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Inject
    private IUserService userService;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String alert = request.getParameter("alert");
        if (alert != null) {
            String val = resourceBundle.getString(alert);
            request.setAttribute("alertMsg", new String(val.getBytes("ISO-8859-1"), "UTF-8"));
        }
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            response.sendRedirect(request.getContextPath()+ "/waiting");
            return;
        }
        // Check cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    session = request.getSession(true);
                    session.setAttribute("username", cookie.getValue());
                    response.sendRedirect(request.getContextPath()+ "/waiting");
                    return;
                }
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/web/views/login.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isRememberMe = false;
        String remember = request.getParameter("remember");

        if ("on".equals(remember)){
            isRememberMe = true;
        }
        if(username.isEmpty() || password.isEmpty()){
            response.sendRedirect(request.getContextPath() + "/login?alert=username_password_empty");
            return;
        }
        User user = userService.findByUserNameAndPassword(username, password);

        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("account", user);
            if(isRememberMe){
                saveRememberMe(response, username);
            }
            response.sendRedirect(request.getContextPath() + "/waiting");
        } else {
            response.sendRedirect(request.getContextPath() + "/login?alert=username_password_invalid");
        }
    }

    private void saveRememberMe(HttpServletResponse response, String username) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);
    }
}
