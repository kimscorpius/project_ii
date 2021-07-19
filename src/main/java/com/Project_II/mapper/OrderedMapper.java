package com.Project_II.mapper;

import com.Project_II.model.Order;
import com.Project_II.model.OrderItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderedMapper implements RowMapper<Order> {

    private List<OrderItem> orderItemList = new ArrayList<>();

    @Override
    public Order mapRow(ResultSet resultSet) {
        Order ordered = new Order();

        try {
            ordered.setId(resultSet.getLong("o.id"));
            ordered.setPrice(resultSet.getLong("o.price"));
            ordered.setUser_id(resultSet.getLong("o.user_id"));
            ordered.setBuyDate(resultSet.getDate("o.buy_date"));
            orderItemList.add(new OrderItemMapper().mapRow(resultSet));
            ordered.setCartItemList(orderItemList);

            return ordered;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
