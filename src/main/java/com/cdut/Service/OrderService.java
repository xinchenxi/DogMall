package com.cdut.Service;

import com.cdut.Dto.OrderGoods;
import com.cdut.Pojo.Order;
import com.cdut.Vo.UserOrder;

import java.util.List;
public interface OrderService {
    public UserOrder getOrderByUserId(String userId);
    public List<OrderGoods> selectGoodsByOrderId(String orderId);
    public UserOrder getOrderByOrderId(String orderId);
    public void addOrder(String userId,List<OrderGoods> goods);
    public int getCountOrderByUserId(String userId);
}
