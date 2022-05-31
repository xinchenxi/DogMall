package com.cdut.Service.Impl;

import com.cdut.Dao.GoodsDao;
import com.cdut.Pojo.Goods;
import com.cdut.Service.GoodsService;
import com.cdut.Vo.Pager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Pager<Goods> findGoodsByPager(int page, int size, String pattern){
        Map<String, Object> params = new HashMap<String, Object>();
        pattern='%'+pattern+'%';
        params.put("page", page);
        params.put("size", size);
        Pager<Goods> pager = new Pager<Goods>();
        List<Goods> list = dao.selectGoodsByPager(params,pattern);
        pager.setRows(list);
        pager.setTotal(dao.countGoodsPage(pattern));
        return pager;
    }

    @Override
    public void updateGoodPicture(String goodId, String imgurl) {
        dao.updateGoodsPicture(goodId, imgurl);
    }

    /**
     * 已弃用分页查询商品使用 findGoodsByPager函数
     @Override
     public List<Goods> listGoodsPages(Integer start, Integer size, String pattern) {
     pattern='%'+pattern+'%';
     List<Goods> goods=dao.listGoodsPages(pattern);
     return goods;
     }*/
}
