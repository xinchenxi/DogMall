package com.cdut.Service.Impl;

import com.cdut.Dao.SupplierDao;
import com.cdut.Pojo.Supplier;
import com.cdut.Service.SupplierService;

import java.util.List;

public class SupplierServiceImpl  implements SupplierService {
    private SupplierDao dao;

    public void setDao(SupplierDao dao) { this.dao = dao; }


    @Override
    public int CountSupplier() {
        return dao.getCountSupplier();
    }

    @Override
    public List<Supplier> ListAllSupplier() {
        return dao.listAllSupplier();
    }
}
