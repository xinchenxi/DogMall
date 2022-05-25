package com.cdut.Dao;

import com.cdut.Pojo.User;
import com.cdut.Pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {

    /**
     *  用户数量
     */
    public int countUsers();
    /**
     * 列出所有用户
     */
    public List<User> listAllUsers();
    /**
     * 根据账号得到用户信息
     */
    public User getUserByAccount(String account);
    /**
     * 根据用户id得到用户信息
     */
    public User getUserByuserId(String userId);
    /**
     *新增一个用户
     */
    public void insertUser(User user);
    /**
     * 修改用户密码
     * DAO层函数有多个参数时要是有@Param 否则参数无法匹配
     */
    public void updatePassword(@Param("userId") String userId, @Param("password") String password);
    /**
     * 根据id删除用户
     */
    public void deleteUserById(String userId);
    /**
     *   修改用户等级
     */
    public void updateUserGrade(String userId,Integer Grade);
    /**
     * 修改用户信息
     */
    public void updateUser(UserInfo userInfo);
}
