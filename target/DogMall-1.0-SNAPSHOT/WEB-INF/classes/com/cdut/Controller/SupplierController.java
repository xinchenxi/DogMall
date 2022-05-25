package com.cdut.Controller;

import com.cdut.Pojo.Supplier;
import com.cdut.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    SupplierService supplierService;
    @RequestMapping("testSupplier.do")
    public ModelAndView supplier1(){
        ModelAndView mv=new ModelAndView();
        int nums=supplierService.CountSupplier();
        List<Supplier> suppliers=supplierService.ListAllSupplier();
        mv.addObject("nums",nums);
        mv.addObject("allSupplier",suppliers);
        mv.setViewName("result1.jsp");
        return mv;
    }
}
