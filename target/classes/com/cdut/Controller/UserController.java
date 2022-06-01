package com.cdut.Controller;

import com.cdut.Pojo.User;
import com.cdut.Pojo.UserInfo;
import com.cdut.Service.UserInfoService;
import com.cdut.Service.UserService;
import com.cdut.Util.MinioUtil;
import com.cdut.Util.SnowFlakeUtil;
import org.apache.ibatis.annotations.Param;
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
    private MinioUtil minioUtil;

    @RequestMapping("register.do")
    public ModelAndView userRegister(@RequestParam("account") String account,@RequestParam("password") String password,
                                  HttpSession session){
        ModelAndView mv=new ModelAndView();
        SnowFlakeUtil snowFlakeUtil=new SnowFlakeUtil(0,0);
        String userId=snowFlakeUtil.nextId();
        User user=new User();
        user.setUserid(userId);
        user.setAccount(account);
        user.setPassword(password);

        userService.addUser(user);
        UserInfo userInfo= userInfoService.addUserInfo(user);

        session.setAttribute("userId",user.getUserid());
        session.setAttribute("userName",userInfo.getUsername());
        session.setAttribute("userImg",userInfo.getImg());
        mv.setViewName("result.jsp");
        System.out.println("返回");
        return mv;
    }

    @RequestMapping("/userLogin.do")
    public ModelAndView userLogin(String account,@RequestParam("password") String password,HttpSession session){
        ModelAndView mv=new ModelAndView();
        if(0==userService.getCountByAcoount(account)){
            mv.addObject("msg","账号错误");
            mv.setViewName("result.jsp");
            return mv;
        }else {//如果查到了就进入登录

            User user = userService.getUserByAccount(account);
            //密码输入正确
            if (user.getPassword().equals(password)) {
                //将用户加入session
                session.setAttribute("user", user);
                //获得用户信息并加入session
                UserInfo userInfo = userInfoService.findUserInfoById(user.getUserid());
                session.setAttribute("userInfo", userInfo);
                mv.addObject("user", user);
                mv.addObject("userInfo", userInfo);
                mv.addObject("msg", "登陆成功");
                //返回首页
                mv.setViewName("index.jsp");
            } else {
                mv.addObject("msg", "密码错误");
                mv.setViewName("result.jsp");
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
        userInfo.setUserId(user.getUserid());

        //更新头像
        HashMap<String,String> res = null;
        try {
            //将minio的返回结果放到res中
            res = minioUtil.uploadAvatar(user.getUserid(), file, "mall");

            userInfoService.updateUserAvator(user.getUserid(),(String)res.get("user_Avator"));
        } catch (Exception e) {
            e.printStackTrace();
            res.put("code", "0");
            res.put("msg", "上传失败");
        }
        userInfo.setImg((String)res.get("user_Avator"));
        //更新用户信息
        userInfoService.updateUserInfo(userInfo);
        Iterator iter = res.entrySet().iterator();
        while (iter.hasNext()) {
            HashMap.Entry entry = (HashMap.Entry) iter.next();
           session.setAttribute((String) entry.getKey(), (String) entry.getValue());
        }
        //把用户信息放到session里
        session.setAttribute("userInfo", userInfo);
        mv.setViewName("result.jsp");
        return mv;
    }

    @RequestMapping("updatePassword.do")
   public ModelAndView updatePassword(@RequestParam("newpassword") String newpassword,
                                      @RequestParam("oldpassword") String oldpassword,
                                      HttpSession session){
        ModelAndView mv=new ModelAndView();
        User user= (User) session.getAttribute("user");
        userService.updatePassword(user.getUserid(),oldpassword,newpassword);
        //更新用户账号信息
        session.setAttribute("user",userService.getUserByuserId(user.getUserid()));
        mv.setViewName("result.jsp");
        return mv;
   }
}
