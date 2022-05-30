package com.cdut.Dao;

import com.cdut.Pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsDao {
    /**
     * 获得商品的数量
     */
    public int countGoods();
    /**
     * 列出所有的商品
     */
    public List<Goods> listAllGoods();
    /**
     * 已弃用，分页查询使用 selectGoodsByPager函数
     * 分页查询商品
     */
    //public List<Goods> listGoodsPages(String pattern);
    /**
     * 新增商品
     */
    public void insertGoods(Goods goods);
    /**
     * 更新商品信息
     */
    public void updateGoods(Goods goods);
    /**
     * 根据商品ID删除商品
     */
    public void deleteGoodsById(String goodsId);
    /**
     * 更新商品状态
     */
    public void setGoodsStatus(@Param("goodId") String goodsId,@Param("status") Integer status);
    /**
     * 列出商家商家的所有商品
     */
    public List<Goods> getListGoodsBySupplierId(String supplierId);

    public List<Goods> selectGoodsById(String goodId);

    /**
     * 分页查找商品
     * @param params
     * @return
     */
    public List<Goods> selectGoodsByPager(@Param("params") Map<String, Object> params,@Param("pattern") String pattern);

    /**
     * 获得查询的商品总数
     * @param pattern
     * @return
     */
    public int countGoodsPage(String pattern);
}
