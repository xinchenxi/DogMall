package com.cdut.Controller;

import com.cdut.Pojo.Goods;
import com.cdut.Pojo.ShoppingCartGoods;
import com.cdut.Pojo.User;
import com.cdut.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Controller
public class ShoppingCartController {
    @Autowired
    ShoppingCartService shoppingCartService;

    @RequestMapping("ListAllGoodsByUserId.do")
    public void cart1(){
        System.out.println(shoppingCartService.listCartByUserId("1"));
        shoppingCartService.increaseGoods("1","1");
        shoppingCartService.decreaseGoods("1","2");
    }

    @RequestMapping("insertGoodsToCart.do")
    public void cart2(){
        shoppingCartService.insertGoodstoCart("1","3",4);
        List<String> goodsId=new ArrayList<>();
        goodsId.add("1");
        goodsId.add("2");
        shoppingCartService.deleteGoodsFromCart("1",goodsId);
    }
    @RequestMapping("priceIncheckGoods.do")
    public void cart3(){
        List<String> goodsId=new ArrayList<>();
        goodsId.add("1");
        goodsId.add("2");
        System.out.println(shoppingCartService.priceIncheckGoods("1",goodsId));
        shoppingCartService.clearCart("1");
    }

    @RequestMapping("/listCart.do")
    public ModelAndView listAllShoppingCartByUserId(HttpSession session){
        ModelAndView mv=new ModelAndView();
        if( session.getAttribute("user")==null){//没登录就跳转去登陆
            mv.setViewName("login.jsp");
            return mv;
        }else {
            User user= (User) session.getAttribute("user");
            List<ShoppingCartGoods> goods=shoppingCartService.listCartByUserId(user.getUserid());
            System.out.println(goods);
            session.setAttribute("Cart", goods);
            session.setAttribute("CartGoodsNum", goods.size());
            mv.setViewName("cart.jsp");
            return mv;
        }

    }
}
