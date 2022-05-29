package com.cdut.Dao;

import com.cdut.Pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ShoppingCartDao {

    public  List<Goods> listCartByUserId(String userId);

    public void clearCart(String userId);

    public  double priceIncheckGoods(@Param("userId")String userId,
                                     @Param("goodsId")List<String> goodsId);

    public void InsertGoods(@Param("userId") String userId,
                            @Param("goodsId")  String goodsId,
                            @Param("nums") Integer nums);

    public void deleteGoods(@Param("userId")String userId,
                            @Param("goodsId")List<String> goodsId);

    public void increaseGoods(@Param("userId") String userId,@Param("goodsId") String goodsId);

    public void decreaseGoods(@Param("userId")String userId,@Param("goodsId")String goodsId);

    public Integer getGoodsnumsInCart(@Param("userId")String userId,@Param("goodsId")String goodsId);
}
