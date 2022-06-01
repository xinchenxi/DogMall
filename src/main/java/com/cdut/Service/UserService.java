package com.cdut.Service;

import com.cdut.Pojo.User;
import com.cdut.Pojo.UserInfo;

import java.util.List;

public interface UserService {
    public int getCountUser();

    public List<User> getListUser();

    public User getUserByAccount(String account);

    public User getUserByuserId(String userId);

    public void addUser(User user);

    /**
     * 修改用户信息
     * @param userInfo
     */
    public void updateUser(UserInfo userInfo);

    /**
     * 修改用户密码
     * @param userId 用户id
     * @param oldpwd 旧密码
     * @param newpwd 新密码
     */
    public void updatePassword(String userId, String oldpwd,String newpwd);

    /**
     * 根据用户id删除用户
     * @param userid 用户id
     */
    public void deteleUserById(String userid);
    public int getCountByAcoount(String account);

}
