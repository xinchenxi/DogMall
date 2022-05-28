package com.cdut.Pojo;

/**
 * 商家entity
 */
public class Supplier {
    /**
     * 店铺首先是一个用户 拥有用户id
     */
    private String userId;
    /**
     * 店铺id
     */
    private String supplierId;
    /**
     * 店铺名称
     */
    private String supplierName;
    /**
     * 店铺地址
     */
    private String address;
    /**
     * 店铺分类
     */
    private String category;

    public Supplier(String userId, String supplierId, String supplierName, String address, String category) {
        this.userId = userId;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.address = address;
        this.category = category;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Supplier{" +
                "userId=" + userId +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", Address='" + address + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
