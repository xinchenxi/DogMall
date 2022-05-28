package com.cdut.Service;

import com.cdut.Pojo.Goods;
import com.cdut.Vo.UserFavorite;

import java.util.List;

public interface UserFavoriteService {
    public void addUserFavorite(String userId,String goodId);

    public void deleteUserFavorite(String userId,String goodId);

    public UserFavorite listUserAllFavorite(String userId);
}
