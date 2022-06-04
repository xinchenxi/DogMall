package com.cdut.Pojo;

public class ShoppingCartGoods {
    private Goods goods;
    private int goodsnum;
    private double goodsprice;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(int goodsnum) {
        this.goodsnum = goodsnum;
    }

    public double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(double goodsprice) {
        this.goodsprice = goodsprice;
    }

    @Override
    public String toString() {
        return "ShoppingCartGoods{" +
                "goods=" + goods +
                ", goodsnum=" + goodsnum +
                ", goodsprice=" + goodsprice +
                '}';
    }
}
