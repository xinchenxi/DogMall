package com.cdut.Dao;
import com.cdut.Dto.OrderGoods;
import com.cdut.Pojo.Goods;

import java.util.List;
public interface OrderDao {

    public int selectCountOrderByUserId(String userId);
    public List<String> selectOrderIdByUserId(String userId);
    public List<OrderGoods> selectGoodsByOrderId(String orderId);
    public String selectDateByOrderId(String orderId);
}
