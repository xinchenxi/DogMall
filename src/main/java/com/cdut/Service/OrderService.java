package com.cdut.Service;

import com.cdut.Dto.OrderGoods;
import com.cdut.Pojo.Order;
import com.cdut.Vo.UserOrder;

import java.util.List;
public interface OrderService {
    public UserOrder getOrderByUserId(String userId);
    public List<OrderGoods> selectGoodsByOrderId(String orderId);
}