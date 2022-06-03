package com.cdut.Dao;
import com.cdut.Dto.OrderGoods;
import com.cdut.Pojo.Goods;
import com.cdut.Pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    public int selectCountOrderByUserId(String userId);
    public List<String> selectOrderIdByUserId(String userId);
    public List<OrderGoods> selectGoodsByOrderId(String orderId);
    public String selectDateByOrderId(String orderId);
    public String selectUserIdByOrderId(String orderId);
    public void insertOrder(String userId,String orderId,String dateStr,OrderGoods orderGoods);
    public void deleteOrder(String order);

}
