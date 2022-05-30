package com.cdut.Controller;

import com.alibaba.fastjson.JSONObject;
import com.cdut.Pojo.User;
import com.cdut.Pojo.UserInfo;
import com.cdut.Service.UserInfoService;
import com.cdut.Service.UserService;
import com.cdut.Util.MinioUtil;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.cdut.Util.SnowFlakeUtil;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MinioUtil minioUtil;

    public TestController() throws InvalidPortException, InvalidEndpointException {
    }

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
        userInfoService.addUserInfo(user);
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
        userService.updateUser(new UserInfo("3","花花","女","99@qq","山西","193" ,1,"http://yangpai.cool:9000/mall/mall_1653894259778.jpg"));
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

    @GetMapping("init.do")
    public String init() {
        return "file";
    }

    /**
     * 上传
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload.do")
    @ResponseBody
    public String upload(@RequestParam(name = "file", required = false) MultipartFile file, HttpServletRequest request) {
        JSONObject res = null;
        try {
            res = minioUtil.uploadAvatar("1",file, "mall");
            String userId="980852303395291136";
            userInfoService.updateUserAvator(userId,(String)res.get("msg"));
        } catch (Exception e) {
            e.printStackTrace();
            res.put("code", 0);
            res.put("msg", "上传失败");
        }
        return res.toJSONString();
    }
}
