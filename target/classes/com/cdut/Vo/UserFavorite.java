package com.cdut.Vo;

import com.cdut.Pojo.Goods;

import java.util.List;

/**
 * 用户收藏
 */
public class UserFavorite {

    /**
     *  用户id
     */
    private String userId;
    /**
     * 收藏的商品id
     */
    private List<Goods> good;

    public UserFavorite() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Goods> getGood() {
        return good;
    }

    public void setGood(List<Goods> good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "UserFavorite{" +
                "userId='" + userId + '\'' +
                ", good=" + good +
                '}';
    }
}
