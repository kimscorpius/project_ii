package com.Project_II.service.impl;

import com.Project_II.dao.IOrderDAO;
import com.Project_II.dao.impl.OrderDAO;
import com.Project_II.model.Order;
import com.Project_II.service.IOrderService;

import java.util.List;

public class OrderService implements IOrderService {

    private IOrderDAO orderDAO = new OrderDAO();

    @Override
    public Long insertOrder(Order order) {
        return orderDAO.insertOrder(order);
    }

    @Override
    public List<Order> findAllWithUser(Long userId) {
        return orderDAO.findAllWithUser(userId);
    }
}
