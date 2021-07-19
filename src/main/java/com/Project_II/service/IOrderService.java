package com.Project_II.service;

import com.Project_II.model.Order;

import java.util.List;

public interface IOrderService {

    Long insertOrder(Order order);

    List<Order> findAllWithUser(Long userId);
}
