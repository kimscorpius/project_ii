package com.Project_II.service;

import com.Project_II.model.OrderItem;

import java.util.List;

public interface IOrderItemService {

    Long insertCartItem(Integer quantity, Long proId, Long userId);

    List<OrderItem> findByUserId(Long userId);

    void removeOrderItem(Long idOrderItem);

    void updateAfterOrder(Long orderItemId, Long orderId);

}
