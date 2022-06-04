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
        mv.setViewName("test/result1.jsp");
        return mv;
    }

    @RequestMapping("/findSupplier.do")
    public String supplier2(){
        System.out.println(supplierService.findSuppliereBySupplierId("123"));
        System.out.println(supplierService.finSupplierByUserId("1"));
        supplierService.addSupplier(new Supplier("3","147","中国知网","北京","文化"));
        return "test/result.jsp";
    }

    @RequestMapping("updateSupplier.do")
    public void supplier3(){
        supplierService.updateSupplier(new Supplier("3","147","中国知网","北京","抄袭"));
    }
    @RequestMapping("deleteSupplier.do")
    public void supplier4(){
        supplierService.deleteSupplierBysupplierId("147");
    }
}
