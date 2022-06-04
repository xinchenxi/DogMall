package com.cdut.Controller;

import com.cdut.Pojo.User;
import com.cdut.Pojo.UserInfo;
import com.cdut.Service.UserFavoriteService;
import com.cdut.Service.UserInfoService;
import com.cdut.Service.UserService;
import com.cdut.Util.MinioUtil;
import com.cdut.Util.SnowFlakeUtil;
import com.cdut.Vo.UserFavorite;
import org.apache.commons.codec.digest.DigestUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserFavoriteService userFavoriteService;
    @Autowired
    private MinioUtil minioUtil;

    @RequestMapping("register.do")
    public ModelAndView userRegister(@RequestParam("account") String account,@RequestParam("password") String password,
                                  HttpSession session){
        ModelAndView mv=new ModelAndView();
        SnowFlakeUtil snowFlakeUtil=new SnowFlakeUtil(0,0);
        String userId=snowFlakeUtil.nextId();
        User user=new User();
        user.setUserid(userId);
        //md5账号加密 不可逆
        user.setAccount(DigestUtils.md5Hex(account));
        //md5密码加密 不可逆
        user.setPassword(DigestUtils.md5Hex(password));
        userService.addUser(user);
        UserInfo userInfo= userInfoService.addUserInfo(user);

        session.setAttribute("user",user);
        session.setAttribute("userInfo",userInfo);
        System.out.println(user);
        System.out.println(userInfo);
        mv.setViewName("index.jsp");
        System.out.println("返回");
        return mv;
    }

    @RequestMapping("/userLogin.do")
    public ModelAndView userLogin(@RequestParam("accounts")String account,@RequestParam("password") String password,HttpSession session){
        ModelAndView mv=new ModelAndView();
        //账号加密用于查询
        account=DigestUtils.md5Hex(account);
        //使用加密后的账号到数据库内查数据 如果为0就表示账号错误
        if(0==userService.getCountByAcoount(account)){
            mv.addObject("msg","账号错误");
            mv.setViewName("test/result.jsp");
            return mv;
        }else {//如果查到了就进入登录
            User user = userService.getUserByAccount(account);
            //密码输入正确
            System.out.println(DigestUtils.md5Hex(password));
            if (user.getPassword().equals(DigestUtils.md5Hex(password))) {
                //将用户加入session
                session.setAttribute("user", user);
                //获得用户信息并加入session
                UserInfo userInfo = userInfoService.findUserInfoById(user.getUserid());
                session.setAttribute("userInfo", userInfo);
                //返回首页
                mv.setViewName("user_center_info.jsp");
            } else {
                mv.addObject("msg", "密码错误");
                mv.setViewName("test/result.jsp");
            }

        }
        return mv;
    }

    @RequestMapping("updateUserInfo.do")
    public  ModelAndView updateUserInfo(UserInfo userInfo,
                                        @RequestParam(name = "img", required = false) MultipartFile file,
                                        HttpSession session) throws Exception {
        ModelAndView mv=new ModelAndView();
        User user= (User) session.getAttribute("user");
        //先获取当前登录的用户id
        userInfo.setUserId(user.getUserid());
        userInfo.setImg(userInfoService.findUserImg(user.getUserid()));
            //更新头像
            HashMap<String, String> res = null;
        //没有上传头像就用原来的头像
        if(0 != file.getSize()) {
            try {
                //将minio的返回结果放到res中
                res = minioUtil.uploadAvatar(user.getUserid(), file, "mall");
                Iterator iter = res.entrySet().iterator();
                while (iter.hasNext()) {
                    HashMap.Entry entry = (HashMap.Entry) iter.next();
                    session.setAttribute((String) entry.getKey(), (String) entry.getValue());
                }
                //将图片地址放到数据库中
                userInfoService.updateUserAvator(user.getUserid(), (String) res.get("user_Avator"));
                userInfo.setImg((String)res.get("user_Avator"));
            } catch (Exception e) {
                e.printStackTrace();
                res.put("msg", "上传失败");
            }
        }

        //更新用户信息
        userInfoService.updateUserInfo(userInfo);

        //把用户信息放到session里
        session.setAttribute("userInfo", userInfo);
        mv.setViewName("user_center_info.jsp");
        return mv;
    }

    @RequestMapping("updatePassword.do")
   public ModelAndView updatePassword(@RequestParam("newpassword") String newpassword,
                                      @RequestParam("oldpassword") String oldpassword,
                                      HttpSession session){
        ModelAndView mv=new ModelAndView();
        User user= (User) session.getAttribute("user");
        HashMap<String,String> map=userService.updatePassword(user.getUserid(),DigestUtils.md5Hex(oldpassword),DigestUtils.md5Hex(newpassword));
        if(map.get("msg").equals("1")){
            session.setAttribute("UpdatePasswordMsg","新密码不能与旧密码一致");
        }else if(map.get("msg").equals("3")){
            session.setAttribute("UpdatePasswordMsg","密码错误");
        }else{
            session.setAttribute("UpdatePasswordMsg","更新成功");
            session.setAttribute("user",userService.getUserByuserId(user.getUserid()));
        }
        //更新用户账号信息
        mv.setViewName("user_center_info.jsp");
        return mv;
   }

   @RequestMapping("getuserFavorite.do")
   public ModelAndView getUserFavorite(HttpSession session){
        ModelAndView mv=new ModelAndView();
        User user= (User) session.getAttribute("user");
        UserFavorite userFavorite=userFavoriteService.listUserAllFavorite(user.getUserid());
        session.setAttribute("userFavorite",userFavorite);
       //没有数据
        if(0==userFavorite.getGood().size()){
            session.setAttribute("FavoriteMsg",0);
        }else{
            session.setAttribute("FavoriteMsg",1);
        }
        mv.setViewName("test/result.jsp");
        return mv;
   }


}
