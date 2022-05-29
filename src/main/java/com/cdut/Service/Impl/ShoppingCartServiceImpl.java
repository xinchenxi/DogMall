package com.cdut.Service.Impl;

import com.cdut.Dao.ShoppingCartDao;
import com.cdut.Pojo.Goods;
import com.cdut.Service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    private ShoppingCartDao dao;

    public void setDao(ShoppingCartDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Goods> listCartByUserId(String userId) {
        return dao.listCartByUserId(userId);
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
