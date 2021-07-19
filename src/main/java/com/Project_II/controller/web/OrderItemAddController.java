package com.Project_II.controller.web;

import com.Project_II.model.User;
import com.Project_II.service.IOrderItemService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/member/order/add"})
public class OrderItemAddController extends HttpServlet {

    @Inject
    private IOrderItemService orderItemService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User account = (User) request.getSession().getAttribute("account");

        if (account != null) {
            Integer pId = Integer.parseInt(request.getParameter("pId"));
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            orderItemService.insertCartItem(quantity, pId.longValue(), account.getId().longValue());
            response.sendRedirect(request.getContextPath() + "/member/cart");
        } else {
            response.sendRedirect(request.getContextPath() + "/login?alert=login_to_continue");
        }
    }
}
