package com.Project_II.dao.impl;

import com.Project_II.dao.IOrderDAO;
import com.Project_II.mapper.OrderedMapper;
import com.Project_II.model.Order;

import java.util.List;

public class OrderDAO extends AbstractDAO<Order> implements IOrderDAO {
    @Override
    public Long insertOrder(Order order) {
        StringBuilder sql = new StringBuilder("insert into orders");
        sql.append("(user_id, price, buy_date) ");
        sql.append("value(?, ?, ?) ");
        return insert(sql.toString(), order.getUser_id(), order.getPrice(), order.getBuyDate());
    }

    @Override
    public List<Order> findAllWithUser(Long userId) {
        StringBuilder sql = new StringBuilder("SELECT * from ");
        sql.append("(orders as o inner join orderitem as oi on o.id = oi.order_id) ");
        sql.append("inner join product as p on p.id = oi.pro_id ");
        sql.append("where o.user_id = ?");
        List<Order> orderList = query(sql.toString(), new OrderedMapper(), userId);
        int i = 0;
        while (i < orderList.size() - 1) {
            int j = i + 1;
            if (orderList.get(i).getId() == orderList.get(j).getId()) {
                orderList.remove(i);
            } else i++;
        }
        return orderList;
    }
}