package com.Project_II.controller.web;

import com.Project_II.model.User;
import com.Project_II.service.IOrderService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/member/ordered"})
public class OrderedController extends HttpServlet {

    @Inject
    private IOrderService orderService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("account");
        if (user != null) {
            request.setAttribute("userOrderedList", orderService.findAllWithUser(user.getId().longValue()));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/views/ordered.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login?alert=not_logged_in");
        }
    }
}