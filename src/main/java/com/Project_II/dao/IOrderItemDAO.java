package com.Project_II.dao;

import com.Project_II.model.OrderItem;

import java.util.List;

public interface IOrderItemDAO extends GenericDAO<OrderItem> {

    Long insertCartItem(Integer quantity, Long proId, Long userId);

    List<OrderItem> findByUserId(Long userId);

    OrderItem findByUserIdAndProductId(Long proId, Long userId);

    void removeOrderItem(Long idOrderItem);

    void updateAfterOrder(Long orderItemId, Long orderId);
}
