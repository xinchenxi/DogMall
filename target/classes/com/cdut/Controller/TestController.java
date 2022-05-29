package com.cdut.Controller;

import com.cdut.Pojo.User;
import com.cdut.Pojo.UserInfo;
import com.cdut.Service.UserInfoService;
import com.cdut.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.cdut.Util.SnowFlakeUtil;

@Controller
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/userService.do")
    public ModelAndView User(){
        ModelAndView mv=new ModelAndView();
        //countUsers()方法
        int nums=userService.getCountUser();
        mv.addObject("nums",nums);

        //listAllUsers
        List<User> users=userService.getListUser();
        mv.addObject("allUsers",users);
        mv.setViewName("result.jsp");

        //getUserByAccount
        String account="z992448694";
        User user1=userService.getUserByAccount(account);
        mv.addObject("getuser",user1);
        return mv;


    }
    @RequestMapping("/getUserByAccount.do")
    public ModelAndView user2(@RequestParam(value="account") String Account){
        ModelAndView mv=new ModelAndView();
        User user=userService.getUserByAccount(Account);
        System.out.println(Account);
        mv.addObject("info",user);
        mv.setViewName("result.jsp");
        return mv;
    }
    @RequestMapping("/insertUser.do")
    public ModelAndView user3(@RequestParam("account") String account,
                              @RequestParam("password")String password){
        ModelAndView mv=new ModelAndView();
        SnowFlakeUtil snowFlakeUtil=new SnowFlakeUtil(0,0);

        String userId=snowFlakeUtil.nextId();
        User user=new User();
        user.setUserid(userId);
        user.setAccount(account);
        user.setPassword(password);

        userService.addUser(user);

        User users =userService.getUserByAccount(account);
        mv.addObject("users",users);
        mv.setViewName("result.jsp");
        return mv;
    }
    @RequestMapping("/updateUserPassword.do")
    public ModelAndView user4(@RequestParam("userid")  String userId,
                              @RequestParam("newpassword") String newpwd,
                              @RequestParam("oldpassword") String oldpwd){
        ModelAndView mv=new ModelAndView();
        userService.updatePassword(userId,oldpwd,newpwd);
        System.out.println(userId);
        User user1=userService.getUserByuserId(userId);
        mv.addObject("user1",user1);
        mv.setViewName("result.jsp");
        return mv;
    }

    @RequestMapping("updateUser.do")
    public void user5(){
        userService.updateUser(new UserInfo("3","花花","女","99@qq","山西","193" ,1));
        //userService.deteleUserById("978697264128065536");
    }
    @RequestMapping("deteleUserById.do")
    public void user6(){
        userService.deteleUserById("978697264128065536");
    }
    @RequestMapping("updateUserGrade.do")
    public void user7(){
        userInfoService.updateUserGrade("3",2);
    }
}
