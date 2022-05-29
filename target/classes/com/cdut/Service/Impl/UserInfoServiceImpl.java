package com.cdut.Service.Impl;

import com.cdut.Dao.UserInfoDao;
import com.cdut.Pojo.User;
import com.cdut.Pojo.UserInfo;
import com.cdut.Service.UserInfoService;
import com.cdut.Util.SnowFlakeUtil;

public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDao userInfoDao;

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public void updateUserGrade(String userid, Integer grade) {
        userInfoDao.updateUserGrade(userid,grade);
    }

    @Override
    public void deteleUserInfoById(String userid) {
        userInfoDao.deleteUserInfoById(userid);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoDao.updateUser(userInfo);
    }

    @Override
    public void addUserInfo(User user) {
        SnowFlakeUtil snowFlakeUtil=new SnowFlakeUtil(0,0);
        String userName=snowFlakeUtil.nextId();
        String userId=user.getUserid();
        userInfoDao.insertUserInfo(userId,userName);
    }
}
