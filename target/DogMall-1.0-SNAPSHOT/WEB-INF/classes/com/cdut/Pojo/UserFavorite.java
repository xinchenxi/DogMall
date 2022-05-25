package com.cdut.Pojo;

import java.util.Arrays;

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
    private String[] goodId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String[] getGoodId() {
        return goodId;
    }

    public void setGoodId(String[] goodId) {
        this.goodId = goodId;
    }

    @Override
    public String toString() {
        return "UserFavorite{" +
                "userId=" + userId +
                ", goodId=" + Arrays.toString(goodId) +
                '}';
    }
}
