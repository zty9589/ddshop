package com.zty.ddshop.common.dto;

public class Page {

    /*
    * 封装分页请求的参数类
    * */

    //当前页码
    private Integer page;
    //每页显示的条数
    private Integer rows;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return (page-1)*rows;
    }

}
