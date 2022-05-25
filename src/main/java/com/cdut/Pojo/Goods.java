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
    private double sales;
    /**
     * 提供商家的id
     */
    private Integer supplier_id;
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

    public double getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(Integer supplier_id) {
        this.supplier_id = supplier_id;
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
                ", sales=" + sales +
                ", supplier_id=" + supplier_id +
                ", describe='" + describe + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", status=" + status +
                '}';
    }
}
