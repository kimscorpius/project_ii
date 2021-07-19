package com.Project_II.service.impl;

import com.Project_II.dao.IOrderItemDAO;
import com.Project_II.dao.impl.OrderItemDAO;
import com.Project_II.model.OrderItem;
import com.Project_II.service.IOrderItemService;

import java.util.List;

public class OrderItemService implements IOrderItemService {

    private IOrderItemDAO orderItemDAO = new OrderItemDAO();

    @Override
    public Long insertCartItem(Integer quantity, Long proId, Long userId) {
        return orderItemDAO.insertCartItem(quantity, proId, userId);
    }

    @Override
    public List<OrderItem> findByUserId(Long userId) {
        return orderItemDAO.findByUserId(userId);
    }

    @Override
    public void removeOrderItem(Long idOrderItem) {
        orderItemDAO.removeOrderItem(idOrderItem);
    }

    @Override
    public void updateAfterOrder(Long orderItemId, Long orderId) {
        orderItemDAO.updateAfterOrder(orderItemId, orderId);
    }

}
