package com.cdut.Service.Impl;

import com.cdut.Dao.ShoppingCartDao;
import com.cdut.Pojo.ShoppingCartGoods;
import com.cdut.Service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    private ShoppingCartDao dao;

    public void setDao(ShoppingCartDao dao) {
        this.dao = dao;
    }

    @Override
    public List<ShoppingCartGoods> listCartByUserId(String userId) {
        List<ShoppingCartGoods> shoppingCartGoods=dao.listCartByUserId(userId);
        for (ShoppingCartGoods shoppingCartGoods1:shoppingCartGoods){
            double price=shoppingCartGoods1.getGoods().getPrice();
            shoppingCartGoods1.setGoodsnum(dao.getGoodsnumsInCart(userId,shoppingCartGoods1.getGoods().getGoodId()));
            int num=shoppingCartGoods1.getGoodsnum();
            shoppingCartGoods1.setGoodsprice(price*num);
        }
        return shoppingCartGoods;
    }

    @Override
    public void clearCart(String userId) {
        dao.clearCart(userId);
    }

    @Override
    public double priceIncheckGoods(String userId,List<String> goodsId) {
        return dao.priceIncheckGoods(userId, goodsId);
    }

    @Override
    public void insertGoodstoCart(String userId, String goodsId, Integer nums) {
        dao.InsertGoods(userId, goodsId, nums);
    }

    @Override
    public void deleteGoodsFromCart(String userId, List<String> goodsId) {
        dao.deleteGoods(userId, goodsId);
    }

    @Override
    public void increaseGoods(String userId, String goodsId) {
        dao.increaseGoods(userId,goodsId);
    }

    @Override
    public void decreaseGoods(String userId, String goodsId) {
        dao.decreaseGoods(userId, goodsId);
        Integer nums=dao.getGoodsnumsInCart(userId, goodsId);
        if(nums==0){
            List<String> deleteGoods=new ArrayList<>();
            deleteGoods.add(goodsId);
            dao.deleteGoods(userId, deleteGoods);
        }
    }
}
