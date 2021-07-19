package com.Project_II.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Order implements Serializable {
    private Long id;
    private Long price;
    private Long user_id;
    private List<OrderItem> orderItemList;
    private Date buyDate;

    public Order() {

    }

    public Order(Long user_id, Long price, Date buyDate) {
        this.user_id = user_id;
        this.buyDate = buyDate;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public List<OrderItem> getCartItemList() {
        return orderItemList;
    }

    public void setCartItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
