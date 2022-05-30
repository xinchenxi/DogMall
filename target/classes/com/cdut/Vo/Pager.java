package com.cdut.Vo;

import com.cdut.Pojo.Goods;

import java.util.List;
/**
 * 分页查询
 */
public class Pager<T> {
    //分页起始页
    private int page;
    //每页记录数
    private int size;
    //返回的记录集合
    private List<T> rows;
    //总记录条数
    private long total;


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "page=" + page +
                ", size=" + size +
                ", rows=" + rows +
                ", total=" + total +
                '}';
    }
}
