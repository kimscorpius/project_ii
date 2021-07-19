package com.Project_II.controller.web;

import com.Project_II.service.IOrderItemService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/member/order/remove"})
public class OrderItemRemoveController extends HttpServlet {

    @Inject
    private IOrderItemService orderItemService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long orderItemId = Long.parseLong(request.getParameter("orderItemId"));
        orderItemService.removeOrderItem(orderItemId);
        response.sendRedirect(request.getContextPath() + "/member/cart");
    }
}
