package com.cdut.Pojo;

import com.cdut.Dto.OrderGoods;

import java.util.Date;
import java.util.List;

/**
 * 订单
 */
public class Order {
    /**
     *订单号
     */
    private String orderId;

    /**
     * 订单中的商品
     */
    private List<OrderGoods> goods;

    /**
     * 订单创建的日期
     */
    private String date;
    /**
     * 订单的总价格
     */
    private  double orderprice;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<OrderGoods> getGoods() {
        return goods;
    }

    public void setGoods(List<OrderGoods> goods) {
        this.goods = goods;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(double orderprice) {
        this.orderprice = orderprice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", goods=" + goods +
                ", date='" + date + '\'' +
                ", orderprice=" + orderprice +
                '}';
    }
}
