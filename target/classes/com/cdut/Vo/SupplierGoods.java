package com.cdut.Vo;

import com.cdut.Pojo.Goods;
import java.util.List;

public class SupplierGoods {

    private String supplier;

    private List<Goods> goods;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "SupplierGoods{" +
                "supplier='" + supplier + '\'' +
                ", goods=" + goods +
                '}';
    }
}
