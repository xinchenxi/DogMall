package com.cdut.Service.Impl;

import com.cdut.Dao.GoodsDao;
import com.cdut.Dao.UserDao;
import com.cdut.Dao.UserFavoriteDao;
import com.cdut.Pojo.Goods;
import com.cdut.Vo.UserFavorite;
import com.cdut.Service.UserFavoriteService;

import java.util.List;

public class UserFavoriteServiceImpl  implements UserFavoriteService {

    private UserFavoriteDao dao;


    public void setDao(UserFavoriteDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUserFavorite(String userId, String goodId) {
        dao.insertUserFavoriteGoods(userId,goodId);
    }

    @Override
    public void deleteUserFavorite(String userId, String goodId) {
        dao.deleteUserFavoriteGoods(userId,goodId);
    }

    @Override
    public UserFavorite listUserAllFavorite(String userId) {
        UserFavorite userFavorite=new UserFavorite();
        userFavorite.setUserId(userId);
        List<Goods> goods=dao.listAllFavoriteGoods(userId);
        userFavorite.setGood(goods);
        return userFavorite;
    }

}
