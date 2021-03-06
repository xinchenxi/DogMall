package com.cdut.Controller;

import com.cdut.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
