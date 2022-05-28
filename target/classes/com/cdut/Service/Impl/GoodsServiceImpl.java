package com.cdut.Service.Impl;

import com.cdut.Dao.GoodsDao;
import com.cdut.Pojo.Goods;
import com.cdut.Service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao dao;

    public void setDao(GoodsDao dao) {
        this.dao = dao;
    }

    @Override
    public int getGoodsCount() {
        return dao.countGoods();
    }

    @Override
    public List<Goods> getListAllGoods() {
        return dao.listAllGoods();
    }

    @Override
    public List<Goods> listGoodsPages(Integer start, Integer size, String pattern) {

        List<Goods> goods=dao.listGoodsPages(pattern);
        return goods;
    }

    @Override
    public void addGoods(Goods goods) {
        dao.insertGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        dao.updateGoods(goods);
    }

    @Override
    public void deleteGoodsById(String goodsId) {
        dao.deleteGoodsById(goodsId);
    }

    @Override
    public void setGoodsStatus(String goodsId, Integer status) {
        dao.setGoodsStatus(goodsId,status);
    }

    @Override
    public List<Goods> getListGoodsBySupplierId(String supplierId) {
        return dao.getListGoodsBySupplierId(supplierId);
    }

    @Override
    public List<Goods> getGoodsById(String goodsId) {
        return dao.selectGoodsById("1");
    }
}
