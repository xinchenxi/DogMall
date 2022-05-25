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

    public void updatePassword(String userId, String oldpwd,String newpwd);

    public void deteleUserById(String userid);
}
