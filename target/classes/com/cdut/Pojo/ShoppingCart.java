package com.cdut.Pojo;

import java.util.List;
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
    private List<Goods> goods;
    /**
     * 商品的数量
     */
    private List<Integer> nums;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<Integer> getNums() {
        return nums;
    }

    public void setNums(List<Integer> nums) {
        this.nums = nums;
    }


    @Override
    public String toString() {
        return "ShoppingCart{" +
                "userId='" + userId + '\'' +
                ", goodId=" + goods +
                ", nums=" + nums +
                '}';
    }
}
