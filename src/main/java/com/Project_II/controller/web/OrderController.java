package com.Project_II.controller.web;

import com.Project_II.model.Order;
import com.Project_II.model.OrderItem;
import com.Project_II.model.User;
import com.Project_II.service.IOrderItemService;
import com.Project_II.service.IOrderService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/member/ordering"})
public class OrderController extends HttpServlet {

    @Inject
    private IOrderItemService orderItemService;

    @Inject
    private IOrderService orderService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("account");
        List<OrderItem> orderItemList = orderItemService.findByUserId(user.getId().longValue());
        Long totalPrice = 0L;

        for (OrderItem orderItem : orderItemList) {
            totalPrice += orderItem.getQuantity() * orderItem.getProduct().getPrice();
        }
        Date date = new Date(System.currentTimeMillis());
        Long orderId = orderService.insertOrder(new Order(user.getId().longValue(),
                totalPrice, date));
        for (OrderItem orderItem : orderItemList) {
            orderItemService.updateAfterOrder(orderItem.getId(), orderId);
        }

        response.sendRedirect(request.getContextPath() + "/member/cart?alert=successfulOrder");
    }
}
