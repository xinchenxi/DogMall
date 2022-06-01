package com.cdut.Service.Impl;

import com.cdut.Dao.OrderDao;
import com.cdut.Dto.OrderGoods;
import com.cdut.Pojo.Goods;
import com.cdut.Pojo.Order;
import com.cdut.Service.OrderService;
import com.cdut.Util.SnowFlakeUtil;
import com.cdut.Vo.UserOrder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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

    @Override
    public UserOrder getOrderByOrderId(String orderId) {
        UserOrder userOrder=new UserOrder();
        List<Order> orders=new ArrayList<>();
        Order order=new Order();
        //设置订单号
        order.setOrderId(orderId);
        //设置订单日期
        order.setDate(dao.selectDateByOrderId(orderId));
        //设置订单中的所有商品
        order.setGoods(dao.selectGoodsByOrderId(orderId));
        //放入列表中
        orders.add(order);
        //将商品list放入UserOrder中
        userOrder.setOrders(orders);
        userOrder.setUserId(dao.selectUserIdByOrderId(orderId));
        return userOrder;
    }

    @Override
    public void addOrder(String userId, List<OrderGoods> goods) {
        Date date=new Date();
        DateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
         String dateStr=sdf.format(date);
        //随机生成订单号
        SnowFlakeUtil snowFlakeUtil=new SnowFlakeUtil(0,0);
        String orderId=snowFlakeUtil.nextId();
        for(OrderGoods good:goods) {
            dao.insertOrder(userId, orderId, dateStr,good);
        }
    }
}
