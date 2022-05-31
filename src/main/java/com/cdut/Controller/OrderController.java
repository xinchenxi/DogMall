package com.cdut.Controller;

import com.cdut.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/selectGoodsByOrderId.do")
    public void order1(){
        System.out.println(orderService.selectGoodsByOrderId("147"));
        System.out.println("输出的oder是:"+orderService.getOrderByUserId("1"));
    }
}
