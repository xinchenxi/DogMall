package com.cdut.Service;

import com.cdut.Pojo.Supplier;
import java.util.List;

public interface SupplierService {

    public int CountSupplier();

    public List<Supplier> ListAllSupplier();

    public Supplier  findSuppliereBySupplierId(String supplierId);

    public  Supplier finSupplierByUserId(String userId);

    public void addSupplier(Supplier supplier);

    public  void updateSupplier(Supplier supplier);

    public void deleteSupplierBysupplierId(String supplierId);
}
