package com.cdut.Controller;

import com.cdut.Vo.UserFavorite;
import com.cdut.Service.UserFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserFavoriteController {

    @Autowired
    UserFavoriteService userFavoriteService;

    @RequestMapping("/listAllUserFavorite.do")
    public ModelAndView UserFavorite(){
        ModelAndView mv=new ModelAndView();
        UserFavorite user=userFavoriteService.listUserAllFavorite("1");
        mv.addObject("userFavorite",user);
        mv.setViewName("test/result3.jsp");
        return mv;
    }

}
