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
        userInfoDao.updateAvator(userInfo.getUserId(),userInfo.getImg());
    }

    @Override
    public UserInfo addUserInfo(User user) {
        SnowFlakeUtil snowFlakeUtil=new SnowFlakeUtil(0,0);
        String userName=snowFlakeUtil.nextId();
        String userId=user.getUserid();
        UserInfo userInfo=new UserInfo(userId,userName,"http://yangpai.cool:9000/mall/cc.jpg");
        userInfoDao.insertUserInfo(userInfo.getUserId(),userInfo.getUsername(),userInfo.getImg(),1);
        return userInfo;
    }

    @Override
    public void updateUserAvator(String userId, String imgUrl) {
        userInfoDao.updateAvator(userId,imgUrl);
    }

    @Override
    public UserInfo findUserInfoById(String userId) {
        return userInfoDao.selectUserInfo(userId);
    }

    @Override
    public String findUserImg(String userId) {
        return userInfoDao.selectUserImgByUserId(userId);
    }
}
