package com.cdut.Pojo;

import java.util.List;
/**
 * 购物车
 */
public class ShoppingCart {

    private List<ShoppingCartGoods> shoppingCartGoods;


    public List<ShoppingCartGoods> getShoppingCartGoods() {
        return shoppingCartGoods;
    }

    public void setShoppingCartGoods(List<ShoppingCartGoods> shoppingCartGoods) {
        this.shoppingCartGoods = shoppingCartGoods;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCartGoods=" + shoppingCartGoods +
                '}';
    }
}
