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

    @Override
    public Supplier findSuppliereBySupplierId(String supplierId) {
        return dao.getSupplierBysupplierId(supplierId);
    }

    @Override
    public Supplier finSupplierByUserId(String userId) {
        return dao.getSupplierByuserId(userId);
    }

    @Override
    public void addSupplier(Supplier supplier) {
        dao.insertSupplier(supplier);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        dao.updateSupplier(supplier);
    }

    @Override
    public void deleteSupplierBysupplierId(String supplierId) {
        dao.deleteSupplierBysupplierId(supplierId);
    }


}
