package com.cdut.Dao;

import com.cdut.Pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoDao {
    /**
     * 根据id删除用户信息
     */
    public void deleteUserInfoById(String userId);
    /**
     *   修改用户等级
     */
    public void updateUserGrade(String userId,Integer Grade);
    /**
     * 修改用户信息
     */
    public void updateUser(UserInfo userInfo);
    /**
     * user表中插入一条数据时需要在userInfo里也插入一条数据
     */
    public void insertUserInfo(@Param("userId") String userId,
                               @Param("userName") String userName,
                               @Param("defaultImg")String defaultImg,
                                @Param("grade") Integer grade);

    /**
     * 查询用户信息
     */
    public UserInfo selectUserInfo(String userId);

    public void updateAvator(@Param("userId")String userId,@Param("imgUrl")String imgUrl);
}
