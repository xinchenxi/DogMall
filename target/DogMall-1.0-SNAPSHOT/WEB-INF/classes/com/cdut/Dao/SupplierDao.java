package com.cdut.Dao;

import com.cdut.Pojo.Supplier;

import java.util.*;

/**
 * 商家DAO
 */
public interface SupplierDao {
    /**
     *  获得商家数量（有什么用呢？）
     */
    public int getCountSupplier();
    /**
     * 列出所有的商家（又有什么用呢？）
     */
    public List<Supplier>  listAllSupplier();
    /**
     *  根据商家id获得商家的信息
     */
    public Supplier getSupplierBysupplierId(Integer supplierId);
    /**
     *  根据用户id获得商家的信息
     */
    public Supplier getSupplierByuserId(Integer userId);
    /**
     *  新增一个商家
     */
    public void insertSupplier(Supplier supplier);
    /**
     *  更新商家信息
     */
    public void updateSupplier(Supplier supplier);
    /**
     *  根据商家id删除商家
     */
    public void deleteSupplierBysupplierId(Integer supplierId);

}
