package com.cdut.Service;

import com.cdut.Pojo.Goods;
import com.cdut.Vo.Pager;

import java.util.List;

public interface GoodsService {

    public int getGoodsCount();

    public List<Goods> getListAllGoods();

    public void addGoods(Goods goods);

    public void updateGoods(Goods goods);

    public void deleteGoodsById(String goodsId);

    public void setGoodsStatus(String goodsId, Integer status);

    public List<Goods> getListGoodsBySupplierId(String supplierId);

    public List<Goods> getGoodsById(String goodsId);

    public Pager<Goods> findGoodsByPager(int page, int size, String pattern);

    public void updateGoodPicture(String goodId,String imgurl);

    /*   弃用的分页查询 分页查询请使用 findGoodsByPager
    public List<Goods> listGoodsPages(Integer start,Integer size,String pattern);
    */
}
