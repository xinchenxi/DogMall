package com.cdut.Service.Impl;

import com.cdut.Dao.OrderDao;
import com.cdut.Dto.OrderGoods;
import com.cdut.Pojo.Goods;
import com.cdut.Pojo.Order;
import com.cdut.Service.OrderService;
import com.cdut.Vo.UserOrder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao dao;

    public void setDao(OrderDao dao) {
        this.dao = dao;
    }

    @Override
    public UserOrder getOrderByUserId(String userId) {
        UserOrder userOrder=new UserOrder();
        //插入用户Id
        userOrder.setUserId(userId);
        //查询用户的所有订单id
        List<String> orderIds=dao.selectOrderIdByUserId(userId);
        //List去重 去掉重复的orderId
        HashSet h = new HashSet(orderIds);
        orderIds.clear();
        orderIds.addAll(h);
        List<Order> orders=new ArrayList<>();
        //开始逐个订单的查找
        for(String orderid:orderIds){
            Order order=new Order();
            //先插入orderid
            order.setOrderId(orderid);

            //开始根据orderid查询商品 查到一系列id后set到order的Goods属性中
            order.setGoods(dao.selectGoodsByOrderId(orderid));
            //查询订单日期插入到date
            order.setDate(dao.selectDateByOrderId(orderid));
            //将单个的order放入到list中
            orders.add(order);
        }
        userOrder.setOrders(orders);
        return userOrder;
    }

    @Override
    public List<OrderGoods> selectGoodsByOrderId(String orderId) {
        return dao.selectGoodsByOrderId(orderId);
    }
}
