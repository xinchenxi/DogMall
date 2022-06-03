package com.cdut.Service;

import com.cdut.Pojo.User;
import com.cdut.Pojo.UserInfo;

public interface UserInfoService {

    /**
     * 更新用户的等级 用户 商家 管理员
     * @param userid
     * @param grade
     */
    public void updateUserGrade(String userid,Integer grade);

    /**
     *删除用户账号信息的同时需要删除用户的信息
     * @param userid
     */
    public void deteleUserInfoById(String userid);

    /**
     * 更新用户信息
     * @param userInfo
     */
    public void updateUserInfo(UserInfo userInfo);

    /**
     * 新建用户时顺便创建一个userInfo 自定义生成用户id
     * @param user
     */
    public UserInfo addUserInfo(User user);

    /**
     * 更新用户头像
     */
    public void updateUserAvator(String userId,String imgUrl);
    /**
     * 查询用户信息
     */
    public UserInfo findUserInfoById(String userId);

    /**
     * 获得用户头像
     */
    public String findUserImg(String userId);
}
