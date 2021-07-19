package com.Project_II.dao;

import com.Project_II.model.Order;

import java.util.List;

public interface IOrderDAO extends GenericDAO<Order> {

    Long insertOrder(Order order);

    List<Order> findAllWithUser(Long userId);
}
