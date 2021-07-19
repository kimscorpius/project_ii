package com.Project_II.mapper;

import com.Project_II.model.OrderItem;
import com.Project_II.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemMapper implements RowMapper<OrderItem> {
    @Override
    public OrderItem mapRow(ResultSet resultSet) {
        OrderItem orderItem = new OrderItem();
        try {
            orderItem.setId(resultSet.getLong("oi.id"));
            orderItem.setQuantity(resultSet.getInt("oi.quantity"));
            orderItem.setPro_id(resultSet.getLong("oi.pro_id"));
            try {
                orderItem.setProduct(new Product(resultSet.getInt("p.id"),
                        resultSet.getString("p.name"), resultSet.getString("p.image"),
                        resultSet.getString("p.short_des"), resultSet.getInt("p.price")));
                orderItem.setCartId(resultSet.getLong("p.cart_id"));
            } catch (Exception e) {
                e.getMessage();
            }
            orderItem.setUserId(resultSet.getLong("oi.user_id"));
            orderItem.setStatus(resultSet.getInt("oi.status"));

            return orderItem;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
