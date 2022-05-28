package com.cdut.Service;

import com.cdut.Pojo.Goods;
import java.util.List;

public interface GoodsService {

    public int getGoodsCount();

    public List<Goods> getListAllGoods();

    public List<Goods> listGoodsPages(Integer start,Integer size,String pattern);

    public void addGoods(Goods goods);

    public void updateGoods(Goods goods);

    public void deleteGoodsById(String goodsId);

    public void setGoodsStatus(String goodsId, Integer status);

    public List<Goods> getListGoodsBySupplierId(String supplierId);

    public List<Goods> getGoodsById(String goodsId);
}
