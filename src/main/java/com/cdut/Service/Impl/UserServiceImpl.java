package com.cdut.Service.Impl;

import com.cdut.Dao.UserDao;
import com.cdut.Dao.UserInfoDao;
import com.cdut.Pojo.User;
import com.cdut.Pojo.UserInfo;
import com.cdut.Service.UserService;
import com.cdut.Util.SnowFlakeUtil;

import java.util.HashMap;
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

    }

    @Override
    public HashMap<String,String> updatePassword(String userId, String oldpwd, String newpwd) {
        HashMap<String,String> map=new HashMap<>();
        User user=dao.getUserByuserId(userId);
        if(oldpwd.equals(user.getPassword())){
            if(newpwd.equals(oldpwd)) {//新旧密码相同
                map.put("msg","1");
            }else{//更新密码
                dao.updatePassword(userId, newpwd);
                map.put("msg","2");
            }
        }else{//密码错误
            map.put("msg","3");
        }
        return map;
    }

    @Override
    public void deteleUserById(String userid) {
        dao.deleteUserById(userid);
    }

    @Override
    public int getCountByAcoount(String account) {
        return dao.getCountByAccount(account);
    }


}
