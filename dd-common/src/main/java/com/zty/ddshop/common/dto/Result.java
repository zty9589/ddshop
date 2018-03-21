package com.zty.ddshop.common.dto;

import java.util.List;

public class Result<T> {
    /*
    * 封装了分页请求的结果的类
    * */

    //总记录数
    private int total;
    //每页记录数封装成的集合
    private List<T> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
