package com.cdut.Pojo;

import java.util.Arrays;

/**
 * 购物车
 */
public class ShoppingCart {
    /**
     * 该购物车的用户id
     */
    private String userId;
    /**
     *  所有的商品id
     */
    private String[] goodId;
    /**
     * 商品的数量
     */
    private Integer[] nums;
    /**
     * 所有商品的价格
     */
    private double[] price;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getGoodId() {
        return goodId;
    }

    public void setGoodId(String[] goodId) {
        this.goodId = goodId;
    }

    public Integer[] getNums() {
        return nums;
    }

    public void setNums(Integer[] nums) {
        this.nums = nums;
    }

    public double[] getPrice() {
        return price;
    }

    public void setPrice(double[] price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "userId=" + userId +
                ", goodId=" + Arrays.toString(goodId) +
                ", nums=" + Arrays.toString(nums) +
                ", price=" + Arrays.toString(price) +
                '}';
    }
}
