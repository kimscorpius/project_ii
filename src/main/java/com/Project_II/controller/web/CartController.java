package com.Project_II.controller.web;

import com.Project_II.model.User;
import com.Project_II.service.IOrderItemService;
import com.Project_II.service.impl.OrderItemService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

@WebServlet(urlPatterns = {"/member/cart"})
public class CartController extends HttpServlet {

    @Inject
    private IOrderItemService orderItemService;

    ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String alert = request.getParameter("alert");
        if (alert != null) {
            String val = resourceBundle.getString(alert);
            request.setAttribute("alertMsg",
                    new String(val.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        }
        request.setAttribute("alert", alert);

        User user = (User) request.getSession().getAttribute("account");
        if (user != null) {
            request.setAttribute("userOrderItemList", orderItemService.findByUserId(user.getId().longValue()));
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/web/views/cart.jsp");
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login?alert=not_logged_in");
        }
    }
}
