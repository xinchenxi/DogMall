package com.cdut.Pojo;

import java.util.Arrays;
import java.util.Date;

/**
 * 订单
 */
public class Order {
    /**
     *订单号
     */
    private Integer orderId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 所有商品id
     */
    private Integer[] goodId;
    /**
     * 所有的商品价格
     */
    private Integer[] nums;
    /**
     * 总价格
     */
    private double price;
    /**
     * 创建日期
     */
    private Date date;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer[] getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer[] goodId) {
        this.goodId = goodId;
    }

    public Integer[] getNums() {
        return nums;
    }

    public void setNums(Integer[] nums) {
        this.nums = nums;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", goodId=" + Arrays.toString(goodId) +
                ", nums=" + Arrays.toString(nums) +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
