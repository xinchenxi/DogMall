package com.cdut.Vo;

import com.cdut.Pojo.Order;
import java.util.List;
public class UserOrder {
    private String userId;
    private List<Order> orders;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "userId='" + userId + '\'' +
                ", orders=" + orders +
                '}';
    }
}
