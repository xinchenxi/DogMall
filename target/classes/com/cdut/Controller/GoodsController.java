package com.cdut.Controller;

import com.cdut.Pojo.Goods;
import com.cdut.Service.GoodsService;
import com.cdut.Util.MinioUtil;
import com.cdut.Vo.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    /**
     * 文件上传的工具
     */
    @Autowired
    private MinioUtil minioUtil;

    @RequestMapping("ListGoodPages.do")
    public ModelAndView goods1() {
        ModelAndView mv = new ModelAndView();
        Pager<Goods> goods = goodsService.findGoodsByPager(1, 2, "花");
        mv.addObject("返回结果", goods);
        mv.setViewName("result2.jsp");
        return mv;
    }

    @RequestMapping("getListGoodsBySupplierId.do")
    public ModelAndView goods2() {
        ModelAndView mv = new ModelAndView();
        List<Goods> goods = goodsService.getListGoodsBySupplierId("123");
        mv.addObject("goods", goods);
        mv.setViewName("result2.jsp");
        return mv;
    }

    @RequestMapping("setGoodsStatus.do")
    public void goods3() {
        goodsService.setGoodsStatus("1", 2);
    }

    @RequestMapping("deleteGoodsById.do")
    public void goods4() {
        goodsService.deleteGoodsById("2");
    }

    @RequestMapping("updateGoods.do")
    public void goods5(Goods goods) {
        goodsService.updateGoods(goods);
    }

    @RequestMapping("insertGoods.do")
    public void goods6(Goods goods) {
        goodsService.addGoods(goods);
    }

    @RequestMapping("listGoods.do")
    public void goods7() {
        System.out.println(goodsService.getGoodsCount());
        System.out.println(goodsService.getListAllGoods());
        System.out.println(goodsService.getGoodsById("1"));
    }

    @RequestMapping("findGoodsByPager.do")
    public void goods8() {
        System.out.println(goodsService.findGoodsByPager(1, 3, "花"));
    }

    @RequestMapping("/updatePicture.do")
    public ModelAndView goods9(@RequestParam(name = "file", required = false) MultipartFile file,
                               @RequestParam("goodId") String goodId) {
        HashMap<String, String> res = null;
        ModelAndView mv = new ModelAndView();
        try {
            //将minio的返回结果放到res中
            res = minioUtil.uploadgoodsPicture(goodId, file, "mall");
            System.out.println((String)res.get("goods_picture"));
            goodsService.updateGoodPicture(goodId,(String)res.get("goods_picture"));
            //再把res的结果放回到 ModelandView中
            Iterator iter = res.entrySet().iterator();
            while (iter.hasNext()) {
                HashMap.Entry entry = (HashMap.Entry) iter.next();
                mv.addObject((String) entry.getKey(), (String) entry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.put("code", "0");
            res.put("msg", "上传失败");
        }
        mv.setViewName("result2.jsp");
        return mv;
    }

}
