package com.cdut.Pojo;

/**
 * 商品
 */
public class Goods {
    /**
     * 商品id
     */
    private String goodId;
    /**
     *名称
     */
    private String goodName;
    /**
     *库存
     */
    private Integer nums;
    /**
     *价格
     */
    private double price;
    /**
     * 提供商家的id
     */
    private String supplierId;
    /**
     * 商品描述
     */
    private String describe;
    /**
     * 商品图片
     */
    private String imgurl;
    /**
     * 商品状态
     */
    private Integer status;

    public Goods() {
    }

    public Goods(String goodId, String goodName, Integer nums, double price, String supplierId, String describe, String imgurl, Integer status) {
        this.goodId = goodId;
        this.goodName = goodName;
        this.nums = nums;
        this.price = price;
        this.supplierId = supplierId;
        this.describe = describe;
        this.imgurl = imgurl;
        this.status = status;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodId=" + goodId +
                ", goodName='" + goodName + '\'' +
                ", nums=" + nums +
                ", price=" + price +
                ", supplierId=" + supplierId +
                ", describe='" + describe + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", status=" + status +
                '}';
    }
}
