package com.cdut.Dto;

import com.cdut.Pojo.Goods;

import java.util.List;
public class OrderGoods {

    /**
     * 商品
     */
    private Goods goods;
    /**
     * 商品数量
     */
    private Integer goodNum;
    /**
    *商品单价乘商品数量等于goodsPrice
     */
    private double goodsPrice;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "goods=" + goods +
                ", goodNum=" + goodNum +
                ", goodsPrice=" + goodsPrice +
                '}';
    }
}
