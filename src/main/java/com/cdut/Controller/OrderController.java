package com.cdut.Controller;

import com.cdut.Dto.OrderGoods;
import com.cdut.Pojo.Goods;
import com.cdut.Pojo.Order;
import com.cdut.Pojo.User;
import com.cdut.Service.OrderService;
import com.cdut.Vo.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/selectGoodsByUserId.do")
    public ModelAndView ListAllOrderByUserId(HttpSession session ) {
        ModelAndView mv = new ModelAndView();
        User user = (User) session.getAttribute("user");
        if ((orderService.getCountOrderByUserId(user.getUserid()) != 0)) {
            UserOrder userOrder = orderService.getOrderByUserId(user.getUserid());
            session.setAttribute("orders", userOrder.getOrders());
            List<Order> orders = userOrder.getOrders();
        }else{
            session.setAttribute("msg","0");
        }
            mv.setViewName("user_center_order.jsp");
            return mv;

    }

    @RequestMapping("/getOrderByOrderId.do")
    public void order2(String orderId){
        System.out.println(orderService.getOrderByOrderId(orderId));
    }
    @RequestMapping("/insertOrderGoods.do")
    public void order3(List<String> goodsId,String userId){

    }

}
