package com.cdut.Dao;

import com.cdut.Pojo.Goods;
import com.cdut.Vo.UserFavorite;

import java.util.List;

public interface UserFavoriteDao {

    public void insertUserFavoriteGoods(String userId,String goodId);

    public void deleteUserFavoriteGoods(String userId,String goodId);

    public List<Goods> listAllFavoriteGoods(String userId);

}
