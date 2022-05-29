package com.cdut.Service;

import com.cdut.Pojo.Goods;
import java.util.List;
public interface ShoppingCartService {

    public List<Goods> listCartByUserId(String userId);

    public void clearCart(String userId);

    public double priceIncheckGoods(String userId,List<String> goodsId);

    public void insertGoodstoCart(String userId,String goodsId,Integer nums);

    public void deleteGoodsFromCart(String userId,List<String> goodsId);

    public void increaseGoods(String userId,String goodsId);

    public void decreaseGoods(String userId,String goodsId);
}
