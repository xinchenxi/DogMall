package com.cdut.Service.Impl;

import com.cdut.Dao.UserDao;
import com.cdut.Pojo.User;
import com.cdut.Pojo.UserInfo;
import com.cdut.Service.UserService;

import java.util.List;
//没完呢
//再添加一个用户名加入到userInfo中
public class UserServiceImpl  implements UserService {
    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public int getCountUser() {
        return dao.countUsers();
    }

    @Override
    public List<User> getListUser() {
        return dao.listAllUsers();
    }

    @Override
    public User getUserByAccount(String account) {
        return dao.getUserByAccount(account);
    }

    @Override
    public User getUserByuserId(String userId) {
        return dao.getUserByuserId(userId);
    }

    @Override
    public void addUser(User user) {

        dao.insertUser(user);
        //再添加一个用户名加入到userInfo中
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        dao.updateUser(userInfo);
    }

    @Override
    public void updatePassword(String userId, String oldpwd, String newpwd) {
        User user=dao.getUserByuserId(userId);
        System.out.println("数据库中的密码为:"+user.getPassword()+"\n"+"输入的旧密码为:"+oldpwd);
        if(oldpwd.equals(user.getPassword())){
            if(newpwd.equals(oldpwd)) {
                System.out.println("新密码不能与旧密码一致");
            }else{
                dao.updatePassword(userId, newpwd);
            }
        }else{
            System.out.println("密码错误");
        }
    }

    @Override
    public void deteleUserById(String userid) {
        dao.deleteUserById(userid);
    }
}
