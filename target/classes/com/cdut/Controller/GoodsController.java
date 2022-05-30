package com.cdut.Controller;

import com.cdut.Pojo.Goods;
import com.cdut.Service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    //不行
    @RequestMapping("ListGoodPages.do")
    public ModelAndView goods1(){
        ModelAndView mv=new ModelAndView();
        List<Goods> goods=goodsService.listGoodsPages(1,2,"花");
        mv.addObject("返回结果",goods);
        mv.setViewName("result2.jsp");
        return mv;
    }
    @RequestMapping("getListGoodsBySupplierId.do")
    public ModelAndView goods2(){
        ModelAndView mv=new ModelAndView();
        List<Goods> goods=goodsService.getListGoodsBySupplierId("123");
        mv.addObject("goods",goods);
        mv.setViewName("result2.jsp");
        return mv;
    }
    @RequestMapping("setGoodsStatus.do")
    public void goods3(){
        goodsService.setGoodsStatus("1",2);
    }
    @RequestMapping("deleteGoodsById.do")
    public void goods4(){
        goodsService.deleteGoodsById("2");
    }
    @RequestMapping("updateGoods.do")
    public void goods5(Goods goods){
        goodsService.updateGoods(goods);
    }
    @RequestMapping("insertGoods.do")
    public void goods6(Goods goods){
        goodsService.addGoods(goods);
    }
    @RequestMapping("listGoods.do")
    public void goods7(){
        System.out.println(goodsService.getGoodsCount());
        System.out.println(goodsService.getListAllGoods());
        System.out.println(goodsService.getGoodsById("1"));
    }
    @RequestMapping("findGoodsByPager.do")
    public void goods8(){
        System.out.println(goodsService.findGoodsByPager(1,3,"花"));
    }

}
