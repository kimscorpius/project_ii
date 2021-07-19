package com.Project_II.dao.impl;

import com.Project_II.dao.IOrderItemDAO;
import com.Project_II.mapper.OrderItemMapper;
import com.Project_II.model.OrderItem;

import java.util.List;

public class OrderItemDAO extends AbstractDAO<OrderItem> implements IOrderItemDAO {

    // Chú ý: viết câu lệnh select thì phải thêm orderitem as o. Để tương thích với mapper.

    @Override
    public Long insertCartItem(Integer quantity, Long proId, Long userId) {
        OrderItem orderItem = this.findByUserIdAndProductId(proId, userId);
        if (orderItem == null || orderItem.getStatus() == 2) {
            StringBuilder sql = new StringBuilder("INSERT INTO orderitem");
            sql.append("(quantity, pro_id, user_id, status) ");
            sql.append("VALUE (?, ?, ?, ?) ");

            return insert(sql.toString(), quantity, proId, userId, 1); //1: chưa đặt hàng(có trong giỏ hàng)

        } else {
            StringBuilder sql = new StringBuilder("update orderitem set quantity = quantity + ? ");
            sql.append("where pro_id = ? and user_id = ?");
            update(sql.toString(), quantity, proId, userId);

            return 0L;
        }
    }

    @Override
    public List<OrderItem> findByUserId(Long userId) {
        StringBuilder sql = new StringBuilder("select * from orderitem as oi ");
        sql.append("inner join product as p on oi.pro_id = p.id ");
        sql.append("where oi.user_id = ? and oi.status = ? ");
        List<OrderItem> orderItems = query(sql.toString(), new OrderItemMapper(),userId, 1);

        return orderItems.isEmpty() ? null : orderItems;
    }

    @Override
    public OrderItem findByUserIdAndProductId(Long proId, Long userId) {
        StringBuilder sql = new StringBuilder("select * from orderitem as oi ");
        sql.append("where oi.pro_id = ? and oi.user_id = ? ");
        List<OrderItem> orderItems = query(sql.toString(), new OrderItemMapper(), proId, userId);

        return orderItems.isEmpty() ? null : orderItems.get(0);
    }

    @Override
    public void removeOrderItem(Long idOrderItem) {
        StringBuilder sql = new StringBuilder("delete from orderitem ");
        sql.append("where id = ? ");

        update(sql.toString(), idOrderItem);
    }

    @Override
    public void updateAfterOrder(Long orderItemId, Long orderId) {
        StringBuilder sql = new StringBuilder("update orderitem ");
        sql.append("set order_id = ?, status = ? where id = ? ");

        update(sql.toString(), orderId, 2, orderItemId);
    }

}
